package com.amap.api.col.p0003l;

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
public final class gl {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6104a = fv.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");

    /* renamed from: f, reason: collision with root package name */
    private static gl f6105f;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f6106b;

    /* renamed from: c, reason: collision with root package name */
    private String f6107c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f6108d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f6109e;

    private gl(Context context) {
        this.f6108d = context.getApplicationContext();
        if (Looper.myLooper() == null) {
            this.f6109e = new a(Looper.getMainLooper(), this);
        } else {
            this.f6109e = new a(this);
        }
    }

    /* compiled from: AdiuStorageModel.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<gl> f6113a;

        public a(gl glVar) {
            this.f6113a = new WeakReference<>(glVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            gl glVar = this.f6113a.get();
            if (glVar == null || message == null || (obj = message.obj) == null) {
                return;
            }
            glVar.a((String) obj, message.what);
        }

        public a(Looper looper, gl glVar) {
            super(looper);
            this.f6113a = new WeakReference<>(glVar);
        }
    }

    public final void b(String str) {
        List<String> list = this.f6106b;
        if (list != null) {
            list.clear();
            this.f6106b.add(str);
        }
        a(str, 273);
    }

    public static gl a(Context context) {
        if (f6105f == null) {
            synchronized (gl.class) {
                if (f6105f == null) {
                    f6105f = new gl(context);
                }
            }
        }
        return f6105f;
    }

    public final void a(String str) {
        this.f6107c = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(final String str, final int i10) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread() { // from class: com.amap.api.col.3l.gl.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    String b4 = gr.b(str);
                    if (TextUtils.isEmpty(b4)) {
                        return;
                    }
                    if ((i10 & 1) > 0) {
                        try {
                            if (Build.VERSION.SDK_INT >= 23) {
                                if (Settings.System.canWrite(gl.this.f6108d)) {
                                    Settings.System.putString(gl.this.f6108d.getContentResolver(), gl.this.f6107c, b4);
                                }
                            } else {
                                Settings.System.putString(gl.this.f6108d.getContentResolver(), gl.this.f6107c, b4);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if ((i10 & 16) > 0) {
                        gn.a(gl.this.f6108d, gl.this.f6107c, b4);
                    }
                    if ((i10 & 256) > 0) {
                        SharedPreferences.Editor edit = gl.this.f6108d.getSharedPreferences(gl.f6104a, 0).edit();
                        edit.putString(gl.this.f6107c, b4);
                        edit.apply();
                    }
                }
            }.start();
            return;
        }
        String b4 = gr.b(str);
        if (!TextUtils.isEmpty(b4)) {
            if ((i10 & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        Settings.System.putString(this.f6108d.getContentResolver(), this.f6107c, b4);
                    } else {
                        Settings.System.putString(this.f6108d.getContentResolver(), this.f6107c, b4);
                    }
                } catch (Exception unused) {
                }
            }
            if ((i10 & 16) > 0) {
                gn.a(this.f6108d, this.f6107c, b4);
            }
            if ((i10 & 256) > 0) {
                SharedPreferences.Editor edit = this.f6108d.getSharedPreferences(f6104a, 0).edit();
                edit.putString(this.f6107c, b4);
                edit.apply();
            }
        }
    }
}
