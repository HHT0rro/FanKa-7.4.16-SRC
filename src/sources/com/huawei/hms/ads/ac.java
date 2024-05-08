package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface ac {
    Context Code(Context context);

    f.a Code();

    Object Code(Context context, String str);

    void Code(Activity activity);

    void Code(String str);

    void V(String str);

    void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback);
}
