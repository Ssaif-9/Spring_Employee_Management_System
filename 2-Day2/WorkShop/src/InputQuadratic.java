public class InputQuadratic {
    private double firstParameter;
    private double secondParameter;
    private double thirdParameter;

    public InputQuadratic(){}

    public InputQuadratic(int firstParameter, int secondParameter, int thirdParameter){
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
        this.thirdParameter = thirdParameter;
    }

    public double getFirstParameter() {
        return firstParameter;
    }

    public void setFirstParameter(int firstParameter) {
        this.firstParameter = firstParameter;
    }

    public double getSecondParameter() {
        return secondParameter;
    }

    public void setSecondParameter(int secondParameter) {
        this.secondParameter = secondParameter;
    }

    public double getThirdParameter() {
        return thirdParameter;
    }

    public void setThirdParameter(int thirdParameter) {
        this.thirdParameter = thirdParameter;
    }

    public void inputEquation( ) {
        System.out.printf("Our Quadratic Equation : %fX^2 + %fX + %f = 0 ",getFirstParameter(), getSecondParameter(),getThirdParameter());
    }






}