public class StockMarketTest {
    public static void main(String[] args) {
        StockMarket appleStock = new StockMarket("AAPL", 150.00);

        Observer mobileApp1 = new MobileApp("StockTracker");
        Observer mobileApp2 = new MobileApp("InvestPro");
        Observer webApp1 = new WebApp("finance.com");

        System.out.println("--- Registering Observers ---");
        appleStock.registerObserver(mobileApp1);
        appleStock.registerObserver(mobileApp2);
        appleStock.registerObserver(webApp1);

        System.out.println("\n--- Price Change 1: AAPL -> $175.50 ---");
        appleStock.setPrice(175.50);

        System.out.println("\n--- Deregistering InvestPro ---");
        appleStock.deregisterObserver(mobileApp2);

        System.out.println("\n--- Price Change 2: AAPL -> $180.00 ---");
        appleStock.setPrice(180.00);
    }
}
