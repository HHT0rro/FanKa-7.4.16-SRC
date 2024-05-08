package com.google.android.exoplayer2.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: NetworkTypeObserver.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class s {

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public static s f23021e;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f23022a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<WeakReference<c>> f23023b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final Object f23024c = new Object();

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("networkTypeLock")
    public int f23025d = 0;

    /* compiled from: NetworkTypeObserver.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static volatile boolean f23026a;
    }

    /* compiled from: NetworkTypeObserver.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface c {
        void a(int i10);
    }

    /* compiled from: NetworkTypeObserver.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int g3 = s.g(context);
            int i10 = j0.f22990a;
            if (i10 >= 29 && !b.f23026a && g3 == 5) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) com.google.android.exoplayer2.util.a.e((TelephonyManager) context.getSystemService("phone"));
                    e eVar = new e();
                    if (i10 < 31) {
                        telephonyManager.listen(eVar, 1);
                    } else {
                        telephonyManager.listen(eVar, 1048576);
                    }
                    telephonyManager.listen(eVar, 0);
                    return;
                } catch (RuntimeException unused) {
                }
            }
            s.this.k(g3);
        }
    }

    /* compiled from: NetworkTypeObserver.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class e extends PhoneStateListener {
        public e() {
        }

        @Override // android.telephony.PhoneStateListener
        @RequiresApi(31)
        public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
            int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
            s.this.k(overrideNetworkType == 3 || overrideNetworkType == 4 ? 10 : 5);
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(@Nullable ServiceState serviceState) {
            String serviceState2 = serviceState == null ? "" : serviceState.toString();
            s.this.k(serviceState2.contains("nrState=CONNECTED") || serviceState2.contains("nrState=NOT_RESTRICTED") ? 10 : 5);
        }
    }

    public s(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new d(), intentFilter);
    }

    public static synchronized s d(Context context) {
        s sVar;
        synchronized (s.class) {
            if (f23021e == null) {
                f23021e = new s(context);
            }
            sVar = f23021e;
        }
        return sVar;
    }

    public static int e(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return j0.f22990a >= 29 ? 9 : 0;
        }
    }

    public static int g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i10 = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i10 = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (type != 4 && type != 5) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return e(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(c cVar) {
        cVar.a(f());
    }

    public int f() {
        int i10;
        synchronized (this.f23024c) {
            i10 = this.f23025d;
        }
        return i10;
    }

    public void i(final c cVar) {
        j();
        this.f23023b.add(new WeakReference<>(cVar));
        this.f23022a.post(new Runnable() { // from class: com.google.android.exoplayer2.util.r
            @Override // java.lang.Runnable
            public final void run() {
                s.this.h(cVar);
            }
        });
    }

    public final void j() {
        Iterator<WeakReference<c>> iterator2 = this.f23023b.iterator2();
        while (iterator2.hasNext()) {
            WeakReference<c> next = iterator2.next();
            if (next.get() == null) {
                this.f23023b.remove(next);
            }
        }
    }

    public final void k(int i10) {
        synchronized (this.f23024c) {
            if (this.f23025d == i10) {
                return;
            }
            this.f23025d = i10;
            Iterator<WeakReference<c>> iterator2 = this.f23023b.iterator2();
            while (iterator2.hasNext()) {
                WeakReference<c> next = iterator2.next();
                c cVar = next.get();
                if (cVar != null) {
                    cVar.a(i10);
                } else {
                    this.f23023b.remove(next);
                }
            }
        }
    }
}
