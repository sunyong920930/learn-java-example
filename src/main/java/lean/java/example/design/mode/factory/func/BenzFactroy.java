package lean.java.example.design.mode.factory.func;

import lean.java.example.design.mode.factory.BenzCar;
import lean.java.example.design.mode.factory.Car;

/**
 * Created by sunyong on 2018-09-06.
 */
public class BenzFactroy implements Factory {
    @Override
    public Car getCar() {
        return new BenzCar();
    }
}
