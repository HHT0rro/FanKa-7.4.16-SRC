package com.android.internal.app;

import android.animation.ObjectAnimator;
import android.animation.TimeAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CombinedVibration;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.VibratorManager;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.quickcard.base.Attributes;
import java.util.Random;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PlatLogoActivity extends Activity {
    private static final boolean FINISH_AFTER_NEXT_STAGE_LAUNCH = false;
    private static final long LAUNCH_TIME = 5000;
    private static final float MAX_WARP = 10.0f;
    private static final float MIN_WARP = 1.0f;
    private static final String TAG = "PlatLogoActivity";
    static final String TOUCH_STATS = "touch.stats";
    private static final String U_EGG_UNLOCK_SETTING = "egg_mode_u";
    private TimeAnimator mAnim;
    private float mDp;
    private FrameLayout mLayout;
    private ImageView mLogo;
    private Random mRandom;
    private RumblePack mRumble;
    private Starfield mStarfield;
    private ObjectAnimator mWarpAnim;
    private boolean mAnimationsEnabled = true;
    private final View.OnTouchListener mTouchListener = new View.OnTouchListener() { // from class: com.android.internal.app.PlatLogoActivity.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v2, MotionEvent event) {
            switch (event.getActionMasked()) {
                case 0:
                    PlatLogoActivity.this.measureTouchPressure(event);
                    PlatLogoActivity.this.startWarp();
                    return true;
                case 1:
                case 3:
                    PlatLogoActivity.this.stopWarp();
                    return true;
                case 2:
                default:
                    return true;
            }
        }
    };
    private final Runnable mLaunchNextStage = new Runnable() { // from class: com.android.internal.app.PlatLogoActivity$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            PlatLogoActivity.this.lambda$new$0();
        }
    };
    private final TimeAnimator.TimeListener mTimeListener = new TimeAnimator.TimeListener() { // from class: com.android.internal.app.PlatLogoActivity.2
        @Override // android.animation.TimeAnimator.TimeListener
        public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
            PlatLogoActivity.this.mStarfield.update(deltaTime);
            float warpFrac = (PlatLogoActivity.this.mStarfield.getWarp() - 1.0f) / 9.0f;
            if (PlatLogoActivity.this.mAnimationsEnabled) {
                PlatLogoActivity.this.mLogo.setTranslationX(PlatLogoActivity.this.mRandom.nextFloat() * warpFrac * 5.0f * PlatLogoActivity.this.mDp);
                PlatLogoActivity.this.mLogo.setTranslationY(PlatLogoActivity.this.mRandom.nextFloat() * warpFrac * 5.0f * PlatLogoActivity.this.mDp);
            }
            if (warpFrac > 0.0f) {
                PlatLogoActivity.this.mRumble.rumble(warpFrac);
            }
            PlatLogoActivity.this.mLayout.postInvalidate();
        }
    };
    double mPressureMin = ShadowDrawableWrapper.COS_45;
    double mPressureMax = -1.0d;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        stopWarp();
        launchNextStage(false);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class RumblePack implements Handler.Callback {
        private static final int INTERVAL = 50;
        private static final int MSG = 6464;
        private long mLastVibe = 0;
        private boolean mSpinPrimitiveSupported;
        private final Handler mVibeHandler;
        private final VibratorManager mVibeMan;
        private final HandlerThread mVibeThread;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message msg) {
            float warpFrac = msg.arg1 / 100.0f;
            if (!this.mSpinPrimitiveSupported) {
                if (PlatLogoActivity.this.mRandom.nextFloat() < warpFrac) {
                    PlatLogoActivity.this.mLogo.performHapticFeedback(4);
                    return false;
                }
                return false;
            }
            if (msg.getWhen() > this.mLastVibe + 50) {
                this.mLastVibe = msg.getWhen();
                this.mVibeMan.vibrate(CombinedVibration.createParallel(VibrationEffect.startComposition().addPrimitive(3, (float) Math.pow(warpFrac, 3.0d)).compose()));
                return false;
            }
            return false;
        }

        RumblePack() {
            VibratorManager vibratorManager = (VibratorManager) PlatLogoActivity.this.getSystemService(VibratorManager.class);
            this.mVibeMan = vibratorManager;
            this.mSpinPrimitiveSupported = vibratorManager.getDefaultVibrator().areAllPrimitivesSupported(3);
            HandlerThread handlerThread = new HandlerThread("VibratorThread");
            this.mVibeThread = handlerThread;
            handlerThread.start();
            this.mVibeHandler = Handler.createAsync(handlerThread.getLooper(), this);
        }

        public void destroy() {
            this.mVibeThread.quit();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void rumble(float warpFrac) {
            if (this.mVibeThread.isAlive()) {
                Message msg = Message.obtain();
                msg.what = MSG;
                msg.arg1 = (int) (100.0f * warpFrac);
                this.mVibeHandler.removeMessages(MSG);
                this.mVibeHandler.sendMessage(msg);
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.mRumble.destroy();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setDecorFitsSystemWindows(false);
        getWindow().setNavigationBarColor(0);
        getWindow().setStatusBarColor(0);
        getWindow().getDecorView().getWindowInsetsController().hide(WindowInsets.Type.systemBars());
        ActionBar ab2 = getActionBar();
        if (ab2 != null) {
            ab2.hide();
        }
        try {
            this.mAnimationsEnabled = Settings.Global.getFloat(getContentResolver(), "animator_duration_scale") > 0.0f;
        } catch (Settings.SettingNotFoundException e2) {
            this.mAnimationsEnabled = true;
        }
        this.mRumble = new RumblePack();
        this.mLayout = new FrameLayout(this);
        this.mRandom = new Random();
        this.mDp = getResources().getDisplayMetrics().density;
        Starfield starfield = new Starfield(this.mRandom, this.mDp * 2.0f);
        this.mStarfield = starfield;
        starfield.setVelocity((this.mRandom.nextFloat() - 0.5f) * 200.0f, (this.mRandom.nextFloat() - 0.5f) * 200.0f);
        this.mLayout.setBackground(this.mStarfield);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        float f10 = dm.density;
        int minSide = Math.min(dm.widthPixels, dm.heightPixels);
        int widgetSize = (int) (minSide * 0.75d);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(widgetSize, widgetSize);
        lp.gravity = 17;
        ImageView imageView = new ImageView(this);
        this.mLogo = imageView;
        imageView.setImageResource(17303219);
        this.mLogo.setOnTouchListener(this.mTouchListener);
        this.mLogo.requestFocus();
        this.mLayout.addView(this.mLogo, lp);
        Log.v(TAG, "Hello");
        setContentView(this.mLayout);
    }

    private void startAnimating() {
        TimeAnimator timeAnimator = new TimeAnimator();
        this.mAnim = timeAnimator;
        timeAnimator.setTimeListener(this.mTimeListener);
        this.mAnim.start();
    }

    private void stopAnimating() {
        this.mAnim.cancel();
        this.mAnim = null;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 62) {
            if (event.getRepeatCount() == 0) {
                startWarp();
                return true;
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == 62) {
            stopWarp();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWarp() {
        stopWarp();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mStarfield, "warp", 1.0f, MAX_WARP).setDuration(5000L);
        this.mWarpAnim = duration;
        duration.start();
        this.mLogo.postDelayed(this.mLaunchNextStage, 6000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopWarp() {
        ObjectAnimator objectAnimator = this.mWarpAnim;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.mWarpAnim.removeAllListeners();
            this.mWarpAnim = null;
        }
        this.mStarfield.setWarp(1.0f);
        this.mLogo.removeCallbacks(this.mLaunchNextStage);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        startAnimating();
    }

    @Override // android.app.Activity
    public void onPause() {
        stopWarp();
        stopAnimating();
        super.onPause();
    }

    private boolean shouldWriteSettings() {
        return getPackageName().equals("android");
    }

    private void launchNextStage(boolean locked) {
        ContentResolver cr = getContentResolver();
        try {
            if (shouldWriteSettings()) {
                Log.v(TAG, "Saving egg locked=" + locked);
                syncTouchPressure();
                Settings.System.putLong(cr, U_EGG_UNLOCK_SETTING, locked ? 0L : System.currentTimeMillis());
            }
        } catch (RuntimeException e2) {
            Log.e(TAG, "Can't write settings", e2);
        }
        try {
            Intent eggActivity = new Intent("android.intent.action.MAIN").setFlags(268468224).addCategory("com.android.internal.category.PLATLOGO");
            Log.v(TAG, "launching: " + ((Object) eggActivity));
            startActivity(eggActivity);
        } catch (ActivityNotFoundException e10) {
            Log.e("com.android.internal.app.PlatLogoActivity", "No more eggs.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void measureTouchPressure(MotionEvent event) {
        float pressure = event.getPressure();
        switch (event.getActionMasked()) {
            case 0:
                if (this.mPressureMax < ShadowDrawableWrapper.COS_45) {
                    double d10 = pressure;
                    this.mPressureMax = d10;
                    this.mPressureMin = d10;
                    return;
                }
                return;
            case 1:
            default:
                return;
            case 2:
                if (pressure < this.mPressureMin) {
                    this.mPressureMin = pressure;
                }
                if (pressure > this.mPressureMax) {
                    this.mPressureMax = pressure;
                    return;
                }
                return;
        }
    }

    private void syncTouchPressure() {
        try {
            String touchDataJson = Settings.System.getString(getContentResolver(), TOUCH_STATS);
            JSONObject touchData = new JSONObject(touchDataJson != null ? touchDataJson : "{}");
            if (touchData.has(Attributes.Style.MIN)) {
                this.mPressureMin = Math.min(this.mPressureMin, touchData.getDouble(Attributes.Style.MIN));
            }
            if (touchData.has("max")) {
                this.mPressureMax = Math.max(this.mPressureMax, touchData.getDouble("max"));
            }
            if (this.mPressureMax >= ShadowDrawableWrapper.COS_45) {
                touchData.put(Attributes.Style.MIN, this.mPressureMin);
                touchData.put("max", this.mPressureMax);
                if (shouldWriteSettings()) {
                    Settings.System.putString(getContentResolver(), TOUCH_STATS, touchData.toString());
                }
            }
        } catch (Exception e2) {
            Log.e("com.android.internal.app.PlatLogoActivity", "Can't write touch settings", e2);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        float f10 = dm.density;
        int minSide = Math.min(dm.widthPixels, dm.heightPixels);
        int widgetSize = (int) (minSide * 0.75d);
        ViewGroup.LayoutParams logoLayoutParams = this.mLogo.getLayoutParams();
        if (logoLayoutParams instanceof FrameLayout.LayoutParams) {
            logoLayoutParams.width = widgetSize;
            logoLayoutParams.height = widgetSize;
            this.mLogo.setLayoutParams(logoLayoutParams);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        syncTouchPressure();
    }

    @Override // android.app.Activity
    public void onStop() {
        syncTouchPressure();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Starfield extends Drawable {
        private static final int NUM_PLANES = 2;
        private static final int NUM_STARS = 34;
        private float mBuffer;
        private final Random mRng;
        private final float mSize;
        private final Paint mStarPaint;
        private float mVx;
        private float mVy;
        private final float[] mStars = new float[136];
        private long mDt = 0;
        private final Rect mSpace = new Rect();
        private float mWarp = 1.0f;

        public void setWarp(float warp) {
            this.mWarp = warp;
        }

        public float getWarp() {
            return this.mWarp;
        }

        Starfield(Random rng, float size) {
            this.mRng = rng;
            this.mSize = size;
            Paint paint = new Paint();
            this.mStarPaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(-1);
        }

        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(Rect bounds) {
            this.mSpace.set(bounds);
            float f10 = this.mSize * 2.0f * 2.0f * PlatLogoActivity.MAX_WARP;
            this.mBuffer = f10;
            this.mSpace.inset(-((int) f10), -((int) f10));
            float w3 = this.mSpace.width();
            float h10 = this.mSpace.height();
            for (int i10 = 0; i10 < 34; i10++) {
                this.mStars[i10 * 4] = this.mRng.nextFloat() * w3;
                this.mStars[(i10 * 4) + 1] = this.mRng.nextFloat() * h10;
                float[] fArr = this.mStars;
                fArr[(i10 * 4) + 2] = fArr[i10 * 4];
                fArr[(i10 * 4) + 3] = fArr[(i10 * 4) + 1];
            }
        }

        public void setVelocity(float x10, float y10) {
            this.mVx = x10;
            this.mVy = y10;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            float dtSec = ((float) this.mDt) / 1000.0f;
            float f10 = this.mVx * dtSec;
            float f11 = this.mWarp;
            float dx = f10 * f11;
            float dy = this.mVy * dtSec * f11;
            int i10 = 0;
            int i11 = 1;
            boolean inWarp = f11 > 1.0f;
            canvas.drawColor(-16777216);
            long j10 = this.mDt;
            if (j10 > 0 && j10 < 1000) {
                canvas.translate((-this.mBuffer) + (this.mRng.nextFloat() * (this.mWarp - 1.0f)), (-this.mBuffer) + (this.mRng.nextFloat() * (this.mWarp - 1.0f)));
                float w3 = this.mSpace.width();
                float h10 = this.mSpace.height();
                int i12 = 0;
                while (i12 < 34) {
                    int plane = ((int) ((i12 / 34.0f) * 2.0f)) + i11;
                    float[] fArr = this.mStars;
                    fArr[(i12 * 4) + 2] = ((fArr[(i12 * 4) + 2] + (plane * dx)) + w3) % w3;
                    fArr[(i12 * 4) + 3] = ((fArr[(i12 * 4) + 3] + (plane * dy)) + h10) % h10;
                    fArr[(i12 * 4) + i10] = inWarp ? fArr[(i12 * 4) + 2] - (((this.mWarp * dx) * 2.0f) * plane) : -100.0f;
                    fArr[(i12 * 4) + 1] = inWarp ? fArr[(i12 * 4) + 3] - (((this.mWarp * dy) * 2.0f) * plane) : -100.0f;
                    i12++;
                    i10 = 0;
                    i11 = 1;
                }
            }
            int slice = ((this.mStars.length / 2) / 4) * 4;
            for (int p10 = 0; p10 < 2; p10++) {
                this.mStarPaint.setStrokeWidth(this.mSize * (p10 + 1));
                if (inWarp) {
                    canvas.drawLines(this.mStars, p10 * slice, slice, this.mStarPaint);
                }
                canvas.drawPoints(this.mStars, p10 * slice, slice, this.mStarPaint);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        public void update(long dt) {
            this.mDt = dt;
        }
    }
}
