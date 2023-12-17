import java.util.*;
public class RadixSort {
    /*Sap xep theo co so */
    public static void main(String[] args) {
        int[] list = {7843, 4568, 8765, 6543, 7865, 4532, 9987, 3241,
                    6589, 6622, 1211};
        String temp;
        Integer numObj;
        int digit, num;
        Queue<Integer>[] digitQueues = (LinkedList<Integer>[])(new LinkedList[10]);
        for (int digitVal = 0; digitVal <= 9; digitVal++) {
            digitQueues[digitVal] = (Queue<Integer>)(new LinkedList<Integer>());
        }
        for (int pos = 0; pos <= 3; pos++) {
            for (int scan = 0; scan < list.length; scan++) {
                temp = String.valueOf(list[scan]);
                digit = Character.digit(temp.charAt(3 - pos), 10);
                digitQueues[digit].add(list[scan]);
            }
            num = 0;
            for (int digitVal = 0; digitVal <= 9; digitVal++) {
                while (!(digitQueues[digitVal].isEmpty())) {
                    numObj = digitQueues[digitVal].remove();
                    list[num] = numObj.intValue();
                    num++;
                }
            }
        }
        for (int scan = 0; scan < list.length; scan++) {
            System.out.println(list[scan]);
        }
    }
}