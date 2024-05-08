package com.qq.e.comm.managers.status;

import com.android.internal.logging.nano.MetricsProto;
import com.qq.e.comm.managers.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SDKStatus {
    public static final int SDK_CHANNEL = 1;
    public static final String SDK_EX1 = "";
    public static final String SDK_EX2 = "";
    public static final int STUB_IDENTITY = 1;
    public static final boolean isNoPlugin = false;

    public static final int getBuildInPluginVersion() {
        return MetricsProto.MetricsEvent.FIELD_PLUG_TYPE;
    }

    public static final String getIntegrationSDKVersion() {
        return "4.551." + getBuildInPluginVersion();
    }

    public static final int getPluginVersion() {
        if (b.b().d()) {
            return b.b().c().getPluginVersion();
        }
        return 0;
    }

    public static final String getSDKVersion() {
        return "4.551";
    }
}
