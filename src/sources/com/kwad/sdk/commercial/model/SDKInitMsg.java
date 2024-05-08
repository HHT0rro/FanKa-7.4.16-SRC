package com.kwad.sdk.commercial.model;

import android.os.Looper;
import com.android.internal.logging.nano.MetricsProto;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.c.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import java.io.Serializable;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SDKInitMsg extends a implements Serializable {
    private static final int CHILD_PROCESS = 2;
    private static final int DYNAMIC_DISABLE = 2;
    private static final int DYNAMIC_ENABLE = 1;
    public static final int FAIL = 2;
    public static final int FINISH = 1;
    private static final int MAIN_PROCESS = 1;
    private static final int MAIN_THREAD = 1;
    public static final int START = 0;
    private static final int WORK_THREAD = 2;
    private static final long serialVersionUID = 368743526206619387L;
    public String errorReason;
    public int initCount;
    public int initProcess;
    public int initStatus;
    public int initThread;
    public int intBuildNumber;
    public int intDynamicSDK;
    public long launchIntervalTime;
    public long totalDurationTime;

    public SDKInitMsg() {
        this.initProcess = aq.isInMainProcess(ServiceProvider.KO()) ? 1 : 2;
        this.initThread = Looper.getMainLooper() == Looper.myLooper() ? 1 : 2;
        this.intDynamicSDK = com.kwad.framework.a.a.adG.booleanValue() ? 1 : 2;
        this.intBuildNumber = MetricsProto.MetricsEvent.PROVISIONING_ENTRY_POINT_QR_CODE;
    }

    public SDKInitMsg setErrorReason(String str) {
        this.errorReason = str;
        return this;
    }

    public SDKInitMsg setInitCount(int i10) {
        this.initCount = i10;
        return this;
    }

    public SDKInitMsg setInitStatus(int i10) {
        this.initStatus = i10;
        return this;
    }

    public SDKInitMsg setLaunchIntervalTime(long j10) {
        this.launchIntervalTime = j10;
        return this;
    }

    public SDKInitMsg setTotalDurationTime(long j10) {
        this.totalDurationTime = j10;
        return this;
    }
}
