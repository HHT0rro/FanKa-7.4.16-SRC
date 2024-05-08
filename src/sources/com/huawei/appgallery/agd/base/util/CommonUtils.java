package com.huawei.appgallery.agd.base.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.utils.AESUtil;
import com.huawei.appgallery.agd.common.utils.Base64;
import com.huawei.appgallery.agd.common.utils.ByteUtil;
import com.huawei.appgallery.agd.common.utils.PackageKit;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import j9.a;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CommonUtils {
    /* JADX WARN: Multi-variable type inference failed */
    public static String getCallerAppSigns(String str, Context context) {
        Signature[] signatureArr;
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        if (StringUtils.isEmpty(str)) {
            return sb2.toString();
        }
        PackageInfo packageInfo = PackageKit.getPackageInfo(str, context);
        if (packageInfo != null && (signatureArr = packageInfo.signatures) != null) {
            for (Signature signature : signatureArr) {
                String sha256EncryptStr = AESUtil.sha256EncryptStr(Base64.encode(ByteUtil.hexToBytes(signature.toCharsString())));
                if (!StringUtils.isEmpty(sha256EncryptStr)) {
                    arrayList.add(sha256EncryptStr.toLowerCase(Locale.getDefault()));
                }
            }
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            sb2.append((String) arrayList.get(i10));
            if (i10 != arrayList.size() - 1) {
                sb2.append(",");
            }
        }
        return sb2.toString();
    }

    public static boolean hasAppInstalled(@NonNull Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 16384) != null;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            a.f50348d.d("CommonUtils", "hasAppInstalled: " + str + "  not find");
            return false;
        }
    }

    public static boolean hasParseException(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            intent.getStringExtra("TestIntent");
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }
}
