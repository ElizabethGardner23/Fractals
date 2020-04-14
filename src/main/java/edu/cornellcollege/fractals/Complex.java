package edu.cornellcollege.fractals;

/**
 * The Complex class contains methods to model a complex number and to perform
 * operations including addition, multiplication, and magnitude on complex
 * numbers.
 * 
 * @author Elizabeth Gardner
 * @version 13 April 2020
 */
public class Complex {
    
    public double real;
    public double imaginary;
    
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
    } // Complex()
    
    /**
     * The addComplex method returns the sum of two complex numbers by separately
     * adding their real and imaginary elements. Based on code found here:
     * https://www.geeksforgeeks.org/program-to-add-and-subtract-complex-numbers-using-class-in-java/.
     * 
     * @param otherComplex the complex number being added
     * @return a complex number that is the sum of two complex numbers
     */
    public Complex addComplex(Complex otherComplex) {
        Complex sum = new Complex();
        sum.real = this.real + otherComplex.real;
        sum.imaginary = this.imaginary + otherComplex.real;
        return sum;
    } // addComplex(Complex)
    
    /**
     * The multiplyComplex method calculates and returns the product of two
     * complex numbers.
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
        System.out.println("Complex 2 = " + c2);
        System.out.println("Complex 1 + Complex 2 = " + c1.addComplex(c2));
        System.out.println("Complex 1 * Complex 2 = " + c1.multiplyComplex(c2));
        System.out.println("Magnitude of Complex 2 = " + c2.magnitude());
    } // main(String[])
} // Complex