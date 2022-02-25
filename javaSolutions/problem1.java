package javaSolutions;
/*
 *  If we list all the natural numbers below 10 that are multiples of 3 or 5,
 *  we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *  Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class problem1{
    private int LIMIT = 1000;
    private int val1 = 3;
    private int val2 = 5;

    private static String usage = "usage: java problem1 [val1 val2 limit]\nExample: java problem1 4 8 10000";
    
    public static int[] parseArgs(String[] args){
        int[] vals = {3, 5, 1000};
        if(args.length == 0){
            return vals;
        }else if(args.length < 3){
            System.out.println(usage);
            return null;
        }else if(args.length > 3){
            System.out.println(usage);
            return null;
        }else if(args.length == 3){
            try {
                vals[0] = Integer.parseInt(args[0]);
                vals[1] = Integer.parseInt(args[1]);
                vals[2] = Integer.parseInt(args[2]);
            } catch (Exception NumberFormException) {
                System.out.println(usage);
                return null;
            }
            for(int i: vals){
                if(i <= 0){
                    System.out.println("Values must be greater than zero");
                    System.out.println(usage);
                    return null;
                }
            }
            return vals;
        }
        return null;
    }

    public int getSum(){
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

    public void run(int _val1, int _val2, int _LIMIT){
        val1 = _val1;
        val2 = _val2;
        LIMIT = _LIMIT;
        System.out.printf("Finding sum of all multiples of %d and %d below %d\n", val1, val2, LIMIT);
        
        int sum = getSum();

        System.out.printf("Sum: %d\n", sum);
    }
    public void run(){
        System.out.printf("Finding sum of all multiples of %d and %d below %d\n", val1, val2, LIMIT);
        
        int sum = getSum();

        System.out.printf("Sum: %d\n", sum);
    }

    public static void main(String[] args) {
        problem1 runner = new problem1();

        if(args.length == 0) runner.run();
        else{
            int[] vals = parseArgs(args);
            if(vals == null) System.exit(-1);
            runner.run(vals[0], vals[1], vals[2]);
        }
    }
}