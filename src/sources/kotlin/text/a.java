package kotlin.text;

import kotlin.ranges.IntRange;

/* compiled from: CharJVM.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a {
    public static final int a(int i10) {
        if (new IntRange(2, 36).i(i10)) {
            return i10;
        }
        throw new IllegalArgumentException("radix " + i10 + " was not in valid range " + ((Object) new IntRange(2, 36)));
    }

    public static final int b(char c4, int i10) {
        return Character.digit((int) c4, i10);
    }

    public static final boolean c(char c4) {
        return Character.isWhitespace(c4) || Character.isSpaceChar(c4);
    }
}
