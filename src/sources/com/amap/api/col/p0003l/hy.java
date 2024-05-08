package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.id;

/* compiled from: DownloadManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class hy {

    /* renamed from: a, reason: collision with root package name */
    private ia f6318a;

    /* renamed from: b, reason: collision with root package name */
    private id f6319b;

    /* renamed from: c, reason: collision with root package name */
    private long f6320c;

    /* renamed from: d, reason: collision with root package name */
    private long f6321d;

    /* compiled from: DownloadManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void onDownload(byte[] bArr, long j10);

        void onException(Throwable th);

        void onFinish();

        void onStop();
    }

    public hy(id idVar) {
        this(idVar, (byte) 0);
    }

    public final void a(a aVar) {
        try {
            ia iaVar = new ia();
            this.f6318a = iaVar;
            iaVar.b(this.f6321d);
            this.f6318a.a(this.f6320c);
            hw.a();
            if (hw.b(this.f6319b)) {
                this.f6319b.setDegradeType(id.b.NEVER_GRADE);
                this.f6318a.a(this.f6319b, aVar);
            } else {
                this.f6319b.setDegradeType(id.b.DEGRADE_ONLY);
                this.f6318a.a(this.f6319b, aVar);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private hy(id idVar, byte b4) {
        this(idVar, 0L, -1L, false);
    }

    public hy(id idVar, long j10, long j11, boolean z10) {
        this.f6319b = idVar;
        this.f6320c = j10;
        this.f6321d = j11;
        idVar.setHttpProtocol(z10 ? id.c.HTTPS : id.c.HTTP);
        this.f6319b.setDegradeAbility(id.a.SINGLE);
    }

    public final void a() {
        ia iaVar = this.f6318a;
        if (iaVar != null) {
            iaVar.a();
        }
    }
}
