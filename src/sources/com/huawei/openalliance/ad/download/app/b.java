package com.huawei.openalliance.ad.download.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.au;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {
    private static final String B = "reserveappstatus";
    private static final String C = "com.huawei.hms.pps.action.APP_RESERVE_STATUS_CHANGED";
    private static final String Code = "AgReserveDownloadManager";
    private static final String D = "com.huawei.appmarket.RECV_THIRD_COMMON_MSG";
    private static final int F = 2;
    private static final String I = "com.huawei.appgallery.reserveappstatus";
    private static b L = null;
    private static final String S = "callerpackage";
    private static final byte[] V = new byte[0];
    private static final String Z = "reserveapp";

    /* renamed from: a, reason: collision with root package name */
    private a f32404a;

    /* renamed from: b, reason: collision with root package name */
    private c f32405b;

    /* renamed from: c, reason: collision with root package name */
    private com.huawei.openalliance.ad.download.f f32406c;

    /* renamed from: d, reason: collision with root package name */
    private Context f32407d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, WeakHashMap<com.huawei.openalliance.ad.download.g, Object>> f32408e = new ConcurrentHashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            gl.V(b.Code, "reserve broadcast.");
            try {
                SafeIntent safeIntent = new SafeIntent(intent);
                String action = safeIntent.getAction();
                if (b.I.equals(action)) {
                    b.this.Code(safeIntent);
                } else {
                    gl.I(b.Code, "inValid para %s.", action);
                }
            } catch (IllegalStateException e2) {
                gl.I(b.Code, "reserve onReceive IllegalStateException: %s", e2.getClass().getSimpleName());
            } catch (Exception e10) {
                gl.I(b.Code, "reserve onReceive Exception: %s", e10.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class C0330b implements RemoteCallResultCallback<String> {
        private C0330b() {
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            gl.V(b.Code, "reserve app %s.", Integer.valueOf(callResult.getCode()));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            gl.V(b.Code, "silent reserve broadcast.");
            b.this.Code(context, intent);
        }
    }

    private b(Context context) {
        String str;
        this.f32407d = context.getApplicationContext();
        try {
            Code();
        } catch (IllegalStateException unused) {
            str = "registerReceiver IllegalStateException";
            gl.I(Code, str);
        } catch (Exception unused2) {
            str = "registerReceiver Exception";
            gl.I(Code, str);
        }
    }

    public static b Code(Context context) {
        b bVar;
        synchronized (V) {
            if (L == null) {
                L = new b(context);
            }
            bVar = L;
        }
        return bVar;
    }

    private synchronized WeakHashMap<com.huawei.openalliance.ad.download.g, Object> Code(String str) {
        return this.f32408e.get(str);
    }

    private void Code() {
        this.f32404a = new a();
        this.f32407d.registerReceiver(this.f32404a, new IntentFilter(I), D, null);
        this.f32405b = new c();
        this.f32407d.registerReceiver(this.f32405b, new IntentFilter(C), "com.huawei.permission.app.DOWNLOAD", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Context context, Intent intent) {
        try {
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if (C.equals(action) && context != null) {
                String stringExtra = safeIntent.getStringExtra(S);
                String packageName = context.getPackageName();
                if (!au.Code(stringExtra, packageName)) {
                    gl.V(Code, "caller does not match, caller %s, currentPackage %s.", stringExtra, packageName);
                    return;
                } else if (safeIntent.getIntExtra(B, -1) == 0) {
                    gl.V(Code, "silent reserve failed no need to notify");
                    return;
                } else {
                    Code(safeIntent);
                    return;
                }
            }
            gl.I(Code, "reserve onReceive inValid para %s.", action);
        } catch (IllegalStateException e2) {
            gl.I(Code, "silent reserve onReceive IllegalStateException: %s", e2.getClass().getSimpleName());
        } catch (Exception e10) {
            gl.I(Code, "silent reserve onReceive Exception: %s", e10.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Intent intent) {
        String stringExtra = intent.getStringExtra(Z);
        int intExtra = intent.getIntExtra(B, -1);
        gl.V(Code, "reserve status: %s", Integer.valueOf(intExtra));
        if (intExtra == 2) {
            intExtra = 1;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            gl.V(Code, "pkg is null");
        } else {
            Code(stringExtra, intExtra);
        }
    }

    private void Code(String str, int i10) {
        WeakHashMap<com.huawei.openalliance.ad.download.g, Object> Code2 = Code(str);
        if (Code2 != null && Code2.size() > 0) {
            for (com.huawei.openalliance.ad.download.g gVar : Code2.h()) {
                if (gVar != null) {
                    gVar.Code(str, i10);
                }
            }
        }
        com.huawei.openalliance.ad.download.f fVar = this.f32406c;
        if (fVar != null) {
            fVar.Code(str, i10);
        }
    }

    public void Code(AppDownloadTask appDownloadTask) {
        com.huawei.openalliance.ad.download.app.c.Z(this.f32407d, appDownloadTask, new C0330b(), String.class);
    }

    public void Code(com.huawei.openalliance.ad.download.f fVar) {
        this.f32406c = fVar;
    }

    public synchronized void Code(String str, com.huawei.openalliance.ad.download.g gVar) {
        WeakHashMap<com.huawei.openalliance.ad.download.g, Object> weakHashMap = this.f32408e.get(str);
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap<>();
            this.f32408e.put(str, weakHashMap);
        }
        weakHashMap.put(gVar, null);
    }

    public synchronized void V(String str, com.huawei.openalliance.ad.download.g gVar) {
        WeakHashMap<com.huawei.openalliance.ad.download.g, Object> weakHashMap = this.f32408e.get(str);
        if (weakHashMap != null && weakHashMap.size() > 0) {
            weakHashMap.remove(gVar);
            if (weakHashMap.size() <= 0) {
                this.f32408e.remove(str);
            }
        }
    }
}
