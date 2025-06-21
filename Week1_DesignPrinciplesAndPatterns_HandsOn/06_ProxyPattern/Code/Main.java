public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("cute_cat_photo.jpg");

        System.out.println("First call to display():");
        image.display();

        System.out.println("\nSecond call to display():");
        image.display();
    }
}
