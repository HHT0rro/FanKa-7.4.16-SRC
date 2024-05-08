package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class fx extends ae {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements com.huawei.openalliance.ad.inter.listeners.l {
        private int B;
        private String Code;
        private String I;
        private Context V;
        private RemoteCallResultCallback<String> Z;

        public a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback, String str2, int i10) {
            this.Code = str;
            this.V = context;
            this.Z = remoteCallResultCallback;
            this.I = str2;
            this.B = i10;
        }

        private void Code(List<com.huawei.openalliance.ad.inter.data.g> list) {
            ArrayList arrayList = new ArrayList();
            Code(list, arrayList);
            I(arrayList);
        }

        private <T> void Code(List<com.huawei.openalliance.ad.inter.data.g> list, List<T> list2) {
            if (aa.Code(list)) {
                return;
            }
            for (com.huawei.openalliance.ad.inter.data.g gVar : list) {
                if (gVar != null && gVar.l() != null) {
                    int i10 = this.B;
                    if (i10 == 3) {
                        AdContentData l10 = gVar.l();
                        l10.L(l10.ax());
                        list2.add(gVar.l());
                    } else if (i10 == 2) {
                        list2.add(new H5Ad(gVar.l()));
                    }
                }
            }
        }

        private <T> void I(List<T> list) {
            if (!aa.Code(list)) {
                af.Code(this.Z, this.I, 1000, list, true);
            } else {
                gl.V("JsbReqNativeAd", " ads list is empty.");
                af.Code(this.Z, this.I, 1005, null, true);
            }
        }

        private void V(List<com.huawei.openalliance.ad.inter.data.g> list) {
            ArrayList arrayList = new ArrayList();
            Code(list, arrayList);
            I(arrayList);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.l
        public void Code(int i10) {
            af.Code(this.Z, this.I, bp.Code(i10), null, true);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.l
        public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
            if (com.huawei.openalliance.ad.utils.af.Code(map)) {
                gl.Code("JsbReqNativeAd", " ads map is empty.");
                af.Code(this.Z, this.I, 1005, null, true);
                return;
            }
            List<com.huawei.openalliance.ad.inter.data.g> list = map.get(this.Code);
            int i10 = this.B;
            if (i10 == 2) {
                Code(list);
            } else {
                if (i10 != 3) {
                    return;
                }
                V(list);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements com.huawei.openalliance.ad.inter.listeners.d {
        private String Code;
        private RemoteCallResultCallback<String> V;

        public b(RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            this.V = remoteCallResultCallback;
            this.Code = str;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.d
        public void Code(List<String> list) {
            af.Code(this.V, this.Code, 200, new JsbCallBackData(com.huawei.openalliance.ad.utils.z.V(list), false, ag.Code));
        }
    }

    public fx() {
        super(ai.V);
    }

    private List<Integer> Code(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                int optInt = jSONArray.optInt(i10, -111111);
                if (optInt != -111111) {
                    arrayList.add(Integer.valueOf(optInt));
                }
            }
        }
        return arrayList;
    }

    private String S(String str) {
        HashMap hashMap = new HashMap();
        Map map = (Map) com.huawei.openalliance.ad.utils.z.V(str, Map.class, new Class[0]);
        if (map != null && map.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                if (entry != null) {
                    arrayList.add(new ImpEX((String) entry.getKey(), com.huawei.openalliance.ad.utils.au.S((String) entry.getValue())));
                }
            }
            if (arrayList.size() > 0) {
                hashMap.put("contentBundle", arrayList);
            }
        }
        if (hashMap.size() > 0) {
            return com.huawei.openalliance.ad.utils.z.V(hashMap);
        }
        return null;
    }

    private List<String> V(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String optString = jSONArray.optString(i10);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.ads.ae
    public void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("slotId");
        String optString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.as.U);
        JSONArray optJSONArray = jSONObject.optJSONArray(com.huawei.openalliance.ad.constant.as.W);
        int optInt = jSONObject.optInt(com.huawei.openalliance.ad.constant.as.aJ, 2);
        int optInt2 = jSONObject.optInt("adType", 3);
        int optInt3 = jSONObject.optInt(com.huawei.openalliance.ad.constant.as.f32227b, -111111);
        int optInt4 = jSONObject.optInt(com.huawei.openalliance.ad.constant.as.f32228c, -111111);
        int optInt5 = jSONObject.optInt(com.huawei.openalliance.ad.constant.as.f32229d, -111111);
        int optInt6 = jSONObject.optInt("deviceType", 4);
        int optInt7 = jSONObject.optInt(com.huawei.openalliance.ad.constant.as.f32232g, -111111);
        List<String> V = V(jSONObject.optJSONArray(com.huawei.openalliance.ad.constant.as.f32231f));
        boolean optBoolean = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.as.aC, true);
        boolean optBoolean2 = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.as.aB, false);
        boolean optBoolean3 = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.as.aD, false);
        RequestOptions Code = dy.Code(V(context, str));
        com.huawei.openalliance.ad.inter.m mVar = new com.huawei.openalliance.ad.inter.m(context, new String[]{optString}, optInt2, V);
        if (optInt7 != -111111) {
            mVar.Z(Integer.valueOf(optInt7));
        }
        if (optInt3 != -111111) {
            mVar.Code(Integer.valueOf(optInt3));
        }
        if (optInt4 != -111111) {
            mVar.V(Integer.valueOf(optInt4));
        }
        if (optInt5 != -111111) {
            mVar.I(Integer.valueOf(optInt5));
        }
        mVar.Code(Code);
        mVar.Code(S(optString2));
        mVar.Z(Z(optString2));
        mVar.Code(Code(optJSONArray));
        mVar.Code(optBoolean);
        mVar.V(optBoolean2);
        mVar.Code(new b(remoteCallResultCallback, this.Code));
        mVar.Code(new a(context, optString, remoteCallResultCallback, this.Code, optInt));
        mVar.B((Integer) 3);
        mVar.Code(I(str));
        mVar.Z(optBoolean3);
        mVar.Code(optInt6, false);
    }
}
