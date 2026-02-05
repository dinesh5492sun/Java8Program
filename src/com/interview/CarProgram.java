package com.interview;
import java.util.*;
import java.util.stream.*;

class Car {
    Integer model;
    Double price;

    public Car(Integer model, Double price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{model=" + model + ", price=" + price + "}";
    }

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
    
    
}

public class CarProgram {
    public static void main(String[] args) {
        List<Car> carDetails = Arrays.asList(
            new Car(1992, 2001.0),
            new Car(1990, 1001.0),
            new Car(1995, 1421.0),
            new Car(1993, 3001.0),
            new Car(1994, 3001.0),
            new Car(2000, 2001.0),
            new Car(1992, 5001.0),
            new Car(2001, 1001.0)
        );

        List<Car> sortedCars = carDetails.stream()
            .sorted(
                Comparator.comparing(Car::getModel)
                          .reversed()
                          .thenComparing(Comparator.comparing(Car::getPrice).reversed())
            )
            .collect(Collectors.toList());

        sortedCars.forEach(System.out::println);
        
        
        List<Car> sortedCars1 = carDetails.stream()
        	    .sorted(
        	        Comparator.comparing((Car c) -> c.model)
        	                  .reversed()
        	                  .thenComparing((Car c) -> c.price, Comparator.reverseOrder())
        	    )
        	    .collect(Collectors.toList());
        System.out.println("sortedCars1"+sortedCars1);

    }
}
