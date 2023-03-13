package main.repository;

import main.domain.ScheduleDay;
import main.domain.validators.Validator;

import java.net.IDN;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ScheduleDayRepository implements  Repository<Long, ScheduleDay> {
    Map<Long, ScheduleDay> scheduleDays;
    Validator<ScheduleDay> validator;

    public ScheduleDayRepository(Validator<ScheduleDay> validator) {
        this.validator = validator;
        scheduleDays = new HashMap<>();
    }

    @Override
    public Optional<ScheduleDay> findOne(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Iterable<ScheduleDay> findAll() {
        return scheduleDays.values().stream().collect(Collectors.toSet());
    }

    @Override
    public Optional<ScheduleDay> save(ScheduleDay entity) {
        Optional.ofNullable(entity).orElseThrow(() -> new IllegalArgumentException("entity must not be null"));
        validator.validate(entity);
        return Optional.ofNullable(scheduleDays.putIfAbsent(entity.getId(), entity));
    }

    @Override
    public Optional<ScheduleDay> delete(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<ScheduleDay> update(ScheduleDay entity) {
        return Optional.empty();
    }
}
