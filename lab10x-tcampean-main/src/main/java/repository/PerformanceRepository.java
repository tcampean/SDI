package repository;

import domain.Performance;
import domain.ScheduleDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.Optional;

public class PerformanceRepository implements Repository<Long, Performance> {

    @Autowired
    private JdbcOperations jdbcOperations;

    public PerformanceRepository() {
        super();
    }
    @Override
    public Optional<Performance> findOne(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Iterable<Performance> findAll() {
        String sql = "SELECT * FROM performance";
        return jdbcOperations.query(sql, (rs, i) -> {
            Long id = rs.getLong("id");
            Long scheduleId = rs.getLong("scheduledayid");
            Long artistId = rs.getLong("artistid");
            String start = rs.getString("startingtime");
            String end = rs.getString("endingtime");
            return new Performance(id,start,end,scheduleId,artistId);
        });
    }

    @Override
    public Optional<Performance> save(Performance entity) {
        String sql = "INSERT INTO performance (startingtime,endingtime,scheduledayid,artistid) VALUES(?,?,?,?)";
        jdbcOperations.update(sql,entity.getStartingTime(),entity.getEndingTime(),entity.getScheduleDay(),entity.getArtistID());
        return Optional.empty();
    }

    @Override
    public Optional<Performance> delete(Long aLong) {
        String sql = "DELETE FROM performance WHERE id=?";
        jdbcOperations.update(sql,aLong);
        return Optional.empty();
    }

    @Override
    public Optional<Performance> update(Performance entity) {
        String sql = "UPDATE Performance SET startingtime=?, endingtime=?, scheduledayid=?, artistid=? WHERE id=?";
        jdbcOperations.update(sql,entity.getStartingTime(),entity.getEndingTime(),entity.getScheduleDay(),entity.getArtistID(),entity.getId());
        return Optional.empty();
    }
}
