import java.util.*;

public class Main {
    public static void main(String[] args) {
        // keterangan toko
        System.out.println("Selamat Datang di Toko Elektronik D");
        System.out.println("Produk Kami :");
        System.out.println("1. Laptop Apple Macbook Pro");
        System.out.println("2. Hub USB C");
        System.out.println("3. Tas Laptop");
        System.out.println("4. Headphone Bluetooth");
        System.out.println("5. Mouse Logitech");
        System.out.println("6. Smartphone Samsung Galaxy");
        System.out.println("7. Smartphone Apple Iphone Series");
        System.out.println("8. Case Smartphone");
        System.out.println();

        // input produk toko
        ArrayList<String> products = new ArrayList<>();
        products.add("(1) Laptop Apple Macbook Pro");
        products.add("(2) Hub USB C");
        products.add("(3) Tas Laptop");
        products.add("(4) Headphone Bluetooth");
        products.add("(5) Mouse Logitech");
        products.add("(6) Smartphone Samsung Galaxy");
        products.add("(7) Smartphone Apple Iphone Series");
        products.add("(8) Case Smartphone");

        // mulai membeli dan cari rekomendasi
        RecommendationSystem system = new RecommendationSystem();
        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        String name;
        int numOfProduct, productId;
        boolean next = true;

        do {
            System.out.print("Nama -> ");
            name = sc.nextLine();
            names.add(name);

            System.out.print("Mau beli berapa produk? -> ");
            numOfProduct = sc.nextInt();
            sc.nextLine();
            System.out.println();

            System.out.println("Tulis angka produk yang ingin dibeli!");
            for (int i = 0; i < numOfProduct; i++) {
                System.out.print("Produk ke-" + (i + 1) + " -> ");
                productId = sc.nextInt();
                sc.nextLine();
                system.addPurchase(name, products.get(productId - 1));
            }

            System.out.print("Apakah ingin melihat rekomendasi produk? (y/n) -> ");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                next = false;
            }
            System.out.println();
        } while (next);

        // Menampilkan rekomendasi produk untuk pengguna tertentu
        System.out.println("Ingin rekomendasi produk untuk siapa? " + names);
        System.out.print("-> ");
        String targetUser = sc.nextLine();
        Set<String> recommendedProducts = system.recommendProducts(targetUser);

        System.out.println("Rekomendasi produk untuk " + targetUser + ":");
        if (recommendedProducts.isEmpty()) {
            System.out.println("Tidak ada rekomendasi produk saat ini");
        } else {
            for (String product : recommendedProducts) {
                System.out.println(product);
            }
        }

    }
}