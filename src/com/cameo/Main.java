package com.cameo;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
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

        int total = 0;
        int largestNumber = 0;
        int smallestNumber = 9999;

        //loops through each element of array and adds to previous total to create new total
        for (int numberOfCrates : houses) {
            total = total + numberOfCrates;
            if (numberOfCrates > largestNumber) {   //finds house with the most crates
                largestNumber = numberOfCrates;
            }
            if (numberOfCrates < smallestNumber) {  //finds house with the least crates
                smallestNumber = numberOfCrates;
            }
        }

        //Creates new array list of all homes that set out the most recycling bins.
        ArrayList<Integer> mostRecycling = new ArrayList<Integer>();
            for (int j = 0; j < houses.length; j++){
                if (houses[j] == largestNumber){
                    mostRecycling.add(j);
                }
            }

        //Create FileWriter to write to a file
        FileWriter writer = new FileWriter("recycling.txt");
        int count = 0;
        for (Integer crates : houses){
            writer.write("House " + count + " recycled " + crates + " crates\n");
            count++;
        }
        writer.write("\nTotal crates recycled is = " + total + "\n\n");
        writer.write("House(s) that recycled the most \n");
        int counter = 0;
        for (Integer houseNumber : mostRecycling){
            writer.write("House " + counter + ": " + largestNumber + " crates\n");
            counter++;
        }
        writer.close();
        }
    }
