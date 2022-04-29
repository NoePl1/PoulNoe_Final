package Skeleton;

public class AverageStatistic extends Statistic {

    public AverageStatistic(String name) {
        super(name);
    }

    @Override
    public float summarize() {
        float sum = 0;
        int div = 0;
        for (Object i : this) {
            sum += (int) i;
            div++;
        }

        if (div > 0)
            return sum / div;
        else
            return sum;
    }

    @Override
    public void printStatistic() {
        System.out.printf("\t\tSummary value: %s%n", this.summarize());
    }
}
