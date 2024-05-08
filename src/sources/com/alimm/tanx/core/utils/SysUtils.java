package com.alimm.tanx.core.utils;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.orange.OrangeManager;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.wangmai.appsdkdex.R$dimen;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SysUtils implements NotConfused {
    public static final String TAG = "SysUtils";

    public static boolean checkUrlSuffixAndValid(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            LogUtils.d("checkUrlSuffix", "url为空");
            return true;
        }
        int indexOf = str.indexOf(SymbolValues.QUESTION_EN_SYMBOL);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        int indexOf2 = str.indexOf("#");
        if (indexOf2 > 0) {
            str = str.substring(0, indexOf2);
        }
        String[] split2 = str.split("[\\\\/]");
        String str2 = (split2 == null || (split = split2[split2.length - 1].split("\\.")) == null || split.length < 1) ? "" : split[split.length - 1];
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return OrangeManager.getInstance().getWebSuffixWhiteSwitch(str2);
    }

    public static long currentTimeSecs() {
        return System.currentTimeMillis() / 1000;
    }

    public static List<String> getInstallStatus() {
        ArrayList arrayList = new ArrayList();
        HashMap<String, Boolean> installSwitch = OrangeManager.getInstance().getInstallSwitch();
        if (OrangeManager.getInstance().getInstallSwitch() != null) {
            for (Map.Entry<String, Boolean> entry : installSwitch.entrySet()) {
                if (entry.getValue() != null && entry.getValue().booleanValue() && !TextUtils.isEmpty(entry.getKey()) && hasPackage(TanxCoreSdk.getApplication(), entry.getKey())) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        return arrayList;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier <= 0) {
                identifier = R$dimen.default_status_bar_height;
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("System StatusBar height : ");
            sb2.append(dimensionPixelSize);
            return dimensionPixelSize;
        } catch (Exception unused) {
            return context.getResources().getDimensionPixelSize(R$dimen.default_status_bar_height);
        }
    }

    public static int getStatusBarHeight2WebView(Context context) {
        int statusbarHeight = getStatusbarHeight(context);
        int i10 = statusbarHeight > 0 ? statusbarHeight - 58 : 0;
        if (i10 <= 0) {
            return 0;
        }
        return i10;
    }

    public static int getStatusbarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean hasPackage(Context context, String str) {
        if (context == null || str == null) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 256);
            return true;
        } catch (Exception unused) {
            LogUtils.d("hasPackage", str + " not fount app");
            return false;
        }
    }

    public static boolean isValidUrl(String str) {
        try {
            URI uri = new URI(str.replaceAll("\\\\", "").trim());
            if (uri.getHost() == null) {
                return false;
            }
            return uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https");
        } catch (URISyntaxException e2) {
            LogUtils.e(e2);
            return false;
        }
    }
}
