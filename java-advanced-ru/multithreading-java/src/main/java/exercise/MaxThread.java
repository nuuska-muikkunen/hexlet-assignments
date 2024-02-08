package exercise;

// BEGIN
public class MaxThread extends Thread {

    private int maximum;
    private int[] numbers;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    public int getMaximum() {
        return maximum;
    }

    @Override
    public void run() {
        maximum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maximum) {
                maximum = numbers[i];
            }
        }
    }
}
// END
