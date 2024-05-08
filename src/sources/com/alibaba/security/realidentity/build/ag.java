package com.alibaba.security.realidentity.build;

import android.content.Context;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.result.ABActionResult;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.track.model.CommonTrackResult;
import com.alibaba.security.common.track.model.TrackConstants;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.build.ad;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.build.t;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.business.upload.UploadFileParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: UploadFileWorker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ag extends t {

    /* renamed from: d, reason: collision with root package name */
    public BiometricsBucketParams f3046d;

    /* renamed from: e, reason: collision with root package name */
    public UploadFileParams f3047e;

    /* renamed from: f, reason: collision with root package name */
    private StartHttpParams f3048f;

    /* compiled from: UploadFileWorker.java */
    /* renamed from: com.alibaba.security.realidentity.build.ag$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass1 implements ad.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f3049a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f3050b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t.a f3051c;

        public AnonymousClass1(long j10, List list, t.a aVar) {
            this.f3049a = j10;
            this.f3050b = list;
            this.f3051c = aVar;
        }

        @Override // com.alibaba.security.realidentity.build.ad.a
        public final void a() {
            ag.this.a(TrackLog.createBioMonitorUploadFinishLog(new CommonTrackResult(), true, System.currentTimeMillis() - this.f3049a));
            ag.this.f3047e.setUploadTaskList(this.f3050b);
            ag.this.f3047e.setUploadErrorCode(0);
            t.a aVar = this.f3051c;
            if (aVar != null) {
                aVar.a(ag.this.f3047e, !r1.f3046d.isNeedBioResultPage);
            }
        }

        @Override // com.alibaba.security.realidentity.build.ad.a
        public final void b() {
            ag.this.a(TrackLog.createBioMonitorUploadFinishLog(new CommonTrackResult(-1, "uploadFile onError"), false, System.currentTimeMillis() - this.f3049a));
            this.f3050b.clear();
            ag.this.f3047e.setUploadErrorCode(GlobalErrorCode.ERROR_UPLOAD_BIO_PIC_ERROR);
            t.a aVar = this.f3051c;
            if (aVar != null) {
                aVar.b(ag.this.f3047e, !r1.f3046d.isNeedBioResultPage);
            }
        }
    }

    public ag(Context context) {
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
        return "";
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void b(r rVar, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String c() {
        return "";
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String d() {
        return "identity";
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String e() {
        return TrackConstants.Method.UPLOAD_API_BEGIN;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String f() {
        return TrackConstants.Method.UPLOAD_API_END;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void g() {
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final BusinessType h() {
        return BusinessType.UPLOADFILE;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final boolean i() {
        return false;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void a(r rVar, t.a aVar) {
        ABImageResult oi;
        ABImageResult aBImageResult;
        this.f3048f = rVar.f3969c;
        this.f3046d = rVar.f3970d;
        a(TrackLog.createBioMonitorUploadStartLog());
        if (this.f3046d.isCalledFinishSuccessfully()) {
            if (this.f3047e == null) {
                this.f3047e = rVar.f3971e;
            }
            aVar.a(this.f3047e, !this.f3046d.isNeedBioResultPage);
            return;
        }
        this.f3047e = rVar.f3971e;
        Context context = this.f3979b;
        ALBiometricsResult aLBiometricsResult = this.f3046d.biometricsResult;
        ABImageResult qi = aLBiometricsResult.getQi();
        ArrayList<ah> arrayList = new ArrayList();
        j unused = j.a.f3944a;
        if (qi != null) {
            arrayList.add(a(c.f3227o, c.f3227o, this.f3048f.mUploadToken.path, qi.getBf()));
        }
        if (this.f3048f.mNeedActionImage) {
            for (int i10 = 0; i10 < aLBiometricsResult.getAs().size(); i10++) {
                ABActionResult aBActionResult = aLBiometricsResult.getAs().get(i10);
                if (aBActionResult != null && aBActionResult.getIs().size() > 0 && (aBImageResult = aBActionResult.getIs().get(aBActionResult.getIs().size() - 1)) != null) {
                    String concat = "action".concat(String.valueOf(i10));
                    String concat2 = "action".concat(String.valueOf(i10));
                    String str = this.f3048f.mUploadToken.path;
                    byte[] bf = aBImageResult.getBf();
                    c.f3231s.concat(String.valueOf(i10));
                    arrayList.add(a(concat, concat2, str, bf));
                }
            }
        }
        if (this.f3048f.mNeedOriginalImage && (oi = aLBiometricsResult.getOi()) != null) {
            arrayList.add(a(c.f3230r, c.f3230r, this.f3048f.mUploadToken.path, oi.getBf()));
        }
        ABImageResult gi = aLBiometricsResult.getGi();
        if (gi != null) {
            arrayList.add(a(c.f3229q, c.f3229q, this.f3048f.mUploadToken.path, gi.getBf()));
        }
        ABImageResult li = aLBiometricsResult.getLi();
        if (li != null) {
            arrayList.add(a(c.f3228p, c.f3228p, this.f3048f.mUploadToken.path, li.getBf()));
        }
        if (aLBiometricsResult.getDazzleVideoPath() != null) {
            arrayList.add(new ae(context, aLBiometricsResult.getDazzleVideoPath(), "10", aLBiometricsResult));
        }
        AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[arrayList.size()]);
        long currentTimeMillis = System.currentTimeMillis();
        int i11 = 0;
        for (ah ahVar : arrayList) {
            ahVar.f3023c = atomicInteger;
            ahVar.f3024d = atomicIntegerArray;
            ahVar.f3025e = i11;
            ahVar.f3026f = arrayList.size();
            ahVar.f3027g = new AnonymousClass1(currentTimeMillis, arrayList, aVar);
            i11++;
        }
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            ((ah) iterator2.next()).execute(this.f3048f.mUploadToken);
        }
    }

    private void a(Context context, t.a aVar) {
        ABImageResult oi;
        ABImageResult aBImageResult;
        ALBiometricsResult aLBiometricsResult = this.f3046d.biometricsResult;
        ABImageResult qi = aLBiometricsResult.getQi();
        ArrayList<ah> arrayList = new ArrayList();
        j unused = j.a.f3944a;
        if (qi != null) {
            arrayList.add(a(c.f3227o, c.f3227o, this.f3048f.mUploadToken.path, qi.getBf()));
        }
        if (this.f3048f.mNeedActionImage) {
            for (int i10 = 0; i10 < aLBiometricsResult.getAs().size(); i10++) {
                ABActionResult aBActionResult = aLBiometricsResult.getAs().get(i10);
                if (aBActionResult != null && aBActionResult.getIs().size() > 0 && (aBImageResult = aBActionResult.getIs().get(aBActionResult.getIs().size() - 1)) != null) {
                    String concat = "action".concat(String.valueOf(i10));
                    String concat2 = "action".concat(String.valueOf(i10));
                    String str = this.f3048f.mUploadToken.path;
                    byte[] bf = aBImageResult.getBf();
                    c.f3231s.concat(String.valueOf(i10));
                    arrayList.add(a(concat, concat2, str, bf));
                }
            }
        }
        if (this.f3048f.mNeedOriginalImage && (oi = aLBiometricsResult.getOi()) != null) {
            arrayList.add(a(c.f3230r, c.f3230r, this.f3048f.mUploadToken.path, oi.getBf()));
        }
        ABImageResult gi = aLBiometricsResult.getGi();
        if (gi != null) {
            arrayList.add(a(c.f3229q, c.f3229q, this.f3048f.mUploadToken.path, gi.getBf()));
        }
        ABImageResult li = aLBiometricsResult.getLi();
        if (li != null) {
            arrayList.add(a(c.f3228p, c.f3228p, this.f3048f.mUploadToken.path, li.getBf()));
        }
        if (aLBiometricsResult.getDazzleVideoPath() != null) {
            arrayList.add(new ae(context, aLBiometricsResult.getDazzleVideoPath(), "10", aLBiometricsResult));
        }
        AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[arrayList.size()]);
        long currentTimeMillis = System.currentTimeMillis();
        int i11 = 0;
        for (ah ahVar : arrayList) {
            ahVar.f3023c = atomicInteger;
            ahVar.f3024d = atomicIntegerArray;
            ahVar.f3025e = i11;
            ahVar.f3026f = arrayList.size();
            ahVar.f3027g = new AnonymousClass1(currentTimeMillis, arrayList, aVar);
            i11++;
        }
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            ((ah) iterator2.next()).execute(this.f3048f.mUploadToken);
        }
    }

    private ah a(String str, String str2, String str3, byte[] bArr) {
        return new ah(this.f3979b, this.f3980c, str, str2, str3, bArr);
    }
}
