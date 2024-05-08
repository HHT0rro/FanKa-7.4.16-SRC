package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.m;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import p6.f;
import p6.g;
import p6.h;
import p6.i;
import p6.j;
import p6.k;
import p6.o;

/* compiled from: SimpleCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements Cache {

    /* renamed from: l, reason: collision with root package name */
    public static final HashSet<File> f22843l = new HashSet<>();

    /* renamed from: a, reason: collision with root package name */
    public final File f22844a;

    /* renamed from: b, reason: collision with root package name */
    public final b f22845b;

    /* renamed from: c, reason: collision with root package name */
    public final h f22846c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final p6.b f22847d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap<String, ArrayList<Cache.a>> f22848e;

    /* renamed from: f, reason: collision with root package name */
    public final Random f22849f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f22850g;

    /* renamed from: h, reason: collision with root package name */
    public long f22851h;

    /* renamed from: i, reason: collision with root package name */
    public long f22852i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f22853j;

    /* renamed from: k, reason: collision with root package name */
    public Cache.CacheException f22854k;

    /* compiled from: SimpleCache.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a extends Thread {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ConditionVariable f22855b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, ConditionVariable conditionVariable) {
            super(str);
            this.f22855b = conditionVariable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (c.this) {
                this.f22855b.open();
                c.this.q();
                c.this.f22845b.f();
            }
        }
    }

    public c(File file, b bVar, y4.a aVar) {
        this(file, bVar, aVar, null, false, false);
    }

    public static synchronized void C(File file) {
        synchronized (c.class) {
            f22843l.remove(file.getAbsoluteFile());
        }
    }

    public static void n(File file) throws Cache.CacheException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String valueOf = String.valueOf(file);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 34);
        sb2.append("Failed to create cache directory: ");
        sb2.append(valueOf);
        String sb3 = sb2.toString();
        m.c("SimpleCache", sb3);
        throw new Cache.CacheException(sb3);
    }

    public static long o(File file) throws IOException {
        long nextLong = new SecureRandom().nextLong();
        long abs = nextLong == Long.MIN_VALUE ? 0L : Math.abs(nextLong);
        String valueOf = String.valueOf(Long.toString(abs, 16));
        File file2 = new File(file, ".uid".length() != 0 ? valueOf.concat(".uid") : new String(valueOf));
        if (file2.createNewFile()) {
            return abs;
        }
        String valueOf2 = String.valueOf(file2);
        StringBuilder sb2 = new StringBuilder(valueOf2.length() + 27);
        sb2.append("Failed to create UID file: ");
        sb2.append(valueOf2);
        throw new IOException(sb2.toString());
    }

    public static long s(File[] fileArr) {
        int length = fileArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            File file = fileArr[i10];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return x(name);
                } catch (NumberFormatException unused) {
                    String valueOf = String.valueOf(file);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 20);
                    sb2.append("Malformed UID file: ");
                    sb2.append(valueOf);
                    m.c("SimpleCache", sb2.toString());
                    file.delete();
                }
            }
        }
        return -1L;
    }

    public static synchronized boolean t(File file) {
        boolean add;
        synchronized (c.class) {
            add = f22843l.add(file.getAbsoluteFile());
        }
        return add;
    }

    public static long x(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    public final void A() {
        ArrayList arrayList = new ArrayList();
        Iterator<g> iterator2 = this.f22846c.h().iterator2();
        while (iterator2.hasNext()) {
            Iterator<o> iterator22 = iterator2.next().e().iterator2();
            while (iterator22.hasNext()) {
                o next = iterator22.next();
                if (next.f52871f.length() != next.f52869d) {
                    arrayList.add(next);
                }
            }
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            z((f) arrayList.get(i10));
        }
    }

    public final o B(String str, o oVar) {
        if (!this.f22850g) {
            return oVar;
        }
        String name = ((File) com.google.android.exoplayer2.util.a.e(oVar.f52871f)).getName();
        long j10 = oVar.f52869d;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z10 = false;
        p6.b bVar = this.f22847d;
        if (bVar != null) {
            try {
                bVar.h(name, j10, currentTimeMillis);
            } catch (IOException unused) {
                m.h("SimpleCache", "Failed to update index with new touch timestamp.");
            }
        } else {
            z10 = true;
        }
        o k10 = this.f22846c.g(str).k(oVar, currentTimeMillis, z10);
        w(oVar, k10);
        return k10;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized j a(String str) {
        com.google.android.exoplayer2.util.a.g(!this.f22853j);
        return this.f22846c.j(str);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void b(f fVar) {
        com.google.android.exoplayer2.util.a.g(!this.f22853j);
        g gVar = (g) com.google.android.exoplayer2.util.a.e(this.f22846c.g(fVar.f52867b));
        gVar.l(fVar.f52868c);
        this.f22846c.p(gVar.f52874b);
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized f c(String str, long j10, long j11) throws InterruptedException, Cache.CacheException {
        f e2;
        com.google.android.exoplayer2.util.a.g(!this.f22853j);
        m();
        while (true) {
            e2 = e(str, j10, j11);
            if (e2 == null) {
                wait();
            }
        }
        return e2;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized File d(String str, long j10, long j11) throws Cache.CacheException {
        g g3;
        File file;
        com.google.android.exoplayer2.util.a.g(!this.f22853j);
        m();
        g3 = this.f22846c.g(str);
        com.google.android.exoplayer2.util.a.e(g3);
        com.google.android.exoplayer2.util.a.g(g3.g(j10, j11));
        if (!this.f22844a.exists()) {
            n(this.f22844a);
            A();
        }
        this.f22845b.c(this, str, j10, j11);
        file = new File(this.f22844a, Integer.toString(this.f22849f.nextInt(10)));
        if (!file.exists()) {
            n(file);
        }
        return o.k(file, g3.f52873a, j10, System.currentTimeMillis());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    @Nullable
    public synchronized f e(String str, long j10, long j11) throws Cache.CacheException {
        com.google.android.exoplayer2.util.a.g(!this.f22853j);
        m();
        o p10 = p(str, j10, j11);
        if (p10.f52870e) {
            return B(str, p10);
        }
        if (this.f22846c.m(str).i(j10, p10.f52869d)) {
            return p10;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void f(f fVar) {
        com.google.android.exoplayer2.util.a.g(!this.f22853j);
        z(fVar);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long g() {
        com.google.android.exoplayer2.util.a.g(!this.f22853j);
        return this.f22852i;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void h(File file, long j10) throws Cache.CacheException {
        boolean z10 = true;
        com.google.android.exoplayer2.util.a.g(!this.f22853j);
        if (file.exists()) {
            if (j10 == 0) {
                file.delete();
                return;
            }
            o oVar = (o) com.google.android.exoplayer2.util.a.e(o.h(file, j10, this.f22846c));
            g gVar = (g) com.google.android.exoplayer2.util.a.e(this.f22846c.g(oVar.f52867b));
            com.google.android.exoplayer2.util.a.g(gVar.g(oVar.f52868c, oVar.f52869d));
            long a10 = i.a(gVar.c());
            if (a10 != -1) {
                if (oVar.f52868c + oVar.f52869d > a10) {
                    z10 = false;
                }
                com.google.android.exoplayer2.util.a.g(z10);
            }
            if (this.f22847d != null) {
                try {
                    this.f22847d.h(file.getName(), oVar.f52869d, oVar.f52872g);
                } catch (IOException e2) {
                    throw new Cache.CacheException(e2);
                }
            }
            l(oVar);
            try {
                this.f22846c.s();
                notifyAll();
            } catch (IOException e10) {
                throw new Cache.CacheException(e10);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void i(String str, k kVar) throws Cache.CacheException {
        com.google.android.exoplayer2.util.a.g(!this.f22853j);
        m();
        this.f22846c.e(str, kVar);
        try {
            this.f22846c.s();
        } catch (IOException e2) {
            throw new Cache.CacheException(e2);
        }
    }

    public final void l(o oVar) {
        this.f22846c.m(oVar.f52867b).a(oVar);
        this.f22852i += oVar.f52869d;
        u(oVar);
    }

    public synchronized void m() throws Cache.CacheException {
        Cache.CacheException cacheException = this.f22854k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    public final o p(String str, long j10, long j11) {
        o d10;
        g g3 = this.f22846c.g(str);
        if (g3 == null) {
            return o.i(str, j10, j11);
        }
        while (true) {
            d10 = g3.d(j10, j11);
            if (!d10.f52870e || d10.f52871f.length() == d10.f52869d) {
                break;
            }
            A();
        }
        return d10;
    }

    public final void q() {
        if (!this.f22844a.exists()) {
            try {
                n(this.f22844a);
            } catch (Cache.CacheException e2) {
                this.f22854k = e2;
                return;
            }
        }
        File[] listFiles = this.f22844a.listFiles();
        if (listFiles == null) {
            String valueOf = String.valueOf(this.f22844a);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 38);
            sb2.append("Failed to list cache directory files: ");
            sb2.append(valueOf);
            String sb3 = sb2.toString();
            m.c("SimpleCache", sb3);
            this.f22854k = new Cache.CacheException(sb3);
            return;
        }
        long s2 = s(listFiles);
        this.f22851h = s2;
        if (s2 == -1) {
            try {
                this.f22851h = o(this.f22844a);
            } catch (IOException e10) {
                String valueOf2 = String.valueOf(this.f22844a);
                StringBuilder sb4 = new StringBuilder(valueOf2.length() + 28);
                sb4.append("Failed to create cache UID: ");
                sb4.append(valueOf2);
                String sb5 = sb4.toString();
                m.d("SimpleCache", sb5, e10);
                this.f22854k = new Cache.CacheException(sb5, e10);
                return;
            }
        }
        try {
            this.f22846c.n(this.f22851h);
            p6.b bVar = this.f22847d;
            if (bVar != null) {
                bVar.e(this.f22851h);
                Map<String, p6.a> b4 = this.f22847d.b();
                r(this.f22844a, true, listFiles, b4);
                this.f22847d.g(b4.h());
            } else {
                r(this.f22844a, true, listFiles, null);
            }
            this.f22846c.r();
            try {
                this.f22846c.s();
            } catch (IOException e11) {
                m.d("SimpleCache", "Storing index file failed", e11);
            }
        } catch (IOException e12) {
            String valueOf3 = String.valueOf(this.f22844a);
            StringBuilder sb6 = new StringBuilder(valueOf3.length() + 36);
            sb6.append("Failed to initialize cache indices: ");
            sb6.append(valueOf3);
            String sb7 = sb6.toString();
            m.d("SimpleCache", sb7, e12);
            this.f22854k = new Cache.CacheException(sb7, e12);
        }
    }

    public final void r(File file, boolean z10, @Nullable File[] fileArr, @Nullable Map<String, p6.a> map) {
        if (fileArr == null || fileArr.length == 0) {
            if (z10) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z10 && name.indexOf(46) == -1) {
                r(file2, false, file2.listFiles(), map);
            } else if (!z10 || (!h.o(name) && !name.endsWith(".uid"))) {
                long j10 = -1;
                long j11 = -9223372036854775807L;
                p6.a remove = map != null ? map.remove(name) : null;
                if (remove != null) {
                    j10 = remove.f52860a;
                    j11 = remove.f52861b;
                }
                o g3 = o.g(file2, j10, j11, this.f22846c);
                if (g3 != null) {
                    l(g3);
                } else {
                    file2.delete();
                }
            }
        }
    }

    public final void u(o oVar) {
        ArrayList<Cache.a> arrayList = this.f22848e.get(oVar.f52867b);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).b(this, oVar);
            }
        }
        this.f22845b.b(this, oVar);
    }

    public final void v(f fVar) {
        ArrayList<Cache.a> arrayList = this.f22848e.get(fVar.f52867b);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).d(this, fVar);
            }
        }
        this.f22845b.d(this, fVar);
    }

    public final void w(o oVar, f fVar) {
        ArrayList<Cache.a> arrayList = this.f22848e.get(oVar.f52867b);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).e(this, oVar, fVar);
            }
        }
        this.f22845b.e(this, oVar, fVar);
    }

    public synchronized void y() {
        if (this.f22853j) {
            return;
        }
        this.f22848e.clear();
        A();
        try {
            try {
                this.f22846c.s();
                C(this.f22844a);
            } catch (Throwable th) {
                C(this.f22844a);
                this.f22853j = true;
                throw th;
            }
        } catch (IOException e2) {
            m.d("SimpleCache", "Storing index file failed", e2);
            C(this.f22844a);
        }
        this.f22853j = true;
    }

    public final void z(f fVar) {
        g g3 = this.f22846c.g(fVar.f52867b);
        if (g3 == null || !g3.j(fVar)) {
            return;
        }
        this.f22852i -= fVar.f52869d;
        if (this.f22847d != null) {
            String name = fVar.f52871f.getName();
            try {
                this.f22847d.f(name);
            } catch (IOException unused) {
                String valueOf = String.valueOf(name);
                m.h("SimpleCache", valueOf.length() != 0 ? "Failed to remove file index entry for: ".concat(valueOf) : new String("Failed to remove file index entry for: "));
            }
        }
        this.f22846c.p(g3.f52874b);
        v(fVar);
    }

    public c(File file, b bVar, @Nullable y4.a aVar, @Nullable byte[] bArr, boolean z10, boolean z11) {
        this(file, bVar, new h(aVar, file, bArr, z10, z11), (aVar == null || z11) ? null : new p6.b(aVar));
    }

    public c(File file, b bVar, h hVar, @Nullable p6.b bVar2) {
        if (t(file)) {
            this.f22844a = file;
            this.f22845b = bVar;
            this.f22846c = hVar;
            this.f22847d = bVar2;
            this.f22848e = new HashMap<>();
            this.f22849f = new Random();
            this.f22850g = bVar.a();
            this.f22851h = -1L;
            ConditionVariable conditionVariable = new ConditionVariable();
            new a("ExoPlayer:SimpleCacheInit", conditionVariable).start();
            conditionVariable.block();
            return;
        }
        String valueOf = String.valueOf(file);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 46);
        sb2.append("Another SimpleCache instance uses the folder: ");
        sb2.append(valueOf);
        throw new IllegalStateException(sb2.toString());
    }
}
