package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private static d b(Context context, boolean z10, boolean z11) {
        String str;
        try {
            if (!b.isWifiConnected(context)) {
                return new d("", false, "");
            }
            String er = b.er(((WifiManager) context.getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway);
            if (z10) {
                str = "";
            } else {
                str = a.hp("timeout 5 ip neigh show " + er);
            }
            if (z10 || TextUtils.isEmpty(str)) {
                str = KwaiIpNeigh.i(er, false);
            }
            String hr = b.hr(str);
            return new d(hr, !TextUtils.isEmpty(hr), str);
        } catch (Throwable th) {
            return new d("", false, th.getMessage());
        }
    }

    public static d dw(Context context) {
        return y(context, false);
    }

    private static d y(Context context, boolean z10) {
        return b(context, false, false);
    }
}
