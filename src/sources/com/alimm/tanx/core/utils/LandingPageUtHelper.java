package com.alimm.tanx.core.utils;

import com.alimm.tanx.core.ad.bean.BidInfo;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LandingPageUtHelper implements NotConfused {
    public static final String WEBVIEW_TYPE_SYSTEM = "2";
    public static final String WEBVIEW_TYPE_UC = "1";
    public static final String WEBVIEW_TYPE_WV = "0";
    public static final String XAD_UT_LP_CONTENT_VIEW = "content_view";
    public static final String XAD_UT_LP_DESTROY = "destroy";
    public static final String XAD_UT_LP_LOAD_FINISH = "load_finish";
    public static final String XAD_UT_LP_LOAD_RESULT = "load_result";
    public static final String XAD_UT_LP_OPTIMIZE = "optimize";
    public static final String XAD_UT_LP_PAGE_FINISH = "page_finish";
    public static final String XAD_UT_LP_RESUME = "resume";
    public static final String XAD_UT_LP_START_LOAD = "start_load";
    public static final String XAD_UT_LP_STAY_TIME = "xad_lp_stay_time";
    public static final String XAD_UT_LP_T0 = "status_t0";
    public static final String XAD_UT_LP_T1 = "status_t1";
    public static final String XAD_UT_LP_T2 = "status_t2";
    public static final String XAD_UT_LP_T3 = "status_t3";
    public static final String XAD_UT_LP_TIME = "xad_lp_time";
    public long mContentViewTime;
    public long mDestroyTime;
    public long mLoadFinishTime;
    public int mLoadResult;
    public long mLoadUrlTime;
    public long mResumeTime;
    public long mTimeT0;
    public long mTimeT1;
    public long mTimeT2;
    public long mTimeT3;
    public long mUserClickTime;

    private void addParams(BidInfo bidInfo, String str, Map<String, String> map) {
    }

    public void recordLandingFinish(BidInfo bidInfo, String str) {
    }

    public void recordLandingPageDestroy(BidInfo bidInfo, String str) {
    }

    public void setContentViewTime(long j10) {
        this.mContentViewTime = j10;
    }

    public void setDestroyTime(long j10) {
        this.mDestroyTime = j10;
    }

    public void setLoadFinishTime(long j10, int i10) {
        this.mLoadFinishTime = j10;
        this.mLoadResult = i10;
    }

    public void setLoadUrlTime(long j10) {
        this.mLoadUrlTime = j10;
    }

    public void setResumeTime(long j10) {
        this.mResumeTime = j10;
    }

    public void setTimeT0(long j10) {
        if (this.mTimeT0 == 0) {
            this.mTimeT0 = j10;
        }
    }

    public void setTimeT1(long j10) {
        if (this.mTimeT1 == 0) {
            this.mTimeT1 = j10;
        }
    }

    public void setTimeT2(long j10) {
        if (this.mTimeT2 == 0) {
            this.mTimeT2 = j10;
        }
    }

    public void setTimeT3(long j10) {
        if (this.mTimeT3 == 0) {
            this.mTimeT3 = j10;
        }
    }

    public void setUserClickTime(long j10) {
        this.mUserClickTime = j10;
    }
}
