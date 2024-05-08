package android.view.accessibility;

import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class AccessibilityNodeIdManager {
    private static AccessibilityNodeIdManager sIdManager;
    private WeakSparseArray<View> mIdsToViews = new WeakSparseArray<>();

    public static synchronized AccessibilityNodeIdManager getInstance() {
        AccessibilityNodeIdManager accessibilityNodeIdManager;
        synchronized (AccessibilityNodeIdManager.class) {
            if (sIdManager == null) {
                sIdManager = new AccessibilityNodeIdManager();
            }
            accessibilityNodeIdManager = sIdManager;
        }
        return accessibilityNodeIdManager;
    }

    private AccessibilityNodeIdManager() {
    }

    public void registerViewWithId(View view, int id2) {
        synchronized (this.mIdsToViews) {
            this.mIdsToViews.append(id2, view);
        }
    }

    public void unregisterViewWithId(int id2) {
        synchronized (this.mIdsToViews) {
            this.mIdsToViews.remove(id2);
        }
    }

    public View findView(int id2) {
        View view;
        synchronized (this.mIdsToViews) {
            view = this.mIdsToViews.get(id2);
        }
        if (view == null || !view.includeForAccessibility()) {
            return null;
        }
        return view;
    }
}
