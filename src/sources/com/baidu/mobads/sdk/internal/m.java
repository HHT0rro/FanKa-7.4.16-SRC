package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m extends ae {

    /* renamed from: q, reason: collision with root package name */
    private CpuChannelListManager.CpuChannelListListener f10274q;

    /* renamed from: r, reason: collision with root package name */
    private String f10275r;

    /* renamed from: s, reason: collision with root package name */
    private int f10276s;

    public m(Context context) {
        super(context);
    }

    public void a(CpuChannelListManager.CpuChannelListListener cpuChannelListListener) {
        this.f10274q = cpuChannelListListener;
    }

    public void a(String str, int i10) {
        this.f10275r = str;
        this.f10276s = i10;
    }

    @Override // com.baidu.mobads.sdk.internal.ae, com.baidu.mobads.sdk.internal.bg
    public void a() {
        if (this.f9881k == null) {
            this.f9882l = false;
            return;
        }
        this.f9882l = true;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_CPU);
            this.f9881k.createProdHandler(jSONObject2);
            n nVar = new n(this);
            this.f9881k.addEventListener(x.ap, nVar);
            this.f9881k.addEventListener(x.aq, nVar);
            jSONObject.put("appsid", this.f10275r);
            jSONObject.put("subChannelId", this.f10276s);
            jSONObject.put("event_type", "cpu_channelIds");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a(jSONObject);
    }
}
