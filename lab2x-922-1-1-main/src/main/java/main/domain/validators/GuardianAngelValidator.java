package main.domain.validators;

import main.domain.GuardianAngelEntity;

public class GuardianAngelValidator implements Validator<GuardianAngelEntity> {
    @Override
    public void validate(GuardianAngelEntity guardian) throws ValidatorException {
        if (guardian.getId() == null )
            throw new ValidatorException("Id can not be null!");
        if (guardian.getName().isEmpty())
            throw new ValidatorException("GuardianAngel " + guardian.getId().toString() + " has an empty Name");
        if (guardian.getArtistID() == null)
            throw new ValidatorException("Artist Id can not be null!");
        if (guardian.getOccupation().isEmpty())
            throw new ValidatorException("GuardianAngel " + guardian.getId().toString() + " has an empty Occupation");
        if (guardian.getAge() < 0)
            throw new ValidatorException("GuardianAngel " + guardian.getId().toString() + " is not alive");
        if (guardian.getGender().isEmpty())
            throw new ValidatorException("GuardianAngel " + guardian.getId().toString() + " does not have a gender");
    }
}
