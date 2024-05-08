package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class CodePointTranslator extends CharSequenceTranslator {
    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public final int translate(CharSequence charSequence, int i10, Writer writer) throws IOException {
        return translate(Character.codePointAt(charSequence, i10), writer) ? 1 : 0;
    }

    public abstract boolean translate(int i10, Writer writer) throws IOException;
}
