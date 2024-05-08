package kc;

import android.content.Context;
import com.xiaomi.push.hu;
import com.xiaomi.push.s7;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f50778b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ hu f50779c;

    public b0(Context context, hu huVar) {
        this.f50778b = context;
        this.f50779c = huVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile randomAccessFile;
        synchronized (a0.f50775a) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(this.f50778b.getFilesDir(), "tiny_data.lock");
                    s7.g(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (Exception e2) {
                    e = e2;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = null;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e10) {
                            fc.c.k(e10);
                        }
                    }
                    s7.b(randomAccessFile);
                    throw th;
                }
                try {
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        a0.e(this.f50778b, this.f50779c);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e11) {
                                fc.c.k(e11);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileLock != null && fileLock.isValid()) {
                            fileLock.release();
                        }
                        s7.b(randomAccessFile);
                        throw th;
                    }
                } catch (Exception e12) {
                    e = e12;
                    fc.c.k(e);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e13) {
                            fc.c.k(e13);
                        }
                    }
                    s7.b(randomAccessFile);
                }
                s7.b(randomAccessFile);
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
