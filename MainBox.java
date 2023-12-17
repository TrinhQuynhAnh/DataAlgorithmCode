public class MainBox {
    public static void main(String []args) {
        Box<String> box1 = new Box();
        box1.setValue("Hello World");
        String value1 = (String) box1.getValue();
        Box<Integer> box2 = new Box();
        box2.setValue(123);
        Integer value2 = (Integer) box2.getValue();
    }
}
