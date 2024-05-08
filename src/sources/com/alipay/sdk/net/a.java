package com.alipay.sdk.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4614a = "msp";

    /* renamed from: b, reason: collision with root package name */
    private static final String f4615b = "application/octet-stream;binary/octet-stream";

    /* renamed from: c, reason: collision with root package name */
    private static final CookieManager f4616c = new CookieManager();

    /* renamed from: com.alipay.sdk.net.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class C0097a {

        /* renamed from: a, reason: collision with root package name */
        public final String f4617a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f4618b;

        /* renamed from: c, reason: collision with root package name */
        public final Map<String, String> f4619c;

        public C0097a(String str, Map<String, String> map, byte[] bArr) {
            this.f4617a = str;
            this.f4618b = bArr;
            this.f4619c = map;
        }

        public String toString() {
            return String.format("<UrlConnectionConfigure url=%s requestBody=%s headers=%s>", this.f4617a, this.f4618b, this.f4619c);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Map<String, List<String>> f4620a;

        /* renamed from: b, reason: collision with root package name */
        public final String f4621b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f4622c;

        public b(Map<String, List<String>> map, String str, byte[] bArr) {
            this.f4620a = map;
            this.f4621b = str;
            this.f4622c = bArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alipay.sdk.net.a.b a(android.content.Context r12, com.alipay.sdk.net.a.C0097a r13) {
        /*
            Method dump skipped, instructions count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.net.a.a(android.content.Context, com.alipay.sdk.net.a$a):com.alipay.sdk.net.a$b");
    }

    private static NetworkInfo b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    private static String c(Context context) {
        try {
            NetworkInfo b4 = b(context);
            if (b4 != null && b4.isAvailable()) {
                return b4.getType() == 1 ? "wifi" : b4.getExtraInfo().toLowerCase();
            }
        } catch (Exception unused) {
        }
        return "none";
    }

    private static Proxy a(Context context) {
        String c4 = c(context);
        if (c4 != null && !c4.contains("wap")) {
            return null;
        }
        try {
            String property = System.getProperty("https.proxyHost");
            String property2 = System.getProperty("https.proxyPort");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, Integer.parseInt(property2)));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
