package com.tencent.cloud.huiyansdkface.facelight.common;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class CloudFaceCountDownTimer {

    /* renamed from: a, reason: collision with root package name */
    private final long f40679a;

    /* renamed from: b, reason: collision with root package name */
    private final long f40680b;

    /* renamed from: c, reason: collision with root package name */
    private long f40681c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f40682d = false;

    /* renamed from: e, reason: collision with root package name */
    private Handler f40683e = new Handler() { // from class: com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (CloudFaceCountDownTimer.this) {
                if (CloudFaceCountDownTimer.this.f40682d) {
                    return;
                }
                long elapsedRealtime = CloudFaceCountDownTimer.this.f40681c - SystemClock.elapsedRealtime();
                if (elapsedRealtime <= 0) {
                    CloudFaceCountDownTimer.this.onFinish();
                } else if (elapsedRealtime < CloudFaceCountDownTimer.this.f40680b) {
                    sendMessageDelayed(obtainMessage(1), elapsedRealtime);
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    CloudFaceCountDownTimer.this.onTick(elapsedRealtime);
                    long elapsedRealtime3 = (elapsedRealtime2 + CloudFaceCountDownTimer.this.f40680b) - SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        elapsedRealtime3 += CloudFaceCountDownTimer.this.f40680b;
                    }
                    sendMessageDelayed(obtainMessage(1), elapsedRealtime3);
                }
            }
        }
    };

    public CloudFaceCountDownTimer(long j10, long j11) {
        this.f40679a = j10;
        this.f40680b = j11;
    }

    public final synchronized void cancel() {
        this.f40682d = true;
        this.f40683e.removeMessages(1);
    }

    public abstract void onFinish();

    public abstract void onTick(long j10);

    public final synchronized CloudFaceCountDownTimer start() {
        this.f40682d = false;
        if (this.f40679a <= 0) {
            onFinish();
            return this;
        }
        this.f40681c = SystemClock.elapsedRealtime() + this.f40679a;
        Handler handler = this.f40683e;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
