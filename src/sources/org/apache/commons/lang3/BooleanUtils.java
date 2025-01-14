package org.apache.commons.lang3;

import org.apache.commons.lang3.math.NumberUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class BooleanUtils {
    public static boolean and(boolean... zArr) {
        if (zArr != null) {
            if (zArr.length != 0) {
                for (boolean z10 : zArr) {
                    if (!z10) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalArgumentException("Array is empty");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static int compare(boolean z10, boolean z11) {
        if (z10 == z11) {
            return 0;
        }
        return z10 ? 1 : -1;
    }

    public static boolean isFalse(Boolean bool) {
        return Boolean.FALSE.equals(bool);
    }

    public static boolean isNotFalse(Boolean bool) {
        return !isFalse(bool);
    }

    public static boolean isNotTrue(Boolean bool) {
        return !isTrue(bool);
    }

    public static boolean isTrue(Boolean bool) {
        return Boolean.TRUE.equals(bool);
    }

    public static Boolean negate(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
    }

    public static boolean or(boolean... zArr) {
        if (zArr != null) {
            if (zArr.length != 0) {
                for (boolean z10 : zArr) {
                    if (z10) {
                        return true;
                    }
                }
                return false;
            }
            throw new IllegalArgumentException("Array is empty");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static boolean toBoolean(int i10) {
        return i10 != 0;
    }

    public static boolean toBoolean(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    public static boolean toBooleanDefaultIfNull(Boolean bool, boolean z10) {
        return bool == null ? z10 : bool.booleanValue();
    }

    public static Boolean toBooleanObject(int i10) {
        return i10 == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static int toInteger(Boolean bool, int i10, int i11, int i12) {
        return bool == null ? i12 : bool.booleanValue() ? i10 : i11;
    }

    public static int toInteger(boolean z10) {
        return z10 ? 1 : 0;
    }

    public static int toInteger(boolean z10, int i10, int i11) {
        return z10 ? i10 : i11;
    }

    public static Integer toIntegerObject(boolean z10) {
        return z10 ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
    }

    public static Integer toIntegerObject(boolean z10, Integer num, Integer num2) {
        return z10 ? num : num2;
    }

    public static String toString(Boolean bool, String str, String str2, String str3) {
        return bool == null ? str3 : bool.booleanValue() ? str : str2;
    }

    public static String toString(boolean z10, String str, String str2) {
        return z10 ? str : str2;
    }

    public static String toStringOnOff(Boolean bool) {
        return toString(bool, "on", "off", null);
    }

    public static String toStringTrueFalse(Boolean bool) {
        return toString(bool, "true", "false", null);
    }

    public static String toStringYesNo(Boolean bool) {
        return toString(bool, "yes", "no", null);
    }

    public static boolean xor(boolean... zArr) {
        if (zArr != null) {
            if (zArr.length != 0) {
                boolean z10 = false;
                for (boolean z11 : zArr) {
                    z10 ^= z11;
                }
                return z10;
            }
            throw new IllegalArgumentException("Array is empty");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static boolean toBoolean(int i10, int i11, int i12) {
        if (i10 == i11) {
            return true;
        }
        if (i10 == i12) {
            return false;
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static Boolean toBooleanObject(Integer num) {
        if (num == null) {
            return null;
        }
        return num.intValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static Integer toIntegerObject(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool.booleanValue() ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
    }

    public static String toStringOnOff(boolean z10) {
        return toString(z10, "on", "off");
    }

    public static String toStringTrueFalse(boolean z10) {
        return toString(z10, "true", "false");
    }

    public static String toStringYesNo(boolean z10) {
        return toString(z10, "yes", "no");
    }

    public static boolean toBoolean(Integer num, Integer num2, Integer num3) {
        if (num == null) {
            if (num2 == null) {
                return true;
            }
            if (num3 == null) {
                return false;
            }
        } else {
            if (num.equals(num2)) {
                return true;
            }
            if (num.equals(num3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static Boolean toBooleanObject(int i10, int i11, int i12, int i13) {
        if (i10 == i11) {
            return Boolean.TRUE;
        }
        if (i10 == i12) {
            return Boolean.FALSE;
        }
        if (i10 == i13) {
            return null;
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static Integer toIntegerObject(Boolean bool, Integer num, Integer num2, Integer num3) {
        return bool == null ? num3 : bool.booleanValue() ? num : num2;
    }

    public static Boolean and(Boolean... boolArr) {
        if (boolArr != null) {
            if (boolArr.length != 0) {
                try {
                    return and(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
                } catch (NullPointerException unused) {
                    throw new IllegalArgumentException("The array must not contain any null elements");
                }
            }
            throw new IllegalArgumentException("Array is empty");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static Boolean or(Boolean... boolArr) {
        if (boolArr != null) {
            if (boolArr.length != 0) {
                try {
                    return or(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
                } catch (NullPointerException unused) {
                    throw new IllegalArgumentException("The array must not contain any null elements");
                }
            }
            throw new IllegalArgumentException("Array is empty");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static Boolean xor(Boolean... boolArr) {
        if (boolArr != null) {
            if (boolArr.length != 0) {
                try {
                    return xor(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
                } catch (NullPointerException unused) {
                    throw new IllegalArgumentException("The array must not contain any null elements");
                }
            }
            throw new IllegalArgumentException("Array is empty");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static boolean toBoolean(String str) {
        return toBooleanObject(str) == Boolean.TRUE;
    }

    public static Boolean toBooleanObject(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null) {
            if (num2 == null) {
                return Boolean.TRUE;
            }
            if (num3 == null) {
                return Boolean.FALSE;
            }
            if (num4 == null) {
                return null;
            }
        } else {
            if (num.equals(num2)) {
                return Boolean.TRUE;
            }
            if (num.equals(num3)) {
                return Boolean.FALSE;
            }
            if (num.equals(num4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static boolean toBoolean(String str, String str2, String str3) {
        if (str == str2) {
            return true;
        }
        if (str == str3) {
            return false;
        }
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
            if (str.equals(str3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The String did not match either specified value");
    }

    public static Boolean toBooleanObject(String str) {
        if (str == "true") {
            return Boolean.TRUE;
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 1) {
            char charAt = str.charAt(0);
            if (charAt == 'y' || charAt == 'Y' || charAt == 't' || charAt == 'T') {
                return Boolean.TRUE;
            }
            if (charAt == 'n' || charAt == 'N' || charAt == 'f' || charAt == 'F') {
                return Boolean.FALSE;
            }
            return null;
        }
        if (length == 2) {
            char charAt2 = str.charAt(0);
            char charAt3 = str.charAt(1);
            if ((charAt2 == 'o' || charAt2 == 'O') && (charAt3 == 'n' || charAt3 == 'N')) {
                return Boolean.TRUE;
            }
            if (charAt2 != 'n' && charAt2 != 'N') {
                return null;
            }
            if (charAt3 == 'o' || charAt3 == 'O') {
                return Boolean.FALSE;
            }
            return null;
        }
        if (length == 3) {
            char charAt4 = str.charAt(0);
            char charAt5 = str.charAt(1);
            char charAt6 = str.charAt(2);
            if ((charAt4 == 'y' || charAt4 == 'Y') && ((charAt5 == 'e' || charAt5 == 'E') && (charAt6 == 's' || charAt6 == 'S'))) {
                return Boolean.TRUE;
            }
            if (charAt4 != 'o' && charAt4 != 'O') {
                return null;
            }
            if (charAt5 != 'f' && charAt5 != 'F') {
                return null;
            }
            if (charAt6 == 'f' || charAt6 == 'F') {
                return Boolean.FALSE;
            }
            return null;
        }
        if (length == 4) {
            char charAt7 = str.charAt(0);
            char charAt8 = str.charAt(1);
            char charAt9 = str.charAt(2);
            char charAt10 = str.charAt(3);
            if (charAt7 != 't' && charAt7 != 'T') {
                return null;
            }
            if (charAt8 != 'r' && charAt8 != 'R') {
                return null;
            }
            if (charAt9 != 'u' && charAt9 != 'U') {
                return null;
            }
            if (charAt10 == 'e' || charAt10 == 'E') {
                return Boolean.TRUE;
            }
            return null;
        }
        if (length != 5) {
            return null;
        }
        char charAt11 = str.charAt(0);
        char charAt12 = str.charAt(1);
        char charAt13 = str.charAt(2);
        char charAt14 = str.charAt(3);
        char charAt15 = str.charAt(4);
        if (charAt11 != 'f' && charAt11 != 'F') {
            return null;
        }
        if (charAt12 != 'a' && charAt12 != 'A') {
            return null;
        }
        if (charAt13 != 'l' && charAt13 != 'L') {
            return null;
        }
        if (charAt14 != 's' && charAt14 != 'S') {
            return null;
        }
        if (charAt15 == 'e' || charAt15 == 'E') {
            return Boolean.FALSE;
        }
        return null;
    }

    public static Boolean toBooleanObject(String str, String str2, String str3, String str4) {
        if (str == null) {
            if (str2 == null) {
                return Boolean.TRUE;
            }
            if (str3 == null) {
                return Boolean.FALSE;
            }
            if (str4 == null) {
                return null;
            }
        } else {
            if (str.equals(str2)) {
                return Boolean.TRUE;
            }
            if (str.equals(str3)) {
                return Boolean.FALSE;
            }
            if (str.equals(str4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The String did not match any specified value");
    }
}
