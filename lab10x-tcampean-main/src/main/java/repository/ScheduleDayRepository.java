package repository;

import domain.Scene;
import domain.ScheduleDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.Optional;

public class ScheduleDayRepository implements Repository<Long, ScheduleDay> {
    @Autowired
    private JdbcOperations jdbcOperations;

    public ScheduleDayRepository() {
        super();
    }
    @Override
    public Optional<ScheduleDay> findOne(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Iterable<ScheduleDay> findAll() {
        String sql = "SELECT * FROM scheduleday";
        return jdbcOperations.query(sql, (rs, i) -> {
            Long id = rs.getLong("id");
            Long sceneId = rs.getLong("sceneid");
            String date = rs.getString("date");
            Integer nrofparticipants = rs.getInt("nrofparticipants");
            return new ScheduleDay(id,date,sceneId,nrofparticipants);
        });
    }

    @Override
    public Optional<ScheduleDay> save(ScheduleDay entity) {
        String sql = "INSERT INTO scheduleday (date,sceneid,nrofparticipants) VALUES(?)";
        jdbcOperations.update(sql,entity.getDate(),entity.getSceneId(),entity.getNrOfParticipants());
        return Optional.empty();
    }

    @Override
    public Optional<ScheduleDay> delete(Long aLong) {
        String sql = "DELETE FROM scheduleday WHERE id=?";
        jdbcOperations.update(sql,aLong);
        return Optional.empty();
    }

    @Override
    public Optional<ScheduleDay> update(ScheduleDay entity) {
        String sql = "UPDATE scheduleday SET date=?, sceneid=?, nrofparticipants=? WHERE id=?";
        jdbcOperations.update(sql,entity.getDate(),entity.getSceneId(),entity.getNrOfParticipants(),entity.getId());
        return Optional.empty();
    }
}
