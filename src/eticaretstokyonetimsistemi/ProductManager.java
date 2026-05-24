
package eticaretstokyonetimsistemi;
import java.util.ArrayList;
public class ProductManager {
    private ArrayList<Product> products;
    
    public ProductManager(){
        this.products=new ArrayList<>();
    }
    
    public void setProducts(ArrayList<Product> products) {
    this.products = products;
     }
    //Ürün ekleme
    public void addProduct(Product product){
        products.add(product);
    }
    
    public ArrayList<Product> getProducts(){
        return products;
    }
    
    //Ürünleri Listeleme
    public void listProducts(){
        for(Product product: products){
            System.out.println(product.getId() + " - "
            + product.getName() + " - "
            + product.getPrice() +" TL - "
            + product.getStock() + " adet");
        }
    }
    //Ürün silme
    public void deleteProduct(int id){
        for(Product product: products){
            if(product.getId()==id){
                products.remove(product);
                System.out.println("Ürün silindi.");
                return;
            }
        }   
    }
    
    //Üürn güncelleme
    public void update(int id, String newName, double newPrice, int newStock){
        for(Product product: products){
            if(product.getId()==id){
                product.setName(newName);
                product.setPrice(newPrice);
                product.setStock(newStock);
                
                System.out.println("Ürün güncellendi.");
                return;
            }
        }
        System.out.println("Bu id'ye sahip ürün bulunamadı.");
    }
    
    
    }
    
