import Service.ServerService;
import domain.Artist;
import utils.Message;
import utils.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tcp.TCPServer;

import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ServerApp {

    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("config");
        TCPServer tcpServer = context.getBean(TCPServer.class);
        ServerService service = context.getBean(ServerService.class);

        tcpServer.addHandler("addArtist",request ->{
            Future<String> res = service.addArtist((Artist)request.getObject());
            try {
                String result = res.get();
                Message response = new Message(Message.OK, result);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });

        tcpServer.addHandler("getArtists", request -> {
            Future<String> res = service.getArtists();
            System.out.println(res);
            try {
                Message response = new Message(Message.OK, res.get(),null);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });

        tcpServer.addHandler("deleteArtist", request -> {
            Future<String> res = service.deleteArtist(request);
            try {
                String result = res.get();
                Message response = new Message(Message.OK, result,null);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });

        tcpServer.addHandler("updateArtist", request -> {
            Future<String> res = service.updateArtist(request);
            try {
                String result = res.get();
                Message response = new Message(Message.OK, result,null);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });

        tcpServer.addHandler("addScene", request -> {
            Future<String> res = service.addScene(request);
            try {
                String result = res.get();
                Message response = new Message(Message.OK, result,null);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });


        tcpServer.addHandler("deleteScene", request -> {
            Future<String> res = service.deleteScene(request);
            try {
                String result = res.get();
                Message response = new Message(Message.OK, result,null);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });

        tcpServer.addHandler("updateScene", request -> {
            Future<String> res = service.updateScene(request);
            try {
                String result = res.get();
                Message response = new Message(Message.OK, result,null);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });

        tcpServer.addHandler("getScenes", request -> {
            Future<String> res = service.getScenes();
            try {
                String result = res.get();
                Message response = new Message(Message.OK, result,null);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });


        tcpServer.addHandler("addScheduleDay", request -> {
            Future<String> res = service.addScheduleDay(request);
            try {
                String result = res.get();
                Message response = new Message(Message.OK, result,null);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });

        tcpServer.addHandler("updateScheduleDay", request -> {
            Future<String> res = service.updateScheduleDay(request);
            try {
                String result = res.get();
                Message response = new Message(Message.OK, result,null);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });

        tcpServer.addHandler("deleteScheduleDay", request -> {
            Future<String> res = service.deleteScheduleDay(request);
            try {
                String result = res.get();
                Message response = new Message(Message.OK, result,null);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });

        tcpServer.addHandler("getScheduledDays", request -> {
            Future<String> res = service.getScheduledDays();
            try {
                String result = res.get();
                Message response = new Message(Message.OK, result,null);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });


        tcpServer.addHandler("addPerformance", request -> {
            Future<String> res = service.addPerformance(request);
            try {
                String result = res.get();
                Message response = new Message(Message.OK, result,null);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });

        tcpServer.addHandler("deletePerformance", request -> {
            Future<String> res = service.deletePerformance(request);
            try {
                String result = res.get();
                Message response = new Message(Message.OK, result,null);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });

        tcpServer.addHandler("updatePerformance", request -> {
            Future<String> res = service.updatePerformance(request);
            try {
                String result = res.get();
                Message response = new Message(Message.OK, result,null);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });

        tcpServer.addHandler("getPerformances", request -> {
            Future<String> res = service.getPerformances();
            try {
                String result = res.get();
                Message response = new Message(Message.OK, result,null);
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });



        tcpServer.startServer();

        System.out.println("bye");
    }
}
