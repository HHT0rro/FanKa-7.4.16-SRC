package com.huawei.serverrequest.api;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.hmf.tasks.Task;
import com.huawei.serverrequest.api.service.HttpService;
import com.huawei.serverrequest.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Executor {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f34791a;

    private static c a(@NonNull Context context) {
        if (f34791a == null) {
            synchronized (Executor.class) {
                if (f34791a == null) {
                    f34791a = new c(context);
                }
            }
        }
        return f34791a;
    }

    @NonNull
    public static Task<ServerResponse> execute(@NonNull Context context, @NonNull ServerRequest serverRequest) {
        return a(context).a(serverRequest);
    }

    public static void setHttpService(@NonNull Context context, HttpService httpService) {
        a(context).a(httpService);
    }
}
