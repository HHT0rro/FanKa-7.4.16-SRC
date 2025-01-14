package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.o;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class fy extends ae {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements com.huawei.openalliance.ad.inter.listeners.n {
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

        private List<H5Ad> Code(List<com.huawei.openalliance.ad.inter.data.h> list) {
            AdContentData l10;
            ArrayList arrayList = new ArrayList(4);
            if (list != null && list.size() > 0) {
                for (com.huawei.openalliance.ad.inter.data.h hVar : list) {
                    if (hVar != null && (l10 = hVar.l()) != null) {
                        arrayList.add(new H5Ad(l10));
                    }
                }
            }
            return arrayList;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.n
        public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.h>> map) {
            if (map != null && map.size() > 0) {
                List<H5Ad> Code = Code(map.get(this.Code));
                if (Code.size() > 0) {
                    af.Code(this.Z, this.I, 1000, com.huawei.openalliance.ad.utils.z.V(Code), true);
                    return;
                }
            }
            gl.V("JsbReqPlacementAd", " ads map is empty.");
            af.Code(this.Z, this.I, 1005, null, true);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.n
        public void I(int i10) {
            af.Code(this.Z, this.I, bp.Code(i10), null, true);
        }
    }

    public fy() {
        super(ai.B);
    }

    @Override // com.huawei.hms.ads.ae
    public void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("slotId");
        String optString = jSONObject.optString(com.huawei.openalliance.ad.constant.as.U);
        int optInt = jSONObject.optInt("deviceType", 4);
        int optInt2 = jSONObject.optInt(com.huawei.openalliance.ad.constant.as.f32233h, 1);
        int optInt3 = jSONObject.optInt(com.huawei.openalliance.ad.constant.as.f32234i, 300);
        com.huawei.openalliance.ad.inter.o Code = new o.a(context).Code(false).Code(new String[]{string}).Code(optInt).Code(optString).Code(V(context, str)).Code((Integer) 3).Code(I(str)).Code();
        if (optInt3 > 0) {
            Code.Code(new a(context, string, remoteCallResultCallback, this.Code));
            return;
        }
        String str2 = this.Code;
        if (optInt2 > 0) {
            Code.Code(new a(context, string, remoteCallResultCallback, str2), optInt3);
        } else {
            Code.Code(new a(context, string, remoteCallResultCallback, str2), optInt3, optInt2);
        }
    }
}
