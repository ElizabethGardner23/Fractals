package edu.cornellcollege.fractals;

/**
 * The Complex class contains methods to model a complex number and to perform
 * operations including addition, multiplication, and magnitudeSquared on
 * complex numbers.
 * 
 * @author Elizabeth Gardner
 * @version 14 April 2020
 */
public class Complex {
    
    private double real;
    private double imaginary;
    
    /**
     * The Complex() constructor creates a new complex number with no designated
     * real and imaginary values. Code found here:
     * https://www.geeksforgeeks.org/program-to-add-and-subtract-complex-numbers-using-class-in-java/.
     */
    public Complex() {
    } // Complex()
    
    /**
     * The Complex(double, double) constructor creates a new complex number with
     * a designated value for the real and imaginary elements. Code found here:
     * https://www.geeksforgeeks.org/program-to-add-and-subtract-complex-numbers-using-class-in-java/.
     * 
     * @param tempReal the double value of the real part of the complex number
     * @param tempImaginary the double value of the imaginary part of the
     * complex number
     */
    public Complex(double tempReal, double tempImaginary) {
        real = tempReal;
        imaginary = tempImaginary;
    } // Complex(double, double)
    
    /**
     * The getReal accessor method returns the real element of a complex number.
     * 
     * @return the double real element of a complex number
     */
    public double getReal() {
        return this.real;
    } // getReal()
    
    /**
     * The getImaginary accessor method returns the imaginary element of a
     * complex number.
     * 
     * @return the double imaginary element of a complex number
     */
    public double getImaginary() {
        return this.imaginary;
    } // getImaginary()
    
    /**
     * The setReal mutator method changes the real element of a complex number
     * to a designated value.
     * 
     * @param value the new double value of the real element of a complex number
     */
    public void setReal(double value) {
        this.real = value;
    } // setReal(double)
    
    /**
     * The setImaginary mutator method changes the imaginary element of a
     * complex number to a designated value.
     * 
     * @param value the new double value of the imaginary element of a complex
     * number
     */
    public void setImaginary(double value) {
        this.imaginary = value;
    } // setImaginary()
    
    /**
     * The addComplex method calculates the sum of two complex numbers by
     * separately adding their real and imaginary elements. Based on code found
     * here:
     * https://www.geeksforgeeks.org/program-to-add-and-subtract-complex-numbers-using-class-in-java/.
     * 
     * @param otherComplex the complex number being added
     * @return a complex number that is the sum of two complex numbers
     */
    public Complex addComplex(Complex otherComplex) {
        Complex sum = new Complex();
        sum.real = this.real + otherComplex.real;
        sum.imaginary = this.imaginary + otherComplex.imaginary;
        return sum;
    } // addComplex(Complex)
    
    /**
     * The subtractComplex method calculates the difference of two complex
     * numbers by separately subtracting their real and imaginary elements.
     * Based on code found here:
     * https://www.geeksforgeeks.org/program-to-add-and-subtract-complex-numbers-using-class-in-java/.
     * 
     * @param otherComplex the complex number being subtracted
     * @return a complex number that is the difference between two complex
     * numbers
     */
    public Complex subtractComplex(Complex otherComplex) {
        Complex difference = new Complex();
        difference.real = this.real - otherComplex.real;
        difference.imaginary = this.imaginary - otherComplex.imaginary;
        return difference;
    } // subtractComplex(Complex)
    
    /**
     * The multiplyComplex method calculates the product of two complex numbers.
     * 
     * @param otherComplex the complex number being multiplied
     * @return a complex number that is the product of two complex numbers
     */
    public Complex multiplyComplex(Complex otherComplex) {
        Complex product = new Complex();
        double a = this.real;
        double b = this.imaginary;
        double c = otherComplex.real;
        double d = otherComplex.imaginary;
        product.real = (a * c) - (b * d);
        product.imaginary = (a * d) + (b * c);
        return product;
    } // multiplyComplex(Complex)
    
    /**
     * The magnitude method uses a distance formula to calculate the magnitude
     * of a complex number
     * 
     * @return the double magnitude of a complex number
     */
    public double magnitude() {
        double xSquared = Math.pow(this.real, 2);
        double ySquared = Math.pow(this.imaginary, 2);
        return Math.sqrt(xSquared + ySquared);
    } // magnitude()
    
    /**
     * The magnitudeSquared method returns the square of the magnitude of a
     * complex number.
     * 
     * @return the magnitude of a complex number squared
     */
    public double magnitudeSquared() {
        
//        double realSquared = this.real * this.real;
//        double imaginarySquared = this.imaginary * this.imaginary;
//        return realSquared + imaginarySquared;

        return Math.pow(this.magnitude(), 2);
    } // magnitudeSquared()
    
    /**
     * The toString method produces a String representation of a complex number
     * by separating the real and imaginary element by a plus sign and putting
     * an "i" after the imaginary value.
     * 
     * @return a String representation of a complex number
     */
    @Override
    public String toString() {
        return this.real + " + " + this.imaginary + "i";
    } // toString()
    
    /**
     * The main method tests the other methods in the Complex class.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Complex c1 = new Complex(1, 2);
        System.out.println("Complex 1 = " + c1);
        Complex c2 = new Complex(3, 4);
        System.out.println("Complex 1 real = " + c1.getReal());
        System.out.println("Complex 1 imaginary = " + c1.getImaginary());
        Complex c3 = new Complex();
        c3.setReal(18);
        c3.setImaginary(24);
        System.out.println("Complex 3 = " + c3);
        System.out.println("Complex 2 = " + c2);
        System.out.println("Complex 1 + Complex 2 = " + c1.addComplex(c2));
        System.out.println("Complex 1 - Complex 2 = " + c1.subtractComplex(c2));
        System.out.println("Complex 1 * Complex 2 = " + c1.multiplyComplex(c2));
        System.out.println("Magnitude of Complex 2 = " + c2.magnitude());
        System.out.println("Squared magnitude of Complex 2 = " + c2.magnitudeSquared());
    } // main(String[])
} // Complex