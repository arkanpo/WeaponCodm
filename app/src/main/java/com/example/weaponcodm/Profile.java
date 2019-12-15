package com.example.weaponcodm;

public class Profile {

    String nama,level,image,type;

    public Profile() {
    }

    public Profile(String nama, String level, String image, String type) {
        this.nama = nama;
        this.level = level;
        this.image = image;
        this.image = type;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
