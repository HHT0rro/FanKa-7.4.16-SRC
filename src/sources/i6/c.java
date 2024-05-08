package i6;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.common.primitives.Ints;
import com.huawei.quickcard.base.Attributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: SsaStyle.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f49816a;

    /* renamed from: b, reason: collision with root package name */
    public final int f49817b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    @ColorInt
    public final Integer f49818c;

    /* renamed from: d, reason: collision with root package name */
    public final float f49819d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f49820e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f49821f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f49822g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f49823h;

    /* compiled from: SsaStyle.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f49824a;

        /* renamed from: b, reason: collision with root package name */
        public final int f49825b;

        /* renamed from: c, reason: collision with root package name */
        public final int f49826c;

        /* renamed from: d, reason: collision with root package name */
        public final int f49827d;

        /* renamed from: e, reason: collision with root package name */
        public final int f49828e;

        /* renamed from: f, reason: collision with root package name */
        public final int f49829f;

        /* renamed from: g, reason: collision with root package name */
        public final int f49830g;

        /* renamed from: h, reason: collision with root package name */
        public final int f49831h;

        /* renamed from: i, reason: collision with root package name */
        public final int f49832i;

        public a(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            this.f49824a = i10;
            this.f49825b = i11;
            this.f49826c = i12;
            this.f49827d = i13;
            this.f49828e = i14;
            this.f49829f = i15;
            this.f49830g = i16;
            this.f49831h = i17;
            this.f49832i = i18;
        }

        @Nullable
        public static a a(String str) {
            char c4;
            String[] split = TextUtils.split(str.substring(7), ",");
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            int i17 = -1;
            for (int i18 = 0; i18 < split.length; i18++) {
                String e2 = com.google.common.base.a.e(split[i18].trim());
                e2.hashCode();
                switch (e2.hashCode()) {
                    case -1178781136:
                        if (e2.equals("italic")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case -1026963764:
                        if (e2.equals(Attributes.Style.UNDERLINE)) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case -192095652:
                        if (e2.equals("strikeout")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case -70925746:
                        if (e2.equals("primarycolour")) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 3029637:
                        if (e2.equals("bold")) {
                            c4 = 4;
                            break;
                        }
                        break;
                    case 3373707:
                        if (e2.equals("name")) {
                            c4 = 5;
                            break;
                        }
                        break;
                    case 366554320:
                        if (e2.equals("fontsize")) {
                            c4 = 6;
                            break;
                        }
                        break;
                    case 1767875043:
                        if (e2.equals("alignment")) {
                            c4 = 7;
                            break;
                        }
                        break;
                }
                c4 = 65535;
                switch (c4) {
                    case 0:
                        i15 = i18;
                        break;
                    case 1:
                        i16 = i18;
                        break;
                    case 2:
                        i17 = i18;
                        break;
                    case 3:
                        i12 = i18;
                        break;
                    case 4:
                        i14 = i18;
                        break;
                    case 5:
                        i10 = i18;
                        break;
                    case 6:
                        i13 = i18;
                        break;
                    case 7:
                        i11 = i18;
                        break;
                }
            }
            if (i10 != -1) {
                return new a(i10, i11, i12, i13, i14, i15, i16, i17, split.length);
            }
            return null;
        }
    }

    /* compiled from: SsaStyle.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        public static final Pattern f49833c = Pattern.compile("\\{([^}]*)\\}");

        /* renamed from: d, reason: collision with root package name */
        public static final Pattern f49834d = Pattern.compile(j0.D("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: e, reason: collision with root package name */
        public static final Pattern f49835e = Pattern.compile(j0.D("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: f, reason: collision with root package name */
        public static final Pattern f49836f = Pattern.compile("\\\\an(\\d+)");

        /* renamed from: a, reason: collision with root package name */
        public final int f49837a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final PointF f49838b;

        public b(int i10, @Nullable PointF pointF) {
            this.f49837a = i10;
            this.f49838b = pointF;
        }

        public static int a(String str) {
            Matcher matcher = f49836f.matcher(str);
            if (matcher.find()) {
                return c.d((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            }
            return -1;
        }

        public static b b(String str) {
            Matcher matcher = f49833c.matcher(str);
            PointF pointF = null;
            int i10 = -1;
            while (matcher.find()) {
                String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
                try {
                    PointF c4 = c(str2);
                    if (c4 != null) {
                        pointF = c4;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    int a10 = a(str2);
                    if (a10 != -1) {
                        i10 = a10;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            return new b(i10, pointF);
        }

        @Nullable
        public static PointF c(String str) {
            String group;
            String group2;
            Matcher matcher = f49834d.matcher(str);
            Matcher matcher2 = f49835e.matcher(str);
            boolean find = matcher.find();
            boolean find2 = matcher2.find();
            if (find) {
                if (find2) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 82);
                    sb2.append("Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='");
                    sb2.append(str);
                    sb2.append("'");
                    m.f("SsaStyle.Overrides", sb2.toString());
                }
                group = matcher.group(1);
                group2 = matcher.group(2);
            } else {
                if (!find2) {
                    return null;
                }
                group = matcher2.group(1);
                group2 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) com.google.android.exoplayer2.util.a.e(group)).trim()), Float.parseFloat(((String) com.google.android.exoplayer2.util.a.e(group2)).trim()));
        }

        public static String d(String str) {
            return f49833c.matcher(str).replaceAll("");
        }
    }

    public c(String str, int i10, @Nullable @ColorInt Integer num, float f10, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f49816a = str;
        this.f49817b = i10;
        this.f49818c = num;
        this.f49819d = f10;
        this.f49820e = z10;
        this.f49821f = z11;
        this.f49822g = z12;
        this.f49823h = z13;
    }

    @Nullable
    public static c b(String str, a aVar) {
        com.google.android.exoplayer2.util.a.a(str.startsWith("Style:"));
        String[] split = TextUtils.split(str.substring(6), ",");
        int length = split.length;
        int i10 = aVar.f49832i;
        if (length != i10) {
            m.h("SsaStyle", j0.D("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i10), Integer.valueOf(split.length), str));
            return null;
        }
        try {
            String trim = split[aVar.f49824a].trim();
            int i11 = aVar.f49825b;
            int d10 = i11 != -1 ? d(split[i11].trim()) : -1;
            int i12 = aVar.f49826c;
            Integer f10 = i12 != -1 ? f(split[i12].trim()) : null;
            int i13 = aVar.f49827d;
            float g3 = i13 != -1 ? g(split[i13].trim()) : -3.4028235E38f;
            int i14 = aVar.f49828e;
            boolean z10 = i14 != -1 && e(split[i14].trim());
            int i15 = aVar.f49829f;
            boolean z11 = i15 != -1 && e(split[i15].trim());
            int i16 = aVar.f49830g;
            boolean z12 = i16 != -1 && e(split[i16].trim());
            int i17 = aVar.f49831h;
            return new c(trim, d10, f10, g3, z10, z11, z12, i17 != -1 && e(split[i17].trim()));
        } catch (RuntimeException e2) {
            StringBuilder sb2 = new StringBuilder(str.length() + 36);
            sb2.append("Skipping malformed 'Style:' line: '");
            sb2.append(str);
            sb2.append("'");
            m.i("SsaStyle", sb2.toString(), e2);
            return null;
        }
    }

    public static boolean c(int i10) {
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static int d(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (c(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        String valueOf = String.valueOf(str);
        m.h("SsaStyle", valueOf.length() != 0 ? "Ignoring unknown alignment: ".concat(valueOf) : new String("Ignoring unknown alignment: "));
        return -1;
    }

    public static boolean e(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt == 1 || parseInt == -1;
        } catch (NumberFormatException e2) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 33);
            sb2.append("Failed to parse boolean value: '");
            sb2.append(str);
            sb2.append("'");
            m.i("SsaStyle", sb2.toString(), e2);
            return false;
        }
    }

    @Nullable
    @ColorInt
    public static Integer f(String str) {
        long parseLong;
        try {
            if (str.startsWith("&H")) {
                parseLong = Long.parseLong(str.substring(2), 16);
            } else {
                parseLong = Long.parseLong(str);
            }
            com.google.android.exoplayer2.util.a.a(parseLong <= 4294967295L);
            return Integer.valueOf(Color.argb(Ints.c(((parseLong >> 24) & 255) ^ 255), Ints.c(parseLong & 255), Ints.c((parseLong >> 8) & 255), Ints.c((parseLong >> 16) & 255)));
        } catch (IllegalArgumentException e2) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 36);
            sb2.append("Failed to parse color expression: '");
            sb2.append(str);
            sb2.append("'");
            m.i("SsaStyle", sb2.toString(), e2);
            return null;
        }
    }

    public static float g(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e2) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 29);
            sb2.append("Failed to parse font size: '");
            sb2.append(str);
            sb2.append("'");
            m.i("SsaStyle", sb2.toString(), e2);
            return -3.4028235E38f;
        }
    }
}
