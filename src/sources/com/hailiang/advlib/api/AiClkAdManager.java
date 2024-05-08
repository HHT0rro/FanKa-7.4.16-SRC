package com.hailiang.advlib.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.hailiang.advlib.common.b;
import com.hailiang.advlib.common.c;
import com.hailiang.advlib.core.IMultiAdObject;
import com.hailiang.advlib.core.IMultiAdRequest;
import com.hailiang.advlib.core.QMConfig;
import com.hailiang.advlib.core.a;
import com.hailiang.advlib.open.JFIdentifierManager;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AiClkAdManager {
    public static volatile AiClkAdManager sManager;
    public AtomicBoolean isInit = new AtomicBoolean(false);
    public a mFactory;
    public QMConfig mQmConfig;

    public static AiClkAdManager getInstance() {
        if (sManager == null) {
            synchronized (AiClkAdManager.class) {
                if (sManager == null) {
                    sManager = new AiClkAdManager();
                }
            }
        }
        return sManager;
    }

    public static String getSdkVersion() {
        return "3.460.12.426";
    }

    @Deprecated
    public void appListFromClientNotice() {
        a aVar = this.mFactory;
        if (aVar == null) {
            return;
        }
        aVar.appListFromClientNotice();
    }

    public void closeInteractionAd(IMultiAdObject iMultiAdObject) {
        try {
            c.a(iMultiAdObject).b("closeInteractionAd");
        } catch (Throwable unused) {
        }
    }

    public IMultiAdRequest createAdRequest() {
        if (this.mFactory == null) {
            return null;
        }
        JFIdentifierManager.getInstance().acquireOAID(this.mQmConfig.getContext());
        return this.mFactory.createNativeMultiAdRequest();
    }

    @Deprecated
    public void init(Context context, String str) {
        init(new QMConfig.Builder().build(context));
    }

    public void setAppList(List<PackageInfo> list) {
        a aVar = this.mFactory;
        if (aVar == null) {
            return;
        }
        aVar.setAppList(list);
    }

    public void setOaid(String str) {
        JFIdentifierManager.getInstance().setOaid(str);
    }

    public void setPersonalRecommend(boolean z10) {
        try {
            c.b((Class<?>) b.c().b(IMultiAdRequest.class)).a("savePersonalRecommendSwitch", Boolean.valueOf(z10));
        } catch (Throwable unused) {
        }
    }

    public void init(@NonNull QMConfig qMConfig) {
        if (this.isInit.getAndSet(true)) {
            return;
        }
        this.mQmConfig = qMConfig;
        JFIdentifierManager.getInstance().setOaid(qMConfig.getCustomControl() != null ? qMConfig.getCustomControl().getOaid() : "");
        this.mFactory = a.a(qMConfig);
    }
}
