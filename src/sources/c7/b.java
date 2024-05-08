package c7;

import android.os.Process;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f1561b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1562c = 0;

    public b(Runnable runnable, int i10) {
        this.f1561b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f1562c);
        this.f1561b.run();
    }
}
