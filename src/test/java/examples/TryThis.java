
//import Karate from Junit5 karate plugin
public class TryThis {

    @Karate.Test
    Karate testSample() {
        return new Karate().feature("foo");
    }
    
}

