package com.amap.api.col.p0003l;

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
public final class ht implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f6261a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f6262b = Charset.forName(CharEncoding.US_ASCII);

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f6263c = Charset.forName("UTF-8");

    /* renamed from: d, reason: collision with root package name */
    public static ThreadPoolExecutor f6264d;

    /* renamed from: r, reason: collision with root package name */
    private static final ThreadFactory f6265r;

    /* renamed from: t, reason: collision with root package name */
    private static final OutputStream f6266t;

    /* renamed from: e, reason: collision with root package name */
    private final File f6267e;

    /* renamed from: f, reason: collision with root package name */
    private final File f6268f;

    /* renamed from: g, reason: collision with root package name */
    private final File f6269g;

    /* renamed from: h, reason: collision with root package name */
    private final File f6270h;

    /* renamed from: j, reason: collision with root package name */
    private long f6272j;

    /* renamed from: m, reason: collision with root package name */
    private Writer f6275m;

    /* renamed from: p, reason: collision with root package name */
    private int f6278p;

    /* renamed from: l, reason: collision with root package name */
    private long f6274l = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f6276n = 1000;

    /* renamed from: o, reason: collision with root package name */
    private final LinkedHashMap<String, c> f6277o = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: q, reason: collision with root package name */
    private long f6279q = 0;

    /* renamed from: s, reason: collision with root package name */
    private final Callable<Void> f6280s = new Callable<Void>() { // from class: com.amap.api.col.3l.ht.2
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (ht.this) {
                if (ht.this.f6275m == null) {
                    return null;
                }
                ht.this.l();
                if (ht.this.j()) {
                    ht.this.i();
                    ht.e(ht.this);
                }
                return null;
            }
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private final int f6271i = 1;

    /* renamed from: k, reason: collision with root package name */
    private final int f6273k = 1;

    /* compiled from: DiskLruCache.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class a {

        /* renamed from: b, reason: collision with root package name */
        private final c f6284b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean[] f6285c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f6286d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f6287e;

        /* compiled from: DiskLruCache.java */
        /* renamed from: com.amap.api.col.3l.ht$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public class C0104a extends FilterOutputStream {
            public /* synthetic */ C0104a(a aVar, OutputStream outputStream, byte b4) {
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

            private C0104a(OutputStream outputStream) {
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

        public /* synthetic */ a(ht htVar, c cVar, byte b4) {
            this(cVar);
        }

        public static /* synthetic */ boolean c(a aVar) {
            aVar.f6286d = true;
            return true;
        }

        private a(c cVar) {
            this.f6284b = cVar;
            this.f6285c = cVar.f6297d ? null : new boolean[ht.this.f6273k];
        }

        public final OutputStream a() throws IOException {
            FileOutputStream fileOutputStream;
            C0104a c0104a;
            if (ht.this.f6273k <= 0) {
                throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + ht.this.f6273k);
            }
            synchronized (ht.this) {
                if (this.f6284b.f6298e == this) {
                    byte b4 = 0;
                    if (!this.f6284b.f6297d) {
                        this.f6285c[0] = true;
                    }
                    File b10 = this.f6284b.b(0);
                    try {
                        fileOutputStream = new FileOutputStream(b10);
                    } catch (FileNotFoundException unused) {
                        ht.this.f6267e.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(b10);
                        } catch (FileNotFoundException unused2) {
                            return ht.f6266t;
                        }
                    }
                    c0104a = new C0104a(this, fileOutputStream, b4);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0104a;
        }

        public final void b() throws IOException {
            if (this.f6286d) {
                ht.this.a(this, false);
                ht.this.c(this.f6284b.f6295b);
            } else {
                ht.this.a(this, true);
            }
            this.f6287e = true;
        }

        public final void c() throws IOException {
            ht.this.a(this, false);
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class b implements Closeable {

        /* renamed from: b, reason: collision with root package name */
        private final String f6290b;

        /* renamed from: c, reason: collision with root package name */
        private final long f6291c;

        /* renamed from: d, reason: collision with root package name */
        private final InputStream[] f6292d;

        /* renamed from: e, reason: collision with root package name */
        private final long[] f6293e;

        public /* synthetic */ b(ht htVar, String str, long j10, InputStream[] inputStreamArr, long[] jArr, byte b4) {
            this(str, j10, inputStreamArr, jArr);
        }

        public final InputStream a() {
            return this.f6292d[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.f6292d) {
                ht.a(inputStream);
            }
        }

        private b(String str, long j10, InputStream[] inputStreamArr, long[] jArr) {
            this.f6290b = str;
            this.f6291c = j10;
            this.f6292d = inputStreamArr;
            this.f6293e = jArr;
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class c {

        /* renamed from: b, reason: collision with root package name */
        private final String f6295b;

        /* renamed from: c, reason: collision with root package name */
        private final long[] f6296c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f6297d;

        /* renamed from: e, reason: collision with root package name */
        private a f6298e;

        /* renamed from: f, reason: collision with root package name */
        private long f6299f;

        public /* synthetic */ c(ht htVar, String str, byte b4) {
            this(str);
        }

        private c(String str) {
            this.f6295b = str;
            this.f6296c = new long[ht.this.f6273k];
        }

        public final File b(int i10) {
            return new File(ht.this.f6267e, this.f6295b + "." + i10 + ".tmp");
        }

        public static /* synthetic */ boolean a(c cVar) {
            cVar.f6297d = true;
            return true;
        }

        public final String a() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f6296c) {
                sb2.append(' ');
                sb2.append(j10);
            }
            return sb2.toString();
        }

        private static IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File a(int i10) {
            return new File(ht.this.f6267e, this.f6295b + "." + i10);
        }

        public static /* synthetic */ void a(c cVar, String[] strArr) throws IOException {
            if (strArr.length == ht.this.f6273k) {
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    try {
                        cVar.f6296c[i10] = Long.parseLong(strArr[i10]);
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
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.amap.api.col.3l.ht.1

            /* renamed from: a, reason: collision with root package name */
            private final AtomicInteger f6281a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "disklrucache#" + this.f6281a.getAndIncrement());
            }
        };
        f6265r = threadFactory;
        f6264d = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        f6266t = new OutputStream() { // from class: com.amap.api.col.3l.ht.3
            @Override // java.io.OutputStream
            public final void write(int i10) throws IOException {
            }
        };
    }

    private ht(File file, long j10) {
        this.f6267e = file;
        this.f6268f = new File(file, "journal");
        this.f6269g = new File(file, "journal.tmp");
        this.f6270h = new File(file, "journal.bkp");
        this.f6272j = j10;
    }

    public static /* synthetic */ int e(ht htVar) {
        htVar.f6278p = 0;
        return 0;
    }

    private void h() throws IOException {
        a(this.f6269g);
        Iterator<c> iterator2 = this.f6277o.values().iterator2();
        while (iterator2.hasNext()) {
            c next = iterator2.next();
            int i10 = 0;
            if (next.f6298e != null) {
                next.f6298e = null;
                while (i10 < this.f6273k) {
                    a(next.a(i10));
                    a(next.b(i10));
                    i10++;
                }
                iterator2.remove();
            } else {
                while (i10 < this.f6273k) {
                    this.f6274l += next.f6296c[i10];
                    i10++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() throws IOException {
        Writer writer = this.f6275m;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f6269g), f6262b));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f6271i));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f6273k));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c cVar : this.f6277o.values()) {
                if (cVar.f6298e != null) {
                    bufferedWriter.write("DIRTY " + cVar.f6295b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + cVar.f6295b + cVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f6268f.exists()) {
                a(this.f6268f, this.f6270h, true);
            }
            a(this.f6269g, this.f6268f, false);
            this.f6270h.delete();
            this.f6275m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f6268f, true), f6262b));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        int i10 = this.f6278p;
        return i10 >= 2000 && i10 >= this.f6277o.size();
    }

    private void k() {
        if (this.f6275m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() throws IOException {
        while (true) {
            if (this.f6274l <= this.f6272j && this.f6277o.size() <= this.f6276n) {
                return;
            } else {
                c(this.f6277o.entrySet().iterator2().next().getKey());
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.f6275m == null) {
            return;
        }
        Iterator iterator2 = new ArrayList(this.f6277o.values()).iterator2();
        while (iterator2.hasNext()) {
            c cVar = (c) iterator2.next();
            if (cVar.f6298e != null) {
                cVar.f6298e.c();
            }
        }
        l();
        this.f6275m.close();
        this.f6275m = null;
    }

    private synchronized a d(String str) throws IOException {
        k();
        e(str);
        c cVar = this.f6277o.get(str);
        byte b4 = 0;
        if (cVar != null) {
            if (cVar.f6298e != null) {
                return null;
            }
        } else {
            cVar = new c(this, str, b4);
            this.f6277o.put(str, cVar);
        }
        a aVar = new a(this, cVar, b4);
        cVar.f6298e = aVar;
        this.f6275m.write("DIRTY " + str + '\n');
        this.f6275m.flush();
        return aVar;
    }

    private static ThreadPoolExecutor f() {
        try {
            ThreadPoolExecutor threadPoolExecutor = f6264d;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                f6264d = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f6265r);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f6264d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ed, code lost:
    
        throw new java.io.IOException("unexpected journal line: ".concat(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.ht.g():void");
    }

    public final a b(String str) throws IOException {
        return d(str);
    }

    public final synchronized boolean c(String str) throws IOException {
        k();
        e(str);
        c cVar = this.f6277o.get(str);
        if (cVar != null && cVar.f6298e == null) {
            for (int i10 = 0; i10 < this.f6273k; i10++) {
                File a10 = cVar.a(i10);
                if (a10.exists() && !a10.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(a10)));
                }
                this.f6274l -= cVar.f6296c[i10];
                cVar.f6296c[i10] = 0;
            }
            this.f6278p++;
            this.f6275m.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f6277o.remove(str);
            if (j()) {
                f().submit(this.f6280s);
            }
            return true;
        }
        return false;
    }

    private static void e(String str) {
        if (f6261a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public final void a(int i10) {
        if (i10 < 10) {
            i10 = 10;
        } else if (i10 > 10000) {
            i10 = 10000;
        }
        this.f6276n = i10;
    }

    public final File b() {
        return this.f6267e;
    }

    public static void a() {
        ThreadPoolExecutor threadPoolExecutor = f6264d;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        f6264d.shutdown();
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

    public static ht a(File file, long j10) throws IOException {
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
            ht htVar = new ht(file, j10);
            if (htVar.f6268f.exists()) {
                try {
                    htVar.g();
                    htVar.h();
                    htVar.f6275m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htVar.f6268f, true), f6262b));
                    return htVar;
                } catch (Throwable unused) {
                    htVar.d();
                }
            }
            file.mkdirs();
            ht htVar2 = new ht(file, j10);
            htVar2.i();
            return htVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final void d() throws IOException {
        close();
        b(this.f6267e);
    }

    public final synchronized void c() throws IOException {
        k();
        l();
        this.f6275m.flush();
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
        k();
        e(str);
        c cVar = this.f6277o.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.f6297d) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f6273k];
        for (int i10 = 0; i10 < this.f6273k; i10++) {
            try {
                inputStreamArr[i10] = new FileInputStream(cVar.a(i10));
            } catch (FileNotFoundException unused) {
                for (int i11 = 0; i11 < this.f6273k && inputStreamArr[i11] != null; i11++) {
                    a(inputStreamArr[i11]);
                }
                return null;
            }
        }
        this.f6278p++;
        this.f6275m.append((CharSequence) ("READ " + str + '\n'));
        if (j()) {
            f().submit(this.f6280s);
        }
        return new b(this, str, cVar.f6299f, inputStreamArr, cVar.f6296c, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(a aVar, boolean z10) throws IOException {
        c cVar = aVar.f6284b;
        if (cVar.f6298e == aVar) {
            if (z10 && !cVar.f6297d) {
                for (int i10 = 0; i10 < this.f6273k; i10++) {
                    if (aVar.f6285c[i10]) {
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
            for (int i11 = 0; i11 < this.f6273k; i11++) {
                File b4 = cVar.b(i11);
                if (z10) {
                    if (b4.exists()) {
                        File a10 = cVar.a(i11);
                        b4.renameTo(a10);
                        long j10 = cVar.f6296c[i11];
                        long length = a10.length();
                        cVar.f6296c[i11] = length;
                        this.f6274l = (this.f6274l - j10) + length;
                    }
                } else {
                    a(b4);
                }
            }
            this.f6278p++;
            cVar.f6298e = null;
            if (cVar.f6297d | z10) {
                c.a(cVar);
                this.f6275m.write("CLEAN " + cVar.f6295b + cVar.a() + '\n');
                if (z10) {
                    long j11 = this.f6279q;
                    this.f6279q = 1 + j11;
                    cVar.f6299f = j11;
                }
            } else {
                this.f6277o.remove(cVar.f6295b);
                this.f6275m.write("REMOVE " + cVar.f6295b + '\n');
            }
            this.f6275m.flush();
            if (this.f6274l > this.f6272j || j()) {
                f().submit(this.f6280s);
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
