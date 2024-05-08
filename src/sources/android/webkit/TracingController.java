package android.webkit;

import java.io.OutputStream;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class TracingController {
    public abstract boolean isTracing();

    public abstract void start(TracingConfig tracingConfig);

    public abstract boolean stop(OutputStream outputStream, Executor executor);

    @Deprecated
    public TracingController() {
    }

    public static TracingController getInstance() {
        return WebViewFactory.getProvider().getTracingController();
    }
}
