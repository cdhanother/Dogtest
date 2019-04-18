/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catsortproject;

import java.util.LinkedList;

/**
 *
 * @author Bingnan Dong
 */
public class CatSortProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
      //reverse and capitalize a String 
      String r  = "abcdefghijk3!";
      String result =reverseAndCap(r.toUpperCase());
      System.out.println("after reversing and capitalizing:");
      System.out.println(result);
       
      //Quick Sort cat by weight
      Cat[] cat = new Cat[5];
      cat[0]= new Cat("John",8.5,5);
      cat[1]= new Cat("Ada",11.3,4);
      cat[2]= new Cat("Joe",6.6,6);
      cat[3]= new Cat("Eric",7.6,7);
      cat[4]= new Cat("Joe",17.8,8);
      QuickSortWeight(cat,0,cat.length-1);
      System.out.println("\nAfter sorting by weight:");
      System.out.println(String.format("%-20s%-10s%-10s", "Name","Weight","Age"));
      for (int i=0 ; i< cat.length;i++)
      {
        System.out.println(cat[i].toString()); 
       }
      
       //Quick Sort cat by name
       LinkedCatList llcat = new  LinkedCatList();
       llcat.add(new Cat("Jotaro",12.3,5));
       llcat.add(new Cat("Brando",8.3,4));
       llcat.add(new Cat("Zeppeli",6.6,6));
       llcat.add(new Cat("White",10.6,7));
       llcat.add(new Cat("Lee",7.3,8));
       llcat.QuickSortName(0,  llcat.getLength()-1);
       System.out.println("\nAfter sorting by name:");
       llcat.displayList();
    }
    
  public static String reverseAndCap(String r){
     
     if(r.isEmpty()){
         return r;
      } else {
         return reverseAndCap(r.substring(1))+r.charAt(0);
      }
   }
    
  public  static void QuickSortWeight(Cat  cat[],int low,int high)
  {
   int   l=low;
   int   h=high;
   
   if(l>=h){
         return;
   } 
   
   double  povit=cat[low].getWeight();
   while(l< h)
   {
       while(l < h &&cat[h].getWeight()>povit)
       h--;
       if(l< h){
          Cat temp=cat[h];
          cat[h]=cat[l];   
          cat[l]=temp;
          l++;
        }

       while(l< h && cat[l].getWeight()< povit)
       l++;
       if(l< h){
          Cat temp=cat[h];
          cat[h]=cat[l];
          cat[l]=temp;
          h--;
         }
   }

  if(l>low) QuickSortWeight(cat,low,l-1);
  if(h<high) QuickSortWeight(cat,l+1,high);
   }
}

    
