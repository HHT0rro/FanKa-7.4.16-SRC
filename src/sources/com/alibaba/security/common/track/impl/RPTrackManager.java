package com.alibaba.security.common.track.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.interfaces.ITrackUpload;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.TrackLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPTrackManager {
    private static final int DEFAULT_TRACK_CACHE_SIZE = 10;
    private static final int MSG_RELEASE = 2;
    private static final int MSG_UPLOAD = 1;
    private static final String TAG = "RPTrackManager";
    private static final int UPLOAD_DELAYED_TIME = 5000;
    private static final boolean debug = false;
    private final ThreadPoolExecutor mAudioExecutorService;
    private Context mContext;
    private ITrackUpload mITrackUpload;
    private LastExitTrackMsg mLastStepTrackMsg;
    private final TimeHandler mTimeHandler;
    private final List<TrackLog> mTraceLogBuffer;
    private RPTrack.TrackStrategy mTrackStrategy;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class HOLDER {
        private static final RPTrackManager SINGLE = new RPTrackManager();

        private HOLDER() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class TimeHandler extends Handler {
        private final RPTrackManager mRpTrackManager;

        public TimeHandler(RPTrackManager rPTrackManager) {
            super(Looper.getMainLooper());
            this.mRpTrackManager = rPTrackManager;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 == 1) {
                this.mRpTrackManager.uploadNow();
            } else {
                if (i10 != 2) {
                    return;
                }
                this.mRpTrackManager.doRelease();
            }
        }
    }

    private RPTrack.TrackStrategy defaultTrackStrategy() {
        return new RPTrack.TrackStrategy.Builder().setTrackCacheSize(10).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRelease() {
        this.mTimeHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpUploadNow() {
        if (this.mTraceLogBuffer.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(new TrackLog[this.mTraceLogBuffer.size()]));
        Collections.copy(arrayList, this.mTraceLogBuffer);
        ITrackUpload iTrackUpload = this.mITrackUpload;
        if (iTrackUpload != null) {
            iTrackUpload.upload(arrayList);
            this.mTraceLogBuffer.clear();
        }
    }

    public static RPTrackManager getInstance() {
        return HOLDER.SINGLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void looperUpload(boolean z10) {
        this.mTimeHandler.removeMessages(1);
        if (z10) {
            return;
        }
        this.mTimeHandler.sendEmptyMessageDelayed(1, 5000L);
    }

    public LastExitTrackMsg getLastStepTrackMsg() {
        return this.mLastStepTrackMsg;
    }

    public void init(Context context, RPTrack.TrackStrategy trackStrategy) {
        this.mContext = context;
        if (trackStrategy == null) {
            trackStrategy = defaultTrackStrategy();
        }
        this.mTrackStrategy = trackStrategy;
        this.mTimeHandler.removeMessages(1);
        this.mTimeHandler.sendEmptyMessageDelayed(1, 5000L);
    }

    public void release() {
        uploadNow(true);
        this.mTimeHandler.sendEmptyMessageDelayed(2, 5000L);
    }

    public void setLastStepMsg(LastExitTrackMsg lastExitTrackMsg) {
        this.mLastStepTrackMsg = lastExitTrackMsg;
    }

    public void setUploadImpl(ITrackUpload iTrackUpload) {
        this.mITrackUpload = iTrackUpload;
    }

    public void t(final TrackLog trackLog) {
        this.mAudioExecutorService.execute(new Runnable() { // from class: com.alibaba.security.common.track.impl.RPTrackManager.2
            @Override // java.lang.Runnable
            public void run() {
                RPTrackManager.this.mTraceLogBuffer.add(trackLog);
                if (!RPTrackManager.this.mTimeHandler.hasMessages(1)) {
                    RPTrackManager.this.mTimeHandler.sendEmptyMessageDelayed(1, 5000L);
                }
                if (RPTrackManager.this.mTraceLogBuffer.size() >= RPTrackManager.this.mTrackStrategy.getTrackCacheSize()) {
                    RPTrackManager.this.dpUploadNow();
                }
            }
        });
    }

    public void uploadNow() {
        uploadNow(false);
    }

    private RPTrackManager() {
        this.mTimeHandler = new TimeHandler(this);
        this.mTraceLogBuffer = new ArrayList();
        this.mTrackStrategy = defaultTrackStrategy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.common.track.impl.RPTrackManager.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "rpsdk-rpTrackManager");
            }
        });
        this.mAudioExecutorService = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private void uploadNow(final boolean z10) {
        if (this.mTraceLogBuffer.isEmpty()) {
            looperUpload(z10);
        } else {
            this.mAudioExecutorService.execute(new Runnable() { // from class: com.alibaba.security.common.track.impl.RPTrackManager.3
                @Override // java.lang.Runnable
                public void run() {
                    RPTrackManager.this.dpUploadNow();
                    RPTrackManager.this.looperUpload(z10);
                }
            });
        }
    }
}
