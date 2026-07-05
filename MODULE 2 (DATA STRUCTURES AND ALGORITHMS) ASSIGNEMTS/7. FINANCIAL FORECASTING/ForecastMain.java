public class ForecastMain {

    private static void printDivider(String title) {
        System.out.println("\n=== " + title + " ===");
    }

    public static void main(String[] args) {
        double presentValue = 100000.0;
        double annualGrowthRate = 0.08;
        int periods = 10;

        printDivider("Recursive Future Value");
        long start = System.nanoTime();
        double recursive = FinancialForecast.futureValueRecursive(presentValue, annualGrowthRate, periods);
        long end = System.nanoTime();
        System.out.printf("Present Value    : Rs %.2f%n", presentValue);
        System.out.printf("Growth Rate      : %.2f%%%n", annualGrowthRate * 100);
        System.out.printf("Periods          : %d years%n", periods);
        System.out.printf("Future Value     : Rs %.2f%n", recursive);
        System.out.println("Time taken       : " + (end - start) + " ns");

        printDivider("Memoized Recursive Future Value");
        start = System.nanoTime();
        double memoized = FinancialForecast.futureValueMemoized(presentValue, annualGrowthRate, periods);
        end = System.nanoTime();
        System.out.printf("Future Value     : Rs %.2f%n", memoized);
        System.out.println("Time taken       : " + (end - start) + " ns");

        printDivider("Iterative Future Value");
        start = System.nanoTime();
        double iterative = FinancialForecast.futureValueIterative(presentValue, annualGrowthRate, periods);
        end = System.nanoTime();
        System.out.printf("Future Value     : Rs %.2f%n", iterative);
        System.out.println("Time taken       : " + (end - start) + " ns");

        printDivider("Year-by-Year Forecast Series");
        double[] series = FinancialForecast.forecastSeries(presentValue, annualGrowthRate, periods);
        for (int i = 0; i <= periods; i++) {
            System.out.printf("Year %2d : Rs %,.2f%n", i, series[i]);
        }

        printDivider("Variable Growth Rate Forecast (Recursive)");
        double[] variableRates = {0.05, 0.08, 0.10, 0.07, 0.09};
        start = System.nanoTime();
        double variableResult = FinancialForecast.futureValueVariableRates(presentValue, variableRates);
        end = System.nanoTime();
        System.out.print("Growth Rates     : ");
        for (double r : variableRates) {
            System.out.printf("%.0f%% ", r * 100);
        }
        System.out.println();
        System.out.printf("Future Value     : Rs %.2f%n", variableResult);
        System.out.println("Time taken       : " + (end - start) + " ns");

        printDivider("Complexity Analysis");
        System.out.println("Recursive (plain)   - Time: O(n) | Space: O(n) call stack");
        System.out.println("Recursive (memoized) - Time: O(n) | Space: O(n) memo + O(n) stack");
        System.out.println("Iterative            - Time: O(n) | Space: O(1) — most efficient");
        System.out.println("Forecast Series      - Time: O(n) | Space: O(n) array");
        System.out.println("Variable Rates       - Time: O(n) | Space: O(n) call stack");

        printDivider("Optimization Notes");
        System.out.println("1. Plain recursion risks StackOverflowError for large n (e.g., n > 10000).");
        System.out.println("2. Memoization avoids recomputation in overlapping subproblems.");
        System.out.println("3. For this linear recurrence, iteration is the best: O(1) space, no stack risk.");
        System.out.println("4. Math formula FV = PV * (1 + r)^n with Math.pow() gives O(log n) via fast exponentiation.");
        System.out.printf("5. Math.pow verification: Rs %.2f%n", presentValue * Math.pow(1 + annualGrowthRate, periods));
    }
}
