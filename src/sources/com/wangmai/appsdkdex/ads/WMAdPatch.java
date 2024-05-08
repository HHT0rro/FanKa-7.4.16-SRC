package com.wangmai.appsdkdex.ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import com.wangmai.appsdkdex.Iparameter.IPatchParameter;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.common.IAdLoader;
import com.wangmai.common.Iinterface.IPatchInterface;
import com.wangmai.common.Ilistener.XAdPatchListener;
import com.wangmai.common.bean.PatchBean;
import com.wangmai.common.utils.DebugLog;
import java.lang.ref.WeakReference;
import zc.a;
import zc.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMAdPatch implements IPatchInterface, IPatchParameter {
    public static final String TAG = b.a("XNBeQbudi");
    public WeakReference<Activity> activityWeakReference;
    public String adslotId;
    public IAdLoader iAdLoader;
    public IPatchInterface iPatchInterface;
    public PatchBean patchBean;
    public XAdPatchListener patchListener;

    public WMAdPatch(Activity activity, String str, XAdPatchListener xAdPatchListener) {
        this(activity, str, null, xAdPatchListener);
    }

    @Override // com.wangmai.common.Iinterface.IPatchInterface
    public void destroy() {
        IPatchInterface iPatchInterface = this.iPatchInterface;
        if (iPatchInterface != null) {
            iPatchInterface.destroy();
        }
        WeakReference<Activity> weakReference = this.activityWeakReference;
        if (weakReference != null) {
            weakReference.clear();
            this.activityWeakReference = null;
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

    @Override // com.wangmai.common.Iinterface.IPatchInterface
    public long getCurrentPosition() {
        try {
            IPatchInterface iPatchInterface = this.iPatchInterface;
            if (iPatchInterface != null) {
                return iPatchInterface.getCurrentPosition();
            }
            return 0L;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("Qbudi!hfuDvssfouQptjujpo;") + th.toString());
            return 0L;
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public String getCurrentVCode() {
        try {
            IPatchInterface iPatchInterface = this.iPatchInterface;
            if (iPatchInterface != null) {
                return iPatchInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("Qbudi!hfuDvssfouWDpef;") + th.toString());
            return null;
        }
    }

    @Override // com.wangmai.common.Iinterface.IPatchInterface
    public long getDuration() {
        try {
            IPatchInterface iPatchInterface = this.iPatchInterface;
            if (iPatchInterface != null) {
                return iPatchInterface.getDuration();
            }
            return 0L;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("Qbudi!hfuEvsbujpo;") + th.toString());
            return 0L;
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public int getECPM() {
        IPatchInterface iPatchInterface = this.iPatchInterface;
        if (iPatchInterface != null) {
            return iPatchInterface.getECPM();
        }
        return 0;
    }

    @Override // com.wangmai.appsdkdex.Iparameter.IPatchParameter
    public XAdPatchListener getPatchListener() {
        return this.patchListener;
    }

    @Override // com.wangmai.appsdkdex.Iparameter.IPatchParameter
    public ViewGroup getPatchViewGroup() {
        return null;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            IPatchInterface iPatchInterface = this.iPatchInterface;
            if (iPatchInterface != null) {
                return iPatchInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("Qbudi!hfuSfrvftuJe;") + th.toString());
            return null;
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        IPatchInterface iPatchInterface = this.iPatchInterface;
        if (iPatchInterface != null) {
            iPatchInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        IPatchInterface iPatchInterface = this.iPatchInterface;
        if (iPatchInterface != null) {
            iPatchInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Iinterface.IPatchInterface
    public void show(ViewGroup viewGroup) {
        try {
            IPatchInterface iPatchInterface = this.iPatchInterface;
            if (iPatchInterface != null) {
                iPatchInterface.show(viewGroup);
            } else {
                DebugLog.release_e(TAG, b.a("Qbudi沖襻楲鵦;jQbudiJoufsgbdf!jt!ovmm"));
            }
        } catch (Throwable th) {
            DebugLog.release_e(TAG, b.a("Qbudi沖襻楲鵦;") + th.getMessage());
        }
    }

    public WMAdPatch(Activity activity, String str, PatchBean patchBean, XAdPatchListener xAdPatchListener) {
        try {
            if (xAdPatchListener == null) {
                DebugLog.release_e(b.a("XNBeQbudi"), b.a("QbudiMjtufofs!jt!ovmm"));
                return;
            }
            this.activityWeakReference = new WeakReference<>(activity);
            this.patchListener = xAdPatchListener;
            this.adslotId = str;
            if (patchBean != null) {
                this.patchBean = patchBean;
            } else {
                this.patchBean = new PatchBean();
            }
            IAdLoader a10 = a.a(activity.getApplicationContext());
            this.iAdLoader = a10;
            if (a10 != null) {
                a10.fetchPatchAd(this);
            } else {
                DebugLog.release_e(b.a("XNBeQbudi"), b.a("Qbudi扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
                xAdPatchListener.onNoAd(b.a("騇꣒鵵芈��撋扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
            }
        } catch (Throwable th) {
            DebugLog.release_e(b.a("XNBeQbudi"), b.a("Qbudi扞樌捗楲鵦;") + th.toString());
            xAdPatchListener.onNoAd(b.a("騇꣒鵵芈��撋扞樌捗楲鵦;") + th.getMessage());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.wangmai.common.Ibase.IBaseParameter
    public PatchBean getExtraBean() {
        return this.patchBean;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void setImplement(IPatchInterface iPatchInterface) {
        this.iPatchInterface = iPatchInterface;
    }
}
