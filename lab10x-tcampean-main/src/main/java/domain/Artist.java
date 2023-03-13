package domain;

import java.io.Serializable;

public class Artist extends BaseEntity<Long> implements Serializable {
    private String name;
    private String DateOfBirth;
    private String MusicalGenre;

    public Artist(Long id, String name, String dateOfBirth, String musicalGenre){
        this.id = id;
        this.name = name;
        this.DateOfBirth = dateOfBirth;
        this.MusicalGenre = musicalGenre;
    }

    public Artist() {
        this.id = 0L;
        this.name = "";
        this.DateOfBirth = "";
        this.MusicalGenre = "";
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", MusicalGenre='" + MusicalGenre + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getMusicalGenre() {
        return MusicalGenre;
    }

    public void setMusicalGenre(String musicalGenre) {
        MusicalGenre = musicalGenre;
    }
}