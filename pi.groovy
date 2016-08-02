// the more complexity the more cpu gets burned
int complexity = 2000;

public class PI
{
    private static final int SCALE = 10000;
    private static final int ARRINIT = 2000;

    public String pi_digits(int digits)
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

            pi.append(String.format("%04d", (long)(carry + (sum / SCALE))));
            carry = sum % SCALE;
        }
        return pi.toString();
    }
}

long millis0 = System.currentTimeMillis();
System.out.println("Start");
int n = complexity; // 200000;
String result = new PI().pi_digits(n);
long millis1 = System.currentTimeMillis();
logger.info("Done. Time spent: "+(millis1-millis0)+" ms");
logger.info("!PI is equal "+result);
