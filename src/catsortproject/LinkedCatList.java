/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catsortproject;

import java.util.NoSuchElementException;

/**
 *
 * @author Bingnan Dong
 */
public class LinkedCatList {
    
    private Node first;
    private Node currentNode;   
    private int length;
    
    class Node {
      
       private Node next;
       private Cat  data ;

       public void printNodeData() {
         //  System.out.println("Name: " +   data .getName() + " Weight:" +   data .getWeight() + " Age:" +   data .getAge() );
         String r= String.format("%-20s%-10s%-10s",  data.getName(),   data.getWeight(),  data.getAge());
         System.out.println(r);
       }

       public Node getNext() {
           return next;
       }
    }
    
   public LinkedCatList() {
       first = null;
       currentNode = null;
       length = 0;
   }
   
  public void setFirstValue(Cat value  ) {
      first.data  =  value ;
   }
  
  public void setCurrentValue(Cat value ) {
      currentNode.data  =  value ;
   }
  
   public void addFirst(Cat value )
    { 
        //create the Node and set its value
        Node newNode = new Node();
        newNode.data  = value ;
      
        
       // if newNode is the first node, this will be null
        // otherwise it will point to the former "first" now
        newNode.next = first;
        
        //set our "first" Node to the Node we just created
        first = newNode;
        currentNode = newNode;
        length++;
        
    }   
      
  public void removeFirst() {
       if (first == null) {
           throw new NoSuchElementException("Can't remove in empty list");
       } else {
          first = first.next;
          length--;
       }
   }
  
  public void remove()
{
   if (currentNode == first)
   {
     removeFirst();
   }
   else
   {
      Node tempCurrent = currentNode;
      moveFirst();
      boolean found = false;
      while (!found)
      {
         if(currentNode.next == tempCurrent)
         {
            found = true;
         }
        else
        {
        moveNext();
        }
      }
      currentNode.next = tempCurrent.next;
      length--;
    }
}

public int indexOf(Cat value)
{
  Node tempNode = first;
  int position = 0;

  while (tempNode != null)
  {
   if (tempNode.data == value)
   {
    return position;
   }
  else
  {
    tempNode = tempNode.next;
    position++;
   }
 }
  return -1;

}

public void add(Cat value ) 
  {
       if (first == null) {
           addFirst(value );
       } else {
            Node newNode = new Node();
            newNode.data  = value ;
            newNode.next = currentNode.next;
            currentNode.next=newNode;
            moveNext();
            length++;
       }

   }

 public boolean isEmpty() {
       return (first == null);
   }
 
  public int getLength() {
       return length;
   }
   
  public String getFirstValue() {
       if (first == null) {
           throw new NoSuchElementException();
       } else {
           return first.data .getName() + ","+ first.data.getWeight()+"," + first.data.getAge();
       }
   }
  
  public String getCurrentValue() {
    if (currentNode == null) {
           throw new NoSuchElementException();
    } else {
           return currentNode.data .getName() + "," + currentNode.data .getWeight() + "," + currentNode.data .getAge();
    }
  }

public void moveNext() {
       if (currentNode.next == null) {
           throw new NoSuchElementException();
       } else {
           currentNode = currentNode.next;
       }
   }

   public void moveFirst() {
       currentNode = first;
   }
   
  
  public void displayList() {
       Node currentNode = first;
    //   System.out.println("List contents:");
       String r  =  String.format("%-20s%-10s%-10s", "Name","Weight","Age");
       System.out.println(r);
       while (currentNode != null) {
           currentNode.printNodeData();
           currentNode = currentNode.getNext();
         
       }
   }
 
public Cat get(int index){
     
   Node tempNode = first;
   int position = 0;

   while (tempNode != null)
   {
     if (position == index)
     {
      return tempNode.data ;
     }
     else
     {
      tempNode = tempNode.next;
      position++;
     }
    }
     return tempNode.data ;
 }

public void set(int i, Cat value ){
   Node tempNode = first;
   int position = 0;

   while (tempNode != null)
   {
     if (position == i)
     {
       tempNode.data = value ;
       break;
     }
     else
     {
      tempNode = tempNode.next;
      position++;
     }
    }  
  }
 
  public void QuickSortName(int low,int high)
  {
   int   l=low;
   int   h=high;
  
   if(l>=h){
         return;
   } 
   String  povit= get(l).getName();
   while(l < h)
   { 
       while(l< h && get(h).getName().compareTo(povit)>0)
       h--;
       if(l< h){
           Cat temp = get(h);
           set(h, get(l));
           set(l,temp);
           l++;
        }
 
        while(l<h && get(l).getName().compareTo(povit)<0)
        l++;
        if(l< h){
           Cat temp = get(h);
           set(h, get(l));
           set(l,temp);
           h--;
         }
   } 
   if(l>low) QuickSortName(low,l-1);
   if(l<high) QuickSortName(l+1,high);
   }
}

