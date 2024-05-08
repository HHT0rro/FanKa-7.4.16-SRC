package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.location.Location;
import com.huawei.hms.ads.App;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.eo;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kr;
import com.huawei.openalliance.ad.beans.inner.BaseAdReqParam;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.s;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.ac;
import com.huawei.openalliance.ad.utils.af;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.utils.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class p {
    private com.huawei.openalliance.ad.inter.listeners.o B;
    private RequestOptions C;
    private String D;
    private int F;
    private final String[] I;
    private String L;
    private Location S;
    private Context V;
    private a Z = a.IDLE;

    /* renamed from: a, reason: collision with root package name */
    private Set<String> f32538a;

    /* renamed from: b, reason: collision with root package name */
    private String f32539b;

    /* renamed from: c, reason: collision with root package name */
    private long f32540c;

    /* renamed from: d, reason: collision with root package name */
    private long f32541d;

    /* renamed from: e, reason: collision with root package name */
    private long f32542e;

    /* renamed from: f, reason: collision with root package name */
    private App f32543f;

    /* renamed from: g, reason: collision with root package name */
    private Integer f32544g;

    /* renamed from: h, reason: collision with root package name */
    private String f32545h;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum a {
        IDLE,
        LOADING
    }

    public p(Context context, String[] strArr) {
        if (!v.Code(context)) {
            this.I = new String[0];
            return;
        }
        this.V = context.getApplicationContext();
        if (strArr == null || strArr.length <= 0) {
            this.I = new String[0];
            return;
        }
        String[] strArr2 = new String[strArr.length];
        this.I = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final Map<String, List<com.huawei.openalliance.ad.inter.data.i>> map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdsLoaded, size:");
        sb2.append((Object) (map != null ? Integer.valueOf(map.size()) : null));
        sb2.append(", listener:");
        sb2.append((Object) this.B);
        gl.V("RewardAdLoader", sb2.toString());
        if (this.B == null) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.p.2
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.inter.listeners.o oVar = p.this.B;
                p.this.f32541d = System.currentTimeMillis();
                if (oVar != null) {
                    oVar.Code(map);
                }
                eo.Code(p.this.V, 200, p.this.f32539b, 7, map, p.this.f32540c, p.this.f32541d, p.this.f32542e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final int i10) {
        gl.V("RewardAdLoader", "onAdFailed, errorCode:" + i10);
        if (this.B == null) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.p.3
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.inter.listeners.o oVar = p.this.B;
                p.this.f32541d = System.currentTimeMillis();
                if (oVar != null) {
                    oVar.Code(i10);
                }
                eo.Code(p.this.V, i10, p.this.f32539b, 7, null, p.this.f32540c, p.this.f32541d, p.this.f32542e);
            }
        });
    }

    public void Code(int i10) {
        this.F = i10;
    }

    public void Code(int i10, boolean z10) {
        this.f32540c = v.Code();
        gl.V("RewardAdLoader", "loadAds");
        if (!v.Code(this.V)) {
            V(1001);
            return;
        }
        a aVar = a.LOADING;
        if (aVar == this.Z) {
            gl.V("RewardAdLoader", "waiting for request finish");
            V(901);
            return;
        }
        String[] strArr = this.I;
        if (strArr == null || strArr.length == 0) {
            gl.I("RewardAdLoader", "empty ad ids");
            V(902);
            return;
        }
        if (this.f32543f != null && !v.I(this.V)) {
            gl.I("RewardAdLoader", "hms ver not support set appInfo.");
            V(706);
            return;
        }
        ac.Code(this.V, this.C);
        this.Z = aVar;
        AdSlotParam.a aVar2 = new AdSlotParam.a();
        aVar2.Code(Arrays.asList(this.I)).V(i10).Code(1).I(com.huawei.openalliance.ad.utils.c.Z(this.V)).Z(com.huawei.openalliance.ad.utils.c.B(this.V)).Code(this.S).Code(this.C).Code(z10).S(this.F).V(this.D).Code(this.f32538a).Code(this.f32543f).I(this.L).C(this.f32545h);
        Integer num = this.f32544g;
        if (num != null) {
            aVar2.S(num);
        }
        BaseAdReqParam baseAdReqParam = new BaseAdReqParam();
        baseAdReqParam.Code(this.f32540c);
        kr.Code(this.V, "reqRewardAd", aVar2.S(), z.V(baseAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.p.1
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                p pVar;
                int code;
                p.this.f32542e = System.currentTimeMillis();
                if (callResult.getCode() == 200) {
                    Map map = (Map) z.V(callResult.getData(), Map.class, List.class, AdContentData.class);
                    code = 204;
                    if (map != null && map.size() > 0) {
                        HashMap hashMap = new HashMap(map.size());
                        for (Map.Entry entry : map.entrySet()) {
                            String str2 = (String) entry.getKey();
                            List<AdContentData> list = (List) entry.getValue();
                            if (list != null) {
                                ArrayList arrayList = new ArrayList(list.size());
                                for (AdContentData adContentData : list) {
                                    if (p.this.f32539b == null) {
                                        p.this.f32539b = adContentData.E();
                                    }
                                    arrayList.add(new s(adContentData));
                                }
                                hashMap.put(str2, arrayList);
                            }
                        }
                        if (!af.Code(hashMap)) {
                            p.this.Code(hashMap);
                            p.this.Z = a.IDLE;
                        }
                    }
                    pVar = p.this;
                } else {
                    pVar = p.this;
                    code = callResult.getCode();
                }
                pVar.V(code);
                p.this.Z = a.IDLE;
            }
        }, String.class);
    }

    public void Code(Location location) {
        this.S = location;
    }

    public void Code(RequestOptions requestOptions) {
        this.C = requestOptions;
        App app = requestOptions.getApp();
        if (app != null) {
            this.f32543f = app;
        }
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.o oVar) {
        this.B = oVar;
    }

    public void Code(Integer num) {
        this.f32544g = num;
    }

    public void Code(String str) {
        this.f32545h = str;
    }

    public void Code(Set<String> set) {
        this.f32538a = set;
    }

    public void I(String str) {
        this.L = str;
    }

    public void V(String str) {
        this.D = str;
    }
}
