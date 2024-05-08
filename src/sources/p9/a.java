package p9;

import com.huawei.appgallery.agd.common.FlavorApi;
import com.huawei.openalliance.ad.constant.u;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {
    public static boolean a(String str) {
        return "com.huawei.fastapp".equals(str) || u.aV.equals(str) || "com.huawei.hwid".equals(str) || FlavorApi.getConfig().isMediaManager();
    }
}
