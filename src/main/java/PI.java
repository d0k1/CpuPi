/**
 * The most dumb cpu load generator.
 * Calculates pi up to desired precision
 *
 * Created by dkirpichenkov on 21.04.16.
 */
public class PI
{
    private static final int SCALE = 10000;
    private static final int ARRINIT = 2000;

    public static void main(String[] args)
    {
        long millis0 = System.currentTimeMillis();
        System.out.println("Start");
        int n = Integer.parseInt(args[0]); // 200000;
        String result = PI.pi_digits(n);
        long millis1 = System.currentTimeMillis();
        System.out.println("Done. Time spent: "+(millis1-millis0)+" ms");
        System.err.println(result);
    }

    public static String pi_digits(int digits)
    {
        StringBuffer pi = new StringBuffer();
        int[] arr = new int[digits + 1];
        int carry = 0;

        for (int i = 0; i <= digits; ++i)
        {
            arr[i] = ARRINIT;
        }

        for (int i = digits; i > 0; i -= 14)
        {
            int sum = 0;
            for (int j = i; j > 0; --j)
            {
                sum = sum * j + SCALE * arr[j];
                arr[j] = sum % (j * 2 - 1);
                sum /= j * 2 - 1;
            }

            pi.append(String.format("%04d", carry + sum / SCALE));
            carry = sum % SCALE;
        }
        return pi.toString();
    }
}
