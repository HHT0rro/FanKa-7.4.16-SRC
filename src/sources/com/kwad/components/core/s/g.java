package com.kwad.components.core.s;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import java.lang.reflect.Field;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {
    public static void destroyActivity(Context context, Window window) {
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        destroyWebViewInTree(decorView);
        fixInputMethodManagerLeak(context, decorView);
    }

    public static void destroyFragment(Context context, View view) {
        destroyWebViewInTree(view);
        fixInputMethodManagerLeak(context, view);
    }

    private static synchronized void destroyWebViewInTree(View view) {
        synchronized (g.class) {
            if (view == null) {
                return;
            }
            if (view instanceof WebView) {
                try {
                    ((WebView) view).destroy();
                } catch (Throwable unused) {
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    destroyWebViewInTree(viewGroup.getChildAt(i10));
                }
            }
        }
    }

    private static void fixInputMethodManagerLeak(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context == null || view == null || Build.VERSION.SDK_INT >= 29 || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        for (int i10 = 0; i10 < 3; i10++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i10]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if (!(obj instanceof View)) {
                    continue;
                } else if (!context.equals(((View) obj).getContext())) {
                    return;
                } else {
                    declaredField.set(inputMethodManager, null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}