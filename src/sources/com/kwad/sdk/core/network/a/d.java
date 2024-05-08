package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d implements Dns {
    private static final Dns SYSTEM = Dns.SYSTEM;

    @Override // okhttp3.Dns
    public final List<InetAddress> lookup(String str) {
        String fK = com.kwad.sdk.ip.direct.a.fK(str);
        if (!TextUtils.isEmpty(fK)) {
            List<InetAddress> asList = Arrays.asList(InetAddress.getAllByName(fK));
            if (asList != null && !asList.isEmpty()) {
                com.kwad.sdk.core.e.c.d("IpDirect_OkHttpDns", "inetAddresses:" + ((Object) asList));
                return asList;
            }
            return SYSTEM.lookup(str);
        }
        com.kwad.sdk.core.e.c.d("IpDirect_OkHttpDns", "Dns.SYSTEM.lookup(hostname):" + ((Object) Dns.SYSTEM.lookup(str)));
        return SYSTEM.lookup(str);
    }
}
