package lean.java.example.serializable.saverule;

import javax.jws.WebMethod;

public interface HelloWorldWs {

    @WebMethod
    String sayHello(String name);
}
