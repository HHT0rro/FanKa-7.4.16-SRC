package m6;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.Attributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WebvttCssParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f51879c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f51880d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f51881a = new ParsableByteArray();

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f51882b = new StringBuilder();

    public static boolean b(ParsableByteArray parsableByteArray) {
        int e2 = parsableByteArray.e();
        int f10 = parsableByteArray.f();
        byte[] d10 = parsableByteArray.d();
        if (e2 + 2 > f10) {
            return false;
        }
        int i10 = e2 + 1;
        if (d10[e2] != 47) {
            return false;
        }
        int i11 = i10 + 1;
        if (d10[i10] != 42) {
            return false;
        }
        while (true) {
            int i12 = i11 + 1;
            if (i12 < f10) {
                if (((char) d10[i11]) == '*' && ((char) d10[i12]) == '/') {
                    i11 = i12 + 1;
                    f10 = i11;
                } else {
                    i11 = i12;
                }
            } else {
                parsableByteArray.Q(f10 - parsableByteArray.e());
                return true;
            }
        }
    }

    public static boolean c(ParsableByteArray parsableByteArray) {
        char k10 = k(parsableByteArray, parsableByteArray.e());
        if (k10 != '\t' && k10 != '\n' && k10 != '\f' && k10 != '\r' && k10 != ' ') {
            return false;
        }
        parsableByteArray.Q(1);
        return true;
    }

    public static void e(String str, d dVar) {
        Matcher matcher = f51880d.matcher(com.google.common.base.a.e(str));
        if (!matcher.matches()) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 22);
            sb2.append("Invalid font-size: '");
            sb2.append(str);
            sb2.append("'.");
            m.h("WebvttCssParser", sb2.toString());
            return;
        }
        String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(2));
        str2.hashCode();
        char c4 = 65535;
        switch (str2.hashCode()) {
            case 37:
                if (str2.equals("%")) {
                    c4 = 0;
                    break;
                }
                break;
            case 3240:
                if (str2.equals("em")) {
                    c4 = 1;
                    break;
                }
                break;
            case 3592:
                if (str2.equals("px")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                dVar.t(3);
                break;
            case 1:
                dVar.t(2);
                break;
            case 2:
                dVar.t(1);
                break;
            default:
                throw new IllegalStateException();
        }
        dVar.s(Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))));
    }

    public static String f(ParsableByteArray parsableByteArray, StringBuilder sb2) {
        boolean z10 = false;
        sb2.setLength(0);
        int e2 = parsableByteArray.e();
        int f10 = parsableByteArray.f();
        while (e2 < f10 && !z10) {
            char c4 = (char) parsableByteArray.d()[e2];
            if ((c4 < 'A' || c4 > 'Z') && ((c4 < 'a' || c4 > 'z') && !((c4 >= '0' && c4 <= '9') || c4 == '#' || c4 == '-' || c4 == '.' || c4 == '_'))) {
                z10 = true;
            } else {
                e2++;
                sb2.append(c4);
            }
        }
        parsableByteArray.Q(e2 - parsableByteArray.e());
        return sb2.toString();
    }

    @Nullable
    public static String g(ParsableByteArray parsableByteArray, StringBuilder sb2) {
        n(parsableByteArray);
        if (parsableByteArray.a() == 0) {
            return null;
        }
        String f10 = f(parsableByteArray, sb2);
        if (!"".equals(f10)) {
            return f10;
        }
        char D = (char) parsableByteArray.D();
        StringBuilder sb3 = new StringBuilder(1);
        sb3.append(D);
        return sb3.toString();
    }

    @Nullable
    public static String h(ParsableByteArray parsableByteArray, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder();
        boolean z10 = false;
        while (!z10) {
            int e2 = parsableByteArray.e();
            String g3 = g(parsableByteArray, sb2);
            if (g3 == null) {
                return null;
            }
            if (!com.alipay.sdk.util.i.f4738d.equals(g3) && !";".equals(g3)) {
                sb3.append(g3);
            } else {
                parsableByteArray.P(e2);
                z10 = true;
            }
        }
        return sb3.toString();
    }

    @Nullable
    public static String i(ParsableByteArray parsableByteArray, StringBuilder sb2) {
        n(parsableByteArray);
        if (parsableByteArray.a() < 5 || !"::cue".equals(parsableByteArray.A(5))) {
            return null;
        }
        int e2 = parsableByteArray.e();
        String g3 = g(parsableByteArray, sb2);
        if (g3 == null) {
            return null;
        }
        if ("{".equals(g3)) {
            parsableByteArray.P(e2);
            return "";
        }
        String l10 = "(".equals(g3) ? l(parsableByteArray) : null;
        if (")".equals(g(parsableByteArray, sb2))) {
            return l10;
        }
        return null;
    }

    public static void j(ParsableByteArray parsableByteArray, d dVar, StringBuilder sb2) {
        n(parsableByteArray);
        String f10 = f(parsableByteArray, sb2);
        if (!"".equals(f10) && u.bD.equals(g(parsableByteArray, sb2))) {
            n(parsableByteArray);
            String h10 = h(parsableByteArray, sb2);
            if (h10 == null || "".equals(h10)) {
                return;
            }
            int e2 = parsableByteArray.e();
            String g3 = g(parsableByteArray, sb2);
            if (!";".equals(g3)) {
                if (!com.alipay.sdk.util.i.f4738d.equals(g3)) {
                    return;
                } else {
                    parsableByteArray.P(e2);
                }
            }
            if ("color".equals(f10)) {
                dVar.q(com.google.android.exoplayer2.util.d.b(h10));
                return;
            }
            if ("background-color".equals(f10)) {
                dVar.n(com.google.android.exoplayer2.util.d.b(h10));
                return;
            }
            boolean z10 = true;
            if ("ruby-position".equals(f10)) {
                if ("over".equals(h10)) {
                    dVar.v(1);
                    return;
                } else {
                    if ("under".equals(h10)) {
                        dVar.v(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(f10)) {
                if (!"all".equals(h10) && !h10.startsWith("digits")) {
                    z10 = false;
                }
                dVar.p(z10);
                return;
            }
            if ("text-decoration".equals(f10)) {
                if (Attributes.Style.UNDERLINE.equals(h10)) {
                    dVar.A(true);
                    return;
                }
                return;
            }
            if ("font-family".equals(f10)) {
                dVar.r(h10);
                return;
            }
            if ("font-weight".equals(f10)) {
                if ("bold".equals(h10)) {
                    dVar.o(true);
                }
            } else if ("font-style".equals(f10)) {
                if ("italic".equals(h10)) {
                    dVar.u(true);
                }
            } else if ("font-size".equals(f10)) {
                e(h10, dVar);
            }
        }
    }

    public static char k(ParsableByteArray parsableByteArray, int i10) {
        return (char) parsableByteArray.d()[i10];
    }

    public static String l(ParsableByteArray parsableByteArray) {
        int e2 = parsableByteArray.e();
        int f10 = parsableByteArray.f();
        boolean z10 = false;
        while (e2 < f10 && !z10) {
            int i10 = e2 + 1;
            z10 = ((char) parsableByteArray.d()[e2]) == ')';
            e2 = i10;
        }
        return parsableByteArray.A((e2 - 1) - parsableByteArray.e()).trim();
    }

    public static void m(ParsableByteArray parsableByteArray) {
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.p()));
    }

    public static void n(ParsableByteArray parsableByteArray) {
        while (true) {
            for (boolean z10 = true; parsableByteArray.a() > 0 && z10; z10 = false) {
                if (!c(parsableByteArray) && !b(parsableByteArray)) {
                }
            }
            return;
        }
    }

    public final void a(d dVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int indexOf = str.indexOf(91);
        if (indexOf != -1) {
            Matcher matcher = f51879c.matcher(str.substring(indexOf));
            if (matcher.matches()) {
                dVar.z((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            }
            str = str.substring(0, indexOf);
        }
        String[] M0 = j0.M0(str, "\\.");
        String str2 = M0[0];
        int indexOf2 = str2.indexOf(35);
        if (indexOf2 != -1) {
            dVar.y(str2.substring(0, indexOf2));
            dVar.x(str2.substring(indexOf2 + 1));
        } else {
            dVar.y(str2);
        }
        if (M0.length > 1) {
            dVar.w((String[]) j0.B0(M0, 1, M0.length));
        }
    }

    public List<d> d(ParsableByteArray parsableByteArray) {
        this.f51882b.setLength(0);
        int e2 = parsableByteArray.e();
        m(parsableByteArray);
        this.f51881a.N(parsableByteArray.d(), parsableByteArray.e());
        this.f51881a.P(e2);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String i10 = i(this.f51881a, this.f51882b);
            if (i10 == null || !"{".equals(g(this.f51881a, this.f51882b))) {
                return arrayList;
            }
            d dVar = new d();
            a(dVar, i10);
            String str = null;
            boolean z10 = false;
            while (!z10) {
                int e10 = this.f51881a.e();
                String g3 = g(this.f51881a, this.f51882b);
                boolean z11 = g3 == null || com.alipay.sdk.util.i.f4738d.equals(g3);
                if (!z11) {
                    this.f51881a.P(e10);
                    j(this.f51881a, dVar, this.f51882b);
                }
                str = g3;
                z10 = z11;
            }
            if (com.alipay.sdk.util.i.f4738d.equals(str)) {
                arrayList.add(dVar);
            }
        }
    }
}
