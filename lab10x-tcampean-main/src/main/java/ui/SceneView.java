package ui;

import Service.Service;
import domain.Scene;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SceneView {
    public Service controller;

    public SceneView(Service service) {
        this.controller = service;
    }

    public void add_scene() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter scene ID: ");
        Long id = -1L;
        try {
            id = Long.parseLong(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return;
        }
        catch (IOException e)
        {
            return;
        }
        System.out.println("Enter scene name: ");
        String name;
        try
        {
            name = reader.readLine();
        }
        catch (IOException e)
        {
            return;
        }

        controller.addScene(new Scene(id, name));


    }

    public void update_scene() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter scene ID: ");
        Long id = -1L;
        try {
            id = Long.parseLong(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return;
        }
        catch (IOException e)
        {
            return;
        }
        System.out.println("Enter scene name: ");
        String name;
        try
        {
            name = reader.readLine();
        }
        catch (IOException e)
        {
            return;
        }

            controller.updateScene(new Scene(id, name));

    }



    public void print_all_scenes() {
        controller.getScenes().forEach(System.out::println);
    }
    public void printMenu() {
        System.out.println("1. Add scene");
        System.out.println("2. Update scene");
        System.out.println("3. Find one scene");
        System.out.println("4. Print all scenes");
        System.out.println("5. Exit");
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
                        this.add_scene();
                        break;
                    case 2:
                        this.update_scene();
                        break;
                    case 3:
                        break;
                    case 4:
                        this.print_all_scenes();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}

