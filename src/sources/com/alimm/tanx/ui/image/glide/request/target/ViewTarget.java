package com.alimm.tanx.ui.image.glide.request.target;

import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.alimm.tanx.ui.image.glide.request.Request;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import nd.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    public static final String TAG = "ViewTarget";
    public static boolean isTagUsedAtLeastOnce;
    public static Integer tagId;
    public final SizeDeterminer sizeDeterminer;
    public final T view;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class SizeDeterminer {
        public static final int PENDING_SIZE = 0;
        public final List<SizeReadyCallback> cbs = new ArrayList();
        public Point displayDimens;
        public SizeDeterminerLayoutListener layoutListener;
        public final View view;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public static class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
            public final WeakReference<SizeDeterminer> sizeDeterminerRef;

            public SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.sizeDeterminerRef = new WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(ViewTarget.TAG, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("OnGlobalLayoutListener called listener=");
                    sb2.append((Object) this);
                }
                SizeDeterminer sizeDeterminer = this.sizeDeterminerRef.get();
                if (sizeDeterminer == null) {
                    return true;
                }
                sizeDeterminer.checkCurrentDimens();
                return true;
            }
        }

        public SizeDeterminer(View view) {
            this.view = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkCurrentDimens() {
            if (this.cbs.isEmpty()) {
                return;
            }
            int viewWidthOrParam = getViewWidthOrParam();
            int viewHeightOrParam = getViewHeightOrParam();
            if (isSizeValid(viewWidthOrParam) && isSizeValid(viewHeightOrParam)) {
                notifyCbs(viewWidthOrParam, viewHeightOrParam);
                ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.layoutListener);
                }
                this.layoutListener = null;
            }
        }

        private Point getDisplayDimens() {
            Point point = this.displayDimens;
            if (point != null) {
                return point;
            }
            Display defaultDisplay = ((WindowManager) this.view.getContext().getSystemService("window")).getDefaultDisplay();
            Point point2 = new Point();
            this.displayDimens = point2;
            defaultDisplay.getSize(point2);
            return this.displayDimens;
        }

        private int getSizeForParam(int i10, boolean z10) {
            if (i10 != -2) {
                return i10;
            }
            Point displayDimens = getDisplayDimens();
            return z10 ? displayDimens.y : displayDimens.x;
        }

        private int getViewHeightOrParam() {
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (isSizeValid(this.view.getHeight())) {
                return this.view.getHeight();
            }
            if (layoutParams != null) {
                return getSizeForParam(layoutParams.height, true);
            }
            return 0;
        }

        private int getViewWidthOrParam() {
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (isSizeValid(this.view.getWidth())) {
                return this.view.getWidth();
            }
            if (layoutParams != null) {
                return getSizeForParam(layoutParams.width, false);
            }
            return 0;
        }

        private boolean isSizeValid(int i10) {
            return i10 > 0 || i10 == -2;
        }

        private void notifyCbs(int i10, int i11) {
            Iterator<SizeReadyCallback> iterator2 = this.cbs.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onSizeReady(i10, i11);
            }
            this.cbs.clear();
        }

        public void getSize(SizeReadyCallback sizeReadyCallback) {
            int viewWidthOrParam = getViewWidthOrParam();
            int viewHeightOrParam = getViewHeightOrParam();
            if (isSizeValid(viewWidthOrParam) && isSizeValid(viewHeightOrParam)) {
                sizeReadyCallback.onSizeReady(viewWidthOrParam, viewHeightOrParam);
                return;
            }
            if (!this.cbs.contains(sizeReadyCallback)) {
                this.cbs.add(sizeReadyCallback);
            }
            if (this.layoutListener == null) {
                ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                this.layoutListener = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }
    }

    public ViewTarget(T t2) {
        Objects.requireNonNull(t2, "View must not be null!");
        this.view = t2;
        this.sizeDeterminer = new SizeDeterminer(t2);
    }

    private Object getTag() {
        Integer num = tagId;
        if (num == null) {
            return this.view.getTag();
        }
        return this.view.getTag(num.intValue());
    }

    private void setTag(Object obj) {
        Integer num = tagId;
        if (num == null) {
            isTagUsedAtLeastOnce = true;
            this.view.setTag(obj);
        } else {
            this.view.setTag(num.intValue(), obj);
        }
    }

    public static void setTagId(int i10) {
        if (tagId == null && !isTagUsedAtLeastOnce) {
            tagId = Integer.valueOf(i10);
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
    public Request getRequest() {
        Object tag = getTag();
        if (tag == null) {
            return null;
        }
        if (tag instanceof Request) {
            return (Request) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void getSize(SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.getSize(sizeReadyCallback);
    }

    public T getView() {
        return this.view;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
    public void setRequest(Request request) {
        setTag(request);
    }

    public String toString() {
        StringBuilder a10 = a.a("Target for: ");
        a10.append((Object) this.view);
        return a10.toString();
    }
}
