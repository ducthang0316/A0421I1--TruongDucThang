package b11_DSA_stack_queue.bai_tap.dem_so_lan_xuat_hien_su_dung_map;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a string: ");
        String str = scanner.nextLine();
        String[] arrStr = str.split(" ");
        for (int i = 0; i < arrStr.length; i++) {
            int value = 1;
            if (!map.containsKey(arrStr[i].toLowerCase())){
                map.put(arrStr[i].toLowerCase(), value);
            }
            else {
                map.put( arrStr[i].toLowerCase(), map.get(arrStr[i].toLowerCase()) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().intValue());
        }
    }
}


