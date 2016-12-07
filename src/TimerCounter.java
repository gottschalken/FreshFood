/**
 * Created by sambes on 28/11/16.
 */

import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;
import javax.sound.sampled.*;


public class TimerCounter {
    public static void main(String[] args) {
        System.out.println("Set the amount of time (Hours, Minutes, Seconds):");

        int[] timeArray = setTimer();

        runCountdown(timeArray);
    }

    static int[] setTimer() {
        Scanner input = new Scanner(System.in);

        int[] timeArray;

        while (true) {
            try {
                int hour = input.nextInt();
                int min = input.nextInt();
                int sec = input.nextInt();

                timeArray = new int[]{hour, min, sec};

                break;

            } catch (InputMismatchException e) {
                System.out.println("Try again using the format Hours, Minutes, Seconds:");

                input.nextLine();
            }
        }

        input.close();

        return timeArray;
    }

    static void runCountdown(int[] timeArray) {
        int totalTime = (timeArray[0] * 3600) + (timeArray[1] * 60) + timeArray[2];

        try {
            while (totalTime >= 0) {
                if (totalTime > 60) {
                    Thread.sleep(1000);

                    int min = totalTime / 60;
                    int sec = totalTime % 60;

                    System.out.println(min + " min " + sec + " sec");

                    totalTime--;

                } else {
                    Thread.sleep(1000);

                    System.out.println(totalTime + " sec");

                    totalTime--;
                }
            }
        } catch (InterruptedException e) {}

        System.out.println("Done");


    }


}
