import java.util.function.Function;

public class Main {
    public OutputQuadratic calculateQuadraticEquation(InputQuadratic input ,OutputQuadratic output){

        double firstOutput =((-1*input.getSecondParameter())+(Math.sqrt((Math.pow(input.getSecondParameter(),2)-(4*input.getFirstParameter()*input.getThirdParameter())))))/(2*input.getFirstParameter());
        output.setFirstOutput(firstOutput);


    }
    public static void main(String[] args) {
        InputQuadratic inputObject = new InputQuadratic(2,6,7);
        OutputQuadratic outputObject = new OutputQuadratic();


    }
}
