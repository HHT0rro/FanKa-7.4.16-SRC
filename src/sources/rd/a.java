package rd;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Thread.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a {

    /* compiled from: Thread.kt */
    /* renamed from: rd.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class C0815a extends Thread {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<p> f53386b;

        public C0815a(Function0<p> function0) {
            this.f53386b = function0;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f53386b.invoke();
        }
    }

    @NotNull
    public static final Thread a(boolean z10, boolean z11, @Nullable ClassLoader classLoader, @Nullable String str, int i10, @NotNull Function0<p> block) {
        s.i(block, "block");
        C0815a c0815a = new C0815a(block);
        if (z11) {
            c0815a.setDaemon(true);
        }
        if (i10 > 0) {
            c0815a.setPriority(i10);
        }
        if (str != null) {
            c0815a.setName(str);
        }
        if (classLoader != null) {
            c0815a.setContextClassLoader(classLoader);
        }
        if (z10) {
            c0815a.start();
        }
        return c0815a;
    }

    public static /* synthetic */ Thread b(boolean z10, boolean z11, ClassLoader classLoader, String str, int i10, Function0 function0, int i11, Object obj) {
        return a((i11 & 1) != 0 ? true : z10, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? null : classLoader, (i11 & 8) != 0 ? null : str, (i11 & 16) != 0 ? -1 : i10, function0);
    }
}
