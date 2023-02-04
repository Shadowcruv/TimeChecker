import java.util.*;
public class TimeCheck {
    enum ComputationType {BRUTE_FORCE, EUCLID}
    long bruteForce, euclidTime;
    public static void main(String[] args) {
        TimeCheck monitor = new TimeCheck();
        monitor.start();
        System.exit(0);
    }

    public void start() {

        int m, n;
        while (isContinue()) {
            m = getPositiveInteger();
            n = getPositiveInteger();

            bruteForce = timemethod(m, n, ComputationType.BRUTE_FORCE);
            euclidTime = timemethod(m, n, ComputationType.EUCLID);
            System.out.println(" m = " + m +" \n n = "+n +"\n  bruteForce "+ bruteForce+ "\n + euClidTime "+
                    euclidTime);
        }
    }

    public boolean isContinue() {
        String input;
        Boolean response = false;
        Scanner text = new Scanner(System.in);
        System.out.println("Run Test? \n Reply(Yes or yes)");
        input = text.next();
        if (input.equals("yes") || input.equals("Yes")) {
            response = true;
        }

        return response;

    }

    public int getPositiveInteger() {
        int num;
        Scanner input = new Scanner(System.in);
        System.out.println("enter num");
        num = input.nextInt();
        return num;
    }

    public long timemethod(int m, int n, ComputationType type) {
        long timeDuration;
        Date startTime, endTime;
        startTime = new Date();
        if (type == ComputationType.BRUTE_FORCE) {
            gcd_bruteForce(m, n);
        } else {
            gcd_euclid(m, n);
        }


        endTime = new Date();

        timeDuration = endTime.getTime() - startTime.getTime();
        return timeDuration;
    }

    public int gcd_bruteForce(int m, int n) {
      /*  Scanner scanner = new Scanner(System.in);
        System.out.println("The value of m?");
        m = scanner.nextInt();
        System.out.println("The value of n?");
        n = scanner.nextInt();
      */  int last = Math.min(m, n);
        int gcd = 0;
        int i = 1;
        while (i <= last) {
            if (m % i == 0 && n % i == 0) {
                gcd = i;
            }
            i++;
        }
        return gcd;

    }

    public int gcd_euclid(int m, int n) {
        int r = n % m;
        while (r !=0){
            n = m;
            m =r;
            r = n % m;
        }
        return m;
    }
}
