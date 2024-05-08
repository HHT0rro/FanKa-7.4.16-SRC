package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class hx {
    private static final String B = "NotificationActionManager";
    private static final byte[] C = new byte[0];
    public static final String Code = "com.huawei.ads.notification.action.CLICK";
    public static final int I = 1;
    private static hx S = null;
    public static final String V = "com.huawei.ads.notification.action.DELETE";
    public static final String Z = "type";
    private Context D;
    private fr L;
    private byte[] F = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Class<? extends hw>> f29297a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f29298b = new BroadcastReceiver() { // from class: com.huawei.hms.ads.hx.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || TextUtils.isEmpty(intent.getAction())) {
                gl.Code(hx.B, "intent or action maybe empty.");
            } else {
                gl.Code(hx.B, " action name:%s", intent.getAction());
                hx.this.Code(context, intent);
            }
        }
    };

    private hx(Context context) {
        this.D = context.getApplicationContext();
        this.L = fr.Code(context);
    }

    public static hx Code(Context context) {
        synchronized (C) {
            if (S == null) {
                S = new hx(context);
            }
        }
        return S;
    }

    private void V() {
        this.f29297a.put("com.huawei.ads.notification.action.CLICK1", hr.class);
        this.f29297a.put("com.huawei.ads.notification.action.DELETE1", ht.class);
    }

    public void Code() {
        String str;
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(V);
            this.D.registerReceiver(this.f29298b, intentFilter);
        } catch (IllegalStateException unused) {
            str = "init IllegalStateException";
            gl.I(B, str);
            V();
        } catch (Exception unused2) {
            str = "init Exception";
            gl.I(B, str);
            V();
        }
        V();
    }

    public void Code(Context context, Intent intent) {
        StringBuilder sb2;
        String str;
        String str2;
        try {
            int intExtra = intent.getIntExtra("type", 1);
            String str3 = intent.getAction() + intExtra;
            Class<? extends hw> cls = this.f29297a.get(str3);
            if (cls != null) {
                try {
                    hw newInstance = cls.newInstance();
                    if (newInstance != null) {
                        newInstance.Code(this.D, intent);
                    }
                } catch (InstantiationException unused) {
                    str2 = "InstantiationException can not instantiation notification Action";
                    gl.I(B, str2);
                } catch (Throwable unused2) {
                    str2 = "Throwable can not instantiation notification Action";
                    gl.I(B, str2);
                }
            } else {
                gl.V(B, "can not find action key:" + str3);
            }
        } catch (IllegalStateException e2) {
            e = e2;
            sb2 = new StringBuilder();
            str = "actionReceiver.onReceive IllegalStateException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            gl.I(B, sb2.toString());
        } catch (Throwable th) {
            e = th;
            sb2 = new StringBuilder();
            str = "actionReceiver.onReceive Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            gl.I(B, sb2.toString());
        }
    }

    public void Code(String str) {
        if (TextUtils.isEmpty(str)) {
            gl.V(B, "add packageName is Empty.");
            return;
        }
        synchronized (this.F) {
            try {
                Set<String> ai = this.L.ai();
                if (ai != null) {
                    ai.add(str);
                    fr.Code(this.D).Code(ai);
                }
            } finally {
            }
        }
    }

    public boolean I(String str) {
        if (TextUtils.isEmpty(str)) {
            gl.V(B, "isPackageExist packageName is Empty.");
            return false;
        }
        synchronized (this.F) {
            Set<String> ai = this.L.ai();
            if (ai == null) {
                return false;
            }
            return ai.contains(str);
        }
    }

    public void V(String str) {
        if (TextUtils.isEmpty(str)) {
            gl.V(B, "remove packageName is Empty.");
            return;
        }
        synchronized (this.F) {
            try {
                Set<String> ai = this.L.ai();
                if (ai != null) {
                    ai.remove(str);
                    fr.Code(this.D).Code(ai);
                }
            } finally {
            }
        }
    }
}
