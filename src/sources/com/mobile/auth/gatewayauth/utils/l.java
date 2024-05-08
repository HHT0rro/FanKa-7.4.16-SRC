package com.mobile.auth.gatewayauth.utils;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.ColorInt;
import com.mobile.auth.gatewayauth.ExceptionProcessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l {
    private static int a(View view, ViewGroup viewGroup) {
        int i10 = 0;
        while (i10 < viewGroup.getChildCount() && viewGroup.getChildAt(i10) != view) {
            try {
                i10++;
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return -1;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return -1;
                }
            }
        }
        return i10;
    }

    public static void a(Activity activity) {
        try {
            Window window = activity.getWindow();
            window.setFlags(1024, 1024);
            View childAt = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
            window.clearFlags(67108864);
            window.clearFlags(134217728);
            if (childAt != null) {
                childAt.setPadding(0, 0, 0, 0);
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static void a(Activity activity, @ColorInt int i10) {
        try {
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(i10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static void a(Activity activity, boolean z10) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                View decorView = activity.getWindow().getDecorView();
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (z10) {
                    if (systemUiVisibility == 0) {
                        systemUiVisibility = 8192;
                    } else if ((systemUiVisibility & 8192) == 0) {
                        systemUiVisibility |= 8192;
                    }
                } else if (systemUiVisibility == 8192) {
                    systemUiVisibility = 0;
                } else {
                    int i10 = systemUiVisibility & 8192;
                    if (i10 != 0) {
                        systemUiVisibility = i10;
                    }
                }
                decorView.setSystemUiVisibility(systemUiVisibility);
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static boolean a(int i10) {
        try {
            return Color.alpha(i10) == 0;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public static boolean a(View view) {
        try {
            try {
                Rect rect = new Rect();
                if (!(view.getGlobalVisibleRect(rect) && (rect.bottom - rect.top >= view.getMeasuredHeight()) && (rect.right - rect.left >= view.getMeasuredWidth()))) {
                    return true;
                }
                View view2 = view;
                while (view2.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2.getParent();
                    if (viewGroup.getVisibility() != 0) {
                        return true;
                    }
                    for (int a10 = a(view2, viewGroup) + 1; a10 < viewGroup.getChildCount(); a10++) {
                        Rect rect2 = new Rect();
                        view.getGlobalVisibleRect(rect2);
                        View childAt = viewGroup.getChildAt(a10);
                        Rect rect3 = new Rect();
                        childAt.getGlobalVisibleRect(rect3);
                        if (Rect.intersects(rect2, rect3)) {
                            return true;
                        }
                    }
                    view2 = viewGroup;
                }
                return false;
            } catch (Exception e2) {
                i.a(e2);
                return false;
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public static void b(Activity activity, @ColorInt int i10) {
        try {
            Window window = activity.getWindow();
            if (a(i10)) {
                window.clearFlags(134217728);
                window.getDecorView().setSystemUiVisibility(1792);
                window.addFlags(Integer.MIN_VALUE);
            } else {
                window.addFlags(Integer.MIN_VALUE);
                window.clearFlags(134217728);
            }
            window.setNavigationBarColor(i10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static boolean b(Activity activity) {
        try {
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            return rotation == 0 || rotation == 2;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public static void c(Activity activity, int i10) {
        try {
            Window window = activity.getWindow();
            View decorView = window.getDecorView();
            View childAt = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
            int i11 = 1024;
            if (i10 == 1) {
                i11 = 1;
            } else if (i10 != 1024) {
                i11 = 0;
            } else {
                ActionBar actionBar = activity.getActionBar();
                if (actionBar != null) {
                    actionBar.hide();
                }
            }
            window.clearFlags(67108864);
            window.clearFlags(134217728);
            if (childAt != null) {
                childAt.setFitsSystemWindows(false);
                childAt.setPadding(0, 0, 0, 0);
            }
            decorView.setSystemUiVisibility(i11);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
