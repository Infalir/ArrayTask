package main.com.gavruseva.task1.data;


public class ArrayData {
    private int sum;
    private double avg;
    private int max;
    private int min;

    public ArrayData(int sum, double avg, int max, int min) {
        this.sum = sum;
        this.avg = avg;
        this.max = max;
        this.min = min;
    }

    public int getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}
