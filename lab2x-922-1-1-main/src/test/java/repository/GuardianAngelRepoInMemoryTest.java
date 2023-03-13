package repository;

import jdk.nashorn.internal.ir.annotations.Ignore;
import main.domain.GuardianAngelEntity;
import main.domain.validators.GuardianAngelValidator;
import main.domain.validators.ValidatorException;
import main.repository.GuardianAngelRepoInMemory;
import main.repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

class GuardianAngelRepoInMemoryTest {

    Repository<Long, GuardianAngelEntity> repo;
    GuardianAngelEntity elem1 = new GuardianAngelEntity(1L, "Gigel", "baiat", 18, "pierdevara", 12L);
    GuardianAngelEntity elem2 = new GuardianAngelEntity(2L, "Ionica", "baiat", 18, "pierdevara", 11L);

    @BeforeEach
    public void SetUp(){
        repo = new GuardianAngelRepoInMemory(new GuardianAngelValidator());
        repo.save(elem1);
        repo.save(elem2);
    }

    @Test
    public void testFindOne() throws Exception {
        assertEquals(elem1, repo.findOne(1L).get());
        assertEquals(elem2, repo.findOne(2L).get());
    }

    @Test
    public void testFindAll() throws Exception {
        repo = new GuardianAngelRepoInMemory(new GuardianAngelValidator());
        repo.save(elem1);
        repo.save(elem2);
        assertArrayEquals(new GuardianAngelEntity[]{elem1, elem2}, StreamSupport.stream(repo.findAll().spliterator(), false).toArray());
    }

    @Test
    public void testSave() throws Exception {
        long size = StreamSupport.stream(repo.findAll().spliterator(), false).count();
        assertEquals(2L, size);

    }

    @Ignore
    @Test
    public void testDelete() throws Exception {
        repo.delete(1L);
        long size = StreamSupport.stream(repo.findAll().spliterator(), false).count();
        assertEquals(1L, size);
        repo.findOne(1L).ifPresent(s -> assertEquals(elem2, s));
    }

    @Test
    public void testUpdate() throws Exception {
        GuardianAngelEntity elem3 = new GuardianAngelEntity(1L, "Ionica", "baiat", 18, "pierdevara", 11L);
        repo.update(elem3);
        assertEquals(elem3, repo.findOne(1L).get());
    }
}