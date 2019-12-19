package examples;

import org.junit.Test;

public class ServerStop {

    @Test
    public void stopServer() {
        MonitorThread.stop(8081);
    }

}
