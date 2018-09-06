package lean.java.example.design.mode.factory.abstracts;


import lean.java.example.design.mode.factory.BmwCar;
import lean.java.example.design.mode.factory.Car;

public class BmwFactory extends AbstractFactory {

    @Override
    public Car getCar() {
        return new BmwCar();
    }

}
