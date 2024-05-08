package android.view;

import android.graphics.Canvas;
import android.graphics.Rect;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface SurfaceHolder {

    @Deprecated
    public static final int SURFACE_TYPE_GPU = 2;

    @Deprecated
    public static final int SURFACE_TYPE_HARDWARE = 1;

    @Deprecated
    public static final int SURFACE_TYPE_NORMAL = 0;

    @Deprecated
    public static final int SURFACE_TYPE_PUSH_BUFFERS = 3;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface Callback {
        void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12);

        void surfaceCreated(SurfaceHolder surfaceHolder);

        void surfaceDestroyed(SurfaceHolder surfaceHolder);
    }

    void addCallback(Callback callback);

    Surface getSurface();

    Rect getSurfaceFrame();

    boolean isCreating();

    Canvas lockCanvas();

    Canvas lockCanvas(Rect rect);

    void removeCallback(Callback callback);

    void setFixedSize(int i10, int i11);

    void setFormat(int i10);

    void setKeepScreenOn(boolean z10);

    void setSizeFromLayout();

    @Deprecated
    void setType(int i10);

    void unlockCanvasAndPost(Canvas canvas);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class BadSurfaceTypeException extends RuntimeException {
        public BadSurfaceTypeException() {
        }

        public BadSurfaceTypeException(String name) {
            super(name);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface Callback2 extends Callback {
        void surfaceRedrawNeeded(SurfaceHolder surfaceHolder);

        default void surfaceRedrawNeededAsync(SurfaceHolder holder, Runnable drawingFinished) {
            surfaceRedrawNeeded(holder);
            drawingFinished.run();
        }
    }

    default Canvas lockHardwareCanvas() {
        throw new IllegalStateException("This SurfaceHolder doesn't support lockHardwareCanvas");
    }
}
