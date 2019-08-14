package com.tanis138.exceptions;

public class Main {

    public static void main(String[] args) {
        int[] a = {-1, 15, 50, 500, 5000};
        for (int value : a) {
            try {
                ExceptionTester.Test(value);
                System.out.printf("Ok! (i = %d)\n", value);
            } catch (IGreaterThousandException e) {
                System.out.println(e);
            } catch (IGreaterHundredException e) {
                System.out.println(e);
            } catch (ILessTenException | ILessTwentyException e) {
                System.out.println(e);
            }

        }
    }
}
