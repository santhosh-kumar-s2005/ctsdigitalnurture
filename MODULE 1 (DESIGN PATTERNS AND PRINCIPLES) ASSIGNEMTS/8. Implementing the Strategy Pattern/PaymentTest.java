public class PaymentTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment("John Doe", "1234567812345678"));

        System.out.println("--- Paying with Credit Card ---");
        context.executePayment(250.00);

        System.out.println("\n--- Switching to PayPal ---");
        context.setPaymentStrategy(new PayPalPayment("johndoe@email.com"));
        context.executePayment(99.99);

        System.out.println("\n--- Switching back to Credit Card ---");
        context.setPaymentStrategy(new CreditCardPayment("Jane Smith", "8765432187654321"));
        context.executePayment(500.00);
    }
}
