package com.kwad.components.core.s;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j {
    public static boolean d(@NonNull AdTemplate adTemplate, boolean z10) {
        if (!z10 && com.kwad.sdk.core.response.b.b.dj(com.kwad.sdk.core.response.b.e.dQ(adTemplate))) {
            return com.kwad.sdk.core.config.d.CD();
        }
        return false;
    }

    public static void e(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        com.kwad.components.core.e.d.a.a(new a.C0461a(context).am(true).aq(adTemplate));
    }
}
