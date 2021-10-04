public class Main 
{
  public static void main(String[] args) 
  {
    StackzBinHex stack = new StackzBinHex();
    System.out.println(stack.toStringStack());
    stack.pushBin(10);
    System.out.println(stack.toStringStack());
    stack.pushBin(8);
    System.out.println(stack.toStringStack());
    stack.pushHex(2613);
    System.out.println(stack.toStringStack());    
    stack.pop();
    System.out.println(stack.toStringStack());
  }
}

public class Node
{
  private String value;
  private Node top;
  Node(int value) // Constructor
  {
    this.value=Integer.toString(value);
  }
  Node(String value) // Constructor
  {
    this.value=value;
  }
  public String peek() // Returns the top of the stack
  {
    return this.value;
  }
  public Node getNext() // return the next stack
  {
    return top;
  }
  public void setNext(Node n) // pointer function
  {
    top=n;
  }
  public String getValue() // returns value
  {
    return this.value;
  }
}

import java.util.*;
public class StackzBinHex
{
  private Node top;
  public void pushBin(int value) // this method allows the function to push a binary equivalent on the stack
  {
    while(value > 0) // loops until value is 0
    {
      int bin=value%2; // binary operation
      Node newNode = new Node(bin); // pushes binary to the stack
      newNode.setNext(top); // pointer
      top=newNode;
      value/=2;
    }
  }
  public void pop() // points to the next object in the stack
  {
    top=top.getNext();
  }
  public String toStringStack() 
  {
    if (top == null) // if list is empty return []
    {
      return "[]";
    } 
    Node current = top; // temp node
    String result ="[" + current.getValue(); // starts with [number
    current=current.getNext(); // traverses once 
    while (current != null) // to update result
    {
      result += ", " + current.getValue();
      current = current.getNext();
    }
    result += "]"; // closes off result 
    return result;
  }
  public void pushHex(int value) // this function allows the user to push a number in hexadecimal form onto a stack
  {
    while(value > 0) // loops until value is 0
    {
      int bin=value%16;
      switch(bin) // switch case statement for each hexadecimal case
      {
        case(10):
        {
          Node newNode = new Node("A");
          newNode.setNext(top);
          top=newNode;
          value/=16;
          break;
        }
        case(11):
        {
          Node newNode = new Node("B");
          newNode.setNext(top);
          top=newNode;
          value/=16;
          break;
        }
        case(12):
        {
          Node newNode = new Node("C");
          newNode.setNext(top);
          top=newNode;
          value/=16;
          break;
        }
        case(13):
        {
          Node newNode = new Node("D");
          newNode.setNext(top);
          top=newNode;
          value/=16;
          break;
        }
        case(14):
        {
          Node newNode = new Node("E");
          newNode.setNext(top);
          top=newNode;
          value/=16;
          break;
        }
        case(15):
        {
          Node newNode = new Node("F");
          newNode.setNext(top);
          top=newNode;
          value/=16;
          break;
        }
      default:
      Node newNode = new Node(bin);
      newNode.setNext(top);
      top=newNode;
      value/=16;
      }
    }
  }
}
