package TCPClient;

import domain.Artist;
import utils.Message;
import utils.Service;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class TcpClient {
    private ExecutorService executorService;

    public TcpClient(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public Message sendAndReceive(Message request) {
        try {var socket = new Socket(Service.HOST, Service.PORT);
             var is = socket.getInputStream();
             var os = socket.getOutputStream();


            System.out.println("sending request: " + request);
            request.writeTo(os);
            System.out.println("request sent");

            Message response = new Message();
            Thread.sleep(2000);
            response.readFrom(is);
            System.out.println("received response: " + response);

            return response;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Message("error","error");
    }
}