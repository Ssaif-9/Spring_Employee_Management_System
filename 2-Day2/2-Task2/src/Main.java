    import java.util.function.Function;

    public class Main {

        private static OutputQuadratic calculateQuadraticEquation(InputQuadratic input ){
            OutputQuadratic output = new OutputQuadratic();
            double  firstOutput;
            double firstUnderRoot =(Math.pow(input.getSecondParameter(),2)-(4*input.getFirstParameter()*input.getThirdParameter()));

            if(firstUnderRoot >= 0) {
                double firstRoot = Math.sqrt(firstUnderRoot);
                firstOutput = ((-1 * input.getSecondParameter()) + firstRoot) / (2 * input.getFirstParameter());
                Complex firstComplexOutput = new Complex(firstOutput);
                output.setFirstComplexOutput(firstComplexOutput);
            }
            else {
                firstUnderRoot*=-1;
                double firstRoot = Math.sqrt(firstUnderRoot);
                double firstRealPart = (-1 * input.getSecondParameter())/(2 * input.getFirstParameter());
                double firstImagpart = firstRoot/(2 * input.getFirstParameter());
                Complex firstComplexOutput = new Complex(firstRealPart, firstImagpart);
                output.setFirstComplexOutput(firstComplexOutput);

            }


            double secondOutput;
            double secondUnderRoot =(Math.pow(input.getSecondParameter(),2)-(4*input.getFirstParameter()*input.getThirdParameter()));

            if(secondUnderRoot >= 0) {
                double secondRoot = Math.sqrt(secondUnderRoot);
                secondOutput = ((-1 * input.getSecondParameter()) - secondRoot) / (2 * input.getFirstParameter());
                Complex secondComplexOutput = new Complex(secondOutput);
                output.setSecondComplexOutput(secondComplexOutput);

            }
            else {
                secondUnderRoot *=-1;
                double SecondRoot = Math.sqrt(secondUnderRoot);
                double SecondRealPart = (-1 * input.getSecondParameter())/(2 * input.getFirstParameter());
                double SecondImagpart = (-1*SecondRoot)/(2 * input.getFirstParameter());
                Complex SecondComplexResult = new Complex(SecondRealPart, SecondImagpart);
                output.setSecondComplexOutput(SecondComplexResult);

            }
return output;
        }
        public static void main(String[] args) {
            InputQuadratic inputObject = new InputQuadratic(1,.3,28);
            OutputQuadratic outputObject;

            Function<InputQuadratic,OutputQuadratic> calc= Main::calculateQuadraticEquation;      //calc=  (input) -> {  return calculateQuadraticEquation(input);};

            outputObject= calc.apply(inputObject);
            inputObject.inputEquation();
            outputObject.printComplexOutput();
        }
    }
