package lean.java.example.design.mode.factory.abstracts;


import lean.java.example.design.mode.factory.AudiCar;
import lean.java.example.design.mode.factory.Car;

public class AudiFactory extends AbstractFactory {

    @Override
    public Car getCar() {
        return new AudiCar();
    }

}
