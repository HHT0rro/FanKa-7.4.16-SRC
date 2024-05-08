package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.Position;
import com.iab.omid.library.huawei.adsession.media.VastProperties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ji implements ja {
    private static boolean Code = ip.Code("com.iab.omid.library.huawei.adsession.media.VastProperties");
    private final jh B;
    private Float C;
    private final boolean I;
    private final boolean V;
    private final VastProperties Z;

    private ji(float f10, boolean z10, jh jhVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.C = Float.valueOf(f10);
        this.I = z10;
        this.B = jhVar;
        this.Z = vastProperties;
    }

    private ji(boolean z10, jh jhVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.I = z10;
        this.B = jhVar;
        this.Z = vastProperties;
    }

    public static ji Code(float f10, boolean z10, jh jhVar) {
        Position Code2;
        return new ji(f10, z10, jhVar, (jhVar == null || !Code() || (Code2 = jh.Code(jhVar)) == null) ? null : VastProperties.createVastPropertiesForSkippableMedia(f10, z10, Code2));
    }

    public static ji Code(boolean z10, jh jhVar) {
        Position Code2;
        return new ji(z10, jhVar, (jhVar == null || !Code() || (Code2 = jh.Code(jhVar)) == null) ? null : VastProperties.createVastPropertiesForNonSkippableMedia(z10, Code2));
    }

    public static boolean Code() {
        return Code;
    }

    public jh B() {
        return this.B;
    }

    public VastProperties C() {
        return this.Z;
    }

    public Float I() {
        return this.C;
    }

    public boolean V() {
        return false;
    }

    public boolean Z() {
        return this.I;
    }
}
