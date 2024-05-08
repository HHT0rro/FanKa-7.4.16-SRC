package android.webkit;

import android.annotation.SystemApi;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class JsResult {
    private final ResultReceiver mReceiver;
    private boolean mResult;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @SystemApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface ResultReceiver {
        void onJsResultComplete(JsResult jsResult);
    }

    public final void cancel() {
        this.mResult = false;
        wakeUp();
    }

    public final void confirm() {
        this.mResult = true;
        wakeUp();
    }

    @SystemApi
    public JsResult(ResultReceiver receiver) {
        this.mReceiver = receiver;
    }

    @SystemApi
    public final boolean getResult() {
        return this.mResult;
    }

    private final void wakeUp() {
        this.mReceiver.onJsResultComplete(this);
    }
}
