package examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonitorThread extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(MonitorThread.class);

    private final Stoppable stoppable;
    private final ServerSocket socket;

    public MonitorThread(int port, Stoppable stoppable) {
        this.stoppable = stoppable;
        setDaemon(true);
        setName("stop-monitor-" + port);
        try {
            socket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        logger.info("starting thread: {}", getName());
        Socket accept;
        try {
            accept = socket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            reader.readLine();
            logger.info("shutting down thread: {}", getName());
            stoppable.stop();
            accept.close();
            socket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void stop(int port) {
        try {
            Socket s = new Socket(InetAddress.getByName("127.0.0.1"), port);
            OutputStream out = s.getOutputStream();
            logger.info("sending stop request to monitor thread on port: {}", port);
            out.write(("\r\n").getBytes());
            out.flush();
            s.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
