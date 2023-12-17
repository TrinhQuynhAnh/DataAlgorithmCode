

public class Customer implements Comparable {
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int age;
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Customer anotherCustomer = (Customer) obj;
        return this.name.equals(anotherCustomer.name) && this.age == anotherCustomer.age;
    }

    public int compareTo(Customer anotherCustomer) {
        int compareResult = this.name.compareTo(anotherCustomer.name);
        if (compareResult == 0) {
            compareResult = Integer.compare(this.age, anotherCustomer.age);
        }
        return compareResult;
        
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

}