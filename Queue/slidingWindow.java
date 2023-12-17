package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class slidingWindow {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i = 0; i <n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        solve(arr,k,n);


    }
    // Using Sliding Window technical
    private static void solve(int[]arr , int k, int n){
        Deque<Integer> queue = new ArrayDeque<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0 ; i < n;i++){
            if(cnt<=k-1){
                if(!map.containsKey(arr[i])){
                    queue.add(arr[i]);
                    map.put(arr[i],1);
                    cnt++;
                }
                else {
                    map.put(arr[i],map.get(arr[i])+1);
                }
            }
            else {
                 int last= queue.removeFirst();
                 map.put(last,map.get(last)-1);
                 if(map.get(last)==0)
                     map.remove(last);
                if(!map.containsKey(arr[i])){
                    queue.add(arr[i]);
                    map.put(arr[i],1);
                }
                else {
                    map.put(arr[i],map.get(arr[i])+1);
                }

            }
        }
        while (!queue.isEmpty()){
            System.out.print(queue.removeFirst()+" ");
        }
    }
}
