    import java.util.function.Function;

    public class Main {
        public void calculateQuadraticEquation(InputQuadratic input ,OutputQuadratic output){

            double firstOutput =((-1*input.getSecondParameter())+(Math.sqrt((Math.pow(input.getSecondParameter(),2)-(4*input.getFirstParameter()*input.getThirdParameter())))))/(2*input.getFirstParameter());
            output.setFirstOutput(firstOutput);
            double secondOutput =((-1*input.getSecondParameter())-(Math.sqrt((Math.pow(input.getSecondParameter(),2)-(4*input.getFirstParameter()*input.getThirdParameter())))))/(2*input.getFirstParameter());
            output.setSecondOutput(secondOutput);
        }
        public static void main(String[] args) {
            Main main = new Main();
            InputQuadratic inputObject = new InputQuadratic(1,-10,25);
            OutputQuadratic outputObject = new OutputQuadratic();

            Function<InputQuadratic, OutputQuadratic> Calc= (InputQuadratic) -> { main.calculateQuadraticEquation(inputObject,outputObject); return null;

            };

            Calc.apply(inputObject);
            inputObject.inputEquation();
            outputObject.printOutput();

        }
    }
