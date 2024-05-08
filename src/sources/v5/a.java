package v5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.util.j0;
import v5.a;

/* compiled from: RequirementsWatcher.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f54032a;

    /* renamed from: b, reason: collision with root package name */
    public final c f54033b;

    /* renamed from: c, reason: collision with root package name */
    public final Requirements f54034c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f54035d = j0.z();

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public b f54036e;

    /* renamed from: f, reason: collision with root package name */
    public int f54037f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public d f54038g;

    /* compiled from: RequirementsWatcher.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            a.this.e();
        }
    }

    /* compiled from: RequirementsWatcher.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface c {
        void a(a aVar, int i10);
    }

    /* compiled from: RequirementsWatcher.java */
    @RequiresApi(24)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class d extends ConnectivityManager.NetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        public boolean f54040a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f54041b;

        public d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            if (a.this.f54038g != null) {
                a.this.e();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            if (a.this.f54038g != null) {
                a.this.g();
            }
        }

        public final void e() {
            a.this.f54035d.post(new Runnable() { // from class: v5.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.d.this.c();
                }
            });
        }

        public final void f() {
            a.this.f54035d.post(new Runnable() { // from class: v5.c
                @Override // java.lang.Runnable
                public final void run() {
                    a.d.this.d();
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            e();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network network, boolean z10) {
            if (z10) {
                return;
            }
            f();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean hasCapability = networkCapabilities.hasCapability(16);
            if (this.f54040a && this.f54041b == hasCapability) {
                if (hasCapability) {
                    f();
                }
            } else {
                this.f54040a = true;
                this.f54041b = hasCapability;
                e();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            e();
        }
    }

    public a(Context context, c cVar, Requirements requirements) {
        this.f54032a = context.getApplicationContext();
        this.f54033b = cVar;
        this.f54034c = requirements;
    }

    public final void e() {
        int b4 = this.f54034c.b(this.f54032a);
        if (this.f54037f != b4) {
            this.f54037f = b4;
            this.f54033b.a(this, b4);
        }
    }

    public Requirements f() {
        return this.f54034c;
    }

    public final void g() {
        if ((this.f54037f & 3) == 0) {
            return;
        }
        e();
    }

    @RequiresApi(24)
    public final void h() {
        ConnectivityManager connectivityManager = (ConnectivityManager) com.google.android.exoplayer2.util.a.e((ConnectivityManager) this.f54032a.getSystemService("connectivity"));
        d dVar = new d();
        this.f54038g = dVar;
        connectivityManager.registerDefaultNetworkCallback(dVar);
    }

    public int i() {
        this.f54037f = this.f54034c.b(this.f54032a);
        IntentFilter intentFilter = new IntentFilter();
        if (this.f54034c.i()) {
            if (j0.f22990a >= 24) {
                h();
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.f54034c.d()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.f54034c.g()) {
            if (j0.f22990a >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        if (this.f54034c.k()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        b bVar = new b();
        this.f54036e = bVar;
        this.f54032a.registerReceiver(bVar, intentFilter, null, this.f54035d);
        return this.f54037f;
    }

    public void j() {
        this.f54032a.unregisterReceiver((BroadcastReceiver) com.google.android.exoplayer2.util.a.e(this.f54036e));
        this.f54036e = null;
        if (j0.f22990a < 24 || this.f54038g == null) {
            return;
        }
        k();
    }

    @RequiresApi(24)
    public final void k() {
        ((ConnectivityManager) com.google.android.exoplayer2.util.a.e((ConnectivityManager) this.f54032a.getSystemService("connectivity"))).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) com.google.android.exoplayer2.util.a.e(this.f54038g));
        this.f54038g = null;
    }
}
