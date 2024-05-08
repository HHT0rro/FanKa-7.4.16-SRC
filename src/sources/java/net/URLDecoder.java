package java.net;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class URLDecoder {
    static String dfltEncName = URLEncoder.dfltEncName;

    @Deprecated
    public static String decode(String s2) {
        try {
            String str = decode(s2, dfltEncName);
            return str;
        } catch (UnsupportedEncodingException e2) {
            return null;
        }
    }

    public static String decode(String s2, String enc) throws UnsupportedEncodingException {
        if (enc.isEmpty()) {
            throw new UnsupportedEncodingException("URLDecoder: empty string enc parameter");
        }
        try {
            Charset charset = Charset.forName(enc);
            return decode(s2, charset);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e2) {
            throw new UnsupportedEncodingException(enc);
        }
    }

    public static String decode(String s2, Charset charset) {
        Objects.requireNonNull(charset, "Charset");
        boolean needToChange = false;
        int numChars = s2.length();
        StringBuilder sb2 = new StringBuilder(numChars > 500 ? numChars / 2 : numChars);
        int i10 = 0;
        byte[] bytes = null;
        while (i10 < numChars) {
            char c4 = s2.charAt(i10);
            switch (c4) {
                case '%':
                    if (bytes == null) {
                        try {
                            bytes = new byte[(numChars - i10) / 3];
                        } catch (NumberFormatException e2) {
                            throw new IllegalArgumentException("URLDecoder: Illegal hex characters in escape (%) pattern - " + e2.getMessage());
                        }
                    }
                    int pos = 0;
                    while (i10 + 2 < numChars && c4 == '%') {
                        if (!isValidHexChar(s2.charAt(i10 + 1)) || !isValidHexChar(s2.charAt(i10 + 2))) {
                            throw new IllegalArgumentException("URLDecoder: Illegal hex characters in escape (%) pattern : " + s2.substring(i10, i10 + 3));
                        }
                        int v2 = Integer.parseInt(s2.substring(i10 + 1, i10 + 3), 16);
                        if (v2 < 0) {
                            throw new IllegalArgumentException("URLDecoder: Illegal hex characters in escape (%) pattern - negative value : " + s2.substring(i10, i10 + 3));
                        }
                        int pos2 = pos + 1;
                        bytes[pos] = (byte) v2;
                        i10 += 3;
                        if (i10 < numChars) {
                            c4 = s2.charAt(i10);
                        }
                        pos = pos2;
                    }
                    if (i10 < numChars && c4 == '%') {
                        throw new IllegalArgumentException("URLDecoder: Incomplete trailing escape (%) pattern");
                    }
                    sb2.append(new String(bytes, 0, pos, charset));
                    needToChange = true;
                    break;
                case '+':
                    sb2.append(' ');
                    i10++;
                    needToChange = true;
                    break;
                default:
                    sb2.append(c4);
                    i10++;
                    break;
            }
        }
        return needToChange ? sb2.toString() : s2;
    }

    private static boolean isValidHexChar(char c4) {
        return ('0' <= c4 && c4 <= '9') || ('a' <= c4 && c4 <= 'f') || ('A' <= c4 && c4 <= 'F');
    }
}
