package td;

import java.lang.reflect.Field;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.s;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DebugMetadata.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e {
    public static final void a(int i10, int i11) {
        if (i11 <= i10) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i10 + ", got " + i11 + ". Please update the Kotlin standard library.").toString());
    }

    public static final d b(BaseContinuationImpl baseContinuationImpl) {
        return (d) baseContinuationImpl.getClass().getAnnotation(d.class);
    }

    public static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @Nullable
    public static final StackTraceElement d(@NotNull BaseContinuationImpl baseContinuationImpl) {
        String str;
        s.i(baseContinuationImpl, "<this>");
        d b4 = b(baseContinuationImpl);
        if (b4 == null) {
            return null;
        }
        a(1, b4.v());
        int c4 = c(baseContinuationImpl);
        int i10 = c4 < 0 ? -1 : b4.l()[c4];
        String b10 = g.f53809a.b(baseContinuationImpl);
        if (b10 == null) {
            str = b4.c();
        } else {
            str = b10 + IOUtils.DIR_SEPARATOR_UNIX + b4.c();
        }
        return new StackTraceElement(str, b4.m(), b4.f(), i10);
    }
}
