package io.grpc.okhttp.internal;

import com.huawei.openalliance.ad.constant.u;
import java.io.UnsupportedEncodingException;
import okio.ByteString;
import org.apache.commons.lang3.CharEncoding;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2) {
        try {
            return "Basic " + ByteString.of((str + u.bD + str2).getBytes(CharEncoding.ISO_8859_1)).base64();
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }
}
