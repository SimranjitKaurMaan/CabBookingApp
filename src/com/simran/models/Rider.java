package com.simran.models;

public class Rider
{
    private String Id;
    private String Name;

    public Rider(String id, String name) {
        this.Id = id;
        this.Name = name;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

}
