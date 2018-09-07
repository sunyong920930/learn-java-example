package lean.java.example.design.patterns.factory.func;

import lean.java.example.design.patterns.factory.BmwCar;
import lean.java.example.design.patterns.factory.Car;

/**
 * Created by sunyong on 2018-09-06.
 */
public class BmwFactory implements Factory {


    @Override
    public Car getCar() {
        return new BmwCar();
    }
}
