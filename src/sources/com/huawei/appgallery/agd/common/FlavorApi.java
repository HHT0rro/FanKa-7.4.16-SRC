package com.huawei.appgallery.agd.common;

import android.content.Context;
import com.huawei.appgallery.agd.common.flavor.IFlavorConfig;
import com.huawei.appgallery.agd.common.grs.GrsConfigObtainer;
import com.huawei.appgallery.agd.common.utils.ServerAddrConfig;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FlavorApi {

    /* renamed from: a, reason: collision with root package name */
    public static EnvOnlineFlavorConfig f27337a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class EnvOnlineFlavorConfig implements IFlavorConfig {
        public EnvOnlineFlavorConfig() {
        }

        @Override // com.huawei.appgallery.agd.common.flavor.IFlavorConfig
        public void biLog(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        }

        @Override // com.huawei.appgallery.agd.common.flavor.IFlavorConfig
        public String getBiUrl(Context context) {
            return GrsConfigObtainer.getServerUrl(context, ServerAddrConfig.BI_SDK_SERVER, FlavorApi.getGrsServerNameV2());
        }

        @Override // com.huawei.appgallery.agd.common.flavor.IFlavorConfig
        public Map<String, String> getGrsOfProperties() {
            return null;
        }

        @Override // com.huawei.appgallery.agd.common.flavor.IFlavorConfig
        public String getRiskToken() {
            return "";
        }

        @Override // com.huawei.appgallery.agd.common.flavor.IFlavorConfig
        public boolean isMediaManager() {
            return false;
        }

        @Override // com.huawei.appgallery.agd.common.flavor.IFlavorConfig
        public boolean isPrintLog(int i10) {
            return i10 > 3;
        }

        @Override // com.huawei.appgallery.agd.common.flavor.IFlavorConfig
        public boolean shouldCancelWhenWebSslError() {
            return true;
        }

        @Override // com.huawei.appgallery.agd.common.flavor.IFlavorConfig
        public boolean shouldRestrictUrlScheme() {
            return true;
        }
    }

    public static IFlavorConfig getConfig() {
        if (f27337a == null) {
            f27337a = new EnvOnlineFlavorConfig();
        }
        return f27337a;
    }

    public static String getGrsServerNameV2() {
        return "com.huawei.cloud.agdsdkV02";
    }

    public static String getQuickCardUrl() {
        return "";
    }
}
