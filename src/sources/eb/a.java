package eb;

import android.graphics.Bitmap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import pb.c;

/* compiled from: BaseDiskCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a implements db.a {

    /* renamed from: g, reason: collision with root package name */
    public static final Bitmap.CompressFormat f48992g = Bitmap.CompressFormat.PNG;

    /* renamed from: a, reason: collision with root package name */
    public final File f48993a;

    /* renamed from: b, reason: collision with root package name */
    public final File f48994b;

    /* renamed from: c, reason: collision with root package name */
    public final gb.a f48995c;

    /* renamed from: d, reason: collision with root package name */
    public int f48996d = 32768;

    /* renamed from: e, reason: collision with root package name */
    public Bitmap.CompressFormat f48997e = f48992g;

    /* renamed from: f, reason: collision with root package name */
    public int f48998f = 100;

    public a(File file, File file2, gb.a aVar) {
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (aVar != null) {
            this.f48993a = file;
            this.f48994b = file2;
            this.f48995c = aVar;
            return;
        }
        throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    }

    @Override // db.a
    public boolean a(String str, InputStream inputStream, c.a aVar) throws IOException {
        boolean z10;
        File b4 = b(str);
        File file = new File(b4.getAbsolutePath() + ".tmp");
        try {
            try {
                z10 = c.b(inputStream, new BufferedOutputStream(new FileOutputStream(file), this.f48996d), aVar, this.f48996d);
            } finally {
            }
        } catch (Throwable th) {
            th = th;
            z10 = false;
        }
        try {
            boolean z11 = (!z10 || file.renameTo(b4)) ? z10 : false;
            if (!z11) {
                file.delete();
            }
            return z11;
        } catch (Throwable th2) {
            th = th2;
            if (!((!z10 || file.renameTo(b4)) ? z10 : false)) {
                file.delete();
            }
            throw th;
        }
    }

    public File b(String str) {
        File file;
        String generate = this.f48995c.generate(str);
        File file2 = this.f48993a;
        if (!file2.exists() && !this.f48993a.mkdirs() && (file = this.f48994b) != null && (file.exists() || this.f48994b.mkdirs())) {
            file2 = this.f48994b;
        }
        return new File(file2, generate);
    }

    @Override // db.a
    public File get(String str) {
        return b(str);
    }

    @Override // db.a
    public boolean save(String str, Bitmap bitmap) throws IOException {
        File b4 = b(str);
        File file = new File(b4.getAbsolutePath() + ".tmp");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.f48996d);
        try {
            boolean compress = bitmap.compress(this.f48997e, this.f48998f, bufferedOutputStream);
            c.a(bufferedOutputStream);
            if (compress && !file.renameTo(b4)) {
                compress = false;
            }
            if (!compress) {
                file.delete();
            }
            bitmap.recycle();
            return compress;
        } catch (Throwable th) {
            c.a(bufferedOutputStream);
            file.delete();
            throw th;
        }
    }
}
