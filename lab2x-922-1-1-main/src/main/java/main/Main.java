package main;

import main.controller.SceneController;
import main.domain.Scene;
import main.domain.validators.SceneValidator;
import main.repository.Repository;
import main.repository.SceneRepoInMemory;
import main.view.SceneView;

public class Main {

    public static void main(String[] args) {
        Repository repo = new SceneRepoInMemory(new SceneValidator());
        SceneController ctrl = new SceneController((SceneRepoInMemory) repo);
        SceneView view = new SceneView(ctrl);
//        view.add_scene();
        Scene s1 = new Scene(1L, "Scene1");
        Scene s2 = new Scene(2L, "Scene2");

        ctrl.addScene(s1);
        ctrl.addScene(s2);
        view.print_all_scenes();

        //System.out.println("Hello World!");
    }
}
