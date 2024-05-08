package com.alibaba.security.realidentity.build;

import android.content.Context;
import com.alibaba.security.biometrics.service.model.result.SensorInfo;
import com.alibaba.security.biometrics.service.sensor.SensorGetter;
import com.alibaba.security.common.track.model.TrackConstants;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.build.l;
import com.alibaba.security.realidentity.build.t;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.http.IHttpInvoker;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;

/* compiled from: StartBusinessWorker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ab extends t {

    /* renamed from: d, reason: collision with root package name */
    public StartHttpParams f3011d;

    /* compiled from: StartBusinessWorker.java */
    /* renamed from: com.alibaba.security.realidentity.build.ab$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass2 extends w {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t.a f3014a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(HttpBucketParams httpBucketParams, t.a aVar) {
            super(httpBucketParams);
            this.f3014a = aVar;
        }

        @Override // com.alibaba.security.realidentity.build.w
        public final void a(HttpBucketParams httpBucketParams) {
            StartHttpParams startHttpParams = (StartHttpParams) httpBucketParams;
            ab.this.f3011d = startHttpParams;
            t.a aVar = this.f3014a;
            if (aVar != null) {
                aVar.a(startHttpParams, true);
            }
        }

        @Override // com.alibaba.security.realidentity.build.w
        public final void b(HttpBucketParams httpBucketParams) {
            StartHttpParams startHttpParams = (StartHttpParams) httpBucketParams;
            ab.this.f3011d = startHttpParams;
            t.a aVar = this.f3014a;
            if (aVar != null) {
                aVar.b(startHttpParams, true);
            }
        }

        @Override // com.alibaba.security.realidentity.build.w, com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
        public final void onNetError(Exception exc) {
            t.a aVar = this.f3014a;
            if (aVar != null) {
                aVar.a(ab.this.f3011d, exc, true);
            }
        }
    }

    public ab(Context context) {
        super(context);
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void a(r rVar) {
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void a(r rVar, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String b() {
        StartHttpParams startHttpParams = this.f3011d;
        return startHttpParams == null ? "" : JsonUtils.toJSON(startHttpParams.getRpcRequest().httpRequest.httpRequest);
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void b(r rVar, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String c() {
        StartHttpParams startHttpParams = this.f3011d;
        return startHttpParams == null ? "" : JsonUtils.toJSON(startHttpParams.getmHttpResponse());
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String d() {
        return "identity";
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String e() {
        return TrackConstants.Method.START_API_BEGIN;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String f() {
        return TrackConstants.Method.START_API_END;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void g() {
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final BusinessType h() {
        return BusinessType.START;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void a(r rVar, final t.a aVar) {
        if (rVar == null) {
            return;
        }
        this.f3011d = rVar.f3969c;
        SensorGetter.getDefault().collectLightSensorInfo(new SensorGetter.SensorCallback() { // from class: com.alibaba.security.realidentity.build.ab.1
            @Override // com.alibaba.security.biometrics.service.sensor.SensorGetter.SensorCallback
            public final void onGetSensorValue(float f10) {
                ab.this.f3011d.setSensorInfo(new SensorInfo(f10));
                ab.this.a();
                ab abVar = ab.this;
                ab.a(abVar, abVar.f3011d.getRpcRequest(), aVar);
            }
        });
    }

    private void a(BusinessHttpWrapper businessHttpWrapper, t.a aVar) {
        IHttpInvoker e2 = l.a.f3948a.e();
        if (e2 != null) {
            e2.start(businessHttpWrapper, new AnonymousClass2(this.f3011d, aVar));
        }
    }

    public static /* synthetic */ void a(ab abVar, BusinessHttpWrapper businessHttpWrapper, t.a aVar) {
        IHttpInvoker e2 = l.a.f3948a.e();
        if (e2 != null) {
            e2.start(businessHttpWrapper, new AnonymousClass2(abVar.f3011d, aVar));
        }
    }
}
