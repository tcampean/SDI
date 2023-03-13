package domain;

import main.domain.GuardianAngelEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.Guard;

import static org.junit.jupiter.api.Assertions.*;

class GuardianAngelEntityTest {

    @Test
    void getName() {
        GuardianAngelEntity elem = new GuardianAngelEntity();
        assertEquals("", elem.getName());
        elem = new GuardianAngelEntity(1L, "Gigel", "baiat", 18, "pierdevara", 12L);
        assertEquals("Gigel", elem.getName());
    }

    @Test
    void setName() {
        GuardianAngelEntity elem = new GuardianAngelEntity();
        elem.setName("Ionica");
        assertEquals("Ionica", elem.getName());
        elem = new GuardianAngelEntity(1L, "Gigel", "baiat", 18, "pierdevara", 12L);
        elem.setName("");
        assertEquals("", elem.getName());
    }

    @Test
    void getGender() {
        GuardianAngelEntity elem = new GuardianAngelEntity();
        assertEquals("", elem.getGender());
        elem = new GuardianAngelEntity(1L, "Gigel", "baiat", 18, "pierdevara", 12L);
        assertEquals("baiat", elem.getGender());
    }

    @Test
    void setGender() {
        GuardianAngelEntity elem = new GuardianAngelEntity();
        elem.setGender("fata");
        assertEquals("fata", elem.getGender());
        elem = new GuardianAngelEntity(1L, "Gigel", "baiat", 18, "pierdevara", 12L);
        elem.setGender("");
        assertEquals("", elem.getGender());
    }

    @Test
    void getOccupation() {
        GuardianAngelEntity elem = new GuardianAngelEntity();
        assertEquals("", elem.getOccupation());
        elem = new GuardianAngelEntity(1L, "Gigel", "baiat", 18, "pierdevara", 12L);
        assertEquals("pierdevara", elem.getOccupation());
    }

    @Test
    void setOccupation() {
        GuardianAngelEntity elem = new GuardianAngelEntity();
        elem.setOccupation("lenes");
        assertEquals("lenes", elem.getOccupation());
        elem = new GuardianAngelEntity(1L, "Gigel", "baiat", 18, "pierdevara", 12L);
        elem.setOccupation("");
        assertEquals("", elem.getOccupation());
    }

    @Test
    void getAge() {
        GuardianAngelEntity elem = new GuardianAngelEntity();
        assertEquals(0, elem.getAge());
        elem = new GuardianAngelEntity(1L, "Gigel", "baiat", 18, "pierdevara", 12L);
        assertEquals(18, elem.getAge());
    }

    @Test
    void setAge() {
        GuardianAngelEntity elem = new GuardianAngelEntity();
        elem.setAge(2);
        assertEquals(2, elem.getAge());
        elem = new GuardianAngelEntity(1L, "Gigel", "baiat", 18, "pierdevara", 12L);
        elem.setAge(2);
        assertEquals(2, elem.getAge());
    }

    @Test
    void getArtistID() {
        GuardianAngelEntity elem = new GuardianAngelEntity();
        assertEquals(0, elem.getArtistID());
        elem = new GuardianAngelEntity(1L, "Gigel", "baiat", 18, "pierdevara", 12L);
        assertEquals(12L, elem.getArtistID());
    }

    @Test
    void setArtistID() {
        GuardianAngelEntity elem = new GuardianAngelEntity();
        elem.setArtistID(2L);
        assertEquals(2L, elem.getArtistID());
        elem = new GuardianAngelEntity(1L, "Gigel", "baiat", 18, "pierdevara", 12L);
        elem.setArtistID(2L);
        assertEquals(2L, elem.getArtistID());
    }

    @Test
    void testToString() {
        GuardianAngelEntity elem = new  GuardianAngelEntity(1L, "Gigel", "baiat", 18, "pierdevara", 12L);
//        System.out.println(elem);
        String output = elem.toString();
        String expected = "ID: 1\nName: Gigel\nGender: baiat\nAge: 18\nOccupation: pierdevara\nArtist ID: 12\n";
        assertEquals(expected, output);
    }
}