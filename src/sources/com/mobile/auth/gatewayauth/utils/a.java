package com.mobile.auth.gatewayauth.utils;

import android.text.TextUtils;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f37377a = true;

    public static String a() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static String a(int i10) {
        try {
            if (i10 == 0) {
                return a();
            }
            return a() + "-" + i10 + "-" + (Calendar.getInstance().get(11) / i10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static String a(String str, String str2) {
        try {
            HashMap hashMap = new HashMap(2);
            hashMap.put("code", str);
            hashMap.put("msg", str2);
            return new JSONObject(hashMap).toString();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static String a(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || str2.length() != 1 || str3.length() != 1) {
                return str;
            }
            Pattern compile = Pattern.compile("[<>()《》【】『』\\[\\]（）\"]");
            Matcher matcher = compile.matcher(str2);
            Matcher matcher2 = compile.matcher(str3);
            if (!matcher.find() || !matcher2.find()) {
                return str;
            }
            return str2 + str + str3;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static boolean a(String str) {
        try {
            return a().equals(str);
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
}
