package com.kwad.sdk.crash.report;

import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class c implements e {
    private ArrayList<a> aHe = new ArrayList<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private ExceptionMessage aHf;
        private int aHg;

        public a(ExceptionMessage exceptionMessage, int i10) {
            this.aHf = exceptionMessage;
            this.aHg = i10;
        }
    }

    private void HY() {
        if (this.aHe.isEmpty()) {
            return;
        }
        try {
            Iterator<a> iterator2 = this.aHe.iterator2();
            while (iterator2.hasNext()) {
                a next = iterator2.next();
                b(next.aHf, next.aHg, null);
                iterator2.remove();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    private void b(ExceptionMessage exceptionMessage, int i10, @Nullable CountDownLatch countDownLatch) {
        if (exceptionMessage == null || !c(exceptionMessage)) {
            return;
        }
        if (i10 == 3) {
            com.kwad.sdk.crash.report.a.b(exceptionMessage);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.d(exceptionMessage));
        com.kwad.sdk.crash.report.request.b.a(arrayList, countDownLatch);
    }

    private boolean c(ExceptionMessage exceptionMessage) {
        try {
            com.kwad.sdk.crash.e Hu = com.kwad.sdk.crash.e.Hu();
            if (Hu.Hz() != null && Hu.Hy() != 2) {
                List<com.kwad.sdk.crash.a> list = Hu.Hz().aFy;
                double d10 = Hu.Hz().aFb;
                String appId = Hu.getAppId();
                String sdkVersion = Hu.getSdkVersion();
                for (com.kwad.sdk.crash.a aVar : list) {
                    if (aVar != null && (com.kwad.sdk.crash.utils.c.b(aVar.aEY) || aVar.aEY.contains(appId))) {
                        if (com.kwad.sdk.crash.utils.c.b(aVar.aEZ) || aVar.aEZ.contains(sdkVersion)) {
                            if (com.kwad.sdk.crash.utils.c.b(aVar.aFa) || a(exceptionMessage.mCrashDetail, aVar.aFa)) {
                                d10 = aVar.aFb;
                            }
                        }
                    }
                }
                return Math.random() < d10;
            }
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.w("BaseExceptionUploader", Log.getStackTraceString(e2));
            return true;
        }
    }

    public final void a(ExceptionMessage exceptionMessage, int i10, @Nullable CountDownLatch countDownLatch) {
        try {
            HY();
            b(exceptionMessage, i10, countDownLatch);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            this.aHe.add(new a(exceptionMessage, i10));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    private static boolean a(String str, List<String> list) {
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (str.contains(iterator2.next())) {
                return true;
            }
        }
        return false;
    }
}
