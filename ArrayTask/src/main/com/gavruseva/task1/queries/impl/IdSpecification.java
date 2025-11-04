package main.com.gavruseva.task1.queries.impl;

import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.queries.Specification;

public class IdSpecification implements Specification {
    private int id;
    public IdSpecification(int id) {
        this.id = id;
    }
    @Override
    public boolean specify(CustomArray array){
        return array.getId() == id;
    }
}
