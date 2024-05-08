package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CPUAggregationManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeCPUAggregationData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ak extends bg {

    /* renamed from: a, reason: collision with root package name */
    private CPUAggregationManager.CPUAggregationListener f9774a;

    /* renamed from: q, reason: collision with root package name */
    private String f9775q;

    /* renamed from: r, reason: collision with root package name */
    private int f9776r;

    /* renamed from: s, reason: collision with root package name */
    private int f9777s;

    /* renamed from: t, reason: collision with root package name */
    private int f9778t;

    /* renamed from: u, reason: collision with root package name */
    private int[] f9779u;

    /* renamed from: v, reason: collision with root package name */
    private HashMap<String, Object> f9780v;

    public ak(Context context, String str) {
        super(context);
        this.f9779u = new int[]{1098};
        this.f9775q = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a() {
        if (this.f9881k == null) {
            this.f9882l = false;
            return;
        }
        this.f9882l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, "cpu_hot");
            this.f9881k.createProdHandler(jSONObject3);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_hot");
            jSONObject.put("appsid", this.f9775q);
            jSONObject.put("pageIndex", this.f9777s);
            jSONObject.put("pageSize", this.f9776r);
            jSONObject.put("channels", this.f9779u);
            if (!TextUtils.isEmpty(this.f9775q)) {
                jSONObject.put("appid", this.f9775q);
            }
            jSONObject2.put("timeout", this.f9778t);
            jSONObject2 = k.a(this.f9780v);
            jSONObject2.put("listScene", 503);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f9881k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(String str, int i10) {
        super.b(str, i10);
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.f9774a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError(str, i10);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void d() {
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.f9774a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onExitLp();
        }
    }

    public void a(CPUAggregationManager.CPUAggregationListener cPUAggregationListener) {
        this.f9774a = cPUAggregationListener;
    }

    public void a(int i10, int i11, HashMap<String, Object> hashMap) {
        this.f9777s = i10;
        this.f9776r = i11;
        this.f9780v = hashMap;
    }

    public void a(int i10) {
        this.f9778t = i10;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(IOAdEvent iOAdEvent) {
        if (this.f9774a != null) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator iterator2 = ((List) iOAdEvent.getData().get("cpuHotList")).iterator2();
                while (iterator2.hasNext()) {
                    arrayList.add(new NativeCPUAggregationData(this.f9878h, iterator2.next(), this.f9780v));
                }
                this.f9774a.onHotContentLoaded(arrayList);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(int i10, String str) {
        super.a(i10, str);
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.f9774a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError(str, i10);
        }
    }
}
