package com.wangmai.appsdkdex.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.wangmai.appsdkdex.Iparameter.INativePotParameter;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.common.IAdLoader;
import com.wangmai.common.Iinterface.INativePotInterface;
import com.wangmai.common.Ilistener.XAdNativePotListener;
import com.wangmai.common.bean.NativeBean;
import com.wangmai.common.utils.DebugLog;
import java.lang.ref.WeakReference;
import zc.a;
import zc.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMAdNativePot implements INativePotInterface, INativePotParameter {
    public static final String TAG = b.a("XNBeObujwfQpu");
    public WeakReference<Activity> activityWeakReference;
    public String adslotId;
    public IAdLoader iAdLoader;
    public INativePotInterface nativePotInterface;
    public XAdNativePotListener wmNativeListener;

    public WMAdNativePot(Activity activity, String str, XAdNativePotListener xAdNativePotListener) {
        if (xAdNativePotListener == null) {
            DebugLog.release_e(b.a("XNBeObujwfQpu"), b.a("ObujwfQpuMjtufofs!jt!ovmm"));
            return;
        }
        try {
            this.activityWeakReference = new WeakReference<>(activity);
            this.adslotId = str;
            this.wmNativeListener = xAdNativePotListener;
            IAdLoader a10 = a.a(activity.getApplicationContext());
            this.iAdLoader = a10;
            if (a10 != null) {
                a10.fetchNativePotAd(this);
            } else {
                DebugLog.release_e(b.a("XNBeObujwfQpu"), b.a("ObujwfQpu扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
                xAdNativePotListener.onNoAd(b.a("���炰綂鈫繳研��撋扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
            }
        } catch (Throwable th) {
            DebugLog.release_e(b.a("XNBeObujwfQpu"), b.a("ObujwfQpu扞樌捗楲鵦�") + th.toString());
            xAdNativePotListener.onNoAd(b.a("���炰綂鈫繳研��撋扞樌捗楲鵦;") + th.getMessage());
        }
    }

    @Override // com.wangmai.common.Iinterface.INativePotInterface
    public void destroy() {
        try {
            INativePotInterface iNativePotInterface = this.nativePotInterface;
            if (iNativePotInterface != null) {
                iNativePotInterface.destroy();
                this.nativePotInterface = null;
            }
            WeakReference<Activity> weakReference = this.activityWeakReference;
            if (weakReference != null) {
                weakReference.clear();
                this.activityWeakReference = null;
            }
            this.wmNativeListener = null;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("ObujwfQpu!eftuspz;") + th.toString());
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
            INativePotInterface iNativePotInterface = this.nativePotInterface;
            if (iNativePotInterface != null) {
                return iNativePotInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("ObujwfQpu!hfuDvssfouWDpef;") + th.toString());
            return null;
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public int getECPM() {
        INativePotInterface iNativePotInterface = this.nativePotInterface;
        if (iNativePotInterface != null) {
            return iNativePotInterface.getECPM();
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.wangmai.common.Ibase.IBaseParameter
    public NativeBean getExtraBean() {
        return null;
    }

    @Override // com.wangmai.appsdkdex.Iparameter.INativePotParameter
    public XAdNativePotListener getNativePotListener() {
        return this.wmNativeListener;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            INativePotInterface iNativePotInterface = this.nativePotInterface;
            if (iNativePotInterface != null) {
                return iNativePotInterface.getRequestId();
            }
            return null;
        } catch (Throwable th) {
            DebugLog.W(TAG, b.a("ObujwfQpu!hfuSfrvftuJe;") + th.toString());
            return null;
        }
    }

    @Override // com.wangmai.common.Iinterface.INativePotInterface
    public boolean isReady() {
        try {
            return this.nativePotInterface.isReady();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        INativePotInterface iNativePotInterface = this.nativePotInterface;
        if (iNativePotInterface != null) {
            iNativePotInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        INativePotInterface iNativePotInterface = this.nativePotInterface;
        if (iNativePotInterface != null) {
            iNativePotInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void setImplement(INativePotInterface iNativePotInterface) {
        this.nativePotInterface = iNativePotInterface;
    }

    public WMAdNativePot(Context context, String str, XAdNativePotListener xAdNativePotListener) {
        if (xAdNativePotListener == null) {
            DebugLog.release_e(b.a("XNBeObujwfQpu"), b.a("ObujwfQpuMjtufofs!jt!ovmm"));
            return;
        }
        try {
            this.adslotId = str;
            this.wmNativeListener = xAdNativePotListener;
            IAdLoader a10 = a.a(context);
            this.iAdLoader = a10;
            if (a10 != null) {
                a10.fetchNativePotAd(this);
            } else {
                DebugLog.release_e(b.a("XNBeObujwfQpu"), b.a("ObujwfQpu扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
                xAdNativePotListener.onNoAd(b.a("���炰綂鈫繳研��撋扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
            }
        } catch (Throwable th) {
            DebugLog.release_e(b.a("XNBeObujwfQpu"), b.a("ObujwfQpu扞樌捗楲鵦�") + th.toString());
            xAdNativePotListener.onNoAd(b.a("���炰綂鈫繳研��撋扞樌捗楲鵦;") + th.getMessage());
        }
    }
}
