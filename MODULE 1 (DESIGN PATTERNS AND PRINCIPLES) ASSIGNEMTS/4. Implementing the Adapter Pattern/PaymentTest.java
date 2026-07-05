public class PaymentTest {
    public static void main(String[] args) {
        PaymentProcessor payPal = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        PaymentProcessor square = new SquareAdapter(new SquareGateway());

        payPal.processPayment(150.00);
        stripe.processPayment(200.50);
        square.processPayment(99.99);
    }
}
