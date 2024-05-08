package com.huawei.quickcard.video.utils;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.quickcard.FullScreenExtendedParams;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.video.view.RotateMediaGestureHelper;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class VideoRotateHelper extends VideoFullScreenHelperBase {
    private static final long INIT_SENSOR_DELAY = 50;
    private static final String TAG = "VideoRotateHelper";
    private float firstDegree;
    private float lastDegree;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Integer f34368a;

        /* renamed from: b, reason: collision with root package name */
        private View f34369b;

        public a(Integer num, View view) {
            this.f34368a = num;
            this.f34369b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f34368a != null) {
                VideoRotateHelper.this.setControllerRotation(r0.intValue(), this.f34369b);
            }
        }
    }

    private void doOrientationEvent(Integer num, View view) {
        new Handler().postDelayed(new a(num, view), 50L);
    }

    @Deprecated
    public static VideoRotateHelper getInstance() {
        return new VideoRotateHelper();
    }

    private boolean isRTL() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    private void lockActivityScreenOrientation(@NonNull Activity activity) {
        int screenRotate = FullScreenUtils.getScreenRotate(activity);
        if (screenRotate == 1) {
            activity.setRequestedOrientation(0);
        } else if (screenRotate != 3) {
            activity.setRequestedOrientation(1);
        } else {
            activity.setRequestedOrientation(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setControllerRotation(float f10, View view) {
        if (view == null) {
            return;
        }
        if (this.firstDegree < 0.0f) {
            this.firstDegree = view.getRotation();
        }
        if (Math.abs(f10 - view.getRotation()) > 0.001d) {
            view.setRotation(f10);
            int width = view.getWidth();
            int height = view.getHeight();
            if (f10 == 0.0f) {
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
            } else if (Math.abs(this.firstDegree - f10) % 180.0f == 0.0f) {
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
            } else if (Math.abs(this.lastDegree - f10) % 180.0f != 0.0f) {
                if (isRTL()) {
                    view.setTranslationX((height - width) / 2.0f);
                } else {
                    view.setTranslationX((width - height) / 2.0f);
                }
                view.setTranslationY((height - width) / 2.0f);
            } else {
                CardLogUtils.d("do not need change");
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (Math.abs(this.lastDegree - f10) != 180.0f) {
                layoutParams.height = width;
                layoutParams.width = height;
            } else {
                layoutParams.height = height;
                layoutParams.width = width;
            }
            this.lastDegree = f10;
            view.requestLayout();
        }
    }

    @Override // com.huawei.quickcard.video.utils.VideoFullScreenHelperBase, com.huawei.quickcard.IFullScreenHelper
    public FullScreenExtendedParams getExtendedParams() {
        if (this.mFullScreenExtendedParams == null) {
            FullScreenExtendedParams fullScreenExtendedParams = new FullScreenExtendedParams();
            this.mFullScreenExtendedParams = fullScreenExtendedParams;
            fullScreenExtendedParams.setParam("mediaGestureHelper", RotateMediaGestureHelper.class);
        }
        return this.mFullScreenExtendedParams;
    }

    @Override // com.huawei.quickcard.video.utils.VideoFullScreenHelperBase
    public void handleActivityOrientation(@NonNull Activity activity, int i10) {
        lockActivityScreenOrientation(activity);
    }

    @Override // com.huawei.quickcard.video.utils.VideoFullScreenHelperBase
    public void handleHostViewOrientation(@NonNull Activity activity, int i10, View view) {
        int screenDegree = FullScreenUtils.getScreenDegree(activity);
        boolean isScreenOrientationPortrait = FullScreenUtils.isScreenOrientationPortrait(activity);
        if (1 == i10) {
            if (isScreenOrientationPortrait) {
                return;
            }
            doOrientationEvent(Integer.valueOf(screenDegree), view);
        } else if (isScreenOrientationPortrait) {
            doOrientationEvent(90, view);
        }
    }

    @Override // com.huawei.quickcard.video.utils.VideoFullScreenHelperBase
    public void resetHostViewOrientation(View view) {
        float f10 = this.firstDegree;
        if (f10 >= 0.0f) {
            setControllerRotation(f10, view);
            this.firstDegree = -1.0f;
        }
    }

    @Override // com.huawei.quickcard.video.utils.VideoFullScreenHelperBase
    public void resetParams() {
        super.resetParams();
        this.firstDegree = -1.0f;
        this.lastDegree = 0.0f;
    }
}
