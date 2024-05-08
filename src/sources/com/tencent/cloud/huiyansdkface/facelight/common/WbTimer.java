package com.tencent.cloud.huiyansdkface.facelight.common;

import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WbTimer {

    /* renamed from: a, reason: collision with root package name */
    private Timer f40702a = new Timer();

    /* renamed from: b, reason: collision with root package name */
    private boolean f40703b;

    public void cancel() {
        WLogger.d("WbTimer", CardEventType.CLICK_ACTION_CANCEL);
        this.f40703b = true;
        Timer timer = this.f40702a;
        if (timer != null) {
            timer.cancel();
            this.f40702a = null;
        }
    }

    public boolean isCancel() {
        return this.f40703b;
    }

    public void reset() {
        WLogger.d("WbTimer", "reset");
        this.f40703b = false;
        if (this.f40702a == null) {
            this.f40702a = new Timer();
        }
    }

    public void scheduleAtFixedRate(TimerTask timerTask, long j10, long j11) {
        if (this.f40703b) {
            WLogger.d("WbTimer", "timer cancelled,no need go on.");
        } else {
            this.f40702a.scheduleAtFixedRate(timerTask, j10, j11);
        }
    }
}
