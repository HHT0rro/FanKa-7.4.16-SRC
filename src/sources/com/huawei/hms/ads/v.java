package com.huawei.hms.ads;

import android.net.Uri;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class v extends Video {
    private Uri Code;
    private int I;
    private Float V;

    public v(com.huawei.openalliance.ad.inter.data.v vVar) {
        if (vVar != null) {
            this.Code = Uri.parse(vVar.V());
            this.V = vVar.g();
            this.I = vVar.I();
        }
    }

    @Override // com.huawei.hms.ads.Video
    public float getAspectRatio() {
        Float f10 = this.V;
        if (f10 == null) {
            return 1.7777778f;
        }
        return f10.floatValue();
    }

    @Override // com.huawei.hms.ads.Video
    public int getDuration() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.Video
    public Uri getUri() {
        return this.Code;
    }
}
