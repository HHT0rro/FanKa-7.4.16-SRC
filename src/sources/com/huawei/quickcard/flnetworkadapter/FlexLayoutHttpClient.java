package com.huawei.quickcard.flnetworkadapter;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.http.CardHttpClient;
import com.huawei.quickcard.base.http.CardHttpRequest;
import com.huawei.quickcard.base.http.CardHttpResponse;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.flnetworkadapter.b;
import com.huawei.quickcard.flnetworkadapter.c;
import com.huawei.serverrequest.api.Executor;
import com.huawei.serverrequest.api.ServerRequest;
import com.huawei.serverrequest.api.ServerResponse;
import com.huawei.serverrequest.api.service.HttpException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FlexLayoutHttpClient extends CardHttpClient {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33699a = "FlexLayoutHttpClient";

    public FlexLayoutHttpClient(Context context) {
        super(context);
    }

    @Override // com.huawei.quickcard.base.http.CardHttpClient
    public CardHttpResponse request(@NonNull CardHttpRequest cardHttpRequest) throws IOException {
        CardLogUtils.d(f33699a, "start request");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Task<ServerResponse> execute = Executor.execute(getContext(), b.a.b().f(cardHttpRequest.url()).a(new String(cardHttpRequest.body(), StandardCharsets.UTF_8)).a(cardHttpRequest.headers()).c(cardHttpRequest.contentType()).a(ServerRequest.RequestType.REQUEST_CACHE_OTHERWISE_SERVER).d(String.valueOf(cardHttpRequest.hashCode())).b(String.valueOf(cardHttpRequest.hashCode())).e(cardHttpRequest.method().getType()).a());
            c.a b4 = c.a.b();
            try {
                Tasks.await(execute, 30L, TimeUnit.SECONDS);
                ServerResponse result = execute.getResult();
                b4.b(result.getResponse().string());
                b4.a(result.getResponse().statusCode());
                b4.a(result.getResponse().statusMessage());
                b4.a(new LinkedHashMap(result.getResponse().headers()));
                CardLogUtils.d(f33699a, "request success");
            } catch (Exception e2) {
                CardLogUtils.e(f33699a, "request went error : " + e2.getMessage());
                if (e2 instanceof HttpException) {
                    b4.a(((HttpException) e2).code);
                }
                b4.a(e2.getMessage());
            }
            return b4.a();
        }
        throw new IllegalStateException("request function should not call in main thread!");
    }
}
