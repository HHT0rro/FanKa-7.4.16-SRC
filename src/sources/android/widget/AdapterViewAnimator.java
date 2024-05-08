package android.widget;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RemoteViews;
import android.widget.RemoteViewsAdapter;
import androidx.constraintlayout.motion.widget.Key;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class AdapterViewAnimator extends AdapterView<Adapter> implements RemoteViewsAdapter.RemoteAdapterConnectionCallback, Advanceable {
    private static final int DEFAULT_ANIMATION_DURATION = 200;
    private static final String TAG = "RemoteViewAnimator";
    static final int TOUCH_MODE_DOWN_IN_CURRENT_VIEW = 1;
    static final int TOUCH_MODE_HANDLED = 2;
    static final int TOUCH_MODE_NONE = 0;
    int mActiveOffset;
    Adapter mAdapter;
    boolean mAnimateFirstTime;
    int mCurrentWindowEnd;
    int mCurrentWindowStart;
    int mCurrentWindowStartUnbounded;
    AdapterView<Adapter>.AdapterDataSetObserver mDataSetObserver;
    boolean mDeferNotifyDataSetChanged;
    boolean mFirstTime;
    ObjectAnimator mInAnimation;
    boolean mLoopViews;
    int mMaxNumActiveViews;
    ObjectAnimator mOutAnimation;
    private Runnable mPendingCheckForTap;
    ArrayList<Integer> mPreviousViews;
    int mReferenceChildHeight;
    int mReferenceChildWidth;
    RemoteViewsAdapter mRemoteViewsAdapter;
    private int mRestoreWhichChild;
    private int mTouchMode;
    HashMap<Integer, ViewAndMetaData> mViewsMap;
    int mWhichChild;

    public AdapterViewAnimator(Context context) {
        this(context, null);
    }

    public AdapterViewAnimator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AdapterViewAnimator(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public AdapterViewAnimator(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mWhichChild = 0;
        this.mRestoreWhichChild = -1;
        this.mAnimateFirstTime = true;
        this.mActiveOffset = 0;
        this.mMaxNumActiveViews = 1;
        this.mViewsMap = new HashMap<>();
        this.mCurrentWindowStart = 0;
        this.mCurrentWindowEnd = -1;
        this.mCurrentWindowStartUnbounded = 0;
        this.mDeferNotifyDataSetChanged = false;
        this.mFirstTime = true;
        this.mLoopViews = true;
        this.mReferenceChildWidth = -1;
        this.mReferenceChildHeight = -1;
        this.mTouchMode = 0;
        TypedArray a10 = context.obtainStyledAttributes(attrs, R.styleable.AdapterViewAnimator, defStyleAttr, defStyleRes);
        saveAttributeDataForStyleable(context, R.styleable.AdapterViewAnimator, attrs, a10, defStyleAttr, defStyleRes);
        int resource = a10.getResourceId(0, 0);
        if (resource > 0) {
            setInAnimation(context, resource);
        } else {
            setInAnimation(getDefaultInAnimation());
        }
        int resource2 = a10.getResourceId(1, 0);
        if (resource2 > 0) {
            setOutAnimation(context, resource2);
        } else {
            setOutAnimation(getDefaultOutAnimation());
        }
        boolean flag = a10.getBoolean(2, true);
        setAnimateFirstView(flag);
        this.mLoopViews = a10.getBoolean(3, false);
        a10.recycle();
        initViewAnimator();
    }

    private void initViewAnimator() {
        this.mPreviousViews = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ViewAndMetaData {
        int adapterPosition;
        long itemId;
        int relativeIndex;
        View view;

        ViewAndMetaData(View view, int relativeIndex, int adapterPosition, long itemId) {
            this.view = view;
            this.relativeIndex = relativeIndex;
            this.adapterPosition = adapterPosition;
            this.itemId = itemId;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void configureViewAnimator(int numVisibleViews, int activeOffset) {
        this.mMaxNumActiveViews = numVisibleViews;
        this.mActiveOffset = activeOffset;
        this.mPreviousViews.clear();
        this.mViewsMap.clear();
        removeAllViewsInLayout();
        this.mCurrentWindowStart = 0;
        this.mCurrentWindowEnd = -1;
    }

    void transformViewForTransition(int fromIndex, int toIndex, View view, boolean animate) {
        if (fromIndex == -1) {
            this.mInAnimation.setTarget(view);
            this.mInAnimation.start();
        } else if (toIndex == -1) {
            this.mOutAnimation.setTarget(view);
            this.mOutAnimation.start();
        }
    }

    ObjectAnimator getDefaultInAnimation() {
        ObjectAnimator anim = ObjectAnimator.ofFloat((Object) null, Key.ALPHA, 0.0f, 1.0f);
        anim.setDuration(200L);
        return anim;
    }

    ObjectAnimator getDefaultOutAnimation() {
        ObjectAnimator anim = ObjectAnimator.ofFloat((Object) null, Key.ALPHA, 1.0f, 0.0f);
        anim.setDuration(200L);
        return anim;
    }

    @RemotableViewMethod
    public void setDisplayedChild(int whichChild) {
        setDisplayedChild(whichChild, true);
    }

    private void setDisplayedChild(int whichChild, boolean animate) {
        if (this.mAdapter != null) {
            this.mWhichChild = whichChild;
            if (whichChild >= getWindowSize()) {
                this.mWhichChild = this.mLoopViews ? 0 : getWindowSize() - 1;
            } else if (whichChild < 0) {
                this.mWhichChild = this.mLoopViews ? getWindowSize() - 1 : 0;
            }
            boolean hasFocus = getFocusedChild() != null;
            showOnly(this.mWhichChild, animate);
            if (hasFocus) {
                requestFocus(2);
            }
        }
    }

    void applyTransformForChildAtIndex(View child, int relativeIndex) {
    }

    public int getDisplayedChild() {
        return this.mWhichChild;
    }

    public void showNext() {
        setDisplayedChild(this.mWhichChild + 1);
    }

    public void showPrevious() {
        setDisplayedChild(this.mWhichChild - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int modulo(int pos, int size) {
        if (size > 0) {
            return ((pos % size) + size) % size;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getViewAtRelativeIndex(int relativeIndex) {
        if (relativeIndex >= 0 && relativeIndex <= getNumActiveViews() - 1 && this.mAdapter != null) {
            int i10 = modulo(this.mCurrentWindowStartUnbounded + relativeIndex, getWindowSize());
            if (this.mViewsMap.get(Integer.valueOf(i10)) != null) {
                return this.mViewsMap.get(Integer.valueOf(i10)).view;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNumActiveViews() {
        if (this.mAdapter != null) {
            return Math.min(getCount() + 1, this.mMaxNumActiveViews);
        }
        return this.mMaxNumActiveViews;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getWindowSize() {
        if (this.mAdapter != null) {
            int adapterCount = getCount();
            if (adapterCount <= getNumActiveViews() && this.mLoopViews) {
                return this.mMaxNumActiveViews * adapterCount;
            }
            return adapterCount;
        }
        return 0;
    }

    private ViewAndMetaData getMetaDataForChild(View child) {
        for (ViewAndMetaData vm : this.mViewsMap.values()) {
            if (vm.view == child) {
                return vm;
            }
        }
        return null;
    }

    ViewGroup.LayoutParams createOrReuseLayoutParams(View v2) {
        ViewGroup.LayoutParams currentLp = v2.getLayoutParams();
        if (currentLp != null) {
            return currentLp;
        }
        return new ViewGroup.LayoutParams(0, 0);
    }

    void refreshChildren() {
        View updatedChild;
        int adapterCount = this.mAdapter == null ? 0 : getCount();
        for (int i10 = this.mCurrentWindowStart; i10 <= this.mCurrentWindowEnd; i10++) {
            int index = modulo(i10, getWindowSize());
            if (i10 < adapterCount) {
                updatedChild = this.mAdapter.getView(modulo(i10, adapterCount), null, this);
                if (updatedChild.getImportantForAccessibility() == 0) {
                    updatedChild.setImportantForAccessibility(1);
                }
            } else {
                updatedChild = null;
            }
            if (this.mViewsMap.containsKey(Integer.valueOf(index))) {
                FrameLayout fl = (FrameLayout) this.mViewsMap.get(Integer.valueOf(index)).view;
                fl.removeAllViewsInLayout();
                if (updatedChild != null) {
                    fl.addView(updatedChild);
                }
            }
        }
    }

    FrameLayout getFrameForChild() {
        return new FrameLayout(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showOnly(int childIndex, boolean animate) {
        int adapterCount;
        int newWindowStart;
        int newWindowEnd;
        boolean wrap;
        int oldRelativeIndex;
        int newWindowEndUnbounded;
        int adapterCount2;
        int newWindowStartUnbounded;
        int rangeEnd;
        int rangeStart;
        int newWindowEnd2;
        int newRelativeIndex;
        if (this.mAdapter == null || (adapterCount = getCount()) == 0) {
            return;
        }
        for (int i10 = 0; i10 < this.mPreviousViews.size(); i10++) {
            View viewToRemove = this.mViewsMap.get(this.mPreviousViews.get(i10)).view;
            this.mViewsMap.remove(this.mPreviousViews.get(i10));
            viewToRemove.clearAnimation();
            if (viewToRemove instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) viewToRemove;
                vg.removeAllViewsInLayout();
            }
            applyTransformForChildAtIndex(viewToRemove, -1);
            removeViewInLayout(viewToRemove);
        }
        this.mPreviousViews.clear();
        int newWindowStartUnbounded2 = childIndex - this.mActiveOffset;
        int newWindowEndUnbounded2 = (getNumActiveViews() + newWindowStartUnbounded2) - 1;
        int newWindowStart2 = Math.max(0, newWindowStartUnbounded2);
        int newWindowEnd3 = Math.min(adapterCount - 1, newWindowEndUnbounded2);
        if (!this.mLoopViews) {
            newWindowStart = newWindowStart2;
            newWindowEnd = newWindowEnd3;
        } else {
            newWindowStart = newWindowStartUnbounded2;
            newWindowEnd = newWindowEndUnbounded2;
        }
        int newWindowStart3 = getWindowSize();
        int rangeStart2 = modulo(newWindowStart, newWindowStart3);
        int rangeEnd2 = modulo(newWindowEnd, getWindowSize());
        if (rangeStart2 <= rangeEnd2) {
            wrap = false;
        } else {
            wrap = true;
        }
        for (Integer index : this.mViewsMap.h()) {
            boolean remove = false;
            if (!wrap && (index.intValue() < rangeStart2 || index.intValue() > rangeEnd2)) {
                remove = true;
            } else if (wrap && index.intValue() > rangeEnd2 && index.intValue() < rangeStart2) {
                remove = true;
            }
            if (remove) {
                View previousView = this.mViewsMap.get(index).view;
                int oldRelativeIndex2 = this.mViewsMap.get(index).relativeIndex;
                this.mPreviousViews.add(index);
                transformViewForTransition(oldRelativeIndex2, -1, previousView, animate);
            }
        }
        if (newWindowStart != this.mCurrentWindowStart || newWindowEnd != this.mCurrentWindowEnd || newWindowStartUnbounded2 != this.mCurrentWindowStartUnbounded) {
            int i11 = newWindowStart;
            while (i11 <= newWindowEnd) {
                int index2 = modulo(i11, getWindowSize());
                if (this.mViewsMap.containsKey(Integer.valueOf(index2))) {
                    oldRelativeIndex = this.mViewsMap.get(Integer.valueOf(index2)).relativeIndex;
                } else {
                    oldRelativeIndex = -1;
                }
                int newRelativeIndex2 = i11 - newWindowStartUnbounded2;
                boolean inOldRange = this.mViewsMap.containsKey(Integer.valueOf(index2)) && !this.mPreviousViews.contains(Integer.valueOf(index2));
                if (inOldRange) {
                    View view = this.mViewsMap.get(Integer.valueOf(index2)).view;
                    this.mViewsMap.get(Integer.valueOf(index2)).relativeIndex = newRelativeIndex2;
                    applyTransformForChildAtIndex(view, newRelativeIndex2);
                    transformViewForTransition(oldRelativeIndex, newRelativeIndex2, view, animate);
                    rangeEnd = rangeEnd2;
                    newWindowEnd2 = newWindowEnd;
                    rangeStart = rangeStart2;
                    adapterCount2 = adapterCount;
                    newWindowStartUnbounded = newWindowStartUnbounded2;
                    newWindowEndUnbounded = newWindowEndUnbounded2;
                    newRelativeIndex = -1;
                } else {
                    int adapterPosition = modulo(i11, adapterCount);
                    View newView = this.mAdapter.getView(adapterPosition, null, this);
                    long itemId = this.mAdapter.getItemId(adapterPosition);
                    FrameLayout fl = getFrameForChild();
                    if (newView != null) {
                        fl.addView(newView);
                    }
                    newWindowEndUnbounded = newWindowEndUnbounded2;
                    adapterCount2 = adapterCount;
                    newWindowStartUnbounded = newWindowStartUnbounded2;
                    rangeEnd = rangeEnd2;
                    rangeStart = rangeStart2;
                    newWindowEnd2 = newWindowEnd;
                    this.mViewsMap.put(Integer.valueOf(index2), new ViewAndMetaData(fl, newRelativeIndex2, adapterPosition, itemId));
                    addChild(fl);
                    applyTransformForChildAtIndex(fl, newRelativeIndex2);
                    newRelativeIndex = -1;
                    transformViewForTransition(-1, newRelativeIndex2, fl, animate);
                }
                this.mViewsMap.get(Integer.valueOf(index2)).view.bringToFront();
                i11++;
                newWindowEnd = newWindowEnd2;
                newWindowEndUnbounded2 = newWindowEndUnbounded;
                adapterCount = adapterCount2;
                newWindowStartUnbounded2 = newWindowStartUnbounded;
                rangeEnd2 = rangeEnd;
                rangeStart2 = rangeStart;
            }
            int adapterCount3 = adapterCount;
            this.mCurrentWindowStart = newWindowStart;
            this.mCurrentWindowEnd = newWindowEnd;
            this.mCurrentWindowStartUnbounded = newWindowStartUnbounded2;
            if (this.mRemoteViewsAdapter != null) {
                int adapterStart = modulo(newWindowStart, adapterCount3);
                int adapterEnd = modulo(this.mCurrentWindowEnd, adapterCount3);
                this.mRemoteViewsAdapter.setVisibleRangeHint(adapterStart, adapterEnd);
            }
        }
        requestLayout();
        invalidate();
    }

    private void addChild(View child) {
        addViewInLayout(child, -1, createOrReuseLayoutParams(child));
        if (this.mReferenceChildWidth == -1 || this.mReferenceChildHeight == -1) {
            int measureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            child.measure(measureSpec, measureSpec);
            this.mReferenceChildWidth = child.getMeasuredWidth();
            this.mReferenceChildHeight = child.getMeasuredHeight();
        }
    }

    void showTapFeedback(View v2) {
        v2.setPressed(true);
    }

    void hideTapFeedback(View v2) {
        v2.setPressed(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancelHandleClick() {
        View v2 = getCurrentView();
        if (v2 != null) {
            hideTapFeedback(v2);
        }
        this.mTouchMode = 0;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    final class CheckForTap implements Runnable {
        CheckForTap() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AdapterViewAnimator.this.mTouchMode == 1) {
                View v2 = AdapterViewAnimator.this.getCurrentView();
                AdapterViewAnimator.this.showTapFeedback(v2);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
    
        return r1;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            int r0 = r10.getAction()
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 1
            switch(r0) {
                case 0: goto L57;
                case 1: goto L1c;
                case 2: goto L1b;
                case 3: goto Lf;
                case 4: goto Lb;
                case 5: goto Lb;
                case 6: goto Ld;
                default: goto Lb;
            }
        Lb:
            goto L82
        Ld:
            goto L82
        Lf:
            android.view.View r3 = r9.getCurrentView()
            if (r3 == 0) goto L18
            r9.hideTapFeedback(r3)
        L18:
            r9.mTouchMode = r2
            goto L82
        L1b:
            goto L82
        L1c:
            int r5 = r9.mTouchMode
            if (r5 != r4) goto L54
            android.view.View r4 = r9.getCurrentView()
            android.widget.AdapterViewAnimator$ViewAndMetaData r5 = r9.getMetaDataForChild(r4)
            if (r4 == 0) goto L54
            float r6 = r10.getX()
            float r7 = r10.getY()
            boolean r3 = r9.isTransformedTouchPointInView(r6, r7, r4, r3)
            if (r3 == 0) goto L54
            android.os.Handler r3 = r9.getHandler()
            if (r3 == 0) goto L43
            java.lang.Runnable r6 = r9.mPendingCheckForTap
            r3.removeCallbacks(r6)
        L43:
            r9.showTapFeedback(r4)
            android.widget.AdapterViewAnimator$1 r6 = new android.widget.AdapterViewAnimator$1
            r6.<init>()
            int r7 = android.view.ViewConfiguration.getPressedStateDuration()
            long r7 = (long) r7
            r9.postDelayed(r6, r7)
            r1 = 1
        L54:
            r9.mTouchMode = r2
            goto L82
        L57:
            android.view.View r2 = r9.getCurrentView()
            if (r2 == 0) goto L82
            float r5 = r10.getX()
            float r6 = r10.getY()
            boolean r3 = r9.isTransformedTouchPointInView(r5, r6, r2, r3)
            if (r3 == 0) goto L82
            java.lang.Runnable r3 = r9.mPendingCheckForTap
            if (r3 != 0) goto L76
            android.widget.AdapterViewAnimator$CheckForTap r3 = new android.widget.AdapterViewAnimator$CheckForTap
            r3.<init>()
            r9.mPendingCheckForTap = r3
        L76:
            r9.mTouchMode = r4
            java.lang.Runnable r3 = r9.mPendingCheckForTap
            int r4 = android.view.ViewConfiguration.getTapTimeout()
            long r4 = (long) r4
            r9.postDelayed(r3, r4)
        L82:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.AdapterViewAnimator.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void measureChildren() {
        int count = getChildCount();
        int childWidth = (getMeasuredWidth() - this.mPaddingLeft) - this.mPaddingRight;
        int childHeight = (getMeasuredHeight() - this.mPaddingTop) - this.mPaddingBottom;
        for (int i10 = 0; i10 < count; i10++) {
            View child = getChildAt(i10);
            child.measure(View.MeasureSpec.makeMeasureSpec(childWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childHeight, 1073741824));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = View.MeasureSpec.getSize(heightMeasureSpec);
        int widthSpecMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = View.MeasureSpec.getMode(heightMeasureSpec);
        boolean haveChildRefSize = (this.mReferenceChildWidth == -1 || this.mReferenceChildHeight == -1) ? false : true;
        if (heightSpecMode == 0) {
            heightSpecSize = haveChildRefSize ? this.mReferenceChildHeight + this.mPaddingTop + this.mPaddingBottom : 0;
        } else if (heightSpecMode == Integer.MIN_VALUE && haveChildRefSize) {
            int height = this.mReferenceChildHeight + this.mPaddingTop + this.mPaddingBottom;
            heightSpecSize = height > heightSpecSize ? heightSpecSize | 16777216 : height;
        }
        if (widthSpecMode == 0) {
            widthSpecSize = haveChildRefSize ? this.mReferenceChildWidth + this.mPaddingLeft + this.mPaddingRight : 0;
        } else if (heightSpecMode == Integer.MIN_VALUE && haveChildRefSize) {
            int width = this.mReferenceChildWidth + this.mPaddingLeft + this.mPaddingRight;
            widthSpecSize = width > widthSpecSize ? widthSpecSize | 16777216 : width;
        }
        setMeasuredDimension(widthSpecSize, heightSpecSize);
        measureChildren();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkForAndHandleDataChanged() {
        boolean dataChanged = this.mDataChanged;
        if (dataChanged) {
            post(new Runnable() { // from class: android.widget.AdapterViewAnimator.2
                @Override // java.lang.Runnable
                public void run() {
                    AdapterViewAnimator.this.handleDataChanged();
                    if (AdapterViewAnimator.this.mWhichChild >= AdapterViewAnimator.this.getWindowSize()) {
                        AdapterViewAnimator.this.mWhichChild = 0;
                        AdapterViewAnimator adapterViewAnimator = AdapterViewAnimator.this;
                        adapterViewAnimator.showOnly(adapterViewAnimator.mWhichChild, false);
                    } else if (AdapterViewAnimator.this.mOldItemCount != AdapterViewAnimator.this.getCount()) {
                        AdapterViewAnimator adapterViewAnimator2 = AdapterViewAnimator.this;
                        adapterViewAnimator2.showOnly(adapterViewAnimator2.mWhichChild, false);
                    }
                    AdapterViewAnimator.this.refreshChildren();
                    AdapterViewAnimator.this.requestLayout();
                }
            });
        }
        this.mDataChanged = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        checkForAndHandleDataChanged();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View child = getChildAt(i10);
            int childRight = this.mPaddingLeft + child.getMeasuredWidth();
            int childBottom = this.mPaddingTop + child.getMeasuredHeight();
            child.layout(this.mPaddingLeft, this.mPaddingTop, childRight, childBottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.widget.AdapterViewAnimator.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int whichChild;

        SavedState(Parcelable superState, int whichChild) {
            super(superState);
            this.whichChild = whichChild;
        }

        private SavedState(Parcel in) {
            super(in);
            this.whichChild = in.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.whichChild);
        }

        public String toString() {
            return "AdapterViewAnimator.SavedState{ whichChild = " + this.whichChild + " }";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        RemoteViewsAdapter remoteViewsAdapter = this.mRemoteViewsAdapter;
        if (remoteViewsAdapter != null) {
            remoteViewsAdapter.saveRemoteViewsCache();
        }
        return new SavedState(superState, this.mWhichChild);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        int i10 = ss.whichChild;
        this.mWhichChild = i10;
        if (this.mRemoteViewsAdapter != null && this.mAdapter == null) {
            this.mRestoreWhichChild = i10;
        } else {
            setDisplayedChild(i10, false);
        }
    }

    public View getCurrentView() {
        return getViewAtRelativeIndex(this.mActiveOffset);
    }

    public ObjectAnimator getInAnimation() {
        return this.mInAnimation;
    }

    public void setInAnimation(ObjectAnimator inAnimation) {
        this.mInAnimation = inAnimation;
    }

    public ObjectAnimator getOutAnimation() {
        return this.mOutAnimation;
    }

    public void setOutAnimation(ObjectAnimator outAnimation) {
        this.mOutAnimation = outAnimation;
    }

    public void setInAnimation(Context context, int resourceID) {
        setInAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
    }

    public void setOutAnimation(Context context, int resourceID) {
        setOutAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, resourceID));
    }

    public void setAnimateFirstView(boolean animate) {
        this.mAnimateFirstTime = animate;
    }

    @Override // android.view.View
    public int getBaseline() {
        return getCurrentView() != null ? getCurrentView().getBaseline() : super.getBaseline();
    }

    @Override // android.widget.AdapterView
    public Adapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(Adapter adapter) {
        AdapterView<Adapter>.AdapterDataSetObserver adapterDataSetObserver;
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null && (adapterDataSetObserver = this.mDataSetObserver) != null) {
            adapter2.unregisterDataSetObserver(adapterDataSetObserver);
        }
        this.mAdapter = adapter;
        checkFocus();
        if (this.mAdapter != null) {
            AdapterView<Adapter>.AdapterDataSetObserver adapterDataSetObserver2 = new AdapterView.AdapterDataSetObserver();
            this.mDataSetObserver = adapterDataSetObserver2;
            this.mAdapter.registerDataSetObserver(adapterDataSetObserver2);
            this.mItemCount = this.mAdapter.getCount();
        }
        setFocusable(true);
        this.mWhichChild = 0;
        showOnly(0, false);
    }

    @RemotableViewMethod(asyncImpl = "setRemoteViewsAdapterAsync")
    public void setRemoteViewsAdapter(Intent intent) {
        setRemoteViewsAdapter(intent, false);
    }

    public Runnable setRemoteViewsAdapterAsync(Intent intent) {
        return new RemoteViewsAdapter.AsyncRemoteAdapterAction(this, intent);
    }

    @Override // android.widget.RemoteViewsAdapter.RemoteAdapterConnectionCallback
    public void setRemoteViewsAdapter(Intent intent, boolean isAsync) {
        if (this.mRemoteViewsAdapter != null) {
            Intent.FilterComparison fcNew = new Intent.FilterComparison(intent);
            Intent.FilterComparison fcOld = new Intent.FilterComparison(this.mRemoteViewsAdapter.getRemoteViewsServiceIntent());
            if (fcNew.equals(fcOld)) {
                return;
            }
        }
        this.mDeferNotifyDataSetChanged = false;
        RemoteViewsAdapter remoteViewsAdapter = new RemoteViewsAdapter(getContext(), intent, this, isAsync);
        this.mRemoteViewsAdapter = remoteViewsAdapter;
        if (remoteViewsAdapter.isDataReady()) {
            setAdapter(this.mRemoteViewsAdapter);
        }
    }

    public void setRemoteViewsOnClickHandler(RemoteViews.InteractionHandler handler) {
        RemoteViewsAdapter remoteViewsAdapter = this.mRemoteViewsAdapter;
        if (remoteViewsAdapter != null) {
            remoteViewsAdapter.setRemoteViewsInteractionHandler(handler);
        }
    }

    @Override // android.widget.AdapterView
    public void setSelection(int position) {
        setDisplayedChild(position);
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return getViewAtRelativeIndex(this.mActiveOffset);
    }

    @Override // android.widget.RemoteViewsAdapter.RemoteAdapterConnectionCallback
    public void deferNotifyDataSetChanged() {
        this.mDeferNotifyDataSetChanged = true;
    }

    @Override // android.widget.RemoteViewsAdapter.RemoteAdapterConnectionCallback
    public boolean onRemoteAdapterConnected() {
        RemoteViewsAdapter remoteViewsAdapter = this.mRemoteViewsAdapter;
        if (remoteViewsAdapter != this.mAdapter) {
            setAdapter(remoteViewsAdapter);
            if (this.mDeferNotifyDataSetChanged) {
                this.mRemoteViewsAdapter.notifyDataSetChanged();
                this.mDeferNotifyDataSetChanged = false;
            }
            int i10 = this.mRestoreWhichChild;
            if (i10 > -1) {
                setDisplayedChild(i10, false);
                this.mRestoreWhichChild = -1;
            }
            return false;
        }
        if (remoteViewsAdapter == null) {
            return false;
        }
        remoteViewsAdapter.superNotifyDataSetChanged();
        return true;
    }

    @Override // android.widget.RemoteViewsAdapter.RemoteAdapterConnectionCallback
    public void onRemoteAdapterDisconnected() {
    }

    @Override // android.widget.Advanceable
    public void advance() {
        showNext();
    }

    @Override // android.widget.Advanceable
    public void fyiWillBeAdvancedByHostKThx() {
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return AdapterViewAnimator.class.getName();
    }
}
