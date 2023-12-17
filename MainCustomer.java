public class MainCustomer {
    public static void main(String []args) {
        Customer cus1 = new Customer("John", 20);
        Customer cus2 = new Customer("", 20);
        System.out.println(cus1.equals(cus2));
        Customer cus3 = new Customer("Ann", 25);
        Customer cus4 = new Customer("Ben", 21);
        Customer[] customers = {cus1, cus2, cus3, cus4};
    
    }
}