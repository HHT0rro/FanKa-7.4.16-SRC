package com.huawei.openalliance.ad.inter.data;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kv;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.openalliance.ad.beans.metadata.ContentExt;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.uriaction.q;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.au;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class n extends c implements g {
    private boolean B;
    private String C;
    private List<k> D;
    private k F;
    private v L;
    private String S;

    /* renamed from: a, reason: collision with root package name */
    private List<String> f32470a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f32471b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f32472c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f32473d;

    /* renamed from: e, reason: collision with root package name */
    private int f32474e;

    /* renamed from: f, reason: collision with root package name */
    private String f32475f;

    /* renamed from: g, reason: collision with root package name */
    private NativeAdConfiguration f32476g;

    /* renamed from: h, reason: collision with root package name */
    @com.huawei.openalliance.ad.annotations.d
    private long f32477h;

    /* renamed from: i, reason: collision with root package name */
    private Integer f32478i;

    /* renamed from: j, reason: collision with root package name */
    private String f32479j;

    public n(AdContentData adContentData) {
        super(adContentData);
        this.B = false;
        this.f32471b = false;
        this.f32472c = false;
        this.f32473d = false;
        this.f32474e = 0;
        this.f32478i = Integer.valueOf(adContentData.aA());
        this.f32479j = adContentData.az();
    }

    private boolean C(Context context, Bundle bundle) {
        if (context == null || !x()) {
            return false;
        }
        return B(context, bundle);
    }

    private void Code(Context context, String str, Bundle bundle) {
        gl.V("INativeAd", "api report click event.");
        kv.Code(context, l(), au.Code(bundle), 0, 0, str, 12, com.huawei.openalliance.ad.utils.b.Code(context), V(bundle));
    }

    private void F(Context context, Bundle bundle) {
        gl.V("INativeAd", "api adShow called.");
        kv.Code(context, l(), au.Code(bundle), Long.valueOf(Math.min(System.currentTimeMillis() - this.f32477h, r())), Integer.valueOf(s()), (Integer) 7, com.huawei.openalliance.ad.utils.b.Code(context));
    }

    private void S(Context context, Bundle bundle) {
        gl.V("INativeAd", "api report adShowStart event.");
        kv.Code(context, l(), au.Code(bundle));
    }

    public List<AdvertiserInfo> A() {
        if (this.Code == null || !g_()) {
            return null;
        }
        return this.Code.aG();
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public v B() {
        AdContentData adContentData = this.Code;
        if (adContentData == null || adContentData.p() == null) {
            return null;
        }
        if (this.L == null) {
            v vVar = new v(this.Code.p());
            this.L = vVar;
            vVar.Code(this.Code.y());
        }
        return this.L;
    }

    public void B(String str) {
        this.f32475f = str;
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.V(str);
        }
    }

    public void B(boolean z10) {
        this.f32473d = z10;
    }

    public boolean B(Context context, Bundle bundle) {
        if (context == null) {
            return false;
        }
        Code(true);
        q Code = com.huawei.openalliance.ad.uriaction.r.Code(context, l(), ae());
        boolean Code2 = Code.Code();
        if (Code2) {
            Code(context, Code.I(), bundle);
        }
        return Code2;
    }

    public String Code() {
        MetaData k10;
        if (this.C == null && (k10 = k()) != null) {
            this.C = au.V(k10.I());
        }
        return this.C;
    }

    public void Code(int i10) {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.B(i10);
        }
    }

    public void Code(Context context, List<String> list) {
        if (context == null || !x()) {
            return;
        }
        new com.huawei.hms.ads.g(context, this).Code(list);
    }

    public void Code(Bundle bundle) {
    }

    public void Code(NativeAdConfiguration nativeAdConfiguration) {
        this.f32476g = nativeAdConfiguration;
    }

    public void Code(boolean z10) {
        this.B = z10;
    }

    public boolean Code(Context context, Bundle bundle) {
        if (context == null || !x()) {
            return false;
        }
        this.f32477h = System.currentTimeMillis();
        B(String.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        V(this.f32477h);
        S(context, bundle);
        return true;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public k I() {
        MetaData k10;
        List<ImageInfo> B;
        if (this.F == null && (k10 = k()) != null && (B = k10.B()) != null && !B.isEmpty()) {
            this.F = new k(B.get(0));
        }
        return this.F;
    }

    public boolean I(Context context, Bundle bundle) {
        if (context == null || !x()) {
            gl.V("INativeAd", "record click event failed.");
            return false;
        }
        Code(context, com.huawei.openalliance.ad.constant.t.D, bundle);
        return true;
    }

    public boolean Q() {
        return this.f32471b;
    }

    public boolean R() {
        return this.f32472c;
    }

    public boolean T() {
        return this.f32473d;
    }

    public String U() {
        MetaData k10 = k();
        return k10 != null ? k10.D() : "";
    }

    public m V(Bundle bundle) {
        JSONObject V = au.V(bundle);
        Integer valueOf = Integer.valueOf(V.optInt(ax.aj, -111111));
        Integer valueOf2 = Integer.valueOf(V.optInt(ax.ak, -111111));
        String optString = V.optString(ax.al, "");
        if (valueOf.intValue() == -111111) {
            valueOf = null;
        }
        if (valueOf2.intValue() == -111111) {
            valueOf2 = null;
        }
        if (!au.D(optString)) {
            optString = null;
        }
        return new m(valueOf, valueOf2, optString);
    }

    public String V() {
        MetaData Z;
        if (this.S == null && (Z = this.Code.Z()) != null) {
            this.S = au.V(Z.Z());
        }
        return this.S;
    }

    public void V(long j10) {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.Z(j10);
        }
    }

    public void V(boolean z10) {
        this.f32471b = z10;
    }

    public boolean V(Context context, Bundle bundle) {
        if (context == null || !x()) {
            return false;
        }
        F(context, bundle);
        return true;
    }

    public String W() {
        return c();
    }

    public Double X() {
        return null;
    }

    public String Y() {
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<k> Z() {
        MetaData k10;
        if (this.D == null && (k10 = k()) != null) {
            this.D = c.Code(k10.b());
        }
        return this.D;
    }

    public void Z(String str) {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.S(str);
        }
    }

    public void Z(boolean z10) {
        this.f32472c = z10;
    }

    public boolean Z(Context context, Bundle bundle) {
        return C(context, bundle);
    }

    public String aa() {
        return null;
    }

    public Bundle ab() {
        return new Bundle();
    }

    public void ac() {
    }

    public NativeAdConfiguration ad() {
        return this.f32476g;
    }

    public Map<String, String> ae() {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", t());
        hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, U());
        if (B() == null) {
            return hashMap;
        }
        hashMap.put(ax.f32270m, o());
        int L = B().L();
        gl.V("INativeAd", "buildLinkedAdConfig, set progress from native view " + L);
        hashMap.put(ax.f32271n, String.valueOf(aj()));
        hashMap.put(ax.f32274q, B().h() ? "true" : "false");
        hashMap.put(ax.f32273p, B().a());
        hashMap.put(ax.f32272o, String.valueOf(L));
        return hashMap;
    }

    public String ag() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.I();
        }
        return null;
    }

    public String ah() {
        AdContentData adContentData = this.Code;
        return adContentData != null ? adContentData.x() : "";
    }

    public Integer ai() {
        return this.f32478i;
    }

    public int aj() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            this.f32474e = adContentData.z();
        }
        return this.f32474e;
    }

    public String ak() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.aj();
        }
        return null;
    }

    public boolean c_() {
        return B() != null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public boolean d_() {
        AdContentData adContentData = this.Code;
        return adContentData != null && adContentData.ag() == 1;
    }

    public boolean g_() {
        if (this.Code != null) {
            return !aa.Code(r0.aG());
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<String> n() {
        AdContentData adContentData;
        List<String> k10;
        if (this.f32470a == null && (adContentData = this.Code) != null && (k10 = adContentData.k()) != null && k10.size() > 0) {
            this.f32470a = k10;
        }
        return this.f32470a;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public String o() {
        return this.f32475f;
    }

    public Map<String, String> q() {
        AdContentData adContentData = this.Code;
        if (adContentData == null) {
            return null;
        }
        List<ImpEX> at = adContentData.at();
        List<ContentExt> au = this.Code.au();
        HashMap hashMap = new HashMap();
        if (!aa.Code(au)) {
            for (ContentExt contentExt : au) {
                hashMap.put(contentExt.Code(), au.V(contentExt.V()));
            }
        }
        if (!aa.Code(at)) {
            for (ImpEX impEX : at) {
                hashMap.put(impEX.Code(), au.V(impEX.V()));
            }
        }
        return hashMap;
    }
}
