package com.huawei.quickcard.video.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.quickcard.video.utils.FullScreenUtils;
import com.huawei.quickcard.video.view.BaseMediaGestureHelper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RotateMediaGestureHelper extends MediaGestureHelper {
    private static final String TAG = "RotateMediaGestureHelper";
    private int mDegree;
    private boolean mDegreeSeted;

    public RotateMediaGestureHelper(Context context, BaseMediaGestureHelper.MediaGestureHelperHoster mediaGestureHelperHoster) {
        super(context, mediaGestureHelperHoster);
        initParams();
    }

    private void initParams() {
        this.mDegreeSeted = false;
        this.mDegree = 0;
    }

    private void resetWidthAndHeight() {
        this.mMeasuredWidth = this.mWrapper.getHosterMeasuredWidth();
        this.mMeasuredHeight = this.mWrapper.getHosterMeasuredHeight();
    }

    @Override // com.huawei.quickcard.video.view.MediaGestureHelper
    public View createBrightnessDialogView() {
        View createBrightnessDialogView = super.createBrightnessDialogView();
        if (this.mDegreeSeted) {
            FullScreenUtils.setControllerRotation(createBrightnessDialogView, this.mDegree);
        }
        return createBrightnessDialogView;
    }

    @Override // com.huawei.quickcard.video.view.MediaGestureHelper
    public View createProgressDialogView() {
        View createProgressDialogView = super.createProgressDialogView();
        if (this.mDegreeSeted) {
            FullScreenUtils.setControllerRotation(createProgressDialogView, this.mDegree);
        }
        return createProgressDialogView;
    }

    @Override // com.huawei.quickcard.video.view.MediaGestureHelper
    public View createVolumeDialogView() {
        View createVolumeDialogView = super.createVolumeDialogView();
        if (this.mDegreeSeted) {
            FullScreenUtils.setControllerRotation(createVolumeDialogView, this.mDegree);
        }
        return createVolumeDialogView;
    }

    @Override // com.huawei.quickcard.video.view.MediaGestureHelper, com.huawei.quickcard.video.view.BaseMediaGestureHelper
    public boolean onTouch(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            resetWidthAndHeight();
        }
        return super.onTouch(motionEvent);
    }

    @Override // com.huawei.quickcard.video.view.MediaGestureHelper, com.huawei.quickcard.video.view.BaseMediaGestureHelper
    public void setOtherParams(Object obj) {
        this.mBrightnessDialog = null;
        this.mProgressDialog = null;
        this.mVolumeDialog = null;
        if (obj instanceof Integer) {
            this.mDegreeSeted = true;
            this.mDegree = Integer.parseInt(String.valueOf(obj));
        } else {
            this.mDegreeSeted = false;
            this.mDegree = 0;
        }
    }
}
