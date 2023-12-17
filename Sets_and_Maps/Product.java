package Sets_and_Maps;

public class Product implements Comparable<Product> {
    private String productCode;
    private int sales;
    public Product(String productCode) {
        this.productCode = productCode;
        this.sales = 0;
    }
    public String getProductCode() {
        return productCode;
    }
    public void incrementSales() {
        sales++;
    }
    public int compareTo(Product obj) {
        return productCode.compareTo(obj.getProductCode());
    }
    public String toString() {
        return productCode + "\t("+ sales +")";
    }
} 
