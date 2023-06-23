/*Author: Aung Pyae Sone Shan
 * Date: 10.4.2023*/

import java.util.*;
import java.util.ArrayList;

/* Calculator application for Judo training cost
 * Request user input and calculate and show the output to the user
 * This program uses three OOP concepts Inheritance, Encapsulation and Polymorphisms*/

public class NorthSussexJudo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Athlete> athletes = new ArrayList<Athlete>(); //ArrayList to store more than one athlete's data
        int numAthletes = 0;

        //Endless loop for collecting refactorAthletes data
        while (true) {
            System.out.println("Enter athlete name (or 'quit' to exit):");
            String name = scanner.nextLine(); //Athlete's name

            // Name validation testing
            if (name.matches("[a-zA-Z ]+")) {
                if (name.equals("quit")) {
                    break;
                }
            } else {
                System.out.println("Please enter a valid name... ");
                continue;
            }

            Athlete athlete=null;
            boolean testPlan=true; //For plan validation tester
            String plan;//Athlete's plan
           do {
               System.out.println("Enter training plan (beginner/intermediate/elite):");
                plan = scanner.nextLine();
                testPlan=true;
               //plan validation tester
               switch (plan) {
                   case "beginner":
                       athlete = new BeginnerAthlete(name);
                       break;
                   case "intermediate":
                       athlete = new IntermediateAthlete(name);
                       break;
                   case "elite":
                       athlete = new EliteAthlete(name);
                       break;
                   default:
                       System.out.println("Invalid training plan. Please try again.");
                       testPlan=false;
               }
           }while (!testPlan);

            String currentWeight;//Athlete current weight
            do {
                System.out.println("Enter current weight (in kg): ");
                currentWeight = scanner.next();
            //double currentWeight = scanner.nextDouble();
                scanner.nextLine();
            } while (!isValidWeight(currentWeight));

            //setCurrentWeight() is from Athlete class to update current weight
            athlete.setCurrentWeight(Double.parseDouble(currentWeight));
            //athlete.setCurrentWeight(currentWeight);
            String competitionWeight;//Athlete competition weight
            do {
                System.out.println("Enter competition weight category (in kg): \n" +
                        "Heavyweight Unlimited(over 100)\n" +
                        "Light-Heavyweight 100\n" +
                        "Middleweight 90\n" +
                        "Light-Middleweight 81\n" +
                        "Lightweight 73\n" +
                        "Flyweight 66");
                competitionWeight = scanner.next();
                scanner.nextLine();

            } while (!isValidWeight(competitionWeight));


            //setCompetitionWeight() is from Athlete class to update competition weight
            athlete.setCompetitionWeight(Double.parseDouble(competitionWeight));

            //condition for blocking beginner athlete not to enter the competition
            if (!plan.equals("beginner")) {
                String numCompetitions;//Athlete no. of competition
               do {
                   System.out.println("Enter number of competitions entered this month (max 2 times per month) : ");
                   numCompetitions = scanner.next();
                   scanner.nextLine();

            // New added control statement
                   try{
                      double num= Double.parseDouble(numCompetitions);
                       if(num>2){
                           System.out.println("Please enter number less than 2!");
                           numCompetitions="a";
                       }
                   }catch (Exception e){
                       continue;
                   };
               }while (!isValidWeight(numCompetitions));
                athlete.setNumCompetitions(Integer.parseInt(numCompetitions));
            }
            String numPrivateCoachingHours;//Athltet no.of private coaching hours
            do {
                System.out.println("Enter number of hours of private coaching (max 5 hours per week):");
                 numPrivateCoachingHours = scanner.next(); // Athlete's private coaching hours
                scanner.nextLine();

            // New added control statement
                try{
                      double num= Double.parseDouble(numPrivateCoachingHours);
                       if(num>20){
                           System.out.println("Please enter number less than 20!");
                           numPrivateCoachingHours="a";
                       }
                   }catch (Exception e){
                       continue;
                   };

            }while(!isValidWeight(numPrivateCoachingHours));
            //setPrivateCoaching() is from Athlete class to update private coaching hours
            athlete.setPrivateCoaching(Double.parseDouble(numPrivateCoachingHours));
            athletes.add(athlete); //adding the athlete's information in ArrayList
            numAthletes++;
        }

        //forEach loop for output the refactorAthletes' data in the arrayList
        for (Athlete athlete : athletes) {
            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println();
            System.out.println("Athlete: " + athlete.getName());
            System.out.println("Training cost: $" + String.format("%.2f", athlete.getTrainingCost()));
            System.out.println("Competition cost: $" + String.format("%.2f", athlete.getCompetitionCost()));
            System.out.println("Private coaching cost: $" + String.format("%.2f", athlete.getPrivateCoachingCost()));
            System.out.println("Total cost: $" + String.format("%.2f", athlete.calculateTotalCost()));
            System.out.println(athlete.getWeightCategory());
            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println();
        }
    }

    //Weight validation tester function
    static boolean isValidWeight(String weightStr) {
        try {
            double weight = Double.parseDouble(weightStr);
            if (weight > 0) {
                return true;
            } else {
                System.out.println("Please enter a positive number...");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number...");
            return false;
        }
    }

}












