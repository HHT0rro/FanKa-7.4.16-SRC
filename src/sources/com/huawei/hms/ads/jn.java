package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.Position;
import com.iab.omid.library.huawei.adsession.media.VastProperties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class jn implements ja {
    private static boolean Code = ip.Code("com.iab.omid.library.huawei.adsession.media.VastProperties");
    private final jm B;
    private Float C;
    private final boolean I;
    private final boolean V;
    private final VastProperties Z;

    private jn(float f10, boolean z10, jm jmVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.C = Float.valueOf(f10);
        this.I = z10;
        this.B = jmVar;
        this.Z = vastProperties;
    }

    private jn(boolean z10, jm jmVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.I = z10;
        this.B = jmVar;
        this.Z = vastProperties;
    }

    public static jn Code(float f10, boolean z10, jm jmVar) {
        Position Code2;
        return new jn(f10, z10, jmVar, (jmVar == null || !Code() || (Code2 = jm.Code(jmVar)) == null) ? null : VastProperties.createVastPropertiesForSkippableMedia(f10, z10, Code2));
    }

    public static jn Code(boolean z10, jm jmVar) {
        Position Code2;
        VastProperties vastProperties = null;
        if (!Code) {
            return null;
        }
        if (jmVar != null && jm.Code() && (Code2 = jm.Code(jmVar)) != null) {
            vastProperties = VastProperties.createVastPropertiesForNonSkippableMedia(z10, Code2);
        }
        return new jn(z10, jmVar, vastProperties);
    }

    public static boolean Code() {
        return Code;
    }

    public VastProperties V() {
        return this.Z;
    }
}
