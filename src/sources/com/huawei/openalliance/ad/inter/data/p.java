package com.huawei.openalliance.ad.inter.data;

import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.openalliance.ad.beans.metadata.MediaFile;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.utils.aa;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class p extends c implements h, Comparable {
    private r B;
    private boolean F;
    private boolean S;
    private boolean Z;

    public p(AdContentData adContentData) {
        super(adContentData);
        this.Z = false;
        this.S = false;
        this.F = false;
    }

    public boolean B() {
        return this.S;
    }

    public int C() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.A();
        }
        return 0;
    }

    public String Code() {
        MetaData k10 = k();
        if (k10 != null) {
            return k10.D();
        }
        return null;
    }

    public void Code(boolean z10) {
        this.Z = z10;
    }

    public boolean I() {
        r rVar = this.B;
        return rVar != null && (bb.V.equals(rVar.b()) || bb.B.equals(this.B.b()) || bb.I.equals(this.B.b()) || bb.Z.equals(this.B.b()));
    }

    public boolean Q() {
        return this.F;
    }

    @Override // com.huawei.openalliance.ad.inter.data.h
    public r S() {
        MetaData k10;
        MediaFile e2;
        if (this.B == null && (k10 = k()) != null && (e2 = k10.e()) != null) {
            this.B = new r(e2, k10.h());
        }
        return this.B;
    }

    public boolean V() {
        r rVar = this.B;
        return rVar != null && bb.Code.equals(rVar.b());
    }

    public void Z(boolean z10) {
        this.F = z10;
    }

    public boolean Z() {
        return this.Z;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return ((obj instanceof p) && ((p) obj).C() <= C()) ? 1 : -1;
    }

    public boolean k_() {
        if (this.Code != null) {
            return !aa.Code(r0.aG());
        }
        return false;
    }

    public List<AdvertiserInfo> n() {
        if (this.Code == null || !k_()) {
            return null;
        }
        return this.Code.aG();
    }
}
