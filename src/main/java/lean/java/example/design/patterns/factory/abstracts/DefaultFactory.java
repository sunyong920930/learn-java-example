package lean.java.example.design.patterns.factory.abstracts;


import lean.java.example.design.patterns.factory.Car;

public class DefaultFactory extends AbstractFactory {

    private AudiFactory defaultFactory = new AudiFactory();

    public Car getCar() {
        return defaultFactory.getCar();
    }

}
