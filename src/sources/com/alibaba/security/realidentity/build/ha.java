package com.alibaba.security.realidentity.build;

import android.content.Context;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.oss.ClientException;
import com.alibaba.security.realidentity.oss.ServiceException;
import com.alibaba.security.realidentity.upload.UploadFileConfigParams;
import com.alibaba.security.realidentity.upload.UploadFileModel;
import java.util.HashMap;

/* compiled from: OssUploadFileManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ha extends hc {

    /* compiled from: OssUploadFileManager.java */
    /* renamed from: com.alibaba.security.realidentity.build.ha$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass3 extends cl {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UploadFileConfigParams f3805a;

        public AnonymousClass3(UploadFileConfigParams uploadFileConfigParams) {
            this.f3805a = uploadFileConfigParams;
        }

        @Override // com.alibaba.security.realidentity.build.cl, com.alibaba.security.realidentity.build.cj
        public final cm a() {
            return new cm(this.f3805a.getKey(), this.f3805a.getSecret(), this.f3805a.getToken(), this.f3805a.getExpired());
        }
    }

    public ha(Context context) {
        super(context);
    }

    @Override // com.alibaba.security.realidentity.build.hd
    public final Object a(final UploadFileConfigParams uploadFileConfigParams, UploadFileModel uploadFileModel, final he heVar) {
        if (uploadFileConfigParams == null) {
            heVar.b("upload fail by config params is null");
            return null;
        }
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(uploadFileConfigParams);
        Context context = this.f3808a;
        String endPoint = uploadFileConfigParams.getEndPoint();
        bt btVar = new bt();
        btVar.f3207c = 15000;
        btVar.f3206b = 15000;
        btVar.f3205a = 5;
        btVar.f3209e = 2;
        bv bvVar = new bv(context, endPoint, anonymousClass3, btVar);
        final String bucket = uploadFileConfigParams.getBucket();
        final String remoteFileName = uploadFileModel.getRemoteFileName();
        final gd gdVar = new gd(bucket, remoteFileName, uploadFileModel.getLocalFilePath());
        gdVar.f3726h = new by<gd>() { // from class: com.alibaba.security.realidentity.build.ha.1
            private void b(long j10, long j11) {
                heVar.a(j10, j11);
            }

            @Override // com.alibaba.security.realidentity.build.by
            public final /* bridge */ /* synthetic */ void a(long j10, long j11) {
                heVar.a(j10, j11);
            }
        };
        fu fuVar = new fu();
        fuVar.f3702c.put("Content-Type", uploadFileConfigParams.getContentType());
        gdVar.f3723e = fuVar;
        String str = gdVar.f3720b;
        String contentType = uploadFileConfigParams.getContentType();
        HashMap hashMap = new HashMap();
        hashMap.put("fileName", str);
        hashMap.put("fileType", contentType);
        hashMap.put("fileLength", -1L);
        j.a.f3944a.collectLog(TrackLog.createOssUploadFileBeginLog(JsonUtils.toJSON(hashMap)));
        final long currentTimeMillis = System.currentTimeMillis();
        return bvVar.a(gdVar, new bx<gd, ge>() { // from class: com.alibaba.security.realidentity.build.ha.2
            @Override // com.alibaba.security.realidentity.build.bx
            public final /* synthetic */ void a(gd gdVar2, ClientException clientException, ServiceException serviceException) {
                gd gdVar3 = gdVar2;
                String str2 = "oss://" + bucket + com.huawei.openalliance.ad.constant.u.bD + remoteFileName;
                heVar.b("upload fail by oss upload fail");
                String str3 = CommonUtils.getStackTrace(clientException) + "\n" + CommonUtils.getStackTrace(serviceException);
                ha.a("oss upload failed", str3, gdVar3 != null ? gdVar3.f3721c : "");
                hc.a(gdVar.f3720b, uploadFileConfigParams.getContentType(), str2, "-1", str3, System.currentTimeMillis() - currentTimeMillis);
            }

            private void a() {
                String str2 = "oss://" + bucket + com.huawei.openalliance.ad.constant.u.bD + remoteFileName;
                heVar.a(str2);
                hc.a(gdVar.f3720b, uploadFileConfigParams.getContentType(), str2, "0", null, System.currentTimeMillis() - currentTimeMillis);
            }

            /* renamed from: a, reason: avoid collision after fix types in other method */
            private void a2(gd gdVar2, ClientException clientException, ServiceException serviceException) {
                String str2 = "oss://" + bucket + com.huawei.openalliance.ad.constant.u.bD + remoteFileName;
                heVar.b("upload fail by oss upload fail");
                String str3 = CommonUtils.getStackTrace(clientException) + "\n" + CommonUtils.getStackTrace(serviceException);
                ha.a("oss upload failed", str3, gdVar2 != null ? gdVar2.f3721c : "");
                hc.a(gdVar.f3720b, uploadFileConfigParams.getContentType(), str2, "-1", str3, System.currentTimeMillis() - currentTimeMillis);
            }

            @Override // com.alibaba.security.realidentity.build.bx
            public final /* synthetic */ void a(gd gdVar2, ge geVar) {
                String str2 = "oss://" + bucket + com.huawei.openalliance.ad.constant.u.bD + remoteFileName;
                heVar.a(str2);
                hc.a(gdVar.f3720b, uploadFileConfigParams.getContentType(), str2, "0", null, System.currentTimeMillis() - currentTimeMillis);
            }
        });
    }

    @Override // com.alibaba.security.realidentity.build.hd
    public final void a(Object obj) {
        if (obj instanceof dg) {
            ((dg) obj).a();
        }
    }

    public static void a(String str, String str2, String str3) {
        j.a.f3944a.a(TrackLog.createSdkExceptionLog(str, str2, str3));
    }

    private bv a(UploadFileConfigParams uploadFileConfigParams) {
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(uploadFileConfigParams);
        Context context = this.f3808a;
        String endPoint = uploadFileConfigParams.getEndPoint();
        bt btVar = new bt();
        btVar.f3207c = 15000;
        btVar.f3206b = 15000;
        btVar.f3205a = 5;
        btVar.f3209e = 2;
        return new bv(context, endPoint, anonymousClass3, btVar);
    }

    private static bt a() {
        bt btVar = new bt();
        btVar.f3207c = 15000;
        btVar.f3206b = 15000;
        btVar.f3205a = 5;
        btVar.f3209e = 2;
        return btVar;
    }

    private static void a(TrackLog trackLog) {
        j.a.f3944a.a(trackLog);
    }
}
