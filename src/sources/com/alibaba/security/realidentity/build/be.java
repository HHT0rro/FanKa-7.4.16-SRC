package com.alibaba.security.realidentity.build;

import android.text.TextUtils;
import com.alibaba.security.biometrics.image.RPWebViewMediaCacheManager;
import com.alibaba.security.common.track.model.CommonTrackResult;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.build.hb;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.upload.UploadFileConfigParams;
import com.alibaba.security.realidentity.upload.UploadFileModel;
import org.json.JSONObject;

/* compiled from: UploadApi.java */
@aw(a = "uploadPhoto,rpUploadPhoto")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class be extends aq {
    private static final String ao = "be";
    private hc ap;

    private static String c(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            return str.substring(lastIndexOf + 1);
        }
        return null;
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final String a() {
        return "uploadPhoto";
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean a(String str, ay ayVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String optString = jSONObject.optString(aq.K);
            final String optString2 = jSONObject.optString(aq.f3119o);
            JSONObject optJSONObject = jSONObject.optJSONObject(aq.L);
            String optString3 = optJSONObject.optString("key");
            String optString4 = optJSONObject.optString(aq.N);
            String optString5 = optJSONObject.optString("token");
            String optString6 = optJSONObject.optString(aq.R);
            long optLong = optJSONObject.optLong(aq.P);
            String optString7 = optJSONObject.optString(aq.Q);
            String optString8 = optJSONObject.optString("path");
            if (optString8 != null && !optString8.endsWith("/")) {
                optString8 = optString8 + "/";
            }
            if (optString3 != null && optString4 != null && optString5 != null) {
                String str2 = RPWebViewMediaCacheManager.getInstance().get(optString2);
                int lastIndexOf = str2.lastIndexOf("/");
                String substring = lastIndexOf != -1 ? str2.substring(lastIndexOf + 1) : null;
                if (TextUtils.isEmpty(substring)) {
                    bf bfVar = new bf();
                    bfVar.a("errorMsg", "UploadApi oss fileName is invalid");
                    ayVar.a(bfVar);
                    a(bfVar, false);
                    TrackLog createTakePhotoUploadLog = TrackLog.createTakePhotoUploadLog(new CommonTrackResult(-1, "UploadApi oss fileName is invalid"));
                    createTakePhotoUploadLog.setCode(-1);
                    j.a.f3944a.a(createTakePhotoUploadLog);
                    return false;
                }
                if (this.ap == null) {
                    hb unused = hb.a.f3807a;
                    this.ap = hb.a(this.al);
                }
                final UploadFileConfigParams uploadFileConfigParams = new UploadFileConfigParams();
                uploadFileConfigParams.setToken(optString5);
                uploadFileConfigParams.setSecret(optString4);
                uploadFileConfigParams.setKey(optString3);
                uploadFileConfigParams.setExpired(optLong);
                uploadFileConfigParams.setEndPoint(optString7);
                uploadFileConfigParams.setPath(optString8);
                uploadFileConfigParams.setBucket(optString6);
                uploadFileConfigParams.setContentType(com.huawei.openalliance.ad.constant.bb.V);
                final UploadFileModel uploadFileModel = new UploadFileModel();
                uploadFileModel.setRemoteFileName(optString8 + substring);
                uploadFileModel.setLocalFilePath(str2);
                aq.am.execute(new Runnable() { // from class: com.alibaba.security.realidentity.build.be.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Object a10 = be.this.ap.a(uploadFileConfigParams, uploadFileModel, new he() { // from class: com.alibaba.security.realidentity.build.be.1.1
                            @Override // com.alibaba.security.realidentity.build.he
                            public final void a(String str3) {
                                bb.a().b(optString2);
                                String str4 = "{\"photoType\":\"" + optString + "\",\"sourceUrl\":\"" + str3 + "\"}";
                                be.this.ak.b(str4);
                                aq.a(TrackLog.createTakePhotoUploadLog(new CommonTrackResult()));
                                be.this.a(new bf(str4), true);
                            }

                            @Override // com.alibaba.security.realidentity.build.he
                            public final void b(String str3) {
                                bb.a().b(optString2);
                                bf bfVar2 = new bf();
                                bfVar2.a(aq.K, optString);
                                bfVar2.a(aq.f3119o, optString2);
                                be.this.ak.a(bfVar2);
                                aq.a("oss upload failed", str3);
                                d.a().a("RPException", "RPUpload", "oss upload fail.", "exception", str3, null);
                                TrackLog createTakePhotoUploadLog2 = TrackLog.createTakePhotoUploadLog(new CommonTrackResult(-1, "oss upload failed: ".concat(String.valueOf(str3))));
                                createTakePhotoUploadLog2.setCode(-2);
                                aq.a(createTakePhotoUploadLog2);
                            }

                            @Override // com.alibaba.security.realidentity.build.he
                            public final void a(long j10, long j11) {
                                bf bfVar2 = new bf();
                                bfVar2.a(aq.f3119o, optString2);
                                bfVar2.a(aq.X, String.valueOf(j10));
                                bfVar2.a(aq.Y, String.valueOf(j11));
                                bfVar2.f3165a = 1;
                                be.this.ak.a("rpUploadProgress", bfVar2.a());
                            }

                            @Override // com.alibaba.security.realidentity.build.he
                            public final void a() {
                                bb.a().b(optString2);
                            }
                        });
                        bb a11 = bb.a();
                        String str3 = optString2;
                        synchronized (a11.f3149a) {
                            if (str3 != null && a10 != null) {
                                a11.f3149a.put(str3, a10);
                            }
                        }
                    }
                });
                return true;
            }
            bf bfVar2 = new bf();
            bfVar2.a("errorMsg", aq.f3105ae);
            bfVar2.a(aq.K, optString);
            bfVar2.a(aq.f3119o, optString2);
            ayVar.a(bfVar2);
            a(bfVar2, false);
            TrackLog createTakePhotoUploadLog2 = TrackLog.createTakePhotoUploadLog(new CommonTrackResult(-1, "accessKey or accessSecret or accessToken or expiration is null: " + optString3 + " " + optString4 + " " + optString5 + " " + optLong));
            createTakePhotoUploadLog2.setCode(-1);
            j.a.f3944a.a(createTakePhotoUploadLog2);
            return false;
        } catch (Exception e2) {
            aq.a("UploadApi parse error", e2);
            aq.a(ayVar);
            j.a.f3944a.a(TrackLog.createTakePhotoUploadLog(new CommonTrackResult(-1, "UploadPhotoApi parse error")));
            return false;
        }
    }
}
