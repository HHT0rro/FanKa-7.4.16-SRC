package com.huawei.quickcard.base.http;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class CardHttpClient {

    /* renamed from: a, reason: collision with root package name */
    private final Context f33353a;

    public CardHttpClient(Context context) {
        this.f33353a = context.getApplicationContext();
    }

    public void addNetworkInterceptor() {
    }

    public void connectTimeout(long j10, TimeUnit timeUnit) {
    }

    public Context getContext() {
        return this.f33353a;
    }

    public void readTimeout(long j10, TimeUnit timeUnit) {
    }

    public CardHttpResponse request(@NonNull CardHttpRequest cardHttpRequest) throws IOException {
        return null;
    }

    public void writeTimeout(long j10, TimeUnit timeUnit) {
    }
}
