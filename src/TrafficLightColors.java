/*
 * Hello class, this is a program that simulates traffic light using random hold time.
 * I randomly generate a number of itteration for the sake of doing do-while loop(post-test).
 * Yellow will always be 3 second, Green or Red will always have Yellow after.
 * I use a for-loop inside a do-while loop to make a second requested example (pre-test).
 */

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TrafficLightColors {
    public static void main(String[] args) {
        int count = getRandom();
        count--;
        System.out.println("Number of iterations: " + count);
        String[] trafficLightColors = { "yellow", "green", "yellow", "red" };
        int index = 0;
        // This is an example of post-test loop, it testes if the condition is valid
        // after the first iteration.
        do {

            index = (index + 1) % trafficLightColors.length; // constantly going 1-4 and restart
            try {
                // Yellow will always be 3 seconds
                if (trafficLightColors[index] == "yellow") {
                    System.out.println("Traffic Light is " + trafficLightColors[index]);
                    System.out.println("for 3 seconds");
                    TimeUnit.SECONDS.sleep(3);
                }
                // else if and else - will be have a random timer from 3 to 10 sec.
                else if (trafficLightColors[index] == "green") {
                    System.out.println("Traffic Light is " + trafficLightColors[index]);
                    int x = getRandom();
                    System.out.println("for " + x + " seconds");
                    // for loop is an example of pre-test loop - it validates the conditions
                    // and only after that it will execute its content.
                    for (int y = 0; y < x; y++) {
                        System.out.println("DRIVE!");
                    }
                    TimeUnit.SECONDS.sleep(x);
                    count--;
                } else {
                    System.out.println("Traffic Light is " + trafficLightColors[index]);
                    int x = getRandom();
                    System.out.println("for " + x + " seconds");
                    TimeUnit.SECONDS.sleep(x);
                    count--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (count > 0);

    }

    private static int getRandom() {
        return (int) (Math.random() * 10) + 1;
    }
}