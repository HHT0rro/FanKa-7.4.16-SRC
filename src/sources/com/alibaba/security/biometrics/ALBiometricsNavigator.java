package com.alibaba.security.biometrics;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.security.biometrics.manager.ALBiometricsManager;
import com.alibaba.security.biometrics.service.model.params.ABParamsHelper;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.LocalBroadcastManagerUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class ALBiometricsNavigator {
    private static final String TAG = "ALBiometricsNavigator";
    private ALBiometricsManager mABManager;

    public ALBiometricsNavigator(Context context) {
        this.mABManager = new ALBiometricsManager(context);
    }

    private void collectLog(TrackLog trackLog) {
        getEventListener().onLogTrack(trackLog);
    }

    public final void finish(Context context) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setAction(ALBiometricsKeys.KEY_ACTION_FINISH_BIOMETRICS);
            LocalBroadcastManagerUtils.getInstance(context).sendBroadcast(intent);
        }
    }

    public abstract ALBiometricsEventListener getEventListener();

    public abstract Bundle getParams();

    public final void restart(Context context, Bundle bundle) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setAction(ALBiometricsKeys.KEY_ACTION_RESTART_BIOMETRICS);
            intent.putExtra("data", bundle);
            LocalBroadcastManagerUtils.getInstance(context).sendBroadcast(intent);
        }
    }

    public final void start(Context context) {
        start(context, null);
    }

    public final void start(Context context, ALBiometricsConfig aLBiometricsConfig) {
        collectLog(TrackLog.createBioMonitorStartLog());
        this.mABManager.setEventListener(getEventListener());
        this.mABManager.setAlBiometricsConfig(aLBiometricsConfig);
        Bundle params = getParams();
        this.mABManager.setParams(params, new ABParamsHelper(params).getParams());
        this.mABManager.open(context);
    }
}
