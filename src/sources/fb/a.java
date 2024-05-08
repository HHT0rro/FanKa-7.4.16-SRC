package fb;

import com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: DiskLruCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements Closeable {

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f49237r = Pattern.compile("[a-z0-9_-]{1,64}");

    /* renamed from: s, reason: collision with root package name */
    public static final OutputStream f49238s = new b();

    /* renamed from: b, reason: collision with root package name */
    public final File f49239b;

    /* renamed from: c, reason: collision with root package name */
    public final File f49240c;

    /* renamed from: d, reason: collision with root package name */
    public final File f49241d;

    /* renamed from: e, reason: collision with root package name */
    public final File f49242e;

    /* renamed from: f, reason: collision with root package name */
    public final int f49243f;

    /* renamed from: g, reason: collision with root package name */
    public long f49244g;

    /* renamed from: h, reason: collision with root package name */
    public int f49245h;

    /* renamed from: i, reason: collision with root package name */
    public final int f49246i;

    /* renamed from: l, reason: collision with root package name */
    public Writer f49249l;

    /* renamed from: n, reason: collision with root package name */
    public int f49251n;

    /* renamed from: j, reason: collision with root package name */
    public long f49247j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f49248k = 0;

    /* renamed from: m, reason: collision with root package name */
    public final LinkedHashMap<String, d> f49250m = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: o, reason: collision with root package name */
    public long f49252o = 0;

    /* renamed from: p, reason: collision with root package name */
    public final ThreadPoolExecutor f49253p = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: q, reason: collision with root package name */
    public final Callable<Void> f49254q = new CallableC0737a();

    /* compiled from: DiskLruCache.java */
    /* renamed from: fb.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class CallableC0737a implements Callable<Void> {
        public CallableC0737a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.f49249l == null) {
                    return null;
                }
                a.this.J();
                a.this.I();
                if (a.this.A()) {
                    a.this.F();
                    a.this.f49251n = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends OutputStream {
        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        public final d f49256a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f49257b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f49258c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f49259d;

        /* compiled from: DiskLruCache.java */
        /* renamed from: fb.a$c$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public class C0738a extends FilterOutputStream {
            public /* synthetic */ C0738a(c cVar, OutputStream outputStream, CallableC0737a callableC0737a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    c.this.f49258c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    c.this.f49258c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i10) {
                try {
                    this.out.write(i10);
                } catch (IOException unused) {
                    c.this.f49258c = true;
                }
            }

            public C0738a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i10, int i11) {
                try {
                    this.out.write(bArr, i10, i11);
                } catch (IOException unused) {
                    c.this.f49258c = true;
                }
            }
        }

        public /* synthetic */ c(a aVar, d dVar, CallableC0737a callableC0737a) {
            this(dVar);
        }

        public void a() throws IOException {
            a.this.r(this, false);
        }

        public void e() throws IOException {
            if (this.f49258c) {
                a.this.r(this, false);
                a.this.G(this.f49256a.f49262a);
            } else {
                a.this.r(this, true);
            }
            this.f49259d = true;
        }

        public OutputStream f(int i10) throws IOException {
            FileOutputStream fileOutputStream;
            C0738a c0738a;
            synchronized (a.this) {
                if (this.f49256a.f49265d == this) {
                    if (!this.f49256a.f49264c) {
                        this.f49257b[i10] = true;
                    }
                    File k10 = this.f49256a.k(i10);
                    try {
                        fileOutputStream = new FileOutputStream(k10);
                    } catch (FileNotFoundException unused) {
                        a.this.f49239b.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(k10);
                        } catch (FileNotFoundException unused2) {
                            return a.f49238s;
                        }
                    }
                    c0738a = new C0738a(this, fileOutputStream, null);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0738a;
        }

        public c(d dVar) {
            this.f49256a = dVar;
            this.f49257b = dVar.f49264c ? null : new boolean[a.this.f49246i];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f49262a;

        /* renamed from: b, reason: collision with root package name */
        public final long[] f49263b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f49264c;

        /* renamed from: d, reason: collision with root package name */
        public c f49265d;

        /* renamed from: e, reason: collision with root package name */
        public long f49266e;

        public /* synthetic */ d(a aVar, String str, CallableC0737a callableC0737a) {
            this(str);
        }

        public File j(int i10) {
            return new File(a.this.f49239b, this.f49262a + "." + i10);
        }

        public File k(int i10) {
            return new File(a.this.f49239b, this.f49262a + "." + i10 + ".tmp");
        }

        public String l() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f49263b) {
                sb2.append(' ');
                sb2.append(j10);
            }
            return sb2.toString();
        }

        public final IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void n(String[] strArr) throws IOException {
            if (strArr.length == a.this.f49246i) {
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    try {
                        this.f49263b[i10] = Long.parseLong(strArr[i10]);
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public d(String str) {
            this.f49262a = str;
            this.f49263b = new long[a.this.f49246i];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class e implements Closeable {

        /* renamed from: b, reason: collision with root package name */
        public final String f49268b;

        /* renamed from: c, reason: collision with root package name */
        public final long f49269c;

        /* renamed from: d, reason: collision with root package name */
        public File[] f49270d;

        /* renamed from: e, reason: collision with root package name */
        public final InputStream[] f49271e;

        /* renamed from: f, reason: collision with root package name */
        public final long[] f49272f;

        public /* synthetic */ e(a aVar, String str, long j10, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, CallableC0737a callableC0737a) {
            this(str, j10, fileArr, inputStreamArr, jArr);
        }

        public File a(int i10) {
            return this.f49270d[i10];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f49271e) {
                fb.d.a(inputStream);
            }
        }

        public e(String str, long j10, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.f49268b = str;
            this.f49269c = j10;
            this.f49270d = fileArr;
            this.f49271e = inputStreamArr;
            this.f49272f = jArr;
        }
    }

    public a(File file, int i10, int i11, long j10, int i12) {
        this.f49239b = file;
        this.f49243f = i10;
        this.f49240c = new File(file, "journal");
        this.f49241d = new File(file, "journal.tmp");
        this.f49242e = new File(file, "journal.bkp");
        this.f49246i = i11;
        this.f49244g = j10;
        this.f49245h = i12;
    }

    public static a B(File file, int i10, int i11, long j10, int i12) throws IOException {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i12 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (i11 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    H(file2, file3, false);
                }
            }
            a aVar = new a(file, i10, i11, j10, i12);
            if (aVar.f49240c.exists()) {
                try {
                    aVar.D();
                    aVar.C();
                    aVar.f49249l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.f49240c, true), fb.d.f49287a));
                    return aVar;
                } catch (IOException e2) {
                    System.out.println("DiskLruCache " + ((Object) file) + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.u();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i10, i11, j10, i12);
            aVar2.F();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    public static void H(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            w(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void w(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public final boolean A() {
        int i10 = this.f49251n;
        return i10 >= 2000 && i10 >= this.f49250m.size();
    }

    public final void C() throws IOException {
        w(this.f49241d);
        Iterator<d> iterator2 = this.f49250m.values().iterator2();
        while (iterator2.hasNext()) {
            d next = iterator2.next();
            int i10 = 0;
            if (next.f49265d == null) {
                while (i10 < this.f49246i) {
                    this.f49247j += next.f49263b[i10];
                    this.f49248k++;
                    i10++;
                }
            } else {
                next.f49265d = null;
                while (i10 < this.f49246i) {
                    w(next.j(i10));
                    w(next.k(i10));
                    i10++;
                }
                iterator2.remove();
            }
        }
    }

    public final void D() throws IOException {
        fb.c cVar = new fb.c(new FileInputStream(this.f49240c), fb.d.f49287a);
        try {
            String d10 = cVar.d();
            String d11 = cVar.d();
            String d12 = cVar.d();
            String d13 = cVar.d();
            String d14 = cVar.d();
            if (!"libcore.io.DiskLruCache".equals(d10) || !"1".equals(d11) || !Integer.toString(this.f49243f).equals(d12) || !Integer.toString(this.f49246i).equals(d13) || !"".equals(d14)) {
                throw new IOException("unexpected journal header: [" + d10 + ", " + d11 + ", " + d13 + ", " + d14 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    E(cVar.d());
                    i10++;
                } catch (EOFException unused) {
                    this.f49251n = i10 - this.f49250m.size();
                    fb.d.a(cVar);
                    return;
                }
            }
        } catch (Throwable th) {
            fb.d.a(cVar);
            throw th;
        }
    }

    public final void E(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i10 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i10);
            if (indexOf2 == -1) {
                substring = str.substring(i10);
                if (indexOf == 6 && str.startsWith(DiskLruCache.REMOVE)) {
                    this.f49250m.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i10, indexOf2);
            }
            d dVar = this.f49250m.get(substring);
            CallableC0737a callableC0737a = null;
            if (dVar == null) {
                dVar = new d(this, substring, callableC0737a);
                this.f49250m.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(DiskLruCache.CLEAN)) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f49264c = true;
                dVar.f49265d = null;
                dVar.n(split);
                return;
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DiskLruCache.DIRTY)) {
                dVar.f49265d = new c(this, dVar, callableC0737a);
                return;
            }
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith(DiskLruCache.READ)) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public final synchronized void F() throws IOException {
        Writer writer = this.f49249l;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f49241d), fb.d.f49287a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f49243f));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f49246i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.f49250m.values()) {
                if (dVar.f49265d != null) {
                    bufferedWriter.write("DIRTY " + dVar.f49262a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.f49262a + dVar.l() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f49240c.exists()) {
                H(this.f49240c, this.f49242e, true);
            }
            H(this.f49241d, this.f49240c, false);
            this.f49242e.delete();
            this.f49249l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f49240c, true), fb.d.f49287a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    public synchronized boolean G(String str) throws IOException {
        m();
        K(str);
        d dVar = this.f49250m.get(str);
        if (dVar != null && dVar.f49265d == null) {
            for (int i10 = 0; i10 < this.f49246i; i10++) {
                File j10 = dVar.j(i10);
                if (j10.exists() && !j10.delete()) {
                    throw new IOException("failed to delete " + ((Object) j10));
                }
                this.f49247j -= dVar.f49263b[i10];
                this.f49248k--;
                dVar.f49263b[i10] = 0;
            }
            this.f49251n++;
            this.f49249l.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f49250m.remove(str);
            if (A()) {
                this.f49253p.submit(this.f49254q);
            }
            return true;
        }
        return false;
    }

    public final void I() throws IOException {
        while (this.f49248k > this.f49245h) {
            G(this.f49250m.entrySet().iterator2().next().getKey());
        }
    }

    public final void J() throws IOException {
        while (this.f49247j > this.f49244g) {
            G(this.f49250m.entrySet().iterator2().next().getKey());
        }
    }

    public final void K(String str) {
        if (f49237r.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f49249l == null) {
            return;
        }
        Iterator iterator2 = new ArrayList(this.f49250m.values()).iterator2();
        while (iterator2.hasNext()) {
            d dVar = (d) iterator2.next();
            if (dVar.f49265d != null) {
                dVar.f49265d.a();
            }
        }
        J();
        I();
        this.f49249l.close();
        this.f49249l = null;
    }

    public final void m() {
        if (this.f49249l == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void r(c cVar, boolean z10) throws IOException {
        d dVar = cVar.f49256a;
        if (dVar.f49265d == cVar) {
            if (z10 && !dVar.f49264c) {
                for (int i10 = 0; i10 < this.f49246i; i10++) {
                    if (cVar.f49257b[i10]) {
                        if (!dVar.k(i10).exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                    }
                }
            }
            for (int i11 = 0; i11 < this.f49246i; i11++) {
                File k10 = dVar.k(i11);
                if (z10) {
                    if (k10.exists()) {
                        File j10 = dVar.j(i11);
                        k10.renameTo(j10);
                        long j11 = dVar.f49263b[i11];
                        long length = j10.length();
                        dVar.f49263b[i11] = length;
                        this.f49247j = (this.f49247j - j11) + length;
                        this.f49248k++;
                    }
                } else {
                    w(k10);
                }
            }
            this.f49251n++;
            dVar.f49265d = null;
            if (dVar.f49264c | z10) {
                dVar.f49264c = true;
                this.f49249l.write("CLEAN " + dVar.f49262a + dVar.l() + '\n');
                if (z10) {
                    long j12 = this.f49252o;
                    this.f49252o = 1 + j12;
                    dVar.f49266e = j12;
                }
            } else {
                this.f49250m.remove(dVar.f49262a);
                this.f49249l.write("REMOVE " + dVar.f49262a + '\n');
            }
            this.f49249l.flush();
            if (this.f49247j > this.f49244g || this.f49248k > this.f49245h || A()) {
                this.f49253p.submit(this.f49254q);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public void u() throws IOException {
        close();
        fb.d.b(this.f49239b);
    }

    public c x(String str) throws IOException {
        return y(str, -1L);
    }

    public final synchronized c y(String str, long j10) throws IOException {
        m();
        K(str);
        d dVar = this.f49250m.get(str);
        CallableC0737a callableC0737a = null;
        if (j10 != -1 && (dVar == null || dVar.f49266e != j10)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, callableC0737a);
            this.f49250m.put(str, dVar);
        } else if (dVar.f49265d != null) {
            return null;
        }
        c cVar = new c(this, dVar, callableC0737a);
        dVar.f49265d = cVar;
        this.f49249l.write("DIRTY " + str + '\n');
        this.f49249l.flush();
        return cVar;
    }

    public synchronized e z(String str) throws IOException {
        m();
        K(str);
        d dVar = this.f49250m.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f49264c) {
            return null;
        }
        int i10 = this.f49246i;
        File[] fileArr = new File[i10];
        InputStream[] inputStreamArr = new InputStream[i10];
        for (int i11 = 0; i11 < this.f49246i; i11++) {
            try {
                File j10 = dVar.j(i11);
                fileArr[i11] = j10;
                inputStreamArr[i11] = new FileInputStream(j10);
            } catch (FileNotFoundException unused) {
                for (int i12 = 0; i12 < this.f49246i && inputStreamArr[i12] != null; i12++) {
                    fb.d.a(inputStreamArr[i12]);
                }
                return null;
            }
        }
        this.f49251n++;
        this.f49249l.append((CharSequence) ("READ " + str + '\n'));
        if (A()) {
            this.f49253p.submit(this.f49254q);
        }
        return new e(this, str, dVar.f49266e, fileArr, inputStreamArr, dVar.f49263b, null);
    }
}
