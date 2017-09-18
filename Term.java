/*
 * Term.java
 * CS230 PSet 6, Task 3
 * Emily Van Laarhoven and Andrea Leon
 */

//import javafoundations.*;

public class Term {
  
  //instance vars
  private int coefficient;
  private int exponent;
 
  //constructor
  public Term(int coefficient, int exponent) {
    this.coefficient=coefficient;
    this.exponent=exponent;
  }
  
  //toString() method
  public String toString() {
    return coefficient+"x^"+exponent;
  }
  
  //setters and getters
  public void setExponent(int exp) {
    this.exponent=exp;
  }
  
  public void setCoefficient(int coeff) {
    this.coefficient=coeff;
  }
  
  public int getExponent() {
    return exponent;
  }
  
  public int getCoefficient() {
    return coefficient;
  }
  
  public static void main (String[] args) {
   Term test1 = new Term(3,4);
   System.out.println(test1);
   
  }
  }