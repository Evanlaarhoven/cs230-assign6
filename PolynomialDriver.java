/*
 * PolynomialDriver.java
 * CS230 PSet 6, Task 3
 * Emily Van Laarhoven and Andrea Leon
 */

import java.util.*;


public class PolynomialDriver {

  public static Polynomial getInput() {
    Polynomial poly = new Polynomial();
    Scanner scan = new Scanner(System.in).useDelimiter("\\s* + \\s*");
    String [] terms = scan.nextLine().split("\\+");
    scan.close();
    for (int i=0;i<terms.length; i++) {
    Term t = new Term(Integer.parseInt(terms[i].split("x")[0]),Integer.parseInt(terms[i].split("x")[1]));
    poly.addTerm(t);
    }
    return poly;
  }
    
    
  public static void main (String[] args) {
    System.out.println("Enter first polynomial in the following format: 4x3+2x2+1x1");
    Polynomial p1 = getInput();
    System.out.println(p1);
    System.out.println("Enter second polynomial in the following format: 4x3+2x2+1x1");
    Polynomial p2 = getInput();
    System.out.println(p2);
    System.out.println("The result of the addition is:");
    Polynomial sum = p1.addPolynomial(p2);
    System.out.println(sum);

    
  }
  
}
  
