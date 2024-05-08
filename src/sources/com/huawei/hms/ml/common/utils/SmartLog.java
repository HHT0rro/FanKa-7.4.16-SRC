package com.huawei.hms.ml.common.utils;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SmartLog {
    private static final int LEN_CONST = 2;
    private static final Pattern M_PATTERN = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
    private static final char STAR = '*';

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class ThrowableWrapper extends Throwable {
        private static final long serialVersionUID = 7129050843360571879L;
        private String message;
        private Throwable ownerThrowable;
        private Throwable thisCause;

        public ThrowableWrapper(Throwable th) {
            this.ownerThrowable = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            Throwable th = this.thisCause;
            if (th == this) {
                return null;
            }
            return th;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public void setCause(Throwable th) {
            this.thisCause = th;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th = this.ownerThrowable;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.message == null) {
                return name;
            }
            String str = name + ": ";
            if (this.message.startsWith(str)) {
                return this.message;
            }
            return str + this.message;
        }
    }

    public static void d(String str, String str2) {
    }

    public static void d(String str, String str2, String str3) {
    }

    public static void d(String str, String str2, String str3, Throwable th) {
    }

    public static void d(String str, String str2, Throwable th) {
    }

    public static void d(String str, String str2, Throwable th, boolean z10) {
    }

    public static void d(String str, String str2, boolean z10) {
    }

    public static void e(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        getLogMsg(str2, z10);
    }

    private static String formatLogWithStar(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i10 = 1;
        if (1 == length) {
            return String.valueOf(STAR);
        }
        StringBuilder sb2 = new StringBuilder(length);
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (M_PATTERN.matcher(String.valueOf(charAt)).matches()) {
                if (i10 % 2 == 0) {
                    charAt = STAR;
                }
                i10++;
            }
            sb2.append(charAt);
        }
        return sb2.toString();
    }

    private static String getLogMsg(String str, boolean z10) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z10) {
                sb2.append(formatLogWithStar(str));
            } else {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    private static Throwable getNewThrowable(Throwable th) {
        if (th == null) {
            return null;
        }
        ThrowableWrapper throwableWrapper = new ThrowableWrapper(th);
        throwableWrapper.setStackTrace(th.getStackTrace());
        throwableWrapper.setMessage(modifyExceptionMessage(th.getMessage()));
        Throwable cause = th.getCause();
        ThrowableWrapper throwableWrapper2 = throwableWrapper;
        while (cause != null) {
            ThrowableWrapper throwableWrapper3 = new ThrowableWrapper(cause);
            throwableWrapper3.setStackTrace(cause.getStackTrace());
            throwableWrapper3.setMessage(modifyExceptionMessage(cause.getMessage()));
            throwableWrapper2.setCause(throwableWrapper3);
            cause = cause.getCause();
            throwableWrapper2 = throwableWrapper3;
        }
        return throwableWrapper;
    }

    public static void i(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        getLogMsg(str2, z10);
    }

    private static String modifyExceptionMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i10 = 0; i10 < charArray.length; i10++) {
            if (i10 % 2 == 0) {
                charArray[i10] = STAR;
            }
        }
        return new String(charArray);
    }

    public static void w(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        getLogMsg(str2, z10);
    }

    public static void e(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        getLogMsg(str2, str3);
    }

    public static void i(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        getLogMsg(str2, str3);
    }

    public static void w(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        getLogMsg(str2, str3);
    }

    public static void e(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        getLogMsg(str2, str3);
        getNewThrowable(th);
    }

    public static void i(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        getLogMsg(str2, str3);
        getNewThrowable(th);
    }

    public static void w(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        getLogMsg(str2, str3);
        getNewThrowable(th);
    }

    private static String getLogMsg(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(formatLogWithStar(str2));
        }
        return sb2.toString();
    }

    public static void e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        getLogMsg(str2, false);
    }

    public static void i(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        getLogMsg(str2, false);
    }

    public static void w(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        getLogMsg(str2, false);
    }

    public static void e(String str, String str2, Throwable th, boolean z10) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        getLogMsg(str2, z10);
        getNewThrowable(th);
    }

    public static void i(String str, String str2, Throwable th, boolean z10) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        getLogMsg(str2, z10);
        getNewThrowable(th);
    }

    public static void w(String str, String str2, Throwable th, boolean z10) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        getLogMsg(str2, z10);
        getNewThrowable(th);
    }

    public static void e(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        getLogMsg(str2, false);
        getNewThrowable(th);
    }

    public static void i(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        getLogMsg(str2, false);
        getNewThrowable(th);
    }

    public static void w(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        getLogMsg(str2, false);
        getNewThrowable(th);
    }
}
