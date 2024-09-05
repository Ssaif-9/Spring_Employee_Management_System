import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    private static void findHighestPopulatedCityOfEachCountry(List<Country> countries) {
        countries.forEach(country -> {
            City highestPopulatedCity = country.getCities()
                    .stream()
                    .max(Comparator.comparingInt(City::getPopulation))
                    .orElse(null);

            if (highestPopulatedCity != null) {
                System.out.println("Highest populated city in " + country.getCode() + " is " + highestPopulatedCity.getName() + " with a population of " + highestPopulatedCity.getPopulation());
            }
        });
    }
    
    public static void main(String[] args) {
        List<City> franceCity = new ArrayList<City>();
        franceCity.add(new City(1,"paris",1256332,"223"));
        franceCity.add(new City(2,"Marsillia",125632,"2523"));

        List<City> usaCity = new ArrayList<City>();
        usaCity.add(new City(1,"New York",789321654,"29923"));
        usaCity.add(new City(2,"Washonton",654213123,"28523"));

        List<City> egyptCity = new ArrayList<City>();
        usaCity.add(new City(1,"Cairo",1478523,"002"));
        usaCity.add(new City(2,"Alex",963258,"003"));

        List<Country> countries = new ArrayList<Country>();
        countries.add(new Country("02","Egypt","Aftica",1000000.0,11000000,153.3,5,egyptCity));
        countries.add(new Country("023","USA","America",37822780.5,33000000,188.3,1,usaCity));
        countries.add(new Country("077","Farance","Eurobe",831000.0,8056000,83.3,4,franceCity));

      findHighestPopulatedCityOfEachCountry(countries);



    }


}