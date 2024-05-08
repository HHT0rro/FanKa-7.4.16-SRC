package com.huawei.quickcard.cardmanager;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.quickcard.cardmanager.bean.BatchParams;
import com.huawei.quickcard.cardmanager.config.VersionUtils;
import com.huawei.quickcard.cardmanager.http.CardServerUtil;
import com.huawei.quickcard.cardmanager.http.ManagerHttpClientUtil;
import com.huawei.quickcard.cardmanager.http.ManagerHttpRequest;
import com.huawei.quickcard.cardmanager.http.ManagerHttpResponse;
import com.huawei.quickcard.cardmanager.http.ServerConfigUtil;
import com.huawei.quickcard.cardmanager.log.ManagerLogUtil;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static final String f33537b = "CardStoreServer";

    /* renamed from: c, reason: collision with root package name */
    public static final String f33538c = "User-Agent";

    /* renamed from: d, reason: collision with root package name */
    public static final String f33539d = "application/x-www-form-urlencoded";

    /* renamed from: a, reason: collision with root package name */
    public final Context f33540a;

    public d(Context context) {
        this.f33540a = context;
    }

    public static String b(Context context) {
        return a.a(context);
    }

    public ManagerHttpResponse a(@NonNull String str, @NonNull Map<String, String> map) throws IOException {
        byte[] a10 = a(map);
        if (a10.length <= 0) {
            ManagerLogUtil.e(f33537b, "parse Post Body fail please check params !");
            return null;
        }
        ManagerHttpRequest managerHttpRequest = new ManagerHttpRequest();
        managerHttpRequest.setUrl(str);
        managerHttpRequest.setBody(a10);
        managerHttpRequest.setMethod("POST");
        managerHttpRequest.setContentType("application/x-www-form-urlencoded");
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", b(this.f33540a));
        hashMap.putAll(ServerConfigUtil.getPostHeaders());
        managerHttpRequest.setHeaders(hashMap);
        return ManagerHttpClientUtil.request(this.f33540a, managerHttpRequest);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final String f33541a = "QuickCard";

        /* renamed from: b, reason: collision with root package name */
        private static final String f33542b = "##";

        /* renamed from: c, reason: collision with root package name */
        private static final String f33543c = "unknown";

        /* renamed from: d, reason: collision with root package name */
        private static final String f33544d = "other";

        /* renamed from: e, reason: collision with root package name */
        private static volatile String f33545e;

        private a() {
        }

        public static String a(Context context) {
            if (f33545e == null) {
                f33545e = "QuickCard##" + VersionUtils.getSdkVersionName() + f33542b + a() + f33542b + Build.MODEL;
            }
            ManagerLogUtil.i(d.f33537b, "UABuilder user agent: " + f33545e);
            return f33545e;
        }

        private static String a() {
            String str = Build.BRAND;
            return (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str)) ? "other" : str;
        }
    }

    public static String a(Context context) {
        return CardServerUtil.getPostUrl(context);
    }

    public byte[] a(Map<String, String> map) {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                if (sb2.length() > 0) {
                    sb2.append("&");
                }
                sb2.append(entry.getKey());
                sb2.append("=");
                sb2.append(entry.getValue());
            }
        }
        return TextUtils.isEmpty(sb2) ? new byte[0] : sb2.toString().getBytes(StandardCharsets.UTF_8);
    }

    public ManagerHttpResponse a(String str, BatchParams batchParams) throws IOException {
        byte[] a10 = a(batchParams);
        if (a10.length <= 0) {
            ManagerLogUtil.e(f33537b, "parse batch body fail please check batch params !");
            return null;
        }
        ManagerHttpRequest managerHttpRequest = new ManagerHttpRequest();
        managerHttpRequest.setUrl(str);
        managerHttpRequest.setBody(a10);
        managerHttpRequest.setMethod("POST");
        managerHttpRequest.setContentType("application/x-www-form-urlencoded");
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", b(this.f33540a));
        managerHttpRequest.setHeaders(hashMap);
        return ManagerHttpClientUtil.request(this.f33540a, managerHttpRequest);
    }

    private byte[] a(BatchParams batchParams) {
        String[] uris = batchParams.getUris();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("method=quickCard.download.batch&maxSize=");
        sb2.append(batchParams.getMaxSize());
        try {
            for (String str : uris) {
                sb2.append("&uris=");
                sb2.append(URLEncoder.encode(str, "utf-8"));
            }
            return sb2.toString().getBytes(StandardCharsets.UTF_8);
        } catch (Exception e2) {
            ManagerLogUtil.e(f33537b, e2.getMessage());
            return new byte[0];
        }
    }
}
