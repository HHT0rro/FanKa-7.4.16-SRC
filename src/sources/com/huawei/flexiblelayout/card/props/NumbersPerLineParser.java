package com.huawei.flexiblelayout.card.props;

import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.card.props.FLCardProps;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class NumbersPerLineParser {

    /* renamed from: a, reason: collision with root package name */
    private static final String f27892a = "NumbersPerLineParser";

    /* renamed from: b, reason: collision with root package name */
    private static final String f27893b = "ldpi";

    /* renamed from: c, reason: collision with root package name */
    private static final String f27894c = "mdpi";

    /* renamed from: d, reason: collision with root package name */
    private static final String f27895d = "hdpi";

    /* renamed from: e, reason: collision with root package name */
    private static final String f27896e = "xhdpi";

    /* renamed from: f, reason: collision with root package name */
    private static final String f27897f = "xxhdpi";

    /* renamed from: g, reason: collision with root package name */
    private static final String f27898g = "xxxhdpi";

    /* renamed from: h, reason: collision with root package name */
    private static final String f27899h = "tvdpi";

    /* renamed from: i, reason: collision with root package name */
    private static Pattern f27900i = Pattern.compile("(\\w+):(\\d+),(\\d+);");

    /* renamed from: j, reason: collision with root package name */
    private static Pattern f27901j = Pattern.compile("(w\\d+):(\\d+)(,\\d+)*;");

    public static boolean a(FLCardProps.CardNumbersPerLine cardNumbersPerLine, String str, int i10) {
        try {
            cardNumbersPerLine.wDp(Integer.parseInt(str.substring(1)), i10);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    @Nullable
    public static FLCardProps.CardNumbersPerLine parse(@Nullable String str) {
        boolean z10;
        if (str == null) {
            return null;
        }
        FLCardProps.CardNumbersPerLine numbersPerLine = FLCardProps.numbersPerLine();
        Matcher matcher = f27900i.matcher(str + ";");
        loop0: while (true) {
            while (matcher.find()) {
                z10 = a(numbersPerLine, matcher.group(1), a(matcher.group(2), 1), a(matcher.group(3), 1)) || z10;
            }
        }
        Matcher matcher2 = f27901j.matcher(str + ";");
        while (matcher2.find()) {
            z10 = a(numbersPerLine, matcher2.group(1), a(matcher2.group(2), 1)) || z10;
        }
        if (z10) {
            return numbersPerLine;
        }
        return null;
    }

    public static boolean a(FLCardProps.CardNumbersPerLine cardNumbersPerLine, String str, int i10, int i11) {
        if (f27893b.equals(str)) {
            cardNumbersPerLine.ldpi(i10, i11);
            return true;
        }
        if (f27894c.equals(str)) {
            cardNumbersPerLine.mdpi(i10, i11);
            return true;
        }
        if (f27895d.equals(str)) {
            cardNumbersPerLine.hdpi(i10, i11);
            return true;
        }
        if (f27896e.equals(str)) {
            cardNumbersPerLine.xhdpi(i10, i11);
            return true;
        }
        if (f27897f.equals(str)) {
            cardNumbersPerLine.xxhdpi(i10, i11);
            return true;
        }
        if (f27898g.equals(str)) {
            cardNumbersPerLine.xxxhdpi(i10, i11);
            return true;
        }
        if (!f27899h.equals(str)) {
            return false;
        }
        cardNumbersPerLine.tvdpi(i10, i11);
        return true;
    }

    private static int a(String str, int i10) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i10;
        }
    }
}
