package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class Main {
  public static void main(String[] args) throws Exception {
    int option = 0;
    boolean error = false;
    Scanner sc = new Scanner(System.in);

    do{
      System.out.print("Do you want to create: \t (1) Car \t (2) Bike \t");
      option = sc.nextInt();
      switch (option){
        case 1: {
          createCar();
          error = false;
        }
        break;
        case 2: {
          createBike();
          error = false;
        }
        break;
        default: error = true;
          System.out.println("Incorrect option");
      }
    }
    while (error);
  }

  public static boolean plateIsCorrect(String plate){
    String patPlate = "^[a-zA-Z]{4}[0-9]{2,3}";
    Pattern pat = Pattern.compile(patPlate);
    Matcher mat = pat.matcher(plate);

    if (mat.matches()) {
      return true;
    } else {
      return false;
    }
  }

  public static void createCar() throws Exception {
    String brand = "";
    String color = "";
    String plate = "";
    double diameterWheelBack = 0;
    double diameterWheelFront = 0;
    boolean plateIsCorrect = true;
    boolean diameterIsCorrect = true;
    Scanner sc = new Scanner(System.in);
    System.out.println(" ******** Data for Car: ******** ");

    do {
      System.out.print("Plate: \t");
      plate = sc.nextLine();
      plateIsCorrect = plateIsCorrect(plate);
      if(plateIsCorrect){
        plateIsCorrect=true;
      } else{
        System.out.println("Incorrect plate, try again");
      }
    }
    while(!plateIsCorrect);

    System.out.print("Brand: \t");
    brand = sc.nextLine();

    System.out.print("Color: \t");
    color = sc.nextLine();

    Car clientCar = new Car(plate, brand, color);
    System.out.println("\n*********** For Back Wheels ***********");
    System.out.print("Please, write the Brand: \t");
    String brandWheelBack = sc.nextLine();

    do{
      System.out.print("Diameter: \t");
      diameterWheelBack = sc.nextDouble();
      diameterIsCorrect = diameterIsCorrect(diameterWheelBack);
    }
    while(!diameterIsCorrect);

    Wheel backWheel1 = new Wheel(brandWheelBack, diameterWheelBack);
    Wheel backWheel2 = new Wheel(brandWheelBack, diameterWheelBack);
    List<Wheel> backWheelsList = new ArrayList<Wheel>();
    backWheelsList.add(backWheel1);
    backWheelsList.add(backWheel1);

    System.out.println("\n*********** For Front Wheels ***********");
    System.out.print("Please, write the Brand: \t");
    Scanner console = new Scanner(System.in);
    String brandWheelFront = console.nextLine();

    diameterIsCorrect = false;

    do{
      System.out.print("Diameter: \t");
      diameterWheelFront = sc.nextDouble();
      diameterIsCorrect = diameterIsCorrect(diameterWheelFront);
    }
    while(!diameterIsCorrect);

    Wheel frontWheel1 = new Wheel(brandWheelFront, diameterWheelFront);
    Wheel frontWheel2 = new Wheel(brandWheelFront, diameterWheelFront);
    List<Wheel> frontWheelsList = new ArrayList<Wheel>();
    frontWheelsList.add(frontWheel1);
    frontWheelsList.add(frontWheel1);

    clientCar.addWheels(frontWheelsList, backWheelsList);
    System.out.println("\nCar created correctly. Summary:");
    System.out.println(clientCar.toString());
  }

  public static void createBike() throws Exception {
    String brand = "";
    String color = "";
    String plate = "";
    double diameterWheelBack = 0;
    double diameterWheelFront = 0;
    boolean plateIsCorrect = true;
    boolean diameterIsCorrect = false;

    System.out.println(" ******** Data for Bike ******** ");
    Scanner sc = new Scanner(System.in);

    do {
      System.out.print("Plate: \t");
      plate = sc.nextLine();
      plateIsCorrect = plateIsCorrect(plate);
      if(plateIsCorrect){
        plateIsCorrect=true;
      } else{
        System.out.println("Incorrect plate, try again");
      }
    }
    while(!plateIsCorrect);

    System.out.print("Brand: \t");
    brand = sc.nextLine();

    System.out.print("Color: \t");
    color = sc.nextLine();

    Bike clientBike = new Bike(plate, brand, color);

    System.out.println("\n*********** For Back Wheel ***********");
    System.out.print("Brand: \t");
    String brandWheelBack = sc.nextLine();

    do{
      System.out.print("Diameter: \t");
      diameterWheelBack = sc.nextDouble();
      diameterIsCorrect = diameterIsCorrect(diameterWheelBack);
    }
    while(!diameterIsCorrect);

    Wheel backWheel = new Wheel(brandWheelBack, diameterWheelBack);
    List<Wheel> backWheelsList = new ArrayList<Wheel>();
    backWheelsList.add(backWheel);

    System.out.println("\n*********** For Front Wheel ***********");
    System.out.print("Brand: \t");
    Scanner console = new Scanner(System.in);
    String brandWheelFront = console.nextLine();

    do{
      System.out.print("Diameter: \t");
      diameterWheelFront = sc.nextDouble();
      diameterIsCorrect = diameterIsCorrect(diameterWheelFront);
    }
    while(!diameterIsCorrect);

    Wheel frontWheel = new Wheel(brandWheelFront, diameterWheelFront);
    List<Wheel> frontWheelsList = new ArrayList<Wheel>();
    frontWheelsList.add(frontWheel);

    clientBike.addWheels(frontWheelsList, backWheelsList);

    System.out.println("\nByke created correctly. Summary: ");
    System.out.println(clientBike.toString());
  }

  public static boolean diameterIsCorrect(double diameter){
    if (!(diameter >= 0.4 && diameter < 4)) {
      System.out.print("\nIncorrect diameter, try again!!!\n");
      return false;
    } else{
      return true;
    }
  }

}
