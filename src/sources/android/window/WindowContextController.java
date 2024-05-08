package android.window;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class WindowContextController {
    private static final boolean DEBUG_ATTACH = false;
    private static final String TAG = "WindowContextController";
    public int mAttachedToDisplayArea = 0;
    private final WindowTokenClient mToken;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface AttachStatus {
        public static final int STATUS_ATTACHED = 1;
        public static final int STATUS_DETACHED = 2;
        public static final int STATUS_FAILED = 3;
        public static final int STATUS_INITIALIZED = 0;
    }

    public WindowContextController(WindowTokenClient token) {
        this.mToken = token;
    }

    public void attachToDisplayArea(int type, int displayId, Bundle options) {
        if (this.mAttachedToDisplayArea == 1) {
            throw new IllegalStateException("A Window Context can be only attached to a DisplayArea once.");
        }
        int i10 = this.mToken.attachToDisplayArea(type, displayId, options) ? 1 : 3;
        this.mAttachedToDisplayArea = i10;
        if (i10 == 3) {
            Log.w(TAG, "attachToDisplayArea fail, type:" + type + ", displayId:" + displayId);
        }
    }

    public void attachToWindowToken(IBinder windowToken) {
        if (this.mAttachedToDisplayArea != 1) {
            throw new IllegalStateException("The Window Context should have been attached to a DisplayArea. AttachToDisplayArea:" + this.mAttachedToDisplayArea);
        }
        this.mToken.attachToWindowToken(windowToken);
    }

    public void detachIfNeeded() {
        if (this.mAttachedToDisplayArea == 1) {
            this.mToken.detachFromWindowContainerIfNeeded();
            this.mAttachedToDisplayArea = 2;
        }
    }
}
