/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catsortproject;

/**
 *
 * @Bingnan Dong
 */
public class Cat {
    private String Name;
    private double Weight;
    private int Age;
    
    
    public Cat(String Name, double Weight,int Age  ){
        this.Name = Name;
        this.Weight = Weight;
        this.Age = Age;
    }
    
    public String getName(){
        return Name;
    }
    
    public int getAge(){
        return Age;
    }
    
    public double getWeight(){
        return Weight;
    }
    
    public String toString() {
     //   return Name + "," + Weight+ "," + Age;
        return String.format("%-20s%-10s%-10s", Name, Weight, Age);
    }
}
