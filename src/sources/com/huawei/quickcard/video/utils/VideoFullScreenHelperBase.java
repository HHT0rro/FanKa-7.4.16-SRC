package com.huawei.quickcard.video.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.FullScreenExtendedParams;
import com.huawei.quickcard.IFullScreenHelper;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.utils.QuickCardComponentUtils;
import com.huawei.quickcard.utils.YogaUtils;
import com.huawei.quickcard.video.view.MediaGestureHelper;
import com.huawei.quickcard.views.div.CardYogaLayout;
import com.huawei.quickcard.views.stack.view.StackLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class VideoFullScreenHelperBase implements IFullScreenHelper {
    private static final String TAG = "VideoFullScreenHelperBase";
    private ViewGroup mContainer;
    private Context mContext;
    public FullScreenExtendedParams mFullScreenExtendedParams;
    private IFullScreenHelper.IFullScreenListener mFullScreenListener;
    private View mNavigationBar;
    private YogaNode mOriginNode;
    private ViewGroup mOriginParent;
    private int mOriginScreenOrientation;
    private View mOriginView;
    private View mPlaceholderView;
    private View mStatusBar;
    private boolean mInFullScreenState = false;
    private boolean hasActionBar = false;
    private boolean hasStatusBar = false;

    @Override // com.huawei.quickcard.IFullScreenHelper
    public boolean enterFullScreen(Context context, @NonNull View view, int i10, Object... objArr) {
        if (this.mInFullScreenState) {
            CardLogUtils.e(TAG, "Current has full screen component, name is " + QuickCardComponentUtils.getComponentInfo(this.mOriginView).getName());
            return false;
        }
        Activity scanForActivity = FullScreenUtils.scanForActivity(context);
        if (scanForActivity == null) {
            return false;
        }
        View decorView = scanForActivity.getWindow().getDecorView();
        if (!(decorView instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) decorView;
        this.mContext = context;
        this.mOriginView = view;
        this.mOriginNode = YogaUtils.getYogaNode(view);
        ViewGroup viewGroup2 = (ViewGroup) this.mOriginView.getParent();
        this.mOriginParent = viewGroup2;
        if (viewGroup2 == null) {
            return false;
        }
        this.mOriginScreenOrientation = scanForActivity.getRequestedOrientation();
        handleActivityOrientation(scanForActivity, i10);
        this.mContainer = (ViewGroup) viewGroup.getChildAt(0);
        this.mStatusBar = viewGroup.findViewById(16908335);
        this.mNavigationBar = viewGroup.findViewById(16908336);
        this.hasStatusBar = FullScreenUtils.hasStatusBar(context);
        this.hasActionBar = FullScreenUtils.actionbarIsShow(context);
        viewGroup.removeAllViews();
        int descendantFocusability = viewGroup.getDescendantFocusability();
        viewGroup.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        int indexOfChild = this.mOriginParent.indexOfChild(this.mOriginView);
        this.mOriginParent.removeView(this.mOriginView);
        if (this.mPlaceholderView == null) {
            this.mPlaceholderView = new View(context);
        }
        this.mOriginParent.addView(this.mPlaceholderView, indexOfChild, this.mOriginView.getLayoutParams());
        viewGroup.addView(this.mOriginView, new ViewGroup.LayoutParams(-1, -1));
        viewGroup.setDescendantFocusability(descendantFocusability);
        FullScreenUtils.setWindowFullScreenState(context, true, this.hasActionBar, this.hasStatusBar);
        handleHostViewOrientation(scanForActivity, i10, this.mOriginView);
        this.mInFullScreenState = true;
        return true;
    }

    @Override // com.huawei.quickcard.IFullScreenHelper
    public boolean exitFullScreen() {
        if (!this.mInFullScreenState) {
            CardLogUtils.d(TAG, "Not in full screen state");
            return false;
        }
        Activity scanForActivity = FullScreenUtils.scanForActivity(this.mContext);
        if (scanForActivity == null) {
            return false;
        }
        View decorView = scanForActivity.getWindow().getDecorView();
        if (!(decorView instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) decorView;
        try {
            IFullScreenHelper.IFullScreenListener iFullScreenListener = this.mFullScreenListener;
            if (iFullScreenListener != null) {
                iFullScreenListener.beforeExitFullScreen();
            }
            resetHostViewOrientation(this.mOriginView);
            scanForActivity.setRequestedOrientation(this.mOriginScreenOrientation);
            int descendantFocusability = viewGroup.getDescendantFocusability();
            viewGroup.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
            viewGroup.removeAllViews();
            viewGroup.addView(this.mContainer);
            View view = this.mStatusBar;
            if (view != null) {
                viewGroup.addView(view);
            }
            View view2 = this.mNavigationBar;
            if (view2 != null) {
                viewGroup.addView(view2);
            }
            View view3 = this.mOriginView;
            if (view3 != null && this.mOriginParent != null) {
                ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                int indexOfChild = this.mOriginParent.indexOfChild(this.mPlaceholderView);
                this.mOriginParent.removeView(this.mPlaceholderView);
                if (indexOfChild >= 0) {
                    YogaNode yogaNode = this.mOriginNode;
                    if (yogaNode != null) {
                        ViewGroup viewGroup2 = this.mOriginParent;
                        if (viewGroup2 instanceof CardYogaLayout) {
                            ((CardYogaLayout) viewGroup2).addView(this.mOriginView, yogaNode, indexOfChild);
                        } else if (viewGroup2 instanceof StackLayout) {
                            ((StackLayout) viewGroup2).addView(this.mOriginView, yogaNode, indexOfChild);
                        }
                    } else {
                        this.mOriginParent.addView(this.mOriginView, indexOfChild, layoutParams);
                    }
                }
            }
            viewGroup.setDescendantFocusability(descendantFocusability);
            FullScreenUtils.setWindowFullScreenState(this.mContext, false, this.hasActionBar, this.hasStatusBar);
            IFullScreenHelper.IFullScreenListener iFullScreenListener2 = this.mFullScreenListener;
            if (iFullScreenListener2 != null) {
                iFullScreenListener2.onExitFullScreen();
            }
            resetParams();
            return true;
        } catch (Throwable th) {
            resetParams();
            throw th;
        }
    }

    @Override // com.huawei.quickcard.IFullScreenHelper
    public FullScreenExtendedParams getExtendedParams() {
        if (this.mFullScreenExtendedParams == null) {
            FullScreenExtendedParams fullScreenExtendedParams = new FullScreenExtendedParams();
            this.mFullScreenExtendedParams = fullScreenExtendedParams;
            fullScreenExtendedParams.setParam("mediaGestureHelper", MediaGestureHelper.class);
        }
        return this.mFullScreenExtendedParams;
    }

    public void handleActivityOrientation(@NonNull Activity activity, int i10) {
    }

    public void handleHostViewOrientation(@NonNull Activity activity, int i10, View view) {
    }

    public void resetHostViewOrientation(View view) {
    }

    public void resetParams() {
        this.mInFullScreenState = false;
        this.mFullScreenListener = null;
        this.hasActionBar = false;
        this.hasStatusBar = false;
        this.mOriginNode = null;
        this.mContainer = null;
        this.mPlaceholderView = null;
        this.mOriginView = null;
        this.mStatusBar = null;
        this.mNavigationBar = null;
        this.mOriginParent = null;
        this.mContext = null;
    }

    @Override // com.huawei.quickcard.IFullScreenHelper
    public void setFullScreenListener(IFullScreenHelper.IFullScreenListener iFullScreenListener) {
        this.mFullScreenListener = iFullScreenListener;
    }
}
