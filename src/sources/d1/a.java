package d1;

import com.cupidapp.live.base.utils.j;
import java.io.IOException;
import kotlin.d;
import kotlin.jvm.internal.s;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import z3.c;

/* compiled from: ApmHttpInterceptor.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a implements Interceptor {
    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        s.i(chain, "chain");
        try {
            Response proceed = chain.proceed(chain.request());
            String httpUrl = proceed.request().url().toString();
            int code = proceed.code();
            ResponseBody body = proceed.body();
            long contentLength = body != null ? body.contentLength() : 0L;
            long receivedResponseAtMillis = proceed.receivedResponseAtMillis() - proceed.sentRequestAtMillis();
            if (proceed.isSuccessful()) {
                c.f54829a.a(httpUrl, code, "String", contentLength, receivedResponseAtMillis, "", null);
            } else {
                c.f54829a.a(httpUrl, code, "String", contentLength, receivedResponseAtMillis, "", new Exception("status code is " + code));
            }
            return proceed;
        } catch (Exception e2) {
            j.f12332a.c("ApmHttpInterceptor", "http intercept proceed exception:" + ((Object) e2));
            throw e2;
        }
    }
}
