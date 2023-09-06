package edu.au.javacourse.tasks.lecture11.homework;


public class Test {
    @org.junit.jupiter.api.Test
    void test() throws IllegalAccessException {
        Serializer mySerializer = new Serializer();
        Gene gene1 = new Gene("human123", "TP53", 12345);
        Gene gene2 = new Gene("human78", "AKT1", 566765);
        Protein protein1 = new Protein("collagen",
                new String[]{"G", "3-hydroxyproline", "4-hydroxyproline", "5-hydroxylysine"},
                1);

        mySerializer.serialize(gene1);
        mySerializer.serialize(gene2);
        mySerializer.serialize(protein1);
    }
}
