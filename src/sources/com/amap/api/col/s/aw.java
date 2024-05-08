package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.huawei.appgallery.agd.common.constant.SymbolValues;

/* compiled from: StatisticsUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class aw {

    /* renamed from: a, reason: collision with root package name */
    public static ef f7134a;

    public static void a(Context context, String str, long j10, boolean z10) {
        try {
            String a10 = a(str, j10, z10);
            if (a10 != null && a10.length() > 0) {
                if (f7134a == null) {
                    f7134a = new ef(context, "sea", "9.7.0", "O002");
                }
                f7134a.a(a10);
                eg.a(f7134a, context);
            }
        } catch (Throwable th) {
            n.a(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    private static String a(String str, long j10, boolean z10) {
        try {
            return "{\"RequestPath\":\"" + str + "\",\"ResponseTime\":" + j10 + ",\"Success\":" + z10 + com.alipay.sdk.util.i.f4738d;
        } catch (Throwable th) {
            n.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    public static void a(String str, String str2, AMapException aMapException) {
        if (str != null) {
            String errorType = aMapException.getErrorType();
            String a10 = a(aMapException);
            if (a10 == null || a10.length() <= 0) {
                return;
            }
            df.a(m.a(true), str, errorType, str2, a10);
        }
    }

    private static String a(AMapException aMapException) {
        if (aMapException == null) {
            return null;
        }
        if (aMapException.getErrorLevel() == 0) {
            int errorCode = aMapException.getErrorCode();
            if (errorCode == 0) {
                return "4";
            }
            int pow = (int) Math.pow(10.0d, Math.floor(Math.log10(errorCode)));
            return String.valueOf((errorCode % pow) + (pow * 4));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(aMapException.getErrorCode());
        return sb2.toString();
    }

    public static void a(Context context, String str, boolean z10) {
        try {
            String a10 = a(str, z10);
            if (a10 != null && a10.length() > 0) {
                ef efVar = new ef(context, "sea", "9.7.0", "O006");
                efVar.a(a10);
                eg.a(efVar, context);
            }
        } catch (Throwable th) {
            n.a(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    private static String a(String str, boolean z10) {
        String str2;
        try {
            str2 = "";
            int indexOf = str.indexOf(SymbolValues.QUESTION_EN_SYMBOL);
            int length = str.length();
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                int i10 = indexOf + 1;
                str2 = i10 < length ? str.substring(i10) : "";
                str = substring;
            }
            return "{\"RequestPath\":\"" + str + "\",\"RequestParm\":\"" + str2 + "\",\"IsCacheRequest\":" + z10 + com.alipay.sdk.util.i.f4738d;
        } catch (Throwable th) {
            n.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }
}
