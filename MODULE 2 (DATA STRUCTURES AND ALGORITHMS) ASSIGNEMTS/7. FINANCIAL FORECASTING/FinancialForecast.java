import java.util.HashMap;
import java.util.Map;

public class FinancialForecast {

    public static double futureValueRecursive(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return futureValueRecursive(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    private static Map<Integer, Double> memo = new HashMap<>();

    public static double futureValueMemoized(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }
        double result = futureValueMemoized(presentValue * (1 + growthRate), growthRate, periods - 1);
        memo.put(periods, result);
        return result;
    }

    public static double futureValueIterative(double presentValue, double growthRate, int periods) {
        double value = presentValue;
        for (int i = 0; i < periods; i++) {
            value = value * (1 + growthRate);
        }
        return value;
    }

    public static double[] forecastSeries(double presentValue, double growthRate, int periods) {
        double[] forecast = new double[periods + 1];
        forecast[0] = presentValue;
        for (int i = 1; i <= periods; i++) {
            forecast[i] = forecast[i - 1] * (1 + growthRate);
        }
        return forecast;
    }

    public static double futureValueVariableRates(double presentValue, double[] growthRates) {
        if (growthRates.length == 0) {
            return presentValue;
        }
        double[] remaining = new double[growthRates.length - 1];
        System.arraycopy(growthRates, 1, remaining, 0, remaining.length);
        return futureValueVariableRates(presentValue * (1 + growthRates[0]), remaining);
    }
}
