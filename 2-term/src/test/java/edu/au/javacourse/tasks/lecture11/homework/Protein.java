package edu.au.javacourse.tasks.lecture11.homework;

import java.util.Arrays;

public class Protein {
    @Serialize
    private String name;
    @Serialize
    private int structure;
    private String aminoAcids;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAminoAcids() {
        return aminoAcids;
    }

    public void setAminoAcids(String[] aminoAcids) {
        this.aminoAcids = Arrays.toString(aminoAcids);
    }

    public int getStructure() {
        return structure;
    }

    public void setStructure(int structure) {
        this.structure = structure;
    }

    public Protein(String name, String[] aminoAcids, int structure) {
        setName(name);
        setAminoAcids(aminoAcids);
        setStructure(structure);
    }
}
