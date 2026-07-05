public class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF Document...");
    }
    public void close() {
        System.out.println("Closing PDF Document...");
    }
    public void save() {
        System.out.println("Saving PDF Document as .pdf");
    }
}
