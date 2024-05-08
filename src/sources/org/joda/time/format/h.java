package org.joda.time.format;

import java.io.IOException;

/* compiled from: FormatUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final double f52610a = Math.log(10.0d);

    public static void a(Appendable appendable, int i10, int i11) throws IOException {
        int log;
        if (i10 < 0) {
            appendable.append('-');
            if (i10 == Integer.MIN_VALUE) {
                while (i11 > 10) {
                    appendable.append('0');
                    i11--;
                }
                appendable.append("2147483648");
                return;
            }
            i10 = -i10;
        }
        if (i10 < 10) {
            while (i11 > 1) {
                appendable.append('0');
                i11--;
            }
            appendable.append((char) (i10 + 48));
            return;
        }
        if (i10 < 100) {
            while (i11 > 2) {
                appendable.append('0');
                i11--;
            }
            int i12 = ((i10 + 1) * 13421772) >> 27;
            appendable.append((char) (i12 + 48));
            appendable.append((char) (((i10 - (i12 << 3)) - (i12 << 1)) + 48));
            return;
        }
        if (i10 < 1000) {
            log = 3;
        } else {
            log = i10 < 10000 ? 4 : ((int) (Math.log(i10) / f52610a)) + 1;
        }
        while (i11 > log) {
            appendable.append('0');
            i11--;
        }
        appendable.append(Integer.toString(i10));
    }

    public static void b(StringBuffer stringBuffer, int i10, int i11) {
        try {
            a(stringBuffer, i10, i11);
        } catch (IOException unused) {
        }
    }

    public static void c(Appendable appendable, int i10) throws IOException {
        if (i10 < 0) {
            appendable.append('-');
            if (i10 == Integer.MIN_VALUE) {
                appendable.append("2147483648");
                return;
            }
            i10 = -i10;
        }
        if (i10 < 10) {
            appendable.append((char) (i10 + 48));
        } else {
            if (i10 < 100) {
                int i11 = ((i10 + 1) * 13421772) >> 27;
                appendable.append((char) (i11 + 48));
                appendable.append((char) (((i10 - (i11 << 3)) - (i11 << 1)) + 48));
                return;
            }
            appendable.append(Integer.toString(i10));
        }
    }

    public static void d(Appendable appendable, long j10) throws IOException {
        int i10 = (int) j10;
        if (i10 == j10) {
            c(appendable, i10);
        } else {
            appendable.append(Long.toString(j10));
        }
    }

    public static void e(StringBuffer stringBuffer, int i10) {
        try {
            c(stringBuffer, i10);
        } catch (IOException unused) {
        }
    }

    public static void f(StringBuffer stringBuffer, long j10) {
        try {
            d(stringBuffer, j10);
        } catch (IOException unused) {
        }
    }

    public static int g(long j10) {
        if (j10 < 0) {
            if (j10 != Long.MIN_VALUE) {
                return g(-j10) + 1;
            }
            return 20;
        }
        if (j10 < 10) {
            return 1;
        }
        if (j10 < 100) {
            return 2;
        }
        if (j10 < 1000) {
            return 3;
        }
        if (j10 < 10000) {
            return 4;
        }
        return 1 + ((int) (Math.log(j10) / f52610a));
    }

    public static String h(String str, int i10) {
        int i11 = i10 + 32;
        String concat = str.length() <= i11 + 3 ? str : str.substring(0, i11).concat("...");
        if (i10 <= 0) {
            return "Invalid format: \"" + concat + '\"';
        }
        if (i10 >= str.length()) {
            return "Invalid format: \"" + concat + "\" is too short";
        }
        return "Invalid format: \"" + concat + "\" is malformed at \"" + concat.substring(i10) + '\"';
    }

    public static int i(CharSequence charSequence, int i10) {
        int charAt = charSequence.charAt(i10) - '0';
        return (((charAt << 3) + (charAt << 1)) + charSequence.charAt(i10 + 1)) - 48;
    }
}
