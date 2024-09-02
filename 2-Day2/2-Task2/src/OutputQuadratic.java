public class OutputQuadratic {

    private Complex firstComplexOutput;
    private Complex secondComplexOutput;

    public Complex getFirstComplexOutput() {
        return firstComplexOutput;
    }

    public void setFirstComplexOutput(Complex firstComplexOutput) {
        this.firstComplexOutput = firstComplexOutput;
    }

    public Complex getSecondComplexOutput() {
        return secondComplexOutput;
    }

    public void setSecondComplexOutput(Complex secondComplexOutput) {
        this.secondComplexOutput = secondComplexOutput;
    }

    public OutputQuadratic() {}

    public void printComplexOutput(){
        System.out.print("X1 = ");
        Complex.printComplex(getFirstComplexOutput());
        System.out.println();
        System.out.print("X2 = ");
        Complex.printComplex(getSecondComplexOutput());
    }
}
