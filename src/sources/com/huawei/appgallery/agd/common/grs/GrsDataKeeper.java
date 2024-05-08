package com.huawei.appgallery.agd.common.grs;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.CommonLog;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.support.global.HomeCountryUtils;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class GrsDataKeeper {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f27361e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public static GrsDataKeeper f27362f;

    /* renamed from: a, reason: collision with root package name */
    public String f27363a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f27364b = "";

    /* renamed from: c, reason: collision with root package name */
    public IHomeCountryProxy f27365c;

    /* renamed from: d, reason: collision with root package name */
    public String f27366d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface IHomeCountryProxy {
        String getHomeCountry();
    }

    public static GrsDataKeeper getInstance() {
        GrsDataKeeper grsDataKeeper;
        synchronized (f27361e) {
            if (f27362f == null) {
                f27362f = new GrsDataKeeper();
            }
            grsDataKeeper = f27362f;
        }
        return grsDataKeeper;
    }

    public String getAppName(Context context) {
        String string = new AgdDataSp(context).getString(AgdDataSp.AGD_DATA_GRS_APP_NAME, "");
        this.f27364b = string;
        return string;
    }

    public String getHomeCountry() {
        IHomeCountryProxy iHomeCountryProxy;
        Context context = ApplicationWrapper.getInstance().getContext();
        if (context == null) {
            return !TextUtils.isEmpty(this.f27366d) ? this.f27366d : !TextUtils.isEmpty(this.f27363a) ? this.f27363a : "";
        }
        if (TextUtils.isEmpty(this.f27366d) && (iHomeCountryProxy = this.f27365c) != null) {
            String homeCountry = iHomeCountryProxy.getHomeCountry();
            CommonLog.LOG.i("GrsDataKeeper", "getHomeCountry from AG: " + homeCountry);
            if (!TextUtils.isEmpty(homeCountry)) {
                this.f27366d = homeCountry;
            }
        }
        if (!TextUtils.isEmpty(this.f27366d)) {
            return this.f27366d;
        }
        String string = new AgdDataSp(context).getString(AgdDataSp.AGD_DATA_HOMECOUNTRY, "");
        this.f27363a = string;
        if (TextUtils.isEmpty(string)) {
            this.f27363a = GrsApp.getInstance().getIssueCountryCode(context);
        }
        if (StringUtils.isEmpty(this.f27363a)) {
            this.f27363a = HomeCountryUtils.getHomeCountry();
        }
        return this.f27363a;
    }

    public void setHomeCountryProxy(IHomeCountryProxy iHomeCountryProxy) {
        this.f27365c = iHomeCountryProxy;
    }

    public void storeAppName(@NonNull Context context, String str) {
        if (str == null) {
            str = "";
        }
        if (this.f27364b.equals(str)) {
            return;
        }
        this.f27364b = str;
        new AgdDataSp(context).putString(AgdDataSp.AGD_DATA_GRS_APP_NAME, str);
    }

    public void storeHomeCountry(@NonNull Context context, String str) {
        CommonLog.LOG.i("GrsDataKeeper", "storeHomeCountry current: " + this.f27363a + ", new: " + str);
        if (str == null) {
            str = "";
        }
        if (this.f27363a.equals(str)) {
            return;
        }
        this.f27363a = str;
        new AgdDataSp(context).putString(AgdDataSp.AGD_DATA_HOMECOUNTRY, str);
    }
}
