package android.view;

import android.graphics.Rect;
import android.os.CancellationSignal;
import android.util.IndentingPrintWriter;
import android.view.ScrollCaptureSearchResults;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class ScrollCaptureSearchResults {
    private static final int AFTER = 1;
    private static final int BEFORE = -1;
    private static final int EQUAL = 0;
    static final Comparator<ScrollCaptureTarget> PRIORITY_ORDER = new Comparator() { // from class: android.view.ScrollCaptureSearchResults$$ExternalSyntheticLambda1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ScrollCaptureSearchResults.lambda$static$1((ScrollCaptureTarget) obj, (ScrollCaptureTarget) obj2);
        }
    };
    private int mCompleted;
    private final Executor mExecutor;
    private Runnable mOnCompleteListener;
    private boolean mComplete = true;
    private final List<ScrollCaptureTarget> mTargets = new ArrayList();
    private final CancellationSignal mCancel = new CancellationSignal();

    public ScrollCaptureSearchResults(Executor executor) {
        this.mExecutor = executor;
    }

    public void addTarget(ScrollCaptureTarget target) {
        Objects.requireNonNull(target);
        this.mTargets.add(target);
        this.mComplete = false;
        final ScrollCaptureCallback callback = target.getCallback();
        final Consumer<Rect> consumer = new SearchRequest(target);
        this.mExecutor.execute(new Runnable() { // from class: android.view.ScrollCaptureSearchResults$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ScrollCaptureSearchResults.this.lambda$addTarget$0(callback, consumer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addTarget$0(ScrollCaptureCallback callback, Consumer consumer) {
        callback.onScrollCaptureSearch(this.mCancel, consumer);
    }

    public boolean isComplete() {
        return this.mComplete;
    }

    public void setOnCompleteListener(Runnable onComplete) {
        if (this.mComplete) {
            onComplete.run();
        } else {
            this.mOnCompleteListener = onComplete;
        }
    }

    public boolean isEmpty() {
        return this.mTargets.isEmpty();
    }

    public void finish() {
        if (!this.mComplete) {
            this.mCancel.cancel();
            signalComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signalComplete() {
        this.mComplete = true;
        this.mTargets.sort(PRIORITY_ORDER);
        Runnable runnable = this.mOnCompleteListener;
        if (runnable != null) {
            runnable.run();
            this.mOnCompleteListener = null;
        }
    }

    public List<ScrollCaptureTarget> getTargets() {
        return new ArrayList(this.mTargets);
    }

    public ScrollCaptureTarget getTopResult() {
        ScrollCaptureTarget target = this.mTargets.isEmpty() ? null : this.mTargets.get(0);
        if (target == null || target.getScrollBounds() == null) {
            return null;
        }
        return target;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class SearchRequest implements Consumer<Rect> {
        private ScrollCaptureTarget mTarget;

        SearchRequest(ScrollCaptureTarget target) {
            this.mTarget = target;
        }

        @Override // java.util.function.Consumer
        public void accept(final Rect scrollBounds) {
            if (this.mTarget == null || ScrollCaptureSearchResults.this.mCancel.isCanceled()) {
                return;
            }
            ScrollCaptureSearchResults.this.mExecutor.execute(new Runnable() { // from class: android.view.ScrollCaptureSearchResults$SearchRequest$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ScrollCaptureSearchResults.SearchRequest.this.lambda$accept$0(scrollBounds);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: consume, reason: merged with bridge method [inline-methods] */
        public void lambda$accept$0(Rect scrollBounds) {
            if (this.mTarget == null || ScrollCaptureSearchResults.this.mCancel.isCanceled()) {
                return;
            }
            if (!ScrollCaptureSearchResults.nullOrEmpty(scrollBounds)) {
                this.mTarget.setScrollBounds(scrollBounds);
                this.mTarget.updatePositionInWindow();
            }
            ScrollCaptureSearchResults.this.mCompleted++;
            this.mTarget = null;
            if (ScrollCaptureSearchResults.this.mCompleted == ScrollCaptureSearchResults.this.mTargets.size()) {
                ScrollCaptureSearchResults.this.signalComplete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$static$1(ScrollCaptureTarget a10, ScrollCaptureTarget b4) {
        if (a10 == null && b4 == null) {
            return 0;
        }
        if (a10 == null || b4 == null) {
            return a10 == null ? 1 : -1;
        }
        boolean emptyScrollBoundsA = nullOrEmpty(a10.getScrollBounds());
        boolean emptyScrollBoundsB = nullOrEmpty(b4.getScrollBounds());
        if (emptyScrollBoundsA || emptyScrollBoundsB) {
            if (emptyScrollBoundsA && emptyScrollBoundsB) {
                return 0;
            }
            return emptyScrollBoundsA ? 1 : -1;
        }
        View viewA = a10.getContainingView();
        View viewB = b4.getContainingView();
        boolean hintIncludeA = hasIncludeHint(viewA);
        boolean hintIncludeB = hasIncludeHint(viewB);
        if (hintIncludeA != hintIncludeB) {
            return hintIncludeA ? -1 : 1;
        }
        if (isDescendant(viewA, viewB)) {
            return -1;
        }
        if (isDescendant(viewB, viewA)) {
            return 1;
        }
        int scrollAreaA = area(a10.getScrollBounds());
        int scrollAreaB = area(b4.getScrollBounds());
        return scrollAreaA >= scrollAreaB ? -1 : 1;
    }

    private static int area(Rect r10) {
        return r10.width() * r10.height();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean nullOrEmpty(Rect r10) {
        return r10 == null || r10.isEmpty();
    }

    private static boolean hasIncludeHint(View view) {
        return (view.getScrollCaptureHint() & 2) != 0;
    }

    private static boolean isDescendant(View view, View otherView) {
        if (view == otherView) {
            return false;
        }
        ViewParent otherParent = otherView.getParent();
        while (otherParent != view && otherParent != null) {
            otherParent = otherParent.getParent();
        }
        return otherParent == view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dump(IndentingPrintWriter writer) {
        writer.println("results:");
        writer.increaseIndent();
        writer.println("complete: " + isComplete());
        writer.println("cancelled: " + this.mCancel.isCanceled());
        writer.println("targets:");
        writer.increaseIndent();
        if (isEmpty()) {
            writer.println("None");
        } else {
            for (int i10 = 0; i10 < this.mTargets.size(); i10++) {
                writer.println("[" + i10 + "]");
                writer.increaseIndent();
                this.mTargets.get(i10).dump(writer);
                writer.decreaseIndent();
            }
            writer.decreaseIndent();
        }
        writer.decreaseIndent();
    }
}
