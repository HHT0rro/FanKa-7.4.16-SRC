package android.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.android.internal.R;
import com.android.internal.widget.CachingIconView;
import com.android.internal.widget.NotificationExpandButton;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@RemoteViews.RemoteView
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class NotificationHeaderView extends RelativeLayout {
    private boolean mAcceptAllTouches;
    private View mAltExpandTarget;
    private Drawable mBackground;
    private boolean mEntireHeaderClickable;
    private NotificationExpandButton mExpandButton;
    private View.OnClickListener mExpandClickListener;
    private boolean mExpandOnlyOnButton;
    private CachingIconView mIcon;
    ViewOutlineProvider mProvider;
    private NotificationTopLineView mTopLineView;
    private HeaderTouchListener mTouchListener;
    private final int mTouchableHeight;

    public NotificationHeaderView(Context context) {
        this(context, null);
    }

    public NotificationHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NotificationHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public NotificationHeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mTouchListener = new HeaderTouchListener();
        this.mProvider = new ViewOutlineProvider() { // from class: android.view.NotificationHeaderView.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (NotificationHeaderView.this.mBackground != null) {
                    outline.setRect(0, 0, NotificationHeaderView.this.getWidth(), NotificationHeaderView.this.getHeight());
                    outline.setAlpha(1.0f);
                }
            }
        };
        Resources res = getResources();
        this.mTouchableHeight = res.getDimensionPixelSize(17105433);
        this.mEntireHeaderClickable = res.getBoolean(R.bool.config_notificationHeaderClickableForExpand);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mIcon = findViewById(16908294);
        this.mTopLineView = (NotificationTopLineView) findViewById(16909316);
        this.mExpandButton = findViewById(16908991);
        this.mAltExpandTarget = findViewById(16908775);
        setClipToPadding(false);
    }

    public void setHeaderBackgroundDrawable(Drawable drawable) {
        if (drawable != null) {
            setWillNotDraw(false);
            this.mBackground = drawable;
            drawable.setCallback(this);
            setOutlineProvider(this.mProvider);
        } else {
            setWillNotDraw(true);
            this.mBackground = null;
            setOutlineProvider(null);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = this.mBackground;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getHeight());
            this.mBackground.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.mBackground;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Drawable drawable = this.mBackground;
        if (drawable != null && drawable.isStateful()) {
            this.mBackground.setState(getDrawableState());
        }
    }

    private void updateTouchListener() {
        if (this.mExpandClickListener == null) {
            setOnTouchListener(null);
        } else {
            setOnTouchListener(this.mTouchListener);
            this.mTouchListener.bindTouchRects();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l10) {
        this.mExpandClickListener = l10;
        this.mExpandButton.setOnClickListener(l10);
        this.mAltExpandTarget.setOnClickListener(this.mExpandClickListener);
        updateTouchListener();
    }

    public void setTopLineExtraMarginEnd(int extraMarginEnd) {
        this.mTopLineView.setHeaderTextMarginEnd(extraMarginEnd);
    }

    @RemotableViewMethod
    public void setTopLineExtraMarginEndDp(float extraMarginEndDp) {
        setTopLineExtraMarginEnd((int) (getResources().getDisplayMetrics().density * extraMarginEndDp));
    }

    @RemotableViewMethod
    public void styleTextAsTitle(boolean styleTextAsTitle) {
        int styleResId;
        if (styleTextAsTitle) {
            styleResId = 16974716;
        } else {
            styleResId = 16974713;
        }
        View headerText = findViewById(16909088);
        if (headerText instanceof TextView) {
            ((TextView) headerText).setTextAppearance(styleResId);
        }
        View appNameText = findViewById(16908789);
        if (appNameText instanceof TextView) {
            ((TextView) appNameText).setTextAppearance(styleResId);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class HeaderTouchListener implements View.OnTouchListener {
        private Rect mAltExpandTargetRect;
        private float mDownX;
        private float mDownY;
        private Rect mExpandButtonRect;
        private final ArrayList<Rect> mTouchRects = new ArrayList<>();
        private int mTouchSlop;
        private boolean mTrackGesture;

        public HeaderTouchListener() {
        }

        public void bindTouchRects() {
            this.mTouchRects.clear();
            addRectAroundView(NotificationHeaderView.this.mIcon);
            this.mExpandButtonRect = addRectAroundView(NotificationHeaderView.this.mExpandButton);
            this.mAltExpandTargetRect = addRectAroundView(NotificationHeaderView.this.mAltExpandTarget);
            addWidthRect();
            this.mTouchSlop = ViewConfiguration.get(NotificationHeaderView.this.getContext()).getScaledTouchSlop();
        }

        private void addWidthRect() {
            Rect r10 = new Rect();
            r10.top = 0;
            r10.bottom = NotificationHeaderView.this.mTouchableHeight;
            r10.left = 0;
            r10.right = NotificationHeaderView.this.getWidth();
            this.mTouchRects.add(r10);
        }

        private Rect addRectAroundView(View view) {
            Rect r10 = getRectAroundView(view);
            this.mTouchRects.add(r10);
            return r10;
        }

        private Rect getRectAroundView(View view) {
            float size = NotificationHeaderView.this.getResources().getDisplayMetrics().density * 48.0f;
            float width = Math.max(size, view.getWidth());
            float height = Math.max(size, view.getHeight());
            Rect r10 = new Rect();
            if (view.getVisibility() == 8) {
                view = NotificationHeaderView.this.getFirstChildNotGone();
                r10.left = (int) (view.getLeft() - (width / 2.0f));
            } else {
                r10.left = (int) (((view.getLeft() + view.getRight()) / 2.0f) - (width / 2.0f));
            }
            r10.top = (int) (((view.getTop() + view.getBottom()) / 2.0f) - (height / 2.0f));
            r10.bottom = (int) (r10.top + height);
            r10.right = (int) (r10.left + width);
            return r10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v2, MotionEvent event) {
            float x10 = event.getX();
            float y10 = event.getY();
            switch (event.getActionMasked() & 255) {
                case 0:
                    this.mTrackGesture = false;
                    if (isInside(x10, y10)) {
                        this.mDownX = x10;
                        this.mDownY = y10;
                        this.mTrackGesture = true;
                        return true;
                    }
                    break;
                case 1:
                    if (this.mTrackGesture) {
                        float topLineX = NotificationHeaderView.this.mTopLineView.getX();
                        float topLineY = NotificationHeaderView.this.mTopLineView.getY();
                        if (!NotificationHeaderView.this.mTopLineView.onTouchUp(x10 - topLineX, y10 - topLineY, this.mDownX - topLineX, this.mDownY - topLineY)) {
                            NotificationHeaderView.this.mExpandButton.performClick();
                            break;
                        }
                    }
                    break;
                case 2:
                    if (this.mTrackGesture && (Math.abs(this.mDownX - x10) > this.mTouchSlop || Math.abs(this.mDownY - y10) > this.mTouchSlop)) {
                        this.mTrackGesture = false;
                        break;
                    }
                    break;
            }
            return this.mTrackGesture;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isInside(float x10, float y10) {
            if (NotificationHeaderView.this.mAcceptAllTouches) {
                return true;
            }
            if (NotificationHeaderView.this.mExpandOnlyOnButton) {
                return this.mExpandButtonRect.contains((int) x10, (int) y10) || this.mAltExpandTargetRect.contains((int) x10, (int) y10);
            }
            for (int i10 = 0; i10 < this.mTouchRects.size(); i10++) {
                Rect r10 = this.mTouchRects.get(i10);
                if (r10.contains((int) x10, (int) y10)) {
                    return true;
                }
            }
            float topLineX = x10 - NotificationHeaderView.this.mTopLineView.getX();
            float topLineY = y10 - NotificationHeaderView.this.mTopLineView.getY();
            return NotificationHeaderView.this.mTopLineView.isInTouchRect(topLineX, topLineY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getFirstChildNotGone() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View child = getChildAt(i10);
            if (child.getVisibility() != 8) {
                return child;
            }
        }
        return this;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public boolean isInTouchRect(float x10, float y10) {
        if (this.mExpandClickListener == null) {
            return false;
        }
        return this.mTouchListener.isInside(x10, y10);
    }

    @RemotableViewMethod
    public void setAcceptAllTouches(boolean acceptAllTouches) {
        this.mAcceptAllTouches = this.mEntireHeaderClickable || acceptAllTouches;
    }

    @RemotableViewMethod
    public void setExpandOnlyOnButton(boolean expandOnlyOnButton) {
        this.mExpandOnlyOnButton = expandOnlyOnButton;
    }
}
