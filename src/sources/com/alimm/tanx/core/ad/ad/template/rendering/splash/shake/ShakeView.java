package com.alimm.tanx.core.ad.ad.template.rendering.splash.shake;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.ut.bean.UtSensor;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.wangmai.appsdkdex.R$drawable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ShakeView extends View implements SensorEventListener, IShakeView, NotConfused {
    public static final long ROTATE_ANIM_INTERVAL_TIME = 333;
    public static final long ROTATE_ANIM_TIME = 1000;
    public static final String TAG = "ShakeView";
    public final float DEFAULT_SHAKE_THRESHOLD;
    public final int GESTURE_INTERACTION_END_CLICK;
    public final int GESTURE_INTERACTION_END_FAIL;
    public final int GESTURE_INTERACTION_END_SUCCESS;
    public final int GESTURE_INTERACTION_START;
    public final int MAX_SHAKE_THRESHOLD;
    public final int MIN_SHAKE_THRESHOLD;
    public int count;

    @Nullable
    public InteractiveCallback mCallBack;

    @NonNull
    @Nullable
    public Rect mCircleImgRect;
    public int mCircleLength;
    public Context mContext;
    public int mImagePadding;
    public long mLastTimeShake;
    public float mNowShakeDegree;
    public int mNowVisibility;

    @NonNull
    public Paint mPaint;
    public int[] mPhoneImgSize;

    @NonNull
    public Rect mRealShakeImgRect;
    public boolean mRemoveWhenDetachFromWindow;
    public ValueAnimator.AnimatorUpdateListener mRotateAnimListener;

    @Nullable
    public ValueAnimator mRotateAnimation;

    @Nullable
    public SensorManager mSenSensorManager;

    @Nullable
    public Bitmap mShakeBitMap;

    @NonNull
    public Rect mShakeImgRect;
    public float mShakeThreshold;
    public int mShakeViewHeight;
    public String mShowText1;
    public String mShowText2;
    public int mShowTextColor1;
    public int mShowTextColor2;
    public float mShowTextHeight1;
    public float mShowTextHeight2;
    public Rect mShowTextRect1;
    public Rect mShowTextRect2;
    public float mShowTextSize1;
    public float mShowTextSize2;
    public int mTextPadding;

    @NonNull
    public Paint mTextPaint;
    public List<UtSensor> sensorList;

    public ShakeView(@NonNull Context context) {
        super(context);
        this.mLastTimeShake = 0L;
        this.DEFAULT_SHAKE_THRESHOLD = 13.0f;
        this.mShakeThreshold = 13.0f;
        this.mRemoveWhenDetachFromWindow = true;
        this.GESTURE_INTERACTION_START = -1;
        this.GESTURE_INTERACTION_END_CLICK = 0;
        this.GESTURE_INTERACTION_END_SUCCESS = 1;
        this.GESTURE_INTERACTION_END_FAIL = 2;
        this.MIN_SHAKE_THRESHOLD = 1;
        this.MAX_SHAKE_THRESHOLD = 50;
        this.sensorList = Collections.synchronizedList(new ArrayList());
        this.count = 0;
        init(context);
    }

    private void drawText(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull String str, @NonNull Rect rect, float f10, int i10, boolean z10) {
        if (z10) {
            paint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            paint.setTypeface(Typeface.DEFAULT);
        }
        paint.setTextSize(f10);
        paint.setColor(i10);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f11 = fontMetrics.bottom;
        canvas.drawText(str, rect.centerX(), rect.centerY() + (((f11 - fontMetrics.top) / 2.0f) - f11), paint);
    }

    private void init(Context context) {
        this.mContext = context;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.mSenSensorManager = sensorManager;
        this.mSenSensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 2);
        this.mShakeBitMap = BitmapFactory.decodeResource(context.getResources(), R$drawable.shake_phone);
        this.mCircleLength = DimenUtil.dp2px(context, 112.0f);
        this.mShakeViewHeight = DimenUtil.dp2px(context, 220.0f);
        this.mPhoneImgSize = new int[]{DimenUtil.dp2px(context, 79.0f), DimenUtil.dp2px(context, 71.0f)};
        this.mShowTextSize1 = DimenUtil.dp2px(context, 20.0f);
        this.mShowTextHeight1 = DimenUtil.dp2px(context, 2.0f);
        this.mPaint = new Paint();
        this.mShakeImgRect = new Rect();
        this.mRealShakeImgRect = new Rect();
        this.mCircleImgRect = new Rect();
        this.mShowTextRect1 = new Rect();
        this.mShowTextRect2 = new Rect();
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        Paint paint = new Paint();
        this.mTextPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setAntiAlias(true);
        if (TextUtils.isEmpty(this.mShowText1)) {
            this.mShowText1 = "摇一摇";
        }
        this.mShowText2 = "互动跳转详情页面或第三方应用";
        this.mShowTextColor1 = Color.parseColor("#ffffff");
        this.mShowTextColor2 = Color.parseColor("#ffffff");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 15.0f, -5.0f, 15.0f, -5.0f, 10.0f, -5.0f);
        this.mRotateAnimation = ofFloat;
        ofFloat.setDuration(1000L);
        this.mRotateAnimation.setStartDelay(333L);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setRepeatMode(1);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShakeView.this.mNowShakeDegree = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ShakeView.this.postInvalidate();
            }
        };
        this.mRotateAnimListener = animatorUpdateListener;
        this.mRotateAnimation.addUpdateListener(animatorUpdateListener);
    }

    private void onShake() {
        InteractiveCallback interactiveCallback;
        long currentTimeMillis = System.currentTimeMillis();
        if (getVisibility() != 0 || (interactiveCallback = this.mCallBack) == null || currentTimeMillis - this.mLastTimeShake <= 1000) {
            return;
        }
        this.mLastTimeShake = currentTimeMillis;
        interactiveCallback.onShake();
    }

    private void startShakeAnim() {
        ValueAnimator valueAnimator = this.mRotateAnimation;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void addSensorList(float f10, float f11, float f12) {
        try {
            if (this.sensorList == null) {
                this.sensorList = Collections.synchronizedList(new ArrayList());
            }
            if (this.sensorList.size() < 10) {
                this.sensorList.add(new UtSensor(f10, f11, f12));
            }
            LogUtils.d("addSensorList", JSON.toJSONString(this.sensorList));
        } catch (Exception e2) {
            LogUtils.e(e2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.IShakeView
    public void load(@NonNull InteractiveCallback interactiveCallback, float f10, boolean z10) {
        this.mCallBack = interactiveCallback;
        if (f10 <= 1.0f) {
            f10 = 13.0f;
        }
        this.mShakeThreshold = f10;
        if (z10) {
            this.mShakeViewHeight = DimenUtil.dp2px(getContext(), 190.0f);
        } else {
            this.mShakeViewHeight = DimenUtil.dp2px(getContext(), 160.0f);
        }
        setMeasuredDimension(getMeasuredWidth(), this.mShakeViewHeight);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        Context context;
        super.onAttachedToWindow();
        startShakeAnim();
        if (this.mRemoveWhenDetachFromWindow || (context = this.mContext) == null) {
            return;
        }
        startShake(context);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InteractiveCallback interactiveCallback = this.mCallBack;
        if (interactiveCallback != null) {
            List<UtSensor> list = this.sensorList;
            if (list != null) {
                interactiveCallback.destroy(JSON.toJSONString(list));
            } else {
                interactiveCallback.destroy("");
            }
        }
        LogUtils.d(TAG, "onDetachedFromWindow");
        if (!this.mRemoveWhenDetachFromWindow) {
            pauseShake();
        } else {
            recycle();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            Bitmap bitmap = this.mShakeBitMap;
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.save();
                canvas.translate(this.mShakeImgRect.centerX(), this.mShakeImgRect.centerY());
                canvas.rotate(this.mNowShakeDegree);
                canvas.drawBitmap(this.mShakeBitMap, (Rect) null, this.mRealShakeImgRect, this.mPaint);
                canvas.restore();
            }
            this.mTextPaint.setTextAlign(Paint.Align.CENTER);
            this.mTextPaint.setShadowLayer(3.0f, 2.0f, 2.0f, 1711276032);
            drawText(canvas, this.mTextPaint, this.mShowText1, this.mShowTextRect1, this.mShowTextSize1, this.mShowTextColor1, true);
        } catch (Exception e2) {
            LogUtils.e(TAG, e2);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int measuredWidth = getMeasuredWidth();
        int dp2px = DimenUtil.dp2px(getContext(), 10.0f);
        Rect rect = this.mCircleImgRect;
        if (rect != null) {
            int i12 = measuredWidth / 2;
            int i13 = this.mCircleLength;
            int i14 = i13 / 2;
            rect.set(i12 - i14, dp2px, i12 + i14, i13 + dp2px);
        }
        int i15 = this.mCircleLength / 2;
        int[] iArr = this.mPhoneImgSize;
        int i16 = dp2px + (i15 - (iArr[1] / 2));
        Rect rect2 = this.mShakeImgRect;
        if (rect2 != null) {
            int i17 = measuredWidth / 2;
            rect2.set(i17 - (iArr[0] / 2), i16, i17 + (iArr[0] / 2), iArr[1] + i16);
        }
        Rect rect3 = this.mRealShakeImgRect;
        if (rect3 != null) {
            int[] iArr2 = this.mPhoneImgSize;
            rect3.set((-iArr2[0]) / 2, (-iArr2[1]) / 2, iArr2[0] / 2, iArr2[1] / 2);
        }
        int dp2px2 = DimenUtil.dp2px(getContext(), 10.0f) + this.mCircleLength + this.mImagePadding;
        this.mShowTextRect1.set(getPaddingLeft(), dp2px2, measuredWidth - getPaddingRight(), ((int) this.mShowTextHeight1) + dp2px2);
        setMeasuredDimension(i10, this.mShakeViewHeight);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if (this.mNowVisibility == 0 && sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            addSensorList(fArr[0], fArr[1], fArr[2]);
            if (((float) Math.sqrt((r0 * r0) + (r1 * r1) + (r4 * r4))) >= this.mShakeThreshold) {
                onShake();
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i10) {
        super.onVisibilityChanged(view, i10);
        this.mNowVisibility = i10;
    }

    public void pauseShake() {
        SensorManager sensorManager = this.mSenSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        ValueAnimator valueAnimator = this.mRotateAnimation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void recycle() {
        SensorManager sensorManager = this.mSenSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.mSenSensorManager = null;
        }
        ValueAnimator valueAnimator = this.mRotateAnimation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.mRotateAnimListener;
            if (animatorUpdateListener != null) {
                this.mRotateAnimation.removeUpdateListener(animatorUpdateListener);
            }
            this.mRotateAnimation = null;
        }
        Bitmap bitmap = this.mShakeBitMap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mShakeBitMap = null;
        }
    }

    public void setImagePadding(int i10) {
        if (getContext() != null) {
            this.mImagePadding = DimenUtil.dp2px(getContext(), i10);
        }
    }

    public void setMessageTextSize(float f10) {
        if (getContext() == null || f10 <= 0.0f) {
            return;
        }
        this.mShowTextSize2 = DimenUtil.dp2px(getContext(), f10);
    }

    public void setRemoveWhenDetachFromWindow(boolean z10) {
        this.mRemoveWhenDetachFromWindow = z10;
    }

    public void setTextPadding(int i10) {
        if (getContext() != null) {
            this.mTextPadding = DimenUtil.dp2px(getContext(), i10);
        }
    }

    public void setTitleTextSize(float f10) {
        this.mShowTextSize1 = f10;
    }

    public void startShake(Context context) {
        if (this.mSenSensorManager == null) {
            this.mSenSensorManager = (SensorManager) context.getSystemService("sensor");
        }
        this.mSenSensorManager.registerListener(this, this.mSenSensorManager.getDefaultSensor(1), 2);
    }

    public ShakeView(@NonNull Context context, String str) {
        super(context);
        this.mLastTimeShake = 0L;
        this.DEFAULT_SHAKE_THRESHOLD = 13.0f;
        this.mShakeThreshold = 13.0f;
        this.mRemoveWhenDetachFromWindow = true;
        this.GESTURE_INTERACTION_START = -1;
        this.GESTURE_INTERACTION_END_CLICK = 0;
        this.GESTURE_INTERACTION_END_SUCCESS = 1;
        this.GESTURE_INTERACTION_END_FAIL = 2;
        this.MIN_SHAKE_THRESHOLD = 1;
        this.MAX_SHAKE_THRESHOLD = 50;
        this.sensorList = Collections.synchronizedList(new ArrayList());
        this.count = 0;
        this.mShowText1 = str;
        init(context);
    }

    public ShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastTimeShake = 0L;
        this.DEFAULT_SHAKE_THRESHOLD = 13.0f;
        this.mShakeThreshold = 13.0f;
        this.mRemoveWhenDetachFromWindow = true;
        this.GESTURE_INTERACTION_START = -1;
        this.GESTURE_INTERACTION_END_CLICK = 0;
        this.GESTURE_INTERACTION_END_SUCCESS = 1;
        this.GESTURE_INTERACTION_END_FAIL = 2;
        this.MIN_SHAKE_THRESHOLD = 1;
        this.MAX_SHAKE_THRESHOLD = 50;
        this.sensorList = Collections.synchronizedList(new ArrayList());
        this.count = 0;
        init(context);
    }

    public ShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mLastTimeShake = 0L;
        this.DEFAULT_SHAKE_THRESHOLD = 13.0f;
        this.mShakeThreshold = 13.0f;
        this.mRemoveWhenDetachFromWindow = true;
        this.GESTURE_INTERACTION_START = -1;
        this.GESTURE_INTERACTION_END_CLICK = 0;
        this.GESTURE_INTERACTION_END_SUCCESS = 1;
        this.GESTURE_INTERACTION_END_FAIL = 2;
        this.MIN_SHAKE_THRESHOLD = 1;
        this.MAX_SHAKE_THRESHOLD = 50;
        this.sensorList = Collections.synchronizedList(new ArrayList());
        this.count = 0;
        init(context);
    }
}
