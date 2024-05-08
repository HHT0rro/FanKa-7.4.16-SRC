package android.view;

import android.graphics.Rect;
import android.os.CancellationSignal;
import java.util.function.Consumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ScrollCaptureCallback {
    void onScrollCaptureEnd(Runnable runnable);

    void onScrollCaptureImageRequest(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Rect rect, Consumer<Rect> consumer);

    void onScrollCaptureSearch(CancellationSignal cancellationSignal, Consumer<Rect> consumer);

    void onScrollCaptureStart(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Runnable runnable);
}
