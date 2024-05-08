package com.huawei.hms.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsSession;
import com.huawei.hms.ads.base.R;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class lc {
    private static final int B = 1;
    private static final int C = 110002100;
    private static final String Code = "HwCustomTabsHelper";
    private static final String D = "com.huawei.browser.cct_page_can_go_back";
    private static final String F = "com.huawei.browser.cct_only_show_title";
    private static final String I = "com.android.browser";
    private static final String L = "com.huawei.browser.cct_horizontal_menu_items";
    private static final int S = 110008300;
    private static final String V = "com.huawei.browser";
    private static final String Z = "cct_extension_version";

    /* renamed from: a, reason: collision with root package name */
    private static final String f29355a = "com.huawei.browser.cct_vertical_menu_items";

    /* renamed from: b, reason: collision with root package name */
    private static final String f29356b = "com.huawei.browser.cct_auto_refresh";

    /* renamed from: c, reason: collision with root package name */
    private static final String f29357c = "com.huawei.browser.cct_emui_style";

    /* renamed from: d, reason: collision with root package name */
    private static final String f29358d = "com.huawei.browser.cct_enable_pps";

    /* renamed from: e, reason: collision with root package name */
    private static final String f29359e = "com.huawei.browser.cct_show_open_in_browser_menu";

    /* renamed from: f, reason: collision with root package name */
    private static final String f29360f = "com.huawei.browser.cct_copy_link";

    /* renamed from: g, reason: collision with root package name */
    private static final String f29361g = "com.huawei.browser.cct_tranlate_disable";

    /* renamed from: h, reason: collision with root package name */
    private static final lc f29362h = new lc();

    private lc() {
    }

    private static boolean B(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        if (!Code(context, "com.android.browser", S)) {
            gl.V(Code, "isSupportAndroidCustomizedCustom current browser no support");
            return false;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo("com.android.browser", 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                int i10 = bundle != null ? bundle.getInt(Z, 0) : 0;
                gl.V(Code, "isSupportAndroidCustomizedCustom: " + i10);
                return i10 >= 1;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            gl.Z(Code, "getApplicationInfo failed due to name not found");
        }
        return false;
    }

    private CustomTabsIntent Code(@NonNull Activity activity, boolean z10) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(V());
        CustomTabsIntent build = builder.build();
        builder.setCloseButtonIcon(BitmapFactory.decodeResource(activity.getResources(), R.drawable.hiad_hm_close_btn));
        builder.addDefaultShareMenuItem();
        build.intent.putExtra(F, true);
        build.intent.putExtra(D, true);
        build.intent.putExtra(f29356b, true);
        build.intent.putExtra(f29357c, true);
        build.intent.putExtra(f29359e, false);
        build.intent.putExtra(f29358d, z10);
        build.intent.putExtra(f29360f, true);
        build.intent.putExtra(f29361g, true);
        ArrayList<String> arrayList = new ArrayList<>(10);
        arrayList.add(ld.REFRESH.Code());
        build.intent.putStringArrayListExtra(f29355a, arrayList);
        build.intent.putStringArrayListExtra(L, new ArrayList<>(10));
        return build;
    }

    public static synchronized lc Code() {
        lc lcVar;
        synchronized (lc.class) {
            lcVar = f29362h;
        }
        return lcVar;
    }

    public static boolean Code(@NonNull Context context) {
        try {
            if (!I(context)) {
                if (!Z(context)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            gl.I(Code, "not support customTab");
            return false;
        }
    }

    private static boolean Code(@NonNull Context context, String str, int i10) {
        PackageManager packageManager;
        if (TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 16384);
            return (packageInfo != null ? packageInfo.versionCode : 0) >= i10;
        } catch (PackageManager.NameNotFoundException unused) {
            gl.Z(Code, "getTargetApkInfo failed due to name not found");
            return false;
        }
    }

    private static boolean I(@NonNull Context context) {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add("com.huawei.browser");
        return "com.huawei.browser".equals(CustomTabsClient.getPackageName(context, arrayList, true)) && Code(context, "com.huawei.browser", C);
    }

    private static Activity V(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return V(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private static boolean Z(@NonNull Context context) {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add("com.android.browser");
        return "com.android.browser".equals(CustomTabsClient.getPackageName(context, arrayList, true)) && B(context);
    }

    public void Code(@NonNull Context context, @NonNull Uri uri, boolean z10) {
        gl.Code(Code, "openCustomTab begin");
        Activity V2 = V(context);
        boolean I2 = I(V2);
        CustomTabsIntent Code2 = Code(V2, z10);
        Code2.intent.setPackage(I2 ? "com.huawei.browser" : "com.android.browser");
        Code2.intent.setData(uri);
        try {
            if (Code2.intent != null) {
                Code2.intent.setClipData(com.huawei.openalliance.ad.constant.u.cG);
            }
            V2.startActivityForResult(Code2.intent, 0);
        } catch (ActivityNotFoundException unused) {
            gl.Z(Code, "openCustomTab ActivityNotFoundException");
        }
    }

    public CustomTabsSession V() {
        return null;
    }
}
