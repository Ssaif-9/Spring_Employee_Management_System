public class InputQuadratic {
    private double firstParameter;
    private double secondParameter;
    private double thirdParameter;

    public InputQuadratic(){}

    public InputQuadratic(double firstParameter, double secondParameter, double thirdParameter){
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
        this.thirdParameter = thirdParameter;
    }

    public double getFirstParameter() {
        return firstParameter;
    }

    public void setFirstParameter(double firstParameter) {
        this.firstParameter = firstParameter;
    }

    public double getSecondParameter() {
        return secondParameter;
    }

    public void setSecondParameter(double secondParameter) {
        this.secondParameter = secondParameter;
    }

    public double getThirdParameter() {
        return thirdParameter;
    }

    public void setThirdParameter(double thirdParameter) {
        this.thirdParameter = thirdParameter;
    }

    public void inputEquation( ) {
        System.out.printf("Our Quadratic Equation : %fX^2 + %fX + %f = 0 \n",getFirstParameter(), getSecondParameter(),getThirdParameter());
    }

}
