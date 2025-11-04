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
    public void setSum(int sum) {
        this.sum = sum;
    }
    public double getAvg() {
        return avg;
    }
    public void setAvg(double avg) {
        this.avg = avg;
    }
    public int getMax() {
        return max;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public int getMin() {
        return min;
    }
    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayData data = (ArrayData) o;
        return data.getAvg() == this.getAvg() && data.getMax() == this.getMax()
                && data.getMin() == this.getMin() && data.getSum() == this.getSum();
    }
}
