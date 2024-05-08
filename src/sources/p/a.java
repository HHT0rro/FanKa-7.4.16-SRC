package p;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: MinosSecurityLoad_5c2ca5276b6d256e72085145adbe88ad.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f52723a = new AtomicBoolean(false);

    public static void a(String str) {
        if (f52723a.compareAndSet(false, true)) {
            System.loadLibrary(str);
            f52723a.set(false);
        }
    }
}
