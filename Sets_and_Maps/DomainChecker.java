package Sets_and_Maps;
import java.io.*;
import java.util.*;

public class DomainChecker {
    public static void main(String[] args) throws FileNotFoundException {
        DomainBlocker blocker = new DomainBlocker();
        Scanner sc = new Scanner(System.in);
        String domain;
        do {
            System.out.println("Enter a domain (DONE to quit): ");
            domain = sc.nextLine();
            if (!domain.equalsIgnoreCase("DONE")) {
                if (blocker.domainIsBlocked(domain)) {
                    System.out.println("That domain is blocked.");
                } else {
                    System.out.println("That domain is fine.");
                }
            }
        } while (!domain.equalsIgnoreCase("DONE"));
    }
}
