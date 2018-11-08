
import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    //Tester den 6-sidet terning
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

    //Tester den 4-sidet terning
    @Test
    public void roll2(){
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        int[] array = new int[9];

        for (int i = 0; i <= 20000; ++i) {
            dice3.roll2();
            dice4.roll2();
            int number2 = dice3.getFace() + dice4.getFace();

            Assert.assertTrue(number2 > 1 && number2 < 9);
            ++array[number2];
            System.out.println(number2);
        }
        for (int face = 2; face < array.length; ++face) {
            System.out.printf("%2d%9d\n", face, array[face]);
        }
    }
}