package com.cupidapp.live.base.network;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.s;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: DynamicTimeoutInterceptor.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final List<String> f11921a = s.m("/file/upload/image/v2", "/file/upload/video", "/inbox/send/image/v3", "/inbox/send/snapImage/v3");

    public final boolean a(String str) {
        Iterator<String> iterator2 = this.f11921a.iterator2();
        while (iterator2.hasNext()) {
            if (StringsKt__StringsKt.K(str, iterator2.next(), false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        kotlin.jvm.internal.s.i(chain, "chain");
        Request request = chain.request();
        if (a(request.url().toString())) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            return chain.withConnectTimeout(60, timeUnit).withReadTimeout(60, timeUnit).withWriteTimeout(60, timeUnit).proceed(request);
        }
        return chain.proceed(request);
    }
}
