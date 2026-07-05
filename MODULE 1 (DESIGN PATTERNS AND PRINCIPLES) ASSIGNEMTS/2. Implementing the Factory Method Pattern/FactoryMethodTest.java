public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Test ===\n");

        DocumentFactory wordFactory = new WordDocumentFactory();
        System.out.println("--- Word Document ---");
        wordFactory.manageDocument();

        System.out.println();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        System.out.println("--- PDF Document ---");
        pdfFactory.manageDocument();

        System.out.println();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        System.out.println("--- Excel Document ---");
        excelFactory.manageDocument();
    }
}
