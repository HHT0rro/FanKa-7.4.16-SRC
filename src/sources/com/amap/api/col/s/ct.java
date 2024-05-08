package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: AdiuStorageModel.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ct {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7592a = ci.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");

    /* renamed from: f, reason: collision with root package name */
    private static ct f7593f;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f7594b;

    /* renamed from: c, reason: collision with root package name */
    private String f7595c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f7596d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f7597e;

    private ct(Context context) {
        this.f7596d = context.getApplicationContext();
        if (Looper.myLooper() == null) {
            this.f7597e = new a(Looper.getMainLooper(), this);
        } else {
            this.f7597e = new a(this);
        }
    }

    /* compiled from: AdiuStorageModel.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<ct> f7601a;

        public a(ct ctVar) {
            this.f7601a = new WeakReference<>(ctVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            ct ctVar = this.f7601a.get();
            if (ctVar == null || message == null || (obj = message.obj) == null) {
                return;
            }
            ctVar.a((String) obj, message.what);
        }

        public a(Looper looper, ct ctVar) {
            super(looper);
            this.f7601a = new WeakReference<>(ctVar);
        }
    }

    public final void b(String str) {
        List<String> list = this.f7594b;
        if (list != null) {
            list.clear();
            this.f7594b.add(str);
        }
        a(str, 273);
    }

    public static ct a(Context context) {
        if (f7593f == null) {
            synchronized (ct.class) {
                if (f7593f == null) {
                    f7593f = new ct(context);
                }
            }
        }
        return f7593f;
    }

    public final void a(String str) {
        this.f7595c = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(final String str, final int i10) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread() { // from class: com.amap.api.col.s.ct.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    String b4 = cz.b(str);
                    if (TextUtils.isEmpty(b4)) {
                        return;
                    }
                    if ((i10 & 1) > 0) {
                        try {
                            if (Build.VERSION.SDK_INT >= 23) {
                                if (Settings.System.canWrite(ct.this.f7596d)) {
                                    Settings.System.putString(ct.this.f7596d.getContentResolver(), ct.this.f7595c, b4);
                                }
                            } else {
                                Settings.System.putString(ct.this.f7596d.getContentResolver(), ct.this.f7595c, b4);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if ((i10 & 16) > 0) {
                        cv.a(ct.this.f7596d, ct.this.f7595c, b4);
                    }
                    if ((i10 & 256) > 0) {
                        SharedPreferences.Editor edit = ct.this.f7596d.getSharedPreferences(ct.f7592a, 0).edit();
                        edit.putString(ct.this.f7595c, b4);
                        edit.apply();
                    }
                }
            }.start();
            return;
        }
        String b4 = cz.b(str);
        if (!TextUtils.isEmpty(b4)) {
            if ((i10 & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        Settings.System.putString(this.f7596d.getContentResolver(), this.f7595c, b4);
                    } else {
                        Settings.System.putString(this.f7596d.getContentResolver(), this.f7595c, b4);
                    }
                } catch (Exception unused) {
                }
            }
            if ((i10 & 16) > 0) {
                cv.a(this.f7596d, this.f7595c, b4);
            }
            if ((i10 & 256) > 0) {
                SharedPreferences.Editor edit = this.f7596d.getSharedPreferences(f7592a, 0).edit();
                edit.putString(this.f7595c, b4);
                edit.apply();
            }
        }
    }
}
