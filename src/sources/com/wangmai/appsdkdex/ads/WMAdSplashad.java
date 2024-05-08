package com.wangmai.appsdkdex.ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.wangmai.appsdkdex.Iparameter.ISplashParameter;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.common.IAdLoader;
import com.wangmai.common.Iinterface.ISplashInterface;
import com.wangmai.common.Ilistener.XAdSplashListener;
import com.wangmai.common.bean.SplashBean;
import com.wangmai.common.utils.DebugLog;
import java.lang.ref.WeakReference;
import zc.a;
import zc.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMAdSplashad implements ISplashInterface, ISplashParameter {
    public static final String TAG = b.a("XNBeTqmbtibe");
    public WeakReference<Activity> activityWeakReference;
    public XAdSplashListener adListener;
    public IAdLoader iAdLoader;
    public String mAdslotId;
    public SplashBean mapSplashDrop;
    public ISplashInterface splashInterface;

    public WMAdSplashad(Activity activity, String str, XAdSplashListener xAdSplashListener) {
        this(activity, str, null, xAdSplashListener);
    }

    @Override // com.wangmai.common.Iinterface.ISplashInterface
    public void destroy() {
        try {
            ISplashInterface iSplashInterface = this.splashInterface;
            if (iSplashInterface != null) {
                iSplashInterface.destroy();
                this.splashInterface = null;
            }
            WeakReference<Activity> weakReference = this.activityWeakReference;
            if (weakReference != null) {
                weakReference.clear();
                this.activityWeakReference = null;
            }
            this.adListener = null;
            this.mapSplashDrop = null;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("Tqmbti!eftuspz!fssps;") + th.getMessage());
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

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public String getCurrentVCode() {
        try {
            ISplashInterface iSplashInterface = this.splashInterface;
            if (iSplashInterface != null) {
                return iSplashInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("Tqmbti!hfuDvssfouWDpef;") + th.getMessage());
            return null;
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public int getECPM() {
        ISplashInterface iSplashInterface = this.splashInterface;
        if (iSplashInterface != null) {
            return iSplashInterface.getECPM();
        }
        return 0;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            ISplashInterface iSplashInterface = this.splashInterface;
            if (iSplashInterface != null) {
                return iSplashInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("Tqmbti!hfuSfrvftuJe;") + th.getMessage());
            return null;
        }
    }

    @Override // com.wangmai.appsdkdex.Iparameter.ISplashParameter
    public XAdSplashListener getSplashListener() {
        return this.adListener;
    }

    @Override // com.wangmai.appsdkdex.Iparameter.ISplashParameter
    public ViewGroup getSplashViewGroup() {
        return null;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        ISplashInterface iSplashInterface = this.splashInterface;
        if (iSplashInterface != null) {
            iSplashInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        ISplashInterface iSplashInterface = this.splashInterface;
        if (iSplashInterface != null) {
            iSplashInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Iinterface.ISplashInterface
    public void show(ViewGroup viewGroup) {
        try {
            ISplashInterface iSplashInterface = this.splashInterface;
            if (iSplashInterface != null) {
                iSplashInterface.show(viewGroup);
            } else {
                DebugLog.release_e(TAG, b.a("Tqmbti!tipx!gbjmfe)tqmbtiJoufsgbdf!jt!ovmm*"));
            }
        } catch (Throwable th) {
            DebugLog.release_e(TAG, b.a("Tqmbti!tipx!gbjmfe)") + th.toString() + b.a(StringUtils.NO_PRINT_CODE));
        }
    }

    public WMAdSplashad(Activity activity, String str, SplashBean splashBean, XAdSplashListener xAdSplashListener) {
        if (xAdSplashListener == null) {
            DebugLog.release_e(b.a("XNBeTqmbtibe"), b.a("TqmbtiMjtufofs!jt!ovmm"));
            return;
        }
        try {
            this.activityWeakReference = new WeakReference<>(activity);
            this.mAdslotId = str;
            this.adListener = xAdSplashListener;
            if (splashBean != null) {
                this.mapSplashDrop = splashBean;
            }
            IAdLoader a10 = a.a(activity.getApplicationContext());
            this.iAdLoader = a10;
            if (a10 != null) {
                a10.fetchSplashAd(this);
            } else {
                xAdSplashListener.onNoAd(b.a("��撋拡龾楲鵦"));
            }
        } catch (Throwable th) {
            DebugLog.release_e(b.a("XNBeTqmbtibe"), b.a("Tqmbti!joju!gbjmfe)") + th.toString() + b.a(StringUtils.NO_PRINT_CODE));
            xAdSplashListener.onNoAd(b.a("��撋拡龾楲鵦"));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.wangmai.common.Ibase.IBaseParameter
    public SplashBean getExtraBean() {
        return this.mapSplashDrop;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void setImplement(ISplashInterface iSplashInterface) {
        this.splashInterface = iSplashInterface;
    }
}
