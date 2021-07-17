package b2_loop_in_java.bai_tap;

public class PrimeLessThan100 {
    public static void main(String[] args) {

        for (int i=2; i < 100; i++){
            boolean check = true;
            int num = 2;
            while (num <= Math.sqrt(i)){
                if (i % num == 0){
                    check = false;
                    break;
                }
                num++;
            }
            if (check){
                System.out.println( i );
            }
        }
    }
}
