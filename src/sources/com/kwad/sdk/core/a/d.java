package com.kwad.sdk.core.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    private static g auZ;

    public static void a(String str, Map<String, String> map, String str2) {
        ox().a(str, map, str2);
    }

    public static String al(String str) {
        return ox().al(str);
    }

    public static void f(@NonNull Map<String, String> map) {
        ox().f(map);
    }

    public static String getResponseData(String str) {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return ox().getResponseData(str);
    }

    private static g ox() {
        g gVar = auZ;
        if (gVar != null) {
            return gVar;
        }
        com.kwad.sdk.components.g gVar2 = (com.kwad.sdk.components.g) com.kwad.sdk.components.c.f(com.kwad.sdk.components.g.class);
        if (gVar2 != null) {
            gVar2.ox();
            auZ = gVar2.ox();
        } else {
            auZ = new a();
        }
        return auZ;
    }
}
