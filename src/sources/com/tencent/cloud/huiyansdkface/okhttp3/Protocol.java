package com.tencent.cloud.huiyansdkface.okhttp3;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* renamed from: g, reason: collision with root package name */
    private final String f41524g;

    Protocol(String str) {
        this.f41524g = str;
    }

    public static Protocol get(String str) throws IOException {
        Protocol protocol = HTTP_1_0;
        if (str.equals(protocol.f41524g)) {
            return protocol;
        }
        Protocol protocol2 = HTTP_1_1;
        if (str.equals(protocol2.f41524g)) {
            return protocol2;
        }
        Protocol protocol3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(protocol3.f41524g)) {
            return protocol3;
        }
        Protocol protocol4 = HTTP_2;
        if (str.equals(protocol4.f41524g)) {
            return protocol4;
        }
        Protocol protocol5 = SPDY_3;
        if (str.equals(protocol5.f41524g)) {
            return protocol5;
        }
        Protocol protocol6 = QUIC;
        if (str.equals(protocol6.f41524g)) {
            return protocol6;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f41524g;
    }
}
