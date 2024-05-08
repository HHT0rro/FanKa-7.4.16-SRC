package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.crash.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static boolean F(@NonNull List<StackTraceElement[]> list) {
        Iterator<StackTraceElement[]> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (a(iterator2.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return false;
        }
        String[] Hv = e.Hu().Hv();
        if (Hv == null || Hv.length == 0) {
            return true;
        }
        boolean z10 = false;
        for (String str : Hv) {
            z10 = a(stackTraceElementArr, str);
            if (z10) {
                break;
            }
        }
        if (z10) {
            for (String str2 : e.Hu().Hw()) {
                if (b(stackTraceElementArr, str2)) {
                    return false;
                }
            }
        }
        return z10;
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AdExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                return true;
            }
        }
        return false;
    }

    public static boolean o(@NonNull Throwable th) {
        ArrayList arrayList = new ArrayList(5);
        for (int i10 = 0; i10 < 5; i10++) {
            arrayList.add(th.getStackTrace());
            th = th.getCause();
            if (th == null) {
                break;
            }
        }
        return F(arrayList);
    }

    private static boolean a(@NonNull StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AdExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                return true;
            }
        }
        return false;
    }
}
