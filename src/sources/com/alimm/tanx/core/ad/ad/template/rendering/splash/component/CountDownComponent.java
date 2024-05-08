package com.alimm.tanx.core.ad.ad.template.rendering.splash.component;

import android.widget.TextView;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.TanxCountDownTimer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CountDownComponent {
    public final TextView tanxc_do;
    public OnFinishListener tanxc_for;
    public int tanxc_if;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.component.CountDownComponent$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass1 extends TanxCountDownTimer {
        public AnonymousClass1(long j10, long j11) {
            super(j10, j11);
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onFinish() {
            LogUtils.d("CountDownComponent", "onFinish.");
            if (CountDownComponent.this.tanxc_for != null) {
                CountDownComponent.this.tanxc_for.onFinish();
            }
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onTick(long j10) {
            CountDownComponent.this.tanxc_if = Math.round(((float) j10) / 1000.0f);
            LogUtils.d("CountDownComponent", "onTick: millisUntilFinished = " + j10);
            if (CountDownComponent.this.tanxc_if < 1) {
                CountDownComponent.this.tanxc_if = 1;
            }
            CountDownComponent countDownComponent = CountDownComponent.this;
            countDownComponent.tanxc_do(countDownComponent.tanxc_if);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnFinishListener {
        void onFinish();
    }

    public void tanxc_do(int i10) {
        TextView textView = this.tanxc_do;
        if (textView == null || i10 <= 0) {
            return;
        }
        textView.setText(String.valueOf(i10));
    }
}
