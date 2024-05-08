package com.huawei.flexiblelayout.services.exposure.impl;

import android.view.View;
import android.view.ViewTreeObserver;
import com.huawei.flexiblelayout.log.Log;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AwaitViewLayout {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28522a = "AwaitViewLayout";

    /* renamed from: b, reason: collision with root package name */
    private static final long f28523b = 300;

    /* renamed from: c, reason: collision with root package name */
    private static final String f28524c = "LAYOUT_COMPUTED_TAG";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ViewPredicate {
        boolean test(View view);
    }

    public static void a(final View view, final ViewPredicate viewPredicate) {
        if (viewPredicate.test(view)) {
            return;
        }
        Boolean bool = (Boolean) com.huawei.flexiblelayout.common.d.a(view, f28524c, Boolean.class);
        if (bool == null || !bool.booleanValue()) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.flexiblelayout.services.exposure.impl.AwaitViewLayout.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (ViewPredicate.this.test(view)) {
                        com.huawei.flexiblelayout.common.d.a(view, AwaitViewLayout.f28524c, Boolean.TRUE);
                        countDownLatch.countDown();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            try {
                if (!countDownLatch.await(300L, TimeUnit.MILLISECONDS)) {
                    Log.w(f28522a, "wait layout timeout!");
                }
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
                } else {
                    Log.w(f28522a, "viewTreeObserver not alive");
                }
            } catch (InterruptedException unused) {
                Log.w(f28522a, "wait layout interrupted!");
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
                } else {
                    Log.w(f28522a, "viewTreeObserver not alive");
                }
            }
        }
    }
}
