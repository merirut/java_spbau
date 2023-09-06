package edu.au.javacourse.tasks.lecture12.classwork;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilteringContainer<T> {
    private List<T> items;
    private Predicate<T> filter;
    private Consumer<T> rejecter;


    public FilteringContainer(Predicate<T> filter, Consumer<T> rejecter) {
        this.filter = filter;
        this.rejecter = rejecter;
        this.items = new ArrayList<T>();
    }

    void Add(T item) {
        if (filter.test(item)) {this.items.add(item);}
        else {this.rejecter.accept(item);}
    }
    
    List<T> getItems() {
        return this.items;
    }
}
