package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

/* compiled from: PushObserver.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface PushObserver {
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final PushObserver CANCEL = new Companion.PushObserverCancel();

    /* compiled from: PushObserver.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = null;

        /* compiled from: PushObserver.kt */
        @d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class PushObserverCancel implements PushObserver {
            @Override // okhttp3.internal.http2.PushObserver
            public boolean onData(int i10, @NotNull BufferedSource source, int i11, boolean z10) throws IOException {
                s.i(source, "source");
                source.skip(i11);
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onHeaders(int i10, @NotNull List<Header> responseHeaders, boolean z10) {
                s.i(responseHeaders, "responseHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onRequest(int i10, @NotNull List<Header> requestHeaders) {
                s.i(requestHeaders, "requestHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public void onReset(int i10, @NotNull ErrorCode errorCode) {
                s.i(errorCode, "errorCode");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    boolean onData(int i10, @NotNull BufferedSource bufferedSource, int i11, boolean z10) throws IOException;

    boolean onHeaders(int i10, @NotNull List<Header> list, boolean z10);

    boolean onRequest(int i10, @NotNull List<Header> list);

    void onReset(int i10, @NotNull ErrorCode errorCode);
}
