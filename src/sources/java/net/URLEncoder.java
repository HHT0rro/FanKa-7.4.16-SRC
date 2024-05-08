package java.net;

import java.io.CharArrayWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import java.util.Objects;
import sun.security.action.GetPropertyAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class URLEncoder {
    static final int caseDiff = 32;
    static String dfltEncName;
    static BitSet dontNeedEncoding = new BitSet(256);

    static {
        dfltEncName = null;
        for (int i10 = 97; i10 <= 122; i10++) {
            dontNeedEncoding.set(i10);
        }
        for (int i11 = 65; i11 <= 90; i11++) {
            dontNeedEncoding.set(i11);
        }
        for (int i12 = 48; i12 <= 57; i12++) {
            dontNeedEncoding.set(i12);
        }
        dontNeedEncoding.set(32);
        dontNeedEncoding.set(45);
        dontNeedEncoding.set(95);
        dontNeedEncoding.set(46);
        dontNeedEncoding.set(42);
        dfltEncName = GetPropertyAction.privilegedGetProperty("file.encoding");
    }

    private URLEncoder() {
    }

    @Deprecated
    public static String encode(String s2) {
        try {
            String str = encode(s2, dfltEncName);
            return str;
        } catch (UnsupportedEncodingException e2) {
            return null;
        }
    }

    public static String encode(String s2, String enc) throws UnsupportedEncodingException {
        if (enc == null) {
            throw new NullPointerException("charsetName");
        }
        try {
            Charset charset = Charset.forName(enc);
            return encode(s2, charset);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e2) {
            throw new UnsupportedEncodingException(enc);
        }
    }

    public static String encode(String s2, Charset charset) {
        BitSet bitSet;
        int charAt;
        int d10;
        Objects.requireNonNull(charset, "charset");
        boolean needToChange = false;
        StringBuilder out = new StringBuilder(s2.length());
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        int i10 = 0;
        while (i10 < s2.length()) {
            int c4 = s2.charAt(i10);
            if (dontNeedEncoding.get(c4)) {
                if (c4 == 32) {
                    c4 = 43;
                    needToChange = true;
                }
                out.append((char) c4);
                i10++;
            } else {
                do {
                    charArrayWriter.write(c4);
                    if (c4 >= 55296 && c4 <= 56319 && i10 + 1 < s2.length() && (d10 = s2.charAt(i10 + 1)) >= 56320 && d10 <= 57343) {
                        charArrayWriter.write(d10);
                        i10++;
                    }
                    i10++;
                    if (i10 >= s2.length()) {
                        break;
                    }
                    bitSet = dontNeedEncoding;
                    charAt = s2.charAt(i10);
                    c4 = charAt;
                } while (!bitSet.get(charAt));
                charArrayWriter.flush();
                String str = new String(charArrayWriter.toCharArray());
                byte[] ba2 = str.getBytes(charset);
                for (int j10 = 0; j10 < ba2.length; j10++) {
                    out.append('%');
                    char ch = Character.forDigit((ba2[j10] >> 4) & 15, 16);
                    if (Character.isLetter(ch)) {
                        ch = (char) (ch - ' ');
                    }
                    out.append(ch);
                    char ch2 = Character.forDigit(ba2[j10] & 15, 16);
                    if (Character.isLetter(ch2)) {
                        ch2 = (char) (ch2 - ' ');
                    }
                    out.append(ch2);
                }
                charArrayWriter.reset();
                needToChange = true;
            }
        }
        return needToChange ? out.toString() : s2;
    }
}
