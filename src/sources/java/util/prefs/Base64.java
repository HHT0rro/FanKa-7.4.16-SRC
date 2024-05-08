package java.util.prefs;

import androidx.exifinterface.media.ExifInterface;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import okio.Utf8;
import org.apache.commons.io.IOUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class Base64 {
    private static final char[] intToBase64 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', Locale.PRIVATE_USE_EXTENSION, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};
    private static final char[] intToAltBase64 = {'!', '\"', '#', '$', '%', SymbolValues.CHAR_AND_SYMBOL, '\'', '(', ')', ',', '-', '.', ShortcutConstants.SERVICES_SEPARATOR, ';', '<', '>', '@', '[', ']', '^', '`', '_', '{', '|', '}', '~', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', Locale.PRIVATE_USE_EXTENSION, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '?'};
    private static final byte[] base64ToInt = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, Character.MATH_SYMBOL, -1, -1, -1, -1, -1, -1, Character.CURRENCY_SYMBOL, 27, 28, Character.INITIAL_QUOTE_PUNCTUATION, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private static final byte[] altBase64ToInt = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, -1, 62, 9, 10, 11, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 12, 13, 14, -1, 15, Utf8.REPLACEMENT_BYTE, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 17, -1, 18, 19, 21, 20, Character.CURRENCY_SYMBOL, 27, 28, Character.INITIAL_QUOTE_PUNCTUATION, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, 47, 48, 49, 50, 51, 22, 23, 24, Character.MATH_SYMBOL};

    Base64() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String byteArrayToBase64(byte[] a10) {
        return byteArrayToBase64(a10, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String byteArrayToAltBase64(byte[] a10) {
        return byteArrayToBase64(a10, true);
    }

    private static String byteArrayToBase64(byte[] a10, boolean alternate) {
        int aLen = a10.length;
        int numFullGroups = aLen / 3;
        int numBytesInPartialGroup = aLen - (numFullGroups * 3);
        int resultLen = ((aLen + 2) / 3) * 4;
        StringBuffer result = new StringBuffer(resultLen);
        char[] intToAlpha = alternate ? intToAltBase64 : intToBase64;
        int inCursor = 0;
        int i10 = 0;
        while (i10 < numFullGroups) {
            int inCursor2 = inCursor + 1;
            int byte0 = a10[inCursor] & 255;
            int inCursor3 = inCursor2 + 1;
            int byte1 = a10[inCursor2] & 255;
            int inCursor4 = inCursor3 + 1;
            int byte2 = a10[inCursor3] & 255;
            result.append(intToAlpha[byte0 >> 2]);
            result.append(intToAlpha[((byte0 << 4) & 63) | (byte1 >> 4)]);
            result.append(intToAlpha[((byte1 << 2) & 63) | (byte2 >> 6)]);
            result.append(intToAlpha[byte2 & 63]);
            i10++;
            inCursor = inCursor4;
        }
        if (numBytesInPartialGroup != 0) {
            int inCursor5 = inCursor + 1;
            int byte02 = a10[inCursor] & 255;
            result.append(intToAlpha[byte02 >> 2]);
            if (numBytesInPartialGroup == 1) {
                result.append(intToAlpha[(byte02 << 4) & 63]);
                result.append("==");
            } else {
                int i11 = inCursor5 + 1;
                int byte12 = a10[inCursor5] & 255;
                result.append(intToAlpha[((byte02 << 4) & 63) | (byte12 >> 4)]);
                result.append(intToAlpha[(byte12 << 2) & 63]);
                result.append('=');
            }
        }
        return result.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] base64ToByteArray(String s2) {
        return base64ToByteArray(s2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] altBase64ToByteArray(String s2) {
        return base64ToByteArray(s2, true);
    }

    private static byte[] base64ToByteArray(String s2, boolean alternate) {
        byte[] alphaToInt = alternate ? altBase64ToInt : base64ToInt;
        int sLen = s2.length();
        int numGroups = sLen / 4;
        if (numGroups * 4 != sLen) {
            throw new IllegalArgumentException("String length must be a multiple of four.");
        }
        int missingBytesInLastGroup = 0;
        int numFullGroups = numGroups;
        if (sLen != 0) {
            if (s2.charAt(sLen - 1) == '=') {
                missingBytesInLastGroup = 0 + 1;
                numFullGroups--;
            }
            if (s2.charAt(sLen - 2) == '=') {
                missingBytesInLastGroup++;
            }
        }
        byte[] result = new byte[(numGroups * 3) - missingBytesInLastGroup];
        int inCursor = 0;
        int outCursor = 0;
        int i10 = 0;
        while (i10 < numFullGroups) {
            int inCursor2 = inCursor + 1;
            int ch0 = base64toInt(s2.charAt(inCursor), alphaToInt);
            int inCursor3 = inCursor2 + 1;
            int ch1 = base64toInt(s2.charAt(inCursor2), alphaToInt);
            int inCursor4 = inCursor3 + 1;
            int ch2 = base64toInt(s2.charAt(inCursor3), alphaToInt);
            int inCursor5 = inCursor4 + 1;
            int ch3 = base64toInt(s2.charAt(inCursor4), alphaToInt);
            int outCursor2 = outCursor + 1;
            result[outCursor] = (byte) ((ch0 << 2) | (ch1 >> 4));
            int outCursor3 = outCursor2 + 1;
            result[outCursor2] = (byte) ((ch1 << 4) | (ch2 >> 2));
            result[outCursor3] = (byte) ((ch2 << 6) | ch3);
            i10++;
            inCursor = inCursor5;
            outCursor = outCursor3 + 1;
        }
        if (missingBytesInLastGroup != 0) {
            int inCursor6 = inCursor + 1;
            int ch02 = base64toInt(s2.charAt(inCursor), alphaToInt);
            int inCursor7 = inCursor6 + 1;
            int ch12 = base64toInt(s2.charAt(inCursor6), alphaToInt);
            int outCursor4 = outCursor + 1;
            result[outCursor] = (byte) ((ch02 << 2) | (ch12 >> 4));
            if (missingBytesInLastGroup == 1) {
                int i11 = inCursor7 + 1;
                int i12 = outCursor4 + 1;
                result[outCursor4] = (byte) ((ch12 << 4) | (base64toInt(s2.charAt(inCursor7), alphaToInt) >> 2));
            }
        }
        return result;
    }

    private static int base64toInt(char c4, byte[] alphaToInt) {
        int result = alphaToInt[c4];
        if (result < 0) {
            throw new IllegalArgumentException("Illegal character " + c4);
        }
        return result;
    }

    public static void main(String[] args) {
        int numRuns = Integer.parseInt(args[0]);
        int numBytes = Integer.parseInt(args[1]);
        Random rnd = new Random();
        for (int i10 = 0; i10 < numRuns; i10++) {
            for (int j10 = 0; j10 < numBytes; j10++) {
                byte[] arr = new byte[j10];
                for (int k10 = 0; k10 < j10; k10++) {
                    arr[k10] = (byte) rnd.nextInt();
                }
                String s2 = byteArrayToBase64(arr);
                byte[] b4 = base64ToByteArray(s2);
                if (!Arrays.equals(arr, b4)) {
                    System.out.println("Dismal failure!");
                }
                String s10 = byteArrayToAltBase64(arr);
                byte[] b10 = altBase64ToByteArray(s10);
                if (!Arrays.equals(arr, b10)) {
                    System.out.println("Alternate dismal failure!");
                }
            }
        }
    }
}
