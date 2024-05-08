package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.col.p0003l.bs;
import com.amap.api.col.p0003l.by;
import java.io.IOException;

/* compiled from: OfflineMapDownloadTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bd extends je implements bs.a {

    /* renamed from: a, reason: collision with root package name */
    private bs f5111a;

    /* renamed from: b, reason: collision with root package name */
    private bu f5112b;

    /* renamed from: c, reason: collision with root package name */
    private bx f5113c;

    /* renamed from: d, reason: collision with root package name */
    private Context f5114d;

    /* renamed from: e, reason: collision with root package name */
    private Bundle f5115e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5116g;

    private bd(bx bxVar, Context context) {
        this.f5115e = new Bundle();
        this.f5116g = false;
        this.f5113c = bxVar;
        this.f5114d = context;
    }

    private String d() {
        return dx.c(this.f5114d);
    }

    private void e() throws IOException {
        bs bsVar = new bs(new bt(this.f5113c.getUrl(), d(), this.f5113c.v(), this.f5113c.w()), this.f5113c.getUrl(), this.f5114d, this.f5113c);
        this.f5111a = bsVar;
        bsVar.a(this);
        bx bxVar = this.f5113c;
        this.f5112b = new bu(bxVar, bxVar);
        if (this.f5116g) {
            return;
        }
        this.f5111a.a();
    }

    public final void a() {
        this.f5116g = true;
        bs bsVar = this.f5111a;
        if (bsVar != null) {
            bsVar.b();
        } else {
            cancelTask();
        }
        bu buVar = this.f5112b;
        if (buVar != null) {
            buVar.a();
        }
    }

    public final void b() {
        Bundle bundle = this.f5115e;
        if (bundle != null) {
            bundle.clear();
            this.f5115e = null;
        }
    }

    @Override // com.amap.api.col.3l.bs.a
    public final void c() {
        bu buVar = this.f5112b;
        if (buVar != null) {
            buVar.b();
        }
    }

    @Override // com.amap.api.col.p0003l.je
    public final void runTask() {
        if (this.f5113c.u()) {
            this.f5113c.a(by.a.file_io_exception);
            return;
        }
        try {
            e();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public bd(bx bxVar, Context context, byte b4) {
        this(bxVar, context);
    }
}
