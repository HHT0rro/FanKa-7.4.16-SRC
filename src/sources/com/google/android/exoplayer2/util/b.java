package com.google.android.exoplayer2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: AtomicFile.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final File f22949a;

    /* renamed from: b, reason: collision with root package name */
    public final File f22950b;

    /* compiled from: AtomicFile.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends OutputStream {

        /* renamed from: b, reason: collision with root package name */
        public final FileOutputStream f22951b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f22952c = false;

        public a(File file) throws FileNotFoundException {
            this.f22951b = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f22952c) {
                return;
            }
            this.f22952c = true;
            flush();
            try {
                this.f22951b.getFD().sync();
            } catch (IOException e2) {
                m.i("AtomicFile", "Failed to sync file descriptor:", e2);
            }
            this.f22951b.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f22951b.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            this.f22951b.write(i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f22951b.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            this.f22951b.write(bArr, i10, i11);
        }
    }

    public b(File file) {
        this.f22949a = file;
        this.f22950b = new File(String.valueOf(file.getPath()).concat(".bak"));
    }

    public void a() {
        this.f22949a.delete();
        this.f22950b.delete();
    }

    public void b(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.f22950b.delete();
    }

    public boolean c() {
        return this.f22949a.exists() || this.f22950b.exists();
    }

    public InputStream d() throws FileNotFoundException {
        e();
        return new FileInputStream(this.f22949a);
    }

    public final void e() {
        if (this.f22950b.exists()) {
            this.f22949a.delete();
            this.f22950b.renameTo(this.f22949a);
        }
    }

    public OutputStream f() throws IOException {
        if (this.f22949a.exists()) {
            if (!this.f22950b.exists()) {
                if (!this.f22949a.renameTo(this.f22950b)) {
                    String valueOf = String.valueOf(this.f22949a);
                    String valueOf2 = String.valueOf(this.f22950b);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 37 + valueOf2.length());
                    sb2.append("Couldn't rename file ");
                    sb2.append(valueOf);
                    sb2.append(" to backup file ");
                    sb2.append(valueOf2);
                    m.h("AtomicFile", sb2.toString());
                }
            } else {
                this.f22949a.delete();
            }
        }
        try {
            return new a(this.f22949a);
        } catch (FileNotFoundException e2) {
            File parentFile = this.f22949a.getParentFile();
            if (parentFile != null && parentFile.mkdirs()) {
                try {
                    return new a(this.f22949a);
                } catch (FileNotFoundException e10) {
                    String valueOf3 = String.valueOf(this.f22949a);
                    StringBuilder sb3 = new StringBuilder(valueOf3.length() + 16);
                    sb3.append("Couldn't create ");
                    sb3.append(valueOf3);
                    throw new IOException(sb3.toString(), e10);
                }
            }
            String valueOf4 = String.valueOf(this.f22949a);
            StringBuilder sb4 = new StringBuilder(valueOf4.length() + 16);
            sb4.append("Couldn't create ");
            sb4.append(valueOf4);
            throw new IOException(sb4.toString(), e2);
        }
    }
}
