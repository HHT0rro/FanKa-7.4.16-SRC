package com.huawei.hms.ads;

import com.alibaba.security.common.track.model.TrackConstants;
import com.iab.omid.library.huawei.adsession.AdEvents;
import com.iab.omid.library.huawei.adsession.AdSession;
import com.iab.omid.library.huawei.adsession.media.VastProperties;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.hms.ads.if, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Cif extends ig implements ik {
    private static final String Code = "DisplayEventAgent";
    private static boolean V = ip.Code(ip.f29309e);
    private final List<AdEvents> I = new ArrayList();

    public static boolean Code() {
        return V;
    }

    @Override // com.huawei.hms.ads.ik
    public void Code(iz izVar) {
        if (izVar instanceof id) {
            List<AdSession> V2 = ((id) izVar).V();
            if (V2.isEmpty()) {
                return;
            }
            for (AdSession adSession : V2) {
                if (adSession != null) {
                    this.I.add(AdEvents.createAdEvents(adSession));
                }
            }
        }
    }

    @Override // com.huawei.hms.ads.ig, com.huawei.hms.ads.je
    public void Code(ji jiVar) {
        VastProperties C;
        gl.V(Code, "load vastPropertiesWrapper");
        if (jiVar == null || !ji.Code() || (C = jiVar.C()) == null) {
            return;
        }
        Code(C);
    }

    @Override // com.huawei.hms.ads.ig
    public void Code(VastProperties vastProperties) {
        if (this.I.isEmpty()) {
            return;
        }
        try {
            Iterator<AdEvents> iterator2 = this.I.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().loaded(vastProperties);
            }
        } catch (IllegalStateException unused) {
            gl.V(Code, "loaded, fail");
        }
    }

    @Override // com.huawei.hms.ads.ig, com.huawei.hms.ads.je
    public void D() {
        if (this.I.isEmpty()) {
            gl.I(Code, "impressionOccurred, mAdEventList isEmpty");
            return;
        }
        try {
            Iterator<AdEvents> iterator2 = this.I.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().impressionOccurred();
            }
        } catch (IllegalStateException unused) {
            gl.V(Code, "impressionOccurred, fail");
        }
    }

    @Override // com.huawei.hms.ads.ig, com.huawei.hms.ads.je
    public void L() {
        gl.V(Code, TrackConstants.Method.LOAD);
        if (this.I.isEmpty()) {
            gl.V(Code, "load, AdEventList isEmpty");
            return;
        }
        try {
            Iterator<AdEvents> iterator2 = this.I.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().loaded();
            }
        } catch (IllegalStateException unused) {
            gl.V(Code, "loaded, fail");
        }
    }

    @Override // com.huawei.hms.ads.ik
    public void V() {
        this.I.clear();
    }
}
