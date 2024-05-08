package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LoadAdParams {

    /* renamed from: a, reason: collision with root package name */
    private LoginType f38257a;

    /* renamed from: b, reason: collision with root package name */
    private String f38258b;

    /* renamed from: c, reason: collision with root package name */
    private String f38259c;

    /* renamed from: d, reason: collision with root package name */
    private String f38260d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f38261e;

    /* renamed from: f, reason: collision with root package name */
    private JSONObject f38262f;

    /* renamed from: g, reason: collision with root package name */
    private final JSONObject f38263g = new JSONObject();

    public Map getDevExtra() {
        return this.f38261e;
    }

    public String getDevExtraJsonString() {
        try {
            Map<String, String> map = this.f38261e;
            return (map == null || map.size() <= 0) ? "" : new JSONObject(this.f38261e).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public JSONObject getExtraInfo() {
        return this.f38262f;
    }

    public String getLoginAppId() {
        return this.f38258b;
    }

    public String getLoginOpenid() {
        return this.f38259c;
    }

    public LoginType getLoginType() {
        return this.f38257a;
    }

    public JSONObject getParams() {
        return this.f38263g;
    }

    public String getUin() {
        return this.f38260d;
    }

    public void setDevExtra(Map<String, String> map) {
        this.f38261e = map;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.f38262f = jSONObject;
    }

    public void setLoginAppId(String str) {
        this.f38258b = str;
    }

    public void setLoginOpenid(String str) {
        this.f38259c = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f38257a = loginType;
    }

    public void setUin(String str) {
        this.f38260d = str;
    }

    public String toString() {
        return "LoadAdParams{, loginType=" + ((Object) this.f38257a) + ", loginAppId=" + this.f38258b + ", loginOpenid=" + this.f38259c + ", uin=" + this.f38260d + ", passThroughInfo=" + ((Object) this.f38261e) + ", extraInfo=" + ((Object) this.f38262f) + '}';
    }
}
