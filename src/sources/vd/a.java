package vd;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JDK7PlatformImplementations.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a extends ud.a {

    /* compiled from: JDK7PlatformImplementations.kt */
    /* renamed from: vd.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class C0831a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C0831a f54088a = new C0831a();

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public static final Integer f54089b;

        /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
        static {
            /*
                vd.a$a r0 = new vd.a$a
                r0.<init>()
                vd.a.C0831a.f54088a = r0
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L1f
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L1f
                boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> L1f
                if (r2 == 0) goto L1f
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L1f
                goto L20
            L1f:
                r1 = r0
            L20:
                if (r1 == 0) goto L2e
                int r2 = r1.intValue()
                if (r2 <= 0) goto L2a
                r2 = 1
                goto L2b
            L2a:
                r2 = 0
            L2b:
                if (r2 == 0) goto L2e
                r0 = r1
            L2e:
                vd.a.C0831a.f54089b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: vd.a.C0831a.<clinit>():void");
        }
    }

    @Override // ud.a
    public void a(@NotNull Throwable cause, @NotNull Throwable exception) {
        s.i(cause, "cause");
        s.i(exception, "exception");
        if (c(19)) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }

    public final boolean c(int i10) {
        Integer num = C0831a.f54089b;
        return num == null || num.intValue() >= i10;
    }
}
