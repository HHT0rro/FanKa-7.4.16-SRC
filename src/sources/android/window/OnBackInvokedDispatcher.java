package android.window;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface OnBackInvokedDispatcher {
    public static final boolean DEBUG = false;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_OVERLAY = 1000000;
    public static final int PRIORITY_SYSTEM = -1;
    public static final String TAG = "OnBackInvokedDispatcher";

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface Priority {
    }

    void registerOnBackInvokedCallback(int i10, OnBackInvokedCallback onBackInvokedCallback);

    void unregisterOnBackInvokedCallback(OnBackInvokedCallback onBackInvokedCallback);

    default void registerSystemOnBackInvokedCallback(OnBackInvokedCallback callback) {
    }

    default void setImeOnBackInvokedDispatcher(ImeOnBackInvokedDispatcher imeDispatcher) {
    }
}
