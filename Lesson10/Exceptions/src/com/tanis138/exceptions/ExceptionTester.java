package com.tanis138.exceptions;

public class ExceptionTester {
    public static void Test(int i) throws ILessTenException, ILessTwentyException, IGreaterHundredException, IGreaterThousandException {
        if (i < 10) {
            throw new ILessTenException("i < 10", i);
        } else if (i < 20) {
            throw new ILessTwentyException("i < 20", i);
        } else if (i > 1000) {
            throw new IGreaterThousandException("i > 1000", i);
        } else if (i > 100) {
            throw new IGreaterHundredException("i > 100", i);
        }
    }
}
