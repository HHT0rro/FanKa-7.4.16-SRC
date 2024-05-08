package com.alibaba.security.realidentity.build;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.realidentity.RPVerifyCheckEnvException;
import java.util.TimeZone;

/* compiled from: Checker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class hh {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3840a = "hh";

    public static boolean a(Context context, String str) {
        return context.getResources().getIdentifier("yw_1222_".concat(String.valueOf(str)), "drawable", context.getPackageName()) > 0;
    }

    private static boolean b() {
        return CommonUtils.checkWindVaneExist();
    }

    private static boolean a() {
        try {
            TimeZone timeZone = JSON.defaultTimeZone;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static void a(Context context) throws RPVerifyCheckEnvException {
        if (CommonUtils.checkWindVaneExist()) {
            if (hl.a(context, "libc++_shared.so")) {
                if (!hl.a(context, "libALBiometricsJni.so")) {
                    throw RPVerifyCheckEnvException.create("检查 libALBiometricsJni.so 是否集成");
                }
                return;
            }
            throw RPVerifyCheckEnvException.create("检查 libc++_shared.so 是否集成");
        }
        throw RPVerifyCheckEnvException.create("检查 windvane 是否依赖");
    }
}
