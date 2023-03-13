package main.repository;

import main.domain.GuardianAngelEntity;
import main.domain.validators.Validator;
import main.domain.validators.ValidatorException;
import main.repository.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GuardianAngelRepoInMemory implements Repository<Long, GuardianAngelEntity> {
    private Map<Long, GuardianAngelEntity> entities;
    private Validator<GuardianAngelEntity> validator;

    public GuardianAngelRepoInMemory(Validator<GuardianAngelEntity> validator) {
        this.validator = validator;
        entities = new HashMap<>();
    }

    public void add(GuardianAngelEntity elem){
        entities.put(elem.getId(), elem);
    }

    @Override
    public Optional<GuardianAngelEntity> findOne(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        return Optional.ofNullable(entities.get(id));
    }

    @Override
    public Iterable<GuardianAngelEntity> findAll() {
        return entities.values().stream().collect(Collectors.toSet());
    }

    @Override
    public Optional<GuardianAngelEntity> save(GuardianAngelEntity entity) throws ValidatorException {
        if (entity == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        validator.validate(entity);
        return Optional.ofNullable(entities.putIfAbsent(entity.getId(), entity));
    }

    @Override
    public Optional<GuardianAngelEntity> delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        return Optional.ofNullable(entities.remove(id));
    }

    @Override
    public Optional<GuardianAngelEntity> update(GuardianAngelEntity entity) throws ValidatorException {
        if (entity == null) {
            throw new IllegalArgumentException("entity must not be null");
        }
        validator.validate(entity);
        return Optional.ofNullable(entities.computeIfPresent(entity.getId(), (k, v) -> entity));
    }
}
