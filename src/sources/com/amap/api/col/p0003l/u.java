package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fr;
import com.amap.api.col.p0003l.hy;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;

/* compiled from: AuthTaskDownload.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class u implements hy.a {

    /* renamed from: a, reason: collision with root package name */
    public a f6931a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f6932b;

    /* renamed from: c, reason: collision with root package name */
    private RandomAccessFile f6933c;

    /* renamed from: d, reason: collision with root package name */
    private Cif f6934d;

    /* renamed from: e, reason: collision with root package name */
    private String f6935e;

    /* compiled from: AuthTaskDownload.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f6936a;

        /* renamed from: b, reason: collision with root package name */
        public String f6937b;

        /* renamed from: c, reason: collision with root package name */
        public String f6938c;

        /* renamed from: d, reason: collision with root package name */
        public String f6939d;

        /* renamed from: e, reason: collision with root package name */
        public String f6940e;

        /* renamed from: f, reason: collision with root package name */
        public c f6941f;

        public a(String str, String str2, String str3, String str4) {
            this.f6936a = str;
            this.f6937b = str2;
            this.f6938c = str3;
            this.f6939d = str4 + ".tmp";
            this.f6940e = str4;
        }

        public final String a() {
            return this.f6936a;
        }

        public final String b() {
            return this.f6937b;
        }

        public final String c() {
            return this.f6939d;
        }

        public final String d() {
            return this.f6940e;
        }

        public final c e() {
            return this.f6941f;
        }

        public final void a(c cVar) {
            this.f6941f = cVar;
        }
    }

    /* compiled from: AuthTaskDownload.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b extends db {

        /* renamed from: a, reason: collision with root package name */
        private final a f6942a;

        public b(a aVar) {
            this.f6942a = aVar;
        }

        @Override // com.amap.api.col.p0003l.id
        public final String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.id
        public final Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.id
        public final Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.id
        public final String getURL() {
            a aVar = this.f6942a;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        }

        @Override // com.amap.api.col.p0003l.id
        public final boolean isSupportIPV6() {
            return false;
        }
    }

    /* compiled from: AuthTaskDownload.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f6943a;

        /* renamed from: b, reason: collision with root package name */
        public String f6944b;

        public c(String str, String str2) {
            this.f6943a = str;
            this.f6944b = str2;
        }

        public final String a() {
            return this.f6943a;
        }

        public final String b() {
            return this.f6944b;
        }

        public final boolean c() {
            return (TextUtils.isEmpty(this.f6943a) || TextUtils.isEmpty(this.f6944b)) ? false : true;
        }
    }

    /* compiled from: AuthTaskDownload.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class d extends a {
        public d(String str, String str2, String str3, String str4) {
            super(str, str2, str3, str4);
        }

        public final void a(String str, String str2) {
            a(new c(str, str2));
        }
    }

    public u(Context context, a aVar) {
        this.f6932b = context.getApplicationContext();
        this.f6931a = aVar;
        this.f6934d = new Cif(new b(aVar));
        this.f6935e = aVar.c();
    }

    private boolean b() {
        c e2 = this.f6931a.e();
        return (e2 != null && e2.c() && dn.a(this.f6932b, e2.a(), e2.b(), "").equalsIgnoreCase(this.f6931a.b())) ? false : true;
    }

    public final void a() {
        Cif cif;
        if (ab.f4885a == null || fr.a(ab.f4885a, dx.a()).f5947a == fr.c.SuccessCode) {
            try {
                if (!b() || (cif = this.f6934d) == null) {
                    return;
                }
                cif.a(this);
            } catch (Throwable th) {
                gy.b(th, "AuthTaskDownload", "startDownload()");
            }
        }
    }

    @Override // com.amap.api.col.3l.hy.a
    public final void onDownload(byte[] bArr, long j10) {
        try {
            if (this.f6933c == null) {
                File file = new File(this.f6935e);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.f6933c = new RandomAccessFile(file, "rw");
            }
            this.f6933c.seek(j10);
            this.f6933c.write(bArr);
        } catch (Throwable th) {
            gy.b(th, "AuthTaskDownload", "onDownload()");
        }
    }

    @Override // com.amap.api.col.3l.hy.a
    public final void onException(Throwable th) {
        try {
            RandomAccessFile randomAccessFile = this.f6933c;
            if (randomAccessFile == null) {
                return;
            }
            randomAccessFile.close();
        } catch (Throwable th2) {
            gy.b(th2, "AuthTaskDownload", "onException()");
        }
    }

    @Override // com.amap.api.col.3l.hy.a
    public final void onFinish() {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = this.f6933c;
        } catch (Throwable th) {
            gy.b(th, "AuthTaskDownload", "onFinish()");
        }
        if (randomAccessFile == null) {
            return;
        }
        try {
            randomAccessFile.close();
        } catch (Throwable th2) {
            gy.b(th2, "AuthTaskDownload", "onFinish3");
        }
        String b4 = this.f6931a.b();
        String a10 = fq.a(this.f6935e);
        if (a10 != null && b4.equalsIgnoreCase(a10)) {
            String d10 = this.f6931a.d();
            try {
                bp bpVar = new bp();
                File file = new File(this.f6935e);
                bpVar.a(file, new File(d10), -1L, bv.a(file), null);
                c e2 = this.f6931a.e();
                if (e2 != null && e2.c()) {
                    dn.a(this.f6932b, e2.a(), e2.b(), (Object) a10);
                }
                new File(this.f6935e).delete();
                return;
            } catch (Throwable th3) {
                gy.b(th3, "AuthTaskDownload", "onFinish1");
                return;
            }
        }
        try {
            new File(this.f6935e).delete();
            return;
        } catch (Throwable th4) {
            gy.b(th4, "AuthTaskDownload", "onFinish");
            return;
        }
        gy.b(th, "AuthTaskDownload", "onFinish()");
    }

    @Override // com.amap.api.col.3l.hy.a
    public final void onStop() {
    }
}
