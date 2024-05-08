package com.kwad.components.ad.interstitial.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.interstitial.report.b;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.q;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a {
    public static boolean j(@NonNull AdTemplate adTemplate) {
        boolean z10;
        f bl;
        String K = com.kwad.sdk.core.response.b.a.K(e.dQ(adTemplate));
        if (TextUtils.isEmpty(K)) {
            b.dO().b(adTemplate, "empty videoUrl");
            return false;
        }
        b.dO().o(adTemplate);
        int yU = d.yU();
        String str = "";
        if (yU < 0) {
            File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(K);
            if (q.L(bV)) {
                z10 = true;
            } else {
                a.C0527a c0527a = new a.C0527a();
                z10 = com.kwad.sdk.core.diskcache.b.a.Dc().a(K, c0527a);
                str = c0527a.msg;
            }
            adTemplate.setDownloadSize(bV != null ? bV.length() : 0L);
            adTemplate.setDownloadType(2);
        } else if (yU > 0) {
            a.C0527a c0527a2 = new a.C0527a();
            if (d.CE() == 1) {
                bl = com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 0);
            } else if (d.CE() == 2) {
                bl = com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 1);
            } else {
                bl = com.kwad.sdk.core.videocache.c.a.bl(ServiceProvider.getContext());
            }
            z10 = !bl.eC(K) ? bl.a(K, yU * 1024, c0527a2, null) : true;
            str = c0527a2.msg;
            adTemplate.setDownloadSize(yU * 1024);
            adTemplate.setDownloadType(3);
        } else {
            adTemplate.setDownloadSize(0L);
            adTemplate.setDownloadType(1);
            z10 = true;
        }
        if (!z10) {
            adTemplate.setDownloadStatus(2);
            b.dO().b(adTemplate, str);
            com.kwad.components.ad.interstitial.report.realtime.a.dU();
            com.kwad.components.ad.interstitial.report.realtime.a.b(str, adTemplate);
        } else {
            adTemplate.setDownloadStatus(1);
        }
        return z10;
    }
}
