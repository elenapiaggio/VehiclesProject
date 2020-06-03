package com.vehicles.project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {

    Scanner sc = new Scanner(System.in);
    System.out.print("Plate: \t");
    String plate = sc.nextLine();

    System.out.print("Brand: \t");
    String brand = sc.nextLine();

    System.out.print("Color: \t");
    String color = sc.nextLine();

    Car clientCar = new Car(plate, brand, color);

    System.out.println("\n*********** For Back Wheels ***********");
    System.out.print("Please, write the Brand: \t");
    String brandWheelBack = sc.nextLine();

    System.out.print("Please, write the Diameter: \t");
    double diameterWheelBack = sc.nextDouble();

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

    Wheel frontWheel1 = new Wheel(brandWheelFront, diameterWheelFront);
    Wheel frontWheel2 = new Wheel(brandWheelFront, diameterWheelFront);
    List<Wheel> frontWheelsList = new ArrayList<Wheel>();
    frontWheelsList.add(frontWheel1);
    frontWheelsList.add(frontWheel1);

    clientCar.addWheels(frontWheelsList, backWheelsList);
    //clientCar.addWheels(backWheelsList, frontWheelsList);

    System.out.println(clientCar.toString());

  }


}
