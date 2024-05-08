package com.google.android.gms.internal.mlkit_vision_common;

import java.io.PrintStream;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final o7 f24300a;

    static {
        o7 dVar;
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e2) {
                System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e2.printStackTrace(System.err);
            }
            if (num == null || num.intValue() < 19) {
                dVar = !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new c() : new d();
            } else {
                dVar = new e();
            }
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = d.class.getName();
            StringBuilder sb2 = new StringBuilder(name.length() + 133);
            sb2.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb2.append(name);
            sb2.append("will be used. The error is: ");
            printStream.println(sb2.toString());
            th.printStackTrace(System.err);
            dVar = new d();
        }
        f24300a = dVar;
        if (num == null) {
            return;
        }
        num.intValue();
    }

    public static void a(Throwable th, Throwable th2) {
        f24300a.a(th, th2);
    }
}
