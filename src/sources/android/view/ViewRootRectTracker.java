package android.view;

import android.graphics.Rect;
import com.android.internal.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ViewRootRectTracker {
    private final Function<View, List<Rect>> mRectCollector;
    private boolean mViewsChanged = false;
    private boolean mRootRectsChanged = false;
    private List<Rect> mRootRects = Collections.emptyList();
    private List<ViewInfo> mViewInfos = new ArrayList();
    private List<Rect> mRects = Collections.emptyList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewRootRectTracker(Function<View, List<Rect>> rectCollector) {
        this.mRectCollector = rectCollector;
    }

    public void updateRectsForView(View view) {
        boolean found = false;
        Iterator<ViewInfo> i10 = this.mViewInfos.iterator2();
        while (true) {
            if (!i10.hasNext()) {
                break;
            }
            ViewInfo info = i10.next();
            View v2 = info.getView();
            if (v2 == null || !v2.isAttachedToWindow() || !v2.isAggregatedVisible()) {
                this.mViewsChanged = true;
                i10.remove();
            } else if (v2 == view) {
                found = true;
                info.mDirty = true;
                break;
            }
        }
        if (!found && view.isAttachedToWindow()) {
            this.mViewInfos.add(new ViewInfo(view));
            this.mViewsChanged = true;
        }
    }

    public List<Rect> computeChangedRects() {
        if (computeChanges()) {
            return this.mRects;
        }
        return null;
    }

    public boolean computeChanges() {
        boolean changed = this.mRootRectsChanged;
        Iterator<ViewInfo> i10 = this.mViewInfos.iterator2();
        List<Rect> rects = new ArrayList<>(this.mRootRects);
        while (i10.hasNext()) {
            ViewInfo info = i10.next();
            switch (info.update()) {
                case 0:
                    changed = true;
                    break;
                case 2:
                    this.mViewsChanged = true;
                    i10.remove();
                    continue;
            }
            rects.addAll(info.mRects);
        }
        if (changed || this.mViewsChanged) {
            this.mViewsChanged = false;
            this.mRootRectsChanged = false;
            if (!this.mRects.equals(rects)) {
                this.mRects = rects;
                return true;
            }
        }
        return false;
    }

    public List<Rect> getLastComputedRects() {
        return this.mRects;
    }

    public void setRootRects(List<Rect> rects) {
        Preconditions.checkNotNull(rects, "rects must not be null");
        this.mRootRects = rects;
        this.mRootRectsChanged = true;
    }

    public List<Rect> getRootRects() {
        return this.mRootRects;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Rect> getTrackedRectsForView(View v2) {
        List<Rect> rects = this.mRectCollector.apply(v2);
        return rects == null ? Collections.emptyList() : rects;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ViewInfo {
        public static final int CHANGED = 0;
        public static final int GONE = 2;
        public static final int UNCHANGED = 1;
        boolean mDirty = true;
        List<Rect> mRects = Collections.emptyList();
        private final WeakReference<View> mView;

        ViewInfo(View view) {
            this.mView = new WeakReference<>(view);
        }

        public View getView() {
            return this.mView.get();
        }

        public int update() {
            View view = getView();
            if (view == null || !view.isAttachedToWindow() || !view.isAggregatedVisible()) {
                return 2;
            }
            List<Rect> localRects = ViewRootRectTracker.this.getTrackedRectsForView(view);
            List<Rect> newRects = new ArrayList<>(localRects.size());
            for (Rect src : localRects) {
                Rect mappedRect = new Rect(src);
                ViewParent p10 = view.getParent();
                if (p10 != null && p10.getChildVisibleRect(view, mappedRect, null)) {
                    newRects.add(mappedRect);
                }
            }
            if (this.mRects.equals(localRects)) {
                return 1;
            }
            this.mRects = newRects;
            return 0;
        }
    }
}
