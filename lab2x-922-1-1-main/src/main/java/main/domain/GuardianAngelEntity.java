package main.domain;

import java.util.function.IntToLongFunction;

public class GuardianAngelEntity extends BaseEntity<Long>{
    private String name, gender, occupation;
    private int Age;
    private Long ArtistID;

    public GuardianAngelEntity (){
        this.id = 0L;
        this.name = "";
        this.gender = "";
        this.occupation = "";
        this.Age = 0;
        this.ArtistID = 0L;
    }

    public GuardianAngelEntity(Long id, String name, String gender, int Age, String occupation, Long ArtistID){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.Age = Age;
        this.occupation = occupation;
        this.ArtistID = ArtistID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Long getArtistID() {
        return ArtistID;
    }

    public void setArtistID(Long artistID) {
        ArtistID = artistID;
    }

    @Override
    public String toString() {
        String s = "";
        s = s + "ID: " + this.getId() + "\n";
        s = s + "Name: " + this.getName() + "\n";
        s = s + "Gender: " + this.getGender() + "\n";
        s = s + "Age: " + this.getAge() + "\n";
        s = s + "Occupation: " + this.getOccupation() + "\n";
        s = s + "Artist ID: " + this.getArtistID() + "\n";
        return s;
    }
}
