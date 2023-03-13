package main.domain.validators;

import main.domain.ScheduleDay;

import java.util.Optional;

public class ScheduleDayValidator implements Validator<ScheduleDay>{
    @Override
    public void validate(ScheduleDay entity) throws ValidatorException {
        Optional.ofNullable(entity.getId()).orElseThrow(() -> new ValidatorException("Id can't be null"));
        if (entity.getNrOfParticipants() < 0) {
            throw new ValidatorException("Number of participants must be positive");
        }

    }
}
