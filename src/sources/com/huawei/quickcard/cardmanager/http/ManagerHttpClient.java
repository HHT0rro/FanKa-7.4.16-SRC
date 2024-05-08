package com.huawei.quickcard.cardmanager.http;

import android.content.Context;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface ManagerHttpClient {
    ManagerHttpResponse request(Context context, ManagerHttpRequest managerHttpRequest) throws IOException;
}
