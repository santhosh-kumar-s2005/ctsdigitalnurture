public class StripeGateway {
    public void executeCharge(double amount) {
        System.out.println("Stripe: Charging $" + amount + " to card.");
    }
}
