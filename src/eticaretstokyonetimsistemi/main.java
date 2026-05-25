
package eticaretstokyonetimsistemi;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ProductManager manager = new ProductManager();
        FileManager fileManager = new FileManager();
        Scanner scanner = new Scanner(System.in);
        
        //Dosyadan okunan ürünleri alıyoruz ve ProductManager içindeki ana listeye tek tek ekliyoruz.
        ArrayList<Product> loadedProducts = fileManager.loadProducts();
        for(Product product: loadedProducts){
            manager.addProduct(product);
        }
        int choice;

        do {
            System.out.println("\n--- E-Ticaret Stok Yönetim Sistemi ---");
            System.out.println("1- Ürün Ekle");
            System.out.println("2- Ürünleri Listele");
            System.out.println("3- Ürün Sil");
            System.out.println("4- Ürün Güncelle");
            System.out.println("5- Dosyaya Kaydet");
            System.out.println("0- Çıkış");
            System.out.print("Seçiminiz: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ürün ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ürün adı: ");
                    String name = scanner.nextLine();

                    System.out.print("Ürün fiyatı: ");
                    double price = scanner.nextDouble();

                    System.out.print("Stok miktarı: ");
                    int stock = scanner.nextInt();

                    Product product = new Product(id, name, price, stock);
                    manager.addProduct(product);

                    System.out.println("Ürün eklendi.");
                    break;

                case 2:
                    manager.listProducts();
                    break;

                case 3:
                    System.out.print("Silinecek ürün ID: ");
                    int deleteId = scanner.nextInt();

                    manager.deleteProduct(deleteId);
                    break;

                case 4:
                    System.out.print("Güncellenecek ürün ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Yeni ürün adı: ");
                    String newName = scanner.nextLine();

                    System.out.print("Yeni fiyat: ");
                    double newPrice = scanner.nextDouble();

                    System.out.print("Yeni stok miktarı: ");
                    int newStock = scanner.nextInt();

                    manager.updateProduct(updateId, newName, newPrice, newStock);
                    break;

                case 5:
                    fileManager.saveProducts(manager.getProducts());
                    System.out.println("Ürünler dosyaya kaydedildi.");
                    break;

                case 0:
                    System.out.println("Programdan çıkılıyor...");
                    break;

                default:
                    System.out.println("Geçersiz seçim.");
            }

        } while (choice != 0);

        scanner.close();
    }
}