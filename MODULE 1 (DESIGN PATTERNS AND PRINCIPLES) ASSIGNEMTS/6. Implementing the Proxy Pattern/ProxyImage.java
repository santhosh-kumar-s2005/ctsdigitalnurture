import java.util.HashMap;
import java.util.Map;

public class ProxyImage implements Image {
    private String filename;
    private static Map<String, RealImage> cache = new HashMap<>();

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (!cache.containsKey(filename)) {
            System.out.println("Cache miss. Fetching image...");
            cache.put(filename, new RealImage(filename));
        } else {
            System.out.println("Cache hit. Using cached image: " + filename);
        }
        cache.get(filename).display();
    }
}
