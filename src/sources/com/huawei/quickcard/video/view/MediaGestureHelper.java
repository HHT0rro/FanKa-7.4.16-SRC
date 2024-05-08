package com.huawei.quickcard.video.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.internal.os.PowerProfile;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.video.R;
import com.huawei.quickcard.video.view.BaseMediaGestureHelper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MediaGestureHelper extends BaseMediaGestureHelper {
    private static final float CHANGE_FACTOR = 0.8f;
    private static final int START_Y = 15;
    private static final String TAG = "MediaGestureHelper";
    private static final int THRESHOLD = 80;
    private AudioManager mAudioManager;
    public Dialog mBrightnessDialog;
    private boolean mChangeBrightness;
    private boolean mChangePosition;
    private boolean mChangeVolume;
    private final Context mContext;
    private ProgressBar mDialogBrightnessProgressBar;
    private TextView mDialogBrightnessTextView;
    private ImageView mDialogIcon;
    private ProgressBar mDialogProgressBar;
    private TextView mDialogSeekTime;
    private TextView mDialogTotalTime;
    private ImageView mDialogVolumeImageView;
    private ProgressBar mDialogVolumeProgressBar;
    private TextView mDialogVolumeTextView;
    private float mDownX;
    private float mDownY;
    private float mGestureDownBrightness;
    private int mGestureDownPosition;
    private int mGestureDownVolume;
    public float mMeasuredHeight;
    public float mMeasuredWidth;
    private BaseMediaGestureHelper.MediaGestureChangeListener mMediaGestureChangeListener;
    public Dialog mProgressDialog;
    private int mSeekTimePosition;
    public Dialog mVolumeDialog;
    public final BaseMediaGestureHelper.MediaGestureHelperHoster mWrapper;

    public MediaGestureHelper(Context context, BaseMediaGestureHelper.MediaGestureHelperHoster mediaGestureHelperHoster) {
        super(context, mediaGestureHelperHoster);
        this.mContext = context;
        this.mWrapper = mediaGestureHelperHoster;
        this.mMeasuredWidth = mediaGestureHelperHoster.getHosterMeasuredWidth();
        this.mMeasuredHeight = mediaGestureHelperHoster.getHosterMeasuredHeight();
        Object systemService = context.getSystemService(PowerProfile.POWER_AUDIO);
        if (systemService instanceof AudioManager) {
            this.mAudioManager = (AudioManager) systemService;
        }
    }

    private void changePosition(float f10) {
        int duration = this.mWrapper.getDuration();
        int i10 = (int) (this.mGestureDownPosition + ((300000.0f * f10) / this.mMeasuredWidth));
        this.mSeekTimePosition = i10;
        if (i10 > duration) {
            this.mSeekTimePosition = duration;
        } else if (i10 < 0) {
            this.mSeekTimePosition = 0;
        } else {
            CardLogUtils.i("do not change the value");
        }
        showProgressDialog(f10, com.huawei.quickcard.video.b.a(this.mSeekTimePosition), this.mSeekTimePosition, com.huawei.quickcard.video.b.a(duration), duration);
    }

    private void changeRightness(float f10) {
        Context context = this.mContext;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            float f11 = -f10;
            int i10 = (int) (((f11 * 255.0f) * 0.8f) / this.mMeasuredHeight);
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            float f12 = this.mGestureDownBrightness;
            float f13 = i10 + f12;
            float f14 = (f13 * 1.0f) / 255.0f;
            if (f14 >= 1.0f) {
                attributes.screenBrightness = 1.0f;
            } else if (f14 <= 0.0f) {
                attributes.screenBrightness = 0.01f;
            } else {
                attributes.screenBrightness = f13 / 255.0f;
            }
            BaseMediaGestureHelper.MediaGestureChangeListener mediaGestureChangeListener = this.mMediaGestureChangeListener;
            if (mediaGestureChangeListener != null) {
                mediaGestureChangeListener.onBrightnessChange(attributes.screenBrightness, f12);
            }
            activity.getWindow().setAttributes(attributes);
            showBrightnessDialog((int) (((this.mGestureDownBrightness * 100.0f) / 255.0f) + (((f11 * 0.8f) * 100.0f) / this.mMeasuredHeight)));
        }
    }

    private void changeVolume(float f10) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager == null) {
            return;
        }
        float streamMaxVolume = audioManager.getStreamMaxVolume(3);
        this.mAudioManager.setStreamVolume(3, ((int) (((streamMaxVolume * f10) * 0.8f) / this.mMeasuredHeight)) + this.mGestureDownVolume, 0);
        showVolumeDialog((int) (((this.mGestureDownVolume * 100.0f) / streamMaxVolume) + (((f10 * 0.8f) * 100.0f) / this.mMeasuredHeight)));
    }

    private Dialog createDialogWithView(View view) {
        Dialog dialog = new Dialog(this.mContext, R.style.quick_card_Media_Dialog_Progress);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.addFlags(56);
        window.setLayout(-2, -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        window.setAttributes(attributes);
        return dialog;
    }

    private void detectGesture(float f10, float f11) {
        if (f10 > 80.0f || f11 > 80.0f) {
            if (f10 >= 80.0f) {
                if (this.mWrapper.canChangePosition()) {
                    this.mChangePosition = true;
                    this.mGestureDownPosition = this.mWrapper.getCurrentPosition();
                    return;
                }
                return;
            }
            if (this.mDownX < this.mMeasuredWidth * 0.5f) {
                this.mChangeBrightness = true;
                getGestureBrightness();
                return;
            }
            this.mChangeVolume = true;
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null) {
                this.mGestureDownVolume = audioManager.getStreamVolume(3);
            }
        }
    }

    private void getGestureBrightness() {
        Context context = this.mContext;
        if (context instanceof Activity) {
            float f10 = ((Activity) context).getWindow().getAttributes().screenBrightness;
            if (f10 < 0.0f) {
                try {
                    this.mGestureDownBrightness = Settings.System.getInt(this.mContext.getContentResolver(), "screen_brightness");
                    return;
                } catch (Settings.SettingNotFoundException unused) {
                    CardLogUtils.i(TAG, "get system setting fail");
                    return;
                }
            }
            this.mGestureDownBrightness = f10 * 255.0f;
        }
    }

    private void handleMove(float f10, float f11) {
        float f12 = f10 - this.mDownX;
        float f13 = f11 - this.mDownY;
        float abs = Math.abs(f12);
        float abs2 = Math.abs(f13);
        boolean z10 = this.mChangePosition;
        if ((z10 || this.mChangeVolume || this.mChangeBrightness) ? false : true) {
            detectGesture(abs, abs2);
            return;
        }
        if (z10 && this.mWrapper.canSeek()) {
            changePosition(f12);
        }
        if (this.mChangeVolume) {
            f13 = -f13;
            changeVolume(f13);
        }
        if (this.mChangeBrightness) {
            changeRightness(f13);
        }
    }

    private void hideBrightnessDlg() {
        Dialog dialog = this.mBrightnessDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private void hideProgressDlg() {
        Dialog dialog = this.mProgressDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private void hideVolumeDlg() {
        Dialog dialog = this.mVolumeDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private void initBrightnessView(View view) {
        this.mDialogBrightnessTextView = (TextView) view.findViewById(R.id.tv_brightness);
        this.mDialogBrightnessProgressBar = (ProgressBar) view.findViewById(R.id.brightness_progressbar);
    }

    private void initProgressView(View view) {
        this.mDialogProgressBar = (ProgressBar) view.findViewById(R.id.duration_progressbar);
        this.mDialogSeekTime = (TextView) view.findViewById(R.id.tv_current);
        this.mDialogTotalTime = (TextView) view.findViewById(R.id.tv_duration);
        this.mDialogIcon = (ImageView) view.findViewById(R.id.duration_image_tip);
    }

    private void initVolumeView(View view) {
        this.mDialogVolumeImageView = (ImageView) view.findViewById(R.id.volume_image_tip);
        this.mDialogVolumeTextView = (TextView) view.findViewById(R.id.tv_volume);
        this.mDialogVolumeProgressBar = (ProgressBar) view.findViewById(R.id.volume_progressbar);
    }

    private void showBrightnessDialog(int i10) {
        if (this.mBrightnessDialog == null) {
            this.mBrightnessDialog = createDialogWithView(createBrightnessDialogView());
        }
        if (!this.mBrightnessDialog.isShowing()) {
            this.mBrightnessDialog.show();
        }
        if (i10 > 100) {
            i10 = 100;
        } else if (i10 < 0) {
            i10 = 0;
        } else {
            CardLogUtils.i("do not need to change the value");
        }
        TextView textView = this.mDialogBrightnessTextView;
        if (textView != null) {
            textView.setText(i10 + "%");
        }
        ProgressBar progressBar = this.mDialogBrightnessProgressBar;
        if (progressBar != null) {
            progressBar.setProgress(i10);
        }
    }

    private void showProgressDialog(float f10, String str, int i10, String str2, int i11) {
        if (this.mProgressDialog == null) {
            this.mProgressDialog = createDialogWithView(createProgressDialogView());
        }
        if (!this.mProgressDialog.isShowing()) {
            this.mProgressDialog.show();
        }
        TextView textView = this.mDialogSeekTime;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.mDialogTotalTime;
        if (textView2 != null) {
            textView2.setText(" / " + str2);
        }
        ProgressBar progressBar = this.mDialogProgressBar;
        int i12 = i11 <= 0 ? 0 : (i10 * 100) / i11;
        if (progressBar != null) {
            progressBar.setProgress(i12);
        }
        ImageView imageView = this.mDialogIcon;
        if (imageView != null) {
            if (f10 > 0.0f) {
                imageView.setImageResource(R.drawable.quick_card_video_media_dialog_forward);
            } else {
                imageView.setImageResource(R.drawable.quick_card_video_media_dialog_backward);
            }
        }
    }

    private void showVolumeDialog(int i10) {
        if (this.mVolumeDialog == null) {
            this.mVolumeDialog = createDialogWithView(createVolumeDialogView());
        }
        if (!this.mVolumeDialog.isShowing()) {
            this.mVolumeDialog.show();
        }
        ImageView imageView = this.mDialogVolumeImageView;
        if (imageView != null) {
            if (i10 <= 0) {
                imageView.setImageResource(R.drawable.quick_card_video_player_volume_off);
            } else {
                imageView.setImageResource(R.drawable.quick_card_video_player_volume_on);
            }
        }
        if (i10 > 100) {
            i10 = 100;
        } else if (i10 < 0) {
            i10 = 0;
        } else {
            CardLogUtils.i("do not change the value");
        }
        TextView textView = this.mDialogVolumeTextView;
        if (textView != null) {
            textView.setText(i10 + "%");
        }
        ProgressBar progressBar = this.mDialogVolumeProgressBar;
        if (progressBar != null) {
            progressBar.setProgress(i10);
        }
    }

    public View createBrightnessDialogView() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.quick_card_media_dialog_brightness, (ViewGroup) null);
        initBrightnessView(inflate);
        return inflate;
    }

    public View createProgressDialogView() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.quick_card_media_dialog_progress, (ViewGroup) null);
        initProgressView(inflate);
        return inflate;
    }

    public View createVolumeDialogView() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.quick_card_media_dialog_volume, (ViewGroup) null);
        initVolumeView(inflate);
        return inflate;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
    
        if (r5 != 3) goto L20;
     */
    @Override // com.huawei.quickcard.video.view.BaseMediaGestureHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.MotionEvent r5) {
        /*
            r4 = this;
            float r0 = r5.getX()
            float r1 = r5.getY()
            float r2 = r5.getRawY()
            int r5 = r5.getAction()
            r3 = 1
            if (r5 == 0) goto L3d
            if (r5 == r3) goto L20
            r2 = 2
            if (r5 == r2) goto L1c
            r0 = 3
            if (r5 == r0) goto L20
            goto L54
        L1c:
            r4.handleMove(r0, r1)
            goto L54
        L20:
            r4.hideProgressDlg()
            r4.hideVolumeDlg()
            r4.hideBrightnessDlg()
            boolean r5 = r4.mChangePosition
            if (r5 == 0) goto L54
            com.huawei.quickcard.video.view.BaseMediaGestureHelper$MediaGestureHelperHoster r5 = r4.mWrapper
            boolean r5 = r5.canSeek()
            if (r5 == 0) goto L54
            com.huawei.quickcard.video.view.BaseMediaGestureHelper$MediaGestureHelperHoster r5 = r4.mWrapper
            int r0 = r4.mSeekTimePosition
            r5.setSeekValue(r0)
            goto L54
        L3d:
            r4.mDownX = r0
            r4.mDownY = r1
            r5 = 1097859072(0x41700000, float:15.0)
            r0 = 0
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 >= 0) goto L49
            return r0
        L49:
            r4.mChangeVolume = r0
            r4.mChangePosition = r0
            r4.mChangeBrightness = r0
            com.huawei.quickcard.video.view.BaseMediaGestureHelper$MediaGestureHelperHoster r5 = r4.mWrapper
            r5.requestHosterDisallowInterceptTouchEvent(r3)
        L54:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.quickcard.video.view.MediaGestureHelper.onTouch(android.view.MotionEvent):boolean");
    }

    @Override // com.huawei.quickcard.video.view.BaseMediaGestureHelper
    public void setGestureChangeListener(BaseMediaGestureHelper.MediaGestureChangeListener mediaGestureChangeListener) {
        this.mMediaGestureChangeListener = mediaGestureChangeListener;
    }

    @Override // com.huawei.quickcard.video.view.BaseMediaGestureHelper
    public void setOtherParams(Object obj) {
    }
}
