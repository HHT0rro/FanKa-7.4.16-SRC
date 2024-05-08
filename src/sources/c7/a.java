package c7;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.h;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a implements ThreadFactory {

    /* renamed from: b, reason: collision with root package name */
    public final String f1557b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1558c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicInteger f1559d;

    /* renamed from: e, reason: collision with root package name */
    public final ThreadFactory f1560e;

    public a(@RecentlyNonNull String str) {
        this(str, 0);
    }

    @Override // java.util.concurrent.ThreadFactory
    @RecentlyNonNull
    public Thread newThread(@RecentlyNonNull Runnable runnable) {
        Thread newThread = this.f1560e.newThread(new b(runnable, 0));
        String str = this.f1557b;
        int andIncrement = this.f1559d.getAndIncrement();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 13);
        sb2.append(str);
        sb2.append("[");
        sb2.append(andIncrement);
        sb2.append("]");
        newThread.setName(sb2.toString());
        return newThread;
    }

    public a(String str, int i10) {
        this.f1559d = new AtomicInteger();
        this.f1560e = Executors.defaultThreadFactory();
        this.f1557b = (String) h.i(str, "Name must not be null");
        this.f1558c = 0;
    }
}
