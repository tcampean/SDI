package main.repository;

import main.domain.BaseEntity;
import main.domain.Scene;
import main.domain.validators.Validator;
import main.domain.validators.ValidatorException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class SceneRepoInMemory implements Repository<Long, Scene> {

    private Map<Long, Scene> entities;
    private Validator<Scene> validator;

    public SceneRepoInMemory(Validator<Scene> validator) {
        this.validator = validator;
        entities = new HashMap<>();
    }

    @Override
    public Optional<Scene> findOne(Long id) {
        Optional.ofNullable(id).orElseThrow(() -> new IllegalArgumentException("entity must not be null"));
        return Optional.ofNullable(entities.get(id));
    }

    @Override
    public Iterable<Scene> findAll() {
        return entities.values().stream().collect(Collectors.toSet());
    }

    @Override
    public Optional<Scene> save(Scene entity) throws ValidatorException {
        Optional.ofNullable(entity).orElseThrow(() -> new IllegalArgumentException("entity must not be null"));
        validator.validate(entity);
        return Optional.ofNullable(entities.putIfAbsent(entity.getId(), entity));
    }

    @Override
    public Optional<Scene> delete(Long id) {
        Optional.ofNullable(id).orElseThrow(() -> new IllegalArgumentException("entity must not be null"));
        return Optional.ofNullable(entities.remove(id));
    }

    @Override
    public Optional<Scene> update(Scene entity) throws ValidatorException {
        Optional<Scene> e = Optional.ofNullable(entity);
        e.orElseThrow(() -> new IllegalArgumentException("entity must not be null"));
        validator.validate(entity);
        return Optional.ofNullable(entities.computeIfPresent(entity.getId(), (k, v) -> entity));
    }
}

