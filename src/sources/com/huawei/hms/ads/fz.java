package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class fz extends ae {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements com.huawei.openalliance.ad.inter.listeners.o {
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

        private List<H5Ad> Code(List<com.huawei.openalliance.ad.inter.data.i> list) {
            ArrayList arrayList = new ArrayList(4);
            if (list != null && list.size() > 0) {
                for (com.huawei.openalliance.ad.inter.data.i iVar : list) {
                    if (iVar != null) {
                        arrayList.add(new H5Ad(iVar.l()));
                    }
                }
            }
            return arrayList;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.o
        public void Code(int i10) {
            af.Code(this.Z, this.I, bp.Code(i10), null, true);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.o
        public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.i>> map) {
            if (map != null && map.size() > 0) {
                List<H5Ad> Code = Code(map.get(this.Code));
                if (Code.size() > 0) {
                    af.Code(this.Z, this.I, 1000, com.huawei.openalliance.ad.utils.z.V(Code), true);
                    return;
                }
            }
            gl.V("JsbReqRewardAd", " ads map is empty.");
            af.Code(this.Z, this.I, 1005, null, true);
        }
    }

    public fz() {
        super(ai.I);
    }

    @Override // com.huawei.hms.ads.ae
    public void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("slotId");
        String optString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.as.U);
        int optInt = jSONObject.optInt("deviceType", 4);
        RequestOptions V = V(context, str);
        com.huawei.openalliance.ad.inter.p pVar = new com.huawei.openalliance.ad.inter.p(context, new String[]{optString});
        pVar.Code(V);
        pVar.Code((Integer) 3);
        pVar.Code(Z(optString2));
        pVar.Code(I(str));
        pVar.Code(new a(context, optString, remoteCallResultCallback, this.Code));
        pVar.Code(optInt, false);
    }
}
