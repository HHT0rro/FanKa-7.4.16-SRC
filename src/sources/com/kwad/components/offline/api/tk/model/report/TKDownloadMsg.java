package com.kwad.components.offline.api.tk.model.report;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.huawei.flexiblelayout.parser.cardmanager.d;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TKDownloadMsg extends BaseOfflineCompoJsonParse<TKDownloadMsg> implements Serializable {
    public static final int ENV_SUCCESS = 3;
    public static final int FAIL = 2;
    private static final int INVALID_DOWNLOAD_STATE = -1;
    public static final int START = 0;
    public static final int SUCCESS = 1;
    private static final long serialVersionUID = -8872909341685100922L;
    public long availableTime;
    public int downloadState = -1;
    public long downloadTime;
    public String errorDetail;
    public String errorReason;
    public int loadingTimes;
    public long offlineLoadTime;
    public int offlineSource;
    public int preload;
    public int retryCount;
    public long soLoadTime;
    public int soSource;
    public String templateId;
    public int threadPoolCoreSize;
    public String versionCode;

    public TKDownloadMsg setDownloadState(int i10) {
        this.downloadState = i10;
        return this;
    }

    public TKDownloadMsg setDownloadTime(long j10) {
        this.downloadTime = j10;
        return this;
    }

    public TKDownloadMsg setErrorDetail(String str) {
        this.errorDetail = str;
        return this;
    }

    public TKDownloadMsg setErrorReason(String str) {
        this.errorReason = str;
        return this;
    }

    public TKDownloadMsg setInitSdkTimeConsuming(long j10) {
        this.availableTime = j10;
        return this;
    }

    public TKDownloadMsg setLoadingTimes(int i10) {
        this.loadingTimes = i10;
        return this;
    }

    public TKDownloadMsg setOfflineLoadTime(long j10) {
        this.offlineLoadTime = j10;
        return this;
    }

    public TKDownloadMsg setOfflineSource(int i10) {
        this.offlineSource = i10;
        return this;
    }

    public TKDownloadMsg setPreload(int i10) {
        this.preload = i10;
        return this;
    }

    public TKDownloadMsg setRetryCount(int i10) {
        this.retryCount = i10;
        return this;
    }

    public TKDownloadMsg setSoLoadTime(long j10) {
        this.soLoadTime = j10;
        return this;
    }

    public TKDownloadMsg setSoSource(int i10) {
        this.soSource = i10;
        return this;
    }

    public TKDownloadMsg setTemplateId(String str) {
        this.templateId = str;
        return this;
    }

    public TKDownloadMsg setThreadPoolCoreSize(int i10) {
        this.threadPoolCoreSize = i10;
        return this;
    }

    public TKDownloadMsg setVersionCode(String str) {
        this.versionCode = str;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TKDownloadMsg tKDownloadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKDownloadMsg.downloadState = jSONObject.optInt("download_state");
        tKDownloadMsg.downloadTime = jSONObject.optLong(MonitorConstants.EXTRA_DOWNLOAD_TIME);
        tKDownloadMsg.preload = jSONObject.optInt(d.a.f28342a);
        tKDownloadMsg.errorReason = jSONObject.optString("error_reason");
        if (jSONObject.opt("error_reason") == JSONObject.NULL) {
            tKDownloadMsg.errorReason = "";
        }
        tKDownloadMsg.templateId = jSONObject.optString(ExposeManager.UtArgsNames.templateId);
        if (jSONObject.opt(ExposeManager.UtArgsNames.templateId) == JSONObject.NULL) {
            tKDownloadMsg.templateId = "";
        }
        tKDownloadMsg.versionCode = jSONObject.optString("version_code");
        if (jSONObject.opt("version_code") == JSONObject.NULL) {
            tKDownloadMsg.versionCode = "";
        }
        tKDownloadMsg.retryCount = jSONObject.optInt(MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT);
        tKDownloadMsg.loadingTimes = jSONObject.optInt("loading_times");
        tKDownloadMsg.offlineSource = jSONObject.optInt("offline_source");
        tKDownloadMsg.soSource = jSONObject.optInt("so_source");
        tKDownloadMsg.offlineLoadTime = jSONObject.optLong("offline_load_time");
        tKDownloadMsg.soLoadTime = jSONObject.optLong("so_load_time");
        tKDownloadMsg.errorDetail = jSONObject.optString("error_detail");
        if (jSONObject.opt("error_detail") == JSONObject.NULL) {
            tKDownloadMsg.errorDetail = "";
        }
        tKDownloadMsg.threadPoolCoreSize = jSONObject.optInt("thread_pool_core_size");
        tKDownloadMsg.availableTime = jSONObject.optLong("available_time");
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKDownloadMsg tKDownloadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JsonHelper.putValue(jSONObject, "download_state", tKDownloadMsg.downloadState);
        JsonHelper.putValue(jSONObject, "thread_pool_core_size", tKDownloadMsg.threadPoolCoreSize);
        JsonHelper.putValue(jSONObject, "available_time", tKDownloadMsg.availableTime);
        long j10 = tKDownloadMsg.downloadTime;
        if (j10 != 0) {
            JsonHelper.putValue(jSONObject, MonitorConstants.EXTRA_DOWNLOAD_TIME, j10);
        }
        int i10 = tKDownloadMsg.preload;
        if (i10 != 0) {
            JsonHelper.putValue(jSONObject, d.a.f28342a, i10);
        }
        String str = tKDownloadMsg.errorReason;
        if (str != null && !str.equals("")) {
            JsonHelper.putValue(jSONObject, "error_reason", tKDownloadMsg.errorReason);
        }
        String str2 = tKDownloadMsg.templateId;
        if (str2 != null && !str2.equals("")) {
            JsonHelper.putValue(jSONObject, ExposeManager.UtArgsNames.templateId, tKDownloadMsg.templateId);
        }
        String str3 = tKDownloadMsg.versionCode;
        if (str3 != null && !str3.equals("")) {
            JsonHelper.putValue(jSONObject, "version_code", tKDownloadMsg.versionCode);
        }
        int i11 = tKDownloadMsg.retryCount;
        if (i11 != 0) {
            JsonHelper.putValue(jSONObject, MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, i11);
        }
        int i12 = tKDownloadMsg.loadingTimes;
        if (i12 != 0) {
            JsonHelper.putValue(jSONObject, "loading_times", i12);
        }
        int i13 = tKDownloadMsg.offlineSource;
        if (i13 != 0) {
            JsonHelper.putValue(jSONObject, "offline_source", i13);
        }
        int i14 = tKDownloadMsg.soSource;
        if (i14 != 0) {
            JsonHelper.putValue(jSONObject, "so_source", i14);
        }
        long j11 = tKDownloadMsg.offlineLoadTime;
        if (j11 != 0) {
            JsonHelper.putValue(jSONObject, "offline_load_time", j11);
        }
        long j12 = tKDownloadMsg.soLoadTime;
        if (j12 != 0) {
            JsonHelper.putValue(jSONObject, "so_load_time", j12);
        }
        String str4 = tKDownloadMsg.errorDetail;
        if (str4 != null && !str4.equals("")) {
            JsonHelper.putValue(jSONObject, "error_detail", tKDownloadMsg.errorDetail);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKDownloadMsg tKDownloadMsg) {
        return toJson(tKDownloadMsg, (JSONObject) null);
    }
}
