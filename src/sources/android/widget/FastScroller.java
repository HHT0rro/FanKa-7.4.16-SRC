package android.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.IntProperty;
import android.util.MathUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import com.android.internal.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class FastScroller {
    private static final int DURATION_CROSS_FADE = 50;
    private static final int DURATION_FADE_IN = 150;
    private static final int DURATION_FADE_OUT = 300;
    private static final int DURATION_RESIZE = 100;
    private static final long FADE_TIMEOUT = 1500;
    private static final int MIN_PAGES = 4;
    private static final int OVERLAY_ABOVE_THUMB = 2;
    private static final int OVERLAY_AT_THUMB = 1;
    private static final int OVERLAY_FLOATING = 0;
    private static final int PREVIEW_LEFT = 0;
    private static final int PREVIEW_RIGHT = 1;
    private static final int STATE_DRAGGING = 2;
    private static final int STATE_NONE = 0;
    private static final int STATE_VISIBLE = 1;
    private static final int THUMB_POSITION_INSIDE = 1;
    private static final int THUMB_POSITION_MIDPOINT = 0;
    private boolean mAlwaysShow;
    private AnimatorSet mDecorAnimation;
    private boolean mEnabled;
    private int mFirstVisibleItem;
    private int mHeaderCount;
    private float mInitialTouchY;
    private boolean mLayoutFromRight;
    private final AbsListView mList;
    private Adapter mListAdapter;
    private boolean mLongList;
    private boolean mMatchDragPosition;
    private final int mMinimumTouchTarget;
    private int mOldChildCount;
    private int mOldItemCount;
    private final ViewGroupOverlay mOverlay;
    private int mOverlayPosition;
    private AnimatorSet mPreviewAnimation;
    private final View mPreviewImage;
    private int mPreviewMinHeight;
    private int mPreviewMinWidth;
    private int mPreviewPadding;
    private final TextView mPrimaryText;
    private int mScaledTouchSlop;
    private int mScrollBarStyle;
    private boolean mScrollCompleted;
    private final TextView mSecondaryText;
    private SectionIndexer mSectionIndexer;
    private Object[] mSections;
    private boolean mShowingPreview;
    private boolean mShowingPrimary;
    private int mState;
    private int mTextAppearance;
    private ColorStateList mTextColor;
    private float mTextSize;
    private Drawable mThumbDrawable;
    private final ImageView mThumbImage;
    private int mThumbMinHeight;
    private int mThumbMinWidth;
    private float mThumbOffset;
    private int mThumbPosition;
    private float mThumbRange;
    private Drawable mTrackDrawable;
    private final ImageView mTrackImage;
    private boolean mUpdatingLayout;
    private int mWidth;
    private static final long TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    private static Property<View, Integer> LEFT = new IntProperty<View>("left") { // from class: android.widget.FastScroller.3
        @Override // android.util.IntProperty
        public void setValue(View object, int value) {
            object.setLeft(value);
        }

        @Override // android.util.Property
        public Integer get(View object) {
            return Integer.valueOf(object.getLeft());
        }
    };
    private static Property<View, Integer> TOP = new IntProperty<View>("top") { // from class: android.widget.FastScroller.4
        @Override // android.util.IntProperty
        public void setValue(View object, int value) {
            object.setTop(value);
        }

        @Override // android.util.Property
        public Integer get(View object) {
            return Integer.valueOf(object.getTop());
        }
    };
    private static Property<View, Integer> RIGHT = new IntProperty<View>("right") { // from class: android.widget.FastScroller.5
        @Override // android.util.IntProperty
        public void setValue(View object, int value) {
            object.setRight(value);
        }

        @Override // android.util.Property
        public Integer get(View object) {
            return Integer.valueOf(object.getRight());
        }
    };
    private static Property<View, Integer> BOTTOM = new IntProperty<View>("bottom") { // from class: android.widget.FastScroller.6
        @Override // android.util.IntProperty
        public void setValue(View object, int value) {
            object.setBottom(value);
        }

        @Override // android.util.Property
        public Integer get(View object) {
            return Integer.valueOf(object.getBottom());
        }
    };
    private final Rect mTempBounds = new Rect();
    private final Rect mTempMargins = new Rect();
    private final Rect mContainerRect = new Rect();
    private final int[] mPreviewResId = new int[2];
    private int mCurrentSection = -1;
    private int mScrollbarPosition = -1;
    private long mPendingDrag = -1;
    private final Runnable mDeferHide = new Runnable() { // from class: android.widget.FastScroller.1
        @Override // java.lang.Runnable
        public void run() {
            FastScroller.this.setState(0);
        }
    };
    private final Animator.AnimatorListener mSwitchPrimaryListener = new AnimatorListenerAdapter() { // from class: android.widget.FastScroller.2
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            FastScroller.this.mShowingPrimary = !r0.mShowingPrimary;
        }
    };

    public FastScroller(AbsListView listView, int styleResId) {
        this.mList = listView;
        this.mOldItemCount = listView.getCount();
        this.mOldChildCount = listView.getChildCount();
        Context context = listView.getContext();
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mScrollBarStyle = listView.getScrollBarStyle();
        this.mScrollCompleted = true;
        this.mState = 1;
        this.mMatchDragPosition = context.getApplicationInfo().targetSdkVersion >= 11;
        ImageView imageView = new ImageView(context);
        this.mTrackImage = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView imageView2 = new ImageView(context);
        this.mThumbImage = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        View view = new View(context);
        this.mPreviewImage = view;
        view.setAlpha(0.0f);
        TextView createPreviewTextView = createPreviewTextView(context);
        this.mPrimaryText = createPreviewTextView;
        TextView createPreviewTextView2 = createPreviewTextView(context);
        this.mSecondaryText = createPreviewTextView2;
        this.mMinimumTouchTarget = listView.getResources().getDimensionPixelSize(17105223);
        setStyle(styleResId);
        ViewGroupOverlay overlay = listView.getOverlay();
        this.mOverlay = overlay;
        overlay.add(imageView);
        overlay.add(imageView2);
        overlay.add(view);
        overlay.add(createPreviewTextView);
        overlay.add(createPreviewTextView2);
        getSectionsFromIndexer();
        updateLongList(this.mOldChildCount, this.mOldItemCount);
        setScrollbarPosition(listView.getVerticalScrollbarPosition());
        postAutoHide();
    }

    private void updateAppearance() {
        this.mTrackImage.setImageDrawable(this.mTrackDrawable);
        Drawable drawable = this.mTrackDrawable;
        int width = drawable != null ? Math.max(0, drawable.getIntrinsicWidth()) : 0;
        this.mThumbImage.setImageDrawable(this.mThumbDrawable);
        this.mThumbImage.setMinimumWidth(this.mThumbMinWidth);
        this.mThumbImage.setMinimumHeight(this.mThumbMinHeight);
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            width = Math.max(width, drawable2.getIntrinsicWidth());
        }
        this.mWidth = Math.max(width, this.mThumbMinWidth);
        int i10 = this.mTextAppearance;
        if (i10 != 0) {
            this.mPrimaryText.setTextAppearance(i10);
            this.mSecondaryText.setTextAppearance(this.mTextAppearance);
        }
        ColorStateList colorStateList = this.mTextColor;
        if (colorStateList != null) {
            this.mPrimaryText.setTextColor(colorStateList);
            this.mSecondaryText.setTextColor(this.mTextColor);
        }
        float f10 = this.mTextSize;
        if (f10 > 0.0f) {
            this.mPrimaryText.setTextSize(0, f10);
            this.mSecondaryText.setTextSize(0, this.mTextSize);
        }
        int padding = this.mPreviewPadding;
        this.mPrimaryText.setIncludeFontPadding(false);
        this.mPrimaryText.setPadding(padding, padding, padding, padding);
        this.mSecondaryText.setIncludeFontPadding(false);
        this.mSecondaryText.setPadding(padding, padding, padding, padding);
        refreshDrawablePressedState();
    }

    public void setStyle(int resId) {
        Context context = this.mList.getContext();
        TypedArray ta2 = context.obtainStyledAttributes(null, R.styleable.FastScroll, 16843767, resId);
        int N = ta2.getIndexCount();
        for (int i10 = 0; i10 < N; i10++) {
            int index = ta2.getIndex(i10);
            switch (index) {
                case 0:
                    this.mTextAppearance = ta2.getResourceId(index, 0);
                    break;
                case 1:
                    this.mTextSize = ta2.getDimensionPixelSize(index, 0);
                    break;
                case 2:
                    this.mTextColor = ta2.getColorStateList(index);
                    break;
                case 3:
                    this.mPreviewPadding = ta2.getDimensionPixelSize(index, 0);
                    break;
                case 4:
                    this.mPreviewMinWidth = ta2.getDimensionPixelSize(index, 0);
                    break;
                case 5:
                    this.mPreviewMinHeight = ta2.getDimensionPixelSize(index, 0);
                    break;
                case 6:
                    this.mThumbPosition = ta2.getInt(index, 0);
                    break;
                case 7:
                    this.mPreviewResId[0] = ta2.getResourceId(index, 0);
                    break;
                case 8:
                    this.mPreviewResId[1] = ta2.getResourceId(index, 0);
                    break;
                case 9:
                    this.mOverlayPosition = ta2.getInt(index, 0);
                    break;
                case 10:
                    this.mThumbDrawable = ta2.getDrawable(index);
                    break;
                case 11:
                    this.mThumbMinHeight = ta2.getDimensionPixelSize(index, 0);
                    break;
                case 12:
                    this.mThumbMinWidth = ta2.getDimensionPixelSize(index, 0);
                    break;
                case 13:
                    this.mTrackDrawable = ta2.getDrawable(index);
                    break;
            }
        }
        ta2.recycle();
        updateAppearance();
    }

    public void remove() {
        this.mOverlay.remove(this.mTrackImage);
        this.mOverlay.remove(this.mThumbImage);
        this.mOverlay.remove(this.mPreviewImage);
        this.mOverlay.remove(this.mPrimaryText);
        this.mOverlay.remove(this.mSecondaryText);
    }

    public void setEnabled(boolean enabled) {
        if (this.mEnabled != enabled) {
            this.mEnabled = enabled;
            onStateDependencyChanged(true);
        }
    }

    public boolean isEnabled() {
        return this.mEnabled && (this.mLongList || this.mAlwaysShow);
    }

    public void setAlwaysShow(boolean alwaysShow) {
        if (this.mAlwaysShow != alwaysShow) {
            this.mAlwaysShow = alwaysShow;
            onStateDependencyChanged(false);
        }
    }

    public boolean isAlwaysShowEnabled() {
        return this.mAlwaysShow;
    }

    private void onStateDependencyChanged(boolean peekIfEnabled) {
        if (isEnabled()) {
            if (isAlwaysShowEnabled()) {
                setState(1);
            } else if (this.mState == 1) {
                postAutoHide();
            } else if (peekIfEnabled) {
                setState(1);
                postAutoHide();
            }
        } else {
            stop();
        }
        this.mList.resolvePadding();
    }

    public void setScrollBarStyle(int style) {
        if (this.mScrollBarStyle != style) {
            this.mScrollBarStyle = style;
            updateLayout();
        }
    }

    public void stop() {
        setState(0);
    }

    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v3 */
    public void setScrollbarPosition(int position) {
        ?? r02 = 1;
        if (position == 0) {
            position = this.mList.isLayoutRtl() ? 1 : 2;
        }
        if (this.mScrollbarPosition != position) {
            this.mScrollbarPosition = position;
            if (position == 1) {
                r02 = 0;
            }
            this.mLayoutFromRight = r02;
            int previewResId = this.mPreviewResId[r02];
            this.mPreviewImage.setBackgroundResource(previewResId);
            int textMinWidth = Math.max(0, (this.mPreviewMinWidth - this.mPreviewImage.getPaddingLeft()) - this.mPreviewImage.getPaddingRight());
            this.mPrimaryText.setMinimumWidth(textMinWidth);
            this.mSecondaryText.setMinimumWidth(textMinWidth);
            int textMinHeight = Math.max(0, (this.mPreviewMinHeight - this.mPreviewImage.getPaddingTop()) - this.mPreviewImage.getPaddingBottom());
            this.mPrimaryText.setMinimumHeight(textMinHeight);
            this.mSecondaryText.setMinimumHeight(textMinHeight);
            updateLayout();
        }
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void onSizeChanged(int w3, int h10, int oldw, int oldh) {
        updateLayout();
    }

    public void onItemCountChanged(int childCount, int itemCount) {
        if (this.mOldItemCount != itemCount || this.mOldChildCount != childCount) {
            this.mOldItemCount = itemCount;
            this.mOldChildCount = childCount;
            boolean hasMoreItems = itemCount - childCount > 0;
            if (hasMoreItems && this.mState != 2) {
                int firstVisibleItem = this.mList.getFirstVisiblePosition();
                setThumbPos(getPosFromItemCount(firstVisibleItem, childCount, itemCount));
            }
            updateLongList(childCount, itemCount);
        }
    }

    private void updateLongList(int childCount, int itemCount) {
        boolean longList = childCount > 0 && itemCount / childCount >= 4;
        if (this.mLongList != longList) {
            this.mLongList = longList;
            onStateDependencyChanged(false);
        }
    }

    private TextView createPreviewTextView(Context context) {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(-2, -2);
        TextView textView = new TextView(context);
        textView.setLayoutParams(params);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        textView.setGravity(17);
        textView.setAlpha(0.0f);
        textView.setLayoutDirection(this.mList.getLayoutDirection());
        return textView;
    }

    public void updateLayout() {
        if (this.mUpdatingLayout) {
            return;
        }
        this.mUpdatingLayout = true;
        updateContainerRect();
        layoutThumb();
        layoutTrack();
        updateOffsetAndRange();
        Rect bounds = this.mTempBounds;
        measurePreview(this.mPrimaryText, bounds);
        applyLayout(this.mPrimaryText, bounds);
        measurePreview(this.mSecondaryText, bounds);
        applyLayout(this.mSecondaryText, bounds);
        if (this.mPreviewImage != null) {
            bounds.left -= this.mPreviewImage.getPaddingLeft();
            bounds.top -= this.mPreviewImage.getPaddingTop();
            bounds.right += this.mPreviewImage.getPaddingRight();
            bounds.bottom += this.mPreviewImage.getPaddingBottom();
            applyLayout(this.mPreviewImage, bounds);
        }
        this.mUpdatingLayout = false;
    }

    private void applyLayout(View view, Rect bounds) {
        view.layout(bounds.left, bounds.top, bounds.right, bounds.bottom);
        view.setPivotX(this.mLayoutFromRight ? bounds.right - bounds.left : 0.0f);
    }

    private void measurePreview(View v2, Rect out) {
        Rect margins = this.mTempMargins;
        margins.left = this.mPreviewImage.getPaddingLeft();
        margins.top = this.mPreviewImage.getPaddingTop();
        margins.right = this.mPreviewImage.getPaddingRight();
        margins.bottom = this.mPreviewImage.getPaddingBottom();
        if (this.mOverlayPosition == 0) {
            measureFloating(v2, margins, out);
        } else {
            measureViewToSide(v2, this.mThumbImage, margins, out);
        }
    }

    private void measureViewToSide(View view, View adjacent, Rect margins, Rect out) {
        int marginLeft;
        int marginTop;
        int marginRight;
        int maxWidth;
        int left;
        int right;
        if (margins == null) {
            marginLeft = 0;
            marginTop = 0;
            marginRight = 0;
        } else {
            marginLeft = margins.left;
            marginTop = margins.top;
            marginRight = margins.right;
        }
        Rect container = this.mContainerRect;
        int containerWidth = container.width();
        if (adjacent == null) {
            maxWidth = containerWidth;
        } else if (this.mLayoutFromRight) {
            maxWidth = adjacent.getLeft();
        } else {
            int maxWidth2 = adjacent.getRight();
            maxWidth = containerWidth - maxWidth2;
        }
        int adjMaxHeight = Math.max(0, container.height());
        int adjMaxWidth = Math.max(0, (maxWidth - marginLeft) - marginRight);
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(adjMaxWidth, Integer.MIN_VALUE);
        int heightMeasureSpec = View.MeasureSpec.makeSafeMeasureSpec(adjMaxHeight, 0);
        view.measure(widthMeasureSpec, heightMeasureSpec);
        int width = Math.min(adjMaxWidth, view.getMeasuredWidth());
        if (this.mLayoutFromRight) {
            right = (adjacent == null ? container.right : adjacent.getLeft()) - marginRight;
            left = right - width;
        } else {
            left = (adjacent == null ? container.left : adjacent.getRight()) + marginLeft;
            right = left + width;
        }
        int top = marginTop;
        int bottom = top + view.getMeasuredHeight();
        out.set(left, top, right, bottom);
    }

    private void measureFloating(View preview, Rect margins, Rect out) {
        int marginLeft;
        int marginTop;
        int marginRight;
        if (margins == null) {
            marginLeft = 0;
            marginTop = 0;
            marginRight = 0;
        } else {
            marginLeft = margins.left;
            marginTop = margins.top;
            marginRight = margins.right;
        }
        Rect container = this.mContainerRect;
        int containerWidth = container.width();
        int adjMaxHeight = Math.max(0, container.height());
        int adjMaxWidth = Math.max(0, (containerWidth - marginLeft) - marginRight);
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(adjMaxWidth, Integer.MIN_VALUE);
        int heightMeasureSpec = View.MeasureSpec.makeSafeMeasureSpec(adjMaxHeight, 0);
        preview.measure(widthMeasureSpec, heightMeasureSpec);
        int containerHeight = container.height();
        int width = preview.getMeasuredWidth();
        int top = (containerHeight / 10) + marginTop + container.top;
        int bottom = preview.getMeasuredHeight() + top;
        int left = ((containerWidth - width) / 2) + container.left;
        int marginLeft2 = left + width;
        out.set(left, top, marginLeft2, bottom);
    }

    private void updateContainerRect() {
        AbsListView list = this.mList;
        list.resolvePadding();
        Rect container = this.mContainerRect;
        container.left = 0;
        container.top = 0;
        container.right = list.getWidth();
        container.bottom = list.getHeight();
        int scrollbarStyle = this.mScrollBarStyle;
        if (scrollbarStyle == 16777216 || scrollbarStyle == 0) {
            container.left += list.getPaddingLeft();
            container.top += list.getPaddingTop();
            container.right -= list.getPaddingRight();
            container.bottom -= list.getPaddingBottom();
            if (scrollbarStyle == 16777216) {
                int width = getWidth();
                if (this.mScrollbarPosition == 2) {
                    container.right += width;
                } else {
                    container.left -= width;
                }
            }
        }
    }

    private void layoutThumb() {
        Rect bounds = this.mTempBounds;
        measureViewToSide(this.mThumbImage, null, null, bounds);
        applyLayout(this.mThumbImage, bounds);
    }

    private void layoutTrack() {
        int thumbHalfHeight;
        int top;
        View track = this.mTrackImage;
        View thumb = this.mThumbImage;
        Rect container = this.mContainerRect;
        int maxWidth = Math.max(0, container.width());
        int maxHeight = Math.max(0, container.height());
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(maxWidth, Integer.MIN_VALUE);
        int heightMeasureSpec = View.MeasureSpec.makeSafeMeasureSpec(maxHeight, 0);
        track.measure(widthMeasureSpec, heightMeasureSpec);
        if (this.mThumbPosition == 1) {
            thumbHalfHeight = container.top;
            top = container.bottom;
        } else {
            int top2 = thumb.getHeight();
            int thumbHalfHeight2 = top2 / 2;
            int top3 = container.top + thumbHalfHeight2;
            int i10 = container.bottom - thumbHalfHeight2;
            thumbHalfHeight = top3;
            top = i10;
        }
        int trackWidth = track.getMeasuredWidth();
        int left = thumb.getLeft() + ((thumb.getWidth() - trackWidth) / 2);
        int right = left + trackWidth;
        track.layout(left, thumbHalfHeight, right, top);
    }

    private void updateOffsetAndRange() {
        float min;
        float max;
        View trackImage = this.mTrackImage;
        View thumbImage = this.mThumbImage;
        if (this.mThumbPosition == 1) {
            float halfThumbHeight = thumbImage.getHeight() / 2.0f;
            min = trackImage.getTop() + halfThumbHeight;
            max = trackImage.getBottom() - halfThumbHeight;
        } else {
            min = trackImage.getTop();
            max = trackImage.getBottom();
        }
        this.mThumbOffset = min;
        this.mThumbRange = max - min;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(int state) {
        this.mList.removeCallbacks(this.mDeferHide);
        if (this.mAlwaysShow && state == 0) {
            state = 1;
        }
        if (state == this.mState) {
            return;
        }
        switch (state) {
            case 0:
                transitionToHidden();
                break;
            case 1:
                transitionToVisible();
                break;
            case 2:
                if (transitionPreviewLayout(this.mCurrentSection)) {
                    transitionToDragging();
                    break;
                } else {
                    transitionToVisible();
                    break;
                }
        }
        this.mState = state;
        refreshDrawablePressedState();
    }

    private void refreshDrawablePressedState() {
        boolean isPressed = this.mState == 2;
        this.mThumbImage.setPressed(isPressed);
        this.mTrackImage.setPressed(isPressed);
    }

    private void transitionToHidden() {
        AnimatorSet animatorSet = this.mDecorAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        Animator fadeOut = groupAnimatorOfFloat(View.ALPHA, 0.0f, this.mThumbImage, this.mTrackImage, this.mPreviewImage, this.mPrimaryText, this.mSecondaryText).setDuration(300L);
        float offset = this.mLayoutFromRight ? this.mThumbImage.getWidth() : -this.mThumbImage.getWidth();
        Animator slideOut = groupAnimatorOfFloat(View.TRANSLATION_X, offset, this.mThumbImage, this.mTrackImage).setDuration(300L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mDecorAnimation = animatorSet2;
        animatorSet2.playTogether(fadeOut, slideOut);
        this.mDecorAnimation.start();
        this.mShowingPreview = false;
    }

    private void transitionToVisible() {
        AnimatorSet animatorSet = this.mDecorAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        Animator fadeIn = groupAnimatorOfFloat(View.ALPHA, 1.0f, this.mThumbImage, this.mTrackImage).setDuration(150L);
        Animator fadeOut = groupAnimatorOfFloat(View.ALPHA, 0.0f, this.mPreviewImage, this.mPrimaryText, this.mSecondaryText).setDuration(300L);
        Animator slideIn = groupAnimatorOfFloat(View.TRANSLATION_X, 0.0f, this.mThumbImage, this.mTrackImage).setDuration(150L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mDecorAnimation = animatorSet2;
        animatorSet2.playTogether(fadeIn, fadeOut, slideIn);
        this.mDecorAnimation.start();
        this.mShowingPreview = false;
    }

    private void transitionToDragging() {
        AnimatorSet animatorSet = this.mDecorAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        Animator fadeIn = groupAnimatorOfFloat(View.ALPHA, 1.0f, this.mThumbImage, this.mTrackImage, this.mPreviewImage).setDuration(150L);
        Animator slideIn = groupAnimatorOfFloat(View.TRANSLATION_X, 0.0f, this.mThumbImage, this.mTrackImage).setDuration(150L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mDecorAnimation = animatorSet2;
        animatorSet2.playTogether(fadeIn, slideIn);
        this.mDecorAnimation.start();
        this.mShowingPreview = true;
    }

    private void postAutoHide() {
        this.mList.removeCallbacks(this.mDeferHide);
        this.mList.postDelayed(this.mDeferHide, FADE_TIMEOUT);
    }

    public void onScroll(int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (!isEnabled()) {
            setState(0);
            return;
        }
        boolean hasMoreItems = totalItemCount - visibleItemCount > 0;
        if (hasMoreItems && this.mState != 2) {
            setThumbPos(getPosFromItemCount(firstVisibleItem, visibleItemCount, totalItemCount));
        }
        this.mScrollCompleted = true;
        if (this.mFirstVisibleItem != firstVisibleItem) {
            this.mFirstVisibleItem = firstVisibleItem;
            if (this.mState != 2) {
                setState(1);
                postAutoHide();
            }
        }
    }

    private void getSectionsFromIndexer() {
        this.mSectionIndexer = null;
        Adapter adapter = this.mList.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            this.mHeaderCount = ((HeaderViewListAdapter) adapter).getHeadersCount();
            adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
        }
        if (adapter instanceof ExpandableListConnector) {
            ExpandableListAdapter expAdapter = ((ExpandableListConnector) adapter).getAdapter();
            if (expAdapter instanceof SectionIndexer) {
                SectionIndexer sectionIndexer = (SectionIndexer) expAdapter;
                this.mSectionIndexer = sectionIndexer;
                this.mListAdapter = adapter;
                this.mSections = sectionIndexer.getSections();
                return;
            }
            return;
        }
        if (adapter instanceof SectionIndexer) {
            this.mListAdapter = adapter;
            SectionIndexer sectionIndexer2 = (SectionIndexer) adapter;
            this.mSectionIndexer = sectionIndexer2;
            this.mSections = sectionIndexer2.getSections();
            return;
        }
        this.mListAdapter = adapter;
        this.mSections = null;
    }

    public void onSectionsChanged() {
        this.mListAdapter = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        if (r9 == r7) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
    
        if (r6 <= 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
    
        r6 = r6 - 1;
        r10 = r20.mSectionIndexer.getPositionForSection(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
    
        if (r10 == r7) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        if (r6 != 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        r11 = r6;
        r8 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        r13 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        if (r13 >= r4) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
    
        if (r20.mSectionIndexer.getPositionForSection(r13) != r9) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        r13 = r13 + 1;
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
    
        r14 = r11 / r4;
        r15 = r12 / r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        if (r2 != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
    
        r1 = Float.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
    
        if (r11 != r5) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
    
        if ((r21 - r14) >= r1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        r3 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008b, code lost:
    
        r3 = android.util.MathUtils.constrain(r3, 0, r2 - 1);
        r1 = r20.mList;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0098, code lost:
    
        if ((r1 instanceof android.widget.ExpandableListView) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009a, code lost:
    
        r1 = (android.widget.ExpandableListView) r1;
        r1.setSelectionFromTop(r1.getFlatListPosition(android.widget.ExpandableListView.getPackedPositionForGroup(r20.mHeaderCount + r3)), 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b7, code lost:
    
        if ((r1 instanceof android.widget.ListView) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b9, code lost:
    
        ((android.widget.ListView) r1).setSelectionFromTop(r20.mHeaderCount + r3, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c2, code lost:
    
        r1.setSelection(r20.mHeaderCount + r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x007e, code lost:
    
        r3 = ((int) (((r9 - r10) * (r21 - r14)) / (r15 - r14))) + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x006e, code lost:
    
        r1 = 0.125f / r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void scrollTo(float r21) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.FastScroller.scrollTo(float):void");
    }

    private boolean transitionPreviewLayout(int sectionIndex) {
        TextView showing;
        TextView target;
        Object section;
        Object[] sections = this.mSections;
        String text = null;
        if (sections != null && sectionIndex >= 0 && sectionIndex < sections.length && (section = sections[sectionIndex]) != null) {
            text = section.toString();
        }
        Rect bounds = this.mTempBounds;
        View preview = this.mPreviewImage;
        if (this.mShowingPrimary) {
            showing = this.mPrimaryText;
            target = this.mSecondaryText;
        } else {
            showing = this.mSecondaryText;
            target = this.mPrimaryText;
        }
        target.setText(text);
        measurePreview(target, bounds);
        applyLayout(target, bounds);
        AnimatorSet animatorSet = this.mPreviewAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        Animator showTarget = animateAlpha(target, 1.0f).setDuration(50L);
        Animator hideShowing = animateAlpha(showing, 0.0f).setDuration(50L);
        hideShowing.addListener(this.mSwitchPrimaryListener);
        bounds.left -= preview.getPaddingLeft();
        bounds.top -= preview.getPaddingTop();
        bounds.right += preview.getPaddingRight();
        bounds.bottom += preview.getPaddingBottom();
        Animator resizePreview = animateBounds(preview, bounds);
        resizePreview.setDuration(100L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mPreviewAnimation = animatorSet2;
        AnimatorSet.Builder builder = animatorSet2.play(hideShowing).with(showTarget);
        builder.with(resizePreview);
        int previewWidth = (preview.getWidth() - preview.getPaddingLeft()) - preview.getPaddingRight();
        int targetWidth = target.getWidth();
        if (targetWidth <= previewWidth) {
            target.setScaleX(1.0f);
        } else {
            target.setScaleX(previewWidth / targetWidth);
            Animator scaleAnim = animateScaleX(target, 1.0f).setDuration(100L);
            builder.with(scaleAnim);
        }
        int showingWidth = showing.getWidth();
        if (showingWidth > targetWidth) {
            float scale = targetWidth / showingWidth;
            Animator scaleAnim2 = animateScaleX(showing, scale).setDuration(100L);
            builder.with(scaleAnim2);
        }
        this.mPreviewAnimation.start();
        return !TextUtils.isEmpty(text);
    }

    private void setThumbPos(float position) {
        float previewPos;
        float thumbMiddle = (this.mThumbRange * position) + this.mThumbOffset;
        this.mThumbImage.setTranslationY(thumbMiddle - (r1.getHeight() / 2.0f));
        View previewImage = this.mPreviewImage;
        float previewHalfHeight = previewImage.getHeight() / 2.0f;
        switch (this.mOverlayPosition) {
            case 1:
                previewPos = thumbMiddle;
                break;
            case 2:
                previewPos = thumbMiddle - previewHalfHeight;
                break;
            default:
                previewPos = 0.0f;
                break;
        }
        Rect container = this.mContainerRect;
        int top = container.top;
        int bottom = container.bottom;
        float minP = top + previewHalfHeight;
        float maxP = bottom - previewHalfHeight;
        float previewMiddle = MathUtils.constrain(previewPos, minP, maxP);
        float previewTop = previewMiddle - previewHalfHeight;
        previewImage.setTranslationY(previewTop);
        this.mPrimaryText.setTranslationY(previewTop);
        this.mSecondaryText.setTranslationY(previewTop);
    }

    private float getPosFromMotionEvent(float y10) {
        float f10 = this.mThumbRange;
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        return MathUtils.constrain((y10 - this.mThumbOffset) / f10, 0.0f, 1.0f);
    }

    private float getPosFromItemCount(int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        float incrementalPos;
        int nextSectionPos;
        float posWithinSection;
        int currentVisibleSize;
        int maxSize;
        int nextSectionPos2;
        Object[] objArr;
        SectionIndexer sectionIndexer = this.mSectionIndexer;
        if (sectionIndexer == null || this.mListAdapter == null) {
            getSectionsFromIndexer();
        }
        if (visibleItemCount == 0 || totalItemCount == 0) {
            return 0.0f;
        }
        boolean hasSections = (sectionIndexer == null || (objArr = this.mSections) == null || objArr.length <= 0) ? false : true;
        if (!hasSections || !this.mMatchDragPosition) {
            if (visibleItemCount == totalItemCount) {
                return 0.0f;
            }
            return firstVisibleItem / (totalItemCount - visibleItemCount);
        }
        int i10 = this.mHeaderCount;
        int firstVisibleItem2 = firstVisibleItem - i10;
        if (firstVisibleItem2 < 0) {
            return 0.0f;
        }
        int totalItemCount2 = totalItemCount - i10;
        View child = this.mList.getChildAt(0);
        if (child == null || child.getHeight() == 0) {
            incrementalPos = 0.0f;
        } else {
            incrementalPos = (this.mList.getPaddingTop() - child.getTop()) / child.getHeight();
        }
        int section = sectionIndexer.getSectionForPosition(firstVisibleItem2);
        int sectionPos = sectionIndexer.getPositionForSection(section);
        int sectionCount = this.mSections.length;
        if (section < sectionCount - 1) {
            if (section + 1 < sectionCount) {
                nextSectionPos2 = sectionIndexer.getPositionForSection(section + 1);
            } else {
                nextSectionPos2 = totalItemCount2 - 1;
            }
            nextSectionPos = nextSectionPos2 - sectionPos;
        } else {
            nextSectionPos = totalItemCount2 - sectionPos;
        }
        if (nextSectionPos == 0) {
            posWithinSection = 0.0f;
        } else {
            float posWithinSection2 = firstVisibleItem2;
            posWithinSection = ((posWithinSection2 + incrementalPos) - sectionPos) / nextSectionPos;
        }
        float result = (section + posWithinSection) / sectionCount;
        if (firstVisibleItem2 > 0 && firstVisibleItem2 + visibleItemCount == totalItemCount2) {
            View lastChild = this.mList.getChildAt(visibleItemCount - 1);
            int bottomPadding = this.mList.getPaddingBottom();
            if (this.mList.getClipToPadding()) {
                int maxSize2 = lastChild.getHeight();
                currentVisibleSize = (this.mList.getHeight() - bottomPadding) - lastChild.getTop();
                maxSize = maxSize2;
            } else {
                int currentVisibleSize2 = lastChild.getHeight();
                int maxSize3 = currentVisibleSize2 + bottomPadding;
                currentVisibleSize = this.mList.getHeight() - lastChild.getTop();
                maxSize = maxSize3;
            }
            if (currentVisibleSize > 0 && maxSize > 0) {
                return result + ((1.0f - result) * (currentVisibleSize / maxSize));
            }
            return result;
        }
        return result;
    }

    private void cancelFling() {
        MotionEvent cancelFling = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
        this.mList.onTouchEvent(cancelFling);
        cancelFling.recycle();
    }

    private void cancelPendingDrag() {
        this.mPendingDrag = -1L;
    }

    private void startPendingDrag() {
        this.mPendingDrag = SystemClock.uptimeMillis() + TAP_TIMEOUT;
    }

    private void beginDrag() {
        this.mPendingDrag = -1L;
        setState(2);
        if (this.mListAdapter == null && this.mList != null) {
            getSectionsFromIndexer();
        }
        AbsListView absListView = this.mList;
        if (absListView != null) {
            absListView.requestDisallowInterceptTouchEvent(true);
            this.mList.reportScrollStateChange(1);
        }
        cancelFling();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (!isEnabled()) {
            return false;
        }
        switch (ev.getActionMasked()) {
            case 0:
                if (isPointInside(ev.getX(), ev.getY())) {
                    if (!this.mList.isInScrollingContainer()) {
                        return true;
                    }
                    this.mInitialTouchY = ev.getY();
                    startPendingDrag();
                }
                return false;
            case 1:
            case 3:
                cancelPendingDrag();
                return false;
            case 2:
                if (!isPointInside(ev.getX(), ev.getY())) {
                    cancelPendingDrag();
                } else {
                    long j10 = this.mPendingDrag;
                    if (j10 >= 0 && j10 <= SystemClock.uptimeMillis()) {
                        beginDrag();
                        float pos = getPosFromMotionEvent(this.mInitialTouchY);
                        scrollTo(pos);
                        return onTouchEvent(ev);
                    }
                }
                return false;
            default:
                return false;
        }
    }

    public boolean onInterceptHoverEvent(MotionEvent ev) {
        if (!isEnabled()) {
            return false;
        }
        int actionMasked = ev.getActionMasked();
        if ((actionMasked == 9 || actionMasked == 7) && this.mState == 0 && isPointInside(ev.getX(), ev.getY())) {
            setState(1);
            postAutoHide();
        }
        return false;
    }

    public PointerIcon onResolvePointerIcon(MotionEvent event, int pointerIndex) {
        if (this.mState == 2 || isPointInside(event.getX(), event.getY())) {
            return PointerIcon.getSystemIcon(this.mList.getContext(), 1000);
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean onTouchEvent(MotionEvent me2) {
        if (!isEnabled()) {
            return false;
        }
        switch (me2.getActionMasked()) {
            case 0:
                if (isPointInside(me2.getX(), me2.getY()) && !this.mList.isInScrollingContainer()) {
                    beginDrag();
                    return true;
                }
                return false;
            case 1:
                if (this.mPendingDrag >= 0) {
                    beginDrag();
                    float pos = getPosFromMotionEvent(me2.getY());
                    setThumbPos(pos);
                    scrollTo(pos);
                }
                if (this.mState == 2) {
                    AbsListView absListView = this.mList;
                    if (absListView != null) {
                        absListView.requestDisallowInterceptTouchEvent(false);
                        this.mList.reportScrollStateChange(0);
                    }
                    setState(1);
                    postAutoHide();
                    return true;
                }
                return false;
            case 2:
                if (this.mPendingDrag >= 0 && Math.abs(me2.getY() - this.mInitialTouchY) > this.mScaledTouchSlop) {
                    beginDrag();
                }
                if (this.mState == 2) {
                    float pos2 = getPosFromMotionEvent(me2.getY());
                    setThumbPos(pos2);
                    if (this.mScrollCompleted) {
                        scrollTo(pos2);
                    }
                    return true;
                }
                return false;
            case 3:
                cancelPendingDrag();
                return false;
            default:
                return false;
        }
    }

    private boolean isPointInside(float x10, float y10) {
        return isPointInsideX(x10) && (this.mTrackDrawable != null || isPointInsideY(y10));
    }

    private boolean isPointInsideX(float x10) {
        float offset = this.mThumbImage.getTranslationX();
        float left = this.mThumbImage.getLeft() + offset;
        float right = this.mThumbImage.getRight() + offset;
        float targetSizeDiff = this.mMinimumTouchTarget - (right - left);
        float adjust = targetSizeDiff > 0.0f ? targetSizeDiff : 0.0f;
        return this.mLayoutFromRight ? x10 >= ((float) this.mThumbImage.getLeft()) - adjust : x10 <= ((float) this.mThumbImage.getRight()) + adjust;
    }

    private boolean isPointInsideY(float y10) {
        float offset = this.mThumbImage.getTranslationY();
        float top = this.mThumbImage.getTop() + offset;
        float bottom = this.mThumbImage.getBottom() + offset;
        float targetSizeDiff = this.mMinimumTouchTarget - (bottom - top);
        float adjust = targetSizeDiff > 0.0f ? targetSizeDiff / 2.0f : 0.0f;
        return y10 >= top - adjust && y10 <= bottom + adjust;
    }

    private static Animator groupAnimatorOfFloat(Property<View, Float> property, float value, View... views) {
        AnimatorSet animSet = new AnimatorSet();
        AnimatorSet.Builder builder = null;
        for (int i10 = views.length - 1; i10 >= 0; i10--) {
            Animator anim = ObjectAnimator.ofFloat(views[i10], property, value);
            if (builder == null) {
                builder = animSet.play(anim);
            } else {
                builder.with(anim);
            }
        }
        return animSet;
    }

    private static Animator animateScaleX(View v2, float target) {
        return ObjectAnimator.ofFloat(v2, View.SCALE_X, target);
    }

    private static Animator animateAlpha(View v2, float alpha) {
        return ObjectAnimator.ofFloat(v2, View.ALPHA, alpha);
    }

    private static Animator animateBounds(View v2, Rect bounds) {
        PropertyValuesHolder left = PropertyValuesHolder.ofInt(LEFT, bounds.left);
        PropertyValuesHolder top = PropertyValuesHolder.ofInt(TOP, bounds.top);
        PropertyValuesHolder right = PropertyValuesHolder.ofInt(RIGHT, bounds.right);
        PropertyValuesHolder bottom = PropertyValuesHolder.ofInt(BOTTOM, bounds.bottom);
        return ObjectAnimator.ofPropertyValuesHolder(v2, left, top, right, bottom);
    }
}
