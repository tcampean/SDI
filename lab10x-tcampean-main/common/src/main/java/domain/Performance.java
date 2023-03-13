package domain;

import java.io.Serializable;

public class Performance extends BaseEntity<Long> implements Serializable {
    private String StartingTime;
    private String EndingTime;
    private Long ScheduleDay;
    private Long artistID;

    public Performance() {
    }

    public Performance(Long _id,String startingTime, String endingTime, Long scheduleDay, Long artistID) {
        id = _id;

        this.StartingTime = startingTime;
        this.EndingTime = endingTime;
        this.ScheduleDay = scheduleDay;
        this.artistID = artistID;
    }

    public String getStartingTime() {
        return StartingTime;
    }

    public void setStartingTime(String startingTime){
        this.StartingTime = startingTime;
    }

    public String getEndingTime() {
        return EndingTime;
    }

    public void setEndingTime(String endingTime) {
        this.EndingTime = endingTime;
    }

    public Long getScheduleDay() {
        return ScheduleDay;
    }

    public void setScheduleDay(Long scheduleDay) {
        this.ScheduleDay = scheduleDay;
    }

    public Long getArtistID()
    {
        return this.artistID;
    }

    public void setArtistID(Long id)
    {
        this.artistID = id;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "id =" + id +
                "Starting Time =" + this.StartingTime +
                "Ending Time=" + this.EndingTime +
                "Schedule Day = " + this.ScheduleDay.toString() +
                "Artist id+ " + this.artistID+
                '}';
    }
}