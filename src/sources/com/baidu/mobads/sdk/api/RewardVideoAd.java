package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.aw;
import com.baidu.mobads.sdk.internal.bs;
import com.baidu.mobads.sdk.internal.ds;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RewardVideoAd {
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    private static final String TAG = "RewardVideoAd";
    private ds mAdProd;
    private final Context mContext;
    private RequestParameters mRequestParameters;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface RewardVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f10);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdLoaded();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f10);

        void onRewardVerify(boolean z10);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener) {
        this(context, str, rewardVideoAdListener, false);
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingSuccess(String str) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.a(true, str);
        }
    }

    public Object getAdDataForKey(String str) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            return dsVar.k(str);
        }
        return null;
    }

    public String getBiddingToken() {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            return dsVar.m();
        }
        return null;
    }

    public String getECPMLevel() {
        ds dsVar = this.mAdProd;
        return dsVar != null ? dsVar.h() : "";
    }

    public boolean isReady() {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            return dsVar.g();
        }
        return false;
    }

    public synchronized void load() {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.a();
        }
    }

    public void loadBiddingAd(String str) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.c(str);
        }
    }

    public void setAppSid(String str) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.h(str);
        }
    }

    public void setBidFloor(int i10) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.f9886p = i10;
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.b(str);
        }
    }

    public void setDownloadAppConfirmPolicy(int i10) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.a(i10);
        }
    }

    public void setExtraInfo(String str) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.j(str);
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        ds dsVar;
        this.mRequestParameters = requestParameters;
        if (requestParameters == null || (dsVar = this.mAdProd) == null) {
            return;
        }
        dsVar.a(requestParameters);
    }

    public void setShowDialogOnSkip(boolean z10) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showDialogOnSkip", z10);
                this.mAdProd.a(jSONObject);
            } catch (Throwable th) {
                bs.a().c(th);
            }
        }
    }

    public void setUserId(String str) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.a(str);
        }
    }

    public synchronized void show() {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.f();
        }
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener, boolean z10) {
        this.mContext = context;
        ds dsVar = new ds(context, str, z10);
        this.mAdProd = dsVar;
        dsVar.a(rewardVideoAdListener);
        if (TextUtils.isEmpty(str)) {
            aw.c().e("RewardVideoAd初始化异常：广告位为空");
        }
    }

    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.a(false, str, hashMap);
        }
    }

    public synchronized void show(Context context) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.a(context);
        }
    }
}
