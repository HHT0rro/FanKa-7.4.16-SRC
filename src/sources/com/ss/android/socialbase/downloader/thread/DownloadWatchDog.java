package com.ss.android.socialbase.downloader.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class DownloadWatchDog implements Handler.Callback {
    private static final int MSG_SCHEDULE_WATCH = 0;
    private volatile Handler handler = new Handler(Holder.LOOPER, this);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Holder {
        private static final Looper LOOPER;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            LOOPER = handlerThread.getLooper();
        }

        private Holder() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface IWatcher {
        long onScheduleWatch();
    }

    public static Looper getThreadLooper() {
        return Holder.LOOPER;
    }

    public void addWatcher(IWatcher iWatcher, long j10) {
        Handler handler = this.handler;
        if (handler == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = iWatcher;
        handler.sendMessageDelayed(obtain, j10);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            IWatcher iWatcher = (IWatcher) message.obj;
            long onScheduleWatch = iWatcher.onScheduleWatch();
            if (onScheduleWatch <= 0) {
                return true;
            }
            addWatcher(iWatcher, onScheduleWatch);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public void release() {
        Handler handler = this.handler;
        if (handler == null) {
            return;
        }
        this.handler = null;
        handler.removeCallbacksAndMessages(null);
    }

    public void removeWatcher(IWatcher iWatcher) {
        Handler handler = this.handler;
        if (handler == null) {
            return;
        }
        handler.removeMessages(0, iWatcher);
    }
}
