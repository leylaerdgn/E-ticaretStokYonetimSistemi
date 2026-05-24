## 1. Adım
ilk olarak product dosyamı oluşturdum. burada ürünlerimi tutmak için birkaç bilgi 
tanımladım.

## 2. Adım
Sonrasında productmanager dosyamı oluşturdum. Burada arraylist kavramını öğrendim ve
ürün ekleme,silme,güncelleme metodu yazdım. 

## 3. Adım
File manager dosyamı oluşturdum. Bu dosyanın amacı, ürün listesini kalıcı hale
getirmek için dosyaya yazan ve program tekrar açıldığında dosyadan geri 
okuyan sınıftır. Ürünler bu dosya kurulmadan önce ProductManager listesinde tutuluyordu.
Ama arraylist geçicidir yani program çalışırken ürünler listede durur, program kapanınca
bellekteki liste silinir. Bu yüzden ürünleri bir dosyaya kaydetmemiz gerekiyor: products.txt

İki metot yazdık bu dosyaya:
1-) saveProducts() metodu:
Bu metot ürün listesini alır ve dosyaya yazar -> ArrayList<Product> → products.txt

2-) loadProducts metodu:
Bu dosya ise tersini yapar. Yani dosyada kayıtlı ürünleri okur, tekrar Product nesnesine
çevirir ve liste olarak geri döndürür. Burada amaç dosyadaki ürünleri okumak ve programa geri yüklemek.

İki metot arasındaki fark:
saveProducts()
Programdaki listeyi dosyaya yazar.

loadProducts()
Dosyadaki verileri okuyup tekrar listeye çevirir.





MOT:
1. ProductManager oluşturulur.
   İçinde boş liste oluşur.
2. FileManager products.txt dosyasını okur.
   Dosyadaki ürünleri ArrayList<Product> haline getirir.
3. Dosyadan gelen liste ProductManager içine verilir.
4. Artık ProductManager içindeki liste eski ürünlerle doludur.