package org.joda.time;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class IllegalInstantException extends IllegalArgumentException {
    private static final long serialVersionUID = 2858712538216L;

    public IllegalInstantException(String str) {
        super(str);
    }

    private static String createMessage(long j10, String str) {
        String str2;
        String k10 = org.joda.time.format.a.b("yyyy-MM-dd'T'HH:mm:ss.SSS").k(new Instant(j10));
        if (str != null) {
            str2 = " (" + str + ")";
        } else {
            str2 = "";
        }
        return "Illegal instant due to time zone offset transition (daylight savings time 'gap'): " + k10 + str2;
    }

    public static boolean isIllegalInstant(Throwable th) {
        if (th instanceof IllegalInstantException) {
            return true;
        }
        if (th.getCause() == null || th.getCause() == th) {
            return false;
        }
        return isIllegalInstant(th.getCause());
    }

    public IllegalInstantException(long j10, String str) {
        super(createMessage(j10, str));
    }
}
