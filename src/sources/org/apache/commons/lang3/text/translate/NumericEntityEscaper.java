package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class NumericEntityEscaper extends CodePointTranslator {
    private final int above;
    private final int below;
    private final boolean between;

    private NumericEntityEscaper(int i10, int i11, boolean z10) {
        this.below = i10;
        this.above = i11;
        this.between = z10;
    }

    public static NumericEntityEscaper above(int i10) {
        return outsideOf(0, i10);
    }

    public static NumericEntityEscaper below(int i10) {
        return outsideOf(i10, Integer.MAX_VALUE);
    }

    public static NumericEntityEscaper between(int i10, int i11) {
        return new NumericEntityEscaper(i10, i11, true);
    }

    public static NumericEntityEscaper outsideOf(int i10, int i11) {
        return new NumericEntityEscaper(i10, i11, false);
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
        writer.write("&#");
        writer.write(Integer.toString(i10, 10));
        writer.write(59);
        return true;
    }

    public NumericEntityEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }
}
