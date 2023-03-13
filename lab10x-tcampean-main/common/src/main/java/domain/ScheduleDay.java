package domain;

import java.io.Serializable;

public class ScheduleDay extends BaseEntity<Long> implements Serializable {
    private String date;
    private long sceneId;
    private Integer nrOfParticipants;

    public ScheduleDay(Long _id, String date, Long scene,Integer nrOfParticipants) {
        id = _id;
        this.date = date;
        this.sceneId = scene;
        this.nrOfParticipants = nrOfParticipants;
    }

    public ScheduleDay() {
    }

    public String getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getSceneId() {
        return sceneId;
    }

    public void setSceneId(Long sceneId){
        this.sceneId = sceneId;
    }

    public Integer getNrOfParticipants() {
        return nrOfParticipants;
    }

    public void setNrOfParticipants(Integer nrOfParticipants){
        this.nrOfParticipants = nrOfParticipants;
    }

    @Override
    public String toString() {
        return "ScheduleDay{" +
                "id=" + id +
                ", date=" + date +
                ", scenes=" + sceneId +
                ", nrOfParticipants=" + nrOfParticipants +
                '}';
    }
}