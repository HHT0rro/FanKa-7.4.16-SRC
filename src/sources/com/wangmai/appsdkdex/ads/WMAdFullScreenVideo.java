package com.wangmai.appsdkdex.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.wangmai.appsdkdex.Iparameter.IFullScreenParameter;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.common.IAdLoader;
import com.wangmai.common.Iinterface.IFullScreenInterface;
import com.wangmai.common.Ilistener.XAdFullScreenVideoListener;
import com.wangmai.common.bean.FullScreenBean;
import com.wangmai.common.utils.DebugLog;
import java.lang.ref.WeakReference;
import zc.a;
import zc.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMAdFullScreenVideo implements IFullScreenInterface, IFullScreenParameter {
    public final String TAG = b.a("XNBeGvmmTdsffoWjefp");
    public WeakReference<Activity> activityWeakReference;
    public String adslotId;
    public IAdLoader iAdLoader;
    public IFullScreenInterface rewordInterface;
    public XAdFullScreenVideoListener wmFullScreenListener;

    public WMAdFullScreenVideo(Activity activity, String str, XAdFullScreenVideoListener xAdFullScreenVideoListener) {
        if (xAdFullScreenVideoListener == null) {
            DebugLog.release_e(b.a("XNBeGvmmTdsffoWjefp"), b.a("GvmmTdsffoWjefpMjtufofs!jt!ovmm"));
            return;
        }
        try {
            this.activityWeakReference = new WeakReference<>(activity);
            this.adslotId = str;
            this.wmFullScreenListener = xAdFullScreenVideoListener;
            IAdLoader a10 = a.a(activity.getApplicationContext());
            this.iAdLoader = a10;
            if (a10 != null) {
                a10.fetchFullScreenAd(this);
            } else {
                DebugLog.release_e(b.a("XNBeGvmmTdsffoWjefp"), b.a("GvmmTdsffoWjefp扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
                xAdFullScreenVideoListener.onNoAd(b.a("憩沐��撋扞樌捗楲鵦;BeMpbefs!jt!ovmm"));
            }
        } catch (Throwable th) {
            DebugLog.release_e(b.a("XNBeGvmmTdsffoWjefp"), b.a("GvmmTdsffoWjefp扞樌捗楲鵦;") + th.toString());
            xAdFullScreenVideoListener.onNoAd(b.a("憩沐��撋扞樌捗楲鵦;") + th.getMessage());
        }
    }

    @Override // com.wangmai.common.Iinterface.IFullScreenInterface
    public void destroy() {
        try {
            IFullScreenInterface iFullScreenInterface = this.rewordInterface;
            if (iFullScreenInterface != null) {
                iFullScreenInterface.destroy();
                this.rewordInterface = null;
            }
            WeakReference<Activity> weakReference = this.activityWeakReference;
            if (weakReference != null) {
                weakReference.clear();
                this.activityWeakReference = null;
            }
        } catch (Throwable th) {
            DebugLog.W(this.TAG, b.a("GvmmTdsffoWjefp!eftuspz!fydfqujpo�") + th.getMessage());
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
            IFullScreenInterface iFullScreenInterface = this.rewordInterface;
            if (iFullScreenInterface != null) {
                return iFullScreenInterface.getCurrentVCode();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public int getECPM() {
        IFullScreenInterface iFullScreenInterface = this.rewordInterface;
        if (iFullScreenInterface != null) {
            return iFullScreenInterface.getECPM();
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.wangmai.common.Ibase.IBaseParameter
    public FullScreenBean getExtraBean() {
        return null;
    }

    @Override // com.wangmai.appsdkdex.Iparameter.IFullScreenParameter
    public XAdFullScreenVideoListener getFullScreenListener() {
        return this.wmFullScreenListener;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public String getRequestId() {
        try {
            IFullScreenInterface iFullScreenInterface = this.rewordInterface;
            if (iFullScreenInterface != null) {
                return iFullScreenInterface.getRequestId();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.wangmai.common.Iinterface.IFullScreenInterface
    public void load() {
        try {
            IFullScreenInterface iFullScreenInterface = this.rewordInterface;
            if (iFullScreenInterface != null) {
                iFullScreenInterface.load();
            } else {
                DebugLog.release_e(this.TAG, b.a("GvmmTdsffoWjefp拡龾楲鵦;GvmmTdsffoJoufsgbdf!jt!ovmm"));
                XAdFullScreenVideoListener xAdFullScreenVideoListener = this.wmFullScreenListener;
                if (xAdFullScreenVideoListener != null) {
                    xAdFullScreenVideoListener.onNoAd(b.a("憩沐��撋拡龾楲鵦;GvmmTdsffoJoufsgbdf!jt!ovmm"));
                }
            }
        } catch (Throwable th) {
            DebugLog.release_e(this.TAG, b.a("GvmmTdsffoWjefp拡龾楲鵦;") + th.getMessage());
            XAdFullScreenVideoListener xAdFullScreenVideoListener2 = this.wmFullScreenListener;
            if (xAdFullScreenVideoListener2 != null) {
                xAdFullScreenVideoListener2.onNoAd(b.a("憩沐��撋拡龾楲鵦;") + th.toString());
            }
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        IFullScreenInterface iFullScreenInterface = this.rewordInterface;
        if (iFullScreenInterface != null) {
            iFullScreenInterface.sendLossNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        IFullScreenInterface iFullScreenInterface = this.rewordInterface;
        if (iFullScreenInterface != null) {
            iFullScreenInterface.sendWinNotificationWithInfo(bundle);
        }
    }

    @Override // com.wangmai.common.Iinterface.IFullScreenInterface
    public void show(Context context) {
        try {
            IFullScreenInterface iFullScreenInterface = this.rewordInterface;
            if (iFullScreenInterface != null) {
                iFullScreenInterface.show(context);
            } else {
                DebugLog.release_e(this.TAG, b.a("GvmmTdsffoWjefp沖襻楲鵦;GvmmTdsffoJoufsgbdf!jt!ovmm"));
            }
        } catch (Throwable th) {
            DebugLog.release_e(this.TAG, b.a("憩沐��撋沖襻楲鵦;") + th.getMessage());
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void setImplement(IFullScreenInterface iFullScreenInterface) {
        this.rewordInterface = iFullScreenInterface;
    }
}
