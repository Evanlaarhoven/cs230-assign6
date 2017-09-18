//********************************************************************
//  LinkedQueue.java       Java Foundations
//
//  Represents a linked implementation of a queue.
//********************************************************************

package javafoundations;

import javafoundations.exceptions.*;

public class LinkedQueue<T> implements Queue<T> {
 private int count;
 private LinearNode<T> front, rear;

 //-----------------------------------------------------------------
 //  Creates an empty queue.
 //-----------------------------------------------------------------
 public LinkedQueue() {
  count = 0;
  front = rear = null;
 }

 //-----------------------------------------------------------------
 //  Adds the specified element to the rear of this queue.
 //-----------------------------------------------------------------
 public void enqueue (T el) {
   //create a LinearNote out of the input element
  LinearNode<T> node = new LinearNode<T>(el);

  if (count == 0)
   front = node;
  else
   rear.setNext(node);

  rear = node;
  count++;
 }

 //-----------------------------------------------------------------
 //  The following methods are left as Programming Projects.
 //-----------------------------------------------------------------
 public T dequeue () throws EmptyCollectionException {
   if (count!=0) {
     LinearNode<T> temp = front;
     front = front.getNext();
     count--;
     return temp.getElement();
   }else{
     throw new EmptyCollectionException("The queue is empty");
   }  
 }
 
 public T first () throws EmptyCollectionException {
   if (count!=0) {
     return front.getElement();
   } else {
     throw new EmptyCollectionException("The queue is empty");
   }
 }
 
 
 public boolean isEmpty() {
   return (count==0);
 }
 
 public int size() {
  return count;
 }
 
 public String toString() {
   String s="";
   LinearNode<T> current = front;
   for (int i=0; i<count; i++) { //could also use while(current != null)
     s+=current.getElement()+"\n";
     current = current.getNext();
   }
   return s;
 }
 
 public static void main(String[] args) {
   //testing
   LinkedQueue<String> testQ = new LinkedQueue<String>();
   testQ.enqueue("a");
   testQ.enqueue("b");
   testQ.enqueue("c");
   System.out.println(testQ.toString());
   System.out.println(testQ.size());
   System.out.println(testQ.isEmpty());
   testQ.dequeue();
   testQ.dequeue();
   System.out.println(testQ.toString());
   System.out.println(testQ.size());
   System.out.println(testQ.isEmpty());
   testQ.dequeue();
   System.out.println(testQ.toString());
   System.out.println(testQ.size());
   System.out.println(testQ.isEmpty());
 }
 
}
