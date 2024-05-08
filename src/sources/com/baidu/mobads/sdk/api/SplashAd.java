package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.ay;
import com.baidu.mobads.sdk.internal.bo;
import com.baidu.mobads.sdk.internal.bs;
import com.baidu.mobads.sdk.internal.cq;
import com.baidu.mobads.sdk.internal.dg;
import com.baidu.mobads.sdk.internal.dt;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class SplashAd {
    private static final int BOTTOM_VIEW_ID = 4097;
    public static final String KEY_BIDFAIL_ADN = "adn";
    public static final String KEY_BIDFAIL_ECPM = "ecpm";
    public static final String KEY_DISPLAY_DOWNLOADINFO = "displayDownloadInfo";
    public static final String KEY_FETCHAD = "fetchAd";
    public static final String KEY_LOAD_AFTER_CACHE_END = "loadAfterCacheEnd";
    public static final String KEY_POPDIALOG_DOWNLOAD = "use_dialog_frame";
    public static final String KEY_PREFER_FULLSCREEN = "prefer_fullscreen";
    public static final String KEY_SHAKE_LOGO_SIZE = "shake_logo_size";
    public static final String KEY_TIMEOUT = "timeout";
    public static final String KEY_TWIST_BG_COLOR = "twist_bg_color";
    public static final String KEY_TWIST_LOGO_HEIGHT_DP = "twist_logo_height_dp";
    public static final String KEY_USE_ADAPTIVE_AD = "adaptive_ad";
    private static final int RT_SPLASH_LOAD_AD_TIMEOUT = 4200;
    private String mAdPlaceId;
    private dt mAdProd;
    private String mAppSid;
    private int mBidFloor;
    private Context mContext;
    private Boolean mDisplayClickRegion;
    private boolean mDisplayDownInfo;
    private SplashAdDownloadDialogListener mDownloadDialogListener;
    private boolean mFetchAd;
    private boolean mFetchNotShow;
    private boolean mIsAdaptiveSplashAd;
    private Boolean mLimitRegionClick;
    private SplashAdListener mListener;
    private RequestParameters mParameter;
    private Boolean mPopDialogIfDL;
    private int mShakeLogoSize;
    private int mTimeout;
    private int mTipStyle;
    public int mTwistBgColor;
    public int mTwistLogoHeightDp;
    private ViewGroup mViewParent;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnFinishListener {
        void onFinishActivity();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface SplashAdDownloadDialogListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADFunctionLpClose();

        void onADFunctionLpShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyLpClose();

        void onADPrivacyLpShow();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface SplashCardAdListener {
        void onCardClick();

        void onCardClose();

        void onCardShow();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface SplashFocusAdListener {
        void onAdClick();

        void onAdClose();

        void onAdIconShow();

        void onLpClosed();
    }

    public SplashAd(Context context, String str, SplashAdListener splashAdListener) {
        this(context, str, null, splashAdListener);
    }

    private void addZeroPxSurfaceViewAvoidBlink(ViewGroup viewGroup, Context context) {
        try {
            viewGroup.addView(new SurfaceView(context), new RelativeLayout.LayoutParams(0, 0));
        } catch (Exception e2) {
            bs.a().a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callAdFailed(String str) {
        if (this.mListener != null) {
            sendSplashFailedLog(str);
            this.mListener.onAdFailed(str);
        }
    }

    public static void registerEnterTransition(Activity activity, SplashFocusAdListener splashFocusAdListener) {
        dt.a(activity, (JSONObject) null, splashFocusAdListener);
    }

    private void sendSplashFailedLog(String str) {
        try {
            dt dtVar = this.mAdProd;
            if (dtVar != null) {
                dtVar.a(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void sendSplashLog(ViewGroup viewGroup, View view) {
        try {
            HashMap hashMap = new HashMap();
            StringBuilder sb2 = new StringBuilder();
            boolean z10 = true;
            sb2.append(viewGroup == null);
            sb2.append("");
            hashMap.put("adContainer", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            if (!this.mIsAdaptiveSplashAd || view != null) {
                z10 = false;
            }
            sb3.append(z10);
            sb3.append("");
            hashMap.put("isAdaptive", sb3.toString());
            hashMap.put("mFetchNotShow", this.mFetchNotShow + "");
            if (this.mAdProd != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msg", "sendSplashLog");
                } catch (JSONException e2) {
                    bs.a().a(e2);
                }
                this.mAdProd.a(jSONObject, hashMap);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void setAppLogo(Object obj) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_type", "splash_logo");
                HashMap hashMap = new HashMap();
                hashMap.put("appLogo", obj);
                this.mAdProd.a(jSONObject, hashMap);
            } catch (Throwable th) {
                bs.a().d(th);
            }
        }
    }

    private final void setAppLogoData(byte[] bArr) {
        setAppLogo(bArr);
    }

    private final void setAppLogoId(int i10) {
        setAppLogo(Integer.valueOf(i10));
    }

    private final void showWithBottomView(ViewGroup viewGroup, View view) {
        sendSplashLog(viewGroup, view);
        this.mViewParent = viewGroup;
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("传入容器不可以为空");
                this.mListener.onAdFailed("传入容器不可以为空");
                return;
            }
            return;
        }
        if (this.mIsAdaptiveSplashAd && view == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                return;
            }
            return;
        }
        dt dtVar = this.mAdProd;
        if (dtVar != null) {
            final cq cqVar = new cq(this.mContext);
            cqVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            if (view != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                view.setId(4097);
                cqVar.addView(view, layoutParams);
            }
            cqVar.a(new cq.a() { // from class: com.baidu.mobads.sdk.api.SplashAd.2
                @Override // com.baidu.mobads.sdk.internal.cq.a
                public void onAttachedToWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.o();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.cq.a
                public void onDetachedFromWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.p();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.cq.a
                public boolean onKeyDown(int i10, KeyEvent keyEvent) {
                    return false;
                }

                @Override // com.baidu.mobads.sdk.internal.cq.a
                public void onLayoutComplete(int i10, int i11) {
                    if (!SplashAd.this.mFetchNotShow) {
                        if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.r();
                        }
                        SplashAd.this.callAdFailed("展现失败，请重新load");
                    } else {
                        if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.f10231r = false;
                            SplashAd.this.mFetchNotShow = false;
                            SplashAd.this.mAdProd.a(cqVar);
                            SplashAd.this.mAdProd.f();
                            return;
                        }
                        SplashAd.this.callAdFailed("展现失败，请检查splashAd参数是否正确");
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.cq.a
                public void onWindowFocusChanged(boolean z10) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.a(z10);
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.cq.a
                public void onWindowVisibilityChanged(int i10) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.b(i10);
                    }
                }
            });
            this.mViewParent.addView(cqVar);
            return;
        }
        if (dtVar != null) {
            dtVar.r();
        }
        callAdFailed("展现失败，请检查splashAd参数是否正确");
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingSuccess(String str) {
        dt dtVar = this.mAdProd;
        if (dtVar != null) {
            dtVar.a(true, str);
        }
    }

    public void destroy() {
        dt dtVar = this.mAdProd;
        if (dtVar != null) {
            dtVar.e();
        }
        this.mListener = null;
    }

    public void finishAndJump(Intent intent) {
        finishAndJump(intent, null);
    }

    public Object getAdDataForKey(String str) {
        dt dtVar = this.mAdProd;
        if (dtVar != null) {
            return dtVar.j(str);
        }
        return null;
    }

    public String getBiddingToken() {
        dt dtVar = this.mAdProd;
        if (dtVar != null) {
            dtVar.r();
            this.mAdProd = null;
        }
        float e2 = ay.e(this.mContext);
        Rect a10 = ay.a(this.mContext);
        int width = a10.width();
        int height = a10.height();
        RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * e2);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * e2);
            }
        }
        int i10 = height;
        int i11 = width;
        if (i11 >= 200.0f * e2 && i10 >= e2 * 150.0f) {
            dt dtVar2 = new dt(this.mContext, this.mAdPlaceId, i11, i10, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
            this.mAdProd = dtVar2;
            dtVar2.d(this.mShakeLogoSize);
            this.mAdProd.a(this.mTwistLogoHeightDp);
            this.mAdProd.c(this.mTwistBgColor);
            this.mAdProd.h(this.mAppSid);
            dt dtVar3 = this.mAdProd;
            dtVar3.f9886p = this.mBidFloor;
            dtVar3.f10231r = true;
            RequestParameters requestParameters2 = this.mParameter;
            if (requestParameters2 != null) {
                dtVar3.a(requestParameters2);
            }
            this.mAdProd.a(this.mListener);
            this.mFetchNotShow = true;
            this.mAdProd.a(this.mDownloadDialogListener);
            return this.mAdProd.m();
        }
        bs.a().c(dg.a().a(bo.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
        SplashAdListener splashAdListener = this.mListener;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdDismissed();
        }
        return null;
    }

    public String getECPMLevel() {
        a h10;
        dt dtVar = this.mAdProd;
        return (dtVar == null || (h10 = dtVar.h()) == null) ? "" : h10.z();
    }

    public final boolean hasSplashCardView() {
        dt dtVar = this.mAdProd;
        if (dtVar != null) {
            return dtVar.g();
        }
        return false;
    }

    public boolean isReady() {
        IAdInterListener iAdInterListener;
        dt dtVar = this.mAdProd;
        if (dtVar == null || (iAdInterListener = dtVar.f9881k) == null) {
            return false;
        }
        return iAdInterListener.isAdReady();
    }

    public final void load() {
        dt dtVar = this.mAdProd;
        if (dtVar != null) {
            dtVar.r();
            this.mAdProd = null;
        }
        float e2 = ay.e(this.mContext);
        Rect a10 = ay.a(this.mContext);
        int width = a10.width();
        int height = a10.height();
        RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * e2);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * e2);
            }
        }
        int i10 = height;
        int i11 = width;
        if (i11 >= 200.0f * e2 && i10 >= e2 * 150.0f) {
            dt dtVar2 = new dt(this.mContext, this.mAdPlaceId, i11, i10, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
            this.mAdProd = dtVar2;
            dtVar2.d(this.mShakeLogoSize);
            this.mAdProd.a(this.mTwistLogoHeightDp);
            this.mAdProd.c(this.mTwistBgColor);
            this.mAdProd.h(this.mAppSid);
            dt dtVar3 = this.mAdProd;
            dtVar3.f9886p = this.mBidFloor;
            dtVar3.f10231r = true;
            RequestParameters requestParameters2 = this.mParameter;
            if (requestParameters2 != null) {
                dtVar3.a(requestParameters2);
            }
            this.mAdProd.a(this.mListener);
            this.mFetchNotShow = true;
            this.mAdProd.a(this.mDownloadDialogListener);
            this.mAdProd.a();
            return;
        }
        bs.a().c(dg.a().a(bo.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
        SplashAdListener splashAdListener = this.mListener;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdDismissed();
    }

    public void loadAndShow(ViewGroup viewGroup) {
        if (viewGroup == null) {
            if (this.mListener != null) {
                sendSplashFailedLog("传入容器不可以为空");
                this.mListener.onAdFailed("传入容器不可以为空");
                return;
            }
            return;
        }
        if (this.mIsAdaptiveSplashAd) {
            if (this.mListener != null) {
                sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                return;
            }
            return;
        }
        addZeroPxSurfaceViewAvoidBlink(viewGroup, this.mContext);
        final cq cqVar = new cq(this.mContext);
        cqVar.a(new cq.a() { // from class: com.baidu.mobads.sdk.api.SplashAd.3
            @Override // com.baidu.mobads.sdk.internal.cq.a
            public void onAttachedToWindow() {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.o();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cq.a
            public void onDetachedFromWindow() {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.p();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cq.a
            public boolean onKeyDown(int i10, KeyEvent keyEvent) {
                return false;
            }

            @Override // com.baidu.mobads.sdk.internal.cq.a
            public void onLayoutComplete(int i10, int i11) {
                if (SplashAd.this.mAdProd != null) {
                    return;
                }
                float e2 = ay.e(SplashAd.this.mContext);
                if (SplashAd.this.mParameter != null && SplashAd.this.mParameter.isCustomSize()) {
                    if (SplashAd.this.mParameter.getWidth() > 0) {
                        i10 = (int) (SplashAd.this.mParameter.getWidth() * e2);
                    }
                    if (SplashAd.this.mParameter.getHeight() > 0) {
                        i11 = (int) (SplashAd.this.mParameter.getHeight() * e2);
                    }
                }
                int i12 = i10;
                int i13 = i11;
                if (i12 >= 200.0f * e2 && i13 >= e2 * 150.0f) {
                    SplashAd.this.mAdProd = new dt(SplashAd.this.mContext, SplashAd.this.mAdPlaceId, i12, i13, SplashAd.this.mTipStyle, SplashAd.this.mTimeout, SplashAd.this.mDisplayDownInfo, SplashAd.this.mPopDialogIfDL.booleanValue(), SplashAd.this.mDisplayClickRegion.booleanValue(), SplashAd.this.mLimitRegionClick.booleanValue());
                    SplashAd.this.mAdProd.a(cqVar);
                    SplashAd.this.mAdProd.d(SplashAd.this.mShakeLogoSize);
                    SplashAd.this.mAdProd.a(SplashAd.this.mTwistLogoHeightDp);
                    SplashAd.this.mAdProd.c(SplashAd.this.mTwistBgColor);
                    SplashAd.this.mAdProd.h(SplashAd.this.mAppSid);
                    SplashAd.this.mAdProd.f9886p = SplashAd.this.mBidFloor;
                    SplashAd.this.mAdProd.a(SplashAd.this.mListener);
                    if (SplashAd.this.mParameter != null) {
                        SplashAd.this.mAdProd.a(SplashAd.this.mParameter);
                    }
                    SplashAd.this.mAdProd.f10231r = false;
                    SplashAd.this.mAdProd.a(SplashAd.this.mDownloadDialogListener);
                    SplashAd.this.mAdProd.a();
                    return;
                }
                bs.a().c(dg.a().a(bo.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
                if (SplashAd.this.mListener == null || !(SplashAd.this.mListener instanceof SplashInteractionListener)) {
                    return;
                }
                ((SplashInteractionListener) SplashAd.this.mListener).onAdDismissed();
            }

            @Override // com.baidu.mobads.sdk.internal.cq.a
            public void onWindowFocusChanged(boolean z10) {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.a(z10);
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cq.a
            public void onWindowVisibilityChanged(int i10) {
                if (SplashAd.this.mAdProd != null) {
                    SplashAd.this.mAdProd.b(i10);
                }
            }
        });
        cqVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(cqVar);
    }

    public void loadBiddingAd(String str) {
        dt dtVar = this.mAdProd;
        if (dtVar != null) {
            dtVar.c(str);
        }
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i10) {
        this.mBidFloor = i10;
    }

    @Deprecated
    public void setBiddingData(String str) {
        dt dtVar = this.mAdProd;
        if (dtVar != null) {
            dtVar.b(str);
        }
    }

    public void setDownloadDialogListener(SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.mDownloadDialogListener = splashAdDownloadDialogListener;
        dt dtVar = this.mAdProd;
        if (dtVar != null) {
            dtVar.a(splashAdDownloadDialogListener);
        }
    }

    public void setListener(SplashAdListener splashAdListener) {
        this.mListener = splashAdListener;
        dt dtVar = this.mAdProd;
        if (dtVar != null) {
            dtVar.a(splashAdListener);
        }
    }

    public final void show(ViewGroup viewGroup) {
        showWithBottomView(viewGroup, null);
    }

    public final boolean showSplashCardView(Activity activity, SplashCardAdListener splashCardAdListener) {
        dt dtVar = this.mAdProd;
        if (dtVar == null) {
            return false;
        }
        dtVar.a(splashCardAdListener);
        return this.mAdProd.b(activity);
    }

    public SplashAd(Context context, String str, RequestParameters requestParameters, SplashAdListener splashAdListener) {
        this.mTipStyle = 4;
        this.mFetchAd = true;
        this.mFetchNotShow = false;
        this.mDisplayDownInfo = true;
        this.mPopDialogIfDL = Boolean.FALSE;
        Boolean bool = Boolean.TRUE;
        this.mLimitRegionClick = bool;
        this.mDisplayClickRegion = bool;
        this.mTimeout = 4200;
        this.mShakeLogoSize = 60;
        this.mTwistLogoHeightDp = 67;
        this.mTwistBgColor = -16777216;
        this.mIsAdaptiveSplashAd = false;
        this.mBidFloor = -1;
        this.mListener = new SplashInteractionListener() { // from class: com.baidu.mobads.sdk.api.SplashAd.1
            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdClick() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdDismissed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str2) {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdPresent() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onLpClosed() {
            }
        };
        this.mContext = context;
        this.mAdPlaceId = str;
        if (splashAdListener != null) {
            this.mListener = splashAdListener;
        }
        if (TextUtils.isEmpty(str)) {
            sendSplashFailedLog("请您输入正确的广告位ID");
            this.mListener.onAdFailed("请您输入正确的广告位ID");
            return;
        }
        this.mParameter = requestParameters;
        if (requestParameters == null || requestParameters.getExtras() == null) {
            return;
        }
        String str2 = this.mParameter.getExtras().get(KEY_FETCHAD);
        if (!TextUtils.isEmpty(str2)) {
            this.mFetchAd = Boolean.parseBoolean(str2);
        }
        String str3 = this.mParameter.getExtras().get(KEY_DISPLAY_DOWNLOADINFO);
        if (!TextUtils.isEmpty(str3)) {
            this.mDisplayDownInfo = Boolean.parseBoolean(str3);
        }
        String str4 = this.mParameter.getExtras().get(KEY_POPDIALOG_DOWNLOAD);
        if (!TextUtils.isEmpty(str4)) {
            this.mPopDialogIfDL = Boolean.valueOf(str4);
        }
        String str5 = this.mParameter.getExtras().get(KEY_SHAKE_LOGO_SIZE);
        if (!TextUtils.isEmpty(str5)) {
            this.mShakeLogoSize = Integer.parseInt(str5);
        }
        String str6 = this.mParameter.getExtras().get(KEY_TWIST_LOGO_HEIGHT_DP);
        if (!TextUtils.isEmpty(str6)) {
            this.mTwistLogoHeightDp = Integer.parseInt(str6);
        }
        String str7 = this.mParameter.getExtras().get(KEY_TWIST_BG_COLOR);
        if (!TextUtils.isEmpty(str7)) {
            this.mTwistBgColor = Integer.parseInt(str7);
        }
        String str8 = this.mParameter.getExtras().get("timeout");
        if (!TextUtils.isEmpty(str8)) {
            this.mTimeout = Integer.parseInt(str8);
        }
        String str9 = this.mParameter.getExtras().get(KEY_USE_ADAPTIVE_AD);
        if (TextUtils.isEmpty(str9)) {
            return;
        }
        this.mIsAdaptiveSplashAd = Boolean.parseBoolean(str9);
    }

    public static void registerEnterTransition(Activity activity, SplashFocusParams splashFocusParams, SplashFocusAdListener splashFocusAdListener) {
        dt.a(activity, splashFocusParams != null ? splashFocusParams.getFocusParams() : null, splashFocusAdListener);
    }

    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        dt dtVar = this.mAdProd;
        if (dtVar != null) {
            dtVar.a(false, str, hashMap);
        }
    }

    public void finishAndJump(Intent intent, OnFinishListener onFinishListener) {
        dt dtVar = this.mAdProd;
        if (dtVar != null) {
            dtVar.a(intent, onFinishListener);
        }
    }

    public static void registerEnterTransition(Activity activity, int i10, int i11, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i10);
            jSONObject.put("bottom_margin", i11);
        } catch (JSONException e2) {
            bs.a().a(e2);
        }
        dt.a(activity, jSONObject, splashFocusAdListener);
    }

    @Deprecated
    public static void registerEnterTransition(Activity activity, int i10, int i11, int i12, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i10);
            jSONObject.put("bottom_margin", i11);
            jSONObject.put("anim_offset_y", i12);
        } catch (JSONException e2) {
            bs.a().a(e2);
        }
        dt.a(activity, jSONObject, splashFocusAdListener);
    }
}
