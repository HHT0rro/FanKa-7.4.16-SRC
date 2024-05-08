package z0;

import android.content.Context;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.extension.DateFormatPattern;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

/* compiled from: TimeExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class v {
    @Nullable
    public static final String a(long j10, @Nullable Context context) {
        String str;
        LocalDateTime localDateTime = new LocalDateTime(j10);
        int hourOfDay = localDateTime.getHourOfDay();
        if (hourOfDay >= 0 && hourOfDay < 8) {
            str = "凌晨";
        } else {
            if (8 <= hourOfDay && hourOfDay < 12) {
                str = "上午";
            } else {
                if (12 <= hourOfDay && hourOfDay < 18) {
                    str = "下午";
                } else {
                    str = 18 <= hourOfDay && hourOfDay < 24 ? "晚上" : "";
                }
            }
        }
        if (context != null) {
            return context.getString(R$string.month_and_day, Integer.valueOf(localDateTime.getMonthOfYear()), Integer.valueOf(localDateTime.getDayOfMonth()), str);
        }
        return null;
    }

    @NotNull
    public static final String b(int i10) {
        int i11 = i10 / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        int i12 = i10 % SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i11), Integer.valueOf(i12 / 60), Integer.valueOf(i12 % 60)}, 3));
        kotlin.jvm.internal.s.h(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public static final String c(long j10) {
        long j11 = j10 / 1000;
        long j12 = SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        long j13 = j11 / j12;
        long j14 = j11 % j12;
        long j15 = 60;
        long j16 = j14 / j15;
        long j17 = j14 % j15;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j13), Long.valueOf(j16), Long.valueOf(j17)}, 3));
        kotlin.jvm.internal.s.h(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public static final String d(int i10) {
        int i11 = i10 / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        int ceil = (int) Math.ceil((i10 % 3600.0d) / 60.0d);
        if (ceil == 60) {
            i11++;
            ceil = 0;
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i11), Integer.valueOf(ceil)}, 2));
        kotlin.jvm.internal.s.h(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public static final String e(long j10) {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
        String format = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf((j10 / 1000) / 60)}, 1));
        kotlin.jvm.internal.s.h(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public static final String f(int i10) {
        int i11 = i10 / 60;
        return i11 > 1 ? String.valueOf(i11) : "1";
    }

    @NotNull
    public static final String g(int i10) {
        int i11 = i10 / 60;
        int i12 = i10 % 60;
        if (i11 > 0) {
            return i11 + "分" + i12 + "秒钟";
        }
        return i12 + "秒钟";
    }

    @NotNull
    public static final String h(int i10) {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i10 / 60), Integer.valueOf(i10 % 60)}, 2));
        kotlin.jvm.internal.s.h(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public static final String i(long j10) {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
        String format = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf((j10 / 1000) % 60)}, 1));
        kotlin.jvm.internal.s.h(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public static final String j(int i10) {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i10 / 60), Integer.valueOf(i10 % 60)}, 2));
        kotlin.jvm.internal.s.h(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public static final String k(long j10) {
        long j11 = j10 / 1000;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
        long j12 = 60;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j11 / j12), Long.valueOf(j11 % j12)}, 2));
        kotlin.jvm.internal.s.h(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public static final String l(long j10) {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
        String format = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j10)}, 1));
        kotlin.jvm.internal.s.h(format, "format(format, *args)");
        return format;
    }

    public static final boolean m(long j10, long j11) {
        return Days.daysBetween(new LocalDate(j10), new LocalDate(j11)).getDays() == 0;
    }

    @Nullable
    public static final String n(long j10, @Nullable Context context) {
        if (context == null || j10 <= 0) {
            return null;
        }
        long abs = Math.abs(System.currentTimeMillis() - j10) / 1000;
        int days = Days.daysBetween(new LocalDate(j10), new LocalDate()).getDays();
        if (new LocalDate(j10).getYear() != new LocalDate().getYear()) {
            return s(j10, DateFormatPattern.YYYYMD);
        }
        if (days == 0) {
            if (0 <= abs && abs < 60) {
                return context.getString(R$string.ative_in_now);
            }
            long j11 = 60;
            long j12 = abs / j11;
            return (1L > j12 ? 1 : (1L == j12 ? 0 : -1)) <= 0 && (j12 > 60L ? 1 : (j12 == 60L ? 0 : -1)) < 0 ? context.getString(R$string.ative_in_minutes, Long.valueOf(j12)) : context.getString(R$string.ative_in_hours, Long.valueOf(j12 / j11));
        }
        if (days == 1) {
            return context.getString(R$string.yesterday_time, s(j10, DateFormatPattern.Hmm));
        }
        if (days == 2) {
            return context.getString(R$string.the_day_before_yesterday_time, s(j10, DateFormatPattern.Hmm));
        }
        return 3 <= days && days < 31 ? context.getString(R$string.ative_in_days, Integer.valueOf(days)) : s(j10, DateFormatPattern.MD);
    }

    public static final long o(long j10) {
        return j10 * 1000;
    }

    public static final long p(long j10) {
        return j10 / 1000;
    }

    @NotNull
    public static final LocalDate q(@NotNull String str) {
        kotlin.jvm.internal.s.i(str, "<this>");
        LocalDate g3 = org.joda.time.format.a.b(DateFormatPattern.YyyyMMdd.getPattern()).g(str);
        kotlin.jvm.internal.s.h(g3, "forPattern(DateFormatPat…ern).parseLocalDate(this)");
        return g3;
    }

    public static final long r(int i10) {
        return i10 * 1000;
    }

    @NotNull
    public static final String s(long j10, @NotNull DateFormatPattern dateFormatPattern) {
        kotlin.jvm.internal.s.i(dateFormatPattern, "dateFormatPattern");
        String format = new SimpleDateFormat(dateFormatPattern.getPattern(), Locale.CHINA).format(new Date(j10));
        kotlin.jvm.internal.s.h(format, "SimpleDateFormat(dateFor…CHINA).format(Date(this))");
        return format;
    }

    @NotNull
    public static final String t(@NotNull Date date, @NotNull DateFormatPattern dateFormatPattern) {
        kotlin.jvm.internal.s.i(date, "<this>");
        kotlin.jvm.internal.s.i(dateFormatPattern, "dateFormatPattern");
        String format = new SimpleDateFormat(dateFormatPattern.getPattern(), Locale.CHINA).format(date);
        kotlin.jvm.internal.s.h(format, "SimpleDateFormat(dateFor…ocale.CHINA).format(this)");
        return format;
    }

    @NotNull
    public static final String u(int i10) {
        int i11 = i10 / 1000;
        String valueOf = String.valueOf(i11 / 60);
        String valueOf2 = String.valueOf(i11 % 60);
        if (valueOf.length() == 2) {
            return valueOf;
        }
        if (valueOf2.length() != 2) {
            valueOf2 = "0" + valueOf2;
        }
        return "0" + valueOf + com.huawei.openalliance.ad.constant.u.bD + valueOf2;
    }

    public static final long v(long j10) {
        return j10 / 1000;
    }
}
