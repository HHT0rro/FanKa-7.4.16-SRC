package com.kwad.components.ad.reward.monitor;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RewardMonitorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    public static final int DOWNLOAD_TYPE_ALL = 2;
    public static final int DOWNLOAD_TYPE_ONLINE = 1;
    public static final int DOWNLOAD_TYPE_PART = 3;
    public static final int LOAD_STATUS_DATA_FINISH = 2;
    public static final int LOAD_STATUS_FAIL = 4;
    public static final int LOAD_STATUS_LOAD_FINISH = 3;
    public static final int LOAD_STATUS_RESPONSE_DATA = 6;
    public static final int LOAD_STATUS_START = 1;
    public static final int LOAD_STATUS_START_CACHE = 7;
    public static final int LOAD_STATUS_START_REQUEST = 5;
    public static final int LOAD_TYPE_LOCAL = 2;
    public static final int LOAD_TYPE_NET = 1;
    public static final int PAGE_STATUS_AD_PV = 6;
    public static final int PAGE_STATUS_ENTRY = 1;
    public static final int PAGE_STATUS_PAGE_RESUME = 5;
    public static final int PAGE_STATUS_PREVIEW_H5_ERROR = 9;
    public static final int PAGE_STATUS_PREVIEW_H5_START = 7;
    public static final int PAGE_STATUS_PREVIEW_H5_SUCCESS = 8;
    public static final int PAGE_STATUS_SHOW_AD_CALL = 3;
    public static final int PAGE_STATUS_SHOW_INTERCEPT = 4;
    public static final int PAGE_STATUS_START_PLAY = 2;
    public static final int PAGE_STATUS_SUB_PAGE_CREATE = 101;
    public static final int REWARD_TYPE_DEEP = 1;
    public static final int REWARD_TYPE_NORMAL = 0;
    public static final int SCENE_TYPE_IMAGE = 2;
    public static final int SCENE_TYPE_LIVE = 1;
    public static final int SCENE_TYPE_SCAN_AGGREGATION = 3;
    public static final int SCENE_TYPE_VIDEO = 0;
    public static final long serialVersionUID = 1080394611500009098L;
    public int adCount;
    public int adSceneType;
    public String callbackType;
    public long creativeId;
    public long currentDuration;
    public long dataDownloadInterval;
    public long dataLoadInterval;
    public long downloadDuration;
    public long downloadSize;
    public int downloadType;
    public String interceptReason;
    public String launchFrom;
    public long loadDataDuration;
    public int loadStatus;
    public int loadType;
    public String materialRenderType;
    public int materialType;
    public int operationType;
    public int pageStatus;
    public long posId;
    public long renderDuration;
    public int rewardTaskType;
    public String subStage;
    public int tkRenderType;
    public long totalDuration;
    public long videoDuration;
    public String videoUrl;
    public int rewardType = -1;
    public int taskType = -1;
    public int taskStep = -1;
    public boolean enableRewardLayoutOptimise = com.kwad.components.ad.reward.a.b.gD();
    public boolean enableFullscreenLayoutOptimise = com.kwad.components.ad.reward.a.b.gE();

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        int i10 = this.rewardType;
        if (i10 != -1) {
            t.putValue(jSONObject, "reward_type", i10);
        } else {
            jSONObject.remove("reward_type");
        }
        int i11 = this.taskType;
        if (i11 != -1) {
            t.putValue(jSONObject, "task_type", i11);
        } else {
            jSONObject.remove("task_type");
        }
        int i12 = this.taskStep;
        if (i12 != -1) {
            t.putValue(jSONObject, "task_step", i12);
        } else {
            jSONObject.remove("task_step");
        }
    }

    public RewardMonitorInfo setAdCount(int i10) {
        this.adCount = i10;
        return this;
    }

    public RewardMonitorInfo setAdSceneType(int i10) {
        this.adSceneType = i10;
        return this;
    }

    public RewardMonitorInfo setCallbackType(String str) {
        this.callbackType = str;
        return this;
    }

    public RewardMonitorInfo setCreativeId(long j10) {
        this.creativeId = j10;
        return this;
    }

    public RewardMonitorInfo setCurrentDuration(long j10) {
        this.currentDuration = j10;
        return this;
    }

    public RewardMonitorInfo setDataDownloadInterval(long j10) {
        this.dataDownloadInterval = j10;
        return this;
    }

    public RewardMonitorInfo setDataLoadInterval(long j10) {
        this.dataLoadInterval = j10;
        return this;
    }

    public RewardMonitorInfo setDownloadDuration(long j10) {
        this.downloadDuration = j10;
        return this;
    }

    public RewardMonitorInfo setDownloadSize(long j10) {
        this.downloadSize = j10;
        return this;
    }

    public RewardMonitorInfo setDownloadType(int i10) {
        this.downloadType = i10;
        return this;
    }

    public RewardMonitorInfo setInterceptReason(String str) {
        this.interceptReason = str;
        return this;
    }

    public RewardMonitorInfo setLaunchFrom(String str) {
        this.launchFrom = str;
        return this;
    }

    public RewardMonitorInfo setLoadDataDuration(long j10) {
        this.loadDataDuration = j10;
        return this;
    }

    public RewardMonitorInfo setLoadStatus(int i10) {
        this.loadStatus = i10;
        return this;
    }

    public RewardMonitorInfo setLoadType(int i10) {
        this.loadType = i10;
        return this;
    }

    public RewardMonitorInfo setMaterialRenderType(String str) {
        this.materialRenderType = str;
        return this;
    }

    public RewardMonitorInfo setMaterialType(int i10) {
        this.materialType = i10;
        return this;
    }

    public RewardMonitorInfo setOperationType(int i10) {
        this.operationType = i10;
        return this;
    }

    public RewardMonitorInfo setPageStatus(int i10) {
        this.pageStatus = i10;
        return this;
    }

    public RewardMonitorInfo setRenderDuration(long j10) {
        this.renderDuration = j10;
        return this;
    }

    public RewardMonitorInfo setRewardTaskType(int i10) {
        this.rewardTaskType = i10;
        return this;
    }

    public RewardMonitorInfo setRewardType(int i10) {
        this.rewardType = i10;
        return this;
    }

    public RewardMonitorInfo setSubStage(String str) {
        this.subStage = str;
        return this;
    }

    public RewardMonitorInfo setTKRenderType(int i10) {
        this.tkRenderType = i10;
        return this;
    }

    public RewardMonitorInfo setTaskStep(int i10) {
        this.taskStep = i10;
        return this;
    }

    public RewardMonitorInfo setTaskType(int i10) {
        this.taskType = i10;
        return this;
    }

    public RewardMonitorInfo setTotalDuration(long j10) {
        this.totalDuration = j10;
        return this;
    }

    public RewardMonitorInfo setVideoDuration(long j10) {
        this.videoDuration = j10;
        return this;
    }

    public RewardMonitorInfo setVideoUrl(String str) {
        this.videoUrl = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public RewardMonitorInfo setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return this;
        }
        RewardMonitorInfo rewardMonitorInfo = (RewardMonitorInfo) super.setAdTemplate(adTemplate);
        int dK = e.dK(adTemplate);
        AdInfo dQ = e.dQ(adTemplate);
        rewardMonitorInfo.setOperationType(com.kwad.sdk.core.response.b.a.aQ(dQ));
        rewardMonitorInfo.setMaterialRenderType(com.kwad.components.ad.reward.model.d.m(dQ));
        rewardMonitorInfo.setTKRenderType(com.kwad.sdk.core.response.b.b.a(dK == 2, dQ));
        return rewardMonitorInfo;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public RewardMonitorInfo setErrorCode(int i10) {
        super.setErrorCode(i10);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public RewardMonitorInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public RewardMonitorInfo setPosId(long j10) {
        return (RewardMonitorInfo) super.setPosId(j10);
    }
}
