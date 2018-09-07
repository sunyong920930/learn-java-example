package lean.java.example.design.patterns.factory.abstracts;


import lean.java.example.design.patterns.factory.BenzCar;
import lean.java.example.design.patterns.factory.Car;

public class BenzFactory extends AbstractFactory {

    @Override
    public Car getCar() {
        return new BenzCar();
    }

}
