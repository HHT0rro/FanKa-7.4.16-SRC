package y9;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.appgallery.marketinstallerservice.api.BaseParamSpec;
import com.huawei.appgallery.marketinstallerservice.api.InstallCallback;
import com.huawei.appgallery.marketinstallerservice.api.InstallParamSpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface c extends aa.a {
    void a(@NonNull Activity activity, @NonNull InstallParamSpec installParamSpec, InstallCallback installCallback);

    void b(@NonNull Context context, @NonNull BaseParamSpec baseParamSpec, InstallCallback installCallback);
}
