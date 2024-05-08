package com.kwad.components.ad.reward;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class n {
    public static void a(int i10, int i11, g gVar, com.kwad.components.ad.reward.model.c cVar) {
        if (i10 == 0) {
            com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 1);
            return;
        }
        if (i10 == 1) {
            if (i11 == 0) {
                if (gVar.pr.jB()) {
                    com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 1);
                    return;
                }
                return;
            } else if (gVar.pr.jB()) {
                com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 5);
                return;
            } else {
                com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 4);
                return;
            }
        }
        if (i10 != 2) {
            return;
        }
        if (i11 == 0) {
            if (gVar.pq.jB()) {
                com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 1);
            }
        } else if (gVar.pq.jB()) {
            com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 3);
        } else {
            com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 2);
        }
    }
}
