package com.cameo;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        // This program stores the number of recycling crates of each house on the street.
        // The number of crates per home is stored in an Array.

        Scanner s = new Scanner(System.in);
        // Create the array
        int houses[] = new int[8];

        //Ask for the number of recycling crates per house and store each entry in houses array
        for (int i = 0; i < houses.length; i++) {
            System.out.println("How many recycling crates do you set out house number "
                    + i + "?");
            int numberOfRecyclingCrates = s.nextInt();
            houses[i] = numberOfRecyclingCrates;
        }

        String housesString = Arrays.toString(houses);
        System.out.println(housesString);

        int total = 0;
        int largestNumber = 0;
        int smallestNumber = 9999;

        //loops through each element of array and adds to previous total to create new total
        for (int numberOfCrates : houses) {
            total = total + numberOfCrates;
            if (numberOfCrates > largestNumber) {   //finds home with the most crates
                largestNumber = numberOfCrates;
            }
            if (numberOfCrates < smallestNumber) {  //finds home with the least crates
                smallestNumber = numberOfCrates;
            }
        }
            System.out.println("The total number of crates for the street is " + total);
            System.out.println("The largest number of crates set out by any house is " + largestNumber);
            System.out.println("The smallest number of crates set out by any house is " + smallestNumber);

        //Creates new array list of all homes that set out the most recycling bins.
        ArrayList<Integer> mostRecycling = new ArrayList();
            for (int l = 0; l < houses.length; l++){
                if (houses[l] == largestNumber){
                    mostRecycling.add(l);
                }
            }
        if (mostRecycling.size() > 1) {
            System.out.println("House numbers " + mostRecycling + " have the most recycling.");
        }
        else {
            System.out.println("House number " + mostRecycling + " has the most recycling.");
        }
    }
}