package com.huawei.quickcard.okhttp;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.http.CardHttpClient;
import com.huawei.quickcard.base.http.CardHttpRequest;
import com.huawei.quickcard.base.http.CardHttpResponse;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.okhttp.b;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import xa.d;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardOkHttpClient extends CardHttpClient {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34146a = "QOkHttpClient";

    /* renamed from: b, reason: collision with root package name */
    private static final String f34147b = "com.huawei.fastapp.inspector.quickcard.networkInterceptor";

    /* renamed from: c, reason: collision with root package name */
    private static final OkHttpClient.Builder f34148c = new OkHttpClient.Builder();

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f34149d = 0;

    public CardOkHttpClient(Context context) {
        super(context);
        a();
    }

    private void a() {
        try {
            OkHttpClient.Builder builder = f34148c;
            builder.sslSocketFactory(xa.b.b(getContext()), d.a(getContext()));
            builder.hostnameVerifier(new ya.b());
        } catch (Exception e2) {
            CardLogUtils.e(f34146a, "init http ssl socket failed:." + e2.getMessage());
        }
    }

    @Nullable
    private MediaType b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return MediaType.parse(str);
    }

    @Override // com.huawei.quickcard.base.http.CardHttpClient
    public void addNetworkInterceptor() {
        Interceptor a10 = a(a(getContext()));
        if (a10 != null) {
            f34148c.addInterceptor(a10);
        }
    }

    @Override // com.huawei.quickcard.base.http.CardHttpClient
    public void connectTimeout(long j10, TimeUnit timeUnit) {
        f34148c.connectTimeout(j10, timeUnit);
    }

    @Override // com.huawei.quickcard.base.http.CardHttpClient
    public void readTimeout(long j10, TimeUnit timeUnit) {
        f34148c.readTimeout(j10, timeUnit);
    }

    @Override // com.huawei.quickcard.base.http.CardHttpClient
    public CardHttpResponse request(@NonNull CardHttpRequest cardHttpRequest) throws IOException {
        OkHttpClient build = f34148c.build();
        Request.Builder builder = new Request.Builder();
        a(builder, cardHttpRequest.headers());
        Response execute = build.newCall(builder.method(cardHttpRequest.method().getType(), a(cardHttpRequest.contentType(), cardHttpRequest.body())).url(cardHttpRequest.url()).build()).execute();
        if (execute.body() != null) {
            return b.a.b().a(execute.code()).a(execute.message()).a(a(execute.headers())).b(execute.body().string()).a();
        }
        return null;
    }

    @Override // com.huawei.quickcard.base.http.CardHttpClient
    public void writeTimeout(long j10, TimeUnit timeUnit) {
        f34148c.writeTimeout(j10, timeUnit);
    }

    private Map<String, Object> a(@NonNull Headers headers) {
        HashMap hashMap = new HashMap();
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            hashMap.put(headers.name(i10), headers.value(i10));
        }
        return hashMap;
    }

    private RequestBody a(@Nullable String str, @Nullable byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        return RequestBody.create(b(str), bArr);
    }

    private void a(Request.Builder builder, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.removeHeader(entry.getKey());
            builder.addHeader(entry.getKey(), entry.getValue());
        }
    }

    private static String a(@NonNull Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                return bundle.getString(f34147b);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static Interceptor a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        CardLogUtils.i(f34146a, "find cls name:" + str);
        try {
            Object newInstance = Class.forName(str).newInstance();
            if (newInstance instanceof Interceptor) {
                return (Interceptor) newInstance;
            }
            return null;
        } catch (Exception e2) {
            CardLogUtils.w(f34146a, "make interceptor exception", e2);
            return null;
        }
    }
}
