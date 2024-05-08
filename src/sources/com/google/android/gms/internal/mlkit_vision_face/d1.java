package com.google.android.gms.internal.mlkit_vision_face;

import java.io.PrintStream;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d1 {

    /* renamed from: a, reason: collision with root package name */
    public static final x0 f24802a;

    static {
        x0 b1Var;
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e2) {
                System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e2.printStackTrace(System.err);
            }
            if (num == null || num.intValue() < 19) {
                b1Var = !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new a1() : new b1();
            } else {
                b1Var = new c1();
            }
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = b1.class.getName();
            StringBuilder sb2 = new StringBuilder(name.length() + 133);
            sb2.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb2.append(name);
            sb2.append("will be used. The error is: ");
            printStream.println(sb2.toString());
            th.printStackTrace(System.err);
            b1Var = new b1();
        }
        f24802a = b1Var;
        if (num == null) {
            return;
        }
        num.intValue();
    }

    public static void a(Throwable th, Throwable th2) {
        f24802a.a(th, th2);
    }
}
