package lean.java.example.design.patterns.factory.func;

import lean.java.example.design.patterns.factory.AudiCar;
import lean.java.example.design.patterns.factory.Car;

/**
 * Created by sunyong on 2018-09-06.
 */
public class AudiFactroy implements Factory {
    @Override
    public Car getCar() {
        return new AudiCar();
    }
}
