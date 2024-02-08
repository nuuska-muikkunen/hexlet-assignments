package exercise;

// BEGIN
public class MinThread extends Thread {

    private int minimum;
    private int[] numbers;

       public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    public int getMinimum() {
        return minimum;
    }

    @Override
    public void run() {
        minimum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minimum) {
                minimum = numbers[i];
            }
        }
    }
}
// END
