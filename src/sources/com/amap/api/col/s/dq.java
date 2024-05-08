package com.amap.api.col.s;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.apache.commons.lang3.CharEncoding;

/* compiled from: DiskLruCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dq implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f7693a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f7694b = Charset.forName(CharEncoding.US_ASCII);

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f7695c = Charset.forName("UTF-8");

    /* renamed from: d, reason: collision with root package name */
    public static ThreadPoolExecutor f7696d;

    /* renamed from: r, reason: collision with root package name */
    private static final ThreadFactory f7697r;

    /* renamed from: t, reason: collision with root package name */
    private static final OutputStream f7698t;

    /* renamed from: e, reason: collision with root package name */
    private final File f7699e;

    /* renamed from: f, reason: collision with root package name */
    private final File f7700f;

    /* renamed from: g, reason: collision with root package name */
    private final File f7701g;

    /* renamed from: h, reason: collision with root package name */
    private final File f7702h;

    /* renamed from: j, reason: collision with root package name */
    private long f7704j;

    /* renamed from: m, reason: collision with root package name */
    private Writer f7707m;

    /* renamed from: p, reason: collision with root package name */
    private int f7710p;

    /* renamed from: l, reason: collision with root package name */
    private long f7706l = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f7708n = 1000;

    /* renamed from: o, reason: collision with root package name */
    private final LinkedHashMap<String, c> f7709o = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: q, reason: collision with root package name */
    private long f7711q = 0;

    /* renamed from: s, reason: collision with root package name */
    private final Callable<Void> f7712s = new Callable<Void>() { // from class: com.amap.api.col.s.dq.2
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (dq.this) {
                if (dq.this.f7707m == null) {
                    return null;
                }
                dq.this.k();
                if (dq.this.i()) {
                    dq.this.h();
                    dq.e(dq.this);
                }
                return null;
            }
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private final int f7703i = 1;

    /* renamed from: k, reason: collision with root package name */
    private final int f7705k = 1;

    /* compiled from: DiskLruCache.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class a {

        /* renamed from: b, reason: collision with root package name */
        private final c f7716b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean[] f7717c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f7718d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f7719e;

        /* compiled from: DiskLruCache.java */
        /* renamed from: com.amap.api.col.s.dq$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public class C0106a extends FilterOutputStream {
            public /* synthetic */ C0106a(a aVar, OutputStream outputStream, byte b4) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    a.c(a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    a.c(a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i10) {
                try {
                    this.out.write(i10);
                } catch (IOException unused) {
                    a.c(a.this);
                }
            }

            private C0106a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i10, int i11) {
                try {
                    this.out.write(bArr, i10, i11);
                } catch (IOException unused) {
                    a.c(a.this);
                }
            }
        }

        public /* synthetic */ a(dq dqVar, c cVar, byte b4) {
            this(cVar);
        }

        public static /* synthetic */ boolean c(a aVar) {
            aVar.f7718d = true;
            return true;
        }

        private a(c cVar) {
            this.f7716b = cVar;
            this.f7717c = cVar.f7729d ? null : new boolean[dq.this.f7705k];
        }

        public final OutputStream a() throws IOException {
            FileOutputStream fileOutputStream;
            C0106a c0106a;
            if (dq.this.f7705k <= 0) {
                throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + dq.this.f7705k);
            }
            synchronized (dq.this) {
                if (this.f7716b.f7730e == this) {
                    byte b4 = 0;
                    if (!this.f7716b.f7729d) {
                        this.f7717c[0] = true;
                    }
                    File b10 = this.f7716b.b(0);
                    try {
                        fileOutputStream = new FileOutputStream(b10);
                    } catch (FileNotFoundException unused) {
                        dq.this.f7699e.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(b10);
                        } catch (FileNotFoundException unused2) {
                            return dq.f7698t;
                        }
                    }
                    c0106a = new C0106a(this, fileOutputStream, b4);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0106a;
        }

        public final void b() throws IOException {
            if (this.f7718d) {
                dq.this.a(this, false);
                dq.this.c(this.f7716b.f7727b);
            } else {
                dq.this.a(this, true);
            }
            this.f7719e = true;
        }

        public final void c() throws IOException {
            dq.this.a(this, false);
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class b implements Closeable {

        /* renamed from: b, reason: collision with root package name */
        private final String f7722b;

        /* renamed from: c, reason: collision with root package name */
        private final long f7723c;

        /* renamed from: d, reason: collision with root package name */
        private final InputStream[] f7724d;

        /* renamed from: e, reason: collision with root package name */
        private final long[] f7725e;

        public /* synthetic */ b(dq dqVar, String str, long j10, InputStream[] inputStreamArr, long[] jArr, byte b4) {
            this(str, j10, inputStreamArr, jArr);
        }

        public final InputStream a() {
            return this.f7724d[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.f7724d) {
                dq.a(inputStream);
            }
        }

        private b(String str, long j10, InputStream[] inputStreamArr, long[] jArr) {
            this.f7722b = str;
            this.f7723c = j10;
            this.f7724d = inputStreamArr;
            this.f7725e = jArr;
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class c {

        /* renamed from: b, reason: collision with root package name */
        private final String f7727b;

        /* renamed from: c, reason: collision with root package name */
        private final long[] f7728c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f7729d;

        /* renamed from: e, reason: collision with root package name */
        private a f7730e;

        /* renamed from: f, reason: collision with root package name */
        private long f7731f;

        public /* synthetic */ c(dq dqVar, String str, byte b4) {
            this(str);
        }

        private c(String str) {
            this.f7727b = str;
            this.f7728c = new long[dq.this.f7705k];
        }

        public final File b(int i10) {
            return new File(dq.this.f7699e, this.f7727b + "." + i10 + ".tmp");
        }

        public static /* synthetic */ boolean a(c cVar) {
            cVar.f7729d = true;
            return true;
        }

        public final String a() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f7728c) {
                sb2.append(' ');
                sb2.append(j10);
            }
            return sb2.toString();
        }

        private static IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File a(int i10) {
            return new File(dq.this.f7699e, this.f7727b + "." + i10);
        }

        public static /* synthetic */ void a(c cVar, String[] strArr) throws IOException {
            if (strArr.length == dq.this.f7705k) {
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    try {
                        cVar.f7728c[i10] = Long.parseLong(strArr[i10]);
                    } catch (NumberFormatException unused) {
                        throw a(strArr);
                    }
                }
                return;
            }
            throw a(strArr);
        }
    }

    static {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.amap.api.col.s.dq.1

            /* renamed from: a, reason: collision with root package name */
            private final AtomicInteger f7713a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "disklrucache#" + this.f7713a.getAndIncrement());
            }
        };
        f7697r = threadFactory;
        f7696d = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        f7698t = new OutputStream() { // from class: com.amap.api.col.s.dq.3
            @Override // java.io.OutputStream
            public final void write(int i10) throws IOException {
            }
        };
    }

    private dq(File file, long j10) {
        this.f7699e = file;
        this.f7700f = new File(file, "journal");
        this.f7701g = new File(file, "journal.tmp");
        this.f7702h = new File(file, "journal.bkp");
        this.f7704j = j10;
    }

    public static /* synthetic */ int e(dq dqVar) {
        dqVar.f7710p = 0;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h() throws IOException {
        Writer writer = this.f7707m;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f7701g), f7694b));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f7703i));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f7705k));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c cVar : this.f7709o.values()) {
                if (cVar.f7730e != null) {
                    bufferedWriter.write("DIRTY " + cVar.f7727b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + cVar.f7727b + cVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f7700f.exists()) {
                a(this.f7700f, this.f7702h, true);
            }
            a(this.f7701g, this.f7700f, false);
            this.f7702h.delete();
            this.f7707m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f7700f, true), f7694b));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        int i10 = this.f7710p;
        return i10 >= 2000 && i10 >= this.f7709o.size();
    }

    private void j() {
        if (this.f7707m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() throws IOException {
        while (true) {
            if (this.f7706l <= this.f7704j && this.f7709o.size() <= this.f7708n) {
                return;
            } else {
                c(this.f7709o.entrySet().iterator2().next().getKey());
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.f7707m == null) {
            return;
        }
        Iterator iterator2 = new ArrayList(this.f7709o.values()).iterator2();
        while (iterator2.hasNext()) {
            c cVar = (c) iterator2.next();
            if (cVar.f7730e != null) {
                cVar.f7730e.c();
            }
        }
        k();
        this.f7707m.close();
        this.f7707m = null;
    }

    private static ThreadPoolExecutor e() {
        try {
            ThreadPoolExecutor threadPoolExecutor = f7696d;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                f7696d = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f7697r);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f7696d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ed, code lost:
    
        throw new java.io.IOException("unexpected journal line: ".concat(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.dq.f():void");
    }

    private void g() throws IOException {
        a(this.f7701g);
        Iterator<c> iterator2 = this.f7709o.values().iterator2();
        while (iterator2.hasNext()) {
            c next = iterator2.next();
            int i10 = 0;
            if (next.f7730e != null) {
                next.f7730e = null;
                while (i10 < this.f7705k) {
                    a(next.a(i10));
                    a(next.b(i10));
                    i10++;
                }
                iterator2.remove();
            } else {
                while (i10 < this.f7705k) {
                    this.f7706l += next.f7728c[i10];
                    i10++;
                }
            }
        }
    }

    public final a b(String str) throws IOException {
        return d(str);
    }

    public final synchronized boolean c(String str) throws IOException {
        j();
        e(str);
        c cVar = this.f7709o.get(str);
        if (cVar != null && cVar.f7730e == null) {
            for (int i10 = 0; i10 < this.f7705k; i10++) {
                File a10 = cVar.a(i10);
                if (a10.exists() && !a10.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(a10)));
                }
                this.f7706l -= cVar.f7728c[i10];
                cVar.f7728c[i10] = 0;
            }
            this.f7710p++;
            this.f7707m.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f7709o.remove(str);
            if (i()) {
                e().submit(this.f7712s);
            }
            return true;
        }
        return false;
    }

    private synchronized a d(String str) throws IOException {
        j();
        e(str);
        c cVar = this.f7709o.get(str);
        byte b4 = 0;
        if (cVar != null) {
            if (cVar.f7730e != null) {
                return null;
            }
        } else {
            cVar = new c(this, str, b4);
            this.f7709o.put(str, cVar);
        }
        a aVar = new a(this, cVar, b4);
        cVar.f7730e = aVar;
        this.f7707m.write("DIRTY " + str + '\n');
        this.f7707m.flush();
        return aVar;
    }

    public final void a(int i10) {
        if (i10 < 10) {
            i10 = 10;
        } else if (i10 > 10000) {
            i10 = 10000;
        }
        this.f7708n = i10;
    }

    public final synchronized void b() throws IOException {
        j();
        k();
        this.f7707m.flush();
    }

    public static dq a(File file, long j10) throws IOException {
        if (j10 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            dq dqVar = new dq(file, j10);
            if (dqVar.f7700f.exists()) {
                try {
                    dqVar.f();
                    dqVar.g();
                    dqVar.f7707m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dqVar.f7700f, true), f7694b));
                    return dqVar;
                } catch (Throwable unused) {
                    dqVar.c();
                }
            }
            file.mkdirs();
            dq dqVar2 = new dq(file, j10);
            dqVar2.h();
            return dqVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private static void e(String str) {
        if (f7693a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private static void b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    b(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
                }
            }
            return;
        }
        throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
    }

    public final void c() throws IOException {
        close();
        b(this.f7699e);
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final synchronized b a(String str) throws IOException {
        j();
        e(str);
        c cVar = this.f7709o.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.f7729d) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f7705k];
        for (int i10 = 0; i10 < this.f7705k; i10++) {
            try {
                inputStreamArr[i10] = new FileInputStream(cVar.a(i10));
            } catch (FileNotFoundException unused) {
                for (int i11 = 0; i11 < this.f7705k && inputStreamArr[i11] != null; i11++) {
                    a(inputStreamArr[i11]);
                }
                return null;
            }
        }
        this.f7710p++;
        this.f7707m.append((CharSequence) ("READ " + str + '\n'));
        if (i()) {
            e().submit(this.f7712s);
        }
        return new b(this, str, cVar.f7731f, inputStreamArr, cVar.f7728c, (byte) 0);
    }

    public final File a() {
        return this.f7699e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(a aVar, boolean z10) throws IOException {
        c cVar = aVar.f7716b;
        if (cVar.f7730e == aVar) {
            if (z10 && !cVar.f7729d) {
                for (int i10 = 0; i10 < this.f7705k; i10++) {
                    if (aVar.f7717c[i10]) {
                        if (!cVar.b(i10).exists()) {
                            aVar.c();
                            return;
                        }
                    } else {
                        aVar.c();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i10)));
                    }
                }
            }
            for (int i11 = 0; i11 < this.f7705k; i11++) {
                File b4 = cVar.b(i11);
                if (z10) {
                    if (b4.exists()) {
                        File a10 = cVar.a(i11);
                        b4.renameTo(a10);
                        long j10 = cVar.f7728c[i11];
                        long length = a10.length();
                        cVar.f7728c[i11] = length;
                        this.f7706l = (this.f7706l - j10) + length;
                    }
                } else {
                    a(b4);
                }
            }
            this.f7710p++;
            cVar.f7730e = null;
            if (cVar.f7729d | z10) {
                c.a(cVar);
                this.f7707m.write("CLEAN " + cVar.f7727b + cVar.a() + '\n');
                if (z10) {
                    long j11 = this.f7711q;
                    this.f7711q = 1 + j11;
                    cVar.f7731f = j11;
                }
            } else {
                this.f7709o.remove(cVar.f7727b);
                this.f7707m.write("REMOVE " + cVar.f7727b + '\n');
            }
            this.f7707m.flush();
            if (this.f7706l > this.f7704j || i()) {
                e().submit(this.f7712s);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }
}
