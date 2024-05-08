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
import com.alibaba.security.realidentity.business.upload.UploadResultParams;
import com.alibaba.security.realidentity.http.IHttpInvoker;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;

/* compiled from: UploadResultWorker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ai extends t {

    /* renamed from: d, reason: collision with root package name */
    public BiometricsBucketParams f3053d;

    /* renamed from: e, reason: collision with root package name */
    public UploadResultParams f3054e;

    /* compiled from: UploadResultWorker.java */
    /* renamed from: com.alibaba.security.realidentity.build.ai$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass1 extends w {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t.a f3055a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HttpBucketParams httpBucketParams, t.a aVar) {
            super(httpBucketParams);
            this.f3055a = aVar;
        }

        @Override // com.alibaba.security.realidentity.build.w
        public final void a(HttpBucketParams httpBucketParams) {
            ai.this.f3054e = (UploadResultParams) httpBucketParams;
            t.a aVar = this.f3055a;
            if (aVar != null) {
                aVar.a(httpBucketParams, !r0.f3053d.isNeedBioResultPage);
            }
        }

        @Override // com.alibaba.security.realidentity.build.w
        public final void b(HttpBucketParams httpBucketParams) {
            UploadResultParams uploadResultParams = (UploadResultParams) httpBucketParams;
            ai.this.f3054e = uploadResultParams;
            t.a aVar = this.f3055a;
            if (aVar != null) {
                aVar.b(uploadResultParams, !r0.f3053d.isNeedBioResultPage);
            }
        }

        @Override // com.alibaba.security.realidentity.build.w, com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
        public final void onNetError(Exception exc) {
            t.a aVar = this.f3055a;
            if (aVar != null) {
                aVar.a(ai.this.f3054e, exc, !r1.f3053d.isNeedBioResultPage);
            }
        }
    }

    public ai(Context context) {
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
        UploadResultParams uploadResultParams = this.f3054e;
        return uploadResultParams == null ? "" : JsonUtils.toJSON(uploadResultParams.getmHttpResponse());
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String d() {
        return "identity";
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String e() {
        return TrackConstants.Method.UPLOAD_RESULT_API_BEGIN;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String f() {
        return TrackConstants.Method.UPLOAD_RESULT_API_END;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void g() {
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final BusinessType h() {
        return BusinessType.UPLOADRESULT;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String b() {
        UploadResultParams uploadResultParams = this.f3054e;
        return uploadResultParams == null ? "" : JsonUtils.toJSON(uploadResultParams.getRpcRequest().httpRequest.httpRequest);
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void a(r rVar, t.a aVar) {
        this.f3053d = rVar.f3970d;
        this.f3054e = rVar.f3972f;
        a();
        if (this.f3053d.isCalledFinishSuccessfully()) {
            aVar.a(this.f3054e, !this.f3053d.isNeedBioResultPage);
            return;
        }
        BusinessHttpWrapper rpcRequest = this.f3054e.getRpcRequest();
        IHttpInvoker e2 = l.a.f3948a.e();
        if (e2 != null) {
            e2.upload(rpcRequest, new AnonymousClass1(this.f3054e, aVar));
        }
    }

    private void a(BusinessHttpWrapper businessHttpWrapper, t.a aVar) {
        IHttpInvoker e2 = l.a.f3948a.e();
        if (e2 != null) {
            e2.upload(businessHttpWrapper, new AnonymousClass1(this.f3054e, aVar));
        }
    }
}
