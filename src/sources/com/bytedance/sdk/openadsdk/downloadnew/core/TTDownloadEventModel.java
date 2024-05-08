package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TTDownloadEventModel {
    private String dk;
    private JSONObject ej;

    /* renamed from: l, reason: collision with root package name */
    private JSONObject f11141l;

    /* renamed from: m, reason: collision with root package name */
    private String f11142m;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public JSONObject getExtJson() {
        return this.ej;
    }

    public String getLabel() {
        return this.dk;
    }

    public JSONObject getMaterialMeta() {
        return this.f11141l;
    }

    public String getTag() {
        return this.f11142m;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.ej = jSONObject;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.dk = str;
        return this;
    }

    public TTDownloadEventModel setMaterialMeta(JSONObject jSONObject) {
        this.f11141l = jSONObject;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.f11142m = str;
        return this;
    }
}
