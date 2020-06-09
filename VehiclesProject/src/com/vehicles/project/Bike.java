package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {

  public Bike(String plate, String brand, String color) {
  	super(plate, brand, color);
  }

  public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
    addWheel(frontWheels);
    addWheel(backWheels);
  }

  public void addWheel(List<Wheel> wheels) throws Exception {
    if (wheels.size() != 1)
      throw new Exception();

    Wheel wheel = wheels.get(0);
    this.wheels.add(wheel);
  }

  @Override
  public String toString() {
    return "Bike{" +
            "plate='" + plate + '\'' +
            ", brand='" + brand + '\'' +
            ", color='" + color + '\'' +
            ", wheels=" + wheels +
            '}';
  }
}
