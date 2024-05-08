package com.android.internal.display;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.MathUtils;
import android.util.Slog;
import com.alipay.sdk.util.i;
import java.io.PrintWriter;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class BrightnessSynchronizer {
    private static final boolean DEBUG = false;
    public static final float EPSILON = 0.001f;
    private static final int MSG_RUN_UPDATE = 1;
    private static final String TAG = "BrightnessSynchronizer";
    private static final long WAIT_FOR_RESPONSE_MILLIS = 200;
    private final BrightnessSyncObserver mBrightnessSyncObserver;
    private final Clock mClock;
    private final Context mContext;
    private BrightnessUpdate mCurrentUpdate;
    private DisplayManager mDisplayManager;
    private final Handler mHandler;
    private float mLatestFloatBrightness;
    private int mLatestIntBrightness;
    private BrightnessUpdate mPendingUpdate;
    private static final Uri BRIGHTNESS_URI = Settings.System.getUriFor("screen_brightness");
    private static int sBrightnessUpdateCount = 1;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface Clock {
        long uptimeMillis();
    }

    public BrightnessSynchronizer(Context context) {
        this(context, Looper.getMainLooper(), new Clock() { // from class: com.android.internal.display.BrightnessSynchronizer$$ExternalSyntheticLambda0
            @Override // com.android.internal.display.BrightnessSynchronizer.Clock
            public final long uptimeMillis() {
                return SystemClock.uptimeMillis();
            }
        });
    }

    public BrightnessSynchronizer(Context context, Looper looper, Clock clock) {
        this.mContext = context;
        this.mClock = clock;
        this.mBrightnessSyncObserver = new BrightnessSyncObserver();
        this.mHandler = new BrightnessSynchronizerHandler(looper);
    }

    public void startSynchronizing() {
        if (this.mDisplayManager == null) {
            this.mDisplayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        }
        if (this.mBrightnessSyncObserver.isObserving()) {
            Slog.wtf(TAG, "Brightness sync observer requesting synchronization a second time.");
            return;
        }
        this.mLatestFloatBrightness = getScreenBrightnessFloat();
        this.mLatestIntBrightness = getScreenBrightnessInt();
        Slog.i(TAG, "Initial brightness readings: " + this.mLatestIntBrightness + "(int), " + this.mLatestFloatBrightness + "(float)");
        if (!Float.isNaN(this.mLatestFloatBrightness)) {
            this.mPendingUpdate = new BrightnessUpdate(2, this.mLatestFloatBrightness);
        } else {
            int i10 = this.mLatestIntBrightness;
            if (i10 != -1) {
                this.mPendingUpdate = new BrightnessUpdate(1, i10);
            } else {
                float defaultBrightness = this.mContext.getResources().getFloat(17105113);
                this.mPendingUpdate = new BrightnessUpdate(2, defaultBrightness);
                Slog.i(TAG, "Setting initial brightness to default value of: " + defaultBrightness);
            }
        }
        this.mBrightnessSyncObserver.startObserving(this.mHandler);
        this.mHandler.sendEmptyMessageAtTime(1, this.mClock.uptimeMillis());
    }

    public void dump(PrintWriter pw) {
        pw.println(TAG);
        pw.println("  mLatestIntBrightness=" + this.mLatestIntBrightness);
        pw.println("  mLatestFloatBrightness=" + this.mLatestFloatBrightness);
        pw.println("  mCurrentUpdate=" + ((Object) this.mCurrentUpdate));
        pw.println("  mPendingUpdate=" + ((Object) this.mPendingUpdate));
    }

    public static float brightnessIntToFloat(int brightnessInt) {
        if (brightnessInt == 0) {
            return -1.0f;
        }
        if (brightnessInt == -1) {
            return Float.NaN;
        }
        return MathUtils.constrainedMap(0.0f, 1.0f, 1.0f, 255.0f, brightnessInt);
    }

    public static int brightnessFloatToInt(float brightnessFloat) {
        return Math.round(brightnessFloatToIntRange(brightnessFloat));
    }

    public static float brightnessFloatToIntRange(float brightnessFloat) {
        if (floatEquals(brightnessFloat, -1.0f)) {
            return 0.0f;
        }
        if (Float.isNaN(brightnessFloat)) {
            return -1.0f;
        }
        return MathUtils.constrainedMap(1.0f, 255.0f, 0.0f, 1.0f, brightnessFloat);
    }

    private void handleBrightnessChangeFloat(float brightness) {
        this.mLatestFloatBrightness = brightness;
        handleBrightnessChange(2, brightness);
    }

    private void handleBrightnessChangeInt(int brightness) {
        this.mLatestIntBrightness = brightness;
        handleBrightnessChange(1, brightness);
    }

    private void handleBrightnessChange(int type, float brightness) {
        BrightnessUpdate brightnessUpdate = this.mCurrentUpdate;
        boolean swallowUpdate = brightnessUpdate != null && brightnessUpdate.swallowUpdate(type, brightness);
        BrightnessUpdate prevUpdate = null;
        if (!swallowUpdate) {
            prevUpdate = this.mPendingUpdate;
            this.mPendingUpdate = new BrightnessUpdate(type, brightness);
        }
        runUpdate();
        if (!swallowUpdate && this.mPendingUpdate != null) {
            Slog.i(TAG, "New PendingUpdate: " + ((Object) this.mPendingUpdate) + ", prev=" + ((Object) prevUpdate));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runUpdate() {
        BrightnessUpdate brightnessUpdate;
        do {
            BrightnessUpdate brightnessUpdate2 = this.mCurrentUpdate;
            if (brightnessUpdate2 != null) {
                brightnessUpdate2.update();
                if (!this.mCurrentUpdate.isRunning()) {
                    if (this.mCurrentUpdate.isCompleted()) {
                        if (this.mCurrentUpdate.madeUpdates()) {
                            Slog.i(TAG, "Completed Update: " + ((Object) this.mCurrentUpdate));
                        }
                        this.mCurrentUpdate = null;
                    }
                } else {
                    return;
                }
            }
            if (this.mCurrentUpdate == null && (brightnessUpdate = this.mPendingUpdate) != null) {
                this.mCurrentUpdate = brightnessUpdate;
                this.mPendingUpdate = null;
            }
        } while (this.mCurrentUpdate != null);
    }

    private float getScreenBrightnessFloat() {
        return this.mDisplayManager.getBrightness(0);
    }

    private int getScreenBrightnessInt() {
        return Settings.System.getIntForUser(this.mContext.getContentResolver(), "screen_brightness", -1, -2);
    }

    public static boolean floatEquals(float a10, float b4) {
        if (a10 == b4) {
            return true;
        }
        return (Float.isNaN(a10) && Float.isNaN(b4)) || Math.abs(a10 - b4) < 0.001f;
    }

    public static boolean floatCompare(float a10, float b4, boolean less) {
        if (less) {
            if (a10 < b4) {
                return true;
            }
        } else if (a10 > b4) {
            return true;
        }
        return floatEquals(a10, b4);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class BrightnessUpdate {
        private static final int STATE_COMPLETED = 3;
        private static final int STATE_NOT_STARTED = 1;
        private static final int STATE_RUNNING = 2;
        static final int TYPE_FLOAT = 2;
        static final int TYPE_INT = 1;
        private final float mBrightness;
        private int mConfirmedTypes;
        private int mId;
        private final int mSourceType;
        private int mState;
        private long mTimeUpdated;
        private int mUpdatedTypes;

        BrightnessUpdate(int sourceType, float brightness) {
            int i10 = BrightnessSynchronizer.sBrightnessUpdateCount;
            BrightnessSynchronizer.sBrightnessUpdateCount = i10 + 1;
            this.mId = i10;
            this.mSourceType = sourceType;
            this.mBrightness = brightness;
            this.mTimeUpdated = 0L;
            this.mUpdatedTypes = 0;
            this.mConfirmedTypes = 0;
            this.mState = 1;
        }

        public String toString() {
            return "{[" + this.mId + "] " + toStringLabel(this.mSourceType, this.mBrightness) + ", mUpdatedTypes=" + this.mUpdatedTypes + ", mConfirmedTypes=" + this.mConfirmedTypes + ", mTimeUpdated=" + this.mTimeUpdated + i.f4738d;
        }

        void update() {
            if (this.mState == 1) {
                this.mState = 2;
                int brightnessInt = getBrightnessAsInt();
                if (BrightnessSynchronizer.this.mLatestIntBrightness != brightnessInt) {
                    BrightnessSynchronizer.this.mLatestIntBrightness = brightnessInt;
                    this.mUpdatedTypes |= 1;
                }
                float brightnessFloat = getBrightnessAsFloat();
                if (!BrightnessSynchronizer.floatEquals(BrightnessSynchronizer.this.mLatestFloatBrightness, brightnessFloat)) {
                    BrightnessSynchronizer.this.mDisplayManager.setBrightness(0, brightnessFloat);
                    BrightnessSynchronizer.this.mLatestFloatBrightness = brightnessFloat;
                    this.mUpdatedTypes |= 2;
                }
                if (this.mUpdatedTypes != 0) {
                    Slog.i(BrightnessSynchronizer.TAG, "[" + this.mId + "] New Update " + toStringLabel(this.mSourceType, this.mBrightness) + " set brightness values: " + toStringLabel(this.mUpdatedTypes & 2, brightnessFloat) + " " + toStringLabel(this.mUpdatedTypes & 1, brightnessInt));
                    BrightnessSynchronizer.this.mHandler.sendEmptyMessageAtTime(1, BrightnessSynchronizer.this.mClock.uptimeMillis() + 200);
                }
                this.mTimeUpdated = BrightnessSynchronizer.this.mClock.uptimeMillis();
            }
            if (this.mState == 2) {
                if (this.mConfirmedTypes == this.mUpdatedTypes || this.mTimeUpdated + 200 < BrightnessSynchronizer.this.mClock.uptimeMillis()) {
                    this.mState = 3;
                }
            }
        }

        boolean swallowUpdate(int type, float brightness) {
            if ((this.mUpdatedTypes & type) != type || (this.mConfirmedTypes & type) != 0) {
                return false;
            }
            boolean floatUpdateConfirmed = type == 2 && BrightnessSynchronizer.floatEquals(getBrightnessAsFloat(), brightness);
            boolean intUpdateConfirmed = type == 1 && getBrightnessAsInt() == ((int) brightness);
            if (!floatUpdateConfirmed && !intUpdateConfirmed) {
                return false;
            }
            this.mConfirmedTypes |= type;
            Slog.i(BrightnessSynchronizer.TAG, "Swallowing update of " + toStringLabel(type, brightness) + " by update: " + ((Object) this));
            return true;
        }

        boolean isRunning() {
            return this.mState == 2;
        }

        boolean isCompleted() {
            return this.mState == 3;
        }

        boolean madeUpdates() {
            return this.mUpdatedTypes != 0;
        }

        private int getBrightnessAsInt() {
            if (this.mSourceType == 1) {
                return (int) this.mBrightness;
            }
            return BrightnessSynchronizer.brightnessFloatToInt(this.mBrightness);
        }

        private float getBrightnessAsFloat() {
            if (this.mSourceType == 2) {
                return this.mBrightness;
            }
            return BrightnessSynchronizer.brightnessIntToFloat((int) this.mBrightness);
        }

        private String toStringLabel(int type, float brightness) {
            return type == 1 ? ((int) brightness) + "(i)" : type == 2 ? brightness + "(f)" : "";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    class BrightnessSynchronizerHandler extends Handler {
        BrightnessSynchronizerHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    BrightnessSynchronizer.this.runUpdate();
                    return;
                default:
                    super.handleMessage(msg);
                    return;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class BrightnessSyncObserver {
        private boolean mIsObserving;
        private final DisplayManager.DisplayListener mListener;

        private BrightnessSyncObserver() {
            this.mListener = new DisplayManager.DisplayListener() { // from class: com.android.internal.display.BrightnessSynchronizer.BrightnessSyncObserver.1
                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayAdded(int displayId) {
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayRemoved(int displayId) {
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayChanged(int displayId) {
                }
            };
        }

        private ContentObserver createBrightnessContentObserver(Handler handler) {
            return new ContentObserver(handler) { // from class: com.android.internal.display.BrightnessSynchronizer.BrightnessSyncObserver.2
                @Override // android.database.ContentObserver
                public void onChange(boolean selfChange, Uri uri) {
                }
            };
        }

        boolean isObserving() {
            return this.mIsObserving;
        }

        void startObserving(Handler handler) {
            ContentResolver cr = BrightnessSynchronizer.this.mContext.getContentResolver();
            cr.registerContentObserver(BrightnessSynchronizer.BRIGHTNESS_URI, false, createBrightnessContentObserver(handler), -1);
            BrightnessSynchronizer.this.mDisplayManager.registerDisplayListener(this.mListener, handler, 8L);
            this.mIsObserving = true;
        }
    }
}
