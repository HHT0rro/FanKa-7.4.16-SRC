package com.kwad.sdk.n;

import android.app.Application;
import android.content.Context;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j {
    /* JADX WARN: Multi-variable type inference failed */
    public static Context aq(Context context) {
        return ((ResContext) context).getDelegatedContext();
    }

    public static boolean ar(Context context) {
        return context instanceof ResContext;
    }

    public static Context dl(Context context) {
        Context applicationContext = unwrapContextIfNeed(context).getApplicationContext();
        if (applicationContext instanceof Application) {
            return applicationContext;
        }
        for (int i10 = 0; i10 < 10; i10++) {
            applicationContext = applicationContext.getApplicationContext();
            if (applicationContext instanceof Application) {
                return applicationContext;
            }
            if (ar(applicationContext)) {
                applicationContext = aq(applicationContext);
            }
        }
        return applicationContext;
    }

    public static void onDestroy(Context context) {
        Wrapper.onDestroy(context);
    }

    public static Context unwrapContextIfNeed(Context context) {
        if (ar(context)) {
            context = aq(context);
        }
        if (!ar(context)) {
            return context;
        }
        RuntimeException runtimeException = null;
        for (int i10 = 0; i10 < 10; i10++) {
            if (runtimeException == null) {
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).ys());
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            context = aq(context);
            if (!ar(context)) {
                return context;
            }
        }
        return context;
    }

    public static Context wrapContextIfNeed(Context context) {
        return Wrapper.wrapContextIfNeed(context);
    }
}
