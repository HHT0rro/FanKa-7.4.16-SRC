package com.alibaba.security.realidentity.build;

import android.content.Context;
import com.alibaba.security.common.track.model.TrackConstants;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.build.l;
import com.alibaba.security.realidentity.build.t;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.business.submit.SubmitHttpParams;
import com.alibaba.security.realidentity.http.IHttpInvoker;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;

/* compiled from: SubmitBusinessWorker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ac extends t {

    /* renamed from: d, reason: collision with root package name */
    public BiometricsBucketParams f3016d;

    /* renamed from: e, reason: collision with root package name */
    public SubmitHttpParams f3017e;

    /* compiled from: SubmitBusinessWorker.java */
    /* renamed from: com.alibaba.security.realidentity.build.ac$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass1 extends w {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t.a f3018a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HttpBucketParams httpBucketParams, t.a aVar) {
            super(httpBucketParams);
            this.f3018a = aVar;
        }

        @Override // com.alibaba.security.realidentity.build.w
        public final void a(HttpBucketParams httpBucketParams) {
            ac.this.f3017e = (SubmitHttpParams) httpBucketParams;
            t.a aVar = this.f3018a;
            if (aVar != null) {
                aVar.a(httpBucketParams, !r0.f3016d.isNeedBioResultPage);
            }
        }

        @Override // com.alibaba.security.realidentity.build.w
        public final void b(HttpBucketParams httpBucketParams) {
            SubmitHttpParams submitHttpParams = (SubmitHttpParams) httpBucketParams;
            ac.this.f3017e = submitHttpParams;
            t.a aVar = this.f3018a;
            if (aVar != null) {
                aVar.b(submitHttpParams, !r0.f3016d.isNeedBioResultPage);
            }
        }

        @Override // com.alibaba.security.realidentity.build.w, com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
        public final void onNetError(Exception exc) {
            t.a aVar = this.f3018a;
            if (aVar != null) {
                aVar.a(ac.this.f3017e, exc, !r1.f3016d.isNeedBioResultPage);
            }
        }
    }

    public ac(Context context) {
        super(context);
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void a(r rVar) {
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void a(r rVar, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void b(r rVar, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String c() {
        SubmitHttpParams submitHttpParams = this.f3017e;
        return submitHttpParams == null ? "" : JsonUtils.toJSON(submitHttpParams.getmHttpResponse());
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String d() {
        return "identity";
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String e() {
        return TrackConstants.Method.SUBMIT_RESULT_API_BEGIN;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String f() {
        return TrackConstants.Method.SUBMIT_RESULT_API_END;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void g() {
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final BusinessType h() {
        return BusinessType.SUBMIT;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String b() {
        SubmitHttpParams submitHttpParams = this.f3017e;
        return submitHttpParams == null ? "" : JsonUtils.toJSON(submitHttpParams.getRpcRequest().httpRequest.httpRequest);
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void a(r rVar, t.a aVar) {
        this.f3016d = rVar.f3970d;
        a();
        if (this.f3016d.isCalledFinishSuccessfully()) {
            if (this.f3017e == null) {
                this.f3017e = rVar.f3973g;
            }
            aVar.a(this.f3017e, !this.f3016d.isNeedBioResultPage);
            return;
        }
        SubmitHttpParams submitHttpParams = rVar.f3973g;
        this.f3017e = submitHttpParams;
        BusinessHttpWrapper rpcRequest = submitHttpParams.getRpcRequest();
        IHttpInvoker e2 = l.a.f3948a.e();
        if (e2 != null) {
            e2.submit(rpcRequest, new AnonymousClass1(this.f3017e, aVar));
        }
    }

    private void a(BusinessHttpWrapper businessHttpWrapper, t.a aVar) {
        IHttpInvoker e2 = l.a.f3948a.e();
        if (e2 != null) {
            e2.submit(businessHttpWrapper, new AnonymousClass1(this.f3017e, aVar));
        }
    }
}
