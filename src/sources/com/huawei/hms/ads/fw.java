package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class fw extends ae {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements com.huawei.openalliance.ad.inter.listeners.h {
        private String Code;
        private String I;
        private Context V;
        private RemoteCallResultCallback<String> Z;

        public a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback, String str2) {
            this.Code = str;
            this.V = context;
            this.Z = remoteCallResultCallback;
            this.I = str2;
        }

        private List<H5Ad> Code(List<AdContentData> list) {
            ArrayList arrayList = new ArrayList(4);
            if (list != null && list.size() > 0) {
                for (AdContentData adContentData : list) {
                    if (adContentData != null && adContentData.L() > System.currentTimeMillis()) {
                        if (TextUtils.isEmpty(adContentData.T())) {
                            adContentData.C(UUID.randomUUID().toString());
                        }
                        arrayList.add(new H5Ad(adContentData));
                    }
                }
            }
            return arrayList;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.h
        public void Code(int i10) {
            af.Code(this.Z, this.I, bp.Code(i10), null, true);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.h
        public void Code(Map<String, List<AdContentData>> map) {
            if (map == null || map.size() <= 0) {
                gl.V("JsbReqInterstitialAd", " ads map is empty.");
            } else {
                List<H5Ad> Code = Code(map.get(this.Code));
                if (Code != null && Code.size() > 0) {
                    af.Code(this.Z, this.I, 1000, com.huawei.openalliance.ad.utils.z.V(Code), true);
                    return;
                }
                gl.Code("JsbReqInterstitialAd", " ads is empty.");
            }
            af.Code(this.Z, this.I, 1005, null, true);
        }
    }

    public fw() {
        super(ai.Z);
    }

    @Override // com.huawei.hms.ads.ae
    public void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        String optString = new JSONObject(str).optString("slotId");
        AdParam I = I(context, str);
        z zVar = new z(context);
        zVar.Code(optString);
        zVar.Code((Integer) 3);
        zVar.Code(new a(context, optString, remoteCallResultCallback, this.Code));
        zVar.Code(I);
    }
}
