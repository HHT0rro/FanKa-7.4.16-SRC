package com.wangmai.appsdkdex.ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import com.wangmai.appsdkdex.Iparameter.IBannerParameter;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.common.IAdLoader;
import com.wangmai.common.Iinterface.IBannerInterface;
import com.wangmai.common.Ilistener.XAdBannerListener;
import com.wangmai.common.bean.BannerBean;
import com.wangmai.common.utils.DebugLog;
import java.lang.ref.WeakReference;
import zc.a;
import zc.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMAdBanner implements IBannerInterface, IBannerParameter {
    public final String TAG = b.a("XNBeCboofs");
    public WeakReference<Activity> activityWeakReference;
    public IBannerInterface banner;
    public IAdLoader iAdLoader;
    public String mAdslotId;
    public XAdBannerListener wMBannerListener;

    public WMAdBanner(Activity activity, String str, XAdBannerListener xAdBannerListener) {
        if (xAdBannerListener == null) {
            DebugLog.release_e(b.a("XNBeCboofs"), b.a("CboofsMjtufofs!jt!ovmm"));
            return;
        }
        try {
            this.activityWeakReference = new WeakReference<>(activity);
            this.mAdslotId = str;
            this.wMBannerListener = xAdBannerListener;
            IAdLoader a10 = a.a(activity.getApplicationContext());
            this.iAdLoader = a10;
            if (a10 != null) {
                a10.fetchBannerAd(this);
            } else {
                DebugLog.release_e(b.a("XNBeCboofs"), b.a("Cboofs扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
                xAdBannerListener.onNoAd(b.a("Cboofs��撋扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
            }
        } catch (Throwable th) {
            DebugLog.release_e(b.a("XNBeCboofs"), b.a("Cboofs扞樌捗楲鵦�") + th.toString());
            xAdBannerListener.onNoAd(b.a("Cboofs��撋扞樌捗楲鵦;") + th.getMessage());
        }
    }

    @Override // com.wangmai.common.Iinterface.IBannerInterface
    public void destroy() {
        try {
            IBannerInterface iBannerInterface = this.banner;
            if (iBannerInterface != null) {
                iBannerInterface.destroy();
                this.banner = null;
            }
            WeakReference<Activity> weakReference = this.activityWeakReference;
            if (weakReference != null) {
                weakReference.clear();
                this.activityWeakReference = null;
            }
        } catch (Throwable th) {
            DebugLog.W(this.TAG, b.a("Cboofs!eftuspz!fssps�") + th.getMessage());
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseParameter
    public Activity getAct() {
        WeakReference<Activity> weakReference = this.activityWeakReference;
        return ((weakReference == null || weakReference.get() == null) ? WMDexAdHelper.getTopActivity() : this.activityWeakReference).get();
    }

    @Override // com.wangmai.common.Ibase.IBaseParameter
    public String getAdSlotId() {
        return this.mAdslotId;
    }

    @Override // com.wangmai.appsdkdex.Iparameter.IBannerParameter
    public XAdBannerListener getBannerListener() {
        return this.wMBannerListener;
    }

    @Override // com.wangmai.appsdkdex.Iparameter.IBannerParameter
    public ViewGroup getBannerViewGroup() {
        return null;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public String getCurrentVCode() {
        try {
            IBannerInterface iBannerInterface = this.banner;
            if (iBannerInterface != null) {
                return iBannerInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            DebugLog.W(this.TAG, b.a("Cboofs!hfuDvssfouWDpef;") + th.toString());
            return null;
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public int getECPM() {
        IBannerInterface iBannerInterface = this.banner;
        if (iBannerInterface != null) {
            return iBannerInterface.getECPM();
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.wangmai.common.Ibase.IBaseParameter
    public BannerBean getExtraBean() {
        return null;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            IBannerInterface iBannerInterface = this.banner;
            if (iBannerInterface != null) {
                return iBannerInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            DebugLog.W(this.TAG, b.a("Cboofs!hfuSfrvftuJe;") + th.toString());
            return null;
        }
    }

    @Override // com.wangmai.common.Iinterface.IBannerInterface
    public void reset() {
        IBannerInterface iBannerInterface = this.banner;
        if (iBannerInterface != null) {
            iBannerInterface.reset();
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        IBannerInterface iBannerInterface = this.banner;
        if (iBannerInterface != null) {
            iBannerInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        IBannerInterface iBannerInterface = this.banner;
        if (iBannerInterface != null) {
            iBannerInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Iinterface.IBannerInterface
    public void stop() {
        IBannerInterface iBannerInterface = this.banner;
        if (iBannerInterface != null) {
            iBannerInterface.stop();
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void setImplement(IBannerInterface iBannerInterface) {
        this.banner = iBannerInterface;
    }
}
