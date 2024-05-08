package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class OctalUnescaper extends CharSequenceTranslator {
    private boolean isOctalDigit(char c4) {
        return c4 >= '0' && c4 <= '7';
    }

    private boolean isZeroToThree(char c4) {
        return c4 >= '0' && c4 <= '3';
    }

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i10, Writer writer) throws IOException {
        int length = (charSequence.length() - i10) - 1;
        StringBuilder sb2 = new StringBuilder();
        if (charSequence.charAt(i10) != '\\' || length <= 0) {
            return 0;
        }
        int i11 = i10 + 1;
        if (!isOctalDigit(charSequence.charAt(i11))) {
            return 0;
        }
        int i12 = i10 + 2;
        int i13 = i10 + 3;
        sb2.append(charSequence.charAt(i11));
        if (length > 1 && isOctalDigit(charSequence.charAt(i12))) {
            sb2.append(charSequence.charAt(i12));
            if (length > 2 && isZeroToThree(charSequence.charAt(i11)) && isOctalDigit(charSequence.charAt(i13))) {
                sb2.append(charSequence.charAt(i13));
            }
        }
        writer.write(Integer.parseInt(sb2.toString(), 8));
        return sb2.length() + 1;
    }
}
