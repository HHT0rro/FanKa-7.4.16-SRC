package com.kwad.sdk.core.diskcache.a;

import com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache;
import com.kwad.sdk.utils.q;
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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements Closeable {
    public static final Pattern atD = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream atS = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.a.a.3
        @Override // java.io.OutputStream
        public final void write(int i10) {
        }
    };
    private final File atE;
    private final File atF;
    private final File atG;
    private final File atH;
    private final int atI;
    private int atJ;
    private final int atK;
    private Writer atM;
    private int atO;
    private long maxSize;
    private long size = 0;
    private int atL = 0;
    private final LinkedHashMap<String, b> atN = new LinkedHashMap<>(0, 0.75f, true);
    private long atP = 0;
    public final ThreadPoolExecutor atQ = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.a.a.1
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    });
    private final Callable<Void> atR = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.a.a.2
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: CS, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                if (a.this.atM == null) {
                    return null;
                }
                a.this.trimToSize();
                a.this.CY();
                if (a.this.CX()) {
                    a.this.CV();
                    a.a(a.this, 0);
                }
                return null;
            }
        }
    };

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class C0519a {
        private final b atU;
        private final boolean[] atV;
        private boolean atW;
        private boolean atX;

        /* renamed from: com.kwad.sdk.core.diskcache.a.a$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public class C0520a extends FilterOutputStream {
            public /* synthetic */ C0520a(C0519a c0519a, OutputStream outputStream, byte b4) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    C0519a.b(C0519a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    C0519a.b(C0519a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i10) {
                try {
                    this.out.write(i10);
                } catch (IOException unused) {
                    C0519a.b(C0519a.this, true);
                }
            }

            private C0520a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i10, int i11) {
                try {
                    this.out.write(bArr, i10, i11);
                } catch (IOException unused) {
                    C0519a.b(C0519a.this, true);
                }
            }
        }

        public /* synthetic */ C0519a(a aVar, b bVar, byte b4) {
            this(bVar);
        }

        public static /* synthetic */ boolean b(C0519a c0519a, boolean z10) {
            c0519a.atW = true;
            return true;
        }

        public final void abort() {
            a.this.a(this, false);
        }

        public final OutputStream cZ(int i10) {
            FileOutputStream fileOutputStream;
            C0520a c0520a;
            synchronized (a.this) {
                if (this.atU.aub == this) {
                    byte b4 = 0;
                    if (!this.atU.aua) {
                        this.atV[0] = true;
                    }
                    File db2 = this.atU.db(0);
                    try {
                        fileOutputStream = new FileOutputStream(db2);
                    } catch (FileNotFoundException unused) {
                        a.this.atE.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(db2);
                        } catch (FileNotFoundException unused2) {
                            return a.atS;
                        }
                    }
                    c0520a = new C0520a(this, fileOutputStream, b4);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0520a;
        }

        public final void commit() {
            if (this.atW) {
                a.this.a(this, false);
                a.this.remove(this.atU.key);
            } else {
                a.this.a(this, true);
            }
            this.atX = true;
        }

        private C0519a(b bVar) {
            this.atU = bVar;
            this.atV = bVar.aua ? null : new boolean[a.this.atK];
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class b {
        private final long[] atZ;
        private boolean aua;
        private C0519a aub;
        private long auc;
        private final String key;

        public /* synthetic */ b(a aVar, String str, byte b4) {
            this(str);
        }

        public final String Da() {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.atZ) {
                sb2.append(' ');
                sb2.append(j10);
            }
            return sb2.toString();
        }

        public final File da(int i10) {
            return new File(a.this.atE, this.key + i10);
        }

        public final File db(int i10) {
            return new File(a.this.atE, this.key + i10 + ".tmp");
        }

        private b(String str) {
            this.key = str;
            this.atZ = new long[a.this.atK];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.atK) {
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    try {
                        this.atZ[i10] = Long.parseLong(strArr[i10]);
                    } catch (NumberFormatException unused) {
                        throw c(strArr);
                    }
                }
                return;
            }
            throw c(strArr);
        }

        private static IOException c(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public static /* synthetic */ boolean a(b bVar, boolean z10) {
            bVar.aua = true;
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class c implements Closeable {
        private final long[] atZ;
        private final long auc;
        private File[] aud;
        private final InputStream[] aue;
        private final String key;

        public /* synthetic */ c(a aVar, String str, long j10, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b4) {
            this(str, j10, fileArr, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.aue) {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }

        public final File dc(int i10) {
            return this.aud[0];
        }

        private c(String str, long j10, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.auc = j10;
            this.aud = fileArr;
            this.aue = inputStreamArr;
            this.atZ = jArr;
        }
    }

    private a(File file, int i10, int i11, long j10, int i12) {
        this.atE = file;
        this.atI = i10;
        this.atF = new File(file, "journal");
        this.atG = new File(file, "journal.tmp");
        this.atH = new File(file, "journal.bkp");
        this.atK = i11;
        this.maxSize = j10;
        this.atJ = i12;
    }

    private void CT() {
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.atF), com.kwad.sdk.crash.utils.a.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.atI).equals(readLine3) || !Integer.toString(this.atK).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    dn(bVar.readLine());
                    i10++;
                } catch (EOFException unused) {
                    this.atO = i10 - this.atN.size();
                    com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
            throw th;
        }
    }

    private void CU() {
        p(this.atG);
        Iterator<b> iterator2 = this.atN.values().iterator2();
        while (iterator2.hasNext()) {
            b next = iterator2.next();
            int i10 = 0;
            if (next.aub != null) {
                next.aub = null;
                while (i10 < this.atK) {
                    p(next.da(i10));
                    p(next.db(i10));
                    i10++;
                }
                iterator2.remove();
            } else {
                while (i10 < this.atK) {
                    this.size += next.atZ[i10];
                    this.atL++;
                    i10++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void CV() {
        Writer writer = this.atM;
        if (writer != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.atG), com.kwad.sdk.crash.utils.a.US_ASCII));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.atI));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.atK));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (b bVar : this.atN.values()) {
                if (bVar.aub != null) {
                    bufferedWriter.write("DIRTY " + bVar.key + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + bVar.key + bVar.Da() + '\n');
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
            if (this.atF.exists()) {
                a(this.atF, this.atH, true);
            }
            a(this.atG, this.atF, false);
            this.atH.delete();
            this.atM = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.atF, true), com.kwad.sdk.crash.utils.a.US_ASCII));
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean CX() {
        int i10 = this.atO;
        return i10 >= 2000 && i10 >= this.atN.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CY() {
        while (this.atL > this.atJ) {
            remove(this.atN.entrySet().iterator2().next().getKey());
        }
    }

    public static /* synthetic */ int a(a aVar, int i10) {
        aVar.atO = 0;
        return 0;
    }

    private void checkNotClosed() {
        if (this.atM == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void dn(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i10 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i10);
            if (indexOf2 == -1) {
                substring = str.substring(i10);
                if (indexOf == 6 && str.startsWith(DiskLruCache.REMOVE)) {
                    this.atN.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i10, indexOf2);
            }
            b bVar = this.atN.get(substring);
            byte b4 = 0;
            if (bVar == null) {
                bVar = new b(this, substring, b4);
                this.atN.put(substring, bVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(DiskLruCache.CLEAN)) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                b.a(bVar, true);
                bVar.aub = null;
                bVar.b(split);
                return;
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DiskLruCache.DIRTY)) {
                bVar.aub = new C0519a(this, bVar, b4);
                return;
            } else {
                if (indexOf2 == -1 && indexOf == 4 && str.startsWith(DiskLruCache.READ)) {
                    return;
                }
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private static void dq(String str) {
        if (atD.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    private static void p(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove(this.atN.entrySet().iterator2().next().getKey());
        }
    }

    public final synchronized int CW() {
        return this.atJ;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.atM == null) {
            return;
        }
        Iterator iterator2 = new ArrayList(this.atN.values()).iterator2();
        while (iterator2.hasNext()) {
            b bVar = (b) iterator2.next();
            if (bVar.aub != null) {
                bVar.aub.abort();
            }
        }
        trimToSize();
        CY();
        com.kwad.sdk.crash.utils.b.closeQuietly(this.atM);
        this.atM = null;
    }

    public final void delete() {
        close();
        q.deleteContents(this.atE);
    }

    /* renamed from: do, reason: not valid java name */
    public final synchronized c m2863do(String str) {
        if (this.atM == null) {
            return null;
        }
        dq(str);
        b bVar = this.atN.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.aua) {
            return null;
        }
        int i10 = this.atK;
        File[] fileArr = new File[i10];
        InputStream[] inputStreamArr = new InputStream[i10];
        for (int i11 = 0; i11 < this.atK; i11++) {
            try {
                File da2 = bVar.da(i11);
                fileArr[i11] = da2;
                inputStreamArr[i11] = new FileInputStream(da2);
            } catch (FileNotFoundException unused) {
                for (int i12 = 0; i12 < this.atK && inputStreamArr[i12] != null; i12++) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamArr[i12]);
                }
                return null;
            }
        }
        this.atO++;
        this.atM.append((CharSequence) ("READ " + str + '\n'));
        if (CX()) {
            this.atQ.submit(this.atR);
        }
        return new c(this, str, bVar.auc, fileArr, inputStreamArr, bVar.atZ, (byte) 0);
    }

    public final C0519a dp(String str) {
        return e(str, -1L);
    }

    public final synchronized void flush() {
        checkNotClosed();
        trimToSize();
        CY();
        this.atM.flush();
    }

    public final File getDirectory() {
        return this.atE;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized boolean remove(String str) {
        checkNotClosed();
        dq(str);
        b bVar = this.atN.get(str);
        if (bVar != null && bVar.aub == null) {
            for (int i10 = 0; i10 < this.atK; i10++) {
                File da2 = bVar.da(i10);
                if (da2.exists() && !da2.delete()) {
                    throw new IOException("failed to delete " + ((Object) da2));
                }
                this.size -= bVar.atZ[i10];
                this.atL--;
                bVar.atZ[i10] = 0;
            }
            this.atO++;
            this.atM.append((CharSequence) ("REMOVE " + str + '\n'));
            this.atN.remove(str);
            if (CX()) {
                this.atQ.submit(this.atR);
            }
            return true;
        }
        return false;
    }

    private synchronized C0519a e(String str, long j10) {
        checkNotClosed();
        dq(str);
        b bVar = this.atN.get(str);
        byte b4 = 0;
        if (bVar != null) {
            if (bVar.aub != null) {
                return null;
            }
        } else {
            bVar = new b(this, str, b4);
            this.atN.put(str, bVar);
        }
        C0519a c0519a = new C0519a(this, bVar, b4);
        bVar.aub = c0519a;
        this.atM.write("DIRTY " + str + '\n');
        this.atM.flush();
        return c0519a;
    }

    public static a a(File file, int i10, int i11, long j10) {
        return a(file, 1, 1, 209715200L, Integer.MAX_VALUE);
    }

    public static a a(File file, int i10, int i11, long j10, int i12) {
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
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i10, i11, j10, i12);
            if (aVar.atF.exists()) {
                try {
                    aVar.CT();
                    aVar.CU();
                    aVar.atM = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.atF, true), com.kwad.sdk.crash.utils.a.US_ASCII));
                    return aVar;
                } catch (IOException e2) {
                    System.out.println("DiskLruCache " + ((Object) file) + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.delete();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i10, i11, j10, i12);
            aVar2.CV();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private static void a(File file, File file2, boolean z10) {
        if (z10) {
            p(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0519a c0519a, boolean z10) {
        b bVar = c0519a.atU;
        if (bVar.aub == c0519a) {
            if (z10 && !bVar.aua) {
                for (int i10 = 0; i10 < this.atK; i10++) {
                    if (c0519a.atV[i10]) {
                        if (!bVar.db(i10).exists()) {
                            c0519a.abort();
                            return;
                        }
                    } else {
                        c0519a.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                    }
                }
            }
            for (int i11 = 0; i11 < this.atK; i11++) {
                File db2 = bVar.db(i11);
                if (z10) {
                    if (db2.exists()) {
                        File da2 = bVar.da(i11);
                        db2.renameTo(da2);
                        long j10 = bVar.atZ[i11];
                        long length = da2.length();
                        bVar.atZ[i11] = length;
                        this.size = (this.size - j10) + length;
                        this.atL++;
                    }
                } else {
                    p(db2);
                }
            }
            this.atO++;
            bVar.aub = null;
            if (!(bVar.aua | z10)) {
                this.atN.remove(bVar.key);
                this.atM.write("REMOVE " + bVar.key + '\n');
            } else {
                b.a(bVar, true);
                this.atM.write("CLEAN " + bVar.key + bVar.Da() + '\n');
                if (z10) {
                    long j11 = this.atP;
                    this.atP = 1 + j11;
                    bVar.auc = j11;
                }
            }
            this.atM.flush();
            if (this.size > this.maxSize || this.atL > this.atJ || CX()) {
                this.atQ.submit(this.atR);
            }
            return;
        }
        throw new IllegalStateException();
    }
}
