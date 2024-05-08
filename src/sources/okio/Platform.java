package okio;

import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import kotlin.text.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: -Platform.kt */
@d
/* renamed from: okio.-Platform, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Platform {
    @NotNull
    public static final byte[] asUtf8ToByteArray(@NotNull String asUtf8ToByteArray) {
        s.i(asUtf8ToByteArray, "$this$asUtf8ToByteArray");
        byte[] bytes = asUtf8ToByteArray.getBytes(c.f51097b);
        s.h(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    /* renamed from: synchronized, reason: not valid java name */
    public static final <R> R m3728synchronized(@NotNull Object lock, @NotNull Function0<? extends R> block) {
        R invoke;
        s.i(lock, "lock");
        s.i(block, "block");
        synchronized (lock) {
            try {
                invoke = block.invoke();
                r.b(1);
            } catch (Throwable th) {
                r.b(1);
                r.a(1);
                throw th;
            }
        }
        r.a(1);
        return invoke;
    }

    @NotNull
    public static final String toUtf8String(@NotNull byte[] toUtf8String) {
        s.i(toUtf8String, "$this$toUtf8String");
        return new String(toUtf8String, c.f51097b);
    }
}
