package com.alibaba.security.biometrics.service;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Handler;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.build.a;
import com.alibaba.security.biometrics.service.build.ag;
import com.alibaba.security.biometrics.service.build.c;
import com.alibaba.security.biometrics.service.build.e;
import com.alibaba.security.biometrics.service.build.f;
import com.alibaba.security.biometrics.service.build.h;
import com.alibaba.security.biometrics.service.build.t;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ALBiometricsType;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.JsonUtils;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ALBiometricsService {
    private static final String TAG = "ALBiometricsService";
    private ALBiometricsParams mALBiometricsParams;
    private boolean mIsCollectAlgoStartLog;
    private Context mContext = null;
    private t mABStateMachine = null;
    private ALBiometricsServiceEventListener mABEventListener = null;
    private boolean bRunning = false;

    public ALBiometricsService(Context context, ALBiometricsParams aLBiometricsParams, ALBiometricsServiceEventListener aLBiometricsServiceEventListener) {
        init(context, aLBiometricsParams, aLBiometricsServiceEventListener);
    }

    private String algoStartParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("detectType", ALBiometricsType.isDazzle(this.mALBiometricsParams.mBiometricsType) ? "colorful" : "action");
        return JsonUtils.toJSON(hashMap);
    }

    private void init(Context context, ALBiometricsParams aLBiometricsParams, ALBiometricsServiceEventListener aLBiometricsServiceEventListener) {
        this.mContext = context;
        this.mABEventListener = aLBiometricsServiceEventListener;
        this.mALBiometricsParams = aLBiometricsParams;
        this.mABStateMachine = new t(this);
    }

    public void collectLog(TrackLog trackLog) {
        ALBiometricsServiceEventListener aLBiometricsServiceEventListener = this.mABEventListener;
        if (aLBiometricsServiceEventListener != null) {
            aLBiometricsServiceEventListener.onLogTrack(trackLog);
        }
    }

    public ALBiometricsServiceEventListener getABEventListener() {
        return this.mABEventListener;
    }

    public Context getContext() {
        return this.mContext;
    }

    public ALBiometricsParams getParams() {
        return this.mALBiometricsParams;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0215  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void process(byte[] r23, int r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 855
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.service.ALBiometricsService.process(byte[], int, int, int):void");
    }

    public void release() {
        Handler handler;
        if (this.bRunning) {
            stop();
        }
        t tVar = this.mABStateMachine;
        if (tVar != null) {
            if (tVar.f_) {
                tVar.f_ = false;
                ag.c.h(tVar.g_);
            }
            f fVar = tVar.f2847s;
            if (fVar != null) {
                fVar.f2745j = null;
                if (fVar.f2746k) {
                    ALBiometricsJni.release();
                }
                e eVar = fVar.f2752q;
                if (eVar != null) {
                    if (ALBiometricsJni.isLoaded()) {
                        ALBiometricsJni.release();
                    }
                    if (eVar.f2712h != null && (handler = eVar.f2716l) != null) {
                        handler.post(new e.AnonymousClass4());
                    }
                    eVar.f2713i = 0;
                    eVar.f2714j = 0L;
                    eVar.f2717m = false;
                }
            }
            e.b();
            ABDetectContext.getInstance().destroy();
            h hVar = tVar.f2849u;
            if (hVar != null) {
                hVar.f2760c = null;
            }
            c cVar = tVar.f2845q;
            if (cVar != null) {
                SensorManager sensorManager = cVar.f2686c;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(cVar.f2689f);
                    cVar.f2686c.unregisterListener(cVar.f2690g);
                    cVar.f2686c.unregisterListener(cVar.f2691h);
                }
                cVar.f2686c = null;
                cVar.f2689f = null;
                cVar.f2690g = null;
                cVar.f2691h = null;
            }
            tVar.C = false;
        }
        a.b();
    }

    public void resetBioTimeOut(int i10) {
        this.mABStateMachine.b(i10);
    }

    public void restart() {
        if (this.bRunning) {
            return;
        }
        if (!this.mIsCollectAlgoStartLog) {
            collectLog(TrackLog.createBioMonitorAlgoStartLog(algoStartParams()));
            this.mIsCollectAlgoStartLog = true;
        }
        t tVar = this.mABStateMachine;
        ABDetectContext.getInstance().getResult().increaseRetryTime();
        ABDetectContext.getInstance().setRetryTimes(ABDetectContext.getInstance().getRetryTimes() + 1);
        if (ABDetectContext.getInstance().getRetryTimes() > tVar.f2844p.retryThreshold) {
            tVar.f2848t.a(GlobalErrorCode.ERROR_USER_RETRY_LIMITED);
        } else {
            tVar.c();
        }
        this.bRunning = true;
    }

    public ALBiometricsService setParams(ALBiometricsParams aLBiometricsParams) {
        this.mALBiometricsParams = aLBiometricsParams;
        return this;
    }

    public void start() {
        if (this.bRunning) {
            return;
        }
        a.a().a(this.mABEventListener);
        if (!this.mIsCollectAlgoStartLog) {
            collectLog(TrackLog.createBioMonitorAlgoStartLog(algoStartParams()));
            this.mIsCollectAlgoStartLog = true;
        }
        this.mABStateMachine.c();
        this.bRunning = true;
    }

    public void stop() {
        if (this.bRunning) {
            this.bRunning = false;
            t tVar = this.mABStateMachine;
            try {
                ABDetectContext.getInstance().stop();
                h hVar = tVar.f2849u;
                if (hVar != null) {
                    hVar.d();
                }
                tVar.c(998);
            } catch (Throwable th) {
                a.a().a(th);
            }
        }
    }
}
