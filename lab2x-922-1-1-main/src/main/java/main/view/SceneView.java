package main.view;

import main.controller.SceneController;
import main.domain.Scene;

public class SceneView {
    public SceneController controller;

    public SceneView(SceneController controller) {
        this.controller = controller;
    }

    public void add_scene() {
        java.io.Console cin = System.console();
        System.out.println("Enter scene ID: ");
        Long id = -1L;
        try {
            id = Long.parseLong(cin.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return;
        }
        System.out.println("Enter scene name: ");
        String name = cin.readLine();
        controller.addScene(new Scene(id, name));
    }

    public void print_all_scenes() {
        controller.findAll().forEach(System.out::println);
    }
}
