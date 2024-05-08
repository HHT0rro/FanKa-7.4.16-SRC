package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.i2;
import com.xiaomi.push.s7;
import java.io.File;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f1 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f46992b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f46993c;

    public f1(Context context, boolean z10) {
        this.f46992b = context;
        this.f46993c = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap<String, String> a10;
        String str;
        File a11;
        File file = null;
        try {
            a10 = u.a(this.f46992b, "");
            if (this.f46993c) {
                str = this.f46992b.getFilesDir().getAbsolutePath();
            } else {
                str = this.f46992b.getExternalFilesDir(null).getAbsolutePath() + i2.f47506f;
            }
            a11 = g.a(str);
        } catch (Throwable th) {
            th = th;
        }
        if (a11 == null) {
            fc.c.i("log file null");
            return;
        }
        File file2 = new File(str, this.f46992b.getPackageName() + ".zip");
        try {
            s7.d(file2, a11);
            if (file2.exists()) {
                com.xiaomi.push.j0.k((this.f46993c ? "https://api.xmpush.xiaomi.com/upload/xmsf_log?file=" : "https://api.xmpush.xiaomi.com/upload/app_log?file=") + file2.getName(), a10, file2, "file");
            } else {
                fc.c.i("zip log file failed");
            }
        } catch (Throwable th2) {
            th = th2;
            file = file2;
            fc.c.k(th);
            file2 = file;
            if (file2 == null) {
            } else {
                return;
            }
        }
        if (file2 == null && file2.exists()) {
            file2.delete();
        }
    }
}
