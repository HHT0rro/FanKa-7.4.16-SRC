package fb;

import android.graphics.Bitmap;
import fb.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import pb.c;

/* compiled from: LruDiskCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b implements db.a {

    /* renamed from: g, reason: collision with root package name */
    public static final Bitmap.CompressFormat f49274g = Bitmap.CompressFormat.PNG;

    /* renamed from: a, reason: collision with root package name */
    public a f49275a;

    /* renamed from: b, reason: collision with root package name */
    public File f49276b;

    /* renamed from: c, reason: collision with root package name */
    public final gb.a f49277c;

    /* renamed from: d, reason: collision with root package name */
    public int f49278d = 32768;

    /* renamed from: e, reason: collision with root package name */
    public Bitmap.CompressFormat f49279e = f49274g;

    /* renamed from: f, reason: collision with root package name */
    public int f49280f = 100;

    public b(File file, File file2, gb.a aVar, long j10, int i10) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (aVar != null) {
            long j11 = j10 == 0 ? Long.MAX_VALUE : j10;
            int i11 = i10 == 0 ? Integer.MAX_VALUE : i10;
            this.f49276b = file2;
            this.f49277c = aVar;
            c(file, file2, j11, i11);
            return;
        }
        throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    }

    @Override // db.a
    public boolean a(String str, InputStream inputStream, c.a aVar) throws IOException {
        a.c x10 = this.f49275a.x(b(str));
        if (x10 == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(x10.f(0), this.f49278d);
        try {
            boolean b4 = pb.c.b(inputStream, bufferedOutputStream, aVar, this.f49278d);
            pb.c.a(bufferedOutputStream);
            if (b4) {
                x10.e();
            } else {
                x10.a();
            }
            return b4;
        } catch (Throwable th) {
            pb.c.a(bufferedOutputStream);
            x10.a();
            throw th;
        }
    }

    public final String b(String str) {
        return this.f49277c.generate(str);
    }

    public final void c(File file, File file2, long j10, int i10) throws IOException {
        try {
            this.f49275a = a.B(file, 1, 1, j10, i10);
        } catch (IOException e2) {
            pb.d.c(e2);
            if (file2 != null) {
                c(file2, null, j10, i10);
            }
            if (this.f49275a == null) {
                throw e2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
    @Override // db.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.File get(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            fb.a r1 = r3.f49275a     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            java.lang.String r4 = r3.b(r4)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            fb.a$e r4 = r1.z(r4)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            if (r4 != 0) goto Le
            goto L13
        Le:
            r1 = 0
            java.io.File r0 = r4.a(r1)     // Catch: java.io.IOException -> L19 java.lang.Throwable -> L2b
        L13:
            if (r4 == 0) goto L18
            r4.close()
        L18:
            return r0
        L19:
            r1 = move-exception
            goto L22
        L1b:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
            goto L2c
        L20:
            r1 = move-exception
            r4 = r0
        L22:
            pb.d.c(r1)     // Catch: java.lang.Throwable -> L2b
            if (r4 == 0) goto L2a
            r4.close()
        L2a:
            return r0
        L2b:
            r0 = move-exception
        L2c:
            if (r4 == 0) goto L31
            r4.close()
        L31:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fb.b.get(java.lang.String):java.io.File");
    }

    @Override // db.a
    public boolean save(String str, Bitmap bitmap) throws IOException {
        a.c x10 = this.f49275a.x(b(str));
        if (x10 == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(x10.f(0), this.f49278d);
        try {
            boolean compress = bitmap.compress(this.f49279e, this.f49280f, bufferedOutputStream);
            if (compress) {
                x10.e();
            } else {
                x10.a();
            }
            return compress;
        } finally {
            pb.c.a(bufferedOutputStream);
        }
    }
}
