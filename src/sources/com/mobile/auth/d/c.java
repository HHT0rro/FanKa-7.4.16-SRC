package com.mobile.auth.d;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.security.MessageDigest;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36756a = "com.mobile.auth.d.c";

    /* renamed from: b, reason: collision with root package name */
    private static String f36757b = "";

    public static String a() {
        try {
            String uuid = UUID.randomUUID().toString();
            try {
                uuid = UUID.nameUUIDFromBytes((uuid + System.currentTimeMillis() + Math.random()).getBytes("utf8")).toString();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return !TextUtils.isEmpty(uuid) ? uuid.replace("-", "") : uuid;
        } catch (Throwable th2) {
            try {
                ExceptionProcessor.processException(th2);
                return null;
            } catch (Throwable th3) {
                ExceptionProcessor.processException(th3);
                return null;
            }
        }
    }

    public static String a(Context context) {
        try {
            if (TextUtils.isEmpty(f36757b)) {
                String b4 = b(context);
                f36757b = b4;
                if (TextUtils.isEmpty(b4)) {
                    String c4 = c(context);
                    f36757b = c4;
                    a(context, c4);
                }
            }
            return f36757b;
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

    private static String a(String str) {
        try {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            try {
                byte[] bytes = str.getBytes();
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bytes);
                byte[] digest = messageDigest.digest();
                char[] cArr2 = new char[digest.length * 2];
                int i10 = 0;
                for (byte b4 : digest) {
                    int i11 = i10 + 1;
                    cArr2[i10] = cArr[(b4 >>> 4) & 15];
                    i10 = i11 + 1;
                    cArr2[i11] = cArr[b4 & 15];
                }
                return new String(cArr2);
            } catch (Exception unused) {
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

    private static void a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && context != null) {
                b.a(context, "key_d_i_u", str);
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private static String b(Context context) {
        try {
            return b.b(context, "key_d_i_u", "");
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

    private static String c(Context context) {
        try {
            String uuid = UUID.randomUUID().toString();
            return TextUtils.isEmpty(uuid) ? "default" : a(uuid + "default");
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return "default";
            } catch (Throwable th2) {
                try {
                    ExceptionProcessor.processException(th2);
                    return null;
                } catch (Throwable th3) {
                    ExceptionProcessor.processException(th3);
                    return null;
                }
            }
        }
    }
}
