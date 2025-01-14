package com.alimm.tanx.core.utils;

import android.widget.TextView;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CountDownComponent {
    public final TextView tanxc_do;
    public final int tanxc_for;
    public final TanxCountDownTimer tanxc_if;
    public int tanxc_int;
    public boolean tanxc_new = false;
    public OnFinishListener tanxc_try;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnFinishListener {
        void onFinish();
    }

    public CountDownComponent(@NonNull TextView textView, int i10, OnFinishListener onFinishListener) {
        this.tanxc_do = textView;
        this.tanxc_for = i10;
        this.tanxc_try = onFinishListener;
        this.tanxc_if = new TanxCountDownTimer((i10 * 1000) + 300, 300L) { // from class: com.alimm.tanx.core.utils.CountDownComponent.1
            @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
            public void onFinish() {
                LogUtils.d("CountDownComponent", "onFinish.");
                if (CountDownComponent.this.tanxc_try != null) {
                    CountDownComponent.this.tanxc_try.onFinish();
                }
            }

            @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
            public void onTick(long j10) {
                CountDownComponent.this.tanxc_int = Math.round(((float) j10) / 1000.0f);
                LogUtils.d("CountDownComponent", "onTick: millisUntilFinished = " + j10);
                if (CountDownComponent.this.tanxc_int < 1) {
                    CountDownComponent.this.tanxc_int = 1;
                }
                CountDownComponent countDownComponent = CountDownComponent.this;
                countDownComponent.tanxc_do(countDownComponent.tanxc_int);
            }
        };
    }

    public void tanxc_for() {
        TanxCountDownTimer tanxCountDownTimer = this.tanxc_if;
        if (tanxCountDownTimer != null) {
            tanxCountDownTimer.pause();
        }
    }

    public void tanxc_int() {
        TanxCountDownTimer tanxCountDownTimer = this.tanxc_if;
        if (tanxCountDownTimer != null) {
            tanxCountDownTimer.resume();
        }
    }

    public void tanxc_if() {
        TanxCountDownTimer tanxCountDownTimer;
        if (this.tanxc_new && (tanxCountDownTimer = this.tanxc_if) != null) {
            tanxCountDownTimer.cancel();
            this.tanxc_new = false;
        }
        this.tanxc_try = null;
    }

    public void tanxc_do() {
        LogUtils.d("CountDownComponent", "startCountDown: mCurrentCount = " + this.tanxc_int + ", mIsTimerStarted = " + this.tanxc_new + ", mCountDownTimer = " + ((Object) this.tanxc_if));
        if (this.tanxc_new || this.tanxc_if == null) {
            return;
        }
        this.tanxc_do.setText(String.valueOf(this.tanxc_for));
        this.tanxc_if.start();
        this.tanxc_new = true;
    }

    public void tanxc_do(int i10) {
        TextView textView = this.tanxc_do;
        if (textView == null || i10 <= 0) {
            return;
        }
        textView.setText(String.valueOf(i10));
    }
}
