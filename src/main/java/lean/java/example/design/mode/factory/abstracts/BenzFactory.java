package lean.java.example.design.mode.factory.abstracts;


import lean.java.example.design.mode.factory.BenzCar;
import lean.java.example.design.mode.factory.Car;

public class BenzFactory extends AbstractFactory {

    @Override
    public Car getCar() {
        return new BenzCar();
    }

}
