public class OutputQuadratic {
    private double firstOutput;
    private double secondOutput;

    public double getFirstOutput() {
        return firstOutput;
    }

    public void setFirstOutput(double firstOutput) {
        this.firstOutput = firstOutput;
    }

    public void setSecondOutput(double secondOutput) {
        this.secondOutput = secondOutput;
    }

    public double getSecondOutput() {
        return secondOutput;
    }


    public OutputQuadratic() {}

    public void printOutput(){
        System.out.printf("X1= %f \n" , getFirstOutput());
        System.out.printf("X2= %f \n" , getSecondOutput());
    }
}
