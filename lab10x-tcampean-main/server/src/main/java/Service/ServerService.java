package Service;

import domain.Performance;
import domain.Scene;
import domain.ScheduleDay;
import utils.Message;
import utils.Service;
import domain.Artist;
import repository.ArtistRepository;
import repository.PerformanceRepository;
import repository.SceneRepository;
import repository.ScheduleDayRepository;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ServerService implements Service {

    private ExecutorService executorService;
    ArtistRepository artists;
    PerformanceRepository performances;
    SceneRepository scenes;
    ScheduleDayRepository schedules;
    public ServerService(ArtistRepository artist, PerformanceRepository perform, SceneRepository scene, ScheduleDayRepository schedule,ExecutorService e)
    {
        artists = artist;
        performances = perform;
        scenes = scene;
        schedules = schedule;
        executorService = e;

    }

    @Override
    public Future<String> addArtist(Artist artist) {
        return executorService.submit(() -> {
                artists.save(artist);
        return "Success";
    });
    }

    @Override
    public Future<String> deleteArtist(Message request) {
        return executorService.submit(() -> {
            artists.delete((Long) request.getObject());
            return "Success";
        });
    }

    @Override
    public Future<String> getArtists() {
        return executorService.submit(() -> {
            Iterable<Artist> result = artists.findAll();
            StringBuilder list = new StringBuilder();
            for(Artist a: result)
            {
                list.append(a).append("\n");
            };
            return list.toString();
        });
    }

    @Override
    public Future<String> updateArtist(Message request) {
        return executorService.submit(() -> {
            artists.update((Artist) request.getObject());
            return "Success";
        });
    }

    @Override
    public Future<String> addScene(Message request)
    {
        return executorService.submit(() -> {
            scenes.save((Scene) request.getObject());
            return "Success";
        });
    }

    @Override
    public Future<String> updateScene(Message request)
    {
        return executorService.submit(() -> {
            scenes.update((Scene) request.getObject());
            return "Success";
        });
    }

    @Override
    public Future<String> deleteScene(Message request)
    {
        return executorService.submit(() -> {
            scenes.delete((Long) request.getObject());
            return "Success";
        });
    }

    @Override
    public Future<String> getScenes() {
        return executorService.submit(() -> {
            Iterable<Scene> result = scenes.findAll();
            StringBuilder list = new StringBuilder();
            for(Scene a: result)
            {
                list.append(a).append("\n");
            };
            return list.toString();
        });
    }

    @Override
    public Future<String> addScheduleDay(Message request) {
        return executorService.submit(() -> {
            schedules.save((ScheduleDay) request.getObject());
            return "Success";
        });
    }

    @Override
    public Future<String> deleteScheduleDay(Message request) {
        return executorService.submit(() -> {
            schedules.delete((Long) request.getObject());
            return "Success";
        });
    }

    @Override
    public Future<String> updateScheduleDay(Message request) {
        return executorService.submit(() -> {
            schedules.update((ScheduleDay) request.getObject());
            return "Success";
        });
    }

    @Override
    public Future<String> getScheduledDays() {
        return executorService.submit(() -> {
            Iterable<ScheduleDay> result = schedules.findAll();
            StringBuilder list = new StringBuilder();
            for(ScheduleDay a: result)
            {
                list.append(a).append("\n");
            };
            return list.toString();
        });
    }

    @Override
    public Future<String> addPerformance(Message request) {
        return executorService.submit(() -> {
            performances.save((Performance) request.getObject());
            return "Success";
        });
    }

    @Override
    public Future<String> deletePerformance(Message request) {
        return executorService.submit(() -> {
            performances.delete((Long) request.getObject());
            return "Success";
        });
    }

    @Override
    public Future<String> updatePerformance(Message request) {
        return executorService.submit(() -> {
            performances.update((Performance) request.getObject());
            return "Success";
        });
    }

    @Override
    public Future<String> getPerformances() {
        return executorService.submit(() -> {
            Iterable<Performance> result = performances.findAll();
            StringBuilder list = new StringBuilder();
            for(Performance a: result)
            {
                list.append(a).append("\n");
            };
            return list.toString();
        });
    }
}
