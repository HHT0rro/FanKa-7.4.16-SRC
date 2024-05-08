package y8;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final ExecutorService f54687a = Executors.newSingleThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    public static Handler f54688b = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        f54687a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        f54688b.post(runnable);
    }
}
