package com.wangmai.common.utils;

import java.util.Timer;
import java.util.TimerTask;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TimerUtil {
    public static volatile TimerUtil timerUtil;
    public Timer timer = new Timer();

    public static TimerUtil getInstance() {
        if (timerUtil == null) {
            synchronized (TimerUtil.class) {
                if (timerUtil == null) {
                    timerUtil = new TimerUtil();
                }
            }
        }
        return timerUtil;
    }

    public void cancel() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }

    public void cancelTask(TimerTask timerTask) {
        if (timerTask != null) {
            timerTask.cancel();
        }
    }

    public void schedule(long j10, TimerTask timerTask) {
        if (this.timer == null) {
            this.timer = new Timer();
        }
        this.timer.schedule(timerTask, j10);
    }

    public void schedule(long j10, long j11, TimerTask timerTask) {
        if (this.timer == null) {
            this.timer = new Timer();
        }
        this.timer.schedule(timerTask, j10, j11);
    }
}
