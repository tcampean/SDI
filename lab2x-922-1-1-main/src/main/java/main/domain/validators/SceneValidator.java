package main.domain.validators;

import main.domain.Scene;

import java.util.Optional;

public class SceneValidator implements Validator<Scene> {
    @Override
    public void validate(Scene scene) throws ValidatorException {
        Optional.ofNullable(scene.getId()).orElseThrow(() -> new ValidatorException("Id-ul nu poate fi null!"));
        Optional.ofNullable(scene.getSceneName()).filter(x-> !x.equals("")).orElseThrow(() -> new ValidatorException("Numele nu poate fi null!"));
        Optional.of(scene.getSceneName().isEmpty()).filter(x-> x).ifPresent(x-> {throw new ValidatorException("Numele nu poate fi gol!");});
    }

}
