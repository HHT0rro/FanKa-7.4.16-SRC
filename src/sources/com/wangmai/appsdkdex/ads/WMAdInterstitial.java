package com.wangmai.appsdkdex.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.wangmai.appsdkdex.Iparameter.InterstitialParameter;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.common.IAdLoader;
import com.wangmai.common.Iinterface.InterstitialInterface;
import com.wangmai.common.Ilistener.XAdInterstitialListener;
import com.wangmai.common.bean.InterstialBean;
import com.wangmai.common.utils.DebugLog;
import java.lang.ref.WeakReference;
import zc.a;
import zc.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMAdInterstitial implements InterstitialInterface, InterstitialParameter {
    public static final String TAG = b.a("XNBeJoufstujujbm");
    public XAdInterstitialListener absInterstitialADListener;
    public WeakReference<Activity> activityWeakReference;
    public String adslotId;
    public IAdLoader iAdLoader;
    public InterstitialInterface mInterstitialInterface;

    public WMAdInterstitial(Activity activity, String str, XAdInterstitialListener xAdInterstitialListener) {
        if (xAdInterstitialListener == null) {
            DebugLog.release_e(b.a("XNBeJoufstujujbm"), b.a("JoufstujujbmMjtufofs!jt!ovmm"));
            return;
        }
        try {
            this.activityWeakReference = new WeakReference<>(activity);
            this.adslotId = str;
            this.absInterstitialADListener = xAdInterstitialListener;
            IAdLoader a10 = a.a(activity.getApplicationContext());
            this.iAdLoader = a10;
            if (a10 != null) {
                a10.fetchInterstialAd(this);
            } else {
                DebugLog.release_e(b.a("XNBeJoufstujujbm"), b.a("Joufstujujbm扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
                xAdInterstitialListener.onNoAd(b.a("琓沐��撋扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
            }
        } catch (Throwable th) {
            DebugLog.release_e(b.a("XNBeJoufstujujbm"), b.a("Joufstujujbm扞樌捗楲鵦;") + th.toString());
            xAdInterstitialListener.onNoAd(b.a("琓沐��撋扞樌捗楲鵦;") + th.getMessage());
        }
    }

    @Override // com.wangmai.common.Iinterface.InterstitialInterface
    public void close() {
        try {
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                interstitialInterface.close();
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("Joufstujujbm!dmptf;") + th.getMessage());
        }
    }

    @Override // com.wangmai.common.Iinterface.InterstitialInterface
    public void destroy() {
        try {
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                interstitialInterface.destroy();
                this.mInterstitialInterface = null;
            }
            WeakReference<Activity> weakReference = this.activityWeakReference;
            if (weakReference != null) {
                weakReference.clear();
                this.activityWeakReference = null;
            }
            this.absInterstitialADListener = null;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("Joufstujujbm!eftuspz;") + th.getMessage());
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseParameter
    public Activity getAct() {
        WeakReference<Activity> weakReference = this.activityWeakReference;
        return ((weakReference == null || weakReference.get() == null) ? WMDexAdHelper.getTopActivity() : this.activityWeakReference).get();
    }

    @Override // com.wangmai.common.Ibase.IBaseParameter
    public String getAdSlotId() {
        return this.adslotId;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public String getCurrentVCode() {
        try {
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                return interstitialInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("Joufstujujbm!hfuDvssfouWDpef;") + th.toString());
            return null;
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public int getECPM() {
        InterstitialInterface interstitialInterface = this.mInterstitialInterface;
        if (interstitialInterface != null) {
            return interstitialInterface.getECPM();
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.wangmai.common.Ibase.IBaseParameter
    public InterstialBean getExtraBean() {
        return null;
    }

    @Override // com.wangmai.appsdkdex.Iparameter.InterstitialParameter
    public XAdInterstitialListener getInterstitialistener() {
        return this.absInterstitialADListener;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                return interstitialInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("Joufstujujbm!hfuSfrvftuJe;") + th.toString());
            return null;
        }
    }

    @Override // com.wangmai.common.Iinterface.InterstitialInterface
    public boolean isReady() {
        InterstitialInterface interstitialInterface = this.mInterstitialInterface;
        if (interstitialInterface != null) {
            return interstitialInterface.isReady();
        }
        return false;
    }

    @Override // com.wangmai.common.Iinterface.InterstitialInterface
    public void load() {
        try {
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                interstitialInterface.load();
            } else {
                DebugLog.release_e(TAG, b.a("Joufstujujbm拡龾楲鵦;JoufstujujbmJoufsgbdf!jt!ovmm"));
                XAdInterstitialListener xAdInterstitialListener = this.absInterstitialADListener;
                if (xAdInterstitialListener != null) {
                    xAdInterstitialListener.onNoAd(b.a("琓沐��撋拡龾楲鵦;JoufstujujbmJoufsgbdf!jt!ovmm"));
                }
            }
        } catch (Throwable th) {
            DebugLog.release_e(TAG, b.a("Joufstujujbm拡龾楲鵦;") + th.toString());
            XAdInterstitialListener xAdInterstitialListener2 = this.absInterstitialADListener;
            if (xAdInterstitialListener2 != null) {
                xAdInterstitialListener2.onNoAd(b.a("琓沐��撋拡龾楲鵦;") + th.getMessage());
            }
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        InterstitialInterface interstitialInterface = this.mInterstitialInterface;
        if (interstitialInterface != null) {
            interstitialInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        InterstitialInterface interstitialInterface = this.mInterstitialInterface;
        if (interstitialInterface != null) {
            interstitialInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Iinterface.InterstitialInterface
    public void show(Context context) {
        try {
            InterstitialInterface interstitialInterface = this.mInterstitialInterface;
            if (interstitialInterface != null) {
                interstitialInterface.show(context);
            } else {
                DebugLog.release_e(TAG, b.a("Joufstujujbm沖襻楲鵦;JoufstujujbmJoufsgbdf!jt!ovmm"));
            }
        } catch (Throwable th) {
            DebugLog.release_e(TAG, b.a("Joufstujujbm沖襻楲鵦;") + th.getMessage());
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void setImplement(InterstitialInterface interstitialInterface) {
        this.mInterstitialInterface = interstitialInterface;
    }
}
