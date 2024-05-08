package com.alibaba.security.common.track;

import android.content.Context;
import com.alibaba.security.common.track.impl.RPTrackManager;
import com.alibaba.security.common.track.interfaces.ITrackUpload;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.TrackLog;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPTrack {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class TrackStrategy implements Serializable {
        private int mTrackCacheSize;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public static class Builder implements Serializable {
            private int mTrackCacheSize;

            public TrackStrategy build() {
                return new TrackStrategy(this.mTrackCacheSize);
            }

            public Builder setTrackCacheSize(int i10) {
                this.mTrackCacheSize = i10;
                return this;
            }
        }

        public TrackStrategy(int i10) {
            this.mTrackCacheSize = i10;
        }

        public int getTrackCacheSize() {
            return this.mTrackCacheSize;
        }
    }

    public static LastExitTrackMsg getLastStepTrackMsg() {
        return RPTrackManager.getInstance().getLastStepTrackMsg();
    }

    public static void init(Context context, TrackStrategy trackStrategy) {
        RPTrackManager.getInstance().init(context, trackStrategy);
    }

    public static void release() {
        RPTrackManager.getInstance().release();
    }

    public static void setLastStepTrackMsg(LastExitTrackMsg lastExitTrackMsg) {
        RPTrackManager.getInstance().setLastStepMsg(lastExitTrackMsg);
    }

    public static void setUploadImpl(ITrackUpload iTrackUpload) {
        RPTrackManager.getInstance().setUploadImpl(iTrackUpload);
    }

    public static void t(TrackLog trackLog) {
        RPTrackManager.getInstance().t(trackLog);
    }

    public static void uploadNow() {
        RPTrackManager.getInstance().uploadNow();
    }

    public static void init(Context context) {
        RPTrackManager.getInstance().init(context, null);
    }
}
