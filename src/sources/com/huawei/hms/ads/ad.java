package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.b;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ad extends af {
    private static final String Z = "JsbAdClick";

    public ad() {
        super(ai.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(com.huawei.openalliance.ad.uriaction.q qVar, Context context, AdContentData adContentData, com.huawei.openalliance.ad.inter.data.m mVar) {
        kv.Code(context, adContentData, (String) null, 0, 0, qVar.I(), 12, b.Code(context), mVar);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        gl.Code(Z, "start");
        final int optInt = new JSONObject(str).optInt("adType", -1);
        Code(context, str, true, new ab() { // from class: com.huawei.hms.ads.ad.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                int i10;
                if (adContentData != null) {
                    MetaData Z2 = adContentData.Z();
                    if (Z2 != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("appId", Z2.L());
                        hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, Z2.D());
                        if (optInt == 3 && adContentData.p() != null) {
                            com.huawei.openalliance.ad.inter.data.v vVar = new com.huawei.openalliance.ad.inter.data.v(adContentData.p());
                            hashMap.put(com.huawei.openalliance.ad.constant.ax.f32270m, adContentData.B());
                            hashMap.put(com.huawei.openalliance.ad.constant.ax.f32271n, String.valueOf(adContentData.z()));
                            hashMap.put(com.huawei.openalliance.ad.constant.ax.f32274q, adContentData.y() ? "true" : "false");
                            hashMap.put(com.huawei.openalliance.ad.constant.ax.f32273p, vVar.a());
                        }
                        com.huawei.openalliance.ad.uriaction.q Code = com.huawei.openalliance.ad.uriaction.r.Code(ad.this.Code(context), adContentData, hashMap);
                        if (!Code.Code()) {
                            gl.Code(ad.Z, "fail open land page");
                            i10 = 3003;
                        } else if (ad.this.Code(adContentData)) {
                            ad adVar = ad.this;
                            adVar.Code(Code, context, adContentData, adVar.C(str));
                        } else {
                            gl.V(ad.Z, "ad is not in whitelist");
                            i10 = 3004;
                        }
                    }
                    i10 = 1000;
                } else {
                    gl.Code(ad.Z, "ad not exist");
                    i10 = 3002;
                }
                af.Code(remoteCallResultCallback, ad.this.Code, i10, null, true);
            }
        });
    }
}
