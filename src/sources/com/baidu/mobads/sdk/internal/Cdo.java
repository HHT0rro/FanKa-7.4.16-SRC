package com.baidu.mobads.sdk.internal;

import android.os.CountDownTimer;
import android.widget.TextView;

/* renamed from: com.baidu.mobads.sdk.internal.do, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
class Cdo extends CountDownTimer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dm f10207a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cdo(dm dmVar, long j10, long j11) {
        super(j10, j11);
        this.f10207a = dmVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f10207a.f10197b.a("CountDownTimer finished");
        this.f10207a.c();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j10) {
        TextView textView;
        int i10 = (int) (j10 / 1000);
        if (i10 > 5) {
            i10 = 5;
        }
        textView = this.f10207a.f10199d;
        textView.setText(String.valueOf(i10));
    }
}
