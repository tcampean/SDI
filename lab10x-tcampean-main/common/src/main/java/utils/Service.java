package utils;

import domain.Artist;

import java.util.concurrent.Future;

public interface Service {

    int PORT = 1234;
    String HOST = "localhost";

    Future<String> addArtist(Artist artist);

    Future<String> deleteArtist(Message request);

    Future<String> getArtists();

    Future<String> updateArtist(Message request);

    Future<String> addScene(Message request);

    Future<String> deleteScene(Message request);

    Future<String> updateScene(Message request);

    Future<String> getScenes();

    Future<String> addScheduleDay(Message request);

    Future<String> deleteScheduleDay(Message request);

    Future<String> updateScheduleDay(Message request);

    Future<String> getScheduledDays();

    Future<String> addPerformance(Message request);

    Future<String> deletePerformance(Message request);

    Future<String> updatePerformance(Message request);

    Future<String> getPerformances();
}
