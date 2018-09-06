package lean.java.example.design.mode.factory.abstracts;


import lean.java.example.design.mode.factory.Car;

public class DefaultFactory extends AbstractFactory {

    private AudiFactory defaultFactory = new AudiFactory();

    public Car getCar() {
        return defaultFactory.getCar();
    }

}
