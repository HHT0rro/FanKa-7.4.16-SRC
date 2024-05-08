package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class o7 {

    /* renamed from: e, reason: collision with root package name */
    public static final Set<String> f48058e = Collections.synchronizedSet(new HashSet());

    /* renamed from: a, reason: collision with root package name */
    public Context f48059a;

    /* renamed from: b, reason: collision with root package name */
    public FileLock f48060b;

    /* renamed from: c, reason: collision with root package name */
    public String f48061c;

    /* renamed from: d, reason: collision with root package name */
    public RandomAccessFile f48062d;

    public o7(Context context) {
        this.f48059a = context;
    }

    public static o7 a(Context context, File file) {
        fc.c.m("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        Set<String> set = f48058e;
        if (!set.add(str)) {
            throw new IOException("abtain lock failure");
        }
        o7 o7Var = new o7(context);
        o7Var.f48061c = str;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            o7Var.f48062d = randomAccessFile;
            o7Var.f48060b = randomAccessFile.getChannel().lock();
            fc.c.m("Locked: " + str + " :" + ((Object) o7Var.f48060b));
            if (o7Var.f48060b == null) {
                RandomAccessFile randomAccessFile2 = o7Var.f48062d;
                if (randomAccessFile2 != null) {
                    s7.b(randomAccessFile2);
                }
                set.remove(o7Var.f48061c);
            }
            return o7Var;
        } catch (Throwable th) {
            if (o7Var.f48060b == null) {
                RandomAccessFile randomAccessFile3 = o7Var.f48062d;
                if (randomAccessFile3 != null) {
                    s7.b(randomAccessFile3);
                }
                f48058e.remove(o7Var.f48061c);
            }
            throw th;
        }
    }

    public void b() {
        fc.c.m("unLock: " + ((Object) this.f48060b));
        FileLock fileLock = this.f48060b;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f48060b.release();
            } catch (IOException unused) {
            }
            this.f48060b = null;
        }
        RandomAccessFile randomAccessFile = this.f48062d;
        if (randomAccessFile != null) {
            s7.b(randomAccessFile);
        }
        f48058e.remove(this.f48061c);
    }
}
