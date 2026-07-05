public class PerformanceTester {

    public void performTask() {
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }
    }

    public void performSlowTask() throws InterruptedException {
        Thread.sleep(3000);
    }

    public int computeSum(int limit) {
        int sum = 0;
        for (int i = 1; i <= limit; i++) {
            sum += i;
        }
        return sum;
    }
}
