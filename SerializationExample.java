 import java.io.*;

class Product implements Serializable {
    private int id;
    private String name;
    private String category;
    private double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }

    // Method to serialize Product object
    public static void serializeProduct(Product product, String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(product);
            System.out.println("Product serialized and saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to deserialize Product object
    public static Product deserializeProduct(String filename) {
        Product product = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            product = (Product) objectIn.readObject();
            System.out.println("Product deserialized from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        Product originalProduct = new Product(1, "Laptop", "Electronics", 999.99);
        String filename = "product.ser";

        // Serialize the Product object
        Product.serializeProduct(originalProduct, filename);

        // Deserialize the Product object
        Product deserializedProduct = Product.deserializeProduct(filename);

        // Print the deserialized Product object
        if (deserializedProduct != null) {
            System.out.println("Deserialized Product Details:");
            System.out.println(deserializedProduct);
        }
    }
}


