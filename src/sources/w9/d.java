package w9;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.appgallery.coreservice.api.ConnectConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d {
    public static Intent a(String str, ConnectConfig connectConfig) {
        Intent intent = new Intent(b(connectConfig));
        intent.setPackage(str);
        return intent;
    }

    public static String b(ConnectConfig connectConfig) {
        return (connectConfig == null || TextUtils.isEmpty(connectConfig.getConnectServiceAction())) ? "com.huawei.appmarket.service.intent.ACTION_CORE_SERVICE" : connectConfig.getConnectServiceAction();
    }
}
