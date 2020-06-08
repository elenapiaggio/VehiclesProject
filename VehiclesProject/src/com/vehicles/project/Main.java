package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class Main {
  public static void main(String[] args) throws Exception {

    String brand = "";
    String color = "";

    Scanner sc = new Scanner(System.in);
    System.out.print("Plate: \t");
    String plate = sc.nextLine();

    String patPlate = "^[a-zA-Z]{4}[0-9]{2,3}";
    Pattern pat = Pattern.compile(patPlate);
    Matcher mat = pat.matcher(plate);

    if (mat.matches()) {
      System.out.print("Brand: \t");
      brand = sc.nextLine();

      System.out.print("Color: \t");
      color = sc.nextLine();
    } else {
      System.out.println("Incorrect plat");
      return;
    }

    Car clientCar = new Car(plate, brand, color);

    System.out.println("\n*********** For Back Wheels ***********");
    System.out.print("Please, write the Brand: \t");
    String brandWheelBack = sc.nextLine();

    System.out.print("Please, write the Diameter: \t");
    double diameterWheelBack = sc.nextDouble();

    if (!(diameterWheelBack >= 0.4 && diameterWheelBack < 4)) {
      System.out.println("Incorrecto diameter!!");
      return;
    }
    Wheel backWheel1 = new Wheel(brandWheelBack, diameterWheelBack);
    Wheel backWheel2 = new Wheel(brandWheelBack, diameterWheelBack);
    List<Wheel> backWheelsList = new ArrayList<Wheel>();
    backWheelsList.add(backWheel1);
    backWheelsList.add(backWheel1);

    System.out.println("\n*********** For Front Wheels ***********");
    System.out.print("Please, write the Brand: \t");
    Scanner console = new Scanner(System.in);
    String brandWheelFront = console.nextLine();

    System.out.print("Please, write the Diameter: \t");
    double diameterWheelFront = console.nextDouble();

    if (!(diameterWheelFront >= 0.4 && diameterWheelFront < 4)) {
      System.out.println("Incorrecto diameter!!");
      return;
    }

    Wheel frontWheel1 = new Wheel(brandWheelFront, diameterWheelFront);
    Wheel frontWheel2 = new Wheel(brandWheelFront, diameterWheelFront);
    List<Wheel> frontWheelsList = new ArrayList<Wheel>();
    frontWheelsList.add(frontWheel1);
    frontWheelsList.add(frontWheel1);

    clientCar.addWheels(frontWheelsList, backWheelsList);
    System.out.println(clientCar.toString());
  }

}
