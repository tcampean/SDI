package ui;

import Service.ClientService;
import domain.Artist;
import domain.Performance;
import domain.Scene;
import domain.ScheduleDay;
import utils.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Console {

    private ClientService clientService;

    public Console(ClientService c) {
        this.clientService = c;
    }


    public Artist inputArtist() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter artist ID: ");
        long id = -1L;
        try {
            id = Long.parseLong(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return null;
        } catch (IOException e) {
            return null;
        }
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

        return new Artist(id, name, date, genre);
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

    public Scene inputScene(){
    BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        System.out.println("Enter scene ID: ");
    Long id = -1L;
        try {
        id = Long.parseLong(reader.readLine());
    } catch (NumberFormatException e) {
        System.out.println("Invalid ID");
        return null;
    }
        catch (IOException e)
    {
        return null;
    }
        System.out.println("Enter scene name: ");
    String name;
        try
    {
        name = reader.readLine();
    }
        catch (IOException e)
    {
        return null;
    }

    return new Scene(id,name);
}

    public ScheduleDay inputScheduleDay() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter day ID: ");
        Long id = -1L;
        try {
            id = Long.parseLong(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return null;
        }
        catch (IOException e)
        {
            return null;
        }
        System.out.println("Enter scene ID: ");
        Long sceneId = -1L;
        try {
            sceneId = Long.parseLong(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return null;
        }
        catch (IOException e)
        {
            return null;
        }

        System.out.println("Enter event date: ");
        String date;
        try
        {
            date = reader.readLine();
        }
        catch (IOException e)
        {
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
        return new ScheduleDay(id,date,sceneId,nrOfParticipants);


    }

    public Performance inputPerformance()
    {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter ID: ");
        Long id = -1L;
        try {
            id = Long.parseLong(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return null;
        }
        catch (IOException e)
        {
            return null;
        }

        System.out.println("Enter schedule day ID: ");
        Long scheduleid = -1L;
        try {
            scheduleid = Long.parseLong(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return null;
        }
        catch (IOException e)
        {
            return null;
        }

        System.out.println("Enter srtist ID: ");
        Long artistid = -1L;
        try {
            artistid = Long.parseLong(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return null;
        }
        catch (IOException e)
        {
            return null;
        }

        System.out.println("Enter starting date: ");
        String startingdate;
        try
        {
            startingdate = reader.readLine();
        }
        catch (IOException e)
        {
            System.out.println("Invalid Date");
            return null;
        }

        System.out.println("Enter ending date: ");
        String endingdate;
        try
        {
            endingdate = reader.readLine();
        }
        catch (IOException e)
        {
            System.out.println("Invalid Date");
            return null;
        }

        return new Performance(id,startingdate,endingdate,scheduleid,artistid);


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
                        Artist newArtist = inputArtist();
                        if (newArtist != null) {
                            Future<String> resultFuture = clientService.addArtist(newArtist);


                            try {
                                String result = resultFuture.get();
                                System.out.println("***************");
                                System.out.println(result);
                                System.out.println("***************");
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 2:
                        Long id = inputDelete();

                        if (id != null) {
                            Future<String> resultFuture = clientService.deleteArtist(new Message("deleteArtist", "artist", id));


                            try {
                                String result = resultFuture.get();
                                System.out.println("***************");
                                System.out.println(result);
                                System.out.println("***************");
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 3:
                        Artist updatedArtist = inputArtist();
                        if (updatedArtist != null) {
                            Future<String> resultFuture = clientService.updateArtist(new Message("updateArtist", "artist", updatedArtist));

                            try {
                                String result = resultFuture.get();
                                System.out.println("***************");
                                System.out.println(result);
                                System.out.println("***************");
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }


                        }
                        break;
                    case 4:
                        Future<String> resultFuture1 = clientService.getArtists();
                        try {
                            System.out.println("***************");
                            System.out.println(resultFuture1.get());
                            System.out.println("***************");
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 5:
                        Scene newScene = inputScene();
                        if (newScene != null) {
                            Future<String> resultFuture = clientService.addScene(new Message("addScene", "artist", newScene));

                            try {
                                String result = resultFuture.get();
                                System.out.println("***************");
                                System.out.println(result);
                                System.out.println("***************");
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }


                        }
                        break;
                    case 6:
                        Long id1 = inputDelete();
                        if (id1 != null) {
                            Future<String> resultFuture = clientService.deleteScene(new Message("deleteScene", "scene", id1));

                            try {
                                String result = resultFuture.get();
                                System.out.println("***************");
                                System.out.println(result);
                                System.out.println("***************");
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }


                        }
                        break;
                    case 7:
                        Scene updatedScene = inputScene();
                        if (updatedScene != null) {
                            Future<String> resultFuture = clientService.updateScene(new Message("updateScene", "artist", updatedScene));

                            try {
                                String result = resultFuture.get();
                                System.out.println("***************");
                                System.out.println(result);
                                System.out.println("***************");
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }


                        }
                        break;
                    case 8:
                        Future<String> resultFuture2 = clientService.getScenes();
                        try {
                            System.out.println("***************");
                            System.out.println(resultFuture2.get());
                            System.out.println("***************");
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 9:
                        ScheduleDay newDay = inputScheduleDay();
                        if (newDay != null) {
                            Future<String> resultFuture = clientService.addScheduleDay(new Message("addScheduleDay", "artist", newDay));

                            try {
                                String result = resultFuture.get();
                                System.out.println("***************");
                                System.out.println(result);
                                System.out.println("***************");
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }


                        }
                        break;

                    case 10:
                        Long deleteId = inputDelete();
                        if (deleteId != null) {
                            Future<String> resultFuture = clientService.deleteScheduleDay(new Message("deleteScheduleDay", "artist", deleteId));

                            try {
                                String result = resultFuture.get();
                                System.out.println("***************");
                                System.out.println(result);
                                System.out.println("***************");
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }


                        }
                        break;
                    case 11:
                        ScheduleDay updatedDay = inputScheduleDay();
                        if (updatedDay != null) {
                            Future<String> resultFuture = clientService.updateScheduleDay(new Message("updateScheduleDay", "artist", updatedDay));

                            try {
                                String result = resultFuture.get();
                                System.out.println("***************");
                                System.out.println(result);
                                System.out.println("***************");
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }


                        }
                        break;
                    case 12:
                        Future<String> resultFuture3 = clientService.getScheduledDays();
                        try {
                            System.out.println("***************");
                            System.out.println(resultFuture3.get());
                            System.out.println("***************");
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 13:
                        Performance newPerformance = inputPerformance();
                        if (newPerformance != null) {
                            Future<String> resultFuture = clientService.addPerformance(new Message("addPerformance", "artist", newPerformance));

                            try {
                                String result = resultFuture.get();
                                System.out.println("***************");
                                System.out.println(result);
                                System.out.println("***************");
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }


                        }
                        break;
                    case 14:
                        Long deletePerformance = inputDelete();
                        if (deletePerformance != null) {
                            Future<String> resultFuture = clientService.deletePerformance(new Message("deletePerformance", "artist", deletePerformance));

                            try {
                                String result = resultFuture.get();
                                System.out.println("***************");
                                System.out.println(result);
                                System.out.println("***************");
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }


                        }
                        break;

                    case 15:
                        Performance updatedPerformance = inputPerformance();
                        if (updatedPerformance != null) {
                            Future<String> resultFuture = clientService.updatePerformance(new Message("updatePerformance", "artist", updatedPerformance));

                            try {
                                String result = resultFuture.get();
                                System.out.println("***************");
                                System.out.println(result);
                                System.out.println("***************");
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }


                        }
                        break;

                    case 16:
                        Future<String> resultFuture4 = clientService.getPerformances();
                        try {
                            System.out.println("***************");
                            System.out.println(resultFuture4.get());
                            System.out.println("***************");
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                        break;



                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


        }
    }
}
