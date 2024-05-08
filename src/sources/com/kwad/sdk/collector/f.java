package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.am;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {
    @Nullable
    public static JSONArray Ay() {
        Context context = ServiceProvider.getContext();
        List<g> aL = aL(context);
        aL.add(aK(context));
        return g.t(aL);
    }

    private static g aK(Context context) {
        boolean cr = am.cr(context);
        com.kwad.sdk.core.e.c.d("InfoCollector", "queryAccessibilityServicePermission result: " + cr);
        return new g(com.kuaishou.weapon.p0.g.f36125k, cr ? g.PERMISSION_GRANTED : g.PERMISSION_DENIED);
    }

    @NonNull
    private static List<g> aL(Context context) {
        String[] cq;
        int i10;
        ArrayList arrayList = new ArrayList();
        if (context != null && (cq = aj.cq(context)) != null) {
            for (String str : cq) {
                int aq = am.aq(context, str);
                if (aq == 0) {
                    i10 = g.PERMISSION_GRANTED;
                } else if (aq == -1) {
                    i10 = g.PERMISSION_DENIED;
                } else {
                    i10 = g.anC;
                }
                arrayList.add(new g(str, i10));
            }
        }
        return arrayList;
    }
}
