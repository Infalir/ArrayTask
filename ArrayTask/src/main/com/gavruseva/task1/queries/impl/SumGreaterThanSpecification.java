package main.com.gavruseva.task1.queries.impl;

import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.queries.Specification;

public class SumGreaterThanSpecification implements Specification {
    private int sum;
    public SumGreaterThanSpecification(int sum) {
        this.sum = sum;
    }
    @Override
    public boolean specify(CustomArray array){
        int calculatedSum = 0;
        int[] tempArray =  array.getArray();
        for (int el: tempArray) {
            calculatedSum += el;
        }
        return calculatedSum > sum;
    }
}
