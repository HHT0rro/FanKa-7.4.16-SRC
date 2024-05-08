package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.utils.FileUtils;
import com.alibaba.security.common.utils.Md5Utils;
import com.alibaba.security.realidentity.business.start.UploadToken;
import com.alibaba.security.realidentity.upload.UploadFileModel;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: DazzleVideoUploadTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ae extends ah {

    /* renamed from: l, reason: collision with root package name */
    public static final String f3039l = "wU^s&Mx75NCr$BPmZngO^WRNgDmnVGX@";

    /* renamed from: m, reason: collision with root package name */
    private final String f3040m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f3041n;

    /* renamed from: o, reason: collision with root package name */
    private final String f3042o;

    /* renamed from: p, reason: collision with root package name */
    private final ALBiometricsResult f3043p;

    public ae(Context context, String str, String str2, ALBiometricsResult aLBiometricsResult) {
        super(context, null, null, null, null);
        this.f3042o = str;
        this.f3040m = str2;
        this.f3041n = true;
        this.f3043p = aLBiometricsResult;
    }

    @Override // com.alibaba.security.realidentity.build.ad, android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(String str) {
        super.onPostExecute(str);
    }

    @Override // com.alibaba.security.realidentity.build.ad, android.os.AsyncTask
    /* renamed from: a */
    public final String doInBackground(UploadToken... uploadTokenArr) {
        if (TextUtils.isEmpty(this.f3042o)) {
            return null;
        }
        UploadFileModel uploadFileModel = new UploadFileModel();
        uploadFileModel.setDestDir("biometric/video/" + new SimpleDateFormat("yyyyMMdd").format(Long.valueOf(System.currentTimeMillis())) + "/" + this.f3031k + "/" + (this.f3041n ? "success" : "failure"));
        uploadFileModel.setFileType("h264");
        uploadFileModel.setLocalFilePath(this.f3042o);
        uploadFileModel.setRemoteFileName(new File(this.f3042o).getName());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Object a10 = this.f3029i.a(null, uploadFileModel, new he() { // from class: com.alibaba.security.realidentity.build.ae.1
            @Override // com.alibaba.security.realidentity.build.he
            public final void a(long j10, long j11) {
            }

            @Override // com.alibaba.security.realidentity.build.he
            public final void a(String str) {
                ae aeVar = ae.this;
                aeVar.f3030j = str;
                if ("10".equals(aeVar.f3040m)) {
                    ae.this.f3043p.setDazzleVideoOssUrl(str);
                    ae.this.f3043p.setVideoHash(Md5Utils.md5ToHex(ae.this.f3031k + Md5Utils.md5File(new File(ae.this.f3042o)) + ae.f3039l));
                }
                FileUtils.delete(ae.this.f3042o);
                countDownLatch.countDown();
            }

            @Override // com.alibaba.security.realidentity.build.he
            public final void b(String str) {
                FileUtils.delete(ae.this.f3042o);
                countDownLatch.countDown();
            }

            @Override // com.alibaba.security.realidentity.build.he
            public final void a() {
                FileUtils.delete(ae.this.f3042o);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(ad.e(), TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            this.f3029i.a(a10);
        }
        return this.f3030j;
    }

    @Override // com.alibaba.security.realidentity.build.ad
    /* renamed from: a */
    public final void onPostExecute(String str) {
        super.onPostExecute(str);
    }
}
