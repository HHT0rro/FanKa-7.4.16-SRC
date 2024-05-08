package com.huawei.quickcard.video.utils;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Locale;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FullScreenUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34362a = "FullScreenUtils";

    /* renamed from: b, reason: collision with root package name */
    private static final String f34363b = "config_showNavigationBar";

    /* renamed from: c, reason: collision with root package name */
    private static final String f34364c = "bool";

    /* renamed from: d, reason: collision with root package name */
    private static final String f34365d = "android";

    private static void a(Context context, boolean z10) {
        ActionBar actionBar;
        AppCompatActivity appCompActivity = getAppCompActivity(context);
        if (appCompActivity != null) {
            androidx.appcompat.app.ActionBar supportActionBar = appCompActivity.getSupportActionBar();
            if (supportActionBar != null) {
                if (z10) {
                    if (supportActionBar.isShowing()) {
                        return;
                    }
                    supportActionBar.setShowHideAnimationEnabled(false);
                    supportActionBar.show();
                    return;
                }
                if (supportActionBar.isShowing()) {
                    supportActionBar.setShowHideAnimationEnabled(false);
                    supportActionBar.hide();
                    return;
                }
                return;
            }
            return;
        }
        Activity scanForActivity = scanForActivity(context);
        if (scanForActivity == null || (actionBar = scanForActivity.getActionBar()) == null) {
            return;
        }
        if (z10) {
            if (actionBar.isShowing()) {
                return;
            }
            actionBar.show();
        } else if (actionBar.isShowing()) {
            actionBar.hide();
        }
    }

    public static boolean actionbarIsShow(Context context) {
        AppCompatActivity appCompActivity = getAppCompActivity(context);
        if (appCompActivity == null) {
            Activity scanForActivity = scanForActivity(context);
            return (scanForActivity == null || scanForActivity.getActionBar() == null || !scanForActivity.getActionBar().isShowing()) ? false : true;
        }
        androidx.appcompat.app.ActionBar supportActionBar = appCompActivity.getSupportActionBar();
        return supportActionBar != null && supportActionBar.isShowing();
    }

    private static void b(Context context, boolean z10) {
        if (b(context)) {
            Context a10 = a(context);
            if (a10 instanceof Activity) {
                View decorView = ((Activity) a10).getWindow().getDecorView();
                int systemUiVisibility = decorView.getSystemUiVisibility();
                decorView.setSystemUiVisibility(z10 ? systemUiVisibility & (-4099) : systemUiVisibility | 4098);
            }
        }
    }

    private static void c(Context context, boolean z10) {
        if (a(context) instanceof Activity) {
            Activity activity = (Activity) context;
            if (z10) {
                activity.getWindow().clearFlags(1024);
            } else {
                activity.getWindow().setFlags(1024, 1024);
            }
        }
    }

    public static AppCompatActivity getAppCompActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (context instanceof ContextWrapper) {
            Context a10 = a(context);
            if (a10 instanceof AppCompatActivity) {
                return (AppCompatActivity) a10;
            }
        }
        return null;
    }

    public static int getScreenDegree(@NonNull Activity activity) {
        int screenRotate = getScreenRotate(activity);
        if (screenRotate != 1) {
            return screenRotate != 3 ? 0 : 90;
        }
        return 270;
    }

    public static int getScreenRotate(@NonNull Activity activity) {
        return activity.getWindowManager().getDefaultDisplay().getRotation();
    }

    public static boolean hasStatusBar(Context context) {
        if (!(a(context) instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        return ((activity.getWindow().getAttributes().flags & 1024) == 1024 || (activity.getWindow().getDecorView().getSystemUiVisibility() & 4) == 4) ? false : true;
    }

    public static void hideNavigationBar(Context context) {
        b(context, false);
    }

    public static void hideStatusBar(Context context) {
        a(context, false);
    }

    public static boolean isScreenOrientationPortrait(Context context) {
        Resources resources;
        Configuration configuration;
        return (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 1) ? false : true;
    }

    public static Activity scanForActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context a10 = a(context);
            if (a10 instanceof Activity) {
                return (Activity) a10;
            }
        } else {
            CardLogUtils.d(f34362a, "Other cases of context");
        }
        return null;
    }

    public static void setControllerRotation(View view, int i10) {
        if (view == null) {
            return;
        }
        float rotation = view.getRotation();
        float f10 = i10;
        if (Math.abs(f10 - rotation) > 0.001d) {
            view.setRotation(f10);
            int width = view.getWidth();
            int height = view.getHeight();
            if (f10 == 0.0f) {
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
            } else if (Math.abs(rotation - f10) % 180.0f == 0.0f) {
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
            } else if (i10 % 180 != 0) {
                if (a()) {
                    view.setTranslationX((height - width) / 2.0f);
                } else {
                    view.setTranslationX((width - height) / 2.0f);
                }
                view.setTranslationY((height - width) / 2.0f);
            } else {
                CardLogUtils.d("do not need change");
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                if (i10 % 180 != 0) {
                    layoutParams.height = width;
                    layoutParams.width = height;
                } else {
                    layoutParams.height = height;
                    layoutParams.width = width;
                }
            }
            view.requestLayout();
        }
    }

    public static void setWindowFullScreenState(Context context, boolean z10, boolean z11, boolean z12) {
        if (context == null) {
            return;
        }
        if (z10) {
            if (z11) {
                hideStatusBar(context);
            }
            if (z12) {
                c(context, false);
            }
            hideNavigationBar(context);
            return;
        }
        if (z11) {
            showStatusBar(context);
        }
        if (z12) {
            c(context, true);
        }
        showNavigationBar(context);
    }

    public static void showNavigationBar(Context context) {
        b(context, true);
    }

    public static void showStatusBar(Context context) {
        a(context, true);
    }

    private static boolean b(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(f34363b, f34364c, "android");
        if (identifier > 0) {
            return resources.getBoolean(identifier);
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object invoke = cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "qemu.hw.mainkeys");
            if (invoke instanceof String) {
                String str = (String) invoke;
                if (!"1".equals(str)) {
                    if ("0".equals(str)) {
                        return true;
                    }
                    CardLogUtils.d(f34362a, "Other cases.");
                }
            }
        } catch (RuntimeException unused) {
            CardLogUtils.d("No NavigationBar.");
        } catch (Exception unused2) {
            CardLogUtils.d("No NavigationBar.");
        }
        return false;
    }

    private static Context a(Context context) {
        return (!(context instanceof Activity) && (context instanceof ContextWrapper)) ? a(((ContextWrapper) context).getBaseContext()) : context;
    }

    private static boolean a() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }
}
