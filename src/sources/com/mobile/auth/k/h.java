package com.mobile.auth.k;

import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class h extends a {

    /* renamed from: x, reason: collision with root package name */
    public String f37480x = "";

    /* renamed from: y, reason: collision with root package name */
    public String f37481y = "";

    @Override // com.mobile.auth.k.g
    public String a(String str) {
        return this.f37431b + this.f37432c + this.f37433d + this.f37434e + this.f37435f + this.f37436g + this.f37437h + this.f37438i + this.f37439j + this.f37442m + this.f37443n + str + this.f37444o + this.f37446q + this.f37447r + this.f37448s + this.f37449t + this.f37450u + this.f37451v + this.f37480x + this.f37481y + this.f37452w;
    }

    @Override // com.mobile.auth.k.a
    public void a_(String str) {
        this.f37451v = t(str);
    }

    @Override // com.mobile.auth.k.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f37430a);
            jSONObject.put("sdkver", this.f37431b);
            jSONObject.put("appid", this.f37432c);
            jSONObject.put("imsi", this.f37433d);
            jSONObject.put("operatortype", this.f37434e);
            jSONObject.put("networktype", this.f37435f);
            jSONObject.put("mobilebrand", this.f37436g);
            jSONObject.put("mobilemodel", this.f37437h);
            jSONObject.put("mobilesystem", this.f37438i);
            jSONObject.put("clienttype", this.f37439j);
            jSONObject.put("interfacever", this.f37440k);
            jSONObject.put("expandparams", this.f37441l);
            jSONObject.put("msgid", this.f37442m);
            jSONObject.put("timestamp", this.f37443n);
            jSONObject.put("subimsi", this.f37444o);
            jSONObject.put(CardUriUtils.PARAM_SIGN, this.f37445p);
            jSONObject.put("apppackage", this.f37446q);
            jSONObject.put("appsign", this.f37447r);
            jSONObject.put("ipv4_list", this.f37448s);
            jSONObject.put("ipv6_list", this.f37449t);
            jSONObject.put(ALBiometricsKeys.KEY_SDK_TYPE, this.f37450u);
            jSONObject.put("tempPDR", this.f37451v);
            jSONObject.put("scrip", this.f37480x);
            jSONObject.put("userCapaid", this.f37481y);
            jSONObject.put("funcType", this.f37452w);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return this.f37430a + "&" + this.f37431b + "&" + this.f37432c + "&" + this.f37433d + "&" + this.f37434e + "&" + this.f37435f + "&" + this.f37436g + "&" + this.f37437h + "&" + this.f37438i + "&" + this.f37439j + "&" + this.f37440k + "&" + this.f37441l + "&" + this.f37442m + "&" + this.f37443n + "&" + this.f37444o + "&" + this.f37445p + "&" + this.f37446q + "&" + this.f37447r + "&&" + this.f37448s + "&" + this.f37449t + "&" + this.f37450u + "&" + this.f37451v + "&" + this.f37480x + "&" + this.f37481y + "&" + this.f37452w;
    }

    public void v(String str) {
        this.f37480x = t(str);
    }

    public void w(String str) {
        this.f37481y = t(str);
    }
}
