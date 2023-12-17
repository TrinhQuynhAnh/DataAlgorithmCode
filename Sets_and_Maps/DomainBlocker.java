package Sets_and_Maps;
import java.io.*;
import java.util.*;
public class DomainBlocker {
    private TreeSet<String> blockedSet;
    public DomainBlocker() throws FileNotFoundException {
        blockedSet = new TreeSet<String>();
        File inputFile = new File("D:\\DataAlgorithmCode\\Sets_and_Maps\\blockedDomains.txt");
        Scanner sc = new Scanner(inputFile);
        while (sc.hasNextLine()) {
            blockedSet.add(sc.nextLine());
        }
    }
    public boolean domainIsBlocked(String domain) {
        return blockedSet.contains(domain);
    }
}