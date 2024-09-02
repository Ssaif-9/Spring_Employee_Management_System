    import java.util.function.Function;

    public class Main {

        public void calculateQuadraticEquation(InputQuadratic input ,OutputQuadratic output){
            double  firstOutput;
            double firstUnderRoot =(Math.pow(input.getSecondParameter(),2)-(4*input.getFirstParameter()*input.getThirdParameter()));

            if(firstUnderRoot >= 0) {
                double firstRoot = Math.sqrt(firstUnderRoot);
                firstOutput = ((-1 * input.getSecondParameter()) + firstRoot) / (2 * input.getFirstParameter());
                output.setFirstOutput(firstOutput);
            }
            else {
                firstUnderRoot*=-1;
                double firstRoot = Math.sqrt(firstUnderRoot);
                double firstRealPart = (-1 * input.getSecondParameter())/(2 * input.getFirstParameter());
                double firstImagpart = firstRoot/(2 * input.getFirstParameter());
                Complex firstComplexResult = new Complex(firstRealPart, firstImagpart);

                //output.setFirstOutput(firstOutput);

            }


            double secondOutput;
            double secondUnderRoot =(Math.pow(input.getSecondParameter(),2)-(4*input.getFirstParameter()*input.getThirdParameter()));

            if(secondUnderRoot >= 0) {
                double secondRoot = Math.sqrt(secondUnderRoot);
                secondOutput = ((-1 * input.getSecondParameter()) - secondRoot) / (2 * input.getFirstParameter());
                output.setSecondOutput(secondOutput);

            }
            else {
                secondUnderRoot *=-1;
                double SecondRoot = Math.sqrt(secondUnderRoot);
                double SecondRealPart = (-1 * input.getSecondParameter())/(2 * input.getFirstParameter());
                double SecondImagpart = (-1*SecondRoot)/(2 * input.getFirstParameter());
                Complex SecondComplexResult = new Complex(SecondRealPart, SecondImagpart);

            }

        }
        public static void main(String[] args) {
            Main main = new Main();
            InputQuadratic inputObject = new InputQuadratic(1,8,16);
            OutputQuadratic outputObject = new OutputQuadratic();

            Function<InputQuadratic, OutputQuadratic> Calc= (InputQuadratic) -> { main.calculateQuadraticEquation(inputObject,outputObject); return null; };      //why Calc= (InputQuadratic)

            Calc.apply(inputObject);
            inputObject.inputEquation();
            outputObject.printOutput();

        }
    }
