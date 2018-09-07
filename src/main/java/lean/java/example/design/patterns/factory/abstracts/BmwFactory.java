package lean.java.example.design.patterns.factory.abstracts;


import lean.java.example.design.patterns.factory.BmwCar;
import lean.java.example.design.patterns.factory.Car;

public class BmwFactory extends AbstractFactory {

    @Override
    public Car getCar() {
        return new BmwCar();
    }

}
