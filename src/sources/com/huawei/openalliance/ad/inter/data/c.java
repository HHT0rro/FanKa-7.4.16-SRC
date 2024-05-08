package com.huawei.openalliance.ad.inter.data;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kt;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.utils.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class c implements d {
    private static final String I = "BaseAd";
    private String B;
    private String C;
    public AdContentData Code;
    private List<AdSource> F;
    private AppInfo S;
    public String V;
    private final String Z;

    public c(AdContentData adContentData) {
        String uuid = UUID.randomUUID().toString();
        this.Z = uuid;
        this.Code = adContentData;
        if (adContentData != null) {
            adContentData.C(uuid);
        }
    }

    public static List<k> Code(List<ImageInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<ImageInfo> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(new k(iterator2.next()));
            }
        }
        return arrayList;
    }

    private void V(Context context) {
        String str;
        if (ea.Code(context).V()) {
            str = "china rom should not call gotoWhyThisAdPage method";
        } else {
            if (context != null) {
                String h10 = h();
                if (TextUtils.isEmpty(h10)) {
                    h10 = g();
                }
                com.huawei.openalliance.ad.utils.v.Code(context, h10);
                return;
            }
            str = "context is null not call gotoWhyThisAdPage method";
        }
        gl.I(I, str);
    }

    public void Code(long j10) {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.Z(j10);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void Code(Context context) {
        V(context);
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void Code(RewardVerifyConfig rewardVerifyConfig) {
        if (this.Code == null || rewardVerifyConfig == null) {
            return;
        }
        Code(rewardVerifyConfig.getData());
        V(rewardVerifyConfig.getUserId());
    }

    public void Code(String str) {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.p(str);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String D() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.S();
        }
        return null;
    }

    public String E() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.ao();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String F() {
        MetaData k10;
        if (this.B == null && (k10 = k()) != null) {
            this.B = au.V(k10.Code());
        }
        return this.B;
    }

    public String G() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.ap();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public RewardVerifyConfig H() {
        RewardVerifyConfig.Builder builder = new RewardVerifyConfig.Builder();
        builder.setData(E());
        builder.setUserId(G());
        return builder.build();
    }

    public void I(String str) {
        if (str != null) {
            this.Code.h(str);
        }
    }

    public void I(boolean z10) {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.Code(z10);
        }
    }

    public List<AdSource> J() {
        MetaData k10;
        if (this.F == null && (k10 = k()) != null) {
            this.F = k10.i();
        }
        return this.F;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String K() {
        AdSource Code = AdSource.Code(J());
        if (Code != null) {
            return au.V(Code.Code());
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String L() {
        MetaData k10 = k();
        return k10 != null ? k10.d() : "2";
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String M() {
        AdSource Code = AdSource.Code(J());
        if (Code != null) {
            return Code.V();
        }
        return null;
    }

    public String N() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.n();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String O() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.aB();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String P() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.aC();
        }
        return null;
    }

    public void V(String str) {
        if (str != null) {
            this.Code.q(str);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int a() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.h();
        }
        return 0;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String b() {
        AdContentData adContentData = this.Code;
        return adContentData != null ? adContentData.F() : "";
    }

    public String b_() {
        MetaData k10 = k();
        return k10 != null ? k10.a() : "";
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String c() {
        MetaData k10;
        if (this.C == null && (k10 = k()) != null) {
            this.C = au.V(k10.F());
        }
        return this.C;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long d() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.a();
        }
        return 0L;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long e() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.L();
        }
        return 0L;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        String D = D();
        if (!(obj instanceof c) || D == null) {
            return false;
        }
        return TextUtils.equals(D, ((c) obj).D());
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean f() {
        return e() < System.currentTimeMillis();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String g() {
        AdContentData adContentData = this.Code;
        String W = adContentData != null ? adContentData.W() : null;
        return TextUtils.isEmpty(W) ? com.huawei.openalliance.ad.constant.u.al : W;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String h() {
        AdContentData adContentData = this.Code;
        return adContentData != null ? adContentData.X() : "";
    }

    public String h_() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.E();
        }
        return null;
    }

    public int hashCode() {
        String D = D();
        return (D != null ? D.hashCode() : -1) & super.hashCode();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String i() {
        AdContentData adContentData = this.Code;
        return adContentData != null ? adContentData.Y() : "";
    }

    public int i_() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.f();
        }
        return 0;
    }

    public DelayInfo j_() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.ai();
        }
        return null;
    }

    public MetaData k() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.Z();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public AdContentData l() {
        return this.Code;
    }

    public boolean l_() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.t();
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String m() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.C();
        }
        return null;
    }

    public String o() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.B();
        }
        return null;
    }

    public long p() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.aw();
        }
        return 0L;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long r() {
        MetaData k10 = k();
        if (k10 != null) {
            return k10.C();
        }
        return 500L;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int s() {
        MetaData k10 = k();
        if (k10 != null) {
            return k10.S();
        }
        return 50;
    }

    public String t() {
        MetaData k10 = k();
        return k10 != null ? k10.L() : "";
    }

    public String u() {
        return this.Z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public AppInfo v() {
        MetaData k10;
        ApkInfo c4;
        if (this.S == null && (k10 = k()) != null && (c4 = k10.c()) != null) {
            AppInfo appInfo = new AppInfo(c4);
            appInfo.Code(b_());
            appInfo.V(u());
            this.S = appInfo;
        }
        return this.S;
    }

    public List<Integer> w() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.m();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean x() {
        boolean Z = kt.Z(z());
        if (!Z) {
            gl.V(I, "native ad is not in whiteList, api call event report is not allowed.");
        }
        return Z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int y() {
        return kt.a(z());
    }

    public String z() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.r();
        }
        return null;
    }
}
