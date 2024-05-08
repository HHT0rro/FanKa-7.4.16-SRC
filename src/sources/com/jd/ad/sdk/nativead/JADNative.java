package com.jd.ad.sdk.nativead;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.jd.ad.sdk.bl.adload.IJADBase;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.model.IJADExtra;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.jad_n_an.jad_n_dq;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JADNative implements IJADBase {
    private WeakReference<Activity> mActivityRef;
    private jad_n_dq mAdViewController;
    private String mInstanceId;
    private JADNativeLoadListener mLoadListener;
    private JADSlot mSlot;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class jad_n_an implements JADAdLoadListener {
        public jad_n_an() {
        }

        @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
        public void onLoadFailure(int i10, String str) {
            JADNative jADNative = JADNative.this;
            jADNative.callbackAdLoadFailedOnUiThread(jADNative.mLoadListener, i10, str);
        }

        @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
        public void onLoadSuccess() {
            JADNative jADNative = JADNative.this;
            jADNative.callbackAdLoadOnUiThread(jADNative.mLoadListener);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class jad_n_bo implements Runnable {
        public final /* synthetic */ JADNativeLoadListener jad_n_an;

        public jad_n_bo(JADNativeLoadListener jADNativeLoadListener) {
            this.jad_n_an = jADNativeLoadListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADNative.this.onAdLoadCallback(this.jad_n_an);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class jad_n_cp implements Runnable {
        public final /* synthetic */ JADNativeLoadListener jad_n_an;
        public final /* synthetic */ int jad_n_bo;
        public final /* synthetic */ String jad_n_cp;

        public jad_n_cp(JADNativeLoadListener jADNativeLoadListener, int i10, String str) {
            this.jad_n_an = jADNativeLoadListener;
            this.jad_n_bo = i10;
            this.jad_n_cp = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADNative.this.onAdLoadFailedCallback(this.jad_n_an, this.jad_n_bo, this.jad_n_cp);
        }
    }

    public JADNative(@NonNull JADSlot jADSlot) {
        this.mInstanceId = "";
        this.mInstanceId = UUIDUtils.uuid();
        JADMediator.getInstance().getAdService().registerAd(this.mInstanceId);
        JADMediator.getInstance().getInitService().createDefaultAdInstance(jADSlot);
        this.mSlot = jADSlot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdLoadFailedOnUiThread(JADNativeLoadListener jADNativeLoadListener, int i10, String str) {
        HandlerUtils.runOnUiThread(new jad_n_cp(jADNativeLoadListener, i10, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdLoadOnUiThread(JADNativeLoadListener jADNativeLoadListener) {
        HandlerUtils.runOnUiThread(new jad_n_bo(jADNativeLoadListener));
    }

    private int getRenderMode() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadCallback(JADNativeLoadListener jADNativeLoadListener) {
        if (jADNativeLoadListener != null) {
            jADNativeLoadListener.onLoadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadFailedCallback(JADNativeLoadListener jADNativeLoadListener, int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        if (jADNativeLoadListener != null) {
            jADNativeLoadListener.onLoadFailure(i10, str);
        }
    }

    public void destroy() {
        jad_n_dq jad_n_dqVar = this.mAdViewController;
        if (jad_n_dqVar != null) {
            jad_n_dqVar.jad_n_an();
            this.mAdViewController = null;
        }
        JADMediator.getInstance().getAdService().removeData(this.mInstanceId);
        JADMediator.getInstance().getAdService().unregisterAd(this.mInstanceId);
    }

    @Nullable
    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Nullable
    public List<JADMaterialData> getDataList() {
        return JADMediator.getInstance().getAdService().getJADMaterialDataList(this.mInstanceId);
    }

    public int getDisplayScene(int i10) {
        if (i10 == 1) {
            return 4;
        }
        if (i10 == 2) {
            return 64;
        }
        if (i10 != 4) {
            return i10 != 5 ? 0 : 1;
        }
        return 2;
    }

    public String getErin(@NonNull String str, int i10, @NonNull String str2) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, ExposeManager.UtArgsNames.pid, str);
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(i10));
        JsonUtils.put(jSONObject, "error", str2);
        return jSONObject.toString();
    }

    public String getInstanceId() {
        return this.mInstanceId;
    }

    @NonNull
    public IJADExtra getJADExtra() {
        return JADMediator.getInstance().getAdService().getJADExtra(this.mInstanceId);
    }

    public JADSlot getSlot() {
        return this.mSlot;
    }

    public void loadAd(@NonNull JADNativeLoadListener jADNativeLoadListener) {
        this.mLoadListener = jADNativeLoadListener;
        String uuid = UUIDUtils.uuid();
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            JADError jADError = JADError.GW_REQUEST_SLOT_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(uuid, jADError.getCode(), getErin("", 0, jADError.getMessage(new String[0])));
            callbackAdLoadFailedOnUiThread(this.mLoadListener, jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        jADSlot.setRequestId(uuid);
        this.mSlot.setLoadTime(System.currentTimeMillis());
        if (this.mSlot.getAdType() == 0) {
            JADEventService eventService2 = JADMediator.getInstance().getEventService();
            JADError jADError2 = JADError.GW_REQUEST_AD_TYPE_IS_NOT_SET_ERROR;
            eventService2.reportRequestErrorEvent(uuid, jADError2.getCode(), getErin(this.mSlot.getSlotID(), 0, jADError2.getMessage(new String[0])));
            callbackAdLoadFailedOnUiThread(this.mLoadListener, jADError2.getCode(), jADError2.getMessage(new String[0]));
            return;
        }
        JADSlot jADSlot2 = this.mSlot;
        jADSlot2.setDisplayScene(getDisplayScene(jADSlot2.getAdType()));
        this.mSlot.setFromNativeAd(true);
        JADMediator.getInstance().getAdService().loadAd(this.mInstanceId, this.mSlot, new jad_n_an());
    }

    public void registerNativeView(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @NonNull JADNativeInteractionListener jADNativeInteractionListener) {
        this.mActivityRef = new WeakReference<>(activity);
        this.mAdViewController = new jad_n_dq(this, viewGroup, list, list2, jADNativeInteractionListener);
    }
}
