package com.huawei.hms.ads;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class kb extends hn<lw> implements ko<lw> {
    private mb B;
    private fr I;
    private kc Z;

    public kb(Context context, lw lwVar) {
        Code((kb) lwVar);
        this.I = fr.Code(context);
    }

    private void Code(boolean z10) {
        if (z10) {
            jq jqVar = new jq(this.I, this.B);
            this.Z = jqVar;
            jqVar.Code();
        }
    }

    @Override // com.huawei.hms.ads.ko
    public void Code(int i10, boolean z10) {
        gl.V("SloganPresenter", "show image");
        if (i10 <= 0) {
            Code(z10);
            return;
        }
        I().Code(i10);
        if (z10) {
            jr jrVar = new jr(this.I, this.B);
            this.Z = jrVar;
            jrVar.V();
        }
    }

    @Override // com.huawei.hms.ads.ko
    public void Code(mb mbVar) {
        this.B = mbVar;
    }
}
