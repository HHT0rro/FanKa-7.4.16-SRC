package com.huawei.hms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.data.SearchInfo;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class ae extends af {
    private static final int B = -111111;
    private static final String Z = "JsbBaseAdRequest";

    public ae(String str) {
        super(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.ads.data.SearchInfo Code(org.json.JSONObject r12) {
        /*
            r11 = this;
            r0 = 0
            if (r12 == 0) goto L82
            java.lang.String r1 = "searchQry"
            java.lang.String r1 = r12.optString(r1)
            java.lang.String r2 = "searchKwsType"
            java.lang.String r2 = r12.optString(r2)
            java.lang.String r3 = "searchKwsKW"
            java.lang.String r3 = r12.optString(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L65
            java.lang.String r5 = ","
            java.lang.String[] r3 = r3.split(r5)
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            r7 = 0
            if (r6 != 0) goto L3a
            java.lang.String[] r5 = r2.split(r5)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L38
            goto L3b
        L38:
            int r2 = r5.length
            goto L3c
        L3a:
            r5 = r0
        L3b:
            r2 = 0
        L3c:
            r6 = 0
        L3d:
            int r8 = r3.length
            if (r6 >= r8) goto L65
            r8 = r3[r6]
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L62
            com.huawei.hms.ads.data.Keyword r8 = new com.huawei.hms.ads.data.Keyword
            int r9 = r6 + 1
            if (r2 < r9) goto L59
            r9 = r5[r6]
            int r9 = com.huawei.openalliance.ad.utils.au.Code(r9, r7)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L5a
        L59:
            r9 = r0
        L5a:
            r10 = r3[r6]
            r8.<init>(r9, r10)
            r4.add(r8)
        L62:
            int r6 = r6 + 1
            goto L3d
        L65:
            java.lang.String r2 = "searchChnl"
            java.lang.String r12 = r12.optString(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L7d
            boolean r2 = r4.isEmpty()
            if (r2 == 0) goto L7d
            boolean r2 = android.text.TextUtils.isEmpty(r12)
            if (r2 != 0) goto L82
        L7d:
            com.huawei.hms.ads.data.SearchInfo r0 = new com.huawei.hms.ads.data.SearchInfo
            r0.<init>(r1, r4, r12)
        L82:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.ae.Code(org.json.JSONObject):com.huawei.hms.ads.data.SearchInfo");
    }

    private void Code(Context context, String str, RequestOptions.Builder builder, AdParam.Builder builder2) {
        String str2;
        int i10;
        int i11;
        int i12;
        int i13;
        JSONObject jSONObject = new JSONObject(str);
        Integer valueOf = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.as.f32238m, -111111));
        Integer valueOf2 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.as.f32239n, -111111));
        Integer valueOf3 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.as.f32235j, -111111));
        Integer valueOf4 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.as.f32236k, -111111));
        Integer valueOf5 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.as.f32237l, -111111));
        String optString = jSONObject.optString(com.huawei.openalliance.ad.constant.as.f32240o);
        Boolean valueOf6 = Boolean.valueOf(jSONObject.optBoolean(com.huawei.openalliance.ad.constant.as.E, true));
        Boolean valueOf7 = Boolean.valueOf(jSONObject.optBoolean(com.huawei.openalliance.ad.constant.as.G, true));
        Integer valueOf8 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.as.H, 0));
        Boolean valueOf9 = Boolean.valueOf(jSONObject.optBoolean(com.huawei.openalliance.ad.constant.as.J, false));
        String optString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.as.O);
        String optString3 = jSONObject.optString(com.huawei.openalliance.ad.constant.as.f32248w);
        String optString4 = jSONObject.optString(com.huawei.openalliance.ad.constant.as.M);
        String optString5 = jSONObject.optString(com.huawei.openalliance.ad.constant.as.N);
        Integer valueOf10 = Integer.valueOf(jSONObject.optInt("brand", -111111));
        String optString6 = jSONObject.optString(com.huawei.openalliance.ad.constant.as.f32244s);
        String optString7 = jSONObject.optString(com.huawei.openalliance.ad.constant.as.U);
        Map<String, Bundle> S = S(jSONObject.optString("extras"));
        App V = V(jSONObject.optJSONObject("app"));
        Location I = I(str);
        SearchInfo Code = Code(jSONObject.optJSONObject(com.huawei.openalliance.ad.constant.as.aw));
        if (builder != null) {
            if (valueOf != null) {
                i12 = -111111;
                if (-111111 != valueOf.intValue()) {
                    builder.setTagForChildProtection(valueOf);
                }
            } else {
                i12 = -111111;
            }
            if (valueOf2 != null && i12 != valueOf2.intValue()) {
                builder.setTagForUnderAgeOfPromise(valueOf2);
            }
            if (!TextUtils.isEmpty(optString)) {
                builder.setAdContentClassification(optString);
            }
            if (valueOf3 != null) {
                i13 = -111111;
                if (-111111 != valueOf3.intValue()) {
                    builder.setNonPersonalizedAd(valueOf3);
                }
            } else {
                i13 = -111111;
            }
            if (valueOf4 != null && i13 != valueOf4.intValue()) {
                builder.setHwNonPersonalizedAd(valueOf4);
            }
            if (valueOf5 != null && i13 != valueOf5.intValue()) {
                builder.setThirdNonPersonalizedAd(valueOf5);
            }
            if (!TextUtils.isEmpty(optString2)) {
                builder.setConsent(optString2);
            }
            if (!TextUtils.isEmpty(optString3)) {
                builder.setSearchTerm(optString3);
            }
            if (valueOf6 != null) {
                builder.setRequestLocation(valueOf6);
            }
            if (V != null) {
                builder.setApp(V);
            }
            if (!TextUtils.isEmpty(optString4)) {
                builder.setAppLang(optString4);
            }
            if (TextUtils.isEmpty(optString5)) {
                str2 = optString5;
            } else {
                str2 = optString5;
                builder.setAppCountry(str2);
            }
            if (S != null) {
                builder.setExtras(S);
            }
            if (Code != null) {
                builder.setSearchInfo(Code);
            }
        } else {
            str2 = optString5;
        }
        if (builder2 != null) {
            if (valueOf != null) {
                i10 = -111111;
                if (-111111 != valueOf.intValue()) {
                    builder2.setTagForChildProtection(valueOf);
                }
            } else {
                i10 = -111111;
            }
            if (valueOf2 != null && i10 != valueOf2.intValue()) {
                builder2.setTagForUnderAgeOfPromise(valueOf2);
            }
            if (!TextUtils.isEmpty(optString)) {
                builder2.setAdContentClassification(optString);
            }
            if (valueOf3 != null) {
                i11 = -111111;
                if (-111111 != valueOf3.intValue()) {
                    builder2.setNonPersonalizedAd(valueOf3);
                }
            } else {
                i11 = -111111;
            }
            if (valueOf4 != null && i11 != valueOf4.intValue()) {
                builder2.setHwNonPersonalizedAd(valueOf4);
            }
            if (valueOf5 != null && i11 != valueOf5.intValue()) {
                builder2.setThirdNonPersonalizedAd(valueOf5);
            }
            if (!TextUtils.isEmpty(optString2)) {
                builder2.setConsent(optString2);
            }
            if (!TextUtils.isEmpty(optString3)) {
                builder2.setSearchTerm(optString3);
            }
            if (valueOf6 != null) {
                builder2.setRequestLocation(valueOf6.booleanValue());
            }
            if (V != null) {
                builder2.setAppInfo(V);
            }
            if (!TextUtils.isEmpty(optString4)) {
                builder2.setAppLang(optString4);
            }
            if (!TextUtils.isEmpty(str2)) {
                builder2.setAppCountry(str2);
            }
            if (!TextUtils.isEmpty(optString7)) {
                builder2.setContentBundle(Z(optString7));
            }
            if (I != null) {
                builder2.setLocation(I);
            }
            if (Code != null) {
                builder2.setSearchInfo(Code);
            }
        }
        if (valueOf10 != null && -111111 != valueOf10.intValue()) {
            HiAd.getInstance(context).setBrand(valueOf10.intValue());
        }
        if (valueOf7 != null) {
            HiAd.getInstance(context).setAppInstalledNotify(valueOf7.booleanValue());
        }
        if (valueOf8.intValue() != 0) {
            HiAd.getInstance(context).setAppActivateStyle(valueOf8.intValue());
        }
        if (valueOf9 != null) {
            HiAd.getInstance(context).setAppAutoOpenForbidden(valueOf9.booleanValue());
        }
        if (TextUtils.isEmpty(optString6)) {
            return;
        }
        HiAd.getInstance(context).setCountryCode(optString6);
    }

    private Map<String, Bundle> S(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map map = (Map) com.huawei.openalliance.ad.utils.z.V(str, Map.class, Map.class);
        gl.Code(Z, "extras: %s", str);
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry != null) {
                Bundle bundle = new Bundle();
                String str2 = (String) entry.getKey();
                for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                    if (entry2 != null) {
                        bundle.putString((String) entry2.getKey(), (String) entry2.getValue());
                    }
                }
                hashMap.put(str2, bundle);
            }
        }
        return hashMap;
    }

    private App V(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("version");
        String optString3 = jSONObject.optString(com.huawei.openalliance.ad.constant.as.f32250y);
        if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString3) && TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new App(optString3, optString, optString2);
    }

    public abstract void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback);

    public Location I(String str) {
        JSONObject optJSONObject = new JSONObject(str).optJSONObject("location");
        if (optJSONObject == null) {
            return null;
        }
        String optString = optJSONObject.optString(com.huawei.openalliance.ad.constant.as.at);
        String optString2 = optJSONObject.optString(com.huawei.openalliance.ad.constant.as.au);
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || !Pattern.matches(com.huawei.openalliance.ad.constant.u.bU, optString) || !Pattern.matches(com.huawei.openalliance.ad.constant.u.bU, optString2)) {
            return null;
        }
        Location location = new Location("");
        location.setLatitude(new BigDecimal(optString).doubleValue());
        location.setLongitude(new BigDecimal(optString2).doubleValue());
        return location;
    }

    public AdParam I(Context context, String str) {
        AdParam.Builder builder = new AdParam.Builder();
        Code(context, str, (RequestOptions.Builder) null, builder);
        return builder.build();
    }

    public RequestOptions V(Context context, String str) {
        RequestOptions.Builder builder = new RequestOptions.Builder();
        Code(context, str, builder, (AdParam.Builder) null);
        return builder.build();
    }

    public String Z(String str) {
        return str;
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.hms.ads.ae.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ae.this.Code(context, str, remoteCallResultCallback);
                } catch (Throwable th) {
                    gl.Code(5, ae.Z, "executeInNetworkThread exception", th);
                    af.Code(remoteCallResultCallback, ae.this.Code, -1, th.getClass().getSimpleName() + com.huawei.openalliance.ad.constant.u.bD + th.getMessage(), true);
                }
            }
        });
    }
}
