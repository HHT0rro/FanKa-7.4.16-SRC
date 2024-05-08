package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class CharSequenceTranslator {
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String hex(int i10) {
        return Integer.toHexString(i10).toUpperCase(Locale.ENGLISH);
    }

    public abstract int translate(CharSequence charSequence, int i10, Writer writer) throws IOException;

    public final String translate(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(charSequence.length() * 2);
            translate(charSequence, stringWriter);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final CharSequenceTranslator with(CharSequenceTranslator... charSequenceTranslatorArr) {
        CharSequenceTranslator[] charSequenceTranslatorArr2 = new CharSequenceTranslator[charSequenceTranslatorArr.length + 1];
        charSequenceTranslatorArr2[0] = this;
        System.arraycopy(charSequenceTranslatorArr, 0, charSequenceTranslatorArr2, 1, charSequenceTranslatorArr.length);
        return new AggregateTranslator(charSequenceTranslatorArr2);
    }

    public final void translate(CharSequence charSequence, Writer writer) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }
        if (charSequence == null) {
            return;
        }
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int translate = translate(charSequence, i10, writer);
            if (translate == 0) {
                char charAt = charSequence.charAt(i10);
                writer.write(charAt);
                i10++;
                if (Character.isHighSurrogate(charAt) && i10 < length) {
                    char charAt2 = charSequence.charAt(i10);
                    if (Character.isLowSurrogate(charAt2)) {
                        writer.write(charAt2);
                        i10++;
                    }
                }
            } else {
                for (int i11 = 0; i11 < translate; i11++) {
                    i10 += Character.charCount(Character.codePointAt(charSequence, i10));
                }
            }
        }
    }
}
