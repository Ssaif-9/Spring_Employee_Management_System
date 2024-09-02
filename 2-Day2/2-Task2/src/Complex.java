public class Complex {
    private double real;
    private double imag;

    public Complex() {}

    public Complex(double real) {
        this.real = real;
    }
    public Complex(int x ,double imag) {
        this.imag =imag;
    }
    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }
    public double getReal() {
        return real;
    }
    public double getImag() {
        return imag;
    }
    public void setReal(double real) {
        this.real = real;
    }
    public void setImag(double imag) {
        this.imag = imag;
    }

    public Complex add(Complex c1,Complex c2){
        return new Complex(real+c1.getReal(),imag+c2.getImag());
    }
    public Complex sub(Complex c1,Complex c2){
        return new Complex(real-c1.getReal(),imag-c2.getImag());
    }

    public static void printComplex (Complex complex){
        if(complex.getImag()>0&&complex.getReal()>0)
          System.out.printf("%f+%fi",complex.getReal(),complex.getImag());
        else if (complex.getImag()<0 && complex.getReal()<0)
            System.out.printf("%f%fi",complex.getReal(),complex.getImag());
        if(complex.getImag()<0&&complex.getReal()>0)
            System.out.printf("%f%fi",complex.getReal(),complex.getImag());
        if(complex.getImag()>0&&complex.getReal()<0)
            System.out.printf("%f+%fi",complex.getReal(),complex.getImag());
        else if (complex.getImag()==0&&complex.getReal()>0)
            System.out.printf("%f",complex.getReal());
        else if (complex.getImag()==0&&complex.getReal()<0)
            System.out.printf("%f",complex.getReal());
        else if (complex.getReal()==0&&complex.getImag()>0)
            System.out.printf("%f",complex.getImag());
        else if (complex.getReal()==0&&complex.getImag()<0)
            System.out.printf("%f",complex.getReal());

        }
    }
