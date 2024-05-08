package android.view.accessibility;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class AccessibilityRequestPreparer {
    public static final int REQUEST_TYPE_EXTRA_DATA = 1;
    private final int mAccessibilityViewId;
    private final int mRequestTypes;
    private final WeakReference<View> mViewRef;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface RequestTypes {
    }

    public abstract void onPrepareExtraData(int i10, String str, Bundle bundle, Message message);

    public AccessibilityRequestPreparer(View view, int requestTypes) {
        if (!view.isAttachedToWindow()) {
            throw new IllegalStateException("View must be attached to a window");
        }
        this.mViewRef = new WeakReference<>(view);
        this.mAccessibilityViewId = view.getAccessibilityViewId();
        this.mRequestTypes = requestTypes;
        view.addOnAttachStateChangeListener(new ViewAttachStateListener());
    }

    public View getView() {
        return this.mViewRef.get();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class ViewAttachStateListener implements View.OnAttachStateChangeListener {
        private ViewAttachStateListener() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v2) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v2) {
            Context context = v2.getContext();
            if (context != null) {
                ((AccessibilityManager) context.getSystemService(AccessibilityManager.class)).removeAccessibilityRequestPreparer(AccessibilityRequestPreparer.this);
            }
            v2.removeOnAttachStateChangeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAccessibilityViewId() {
        return this.mAccessibilityViewId;
    }
}
