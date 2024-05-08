package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class p7 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public Context f48081b;

    /* renamed from: c, reason: collision with root package name */
    public File f48082c;

    /* renamed from: d, reason: collision with root package name */
    public Runnable f48083d;

    public p7(Context context, File file) {
        this.f48081b = context;
        this.f48082c = file;
    }

    public /* synthetic */ p7(Context context, File file, q7 q7Var) {
        this(context, file);
    }

    public static void b(Context context, File file, Runnable runnable) {
        new q7(context, file, runnable).run();
    }

    public abstract void a(Context context);

    @Override // java.lang.Runnable
    public final void run() {
        o7 o7Var = null;
        try {
            try {
                if (this.f48082c == null) {
                    this.f48082c = new File(this.f48081b.getFilesDir(), "default_locker");
                }
                o7Var = o7.a(this.f48081b, this.f48082c);
                Runnable runnable = this.f48083d;
                if (runnable != null) {
                    runnable.run();
                }
                a(this.f48081b);
                if (o7Var == null) {
                    return;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (o7Var == null) {
                    return;
                }
            }
            o7Var.b();
        } catch (Throwable th) {
            if (o7Var != null) {
                o7Var.b();
            }
            throw th;
        }
    }
}
