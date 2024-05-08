package com.kwad.components.ad.feed.monitor;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
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
    public static Pair<Integer, String> d(@NonNull AdTemplate adTemplate) {
        String K = com.kwad.sdk.core.response.b.a.K(e.dQ(adTemplate));
        if (TextUtils.isEmpty(K)) {
            return new Pair<>(2, "empty videoUrl");
        }
        int yU = d.yU();
        String str = "";
        int i10 = 1;
        if (yU < 0) {
            File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(K);
            if (!q.L(bV)) {
                a.C0527a c0527a = new a.C0527a();
                int i11 = com.kwad.sdk.core.diskcache.b.a.Dc().a(K, c0527a) ? 1 : 2;
                str = c0527a.msg;
                i10 = i11;
            }
            adTemplate.setDownloadSize(bV != null ? bV.length() : 0L);
        } else if (yU > 0) {
            a.C0527a c0527a2 = new a.C0527a();
            f bl = com.kwad.sdk.core.videocache.c.a.bl(ServiceProvider.getContext());
            if (!bl.eC(K)) {
                i10 = bl.a(K, (long) (yU * 1024), c0527a2, null) ? 1 : 2;
            }
            str = c0527a2.msg;
            adTemplate.setDownloadSize(yU * 1024);
        } else {
            adTemplate.setDownloadSize(0L);
        }
        return new Pair<>(Integer.valueOf(i10), str);
    }
}
