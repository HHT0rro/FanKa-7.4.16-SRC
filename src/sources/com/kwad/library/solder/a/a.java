package com.kwad.library.solder.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.b.c;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    public static void a(Context context, @NonNull b bVar, b.c cVar) {
        i.xe().a(context, new c(bVar), cVar);
    }

    public static com.kwad.library.b.a i(Context context, String str) {
        com.kwad.library.solder.lib.a.a k10 = i.xe().k(context, str);
        if (k10 != null && k10.isLoaded() && (k10 instanceof com.kwad.library.b.a)) {
            return (com.kwad.library.b.a) k10;
        }
        return null;
    }

    public static void j(Context context, String str) {
        i.xe().j(context, str);
    }

    public static void a(Context context, @NonNull com.kwad.library.solder.lib.c.b bVar, b.a aVar) {
        i.xe().a(context, new com.kwad.library.solder.lib.b.a(bVar), aVar);
    }
}
