package y9;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.huawei.appgallery.marketinstallerservice.api.BaseParamSpec;
import com.huawei.appgallery.marketinstallerservice.api.FailResultParam;
import com.huawei.appgallery.marketinstallerservice.api.InstallCallback;
import com.huawei.appgallery.marketinstallerservice.api.InstallParamSpec;
import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.RequestBean;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.ResponseBean;
import com.huawei.appgallery.marketinstallerservice.ui.MarketDownloadActivity;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d implements c {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a implements ja.b {

        /* renamed from: a, reason: collision with root package name */
        public InstallCallback f54692a;

        public a(InstallCallback installCallback) {
            this.f54692a = installCallback;
        }

        @Override // ja.b
        public void a(RequestBean requestBean, ResponseBean responseBean) {
        }

        @Override // ja.b
        public void b(RequestBean requestBean, ResponseBean responseBean) {
            if (this.f54692a == null) {
                fa.a.c("MarketInstallApiImpl", "callback is null!");
                return;
            }
            if (!(responseBean instanceof z9.b)) {
                fa.a.c("MarketInstallApiImpl", "get Market info error!");
                return;
            }
            if (responseBean.getResponseCode() == 0 && responseBean.getRtnCode() == 0) {
                this.f54692a.onSuccess(((z9.b) responseBean).getHiAppInfo());
                return;
            }
            fa.a.c("MarketInstallApiImpl", "get Market info error: responseCode:" + responseBean.getResponseCode() + ", rtnCode:" + responseBean.getRtnCode());
            FailResultParam failResultParam = new FailResultParam();
            failResultParam.setResult(-4);
            failResultParam.setResponseCode(responseBean.getResponseCode());
            failResultParam.setRtnCode(responseBean.getRtnCode());
            this.f54692a.onFailed(failResultParam);
        }
    }

    @Override // y9.c
    public void a(@NonNull Activity activity, @NonNull InstallParamSpec installParamSpec, InstallCallback installCallback) {
        if (installParamSpec.isSilentDownload()) {
            fa.a.d("MarketInstallApiImpl", "start silent download market!");
            new ia.c(activity, installParamSpec, installCallback).a();
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) MarketDownloadActivity.class);
        intent.putExtra("callback_key", y9.a.b(installCallback));
        MarketInfo marketInfo = installParamSpec.getMarketInfo();
        if (marketInfo != null) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(marketInfo);
            intent.putParcelableArrayListExtra("market_info_key", arrayList);
        } else {
            String serverUrl = installParamSpec.getServerUrl();
            String subsystem = installParamSpec.getSubsystem();
            String marketPkg = installParamSpec.getMarketPkg();
            boolean isUpdate = installParamSpec.isUpdate();
            intent.putExtra("service_url_key", serverUrl);
            intent.putExtra("sub_system_key", subsystem);
            intent.putExtra("market_pkg_key", marketPkg);
            intent.putExtra("is_update_key", isUpdate);
        }
        intent.putExtra("fail_result_type_key", installParamSpec.getFailResultPromptType());
        activity.startActivity(intent);
    }

    @Override // y9.c
    public void b(@NonNull Context context, @NonNull BaseParamSpec baseParamSpec, InstallCallback installCallback) {
        z9.a newInstance = z9.a.newInstance(context);
        newInstance.setServiceUrl(baseParamSpec.getServerUrl());
        newInstance.setSubsystem(baseParamSpec.getSubsystem());
        newInstance.setMarketPkg(baseParamSpec.getMarketPkg());
        ba.a.a(newInstance, new a(installCallback));
    }
}
