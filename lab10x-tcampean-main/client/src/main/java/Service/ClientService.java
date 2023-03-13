package Service;

import TCPClient.TcpClient;
import utils.Message;
import utils.Service;
import domain.Artist;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ClientService implements Service {

    private ExecutorService executorService;
    private TcpClient tcpClient;

    public ClientService(ExecutorService executorService, TcpClient tcpClient) {
        this.executorService = executorService;
        this.tcpClient = tcpClient;
    }

    @Override
    public Future<String> addArtist(Artist artist) {

        return executorService.submit(() -> {
            Message addArtist = new Message("addArtist","artist body",artist );
            Message response = tcpClient.sendAndReceive(addArtist);

            String result = response.getBody();
            return result;
        });
    }

    @Override
    public Future<String> deleteArtist(Message req) {

        return executorService.submit(() -> {

            Message response = tcpClient.sendAndReceive(req);

            String result = response.getBody();
            return result;
        });
    }

    @Override
    public Future<String> getArtists() {
        return executorService.submit(() -> {
            Message request = new Message("getArtists", "list of artists",null);

            Message response = tcpClient.sendAndReceive(request);
            String result = response.getBody();
            return result;
        });
    }

    @Override
    public Future<String> updateArtist(Message req) {

        return executorService.submit(() -> {

            Message response = tcpClient.sendAndReceive(req);

            String result = response.getBody();
            return result;
        });
    }

    @Override
    public Future<String> addScene(Message request) {
        return executorService.submit(() -> {

            Message response = tcpClient.sendAndReceive(request);

            String result = response.getBody();
            return result;
        });
    }

    @Override
    public Future<String> deleteScene(Message request) {
        return executorService.submit(() -> {

            Message response = tcpClient.sendAndReceive(request);

            String result = response.getBody();
            return result;
        });
    }

    @Override
    public Future<String> updateScene(Message request) {
        return executorService.submit(() -> {

            Message response = tcpClient.sendAndReceive(request);

            String result = response.getBody();
            return result;
        });
    }

    @Override
    public Future<String> getScenes() {
        return executorService.submit(() -> {
            Message request = new Message("getScenes", "list of scenes",null);

            Message response = tcpClient.sendAndReceive(request);
            String result = response.getBody();
            return result;
        });
    }

    @Override
    public Future<String> addScheduleDay(Message request) {
        return executorService.submit(() -> {

            Message response = tcpClient.sendAndReceive(request);

            String result = response.getBody();
            return result;
        });
    }

    @Override
    public Future<String> deleteScheduleDay(Message request) {
        return executorService.submit(() -> {

            Message response = tcpClient.sendAndReceive(request);

            String result = response.getBody();
            return result;
        });
    }

    @Override
    public Future<String> updateScheduleDay(Message request) {
        return executorService.submit(() -> {

            Message response = tcpClient.sendAndReceive(request);

            String result = response.getBody();
            return result;
        });
    }

    @Override
    public Future<String> getScheduledDays() {
        return executorService.submit(() -> {
            Message request = new Message("getScheduledDays", "list of days",null);

            Message response = tcpClient.sendAndReceive(request);
            String result = response.getBody();
            return result;
        });
    }

    @Override
    public Future<String> addPerformance(Message request) {
        return executorService.submit(() -> {

            Message response = tcpClient.sendAndReceive(request);

            String result = response.getBody();
            return result;
        });
    }

    @Override
    public Future<String> deletePerformance(Message request) {
        return executorService.submit(() -> {

            Message response = tcpClient.sendAndReceive(request);

            String result = response.getBody();
            return result;
        });
    }

    @Override
    public Future<String> updatePerformance(Message request) {
        return executorService.submit(() -> {

            Message response = tcpClient.sendAndReceive(request);

            String result = response.getBody();
            return result;
        });
    }

    @Override
    public Future<String> getPerformances() {
        return executorService.submit(() -> {
            Message request = new Message("getPerformances", "list of performances",null);

            Message response = tcpClient.sendAndReceive(request);
            String result = response.getBody();
            return result;
        });
    }
}
