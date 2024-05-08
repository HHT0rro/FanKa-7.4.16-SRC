package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.by;
import com.amap.api.col.p0003l.fr;
import com.amap.api.col.p0003l.hy;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* compiled from: NetFileFetch.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bs implements hy.a {

    /* renamed from: a, reason: collision with root package name */
    public bt f5150a;

    /* renamed from: d, reason: collision with root package name */
    public long f5153d;

    /* renamed from: f, reason: collision with root package name */
    public bn f5155f;

    /* renamed from: h, reason: collision with root package name */
    public a f5157h;

    /* renamed from: i, reason: collision with root package name */
    private Context f5158i;

    /* renamed from: j, reason: collision with root package name */
    private by f5159j;

    /* renamed from: k, reason: collision with root package name */
    private String f5160k;

    /* renamed from: l, reason: collision with root package name */
    private Cif f5161l;

    /* renamed from: m, reason: collision with root package name */
    private bo f5162m;

    /* renamed from: b, reason: collision with root package name */
    public long f5151b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f5152c = 0;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5154e = true;

    /* renamed from: g, reason: collision with root package name */
    public long f5156g = 0;

    /* renamed from: n, reason: collision with root package name */
    private boolean f5163n = false;

    /* compiled from: NetFileFetch.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void c();
    }

    /* compiled from: NetFileFetch.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b extends db {

        /* renamed from: a, reason: collision with root package name */
        private final String f5164a;

        public b(String str) {
            this.f5164a = str;
        }

        @Override // com.amap.api.col.p0003l.id
        public final String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.col.p0003l.id
        public final Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.id
        public final String getURL() {
            return this.f5164a;
        }

        @Override // com.amap.api.col.p0003l.id
        public final boolean isSupportIPV6() {
            return false;
        }
    }

    public bs(bt btVar, String str, Context context, by byVar) throws IOException {
        this.f5150a = null;
        this.f5155f = bn.a(context.getApplicationContext());
        this.f5150a = btVar;
        this.f5158i = context;
        this.f5160k = str;
        this.f5159j = byVar;
        d();
    }

    private void c() throws IOException {
        bz bzVar = new bz(this.f5160k);
        bzVar.setConnectionTimeout(30000);
        bzVar.setSoTimeout(30000);
        this.f5161l = new Cif(bzVar, this.f5151b, this.f5152c, MapsInitializer.getProtocol() == 2);
        this.f5162m = new bo(this.f5150a.b() + File.separator + this.f5150a.c(), this.f5151b);
    }

    private void d() {
        File file = new File(this.f5150a.b() + this.f5150a.c());
        if (file.exists()) {
            this.f5154e = false;
            this.f5151b = file.length();
            try {
                long g3 = g();
                this.f5153d = g3;
                this.f5152c = g3;
                return;
            } catch (IOException unused) {
                by byVar = this.f5159j;
                if (byVar != null) {
                    byVar.a(by.a.file_io_exception);
                    return;
                }
                return;
            }
        }
        this.f5151b = 0L;
        this.f5152c = 0L;
    }

    private boolean e() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f5150a.b());
        sb2.append(File.separator);
        sb2.append(this.f5150a.c());
        return new File(sb2.toString()).length() >= 10;
    }

    private void f() throws AMapException {
        if (fk.f5771a != 1) {
            for (int i10 = 0; i10 < 3; i10++) {
                try {
                    fk.a(this.f5158i, dx.a(), "", (Map<String, String>) null);
                } catch (Throwable th) {
                    gy.b(th, "SiteFileFetch", "authOffLineDownLoad");
                    th.printStackTrace();
                }
                if (fk.f5771a == 1) {
                    return;
                }
            }
        }
    }

    private long g() throws IOException {
        if (fr.a(this.f5158i, dx.a()).f5947a != fr.c.SuccessCode) {
            return -1L;
        }
        String a10 = this.f5150a.a();
        Map<String, String> map = null;
        try {
            ic.b();
            map = ic.d((id) new b(a10), MapsInitializer.getProtocol() == 2);
        } catch (fi e2) {
            e2.printStackTrace();
        }
        int i10 = -1;
        if (map != null) {
            for (String str : map.h()) {
                if ("Content-Length".equalsIgnoreCase(str)) {
                    i10 = Integer.parseInt(map.get(str));
                }
            }
        }
        return i10;
    }

    private void h() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f5150a == null || currentTimeMillis - this.f5156g <= 500) {
            return;
        }
        i();
        this.f5156g = currentTimeMillis;
        a(this.f5151b);
    }

    private void i() {
        this.f5155f.a(this.f5150a.e(), this.f5150a.d(), this.f5153d, this.f5151b, this.f5152c);
    }

    public final void a() {
        try {
            if (dx.d(this.f5158i)) {
                f();
                if (fk.f5771a != 1) {
                    by byVar = this.f5159j;
                    if (byVar != null) {
                        byVar.a(by.a.amap_exception);
                        return;
                    }
                    return;
                }
                if (!e()) {
                    this.f5154e = true;
                }
                if (this.f5154e) {
                    long g3 = g();
                    this.f5153d = g3;
                    if (g3 != -1 && g3 != -2) {
                        this.f5152c = g3;
                    }
                    this.f5151b = 0L;
                }
                by byVar2 = this.f5159j;
                if (byVar2 != null) {
                    byVar2.m();
                }
                if (this.f5151b >= this.f5152c) {
                    onFinish();
                    return;
                } else {
                    c();
                    this.f5161l.a(this);
                    return;
                }
            }
            by byVar3 = this.f5159j;
            if (byVar3 != null) {
                byVar3.a(by.a.network_exception);
            }
        } catch (AMapException e2) {
            gy.b(e2, "SiteFileFetch", "download");
            by byVar4 = this.f5159j;
            if (byVar4 != null) {
                byVar4.a(by.a.amap_exception);
            }
        } catch (IOException unused) {
            by byVar5 = this.f5159j;
            if (byVar5 != null) {
                byVar5.a(by.a.file_io_exception);
            }
        }
    }

    public final void b() {
        Cif cif = this.f5161l;
        if (cif != null) {
            cif.a();
        }
    }

    @Override // com.amap.api.col.3l.hy.a
    public final void onDownload(byte[] bArr, long j10) {
        try {
            this.f5162m.a(bArr);
            this.f5151b = j10;
            h();
        } catch (IOException e2) {
            e2.printStackTrace();
            gy.b(e2, "fileAccessI", "fileAccessI.write(byte[] data)");
            by byVar = this.f5159j;
            if (byVar != null) {
                byVar.a(by.a.file_io_exception);
            }
            Cif cif = this.f5161l;
            if (cif != null) {
                cif.a();
            }
        }
    }

    @Override // com.amap.api.col.3l.hy.a
    public final void onException(Throwable th) {
        bo boVar;
        this.f5163n = true;
        b();
        by byVar = this.f5159j;
        if (byVar != null) {
            byVar.a(by.a.network_exception);
        }
        if ((th instanceof IOException) || (boVar = this.f5162m) == null) {
            return;
        }
        boVar.a();
    }

    @Override // com.amap.api.col.3l.hy.a
    public final void onFinish() {
        h();
        by byVar = this.f5159j;
        if (byVar != null) {
            byVar.n();
        }
        bo boVar = this.f5162m;
        if (boVar != null) {
            boVar.a();
        }
        a aVar = this.f5157h;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.amap.api.col.3l.hy.a
    public final void onStop() {
        if (this.f5163n) {
            return;
        }
        by byVar = this.f5159j;
        if (byVar != null) {
            byVar.o();
        }
        i();
    }

    private void a(long j10) {
        by byVar;
        long j11 = this.f5153d;
        if (j11 <= 0 || (byVar = this.f5159j) == null) {
            return;
        }
        byVar.a(j11, j10);
        this.f5156g = System.currentTimeMillis();
    }

    public final void a(a aVar) {
        this.f5157h = aVar;
    }
}
