package org.apache.commons.lang3;

import java.util.Random;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class RandomStringUtils {
    private static final Random RANDOM = new Random();

    public static String random(int i10) {
        return random(i10, false, false);
    }

    public static String randomAlphabetic(int i10) {
        return random(i10, true, false);
    }

    public static String randomAlphanumeric(int i10) {
        return random(i10, true, true);
    }

    public static String randomAscii(int i10) {
        return random(i10, 32, 127, false, false);
    }

    public static String randomGraph(int i10) {
        return random(i10, 33, 126, false, false);
    }

    public static String randomNumeric(int i10) {
        return random(i10, false, true);
    }

    public static String randomPrint(int i10) {
        return random(i10, 32, 126, false, false);
    }

    public static String random(int i10, boolean z10, boolean z11) {
        return random(i10, 0, 0, z10, z11);
    }

    public static String randomAlphabetic(int i10, int i11) {
        return randomAlphabetic(RandomUtils.nextInt(i10, i11));
    }

    public static String randomAlphanumeric(int i10, int i11) {
        return randomAlphanumeric(RandomUtils.nextInt(i10, i11));
    }

    public static String randomAscii(int i10, int i11) {
        return randomAscii(RandomUtils.nextInt(i10, i11));
    }

    public static String randomGraph(int i10, int i11) {
        return randomGraph(RandomUtils.nextInt(i10, i11));
    }

    public static String randomNumeric(int i10, int i11) {
        return randomNumeric(RandomUtils.nextInt(i10, i11));
    }

    public static String randomPrint(int i10, int i11) {
        return randomPrint(RandomUtils.nextInt(i10, i11));
    }

    public static String random(int i10, int i11, int i12, boolean z10, boolean z11) {
        return random(i10, i11, i12, z10, z11, null, RANDOM);
    }

    public static String random(int i10, int i11, int i12, boolean z10, boolean z11, char... cArr) {
        return random(i10, i11, i12, z10, z11, cArr, RANDOM);
    }

    public static String random(int i10, int i11, int i12, boolean z10, boolean z11, char[] cArr, Random random) {
        int i13;
        if (i10 == 0) {
            return "";
        }
        if (i10 >= 0) {
            if (cArr != null && cArr.length == 0) {
                throw new IllegalArgumentException("The chars array must not be empty");
            }
            if (i11 == 0 && i12 == 0) {
                if (cArr != null) {
                    i12 = cArr.length;
                } else if (z10 || z11) {
                    i12 = 123;
                    i11 = 32;
                } else {
                    i12 = Character.MAX_CODE_POINT;
                }
            } else if (i12 <= i11) {
                throw new IllegalArgumentException("Parameter end (" + i12 + ") must be greater than start (" + i11 + ")");
            }
            if (cArr == null && ((z11 && i12 <= 48) || (z10 && i12 <= 65))) {
                throw new IllegalArgumentException("Parameter end (" + i12 + ") must be greater then (48) for generating digits or greater then (65) for generating letters.");
            }
            StringBuilder sb2 = new StringBuilder(i10);
            int i14 = i12 - i11;
            while (true) {
                int i15 = i10 - 1;
                if (i10 != 0) {
                    if (cArr == null) {
                        int nextInt = random.nextInt(i14) + i11;
                        int type = Character.getType(nextInt);
                        if (type != 0 && type != 18) {
                            i13 = nextInt;
                            if (type == 19) {
                            }
                        }
                        i10 = i15 + 1;
                    } else {
                        i13 = cArr[random.nextInt(i14) + i11];
                    }
                    int charCount = Character.charCount(i13);
                    if (i15 != 0 || charCount <= 1) {
                        if (!(z10 && Character.isLetter(i13)) && (!(z11 && Character.isDigit(i13)) && (z10 || z11))) {
                            i15++;
                        } else {
                            sb2.appendCodePoint(i13);
                            if (charCount == 2) {
                                i15--;
                            }
                        }
                        i10 = i15;
                    } else {
                        i10 = i15 + 1;
                    }
                } else {
                    return sb2.toString();
                }
            }
        } else {
            throw new IllegalArgumentException("Requested random string length " + i10 + " is less than 0.");
        }
    }

    public static String random(int i10, String str) {
        if (str == null) {
            return random(i10, 0, 0, false, false, null, RANDOM);
        }
        return random(i10, str.toCharArray());
    }

    public static String random(int i10, char... cArr) {
        if (cArr == null) {
            return random(i10, 0, 0, false, false, null, RANDOM);
        }
        return random(i10, 0, cArr.length, false, false, cArr, RANDOM);
    }
}
