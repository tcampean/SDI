package repository;

import main.domain.Scene;
import main.domain.validators.SceneValidator;
import main.domain.validators.ValidatorException;
import main.repository.Repository;
import main.repository.SceneRepoInMemory;
import org.junit.jupiter.api.Test;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SceneInMemoryRepositoryTest {

    @Test
    public void testFindOne() throws Exception {
        Repository<Long, Scene> repo = new SceneRepoInMemory(new SceneValidator());
        Scene s1 = new Scene(1L, "Scene1");
        Scene s2 = new Scene(2L, "Scene2");
        repo.save(s1);
        repo.save(s2);
        assertEquals(s1, repo.findOne(1L).get());
        assertEquals(s2, repo.findOne(2L).get());
    }

    @Test
    public void testFindAll() throws Exception {
        Repository<Long, Scene> repo = new SceneRepoInMemory(new SceneValidator());
        Scene s1 = new Scene(1L, "Scene1");
        Scene s2 = new Scene(2L, "Scene2");
        repo.save(s1);
        repo.save(s2);

        assertArrayEquals(new Scene[]{s1, s2}, StreamSupport.stream(repo.findAll().spliterator(), false).toArray());
    }

    @Test
    public void testSave() throws Exception {
        Repository<Long, Scene> repo = new SceneRepoInMemory(new SceneValidator());
        Scene s1 = new Scene(1L, "Scene1");
        Scene s2 = new Scene(2L, "Scene2");
        repo.save(s1);
        repo.save(s2);
        long size = StreamSupport.stream(repo.findAll().spliterator(), false).count();
        assertEquals(2L, size);

    }


    @Test(expected = ValidatorException.class)
    public void testSaveException() throws Exception {
        Repository<Long, Scene> repo = new SceneRepoInMemory(new SceneValidator());
        Scene s1 = new Scene(1L, "");
        repo.save(s1);
    }


    @Test
    public void testDelete() throws Exception {
        Repository<Long, Scene> repo = new SceneRepoInMemory(new SceneValidator());
        Scene s1 = new Scene(1L, "Scene1");
        Scene s2 = new Scene(2L, "Scene2");

        repo.save(s1);
        repo.save(s2);
        repo.delete(1L);
        long size = StreamSupport.stream(repo.findAll().spliterator(), false).count();
        assertEquals(1L, size);
        repo.findOne(1L).ifPresent(s -> assertEquals(s2, s));
    }

    @Test
    public void testUpdate() throws Exception {
        Repository<Long, Scene> repo = new SceneRepoInMemory(new SceneValidator());
        Scene s1 = new Scene(1L, "Scene1");
        Scene s2 = new Scene(2L, "Scene2");
        Scene s3 = new Scene(1L, "Scene1Updated");
        repo.save(s1);
        repo.save(s2);
        repo.update(s3);
        assertEquals(s3, repo.findOne(1L).get());
    }


    @Test(expected = ValidatorException.class)
    public void testUpdateException() throws Exception {
        Repository<Long, Scene> repo = new SceneRepoInMemory(new SceneValidator());
        Scene s1 = new Scene(null, "Scene1");
        repo.update(s1);
    }

}
