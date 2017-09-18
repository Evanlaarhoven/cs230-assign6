/*
 * Polynomial.java
 * CS230 PSet 6, Task 3
 * Emily Van Laarhoven and Andrea Leon
 */

import javafoundations.*;

public class Polynomial {
  
  //instance vars
  LinkedQueue<Term> polyQ;
  
  //constructor sets up the LinkedQueue
  public Polynomial() {
    polyQ = new LinkedQueue<Term>();
  }
  
  //toString() method
  public String toString() {
    String s="";
    for (int i=0; i<polyQ.size(); i++) {
      Term temp = polyQ.dequeue();
      s+= temp+"+"; //note: this displays an additional plus sign at the end of the polynomial
      polyQ.enqueue(temp);
    }
    return s;
  }
  
  //queue getter
  public LinkedQueue<Term> getQueue(){
    return polyQ;
  }  
  
  public void addTerm(Term t){
    LinkedQueue<Term> result = new LinkedQueue<Term>();
    if (polyQ.isEmpty()) { // sets up the queue if it is empty (for the first term in polynomial)
      polyQ.enqueue(t);
    } else { //goes into else if the queue for the polynomial already has terms 
      Term current = polyQ.first(); // current is term at front of queue used to compare against the parameter term for 
      //the folowing cases
      while(current.getExponent()>t.getExponent() && !polyQ.isEmpty()) { // while loop entered when parameter term's
        //exponent is less than current
        result.enqueue(polyQ.dequeue());        
        if (!polyQ.isEmpty()){
          current = polyQ.first();
        }else {
          result.enqueue(t);
        }
      }
      if (current.getExponent()==t.getExponent()) {// goes into if statement if current's exponent is same as parameter's
        Term temp = new Term(t.getCoefficient()+polyQ.dequeue().getCoefficient(),t.getExponent());
        result.enqueue(temp);
        if (!polyQ.isEmpty()){
          current = polyQ.first();
        }
        final int sizePolyQ = polyQ.size();
        for (int i=0; i<sizePolyQ; i++) {
          result.enqueue(polyQ.dequeue());
        }
      }  else if (t.getExponent()>current.getExponent()){ //if terms exponent is greate rthan current's
        result.enqueue(t);
        final int sizePolyQ = polyQ.size();
        for (int i=0; i<sizePolyQ; i++) {
          result.enqueue(polyQ.dequeue());
        }
      }
      polyQ=result;
    }
  }
  
  public Polynomial addPolynomial(Polynomial p){
    final int size = this.getQueue().size();
    for(int i = 0; i < size; i++){
      p.addTerm(this.getQueue().dequeue());
    }
    return p;
  }
  
  public static void main(String[] args){
    //p1 is adding terms in descending order
    Polynomial p1 = new Polynomial();
    Term t1 = new Term(3,4);
    p1.addTerm(t1);
    Term t2 = new Term(2,2);
    p1.addTerm(t2); 
    Term t3 = new Term(3,1);
    p1.addTerm(t3);
    Term t8 = new Term(2,4);
    p1.addTerm(t8);    
    //can we add term greater than preceding terms?
    Polynomial p2 = new Polynomial();
    Term t4 = new Term(4,4);
    Term t5 = new Term(1,3);
    Term t6 = new Term(1,1);
    Term t7 = new Term(4,7);
    p2.addTerm(t4);
    p2.addTerm(t5);
    p2.addTerm(t6);
    p2.addTerm(t7);
    System.out.println("p1 ="+p1);
    System.out.println("p2 ="+p2);
    System.out.println("p1 + p2 =");
    p1.addPolynomial(p2);
    System.out.println(p2);
  } 
}


