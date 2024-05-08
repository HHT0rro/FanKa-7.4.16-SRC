package p7;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Executor f52912a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final Executor f52913b = new s();

    /* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements Executor {

        /* renamed from: b, reason: collision with root package name */
        public final Handler f52914b = new l7.a(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(@NonNull Runnable runnable) {
            this.f52914b.post(runnable);
        }
    }
}
