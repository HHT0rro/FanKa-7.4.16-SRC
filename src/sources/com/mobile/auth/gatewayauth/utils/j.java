package com.mobile.auth.gatewayauth.utils;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static Pattern f37393a = Pattern.compile("^[-\\+]?[\\d]*$");

    public static String a(int i10) {
        try {
            return Integer.toHexString(i10);
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

    public static String a(long j10) {
        try {
            try {
                return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss.SSS").format(new Date(j10));
            } catch (Exception unused) {
                return String.valueOf(j10);
            }
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

    public static String a(Long l10, int i10) {
        try {
            return String.format("%0" + i10 + LanguageTag.PRIVATEUSE, Long.valueOf(l10.longValue()));
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

    public static String a(String str) {
        try {
            try {
                return new URL(str).getHost();
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                return null;
            }
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
}
