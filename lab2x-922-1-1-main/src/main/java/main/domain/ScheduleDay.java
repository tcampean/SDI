package main.domain;

import java.util.Date;

public class ScheduleDay extends BaseEntity<Long>{
    private Date date;
    private Scene scene;
    private Integer nrOfParticipants;

    public ScheduleDay(Date date, Scene scene, Integer nrOfParticipants) {
        this.date = date;
        this.scene = scene;
        this.nrOfParticipants = nrOfParticipants;
    }

    public Date getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Integer getNrOfParticipants() {
        return nrOfParticipants;
    }

    public void setNrOfParticipants(Integer nrOfParticipants) {
        this.nrOfParticipants = nrOfParticipants;
    }
}
