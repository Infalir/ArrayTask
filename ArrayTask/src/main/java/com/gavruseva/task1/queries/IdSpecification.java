package com.gavruseva.task1.queries;

import com.gavruseva.task1.entity.CustomArray;

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
