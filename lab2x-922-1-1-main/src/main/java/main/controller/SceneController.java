package main.controller;

import main.domain.Scene;
import main.domain.validators.SceneValidator;
import main.repository.SceneRepoInMemory;

public class SceneController {
    public SceneRepoInMemory repo;

    public SceneController(SceneRepoInMemory _repo) {
        repo = _repo;
    }

    public SceneController() {
        repo = new SceneRepoInMemory(new SceneValidator());
    }

    public void addScene(Scene s) {
        repo.save(s);
    }

    public Iterable<Scene> findAll() {
        return repo.findAll();
    }

}
