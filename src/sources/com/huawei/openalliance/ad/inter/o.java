package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.dy;
import com.huawei.hms.ads.eo;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kr;
import com.huawei.openalliance.ad.beans.inner.PlacementAdReqParam;
import com.huawei.openalliance.ad.beans.metadata.Video;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.listeners.n;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
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
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class o {
    private n B;
    private int C;
    private boolean D;
    private int F;
    private Context I;
    private boolean L;
    private String S;
    private b V;
    private final String[] Z;

    /* renamed from: a, reason: collision with root package name */
    private RequestOptions f32525a;

    /* renamed from: b, reason: collision with root package name */
    private Location f32526b;

    /* renamed from: c, reason: collision with root package name */
    private String f32527c;

    /* renamed from: d, reason: collision with root package name */
    private long f32528d;

    /* renamed from: e, reason: collision with root package name */
    private long f32529e;

    /* renamed from: f, reason: collision with root package name */
    private long f32530f;

    /* renamed from: g, reason: collision with root package name */
    private int f32531g;

    /* renamed from: h, reason: collision with root package name */
    private String f32532h;

    /* renamed from: i, reason: collision with root package name */
    private String f32533i;

    /* renamed from: j, reason: collision with root package name */
    private Set<String> f32534j;

    /* renamed from: k, reason: collision with root package name */
    private Integer f32535k;

    /* renamed from: l, reason: collision with root package name */
    private String f32536l;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class a {
        private int B;
        private boolean C;
        private Context Code;
        private Location D;
        private RequestOptions F;
        private int I = 4;
        private Integer L;
        private boolean S;
        private String[] V;
        private String Z;

        /* renamed from: a, reason: collision with root package name */
        private String f32537a;

        public a(Context context) {
            this.Code = context.getApplicationContext();
        }

        public int B() {
            return this.B;
        }

        public boolean C() {
            return this.C;
        }

        public a Code(int i10) {
            this.I = i10;
            return this;
        }

        public a Code(Location location) {
            this.D = location;
            return this;
        }

        public a Code(RequestOptions requestOptions) {
            this.F = requestOptions;
            return this;
        }

        public a Code(Integer num) {
            this.L = num;
            return this;
        }

        public a Code(String str) {
            this.Z = str;
            return this;
        }

        public a Code(boolean z10) {
            this.C = z10;
            return this;
        }

        public a Code(String[] strArr) {
            if (strArr != null) {
                this.V = (String[]) Arrays.copyOf(strArr, strArr.length);
            } else {
                this.V = null;
            }
            return this;
        }

        public o Code() {
            return new o(this);
        }

        public Context F() {
            return this.Code;
        }

        public int I() {
            return this.I;
        }

        public boolean S() {
            return this.S;
        }

        public a V(boolean z10) {
            this.S = z10;
            return this;
        }

        public String[] V() {
            String[] strArr = this.V;
            return strArr != null ? (String[]) Arrays.copyOf(strArr, strArr.length) : new String[0];
        }

        public String Z() {
            return this.Z;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum b {
        IDLE,
        LOADING
    }

    private o(a aVar) {
        this.V = b.IDLE;
        if (!v.Code(aVar.Code)) {
            this.Z = new String[0];
            return;
        }
        this.I = aVar.F();
        String[] V = aVar.V();
        if (aa.Code(V)) {
            this.Z = new String[0];
        } else {
            String[] strArr = new String[V.length];
            this.Z = strArr;
            System.arraycopy(V, 0, strArr, 0, V.length);
        }
        this.C = aVar.I();
        this.S = aVar.Z();
        this.F = aVar.B();
        this.D = aVar.C();
        this.L = aVar.S();
        this.f32526b = aVar.D;
        this.f32525a = aVar.F;
        this.f32535k = aVar.L;
        this.f32536l = aVar.f32537a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdSlotParam.a aVar, PlacementAdReqParam placementAdReqParam) {
        kr.Code(this.I, "reqPlaceAd", aVar.S(), z.V(placementAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.o.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                o oVar;
                int code;
                o.this.f32530f = System.currentTimeMillis();
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
                                    if (o.this.f32527c == null) {
                                        o.this.f32527c = adContentData.E();
                                    }
                                    arrayList.add(new com.huawei.openalliance.ad.inter.data.p(adContentData));
                                }
                                hashMap.put(str2, arrayList);
                            }
                        }
                        if (!af.Code(hashMap)) {
                            o.this.Code(hashMap);
                            o.this.V = b.IDLE;
                        }
                    }
                    oVar = o.this;
                } else {
                    oVar = o.this;
                    code = callResult.getCode();
                }
                oVar.I(code);
                o.this.V = b.IDLE;
            }
        }, String.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final Map<String, List<com.huawei.openalliance.ad.inter.data.h>> map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdsLoaded, size:");
        sb2.append(map == null ? 0 : map.size());
        gl.V("PlacementAdLoader", sb2.toString());
        if (this.B != null) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.o.3
                @Override // java.lang.Runnable
                public void run() {
                    n nVar = o.this.B;
                    o.this.f32529e = System.currentTimeMillis();
                    if (nVar != null) {
                        nVar.Code(map);
                    }
                    eo.Code(o.this.I, 200, o.this.f32527c, 60, map, o.this.f32528d, o.this.f32529e, o.this.f32530f);
                }
            });
        }
    }

    private void Code(boolean z10, int i10, int i11) {
        this.f32528d = v.Code();
        gl.V("PlacementAdLoader", "loadAds");
        if (!v.Code(this.I)) {
            gl.I("PlacementAdLoader", "api level too low");
            I(1001);
            return;
        }
        if (!Z(this.S)) {
            gl.I("PlacementAdLoader", "extra info is invalid");
            I(804);
            return;
        }
        b bVar = b.LOADING;
        if (bVar == this.V) {
            gl.V("PlacementAdLoader", "waiting for request finish");
            I(801);
            return;
        }
        String[] strArr = this.Z;
        if (strArr == null || strArr.length == 0) {
            gl.I("PlacementAdLoader", "empty ad ids");
            I(802);
            return;
        }
        if (i10 <= 0) {
            gl.I("PlacementAdLoader", "invalid totalDuration.");
            I(804);
            return;
        }
        if (i11 < 0) {
            gl.I("PlacementAdLoader", "invalid maxCount");
            I(804);
            return;
        }
        this.V = bVar;
        ac.Code(this.I, this.f32525a);
        Video video = new Video(this.F);
        final AdSlotParam.a aVar = new AdSlotParam.a();
        aVar.Code(Arrays.asList(this.Z)).V(this.C).Code(Boolean.valueOf(z10)).Code(1).I(com.huawei.openalliance.ad.utils.c.Z(this.I)).Z(com.huawei.openalliance.ad.utils.c.B(this.I)).Code(this.D).Code(dy.Code(this.f32525a)).Code(this.f32526b).B(i11).D(i10).C(this.f32536l).Code(video);
        Integer num = this.f32535k;
        if (num != null) {
            aVar.S(num);
        }
        final PlacementAdReqParam placementAdReqParam = new PlacementAdReqParam();
        placementAdReqParam.Code(this.S);
        placementAdReqParam.Code(this.L);
        placementAdReqParam.Code(this.f32528d);
        com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.o.1
            @Override // java.lang.Runnable
            public void run() {
                o.this.Code(aVar, placementAdReqParam);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(final int i10) {
        gl.V("PlacementAdLoader", "onAdFailed, errorCode:" + i10);
        if (this.B != null) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.o.4
                @Override // java.lang.Runnable
                public void run() {
                    n nVar = o.this.B;
                    o.this.f32529e = System.currentTimeMillis();
                    if (nVar != null) {
                        nVar.I(i10);
                    }
                    eo.Code(o.this.I, i10, o.this.f32527c, 60, null, o.this.f32528d, o.this.f32529e, o.this.f32530f);
                }
            });
        }
    }

    private boolean Z(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            gl.I("PlacementAdLoader", "extra info is not json string");
            return false;
        }
    }

    public void Code(n nVar) {
        this.B = nVar;
        Code(false, 300, 1);
    }

    public void Code(n nVar, int i10) {
        Code(nVar, i10, 0);
    }

    public void Code(n nVar, int i10, int i11) {
        this.B = nVar;
        Code(false, i10, i11);
    }

    public void Code(String str) {
        this.f32536l = str;
    }

    public void Code(Set<String> set) {
        this.f32534j = set;
    }

    public void I(String str) {
        this.f32533i = str;
    }

    public void V(int i10) {
        this.f32531g = i10;
    }

    public void V(String str) {
        this.f32532h = str;
    }
}
