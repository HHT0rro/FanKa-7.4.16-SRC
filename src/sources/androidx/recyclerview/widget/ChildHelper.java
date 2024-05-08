package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    public final Callback mCallback;
    public final Bucket mBucket = new Bucket();
    public final List<View> mHiddenViews = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Bucket {
        public static final int BITS_PER_WORD = 64;
        public static final long LAST_BIT = Long.MIN_VALUE;
        public long mData = 0;
        public Bucket mNext;

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        public void clear(int i10) {
            if (i10 >= 64) {
                Bucket bucket = this.mNext;
                if (bucket != null) {
                    bucket.clear(i10 - 64);
                    return;
                }
                return;
            }
            this.mData &= ~(1 << i10);
        }

        public int countOnesBefore(int i10) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (i10 >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(this.mData & ((1 << i10) - 1));
            }
            if (i10 < 64) {
                return Long.bitCount(this.mData & ((1 << i10) - 1));
            }
            return bucket.countOnesBefore(i10 - 64) + Long.bitCount(this.mData);
        }

        public boolean get(int i10) {
            if (i10 < 64) {
                return (this.mData & (1 << i10)) != 0;
            }
            ensureNext();
            return this.mNext.get(i10 - 64);
        }

        public void insert(int i10, boolean z10) {
            if (i10 >= 64) {
                ensureNext();
                this.mNext.insert(i10 - 64, z10);
                return;
            }
            long j10 = this.mData;
            boolean z11 = (Long.MIN_VALUE & j10) != 0;
            long j11 = (1 << i10) - 1;
            this.mData = ((j10 & (~j11)) << 1) | (j10 & j11);
            if (z10) {
                set(i10);
            } else {
                clear(i10);
            }
            if (z11 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z11);
            }
        }

        public boolean remove(int i10) {
            if (i10 >= 64) {
                ensureNext();
                return this.mNext.remove(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.mData;
            boolean z10 = (j11 & j10) != 0;
            long j12 = j11 & (~j10);
            this.mData = j12;
            long j13 = j10 - 1;
            this.mData = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z10;
        }

        public void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        public void set(int i10) {
            if (i10 >= 64) {
                ensureNext();
                this.mNext.set(i10 - 64);
            } else {
                this.mData |= 1 << i10;
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Callback {
        void addView(View view, int i10);

        void attachViewToParent(View view, int i10, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i10);

        View getChildAt(int i10);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i10);
    }

    public ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    private int getOffset(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i11 = i10;
        while (i11 < childCount) {
            int countOnesBefore = i10 - (i11 - this.mBucket.countOnesBefore(i11));
            if (countOnesBefore == 0) {
                while (this.mBucket.get(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += countOnesBefore;
        }
        return -1;
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (!this.mHiddenViews.remove(view)) {
            return false;
        }
        this.mCallback.onLeftHiddenState(view);
        return true;
    }

    public void addView(View view, boolean z10) {
        addView(view, -1, z10);
    }

    public void attachViewToParent(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int offset;
        if (i10 < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(i10);
        }
        this.mBucket.insert(offset, z10);
        if (z10) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, offset, layoutParams);
    }

    public void detachViewFromParent(int i10) {
        int offset = getOffset(i10);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    public View findHiddenNonRemovedView(int i10) {
        int size = this.mHiddenViews.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = this.mHiddenViews.get(i11);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i10 && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public View getChildAt(int i10) {
        return this.mCallback.getChildAt(getOffset(i10));
    }

    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    public View getUnfilteredChildAt(int i10) {
        return this.mCallback.getChildAt(i10);
    }

    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    public void hide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild >= 0) {
            this.mBucket.set(indexOfChild);
            hideViewInternal(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + ((Object) view));
        }
    }

    public int indexOfChild(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild == -1 || this.mBucket.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.mBucket.countOnesBefore(indexOfChild);
    }

    public boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
    }

    public void removeView(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild < 0) {
            return;
        }
        if (this.mBucket.remove(indexOfChild)) {
            unhideViewInternal(view);
        }
        this.mCallback.removeViewAt(indexOfChild);
    }

    public void removeViewAt(int i10) {
        int offset = getOffset(i10);
        View childAt = this.mCallback.getChildAt(offset);
        if (childAt == null) {
            return;
        }
        if (this.mBucket.remove(offset)) {
            unhideViewInternal(childAt);
        }
        this.mCallback.removeViewAt(offset);
    }

    public boolean removeViewIfHidden(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild == -1) {
            unhideViewInternal(view);
            return true;
        }
        if (!this.mBucket.get(indexOfChild)) {
            return false;
        }
        this.mBucket.remove(indexOfChild);
        unhideViewInternal(view);
        this.mCallback.removeViewAt(indexOfChild);
        return true;
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    public void unhide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.mBucket.get(indexOfChild)) {
                this.mBucket.clear(indexOfChild);
                unhideViewInternal(view);
                return;
            } else {
                throw new RuntimeException("trying to unhide a view that was not hidden" + ((Object) view));
            }
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + ((Object) view));
    }

    public void addView(View view, int i10, boolean z10) {
        int offset;
        if (i10 < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(i10);
        }
        this.mBucket.insert(offset, z10);
        if (z10) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, offset);
    }
}
