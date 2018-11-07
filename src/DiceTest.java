
import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    @Test
    public void roll() {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        int[] array = new int[13];

        for (int i = 0; i <= 20000; ++i) {

            dice1.roll();
            dice2.roll();
            int number = dice1.getFace() + dice2.getFace();

            Assert.assertTrue(number > 1 && number < 13);
            ++array[number];
            System.out.println(number);
        }

        for (int face = 2; face < array.length; ++face) {
            System.out.printf("%2d%13d\n", face, array[face]);
        }
    }
}