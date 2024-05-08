package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.location.Location;
import com.huawei.hms.ads.App;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.eo;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kr;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.openalliance.ad.beans.inner.NativeAdReqParam;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.listeners.l;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.ac;
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
public class m implements i {
    private static final String V = "m";
    private DelayInfo A;
    private a B;
    private final String[] C;
    public boolean Code;
    private String D;
    private com.huawei.openalliance.ad.inter.listeners.i F;
    private List<String> I;
    private boolean L;
    private l S;
    private com.huawei.openalliance.ad.inter.listeners.d Z;

    /* renamed from: a, reason: collision with root package name */
    private boolean f32499a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f32500b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f32501c;

    /* renamed from: d, reason: collision with root package name */
    private Context f32502d;

    /* renamed from: e, reason: collision with root package name */
    private int f32503e;

    /* renamed from: f, reason: collision with root package name */
    private RequestOptions f32504f;

    /* renamed from: g, reason: collision with root package name */
    private Location f32505g;

    /* renamed from: h, reason: collision with root package name */
    private Integer f32506h;

    /* renamed from: i, reason: collision with root package name */
    private int f32507i;

    /* renamed from: j, reason: collision with root package name */
    private String f32508j;

    /* renamed from: k, reason: collision with root package name */
    private String f32509k;

    /* renamed from: l, reason: collision with root package name */
    private Set<String> f32510l;

    /* renamed from: m, reason: collision with root package name */
    private int f32511m;

    /* renamed from: n, reason: collision with root package name */
    private Integer f32512n;

    /* renamed from: o, reason: collision with root package name */
    private Integer f32513o;

    /* renamed from: p, reason: collision with root package name */
    private Integer f32514p;

    /* renamed from: q, reason: collision with root package name */
    private NativeAdConfiguration f32515q;

    /* renamed from: r, reason: collision with root package name */
    private String f32516r;

    /* renamed from: s, reason: collision with root package name */
    private long f32517s;

    /* renamed from: t, reason: collision with root package name */
    private long f32518t;

    /* renamed from: u, reason: collision with root package name */
    private long f32519u;

    /* renamed from: v, reason: collision with root package name */
    private String f32520v;

    /* renamed from: w, reason: collision with root package name */
    private App f32521w;

    /* renamed from: x, reason: collision with root package name */
    private List<Integer> f32522x;

    /* renamed from: y, reason: collision with root package name */
    private Integer f32523y;

    /* renamed from: z, reason: collision with root package name */
    private String f32524z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum a {
        IDLE,
        LOADING
    }

    public m(Context context, String[] strArr) {
        this(context, strArr, false);
    }

    public m(Context context, String[] strArr, int i10) {
        this(context, strArr, false);
        this.f32503e = i10;
    }

    public m(Context context, String[] strArr, int i10, List<String> list) {
        this(context, strArr, false);
        this.f32503e = i10;
        this.I = list;
    }

