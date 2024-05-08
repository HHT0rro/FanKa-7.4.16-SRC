package com.huawei.openalliance.ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.constant.u;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d {
    private static d I;
    private static final byte[] Z = new byte[0];
    private Context B;
    private a S;
    private boolean V = false;
    private CopyOnWriteArrayList<WeakReference<b>> C = new CopyOnWriteArrayList<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            gl.V("ExSplashStartReceiver", "onReceive");
            if (intent == null) {
                return;
            }
            try {
                if (u.bl.equals(intent.getAction())) {
                    d.this.V = true;
                    d.this.Z();
                    context.removeStickyBroadcast(intent);
                }
            } catch (Throwable th) {
                gl.I("ExSplashStartReceiver", "ExSplashBeginReceiver err: %s", th.getClass().getSimpleName());
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface b {
        void Code();
    }

    private d(Context context) {
        this.B = context.getApplicationContext();
    }

    public static d Code(Context context) {
        d dVar;
        synchronized (Z) {
            if (I == null) {
                I = new d(context);
            }
            dVar = I;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        if (this.C.isEmpty()) {
            return;
        }
        Iterator<WeakReference<b>> iterator2 = this.C.iterator2();
        while (iterator2.hasNext()) {
            WeakReference<b> next = iterator2.next();
            if (next.get() != null) {
                next.get().Code();
            }
        }
    }

    public void Code(b bVar) {
        if (bVar != null) {
            this.C.add(new WeakReference<>(bVar));
        }
    }

    public void Code(boolean z10) {
        this.V = z10;
    }

    public void I() {
        String str;
        try {
            gl.V("ExSplashStartReceiver", "unregister receiver");
            a aVar = this.S;
            if (aVar != null) {
                this.B.unregisterReceiver(aVar);
                this.S = null;
            }
        } catch (IllegalStateException unused) {
            str = "unregisterReceiver IllegalStateException";
            gl.I("ExSplashStartReceiver", str);
        } catch (Throwable unused2) {
            str = "unregisterReceiver exception";
            gl.I("ExSplashStartReceiver", str);
        }
    }

    public void V() {
        String str;
        try {
            I();
            if (!ea.B(this.B)) {
                gl.I("ExSplashStartReceiver", "not inner device, no need to register");
                return;
            }
            IntentFilter intentFilter = new IntentFilter(u.bl);
            Intent registerReceiver = this.B.registerReceiver(null, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            if (registerReceiver != null && registerReceiver.getAction() != null && registerReceiver.getAction().equals(u.bl)) {
                gl.V("ExSplashStartReceiver", "isExSplashStart");
                this.V = true;
                this.B.removeStickyBroadcast(registerReceiver);
            }
            if (this.S == null) {
                this.S = new a();
            }
            gl.V("ExSplashStartReceiver", "register receiver");
            this.B.registerReceiver(this.S, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
        } catch (IllegalStateException unused) {
            str = "registerReceiver IllegalStateException";
            gl.I("ExSplashStartReceiver", str);
        } catch (Throwable unused2) {
            str = "registerReceiver Exception";
            gl.I("ExSplashStartReceiver", str);
        }
    }

    public void V(b bVar) {
        try {
            CopyOnWriteArrayList<WeakReference<b>> copyOnWriteArrayList = this.C;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                Iterator<WeakReference<b>> iterator2 = this.C.iterator2();
                while (iterator2.hasNext()) {
                    WeakReference<b> next = iterator2.next();
                    b bVar2 = next.get();
                    if (bVar2 == null || bVar2 == bVar) {
                        this.C.remove(next);
                    }
                }
            }
        } catch (Throwable th) {
            gl.V("ExSplashStartReceiver", "removeStartListener err: %s", th.getClass().getSimpleName());
        }
    }
}
