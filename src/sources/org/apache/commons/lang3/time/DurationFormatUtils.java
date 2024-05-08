package org.apache.commons.lang3.time;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class DurationFormatUtils {
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";

    /* renamed from: y, reason: collision with root package name */
    public static final Object f52401y = "y";
    public static final Object M = "M";

    /* renamed from: d, reason: collision with root package name */
    public static final Object f52398d = "d";
    public static final Object H = "H";

    /* renamed from: m, reason: collision with root package name */
    public static final Object f52399m = "m";

    /* renamed from: s, reason: collision with root package name */
    public static final Object f52400s = t.f36222g;
    public static final Object S = ExifInterface.LATITUDE_SOUTH;

    public static String format(Token[] tokenArr, long j10, long j11, long j12, long j13, long j14, long j15, long j16, boolean z10) {
        int i10;
        int i11;
        Token[] tokenArr2 = tokenArr;
        StringBuilder sb2 = new StringBuilder();
        int length = tokenArr2.length;
        int i12 = 0;
        boolean z11 = false;
        while (i12 < length) {
            Token token = tokenArr2[i12];
            Object value = token.getValue();
            int count = token.getCount();
            if (value instanceof StringBuilder) {
                sb2.append(value.toString());
                i11 = length;
                i10 = i12;
            } else {
                if (value.equals(f52401y)) {
                    sb2.append(paddedValue(j10, z10, count));
                    i11 = length;
                    i10 = i12;
                } else {
                    if (value.equals(M)) {
                        i10 = i12;
                        sb2.append(paddedValue(j11, z10, count));
                    } else {
                        i10 = i12;
                        if (value.equals(f52398d)) {
                            sb2.append(paddedValue(j12, z10, count));
                        } else if (value.equals(H)) {
                            sb2.append(paddedValue(j13, z10, count));
                            i11 = length;
                        } else if (value.equals(f52399m)) {
                            sb2.append(paddedValue(j14, z10, count));
                            i11 = length;
                        } else {
                            if (value.equals(f52400s)) {
                                i11 = length;
                                sb2.append(paddedValue(j15, z10, count));
                                z11 = true;
                            } else {
                                i11 = length;
                                if (value.equals(S)) {
                                    if (z11) {
                                        sb2.append(paddedValue(j16, true, z10 ? Math.max(3, count) : 3));
                                    } else {
                                        sb2.append(paddedValue(j16, z10, count));
                                    }
                                    z11 = false;
                                }
                            }
                            i12 = i10 + 1;
                            length = i11;
                            tokenArr2 = tokenArr;
                        }
                    }
                    i11 = length;
                }
                z11 = false;
            }
            i12 = i10 + 1;
            length = i11;
            tokenArr2 = tokenArr;
        }
        return sb2.toString();
    }

    public static String formatDuration(long j10, String str) {
        return formatDuration(j10, str, true);
    }

    public static String formatDurationHMS(long j10) {
        return formatDuration(j10, "HH:mm:ss.SSS");
    }

    public static String formatDurationISO(long j10) {
        return formatDuration(j10, ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static String formatDurationWords(long j10, boolean z10, boolean z11) {
        String formatDuration = formatDuration(j10, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z10) {
            formatDuration = " " + formatDuration;
            String replaceOnce = StringUtils.replaceOnce(formatDuration, " 0 days", "");
            if (replaceOnce.length() != formatDuration.length()) {
                String replaceOnce2 = StringUtils.replaceOnce(replaceOnce, " 0 hours", "");
                if (replaceOnce2.length() != replaceOnce.length()) {
                    formatDuration = StringUtils.replaceOnce(replaceOnce2, " 0 minutes", "");
                    if (formatDuration.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
                    }
                } else {
                    formatDuration = replaceOnce;
                }
            }
            if (!formatDuration.isEmpty()) {
                formatDuration = formatDuration.substring(1);
            }
        }
        if (z11) {
            String replaceOnce3 = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
            if (replaceOnce3.length() != formatDuration.length()) {
                formatDuration = StringUtils.replaceOnce(replaceOnce3, " 0 minutes", "");
                if (formatDuration.length() != replaceOnce3.length()) {
                    String replaceOnce4 = StringUtils.replaceOnce(formatDuration, " 0 hours", "");
                    if (replaceOnce4.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(replaceOnce4, " 0 days", "");
                    }
                } else {
                    formatDuration = replaceOnce3;
                }
            }
        }
        return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(" " + formatDuration, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriod(long j10, long j11, String str) {
        return formatPeriod(j10, j11, str, true, TimeZone.getDefault());
    }

    public static String formatPeriodISO(long j10, long j11) {
        return formatPeriod(j10, j11, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.apache.commons.lang3.time.DurationFormatUtils.Token[] lexx(java.lang.String r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r9.length()
            r0.<init>(r1)
            r1 = 0
            r2 = 0
            r5 = r2
            r6 = r5
            r3 = 0
            r4 = 0
        Lf:
            int r7 = r9.length()
            if (r3 >= r7) goto L9f
            char r7 = r9.charAt(r3)
            r8 = 39
            if (r4 == 0) goto L24
            if (r7 == r8) goto L24
            r5.append(r7)
            goto L9b
        L24:
            if (r7 == r8) goto L6a
            r8 = 72
            if (r7 == r8) goto L67
            r8 = 77
            if (r7 == r8) goto L64
            r8 = 83
            if (r7 == r8) goto L61
            r8 = 100
            if (r7 == r8) goto L5e
            r8 = 109(0x6d, float:1.53E-43)
            if (r7 == r8) goto L5b
            r8 = 115(0x73, float:1.61E-43)
            if (r7 == r8) goto L58
            r8 = 121(0x79, float:1.7E-43)
            if (r7 == r8) goto L55
            if (r5 != 0) goto L51
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            org.apache.commons.lang3.time.DurationFormatUtils$Token r8 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r8.<init>(r5)
            r0.add(r8)
        L51:
            r5.append(r7)
            goto L7e
        L55:
            java.lang.Object r7 = org.apache.commons.lang3.time.DurationFormatUtils.f52401y
            goto L7f
        L58:
            java.lang.Object r7 = org.apache.commons.lang3.time.DurationFormatUtils.f52400s
            goto L7f
        L5b:
            java.lang.Object r7 = org.apache.commons.lang3.time.DurationFormatUtils.f52399m
            goto L7f
        L5e:
            java.lang.Object r7 = org.apache.commons.lang3.time.DurationFormatUtils.f52398d
            goto L7f
        L61:
            java.lang.Object r7 = org.apache.commons.lang3.time.DurationFormatUtils.S
            goto L7f
        L64:
            java.lang.Object r7 = org.apache.commons.lang3.time.DurationFormatUtils.M
            goto L7f
        L67:
            java.lang.Object r7 = org.apache.commons.lang3.time.DurationFormatUtils.H
            goto L7f
        L6a:
            if (r4 == 0) goto L70
            r5 = r2
            r7 = r5
            r4 = 0
            goto L7f
        L70:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            org.apache.commons.lang3.time.DurationFormatUtils$Token r4 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r4.<init>(r5)
            r0.add(r4)
            r4 = 1
        L7e:
            r7 = r2
        L7f:
            if (r7 == 0) goto L9b
            if (r6 == 0) goto L91
            java.lang.Object r5 = r6.getValue()
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L91
            r6.increment()
            goto L9a
        L91:
            org.apache.commons.lang3.time.DurationFormatUtils$Token r5 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r5.<init>(r7)
            r0.add(r5)
            r6 = r5
        L9a:
            r5 = r2
        L9b:
            int r3 = r3 + 1
            goto Lf
        L9f:
            if (r4 != 0) goto Lae
            int r9 = r0.size()
            org.apache.commons.lang3.time.DurationFormatUtils$Token[] r9 = new org.apache.commons.lang3.time.DurationFormatUtils.Token[r9]
            java.lang.Object[] r9 = r0.toArray(r9)
            org.apache.commons.lang3.time.DurationFormatUtils$Token[] r9 = (org.apache.commons.lang3.time.DurationFormatUtils.Token[]) r9
            return r9
        Lae:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unmatched quote in format: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DurationFormatUtils.lexx(java.lang.String):org.apache.commons.lang3.time.DurationFormatUtils$Token[]");
    }

    private static String paddedValue(long j10, boolean z10, int i10) {
        String l10 = Long.toString(j10);
        return z10 ? StringUtils.leftPad(l10, i10, '0') : l10;
    }

    public static String formatDuration(long j10, String str, boolean z10) {
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        Validate.inclusiveBetween(0L, Long.MAX_VALUE, j10, "durationMillis must not be negative");
        Token[] lexx = lexx(str);
        if (Token.containsTokenWithValue(lexx, f52398d)) {
            long j17 = j10 / 86400000;
            j11 = j10 - (86400000 * j17);
            j12 = j17;
        } else {
            j11 = j10;
            j12 = 0;
        }
        if (Token.containsTokenWithValue(lexx, H)) {
            long j18 = j11 / 3600000;
            j11 -= 3600000 * j18;
            j13 = j18;
        } else {
            j13 = 0;
        }
        if (Token.containsTokenWithValue(lexx, f52399m)) {
            long j19 = j11 / 60000;
            j11 -= 60000 * j19;
            j14 = j19;
        } else {
            j14 = 0;
        }
        if (Token.containsTokenWithValue(lexx, f52400s)) {
            long j20 = j11 / 1000;
            j16 = j11 - (1000 * j20);
            j15 = j20;
        } else {
            j15 = 0;
            j16 = j11;
        }
        return format(lexx, 0L, 0L, j12, j13, j14, j15, j16, z10);
    }

    public static String formatPeriod(long j10, long j11, String str, boolean z10, TimeZone timeZone) {
        int i10 = 0;
        Validate.isTrue(j10 <= j11, "startMillis must not be greater than endMillis", new Object[0]);
        Token[] lexx = lexx(str);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(j10));
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTime(new Date(j11));
        int i11 = calendar2.get(14) - calendar.get(14);
        int i12 = calendar2.get(13) - calendar.get(13);
        int i13 = calendar2.get(12) - calendar.get(12);
        int i14 = calendar2.get(11) - calendar.get(11);
        int i15 = calendar2.get(5) - calendar.get(5);
        int i16 = calendar2.get(2) - calendar.get(2);
        int i17 = calendar2.get(1) - calendar.get(1);
        while (i11 < 0) {
            i11 += 1000;
            i12--;
        }
        while (i12 < 0) {
            i12 += 60;
            i13--;
        }
        while (i13 < 0) {
            i13 += 60;
            i14--;
        }
        while (i14 < 0) {
            i14 += 24;
            i15--;
        }
        if (Token.containsTokenWithValue(lexx, M)) {
            while (i15 < 0) {
                i15 += calendar.getActualMaximum(5);
                i16--;
                calendar.add(2, 1);
            }
            while (i16 < 0) {
                i16 += 12;
                i17--;
            }
            if (!Token.containsTokenWithValue(lexx, f52401y) && i17 != 0) {
                while (i17 != 0) {
                    i16 += i17 * 12;
                    i17 = 0;
                }
            }
        } else {
            if (!Token.containsTokenWithValue(lexx, f52401y)) {
                int i18 = calendar2.get(1);
                if (i16 < 0) {
                    i18--;
                }
                while (calendar.get(1) != i18) {
                    int actualMaximum = i15 + (calendar.getActualMaximum(6) - calendar.get(6));
                    if ((calendar instanceof GregorianCalendar) && calendar.get(2) == 1 && calendar.get(5) == 29) {
                        actualMaximum++;
                    }
                    calendar.add(1, 1);
                    i15 = actualMaximum + calendar.get(6);
                }
                i17 = 0;
            }
            while (calendar.get(2) != calendar2.get(2)) {
                i15 += calendar.getActualMaximum(5);
                calendar.add(2, 1);
            }
            i16 = 0;
            while (i15 < 0) {
                i15 += calendar.getActualMaximum(5);
                i16--;
                calendar.add(2, 1);
            }
        }
        if (!Token.containsTokenWithValue(lexx, f52398d)) {
            i14 += i15 * 24;
            i15 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, H)) {
            i13 += i14 * 60;
            i14 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, f52399m)) {
            i12 += i13 * 60;
            i13 = 0;
        }
        if (Token.containsTokenWithValue(lexx, f52400s)) {
            i10 = i12;
        } else {
            i11 += i12 * 1000;
        }
        return format(lexx, i17, i16, i15, i14, i13, i10, i11, z10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Token {
        private int count;
        private final Object value;

        public Token(Object obj) {
            this.value = obj;
            this.count = 1;
        }

        public static boolean containsTokenWithValue(Token[] tokenArr, Object obj) {
            for (Token token : tokenArr) {
                if (token.getValue() == obj) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.value.getClass() != token.value.getClass() || this.count != token.count) {
                return false;
            }
            Object obj2 = this.value;
            if (obj2 instanceof StringBuilder) {
                return obj2.toString().equals(token.value.toString());
            }
            if (obj2 instanceof Number) {
                return obj2.equals(token.value);
            }
            return obj2 == token.value;
        }

        public int getCount() {
            return this.count;
        }

        public Object getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public void increment() {
            this.count++;
        }

        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }

        public Token(Object obj, int i10) {
            this.value = obj;
            this.count = i10;
        }
    }
}
