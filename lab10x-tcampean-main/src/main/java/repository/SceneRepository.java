package repository;

import domain.Artist;
import domain.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.Optional;

public class SceneRepository implements Repository<Long, Scene> {

    @Autowired
    private JdbcOperations jdbcOperations;

    public SceneRepository() {
        super();
    }
    @Override
    public Optional<Scene> findOne(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Iterable<Scene> findAll() {
        String sql = "SELECT * FROM scene";
        return jdbcOperations.query(sql, (rs, i) -> {
            Long id = rs.getLong("id");
            String scenename = rs.getString("scenename");
            return new Scene(id,scenename);
        });
    }

    @Override
    public Optional<Scene> save(Scene entity) {
        String sql = "INSERT INTO scene (scenename) VALUES(?)";
        jdbcOperations.update(sql,entity.getSceneName());
        return Optional.empty();
    }

    @Override
    public Optional<Scene> delete(Long aLong) {
        String sql = "DELETE FROM scene WHERE id=?";
        jdbcOperations.update(sql,aLong);
        return Optional.empty();
    }

    @Override
    public Optional<Scene> update(Scene entity) {
        String sql = "UPDATE scene SET scenename=? WHERE id=?";
        jdbcOperations.update(sql,entity.getSceneName(),entity.getId());
        return Optional.empty();
    }
}
