package com.alibaba.security.realidentity.build;

import android.content.Context;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.bucket.BucketParams;

/* compiled from: AbsBusinessWorker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3978a = "BusinessWorker";

    /* renamed from: b, reason: collision with root package name */
    public Context f3979b;

    /* renamed from: c, reason: collision with root package name */
    public String f3980c;

    /* renamed from: d, reason: collision with root package name */
    private long f3981d;

    /* compiled from: AbsBusinessWorker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a(BucketParams bucketParams, Exception exc, boolean z10);

        void a(BucketParams bucketParams, boolean z10);

        void b(BucketParams bucketParams, boolean z10);
    }

    public t(Context context) {
        this.f3979b = context;
    }

    private void a(String str) {
        this.f3980c = str;
    }

    private String j() {
        return this.f3980c;
    }

    public abstract void a(r rVar);

    public abstract void a(r rVar, a aVar);

    public abstract void a(r rVar, BucketParams bucketParams);

    public abstract String b();

    public abstract void b(r rVar, BucketParams bucketParams);

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract void g();

    public abstract BusinessType h();

    public boolean i() {
        return true;
    }

    public final void a(r rVar, final u uVar) {
        this.f3981d = System.currentTimeMillis();
        a(rVar, new a() { // from class: com.alibaba.security.realidentity.build.t.1
            @Override // com.alibaba.security.realidentity.build.t.a
            public final void a(BucketParams bucketParams, boolean z10) {
                if (bucketParams != null) {
                    bucketParams.setCurrentErrorCode(bucketParams.parseErrorCode());
                }
                t.a(t.this, true);
                t.this.g();
                u uVar2 = uVar;
                if (uVar2 != null) {
                    t.this.h();
                    uVar2.a(bucketParams, z10);
                }
            }

            @Override // com.alibaba.security.realidentity.build.t.a
            public final void b(BucketParams bucketParams, boolean z10) {
                if (bucketParams != null) {
                    bucketParams.setCurrentErrorCode(bucketParams.parseErrorCode());
                }
                t.a(t.this, false);
                t.this.g();
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.a(t.this.h(), bucketParams, z10);
                }
            }

            @Override // com.alibaba.security.realidentity.build.t.a
            public final void a(BucketParams bucketParams, Exception exc, boolean z10) {
                BucketParams.ErrorCode createAuditNotCode = BucketParams.ErrorCode.createAuditNotCode();
                createAuditNotCode.errorMsg = CommonUtils.getExceptionMsg(exc);
                createAuditNotCode.globalErrorCode = GlobalErrorCode.ERROR_ONLINE_NET_ERROR;
                createAuditNotCode.errorCode = String.valueOf(GlobalErrorCode.ERROR_ONLINE_NET_ERROR);
                bucketParams.setCurrentErrorCode(createAuditNotCode);
                t.a(t.this, exc);
                t.this.g();
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.a(t.this.h(), bucketParams, CommonUtils.getExceptionMsg(exc), z10);
                }
            }
        });
    }

    public final void a() {
        if (i()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setLayer("sdk");
            trackLog.setService(d());
            trackLog.setMethod(e());
            trackLog.setParams(b());
            trackLog.setMsg("");
            trackLog.setResult("");
            a(trackLog);
        }
    }

    private void a(Exception exc) {
        if (i()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setRt(System.currentTimeMillis() - this.f3981d);
            trackLog.setLayer("sdk");
            trackLog.setService(d());
            trackLog.setMethod(f());
            trackLog.setParams(b());
            trackLog.setMsg("");
            trackLog.setResult("onNetError: " + CommonUtils.getExceptionMsg(exc));
            trackLog.setCode(-1);
            a(trackLog);
        }
    }

    private void a(boolean z10) {
        if (i()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setRt(System.currentTimeMillis() - this.f3981d);
            trackLog.setLayer("sdk");
            trackLog.setService(d());
            trackLog.setMethod(f());
            trackLog.setParams(b());
            trackLog.setMsg("");
            trackLog.setResult(c());
            trackLog.setCode(z10 ? 0 : -2);
            a(trackLog);
        }
    }

    public final void a(TrackLog trackLog) {
        j unused = j.a.f3944a;
        j.a(this.f3980c, trackLog);
    }

    public static /* synthetic */ void a(t tVar, boolean z10) {
        if (tVar.i()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setRt(System.currentTimeMillis() - tVar.f3981d);
            trackLog.setLayer("sdk");
            trackLog.setService(tVar.d());
            trackLog.setMethod(tVar.f());
            trackLog.setParams(tVar.b());
            trackLog.setMsg("");
            trackLog.setResult(tVar.c());
            trackLog.setCode(z10 ? 0 : -2);
            tVar.a(trackLog);
        }
    }

    public static /* synthetic */ void a(t tVar, Exception exc) {
        if (tVar.i()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setRt(System.currentTimeMillis() - tVar.f3981d);
            trackLog.setLayer("sdk");
            trackLog.setService(tVar.d());
            trackLog.setMethod(tVar.f());
            trackLog.setParams(tVar.b());
            trackLog.setMsg("");
            trackLog.setResult("onNetError: " + CommonUtils.getExceptionMsg(exc));
            trackLog.setCode(-1);
            tVar.a(trackLog);
        }
    }
}
