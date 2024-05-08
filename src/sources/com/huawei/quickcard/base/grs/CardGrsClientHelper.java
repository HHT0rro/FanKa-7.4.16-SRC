package com.huawei.quickcard.base.grs;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsClient;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardGrsClientHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f33331a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile CardGrsClient f33332b;

    public static GrsClient getGrsClient(Context context) {
        GrsClient grsClient;
        synchronized (f33331a) {
            if (f33332b == null) {
                f33332b = new CardGrsClient(context, CardServerConfig.getServerCountry());
            }
            grsClient = f33332b.getGrsClient();
        }
        return grsClient;
    }

    public static void notifyCountryChanged(String str) {
        synchronized (f33331a) {
            if (f33332b != null) {
                f33332b.updateSerCountry(str);
            }
        }
    }
}
