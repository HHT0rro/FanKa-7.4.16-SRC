package android.view;

import android.graphics.RecordingCanvas;
import android.graphics.Rect;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface WindowCallbacks {
    boolean onContentDrawn(int i10, int i11, int i12, int i13);

    void onPostDraw(RecordingCanvas recordingCanvas);

    void onRequestDraw(boolean z10);

    void onWindowDragResizeEnd();

    void onWindowDragResizeStart(Rect rect, boolean z10, Rect rect2, Rect rect3);

    void onWindowSizeIsChanging(Rect rect, boolean z10, Rect rect2, Rect rect3);
}
