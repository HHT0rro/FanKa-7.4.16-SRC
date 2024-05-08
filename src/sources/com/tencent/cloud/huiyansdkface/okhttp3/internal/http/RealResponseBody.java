package com.tencent.cloud.huiyansdkface.okhttp3.internal.http;

import com.tencent.cloud.huiyansdkface.okhttp3.MediaType;
import com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class RealResponseBody extends ResponseBody {

    /* renamed from: a, reason: collision with root package name */
    private final String f41776a;

    /* renamed from: b, reason: collision with root package name */
    private final long f41777b;

    /* renamed from: c, reason: collision with root package name */
    private final BufferedSource f41778c;

    public RealResponseBody(String str, long j10, BufferedSource bufferedSource) {
        this.f41776a = str;
        this.f41777b = j10;
        this.f41778c = bufferedSource;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
    public long contentLength() {
        return this.f41777b;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
    public MediaType contentType() {
        String str = this.f41776a;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
    public BufferedSource source() {
        return this.f41778c;
    }
}
