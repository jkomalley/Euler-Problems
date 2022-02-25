package javaSolutions;
/*
 *  If we list all the natural numbers below 10 that are multiples of 3 or 5,
 *  we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *  Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class problem1{
    private static int LIMIT = 1000;
    private static int val1 = 3;
    private static int val2 = 5;

    private static String usage = "usage: java problem1 [val1 {3}] [val2 {5}] [limit {1000}]";
    
    public static int parseArgs(String[] args){
        if(args.length == 0){
            return 0;
        }else if(args.length > 3){
            System.out.println(usage);
            return -1;
        }else if(args.length == 3){
            try {
                val1 = Integer.parseInt(args[0]);
                val2 = Integer.parseInt(args[1]);
                LIMIT = Integer.parseInt(args[2]);
            } catch (Exception NumberFormException) {
                System.out.println(usage);
                return -1;
            }
        }
        return -1;
    }

    public static int getSum(){
        int cur = 0, sum = 0;
        while(cur < LIMIT){
            if(cur % val1 == 0 && cur % val2 == 0){
                sum += cur;
            }else if(cur % val1 == 0|| cur % val2 == 0){
                sum += cur;
            }
            cur++;
        }
        return sum;
    }
    public static void main(String[] args) {
        if(parseArgs(args) < 0) System.exit(-1);

        System.out.printf("Finding sum of all multiples of %d and %d below %d\n", val1, val2, LIMIT);
        
        int sum = getSum();

        System.out.printf("Sum: %d\n", sum);
    }
}