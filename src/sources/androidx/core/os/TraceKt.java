package androidx.core.os;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Trace.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class TraceKt {
    public static final <T> T trace(@NotNull String sectionName, @NotNull Function0<? extends T> block) {
        s.i(sectionName, "sectionName");
        s.i(block, "block");
        TraceCompat.beginSection(sectionName);
        try {
            return block.invoke();
        } finally {
            r.b(1);
            TraceCompat.endSection();
            r.a(1);
        }
    }
}
