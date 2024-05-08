package com.tencent.cloud.huiyansdkface.okhttp3.internal.cache;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.io.FileSystem;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Sink;
import com.tencent.cloud.huiyansdkface.okio.Source;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class DiskLruCache implements Closeable, Flushable {

    /* renamed from: b, reason: collision with root package name */
    public final FileSystem f41643b;

    /* renamed from: c, reason: collision with root package name */
    public final File f41644c;

    /* renamed from: d, reason: collision with root package name */
    public final int f41645d;

    /* renamed from: e, reason: collision with root package name */
    public BufferedSink f41646e;

    /* renamed from: g, reason: collision with root package name */
    public int f41648g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f41649h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f41650i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f41651j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f41652k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f41653l;

    /* renamed from: n, reason: collision with root package name */
    private final File f41654n;

    /* renamed from: o, reason: collision with root package name */
    private final File f41655o;

    /* renamed from: p, reason: collision with root package name */
    private final File f41656p;

    /* renamed from: q, reason: collision with root package name */
    private final int f41657q;

    /* renamed from: r, reason: collision with root package name */
    private long f41658r;

    /* renamed from: u, reason: collision with root package name */
    private final Executor f41661u;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ boolean f41642m = true;

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f41641a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: s, reason: collision with root package name */
    private long f41659s = 0;

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashMap<String, Entry> f41647f = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: t, reason: collision with root package name */
    private long f41660t = 0;

    /* renamed from: v, reason: collision with root package name */
    private final Runnable f41662v = new Runnable() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.DiskLruCache.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (DiskLruCache.this) {
                DiskLruCache diskLruCache = DiskLruCache.this;
                if ((!diskLruCache.f41650i) || diskLruCache.f41651j) {
                    return;
                }
                try {
                    diskLruCache.c();
                } catch (IOException unused) {
                    DiskLruCache.this.f41652k = true;
                }
                try {
                    if (DiskLruCache.this.b()) {
                        DiskLruCache.this.a();
                        DiskLruCache.this.f41648g = 0;
                    }
                } catch (IOException unused2) {
                    DiskLruCache diskLruCache2 = DiskLruCache.this;
                    diskLruCache2.f41653l = true;
                    diskLruCache2.f41646e = Okio.buffer(Okio.blackhole());
                }
            }
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class Editor {

        /* renamed from: a, reason: collision with root package name */
        public final Entry f41670a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f41671b;

        /* renamed from: d, reason: collision with root package name */
        private boolean f41673d;

        public Editor(Entry entry) {
            this.f41670a = entry;
            this.f41671b = entry.f41679e ? null : new boolean[DiskLruCache.this.f41645d];
        }

        public void a() {
            if (this.f41670a.f41680f != this) {
                return;
            }
            int i10 = 0;
            while (true) {
                DiskLruCache diskLruCache = DiskLruCache.this;
                if (i10 >= diskLruCache.f41645d) {
                    this.f41670a.f41680f = null;
                    return;
                } else {
                    try {
                        diskLruCache.f41643b.delete(this.f41670a.f41678d[i10]);
                    } catch (IOException unused) {
                    }
                    i10++;
                }
            }
        }

        public void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.f41673d) {
                    throw new IllegalStateException();
                }
                if (this.f41670a.f41680f == this) {
                    DiskLruCache.this.a(this, false);
                }
                this.f41673d = true;
            }
        }

        public void abortUnlessCommitted() {
            synchronized (DiskLruCache.this) {
                if (!this.f41673d && this.f41670a.f41680f == this) {
                    try {
                        DiskLruCache.this.a(this, false);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.f41673d) {
                    throw new IllegalStateException();
                }
                if (this.f41670a.f41680f == this) {
                    DiskLruCache.this.a(this, true);
                }
                this.f41673d = true;
            }
        }

        public Sink newSink(int i10) {
            synchronized (DiskLruCache.this) {
                if (this.f41673d) {
                    throw new IllegalStateException();
                }
                Entry entry = this.f41670a;
                if (entry.f41680f != this) {
                    return Okio.blackhole();
                }
                if (!entry.f41679e) {
                    this.f41671b[i10] = true;
                }
                try {
                    return new FaultHidingSink(DiskLruCache.this.f41643b.sink(entry.f41678d[i10])) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.DiskLruCache.Editor.1
                        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.FaultHidingSink
                        public void a(IOException iOException) {
                            synchronized (DiskLruCache.this) {
                                Editor.this.a();
                            }
                        }
                    };
                } catch (FileNotFoundException unused) {
                    return Okio.blackhole();
                }
            }
        }

        public Source newSource(int i10) {
            synchronized (DiskLruCache.this) {
                if (this.f41673d) {
                    throw new IllegalStateException();
                }
                Entry entry = this.f41670a;
                if (!entry.f41679e || entry.f41680f != this) {
                    return null;
                }
                try {
                    return DiskLruCache.this.f41643b.source(entry.f41677c[i10]);
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class Entry {

        /* renamed from: a, reason: collision with root package name */
        public final String f41675a;

        /* renamed from: b, reason: collision with root package name */
        public final long[] f41676b;

        /* renamed from: c, reason: collision with root package name */
        public final File[] f41677c;

        /* renamed from: d, reason: collision with root package name */
        public final File[] f41678d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f41679e;

        /* renamed from: f, reason: collision with root package name */
        public Editor f41680f;

        /* renamed from: g, reason: collision with root package name */
        public long f41681g;

        public Entry(String str) {
            this.f41675a = str;
            int i10 = DiskLruCache.this.f41645d;
            this.f41676b = new long[i10];
            this.f41677c = new File[i10];
            this.f41678d = new File[i10];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i11 = 0; i11 < DiskLruCache.this.f41645d; i11++) {
                sb2.append(i11);
                this.f41677c[i11] = new File(DiskLruCache.this.f41644c, sb2.toString());
                sb2.append(".tmp");
                this.f41678d[i11] = new File(DiskLruCache.this.f41644c, sb2.toString());
                sb2.setLength(length);
            }
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public Snapshot a() {
            if (!Thread.holdsLock(DiskLruCache.this)) {
                throw new AssertionError();
            }
            Source[] sourceArr = new Source[DiskLruCache.this.f41645d];
            long[] jArr = (long[]) this.f41676b.clone();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                try {
                    DiskLruCache diskLruCache = DiskLruCache.this;
                    if (i11 >= diskLruCache.f41645d) {
                        return new Snapshot(this.f41675a, this.f41681g, sourceArr, jArr);
                    }
                    sourceArr[i11] = diskLruCache.f41643b.source(this.f41677c[i11]);
                    i11++;
                } catch (FileNotFoundException unused) {
                    while (true) {
                        DiskLruCache diskLruCache2 = DiskLruCache.this;
                        if (i10 >= diskLruCache2.f41645d || sourceArr[i10] == null) {
                            try {
                                diskLruCache2.a(this);
                                return null;
                            } catch (IOException unused2) {
                                return null;
                            }
                        }
                        Util.closeQuietly(sourceArr[i10]);
                        i10++;
                    }
                }
            }
        }

        public void a(BufferedSink bufferedSink) throws IOException {
            for (long j10 : this.f41676b) {
                bufferedSink.writeByte(32).writeDecimalLong(j10);
            }
        }

        public void a(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.f41645d) {
                throw b(strArr);
            }
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    this.f41676b[i10] = Long.parseLong(strArr[i10]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class Snapshot implements Closeable {

        /* renamed from: b, reason: collision with root package name */
        private final String f41684b;

        /* renamed from: c, reason: collision with root package name */
        private final long f41685c;

        /* renamed from: d, reason: collision with root package name */
        private final Source[] f41686d;

        /* renamed from: e, reason: collision with root package name */
        private final long[] f41687e;

        public Snapshot(String str, long j10, Source[] sourceArr, long[] jArr) {
            this.f41684b = str;
            this.f41685c = j10;
            this.f41686d = sourceArr;
            this.f41687e = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Source source : this.f41686d) {
                Util.closeQuietly(source);
            }
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.a(this.f41684b, this.f41685c);
        }

        public long getLength(int i10) {
            return this.f41687e[i10];
        }

        public Source getSource(int i10) {
            return this.f41686d[i10];
        }

        public String key() {
            return this.f41684b;
        }
    }

    public DiskLruCache(FileSystem fileSystem, File file, int i10, int i11, long j10, Executor executor) {
        this.f41643b = fileSystem;
        this.f41644c = file;
        this.f41657q = i10;
        this.f41654n = new File(file, "journal");
        this.f41655o = new File(file, "journal.tmp");
        this.f41656p = new File(file, "journal.bkp");
        this.f41645d = i11;
        this.f41658r = j10;
        this.f41661u = executor;
    }

    private void a(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i10 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i10);
        if (indexOf2 == -1) {
            substring = str.substring(i10);
            if (indexOf == 6 && str.startsWith(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.REMOVE)) {
                this.f41647f.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i10, indexOf2);
        }
        Entry entry = this.f41647f.get(substring);
        if (entry == null) {
            entry = new Entry(substring);
            this.f41647f.put(substring, entry);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.CLEAN)) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            entry.f41679e = true;
            entry.f41680f = null;
            entry.a(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.DIRTY)) {
            entry.f41680f = new Editor(entry);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.READ)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private void b(String str) {
        if (f41641a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public static DiskLruCache create(FileSystem fileSystem, File file, int i10, int i11, long j10) {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i11 > 0) {
            return new DiskLruCache(fileSystem, file, i10, i11, j10, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private void d() throws IOException {
        BufferedSource buffer = Okio.buffer(this.f41643b.source(this.f41654n));
        try {
            String readUtf8LineStrict = buffer.readUtf8LineStrict();
            String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict4 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict5 = buffer.readUtf8LineStrict();
            if (!"libcore.io.DiskLruCache".equals(readUtf8LineStrict) || !"1".equals(readUtf8LineStrict2) || !Integer.toString(this.f41657q).equals(readUtf8LineStrict3) || !Integer.toString(this.f41645d).equals(readUtf8LineStrict4) || !"".equals(readUtf8LineStrict5)) {
                throw new IOException("unexpected journal header: [" + readUtf8LineStrict + ", " + readUtf8LineStrict2 + ", " + readUtf8LineStrict4 + ", " + readUtf8LineStrict5 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    a(buffer.readUtf8LineStrict());
                    i10++;
                } catch (EOFException unused) {
                    this.f41648g = i10 - this.f41647f.size();
                    if (buffer.exhausted()) {
                        this.f41646e = e();
                    } else {
                        a();
                    }
                    Util.closeQuietly(buffer);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.closeQuietly(buffer);
            throw th;
        }
    }

    private BufferedSink e() throws FileNotFoundException {
        return Okio.buffer(new FaultHidingSink(this.f41643b.appendingSink(this.f41654n)) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.DiskLruCache.2

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ boolean f41664a = true;

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.FaultHidingSink
            public void a(IOException iOException) {
                if (!f41664a && !Thread.holdsLock(DiskLruCache.this)) {
                    throw new AssertionError();
                }
                DiskLruCache.this.f41649h = true;
            }
        });
    }

    private void f() throws IOException {
        this.f41643b.delete(this.f41655o);
        Iterator<Entry> iterator2 = this.f41647f.values().iterator2();
        while (iterator2.hasNext()) {
            Entry next = iterator2.next();
            int i10 = 0;
            if (next.f41680f == null) {
                while (i10 < this.f41645d) {
                    this.f41659s += next.f41676b[i10];
                    i10++;
                }
            } else {
                next.f41680f = null;
                while (i10 < this.f41645d) {
                    this.f41643b.delete(next.f41677c[i10]);
                    this.f41643b.delete(next.f41678d[i10]);
                    i10++;
                }
                iterator2.remove();
            }
        }
    }

    private synchronized void g() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized Editor a(String str, long j10) throws IOException {
        initialize();
        g();
        b(str);
        Entry entry = this.f41647f.get(str);
        if (j10 != -1 && (entry == null || entry.f41681g != j10)) {
            return null;
        }
        if (entry != null && entry.f41680f != null) {
            return null;
        }
        if (!this.f41652k && !this.f41653l) {
            this.f41646e.writeUtf8(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.DIRTY).writeByte(32).writeUtf8(str).writeByte(10);
            this.f41646e.flush();
            if (this.f41649h) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(str);
                this.f41647f.put(str, entry);
            }
            Editor editor = new Editor(entry);
            entry.f41680f = editor;
            return editor;
        }
        this.f41661u.execute(this.f41662v);
        return null;
    }

    public synchronized void a() throws IOException {
        BufferedSink bufferedSink = this.f41646e;
        if (bufferedSink != null) {
            bufferedSink.close();
        }
        BufferedSink buffer = Okio.buffer(this.f41643b.sink(this.f41655o));
        try {
            buffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
            buffer.writeUtf8("1").writeByte(10);
            buffer.writeDecimalLong(this.f41657q).writeByte(10);
            buffer.writeDecimalLong(this.f41645d).writeByte(10);
            buffer.writeByte(10);
            for (Entry entry : this.f41647f.values()) {
                if (entry.f41680f != null) {
                    buffer.writeUtf8(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.DIRTY).writeByte(32);
                    buffer.writeUtf8(entry.f41675a);
                } else {
                    buffer.writeUtf8(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.CLEAN).writeByte(32);
                    buffer.writeUtf8(entry.f41675a);
                    entry.a(buffer);
                }
                buffer.writeByte(10);
            }
            buffer.close();
            if (this.f41643b.exists(this.f41654n)) {
                this.f41643b.rename(this.f41654n, this.f41656p);
            }
            this.f41643b.rename(this.f41655o, this.f41654n);
            this.f41643b.delete(this.f41656p);
            this.f41646e = e();
            this.f41649h = false;
            this.f41653l = false;
        } catch (Throwable th) {
            buffer.close();
            throw th;
        }
    }

    public synchronized void a(Editor editor, boolean z10) throws IOException {
        Entry entry = editor.f41670a;
        if (entry.f41680f != editor) {
            throw new IllegalStateException();
        }
        if (z10 && !entry.f41679e) {
            for (int i10 = 0; i10 < this.f41645d; i10++) {
                if (!editor.f41671b[i10]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                if (!this.f41643b.exists(entry.f41678d[i10])) {
                    editor.abort();
                    return;
                }
            }
        }
        for (int i11 = 0; i11 < this.f41645d; i11++) {
            File file = entry.f41678d[i11];
            if (!z10) {
                this.f41643b.delete(file);
            } else if (this.f41643b.exists(file)) {
                File file2 = entry.f41677c[i11];
                this.f41643b.rename(file, file2);
                long j10 = entry.f41676b[i11];
                long size = this.f41643b.size(file2);
                entry.f41676b[i11] = size;
                this.f41659s = (this.f41659s - j10) + size;
            }
        }
        this.f41648g++;
        entry.f41680f = null;
        if (entry.f41679e || z10) {
            entry.f41679e = true;
            this.f41646e.writeUtf8(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.CLEAN).writeByte(32);
            this.f41646e.writeUtf8(entry.f41675a);
            entry.a(this.f41646e);
            this.f41646e.writeByte(10);
            if (z10) {
                long j11 = this.f41660t;
                this.f41660t = 1 + j11;
                entry.f41681g = j11;
            }
        } else {
            this.f41647f.remove(entry.f41675a);
            this.f41646e.writeUtf8(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.REMOVE).writeByte(32);
            this.f41646e.writeUtf8(entry.f41675a);
            this.f41646e.writeByte(10);
        }
        this.f41646e.flush();
        if (this.f41659s > this.f41658r || b()) {
            this.f41661u.execute(this.f41662v);
        }
    }

    public boolean a(Entry entry) throws IOException {
        Editor editor = entry.f41680f;
        if (editor != null) {
            editor.a();
        }
        for (int i10 = 0; i10 < this.f41645d; i10++) {
            this.f41643b.delete(entry.f41677c[i10]);
            long j10 = this.f41659s;
            long[] jArr = entry.f41676b;
            this.f41659s = j10 - jArr[i10];
            jArr[i10] = 0;
        }
        this.f41648g++;
        this.f41646e.writeUtf8(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.REMOVE).writeByte(32).writeUtf8(entry.f41675a).writeByte(10);
        this.f41647f.remove(entry.f41675a);
        if (b()) {
            this.f41661u.execute(this.f41662v);
        }
        return true;
    }

    public boolean b() {
        int i10 = this.f41648g;
        return i10 >= 2000 && i10 >= this.f41647f.size();
    }

    public void c() throws IOException {
        while (this.f41659s > this.f41658r) {
            a(this.f41647f.values().iterator2().next());
        }
        this.f41652k = false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f41650i && !this.f41651j) {
            for (Entry entry : (Entry[]) this.f41647f.values().toArray(new Entry[this.f41647f.size()])) {
                Editor editor = entry.f41680f;
                if (editor != null) {
                    editor.abort();
                }
            }
            c();
            this.f41646e.close();
            this.f41646e = null;
            this.f41651j = true;
            return;
        }
        this.f41651j = true;
    }

    public void delete() throws IOException {
        close();
        this.f41643b.deleteContents(this.f41644c);
    }

    public Editor edit(String str) throws IOException {
        return a(str, -1L);
    }

    public synchronized void evictAll() throws IOException {
        initialize();
        for (Entry entry : (Entry[]) this.f41647f.values().toArray(new Entry[this.f41647f.size()])) {
            a(entry);
        }
        this.f41652k = false;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f41650i) {
            g();
            c();
            this.f41646e.flush();
        }
    }

    public synchronized Snapshot get(String str) throws IOException {
        initialize();
        g();
        b(str);
        Entry entry = this.f41647f.get(str);
        if (entry != null && entry.f41679e) {
            Snapshot a10 = entry.a();
            if (a10 == null) {
                return null;
            }
            this.f41648g++;
            this.f41646e.writeUtf8(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.READ).writeByte(32).writeUtf8(str).writeByte(10);
            if (b()) {
                this.f41661u.execute(this.f41662v);
            }
            return a10;
        }
        return null;
    }

    public File getDirectory() {
        return this.f41644c;
    }

    public synchronized long getMaxSize() {
        return this.f41658r;
    }

    public synchronized void initialize() throws IOException {
        if (!f41642m && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.f41650i) {
            return;
        }
        if (this.f41643b.exists(this.f41656p)) {
            if (this.f41643b.exists(this.f41654n)) {
                this.f41643b.delete(this.f41656p);
            } else {
                this.f41643b.rename(this.f41656p, this.f41654n);
            }
        }
        if (this.f41643b.exists(this.f41654n)) {
            try {
                d();
                f();
                this.f41650i = true;
                return;
            } catch (IOException e2) {
                Platform.get().log(5, "DiskLruCache " + ((Object) this.f41644c) + " is corrupt: " + e2.getMessage() + ", removing", e2);
                try {
                    delete();
                    this.f41651j = false;
                } catch (Throwable th) {
                    this.f41651j = false;
                    throw th;
                }
            }
        }
        a();
        this.f41650i = true;
    }

    public synchronized boolean isClosed() {
        return this.f41651j;
    }

    public synchronized boolean remove(String str) throws IOException {
        initialize();
        g();
        b(str);
        Entry entry = this.f41647f.get(str);
        if (entry == null) {
            return false;
        }
        boolean a10 = a(entry);
        if (a10 && this.f41659s <= this.f41658r) {
            this.f41652k = false;
        }
        return a10;
    }

    public synchronized void setMaxSize(long j10) {
        this.f41658r = j10;
        if (this.f41650i) {
            this.f41661u.execute(this.f41662v);
        }
    }

    public synchronized long size() throws IOException {
        initialize();
        return this.f41659s;
    }

    public synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new Iterator<Snapshot>() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.DiskLruCache.3

            /* renamed from: a, reason: collision with root package name */
            public final Iterator<Entry> f41666a;

            /* renamed from: b, reason: collision with root package name */
            public Snapshot f41667b;

            /* renamed from: c, reason: collision with root package name */
            public Snapshot f41668c;

            {
                this.f41666a = new ArrayList(DiskLruCache.this.f41647f.values()).iterator2();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f41667b != null) {
                    return true;
                }
                synchronized (DiskLruCache.this) {
                    if (DiskLruCache.this.f41651j) {
                        return false;
                    }
                    while (this.f41666a.hasNext()) {
                        Snapshot a10 = this.f41666a.next().a();
                        if (a10 != null) {
                            this.f41667b = a10;
                            return true;
                        }
                    }
                    return false;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Snapshot next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Snapshot snapshot = this.f41667b;
                this.f41668c = snapshot;
                this.f41667b = null;
                return snapshot;
            }

            @Override // java.util.Iterator
            public void remove() {
                Snapshot snapshot = this.f41668c;
                if (snapshot == null) {
                    throw new IllegalStateException("remove() before next()");
                }
                try {
                    DiskLruCache.this.remove(snapshot.f41684b);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.f41668c = null;
                    throw th;
                }
                this.f41668c = null;
            }
        };
    }
}
