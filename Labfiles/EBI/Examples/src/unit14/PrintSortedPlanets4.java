package unit14;

import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PrintSortedPlanets4 {
    private static Set<Planet> planets;

    public void populatePlanets() {
        planets = new TreeSet<>(new Comparator<Planet>() {
            public int compare(Planet a, Planet b) {
                if (a.getDiameter() < b.getDiameter())
                    return -1;
                else if (a.getDiameter() > b.getDiameter())
                    return 1;
                else
                    return a.getName().compareTo(b.getName());
            }
        });
        
        Parser p = new Parser();
        p.parsePlanets();
    }

    static class Parser {
        public void parsePlanets() {
            try {
                DocumentBuilderFactory f = DocumentBuilderFactory
                        .newInstance();
                DocumentBuilder b = f.newDocumentBuilder();
                Document document = b.parse("planets.xml");
                NodeList planetNodes = document
                        .getElementsByTagName("planet");

                for (int i = 0; i < planetNodes.getLength(); i++) {
                    Node planet = planetNodes.item(i);
                    NodeList planetChildren = planet.getChildNodes();

                    String name = "";
                    long orbit = 0;
                    int diameter = 0;
                    for (int j = 0; j < planetChildren.getLength(); j++) {
                        Node node = planetChildren.item(j);
                        if (node.getNodeName().equals("name")) {
                            name = node.getFirstChild().getNodeValue();
                        }
                        else if (node.getNodeName().equals("orbit")) {
                            orbit = Long.parseLong(node.getFirstChild()
                                    .getNodeValue());
                        }
                        else if (node.getNodeName().equals("diameter")) {
                            diameter = Integer.parseInt(node
                                    .getFirstChild().getNodeValue());
                        }
                    }
                    planets.add(new Planet(name, orbit, diameter));
                }
            }
            catch (ParserConfigurationException | SAXException
                    | IOException e) {
                System.err.println(e);
            }
        }
    }

    public void printPlanets() {
        for (Planet planet : planets) {
            System.out.println(planet);
        }
    }

    public static void main(String[] args) {
        PrintSortedPlanets4 p = new PrintSortedPlanets4();
        p.populatePlanets();
        p.printPlanets();
    }
}
