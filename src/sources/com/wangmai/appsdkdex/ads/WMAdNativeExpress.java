package com.wangmai.appsdkdex.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.wangmai.appsdkdex.Iparameter.INativeExpressParameter;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.common.IAdLoader;
import com.wangmai.common.Iinterface.INativeExpressInterface;
import com.wangmai.common.Ilistener.XAdNativeExpressListener;
import com.wangmai.common.bean.NativeExpressBean;
import com.wangmai.common.utils.DebugLog;
import java.lang.ref.WeakReference;
import zc.a;
import zc.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMAdNativeExpress implements INativeExpressInterface, INativeExpressParameter {
    public static final String TAG = b.a("XNBeObujwfFyqsfttQpu");
    public WeakReference<Activity> activityWeakReference;
    public String adslotId;
    public IAdLoader iAdLoader;
    public INativeExpressInterface nativeExpressInterface;
    public XAdNativeExpressListener wmTemplateAdListener;

    public WMAdNativeExpress(Activity activity, String str, XAdNativeExpressListener xAdNativeExpressListener) {
        if (xAdNativeExpressListener == null) {
            DebugLog.release_e(b.a("XNBeObujwfFyqsfttQpu"), b.a("ObujwfFyqsfttMjtufofs!jt!ovmm"));
            return;
        }
        try {
            this.activityWeakReference = new WeakReference<>(activity);
            this.adslotId = str;
            this.wmTemplateAdListener = xAdNativeExpressListener;
            IAdLoader a10 = a.a(activity.getApplicationContext());
            this.iAdLoader = a10;
            if (a10 != null) {
                a10.fetchNativeExpressAd(this);
            } else {
                DebugLog.release_e(b.a("XNBeObujwfFyqsfttQpu"), b.a("ObujwfFyqsftt扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
                xAdNativeExpressListener.onNoAd(b.a("���炰綂穢����撋扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
            }
        } catch (Throwable th) {
            DebugLog.release_e(b.a("XNBeObujwfFyqsfttQpu"), b.a("ObujwfFyqsftt扞樌捗楲鵦;") + th.toString());
            xAdNativeExpressListener.onNoAd(b.a("���炰綂穢����撋扞樌捗楲鵦;") + th.getMessage());
        }
    }

    @Override // com.wangmai.common.Iinterface.INativeExpressInterface
    public void destroy() {
        try {
            INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
            if (iNativeExpressInterface != null) {
                iNativeExpressInterface.destroy();
                this.nativeExpressInterface = null;
            }
            WeakReference<Activity> weakReference = this.activityWeakReference;
            if (weakReference != null) {
                weakReference.clear();
                this.activityWeakReference = null;
            }
            this.wmTemplateAdListener = null;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("ObujwfFyqsftt!eftuspz;") + th.getMessage());
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
            INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
            if (iNativeExpressInterface != null) {
                return iNativeExpressInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("ObujwfFyqsftt!hfuDvssfouWDpef;") + th.toString());
            return null;
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public int getECPM() {
        INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
        if (iNativeExpressInterface != null) {
            return iNativeExpressInterface.getECPM();
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.wangmai.common.Ibase.IBaseParameter
    public NativeExpressBean getExtraBean() {
        return null;
    }

    @Override // com.wangmai.appsdkdex.Iparameter.INativeExpressParameter
    public XAdNativeExpressListener getNativeExpressListener() {
        return this.wmTemplateAdListener;
    }

    @Override // com.wangmai.appsdkdex.Iparameter.INativeExpressParameter
    public ViewGroup getNativeExpressViewGroup() {
        return null;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
            if (iNativeExpressInterface != null) {
                return iNativeExpressInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("ObujwfFyqsftt!hfuSfrvftuJe;") + th.toString());
            return null;
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
        if (iNativeExpressInterface != null) {
            iNativeExpressInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        INativeExpressInterface iNativeExpressInterface = this.nativeExpressInterface;
        if (iNativeExpressInterface != null) {
            iNativeExpressInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void setImplement(INativeExpressInterface iNativeExpressInterface) {
        this.nativeExpressInterface = iNativeExpressInterface;
    }

    public WMAdNativeExpress(Context context, String str, XAdNativeExpressListener xAdNativeExpressListener) {
        if (xAdNativeExpressListener == null) {
            DebugLog.release_e(b.a("XNBeObujwfFyqsfttQpu"), b.a("ObujwfFyqsfttMjtufofs!jt!ovmm"));
            return;
        }
        try {
            this.adslotId = str;
            this.wmTemplateAdListener = xAdNativeExpressListener;
            IAdLoader a10 = a.a(context);
            this.iAdLoader = a10;
            if (a10 != null) {
                a10.fetchNativeExpressAd(this);
            } else {
                DebugLog.release_e(b.a("XNBeObujwfFyqsfttQpu"), b.a("ObujwfFyqsftt扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
                xAdNativeExpressListener.onNoAd(b.a("���炰綂穢����撋扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
            }
        } catch (Throwable th) {
            DebugLog.release_e(b.a("XNBeObujwfFyqsfttQpu"), b.a("ObujwfFyqsftt扞樌捗楲鵦;") + th.toString());
            xAdNativeExpressListener.onNoAd(b.a("���炰綂穢����撋扞樌捗楲鵦;") + th.getMessage());
        }
    }
}
