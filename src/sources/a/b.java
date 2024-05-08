package a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class b implements ServiceConnection {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadPoolExecutor f658d = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());

    /* renamed from: b, reason: collision with root package name */
    public boolean f659b = false;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f660c = new LinkedBlockingQueue<>(1);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBinder f661b;

        public a(IBinder iBinder) {
            this.f661b = iBinder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                System.currentTimeMillis();
                b.this.f660c.offer(this.f661b);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        f658d.execute(new a(iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        System.currentTimeMillis();
    }
}
