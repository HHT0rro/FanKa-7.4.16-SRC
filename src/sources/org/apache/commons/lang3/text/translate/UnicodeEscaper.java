package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class UnicodeEscaper extends CodePointTranslator {
    private final int above;
    private final int below;
    private final boolean between;

    public UnicodeEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    public static UnicodeEscaper above(int i10) {
        return outsideOf(0, i10);
    }

    public static UnicodeEscaper below(int i10) {
        return outsideOf(i10, Integer.MAX_VALUE);
    }

    public static UnicodeEscaper between(int i10, int i11) {
        return new UnicodeEscaper(i10, i11, true);
    }

    public static UnicodeEscaper outsideOf(int i10, int i11) {
        return new UnicodeEscaper(i10, i11, false);
    }

    public String toUtf16Escape(int i10) {
        return "\\u" + CharSequenceTranslator.hex(i10);
    }

    @Override // org.apache.commons.lang3.text.translate.CodePointTranslator
    public boolean translate(int i10, Writer writer) throws IOException {
        if (this.between) {
            if (i10 < this.below || i10 > this.above) {
                return false;
            }
        } else if (i10 >= this.below && i10 <= this.above) {
            return false;
        }
        if (i10 > 65535) {
            writer.write(toUtf16Escape(i10));
            return true;
        }
        writer.write("\\u");
        char[] cArr = CharSequenceTranslator.HEX_DIGITS;
        writer.write(cArr[(i10 >> 12) & 15]);
        writer.write(cArr[(i10 >> 8) & 15]);
        writer.write(cArr[(i10 >> 4) & 15]);
        writer.write(cArr[i10 & 15]);
        return true;
    }

    public UnicodeEscaper(int i10, int i11, boolean z10) {
        this.below = i10;
        this.above = i11;
        this.between = z10;
    }
}
