package ac;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {

    /* renamed from: f, reason: collision with root package name */
    public static e f737f;

    /* renamed from: a, reason: collision with root package name */
    public Network f738a = null;

    /* renamed from: b, reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f739b = null;

    /* renamed from: c, reason: collision with root package name */
    public ConnectivityManager f740c = null;

    /* renamed from: d, reason: collision with root package name */
    public List<c> f741d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public Timer f742e = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network network) {
            super.onAvailable(network);
            h.g("Network onAvailable");
            e.this.f738a = network;
            e.this.g(true, network);
            try {
                String extraInfo = e.this.f740c.getNetworkInfo(e.this.f738a).getExtraInfo();
                if (TextUtils.isEmpty(extraInfo)) {
                    return;
                }
                i.j(extraInfo);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network network) {
            super.onLost(network);
            h.g("Network onLost");
            e.this.i();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onUnavailable() {
            super.onUnavailable();
            h.g("Network onUnavailable");
            e.this.g(false, null);
            e.this.i();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            e.this.g(false, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface c {
        void a(boolean z10, Object obj);
    }

    public static e a() {
        if (f737f == null) {
            synchronized (e.class) {
                if (f737f == null) {
                    f737f = new e();
                }
            }
        }
        return f737f;
    }

    public final synchronized void d(c cVar) {
        try {
            this.f741d.add(cVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final synchronized void f(Context context, c cVar) {
        Network network = this.f738a;
        if (network != null) {
            cVar.a(true, network);
            return;
        }
        d(cVar);
        if (this.f739b == null || this.f741d.size() < 2) {
            try {
                this.f740c = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addTransportType(0);
                builder.addCapability(12);
                NetworkRequest build = builder.build();
                this.f739b = new a();
                int i10 = 3000;
                if (i.o() < 3000) {
                    i10 = 2000;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f740c.requestNetwork(build, this.f739b, i10);
                    return;
                }
                Timer timer = new Timer();
                this.f742e = timer;
                timer.schedule(new b(), i10);
                this.f740c.requestNetwork(build, this.f739b);
            } catch (Exception e2) {
                e2.printStackTrace();
                g(false, null);
            }
        }
    }

    public final synchronized void g(boolean z10, Network network) {
        try {
            Timer timer = this.f742e;
            if (timer != null) {
                timer.cancel();
                this.f742e = null;
            }
            Iterator<c> iterator2 = this.f741d.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(z10, network);
            }
            this.f741d.clear();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final synchronized void i() {
        ConnectivityManager.NetworkCallback networkCallback;
        try {
            Timer timer = this.f742e;
            if (timer != null) {
                timer.cancel();
                this.f742e = null;
            }
            ConnectivityManager connectivityManager = this.f740c;
            if (connectivityManager != null && (networkCallback = this.f739b) != null) {
                connectivityManager.unregisterNetworkCallback(networkCallback);
            }
            this.f740c = null;
            this.f739b = null;
            this.f738a = null;
            this.f741d.clear();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
