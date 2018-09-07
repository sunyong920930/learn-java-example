package lean.java.example.design.patterns.factory.abstracts;


import lean.java.example.design.patterns.factory.AudiCar;
import lean.java.example.design.patterns.factory.Car;

public class AudiFactory extends AbstractFactory {

    @Override
    public Car getCar() {
        return new AudiCar();
    }

}