    public m(Context context, String[] strArr, boolean z10) {
        this.B = a.IDLE;
        this.f32501c = false;
        this.f32503e = 3;
        this.A = new DelayInfo();
        if (!v.Code(context)) {
            this.C = new String[0];
            return;
        }
        this.f32502d = context.getApplicationContext();
        if (strArr == null || strArr.length <= 0) {
            this.C = new String[0];
        } else {
            String[] strArr2 = new String[strArr.length];
            this.C = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        }
        this.L = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdSlotParam.a aVar, NativeAdReqParam nativeAdReqParam) {
        kr.Code(this.f32502d.getApplicationContext(), "reqNativeAd", aVar.S(), z.V(nativeAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.m.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                m.this.f32519u = System.currentTimeMillis();
                m.this.A.j().c(m.this.f32519u);
                boolean z10 = false;
                if (callResult.getCode() == 200) {
                    Map map = (Map) z.V(callResult.getData(), Map.class, List.class, AdContentData.class);
                    if (map == null || map.size() <= 0) {
                        m.this.V(204, true);
                    } else {
                        HashMap hashMap = new HashMap(map.size());
                        for (Map.Entry entry : map.entrySet()) {
                            String str2 = (String) entry.getKey();
                            List<AdContentData> list = (List) entry.getValue();
                            if (list != null) {
                                ArrayList arrayList = new ArrayList(list.size());
                                for (AdContentData adContentData : list) {
                                    if (m.this.f32520v == null) {
                                        m.this.f32520v = adContentData.E();
                                    }
                                    n nVar = new n(adContentData);
                                    nVar.Code(m.this.f32515q);
                                    arrayList.add(nVar);
                                    if (!z10) {
                                        z10 = adContentData.aa();
                                    }
                                }
                                hashMap.put(str2, arrayList);
                            }
                        }
                        m.this.Code(hashMap, z10);
                    }
                } else if (callResult.getCode() == 602) {
                    List<String> list2 = (List) z.V(callResult.getMsg(), List.class, new Class[0]);
                    if (m.this.Z != null && list2 != null) {
                        gl.Code(m.V, "InValidContentIdsGot: %s", list2.toString());
                        m.this.Z.Code(list2);
                    }
                } else {
                    z10 = Boolean.valueOf(callResult.getMsg()).booleanValue();
                    if (-10 != callResult.getCode()) {
                        m.this.V(callResult.getCode(), z10);
                    }
                }
                if (z10) {
                    m.this.B = a.IDLE;
                }
            }
        }, String.class);
    }

    public void B(Integer num) {
        this.f32523y = num;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(int i10) {
        this.f32507i = i10;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(int i10, String str, boolean z10) {
        this.f32517s = System.currentTimeMillis();
        this.A.j().Code(this.f32517s);
        String str2 = V;
        gl.V(str2, "loadAds");
        if (!v.Code(this.f32502d)) {
            V(1001, true);
            return;
        }
        a aVar = a.LOADING;
        if (aVar == this.B) {
            gl.V(str2, "waiting for request finish");
            V(701, true);
            return;
        }
        String[] strArr = this.C;
        if (strArr == null || strArr.length == 0) {
            gl.I(str2, "empty ad ids");
            V(702, true);
            return;
        }
        if (this.f32521w != null && !v.I(this.f32502d)) {
            gl.I(str2, "hms ver not support set appInfo.");
            V(706, true);
            return;
        }
        ac.Code(this.f32502d, this.f32504f);
        this.B = aVar;
        final AdSlotParam.a aVar2 = new AdSlotParam.a();
        aVar2.Code(Arrays.asList(this.C)).V(i10).Code(str).Code(1).I(com.huawei.openalliance.ad.utils.c.Z(this.f32502d)).Z(com.huawei.openalliance.ad.utils.c.B(this.f32502d)).Code(z10).Code(this.f32504f).Code(this.f32505g).C(this.f32503e).S(this.f32507i).V(this.f32508j).B(this.f32511m).Code(this.f32510l).I(this.f32509k).Code(this.f32512n).Code(this.f32521w).C(this.f32506h).Z(this.f32516r).V(this.f32522x).C(this.f32524z).Z(this.f32501c);
        Integer num = this.f32513o;
        if (num != null && this.f32514p != null) {
            aVar2.V(num);
            aVar2.I(this.f32514p);
        }
        Integer num2 = this.f32523y;
        if (num2 != null) {
            aVar2.S(num2);
        }
        if (this.f32515q != null) {
            aVar2.V(!r11.isReturnUrlsForImages());
            aVar2.I(this.f32515q.isRequestMultiImages());
        }
        final NativeAdReqParam nativeAdReqParam = new NativeAdReqParam();
        nativeAdReqParam.Code(this.D);
        nativeAdReqParam.V(this.f32499a);
        nativeAdReqParam.Code(this.L);
        nativeAdReqParam.I(this.f32500b);
        nativeAdReqParam.Code(this.I);
        nativeAdReqParam.Code(this.f32517s);
        final long currentTimeMillis = System.currentTimeMillis();
        com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.m.1
            @Override // java.lang.Runnable
            public void run() {
                m.this.A.Z(System.currentTimeMillis() - currentTimeMillis);
                m.this.Code(aVar2, nativeAdReqParam);
            }
        });
    }

    public void Code(int i10, boolean z10) {
        Code(i10, (String) null, z10);
    }

    public void Code(Location location) {
        this.f32505g = location;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(RequestOptions requestOptions) {
        this.f32504f = requestOptions;
        App app = requestOptions.getApp();
        if (app != null) {
            this.f32521w = app;
        }
    }

    public void Code(NativeAdConfiguration nativeAdConfiguration) {
        this.f32515q = nativeAdConfiguration;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(com.huawei.openalliance.ad.inter.listeners.d dVar) {
        this.Z = dVar;
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.i iVar) {
        this.F = iVar;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(l lVar) {
        this.S = lVar;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(Integer num) {
        this.f32512n = num;
    }

    public void Code(String str) {
        this.D = str;
    }

    public void Code(List<Integer> list) {
        this.f32522x = list;
    }

    public void Code(final Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map, final boolean z10) {
        String str = V;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdsLoaded, size:");
        sb2.append((Object) (map != null ? Integer.valueOf(map.size()) : null));
        sb2.append(", listener:");
        sb2.append((Object) this.S);
        sb2.append(" innerlistener: ");
        sb2.append((Object) this.F);
        gl.V(str, sb2.toString());
        final long currentTimeMillis = System.currentTimeMillis();
        this.A.j().D(currentTimeMillis);
        if (!this.Code) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.m.3
                @Override // java.lang.Runnable
                public void run() {
                    l lVar = m.this.S;
                    m.this.f32518t = System.currentTimeMillis();
                    m.this.A.j().V(m.this.f32518t);
                    long j10 = m.this.f32518t - currentTimeMillis;
                    m.this.A.D(j10);
                    gl.V(m.V, "onAdsLoaded main thread switch: %s ms", Long.valueOf(j10));
                    if (lVar != null) {
                        lVar.Code(map);
                    }
                    com.huawei.openalliance.ad.inter.listeners.i iVar = m.this.F;
                    if (iVar != null) {
                        iVar.Code(map, z10);
                    }
                    eo.Code(m.this.f32502d, 200, m.this.f32520v, m.this.f32503e, map, m.this.f32518t - m.this.f32517s, m.this.A);
                }
            });
            return;
        }
        this.A.L(currentTimeMillis);
        gl.V(str, "onAdsLoaded thread");
        l lVar = this.S;
        if (lVar != null) {
            lVar.Code(map);
        }
        com.huawei.openalliance.ad.inter.listeners.i iVar = this.F;
        if (iVar != null) {
            iVar.Code(map, z10);
        }
        eo.Code(this.f32502d, 200, this.f32520v, this.f32503e, map, this.f32517s, currentTimeMillis, this.f32519u);
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(Set<String> set) {
        this.f32510l = set;
    }

    public void Code(boolean z10) {
        this.f32499a = z10;
    }

    public void I(int i10) {
        this.f32503e = i10;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void I(Integer num) {
        this.f32514p = num;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void I(String str) {
        this.f32509k = str;
    }

    public void I(boolean z10) {
        this.Code = z10;
    }

    public void V(int i10) {
        this.f32511m = i10;
    }

    public void V(final int i10, final boolean z10) {
        String str = V;
        gl.V(str, "onAdFailed, errorCode:" + i10);
        final long currentTimeMillis = System.currentTimeMillis();
        this.A.j().D(currentTimeMillis);
        if (!this.Code) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.m.4
                @Override // java.lang.Runnable
                public void run() {
                    l lVar = m.this.S;
                    m.this.f32518t = System.currentTimeMillis();
                    m.this.A.j().V(m.this.f32518t);
                    long j10 = m.this.f32518t - currentTimeMillis;
                    m.this.A.D(j10);
                    gl.V(m.V, "onAdFailed main thread switch: %s ms", Long.valueOf(j10));
                    if (lVar != null) {
                        lVar.Code(i10);
                    }
                    com.huawei.openalliance.ad.inter.listeners.i iVar = m.this.F;
                    if (iVar != null) {
                        iVar.Code(i10, z10);
                    }
                    eo.Code(m.this.f32502d, i10, m.this.f32520v, m.this.f32503e, null, m.this.f32518t - m.this.f32517s, m.this.A);
                }
            });
            return;
        }
        gl.V(str, "onAdFailed thread");
        l lVar = this.S;
        if (lVar != null) {
            lVar.Code(i10);
        }
        com.huawei.openalliance.ad.inter.listeners.i iVar = this.F;
        if (iVar != null) {
            iVar.Code(i10, z10);
        }
        eo.Code(this.f32502d, i10, this.f32520v, this.f32503e, null, this.f32517s, currentTimeMillis, this.f32519u);
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void V(Integer num) {
        this.f32513o = num;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void V(String str) {
        this.f32508j = str;
    }

    public void V(boolean z10) {
        this.f32500b = z10;
    }

    public void Z(Integer num) {
        this.f32506h = num;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Z(String str) {
        this.f32524z = str;
    }

    public void Z(boolean z10) {
        gl.V(V, "setSupportTptAd: %s", Boolean.valueOf(z10));
        this.f32501c = z10;
    }
}
