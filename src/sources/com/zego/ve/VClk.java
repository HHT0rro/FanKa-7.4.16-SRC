package com.zego.ve;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class VClk {
    private static final int MESSAGE_RESTART = 2;
    private static final int MESSAGE_START = 0;
    private static final int MESSAGE_STOP = 1;
    private static final String TAG = "VClk";
    private static VClk sInstance = new VClk();
    private EventHandler mCallback;
    private Handler mHandler;
    private HandlerThread mThread;
    private long pThis = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class EventHandler implements Handler.Callback, Choreographer.FrameCallback {
        private AtomicLong mAtomicThis;
        private boolean mRunning;

        private EventHandler() {
            this.mAtomicThis = new AtomicLong();
            this.mRunning = false;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j10) {
            if (this.mRunning) {
                long j11 = this.mAtomicThis.get();
                if (j11 == 0) {
                    return;
                }
                VClk.on_video_tick(j11, j10);
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 0) {
                try {
                    if (i10 == 1) {
                        if (this.mRunning) {
                            this.mRunning = false;
                            Choreographer.getInstance().removeFrameCallback(this);
                            int i11 = Build.VERSION.SDK_INT;
                            if (i11 < 28 && i11 >= 24) {
                                try {
                                    Choreographer.class.getMethod("releaseInstance", new Class[0]).invoke(null, new Object[0]);
                                } catch (IllegalAccessException e2) {
                                    e2.printStackTrace();
                                } catch (NoSuchMethodException e10) {
                                    e10.printStackTrace();
                                } catch (InvocationTargetException e11) {
                                    e11.printStackTrace();
                                }
                            }
                        }
                    } else if (i10 == 2) {
                        Choreographer.getInstance().removeFrameCallback(this);
                        Choreographer.getInstance().postFrameCallback(this);
                    }
                } catch (Exception unused) {
                }
            } else if (!this.mRunning) {
                this.mRunning = true;
                try {
                    Choreographer.getInstance().postFrameCallback(this);
                } catch (Exception e12) {
                    e12.printStackTrace();
                    long j10 = this.mAtomicThis.get();
                    if (j10 != 0) {
                        VClk.on_error(j10);
                    }
                }
            }
            return false;
        }

        public void init(long j10) {
            this.mAtomicThis.set(j10);
        }

        public void uninit() {
            this.mAtomicThis.set(0L);
        }
    }

    public VClk() {
        this.mThread = null;
        this.mCallback = null;
        this.mHandler = null;
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mThread = handlerThread;
        handlerThread.start();
        this.mCallback = new EventHandler();
        this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);
    }

    private static VClk getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native int on_error(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int on_video_tick(long j10, long j11);

    public int restartClock() {
        if (this.pThis == 0) {
            return 0;
        }
        this.mHandler.sendEmptyMessage(2);
        return 0;
    }

    public int start(long j10) {
        this.pThis = j10;
        return 0;
    }

    public int startClock() {
        long j10 = this.pThis;
        if (j10 != 0) {
            this.mCallback.init(j10);
            this.mHandler.sendEmptyMessage(0);
        }
        return 0;
    }

    public int stop(long j10) {
        this.mHandler.removeCallbacksAndMessages(null);
        this.pThis = 0L;
        return 0;
    }

    public int stopClock() {
        if (this.pThis == 0) {
            return 0;
        }
        this.mHandler.sendEmptyMessage(1);
        this.mCallback.uninit();
        return 0;
    }
}
