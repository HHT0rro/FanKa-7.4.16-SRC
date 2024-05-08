package com.ss.android.downloadlib.m.m;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.m.m.ej;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m {

    /* renamed from: hc, reason: collision with root package name */
    private static volatile m f38806hc = null;

    /* renamed from: l, reason: collision with root package name */
    private static String f38807l = "";

    /* renamed from: n, reason: collision with root package name */
    private static String f38808n = "";
    private static String np = "";

    /* renamed from: c, reason: collision with root package name */
    private Context f38809c;

    /* renamed from: m, reason: collision with root package name */
    public ej f38811m;

    /* renamed from: e, reason: collision with root package name */
    private boolean f38810e = true;

    /* renamed from: w, reason: collision with root package name */
    private boolean f38814w = false;

    /* renamed from: oa, reason: collision with root package name */
    private volatile boolean f38812oa = false;
    private final List<Pair<dk, l>> ve = new ArrayList();
    public final List<InterfaceC0585m> dk = new ArrayList();
    private final ServiceConnection sy = new ServiceConnection() { // from class: com.ss.android.downloadlib.m.m.m.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (m.this.ej) {
                m.this.m(false);
                m.this.f38811m = ej.m.m(iBinder);
                m.this.ej();
                Iterator<InterfaceC0585m> iterator2 = m.this.dk.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().m();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (m.this.ej) {
                m.this.m(false);
                m mVar = m.this;
                mVar.f38811m = null;
                Iterator<InterfaceC0585m> iterator2 = mVar.dk.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().dk();
                }
            }
        }
    };

    /* renamed from: r, reason: collision with root package name */
    private String f38813r = "";
    public final Object ej = new Object();

    /* renamed from: com.ss.android.downloadlib.m.m.m$m, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0585m {
        void dk();

        void m();
    }

    private m() {
    }

    public static m m() {
        if (f38806hc == null) {
            synchronized (m.class) {
                if (f38806hc == null) {
                    f38806hc = new m();
                }
            }
        }
        return f38806hc;
    }

    public void dk() {
        if (this.f38811m != null) {
            this.f38809c.unbindService(this.sy);
            this.f38811m = null;
        }
        this.dk.clear();
        this.ve.clear();
    }

    public void ej() {
        for (Pair<dk, l> pair : this.ve) {
            try {
                this.f38811m.m((dk) pair.first, (l) pair.second);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.ve.clear();
    }

    public boolean l() {
        return this.f38812oa;
    }

    public boolean m(Context context, boolean z10) {
        if (TextUtils.isEmpty(f38807l)) {
            JSONObject w3 = c.w();
            String optString = w3.optString(t.f36222g);
            f38807l = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("q"), optString);
            np = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString(t.f36224i), optString);
            f38808n = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString(IAdInterListener.AdReqParam.WIDTH), optString);
        }
        this.f38814w = z10;
        if (context == null) {
            return true;
        }
        this.f38809c = context.getApplicationContext();
        if (TextUtils.isEmpty(f38808n)) {
            f38808n = this.f38809c.getPackageName();
        }
        if (this.f38811m != null || l()) {
            return true;
        }
        return this.f38809c.bindService(m(context), this.sy, 33);
    }

    public Intent m(Context context) {
        Intent intent = new Intent();
        intent.setAction(f38807l);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        Iterator<ResolveInfo> iterator2 = queryIntentServices.iterator2();
        while (iterator2.hasNext()) {
            ServiceInfo serviceInfo = iterator2.next().serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (np.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void m(dk dkVar, l lVar) {
        synchronized (this.ej) {
            dkVar.np = f38808n;
            if (TextUtils.isEmpty(dkVar.f38801n)) {
                dkVar.f38801n = this.f38813r;
            }
            ej ejVar = this.f38811m;
            if (ejVar != null) {
                try {
                    ejVar.m(dkVar, lVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (l() || m(this.f38809c, this.f38814w)) {
                this.ve.add(Pair.create(dkVar, lVar));
            }
        }
    }

    public void m(boolean z10) {
        this.f38812oa = z10;
    }
}
