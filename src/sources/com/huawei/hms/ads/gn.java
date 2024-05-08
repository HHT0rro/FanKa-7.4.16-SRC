package com.huawei.hms.ads;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class gn extends gj {
    private gn() {
    }

    public static gq Code() {
        return new gn();
    }

    private void Code(String str, int i10, String str2) {
    }

    @Override // com.huawei.hms.ads.gq
    public gq Code(String str, String str2) {
        gq gqVar = this.Code;
        if (gqVar != null) {
            gqVar.Code(str, str2);
        }
        return this;
    }

    @Override // com.huawei.hms.ads.gq
    public void Code(gs gsVar, int i10, String str) {
        if (gsVar == null) {
            return;
        }
        Code(gsVar.V(), i10, str);
        gq gqVar = this.Code;
        if (gqVar != null) {
            gqVar.Code(gsVar, i10, str);
        }
    }
}
