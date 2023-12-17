package Sets_and_Maps;
import java.util.*;
import java.io.*;

public class ProductSales {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Product> sales = new TreeMap<String, Product>();
        Scanner sc = new Scanner(new File("D:\\DataAlgorithmCode\\Sets_and_Maps\\salesData.txt"));
        String code;
        Product product;
        while (sc.hasNext()) {
            code = sc.nextLine();
            product = sales.get(code);
            if (product == null) {
                sales.put(code, new Product(code));
            } else {
                product.incrementSales();
            }
        }
        System.out.println("Product sold this period: ");
        for (Product prod : sales.values()) {
            System.out.println(prod);
        }
    }
}
