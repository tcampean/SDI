package client.ui;

import client.controller.ArtistController;
import client.controller.PerformanceController;
import client.controller.SceneController;
import client.controller.ScheduleDayController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.domain.Artist;
import core.domain.ScheduleDay;
import core.dto.ArtistDto;
import core.dto.PerformanceDto;
import core.dto.SceneDto;
import core.dto.ScheduleDayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class Console {
    private final ArtistController artistController;
    private final SceneController sceneController;
    private final ScheduleDayController scheduleDayController;
    private final PerformanceController performanceController;


    @Autowired
    public Console(ArtistController artistController, SceneController sceneController, ScheduleDayController dayController, PerformanceController performanceController) {
        this.artistController = artistController;
        this.sceneController = sceneController;
        this.scheduleDayController = dayController;
        this.performanceController = performanceController;
    }

    public void printMenu() {
        System.out.println("Press 0 to exit app");
        System.out.println("Press 1 to add Artist");
        System.out.println("Press 2 to delete Artist");
        System.out.println("Press 3 to update Artist");
        System.out.println("Press 4 to list Artists");
        System.out.println("Press 5 to add Scene");
        System.out.println("Press 6 to delete Scene");
        System.out.println("Press 7 to update Scene");
        System.out.println("Press 8 to list Scenes");
        System.out.println("Press 9 to add Schedule day");
        System.out.println("Press 10 to delete schedule day");
        System.out.println("Press 11 to update schedule day");
        System.out.println("Press 12 to get scheduled days");
        System.out.println("Press 13 to add performances");
        System.out.println("Press 14 to remove performances");
        System.out.println("Press 15 to update performance");
        System.out.println("Press 16 to list performances");
        System.out.println("Press 17 to see statistics");
    }

    public ArtistDto inputArtist() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter Artist name: ");
        String name;
        try {
            name = reader.readLine();
        } catch (IOException e) {
            return null;
        }

        System.out.println("Enter Artist date of birth: ");
        String date;
        try {
            date = reader.readLine();
        } catch (IOException e) {
            return null;
        }
        System.out.println("Enter Artist music genre: ");
        String genre;
        try {
            genre = reader.readLine();
        } catch (IOException e) {
            return null;
        }

        return new ArtistDto(name, date, genre);
    }

    public Long inputDelete() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter ID: ");
        long id = -1L;
        try {
            id = Long.parseLong(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return null;
        } catch (IOException e) {
            return null;
        }
        return id;
    }

    public SceneDto inputScene() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter scene name: ");
        String name;
        try {
            name = reader.readLine();
        } catch (IOException e) {
            return null;
        }

        return new SceneDto(name);
    }

    public ScheduleDayDto inputScheduleDay() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter scene ID: ");
        Long sceneId = -1L;
        try {
            sceneId = Long.parseLong(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return null;
        } catch (IOException e) {
            return null;
        }

        System.out.println("Enter event date: ");
        String date;
        try {
            date = reader.readLine();
        } catch (IOException e) {
            System.out.println("Invalid Date");
            return null;
        }
        System.out.println("Enter the number of participants ");
        Integer nrOfParticipants;
        try {
            nrOfParticipants = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException | IOException e) {
            System.out.println("Invalid Number of participants");
            return null;
        }
        return new ScheduleDayDto(date, sceneId, nrOfParticipants);


    }

    public PerformanceDto inputPerformance() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter schedule day ID: ");
        Long scheduleid = -1L;
        try {
            scheduleid = Long.parseLong(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return null;
        } catch (IOException e) {
            return null;
        }

        System.out.println("Enter artist ID: ");
        Long artistid = -1L;
        try {
            artistid = Long.parseLong(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return null;
        } catch (IOException e) {
            return null;
        }

        System.out.println("Enter starting date: ");
        String startingdate;
        try {
            startingdate = reader.readLine();
        } catch (IOException e) {
            System.out.println("Invalid Date");
            return null;
        }

        System.out.println("Enter ending date: ");
        String endingdate;
        try {
            endingdate = reader.readLine();
        } catch (IOException e) {
            System.out.println("Invalid Date");
            return null;
        }

        return new PerformanceDto(artistid, scheduleid, startingdate, endingdate);


    }

    public void run() {
        boolean done = false;
        Scanner in = new Scanner(System.in);
        while (!done) {
            try {
                this.printMenu();
                int command = in.nextInt();
                switch (command) {
                    case 0:
                        done = true;
                        break;
                    case 1:
                        System.out.println("Add an artist");
                        ArtistDto newArtist = inputArtist();
                        if (newArtist != null) {
                            artistController.addArtist(newArtist).whenComplete((status, exception) -> {
                                if (exception == null)
                                    System.out.println(status);
                                else System.out.println(exception.getMessage());
                            });
                        }
                        break;
                    case 2:
                        Long id = inputDelete();

                        if (id != null) {
                            artistController.deleteArtist(id).whenComplete((status, exception) -> {
                                if (exception == null)
                                    System.out.println(status);
                                else System.out.println(exception.getMessage());
                            });
                        }
                        break;
                    case 3:
                        Long artistId = inputDelete();
                        ArtistDto updatedArtist = inputArtist();
                        if(artistId!= null && updatedArtist !=null) {
                            updatedArtist.setId(artistId);
                                artistController.updateArtist(updatedArtist).whenComplete((status, exception) -> {
                                    if (exception == null)
                                        System.out.println(status);
                                    else System.out.println(exception.getMessage());
                                });
                            }
                        break;
                    case 4:
                        artistController.getArtistsFromRepository().whenComplete((status, exception) -> {
                            if (exception == null)
                                System.out.println(status);
                            else System.out.println(exception.getMessage());
                        });
                        break;
                    case 5:
                        SceneDto newScene = inputScene();
                        if (newScene != null) {
                            sceneController.addScene(newScene).whenComplete((status, exception) -> {
                                if (exception == null)
                                    System.out.println(status);
                                else System.out.println(exception.getMessage());
                            });
                        }
                        break;
                    case 6:
                        Long id1 = inputDelete();
                        if (id1 != null) {
                            sceneController.deleteScene(id1).whenComplete((status, exception) -> {
                                if (exception == null)
                                    System.out.println(status);
                                else System.out.println(exception.getMessage());
                            });
                        }
                        break;
                    case 7:
                        Long sceneId = inputDelete();
                        SceneDto updatedScene = inputScene();
                        if (updatedScene != null && sceneId !=null) {
                            updatedScene.setId(sceneId);
                            sceneController.updateScene(updatedScene).whenComplete((status, exception) -> {
                                if (exception == null)
                                    System.out.println(status);
                                else System.out.println(exception.getMessage());
                            });
                        }
                        break;
                    case 8:
                        sceneController.getScenesFromRepository().whenComplete((status, exception) -> {
                            if (exception == null)
                                System.out.println(status);
                            else System.out.println(exception.getMessage());
                        });
                        break;

                    case 9:
                        ScheduleDayDto newDay = inputScheduleDay();
                        if (newDay != null) {
                            scheduleDayController.addScheduleDay(newDay).whenComplete((status, exception) -> {
                                if (exception == null)
                                    System.out.println(status);
                                else System.out.println(exception.getMessage());
                            });
                        }
                        break;

                    case 10:
                        Long deleteId = inputDelete();
                        if (deleteId != null) {
                            scheduleDayController.deleteScheduleDay(deleteId).whenComplete((status, exception) -> {
                                if (exception == null)
                                    System.out.println(status);
                                else System.out.println(exception.getMessage());
                            });
                        }
                        break;
                    case 11:
                        Long dayId = inputDelete();
                        ScheduleDayDto updatedDay = inputScheduleDay();
                        if (updatedDay != null && dayId !=null) {
                            updatedDay.setId(dayId);
                            scheduleDayController.updateScheduleDay(updatedDay).whenComplete((status, exception) -> {
                                if (exception == null)
                                    System.out.println(status);
                                else System.out.println(exception.getMessage());
                            });
                        }
                        break;
                    case 12:
                        scheduleDayController.getScheduleDaysFromRepository().whenComplete((status, exception) -> {
                            if (exception == null)
                                System.out.println(status);
                            else System.out.println(exception.getMessage());
                        });
                        break;
                    case 13:
                        PerformanceDto newPerformance = inputPerformance();
                        if (newPerformance != null) {
                            performanceController.addPerformance(newPerformance).whenComplete((status, exception) -> {
                                if (exception == null)
                                    System.out.println(status);
                                else System.out.println(exception.getMessage());
                            });
                        }
                        break;
                    case 14:
                        Long deletePerformance = inputDelete();
                        if (deletePerformance != null) {
                            performanceController.deletePerformance(deletePerformance).whenComplete((status, exception) -> {
                                if (exception == null)
                                    System.out.println(status);
                                else System.out.println(exception.getMessage());
                            });
                        }
                        break;

                    case 15:
                        Long performanceId = inputDelete();
                        PerformanceDto updatedPerformance = inputPerformance();
                        if (updatedPerformance != null && performanceId!=null) {
                            updatedPerformance.setId(performanceId);
                            performanceController.updatePerformance(updatedPerformance).whenComplete((status, exception) -> {
                                if (exception == null)
                                    System.out.println(status);
                                else System.out.println(exception.getMessage());
                            });
                        }
                        break;

                    case 16:
                        performanceController.getPerformancesFromRepository().whenComplete((status, exception) -> {
                            if (exception == null)
                                System.out.println(status);
                            else System.out.println(exception.getMessage());
                        });
                        break;

                    case 17:
                        statistics();
                        break;
                    case 18:
                        artistController.getStat().whenComplete((status, exception) -> {
                            if (exception == null)
                                System.out.println(status);
                            else System.out.println(exception.getMessage());
                        });
                        break;

                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


    void statistics() throws ExecutionException, InterruptedException {
        ArtistDto currentArtist = null;

        Integer countMax = 0;

        Set<ArtistDto> artists = (Set<ArtistDto>) artistController.getArtistsFromRepository().get();

        Iterable<PerformanceDto> performances = performanceController.getPerformancesFromRepository().get();

        ObjectMapper mapper = new ObjectMapper();

        List<ArtistDto> artistList = mapper.convertValue(artists, new TypeReference<List<ArtistDto>>() {
        });
        List<PerformanceDto> performanceList = mapper.convertValue(performances, new TypeReference<List<PerformanceDto>>() {
        });
        for(ArtistDto artist : artistList)
        {
            Integer currentCount = 0;

            for(PerformanceDto performance: performanceList)
                if(performance.getArtistid() == artist.getId())
                {
                    currentCount++;
                }
            if(currentCount > countMax) {
                currentArtist = artist;
                countMax = currentCount;
            }

        }

        System.out.println("Most booked artist is " + currentArtist + " with " + countMax + " performances");


        Set<ScheduleDayDto> days = (Set<ScheduleDayDto>) scheduleDayController.getScheduleDaysFromRepository().get();
        List<ScheduleDayDto> dayList = mapper.convertValue(days, new TypeReference<List<ScheduleDayDto>>() {
        });

        ScheduleDayDto currentDay = null;
        countMax = 0;
        for(ScheduleDayDto day : dayList)
        {
            Integer currentCount = 0;

            for(PerformanceDto performance: performanceList)
                if(performance.getDayid() == day.getId())
                {
                    currentCount++;
                }
            if(currentCount > countMax) {
                currentDay = day;
                countMax = currentCount;
            }

        }

        System.out.println("The day with the most performances is " + currentDay + " with " + countMax + " performances");

        Set<SceneDto> scenes = (Set<SceneDto>) sceneController.getScenesFromRepository().get();
        List<SceneDto> sceneList = mapper.convertValue(scenes, new TypeReference<List<SceneDto>>() {
        });

        SceneDto currentScene = null;
        countMax = 0;
        for(SceneDto scene : sceneList)
        {
            Integer currentCount = 0;

            for(ScheduleDayDto day: dayList)
                if(day.getSceneid() == scene.getId())
                {
                    currentCount++;
                }
            if(currentCount > countMax) {
                currentScene =scene;
                countMax = currentCount;
            }

        }

        System.out.println("The scene with the most schedules is " + currentScene + " with " + countMax + " schedules");
    }


}