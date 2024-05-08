package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomNativeDislikeDialog;
import com.bytedance.sdk.openadsdk.mediation.m.m.oa;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationCustomNativeAd implements Bridge, IMediationCustomNativeAd {

    /* renamed from: c, reason: collision with root package name */
    private int f11301c;
    private MediationCustomNativeDislikeDialog dh;
    private Map<String, Object> dk;

    /* renamed from: e, reason: collision with root package name */
    private int f11302e;
    private String ej;

    /* renamed from: f, reason: collision with root package name */
    private int f11303f;

    /* renamed from: hc, reason: collision with root package name */
    private int f11304hc;

    /* renamed from: k, reason: collision with root package name */
    private boolean f11305k;

    /* renamed from: l, reason: collision with root package name */
    private String f11306l;

    /* renamed from: m, reason: collision with root package name */
    private double f11307m;
    private Bridge mj;

    /* renamed from: n, reason: collision with root package name */
    private String f11308n;
    private String np;

    /* renamed from: oa, reason: collision with root package name */
    private String f11309oa;

    /* renamed from: q, reason: collision with root package name */
    private String f11310q;

    /* renamed from: r, reason: collision with root package name */
    private List<String> f11311r;
    private double sy;

    /* renamed from: t, reason: collision with root package name */
    private int f11312t;
    private int ve;

    /* renamed from: w, reason: collision with root package name */
    private String f11313w;

    /* renamed from: x, reason: collision with root package name */
    private MediationNativeAdAppInfo f11314x;

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        MediationAdDislike dislikeDialog;
        if (i10 == 8127) {
            this.mj = (Bridge) valueSet.objectValue(8034, Bridge.class);
        } else if (i10 == 6083) {
            render();
        } else {
            if (i10 == 6081) {
                return (T) getExpressView();
            }
            if (i10 == 8159) {
                registerView((Activity) valueSet.objectValue(20033, Activity.class), (ViewGroup) valueSet.objectValue(8067, ViewGroup.class), (List) valueSet.objectValue(8068, List.class), (List) valueSet.objectValue(8069, List.class), (List) valueSet.objectValue(8070, List.class), BridgeUtil.buildViewBinder((Bridge) valueSet.objectValue(8071, Bridge.class)));
            } else {
                if (i10 == 8135) {
                    return (T) Boolean.valueOf(hasDislike());
                }
                if (i10 == 8149) {
                    onPause();
                } else if (i10 == 8148) {
                    onResume();
                } else if (i10 == 8109) {
                    onDestroy();
                } else {
                    if (i10 == 8121) {
                        return (T) isReadyCondition();
                    }
                    if (i10 == 8194) {
                        String stringValue = valueSet.stringValue(8036);
                        Map<String, Object> map = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog = this.dh;
                        if (mediationCustomNativeDislikeDialog != null) {
                            mediationCustomNativeDislikeDialog.dislikeClick(stringValue, map);
                        }
                    } else if (i10 == 6072) {
                        Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                        Map<String, Object> map2 = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog2 = this.dh;
                        if (mediationCustomNativeDislikeDialog2 != null && (dislikeDialog = mediationCustomNativeDislikeDialog2.getDislikeDialog(activity, map2)) != null) {
                            return (T) new oa(dislikeDialog);
                        }
                    } else {
                        if (i10 == 8320) {
                            return (T) new MediationCustomizeVideoImpl(getNativeCustomVideoReporter());
                        }
                        if (i10 == 8228) {
                            return (T) getVideoUrl();
                        }
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdClick() {
        Bridge bridge = this.mj;
        if (bridge != null) {
            bridge.call(8130, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdShow() {
        Bridge bridge = this.mj;
        if (bridge != null) {
            bridge.call(8113, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeCancel() {
        Bridge bridge = this.mj;
        if (bridge != null) {
            bridge.call(8184, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeSelected(int i10, String str) {
        if (this.mj != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8038, i10);
            create.add(8039, str);
            this.mj.call(8132, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeShow() {
        Bridge bridge = this.mj;
        if (bridge != null) {
            bridge.call(8185, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadActive(long j10, long j11) {
        if (this.mj != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j10);
            create.add(8063, j11);
            this.mj.call(8187, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFailed(long j10, long j11, String str, String str2) {
        if (this.mj != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j10);
            create.add(8063, j11);
            create.add(8066, str);
            create.add(8056, str2);
            this.mj.call(8157, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFinished(long j10, String str, String str2) {
        if (this.mj != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j10);
            create.add(8066, str);
            create.add(8056, str2);
            this.mj.call(8155, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadPaused(long j10, long j11, String str, String str2) {
        if (this.mj != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j10);
            create.add(8063, j11);
            create.add(8066, str);
            create.add(8056, str2);
            this.mj.call(8158, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnIdle() {
        Bridge bridge = this.mj;
        if (bridge != null) {
            bridge.call(8152, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnInstalled(String str, String str2) {
        if (this.mj != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8066, str);
            create.add(8056, str2);
            this.mj.call(8156, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderFail(View view, int i10, String str) {
        if (this.mj != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8042, view);
            create.add(8014, i10);
            create.add(8015, str);
            this.mj.call(8134, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderSuccess(float f10, float f11) {
        if (this.mj != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8040, f10);
            create.add(8041, f11);
            this.mj.call(8133, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoCompleted() {
        Bridge bridge = this.mj;
        if (bridge != null) {
            bridge.call(8118, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoError(int i10, String str) {
        if (this.mj != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8014, i10);
            create.add(8015, str);
            this.mj.call(8117, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoPause() {
        Bridge bridge = this.mj;
        if (bridge != null) {
            bridge.call(8146, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoProgressUpdate(long j10, long j11) {
        if (this.mj != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8072, j10);
            create.add(8073, j11);
            this.mj.call(8154, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoResume() {
        Bridge bridge = this.mj;
        if (bridge != null) {
            bridge.call(8150, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoStart() {
        Bridge bridge = this.mj;
        if (bridge != null) {
            bridge.call(8145, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public int getBiddingType() {
        Bridge bridge = this.mj;
        if (bridge != null) {
            return ((Integer) bridge.call(8226, null, Integer.class)).intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public View getExpressView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public TTFeedAd.CustomizeVideo getNativeCustomVideoReporter() {
        return null;
    }

    public ValueSet getValueSet() {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8016, this.f11307m);
        create.add(8006, this.dk);
        create.add(8045, this.ej);
        create.add(8046, this.f11306l);
        create.add(8048, this.np);
        create.add(8050, this.f11308n);
        create.add(8051, this.f11302e);
        create.add(8052, this.f11304hc);
        create.add(8061, this.f11313w);
        create.add(8054, this.f11309oa);
        create.add(8420, this.f11301c);
        create.add(8421, this.ve);
        create.add(8082, this.sy);
        create.add(8053, this.f11311r);
        create.add(8049, this.f11310q);
        create.add(8033, this.f11305k);
        create.add(8060, this.f11312t);
        create.add(8059, this.f11303f);
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.f11314x;
        if (mediationNativeAdAppInfo != null) {
            create.add(8315, new MediationNativeAppInfoImpl(mediationNativeAdAppInfo));
        }
        return create.build();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public String getVideoUrl() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean hasDislike() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isClientBidding() {
        Bridge bridge = this.mj;
        if (bridge != null) {
            return ((Boolean) bridge.call(8110, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isServerBidding() {
        Bridge bridge = this.mj;
        if (bridge != null) {
            return ((Boolean) bridge.call(8136, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isUseCustomVideo() {
        Bridge bridge = this.mj;
        if (bridge != null) {
            return ((Boolean) bridge.call(8160, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onDestroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onPause() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onResume() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void render() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setActionText(String str) {
        this.f11313w = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setAdImageMode(int i10) {
        this.f11312t = i10;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setBiddingPrice(double d10) {
        this.f11307m = d10;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDescription(String str) {
        this.f11306l = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDislikeDialogCallBack(MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog) {
        Bridge bridge = this.mj;
        if (bridge != null) {
            this.dh = mediationCustomNativeDislikeDialog;
            bridge.call(6085, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setExpressAd(boolean z10) {
        this.f11305k = z10;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setIconUrl(String str) {
        this.np = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageHeight(int i10) {
        this.f11302e = i10;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageList(List<String> list) {
        this.f11311r = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageUrl(String str) {
        this.f11308n = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageWidth(int i10) {
        this.f11304hc = i10;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setInteractionType(int i10) {
        this.f11303f = i10;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setMediaExtraInfo(Map<String, Object> map) {
        this.dk = map;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setNativeAdAppInfo(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.f11314x = mediationNativeAdAppInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setPackageName(String str) {
        this.f11309oa = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setSource(String str) {
        this.f11310q = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setStarRating(double d10) {
        this.sy = d10;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setTitle(String str) {
        this.ej = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoHeight(int i10) {
        this.ve = i10;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoWidth(int i10) {
        this.f11301c = i10;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return getValueSet();
    }
}
