package edu.au.javacourse.tasks.lecture11.homework;

public class Gene {
    @Serialize
    private String id;
    @Serialize
    private String name;
    private int frequency;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Gene(String id, String name, int frequency) {
        setId(id);
        setName(name);
        setFrequency(frequency);
    }
}
