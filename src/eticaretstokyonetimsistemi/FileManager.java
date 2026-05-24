package eticaretstokyonetimsistemi;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    public void saveProducts(ArrayList<Product> products) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("products.txt"));

            for (Product product : products) {
                writer.println(
                        product.getId() + "," +
                        product.getName() + "," +
                        product.getPrice() + "," +
                        product.getStock()
                );
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Dosyaya yazma hatası: " + e.getMessage());
        }
    }

    public ArrayList<Product> loadProducts() {
        ArrayList<Product> products = new ArrayList<>();

        try {
            File file = new File("products.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int stock = Integer.parseInt(parts[3]);

                Product product = new Product(id, name, price, stock);
                products.add(product);
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println("Dosyadan okuma hatası: " + e.getMessage());
        }

        return products;
    }
}