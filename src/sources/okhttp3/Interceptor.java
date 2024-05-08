package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Interceptor.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Interceptor {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Interceptor.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Chain {
        @NotNull
        Call call();

        int connectTimeoutMillis();

        @Nullable
        Connection connection();

        @NotNull
        Response proceed(@NotNull Request request) throws IOException;

        int readTimeoutMillis();

        @NotNull
        Request request();

        @NotNull
        Chain withConnectTimeout(int i10, @NotNull TimeUnit timeUnit);

        @NotNull
        Chain withReadTimeout(int i10, @NotNull TimeUnit timeUnit);

        @NotNull
        Chain withWriteTimeout(int i10, @NotNull TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    /* compiled from: Interceptor.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        public final Interceptor invoke(@NotNull final Function1<? super Chain, Response> block) {
            s.i(block, "block");
            return new Interceptor() { // from class: okhttp3.Interceptor$Companion$invoke$1
                @Override // okhttp3.Interceptor
                @NotNull
                public final Response intercept(@NotNull Interceptor.Chain it) {
                    s.i(it, "it");
                    return (Response) Function1.this.invoke(it);
                }
            };
        }
    }

    @NotNull
    Response intercept(@NotNull Chain chain) throws IOException;
}
