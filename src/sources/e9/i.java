package e9;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.InterstitialAd;
import com.huawei.appgallery.agd.agdpro.api.IInterstitialAd;
import com.huawei.appgallery.agd.agdpro.api.InterstitialInteractionListener;
import com.huawei.appgallery.agd.agdpro.impl.page.InterstitialAdActivity;
import com.huawei.appgallery.agd.core.api.AdSlot;
import com.huawei.appgallery.agd.core.impl.AgdAdManager;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.impl.report.OperationBi;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.appgallery.agd.pageframe.api.CardEventInfo;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.huawei.flexiblelayout.FLContext;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class i extends b implements IInterstitialAd {

    /* renamed from: d, reason: collision with root package name */
    public AdSlot f48961d;

    /* renamed from: e, reason: collision with root package name */
    public String f48962e;

    /* renamed from: f, reason: collision with root package name */
    public JSONArray f48963f;

    /* renamed from: g, reason: collision with root package name */
    public InterstitialInteractionListener f48964g;

    /* renamed from: h, reason: collision with root package name */
    public long f48965h = 0;

    /* renamed from: i, reason: collision with root package name */
    public boolean f48966i = false;

    public i(@NonNull AdSlot adSlot, @NonNull JSONArray jSONArray) {
        this.f48963f = jSONArray;
        this.f48961d = adSlot;
        this.f48962e = t.b(adSlot.getSlotId());
    }

    @Override // e9.b
    public long c() {
        return this.f48965h;
    }

    @Override // com.huawei.appgallery.agd.agdpro.api.IInterstitialAd
    public void destroy() {
        e.f48945d.i(InterstitialAd.TAG, "interstiatial ad destroy");
        if (this.f48966i) {
            return;
        }
        AgdAdManager.removeAd(this.f48962e);
        this.f48964g = null;
    }

    public void e(@NonNull CardEventInfo cardEventInfo) {
        Activity activity;
        e eVar = e.f48945d;
        StringBuilder b4 = a.b("dispatchCardEvent type: ");
        b4.append(cardEventInfo.type);
        b4.append(", info: ");
        b4.append((Object) cardEventInfo);
        eVar.i(InterstitialAd.TAG, b4.toString());
        String str = cardEventInfo.type;
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1273977221:
                if (str.equals("openFastApp")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1263202134:
                if (str.equals("openWeb")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1177422000:
                if (str.equals("openDeeplink")) {
                    c4 = 2;
                    break;
                }
                break;
            case -934426579:
                if (str.equals("resume")) {
                    c4 = 3;
                    break;
                }
                break;
            case 3357525:
                if (str.equals(CardEventType.CLICK_ACTION_MORE)) {
                    c4 = 4;
                    break;
                }
                break;
            case 94756344:
                if (str.equals("close")) {
                    c4 = 5;
                    break;
                }
                break;
            case 106440182:
                if (str.equals("pause")) {
                    c4 = 6;
                    break;
                }
                break;
            case 187958017:
                if (str.equals("openNative")) {
                    c4 = 7;
                    break;
                }
                break;
            case 884870824:
                if (str.equals("openAppDetail")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 1957569947:
                if (str.equals("install")) {
                    c4 = '\t';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case '\b':
            case '\t':
                InterstitialInteractionListener interstitialInteractionListener = this.f48964g;
                if (interstitialInteractionListener != null) {
                    interstitialInteractionListener.onAdClicked();
                    return;
                }
                return;
            case 5:
                FLContext fLContext = cardEventInfo.flContext;
                if (fLContext != null && fLContext.getActivity() != null) {
                    activity = cardEventInfo.flContext.getActivity();
                } else {
                    eVar.e(InterstitialAd.TAG, "handleClickOpenAppDetail getActivity fail");
                    activity = null;
                }
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void f(boolean z10, String str) {
        e.f48945d.i(InterstitialAd.TAG, "onParseResult success: " + z10 + ", reason " + str);
        InterstitialInteractionListener interstitialInteractionListener = this.f48964g;
        if (interstitialInteractionListener != null) {
            if (z10) {
                interstitialInteractionListener.onAdShow();
                MaintBi.reportAdShow(0, System.currentTimeMillis() - this.f48965h, g());
            } else {
                interstitialInteractionListener.onAdShowError(10001);
                MaintBi.reportAdShowError(10001, "", "FLayout error", g());
                OperationBi.reportAdCallBackOperate(OperationBi.ACTION_AD_SHOW_FAILURE, g());
            }
        }
    }

    public String g() {
        AdSlot adSlot = this.f48961d;
        return adSlot == null ? "" : adSlot.getSlotId();
    }

    @Override // com.huawei.appgallery.agd.core.impl.IAgdAd
    public AdSlot getAdSlot() {
        return this.f48961d;
    }

    @Override // com.huawei.appgallery.agd.core.impl.IAgdAd
    public String getUniqueId() {
        return this.f48962e;
    }

    public final int h() {
        int parseInt;
        try {
            JSONObject jSONObject = this.f48963f.getJSONObject(0).getJSONArray(CardConstants.KEY_DATA_LIST).getJSONObject(0);
            if (jSONObject.has("list")) {
                parseInt = Integer.parseInt(jSONObject.getJSONArray("list").getJSONObject(0).getJSONObject(CardConstants.KEY_EXT_PARAM).getString(CardConstants.KEY_SCREEN_TYPE));
            } else {
                parseInt = Integer.parseInt(jSONObject.getJSONObject(CardConstants.KEY_EXT_PARAM).getString(CardConstants.KEY_SCREEN_TYPE));
            }
            return parseInt;
        } catch (Exception e2) {
            e eVar = e.f48945d;
            StringBuilder b4 = a.b("parse screenType error: ");
            b4.append(e2.getMessage());
            eVar.e(InterstitialAd.TAG, b4.toString());
            return 2;
        }
    }

    public final void i() {
        InterstitialInteractionListener interstitialInteractionListener = this.f48964g;
        if (interstitialInteractionListener != null) {
            interstitialInteractionListener.onAdShowError(2010);
            OperationBi.reportAdCallBackOperate(OperationBi.ACTION_AD_SHOW_FAILURE, this.f48961d.getSlotId());
        }
    }

    @Override // com.huawei.appgallery.agd.agdpro.api.IInterstitialAd
    public void setInteractionListener(InterstitialInteractionListener interstitialInteractionListener) {
        this.f48964g = interstitialInteractionListener;
        e.f48945d.i(InterstitialAd.TAG, "setInteractionListener success");
    }

    @Override // com.huawei.appgallery.agd.agdpro.api.IInterstitialAd
    @MainThread
    public void show(Activity activity) {
        e eVar = e.f48945d;
        a.d(a.b("show mUniqueId="), this.f48962e, eVar, InterstitialAd.TAG);
        if (activity == null) {
            eVar.e(InterstitialAd.TAG, "show activity null");
            i();
            return;
        }
        if (AgdAdManager.getAd(this.f48962e) == null) {
            eVar.e(InterstitialAd.TAG, "InterstitialAd is destroyed");
            i();
            return;
        }
        if (this.f48966i) {
            eVar.e(InterstitialAd.TAG, "show activity: show success");
            return;
        }
        try {
            this.f48965h = System.currentTimeMillis();
            Intent intent = new Intent(activity, (Class<?>) InterstitialAdActivity.class);
            int h10 = h();
            intent.putExtra("uniqueId", this.f48962e);
            eVar.d(InterstitialAd.TAG, "show mUniqueId=" + this.f48962e);
            intent.putExtra(CardConstants.KEY_SCREEN_TYPE, h10);
            intent.putExtra(CardConstants.PAGE_ORIENTATION, (this.f48961d.getOrientation() & activity.getResources().getConfiguration().orientation) == 0 ? -1 : this.f48961d.getOrientation());
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            intent.putExtra(CardConstants.PAGE_ROTATION_DEGREE, rotation == 1 ? 0 : rotation == 2 ? 9 : rotation == 3 ? 8 : 1);
            activity.startActivity(intent);
            this.f48966i = true;
            OperationBi.reportAdCallBackOperate(OperationBi.ACTION_AD_SHOW_SUCCESS, this.f48961d.getSlotId());
        } catch (Exception e2) {
            e eVar2 = e.f48945d;
            StringBuilder b4 = a.b("show activity fail ");
            b4.append(e2.getMessage());
            eVar2.e(InterstitialAd.TAG, b4.toString());
            OperationBi.reportAdCallBackOperate(OperationBi.ACTION_AD_SHOW_FAILURE, this.f48961d.getSlotId());
        }
    }
}
