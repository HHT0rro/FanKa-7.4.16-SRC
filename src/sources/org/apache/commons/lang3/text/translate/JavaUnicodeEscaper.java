package org.apache.commons.lang3.text.translate;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class JavaUnicodeEscaper extends UnicodeEscaper {
    public JavaUnicodeEscaper(int i10, int i11, boolean z10) {
        super(i10, i11, z10);
    }

    public static JavaUnicodeEscaper above(int i10) {
        return outsideOf(0, i10);
    }

    public static JavaUnicodeEscaper below(int i10) {
        return outsideOf(i10, Integer.MAX_VALUE);
    }

    public static JavaUnicodeEscaper between(int i10, int i11) {
        return new JavaUnicodeEscaper(i10, i11, true);
    }

    public static JavaUnicodeEscaper outsideOf(int i10, int i11) {
        return new JavaUnicodeEscaper(i10, i11, false);
    }

    @Override // org.apache.commons.lang3.text.translate.UnicodeEscaper
    public String toUtf16Escape(int i10) {
        char[] chars = Character.toChars(i10);
        return "\\u" + CharSequenceTranslator.hex(chars[0]) + "\\u" + CharSequenceTranslator.hex(chars[1]);
    }
}
