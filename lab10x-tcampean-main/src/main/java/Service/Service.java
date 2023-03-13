package Service;

import domain.Artist;
import domain.Performance;
import domain.Scene;
import domain.ScheduleDay;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.ArtistRepository;
import repository.PerformanceRepository;
import repository.SceneRepository;
import repository.ScheduleDayRepository;

public class Service {

    ArtistRepository artists;
    PerformanceRepository performances;
    SceneRepository scenes;
    ScheduleDayRepository schedules;
    public Service(ArtistRepository artist, PerformanceRepository perform, SceneRepository scene, ScheduleDayRepository schedule)
    {
        artists = artist;
        performances = perform;
        scenes = scene;
        schedules = schedule;

    }

    public void addArtist(Artist artist)
    {
        artists.save(artist);
    }

    public void deleteArtist(Long id)
    {
        artists.delete(id);
    }

    public void updateArtist(Artist artist)
    {
        artists.update(artist);
    }

    public Iterable<Artist> getArtists()
    {
        return artists.findAll();
    }

    public void addScene(Scene scene)
    {
        scenes.save(scene);
    }

    public void deleteScene(Long id)
    {
        scenes.delete(id);
    }

    public void updateScene(Scene scene)
    {
        scenes.update(scene);
    }

    public Iterable<Scene> getScenes()
    {
        return scenes.findAll();
    }


    public void addPerformance(Performance artist)
    {
        performances.save(artist);
    }

    public void deletePerformance(Long id)
    {
        performances.delete(id);
    }

    public void updatePerformance(Performance artist)
    {
        performances.update(artist);
    }

    public Iterable<Performance> getPerformances()
    {
        return performances.findAll();
    }

    public void addSchedule(ScheduleDay artist)
    {
        schedules.save(artist);
    }

    public void deleteSchedule(Long id)
    {
        schedules.delete(id);
    }

    public void updateSchedule(ScheduleDay artist)
    {
        schedules.update(artist);
    }

    public Iterable<ScheduleDay> getSchedules()
    {
        return schedules.findAll();
    }
}
