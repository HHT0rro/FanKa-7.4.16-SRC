package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class UnicodeUnescaper extends CharSequenceTranslator {
    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i10, Writer writer) throws IOException {
        int i11;
        int i12;
        if (charSequence.charAt(i10) != '\\' || (i11 = i10 + 1) >= charSequence.length() || charSequence.charAt(i11) != 'u') {
            return 0;
        }
        int i13 = 2;
        while (true) {
            i12 = i10 + i13;
            if (i12 >= charSequence.length() || charSequence.charAt(i12) != 'u') {
                break;
            }
            i13++;
        }
        if (i12 < charSequence.length() && charSequence.charAt(i12) == '+') {
            i13++;
        }
        int i14 = i10 + i13;
        int i15 = i14 + 4;
        if (i15 <= charSequence.length()) {
            CharSequence subSequence = charSequence.subSequence(i14, i15);
            try {
                writer.write((char) Integer.parseInt(subSequence.toString(), 16));
                return i13 + 4;
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException("Unable to parse unicode value: " + ((Object) subSequence), e2);
            }
        }
        throw new IllegalArgumentException("Less than 4 hex digits in unicode value: '" + ((Object) charSequence.subSequence(i10, charSequence.length())) + "' due to end of CharSequence");
    }
}
