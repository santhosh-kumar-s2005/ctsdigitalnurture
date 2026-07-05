public class ImageViewerTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");
        Image image3 = new ProxyImage("photo1.jpg");

        System.out.println("--- First display of photo1.jpg ---");
        image1.display();

        System.out.println("\n--- First display of photo2.jpg ---");
        image2.display();

        System.out.println("\n--- Second display of photo1.jpg (cached) ---");
        image3.display();

        System.out.println("\n--- Second display of photo2.jpg (cached) ---");
        image2.display();
    }
}
