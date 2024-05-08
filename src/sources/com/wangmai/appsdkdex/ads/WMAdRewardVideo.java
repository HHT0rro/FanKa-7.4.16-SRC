package com.wangmai.appsdkdex.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.wangmai.appsdkdex.Iparameter.IRewordParameter;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.common.IAdLoader;
import com.wangmai.common.Iinterface.IRewordInterface;
import com.wangmai.common.Ilistener.XAdRewardVideoListener;
import com.wangmai.common.bean.RewordBean;
import com.wangmai.common.utils.DebugLog;
import java.lang.ref.WeakReference;
import zc.a;
import zc.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMAdRewardVideo implements IRewordInterface, IRewordParameter {
    public final String TAG = b.a("XNBeSfxbseWjefp");
    public WeakReference<Activity> activityWeakReference;
    public String adslotId;
    public IAdLoader iAdLoader;
    public int orientation;
    public IRewordInterface rewordInterface;
    public XAdRewardVideoListener wmRewardListener;

    public WMAdRewardVideo(Activity activity, String str, int i10, XAdRewardVideoListener xAdRewardVideoListener) {
        if (xAdRewardVideoListener == null) {
            DebugLog.release_e(b.a("XNBeSfxbseWjefp"), b.a("SfxbseWjefpMjtufofs!jt!ovmm"));
            return;
        }
        try {
            this.activityWeakReference = new WeakReference<>(activity);
            this.adslotId = str;
            this.orientation = i10;
            this.wmRewardListener = xAdRewardVideoListener;
            IAdLoader a10 = a.a(activity.getApplicationContext());
            this.iAdLoader = a10;
            if (a10 != null) {
                a10.fetchRewordVideoAd(this);
            } else {
                DebugLog.release_e(b.a("XNBeSfxbseWjefp"), b.a("SfxbseWjefp扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
                xAdRewardVideoListener.onNoAd(b.a("���拲��撋扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
            }
        } catch (Throwable th) {
            DebugLog.release_e(b.a("XNBeSfxbseWjefp"), b.a("SfxbseWjefp扞樌捗楲鵦;") + th.toString());
            xAdRewardVideoListener.onNoAd(b.a("���拲��撋扞樌捗楲鵦;") + th.getMessage());
        }
    }

    @Override // com.wangmai.common.Iinterface.IRewordInterface
    public void destroy() {
        try {
            IRewordInterface iRewordInterface = this.rewordInterface;
            if (iRewordInterface != null) {
                iRewordInterface.destroy();
                this.rewordInterface = null;
            }
            WeakReference<Activity> weakReference = this.activityWeakReference;
            if (weakReference != null) {
                weakReference.clear();
                this.activityWeakReference = null;
            }
            this.wmRewardListener = null;
        } catch (Throwable th) {
            DebugLog.W(this.TAG, b.a("SfxbseWjefp!eftuspz�") + th.getMessage());
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
            IRewordInterface iRewordInterface = this.rewordInterface;
            if (iRewordInterface != null) {
                return iRewordInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            DebugLog.W(this.TAG, b.a("SfxbseWjefp!hfuDvssfouWDpef;") + th.toString());
            return null;
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public int getECPM() {
        IRewordInterface iRewordInterface = this.rewordInterface;
        if (iRewordInterface != null) {
            return iRewordInterface.getECPM();
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.wangmai.common.Ibase.IBaseParameter
    public RewordBean getExtraBean() {
        return null;
    }

    @Override // com.wangmai.appsdkdex.Iparameter.IRewordParameter
    public int getOrientation() {
        return this.orientation;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            IRewordInterface iRewordInterface = this.rewordInterface;
            if (iRewordInterface != null) {
                return iRewordInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            DebugLog.W(this.TAG, b.a("SfxbseWjefp!hfuSfrvftuJe;") + th.toString());
            return null;
        }
    }

    @Override // com.wangmai.appsdkdex.Iparameter.IRewordParameter
    public XAdRewardVideoListener getRewardListener() {
        return this.wmRewardListener;
    }

    @Override // com.wangmai.common.Iinterface.IRewordInterface
    public void load() {
        try {
            IRewordInterface iRewordInterface = this.rewordInterface;
            if (iRewordInterface != null) {
                iRewordInterface.load();
            } else {
                DebugLog.release_e(this.TAG, b.a("SfxbseWjefp!mpbe!fssps;JSfxpseJoufsgbdf!jt!ovmm\""));
                XAdRewardVideoListener xAdRewardVideoListener = this.wmRewardListener;
                if (xAdRewardVideoListener != null) {
                    xAdRewardVideoListener.onNoAd(b.a("盃瘡��撋"));
                }
            }
        } catch (Throwable th) {
            DebugLog.release_e(this.TAG, b.a("SfxbseWjefp!mpbe!fssps;") + th.toString());
            XAdRewardVideoListener xAdRewardVideoListener2 = this.wmRewardListener;
            if (xAdRewardVideoListener2 != null) {
                xAdRewardVideoListener2.onNoAd(b.a("盃瘡��撋"));
            }
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        IRewordInterface iRewordInterface = this.rewordInterface;
        if (iRewordInterface != null) {
            iRewordInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        IRewordInterface iRewordInterface = this.rewordInterface;
        if (iRewordInterface != null) {
            iRewordInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Iinterface.IRewordInterface
    public void show(Context context) {
        try {
            IRewordInterface iRewordInterface = this.rewordInterface;
            if (iRewordInterface != null) {
                iRewordInterface.show(context);
            } else {
                DebugLog.release_e(this.TAG, b.a("SfxbseWjefp沖襻楲鵦;JSfxpseJoufsgbdf!jt!ovmm"));
            }
        } catch (Throwable th) {
            DebugLog.release_e(this.TAG, b.a("SfxbseWjefp沖襻楲鵦;") + th.getMessage());
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void setImplement(IRewordInterface iRewordInterface) {
        this.rewordInterface = iRewordInterface;
    }
}
