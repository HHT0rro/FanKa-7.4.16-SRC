package com.alibaba.security.common.http.ok;

import com.alibaba.security.common.http.ok.internal.Util;
import com.alibaba.security.common.http.okio.ByteString;
import com.huawei.openalliance.ad.constant.u;
import java.nio.charset.Charset;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2) {
        return basic(str, str2, Util.ISO_8859_1);
    }

    public static String basic(String str, String str2, Charset charset) {
        return "Basic " + ByteString.encodeString(str + u.bD + str2, charset).base64();
    }
}
