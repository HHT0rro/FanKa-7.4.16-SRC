package java.net;

import android.icu.text.StringPrepParseException;
import com.android.icu.text.ExtendedIDNA;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class IDN {
    public static final int ALLOW_UNASSIGNED = 1;
    public static final int USE_STD3_ASCII_RULES = 2;

    public static String toASCII(String input, int flag) {
        try {
            return ExtendedIDNA.convertIDNToASCII(input, flag).toString();
        } catch (StringPrepParseException e2) {
            if (".".equals(input)) {
                return input;
            }
            throw new IllegalArgumentException("Invalid input to toASCII: " + input, e2);
        }
    }

    public static String toASCII(String input) {
        return toASCII(input, 0);
    }

    public static String toUnicode(String input, int flag) {
        try {
            return convertFullStop(ExtendedIDNA.convertIDNToUnicode(input, flag)).toString();
        } catch (StringPrepParseException e2) {
            return input;
        }
    }

    private static boolean isLabelSeperator(char c4) {
        return c4 == 12290 || c4 == 65294 || c4 == 65377;
    }

    private static StringBuffer convertFullStop(StringBuffer input) {
        for (int i10 = 0; i10 < input.length(); i10++) {
            if (isLabelSeperator(input.charAt(i10))) {
                input.setCharAt(i10, '.');
            }
        }
        return input;
    }

    public static String toUnicode(String input) {
        return toUnicode(input, 0);
    }

    private IDN() {
    }
}
