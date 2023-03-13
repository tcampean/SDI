package repository;

import domain.Artist;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

public class ArtistRepository implements Repository<Long, Artist> {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public Optional<Artist> findOne(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Iterable<Artist> findAll() {
        String sql = "SELECT * FROM artist";
        return jdbcOperations.query(sql, (rs, i) -> {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            String dateofbirth = rs.getString("dateofbirth");
            String genre = rs.getString("genre");
            return new Artist(id,name,dateofbirth,genre);
        });
    }

    @Override
    public Optional<Artist> save(Artist entity) {

        try {
            String sql = "INSERT INTO artist (name,dateofbirth,genre) VALUES(?,?,?)";
            jdbcOperations.update(sql, entity.getName(), entity.getDateOfBirth(), entity.getMusicalGenre());
            return Optional.empty();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Artist> delete(Long aLong) {
        String sql = "DELETE FROM artist WHERE id=?";
        jdbcOperations.update(sql,aLong);
        return Optional.empty();
    }

    @Override
    public Optional<Artist> update(Artist entity) {
        String sql = "UPDATE artist SET name=?, dateofbirth=?, genre=? WHERE id=?";
        jdbcOperations.update(sql,entity.getName(),entity.getDateOfBirth(),entity.getMusicalGenre(),entity.getId());
        return Optional.empty();
    }
}
