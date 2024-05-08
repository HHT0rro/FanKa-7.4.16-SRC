package j6;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.n;
import e6.a;
import e6.c;
import e6.e;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: SubripDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends c {

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f50339q = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f50340r = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: o, reason: collision with root package name */
    public final StringBuilder f50341o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList<String> f50342p;

    public a() {
        super("SubripDecoder");
        this.f50341o = new StringBuilder();
        this.f50342p = new ArrayList<>();
    }

    public static float C(int i10) {
        if (i10 == 0) {
            return 0.08f;
        }
        if (i10 == 1) {
            return 0.5f;
        }
        if (i10 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    public static long D(Matcher matcher, int i10) {
        String group = matcher.group(i10 + 1);
        long parseLong = (group != null ? Long.parseLong(group) * 60 * 60 * 1000 : 0L) + (Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(i10 + 2))) * 60 * 1000) + (Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(i10 + 3))) * 1000);
        String group2 = matcher.group(i10 + 4);
        if (group2 != null) {
            parseLong += Long.parseLong(group2);
        }
        return parseLong * 1000;
    }

    @Override // e6.c
    public e A(byte[] bArr, int i10, boolean z10) {
        ArrayList arrayList = new ArrayList();
        n nVar = new n();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i10);
        while (true) {
            String p10 = parsableByteArray.p();
            int i11 = 0;
            if (p10 == null) {
                break;
            }
            if (p10.length() != 0) {
                try {
                    Integer.parseInt(p10);
                    String p11 = parsableByteArray.p();
                    if (p11 == null) {
                        m.h("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = f50339q.matcher(p11);
                    if (matcher.matches()) {
                        nVar.a(D(matcher, 1));
                        nVar.a(D(matcher, 6));
                        this.f50341o.setLength(0);
                        this.f50342p.clear();
                        for (String p12 = parsableByteArray.p(); !TextUtils.isEmpty(p12); p12 = parsableByteArray.p()) {
                            if (this.f50341o.length() > 0) {
                                this.f50341o.append("<br>");
                            }
                            this.f50341o.append(E(p12, this.f50342p));
                        }
                        Spanned fromHtml = Html.fromHtml(this.f50341o.toString());
                        String str = null;
                        while (true) {
                            if (i11 >= this.f50342p.size()) {
                                break;
                            }
                            String str2 = this.f50342p.get(i11);
                            if (str2.matches("\\{\\\\an[1-9]\\}")) {
                                str = str2;
                                break;
                            }
                            i11++;
                        }
                        arrayList.add(B(fromHtml, str));
                        arrayList.add(e6.a.f48882r);
                    } else {
                        m.h("SubripDecoder", p11.length() != 0 ? "Skipping invalid timing: ".concat(p11) : new String("Skipping invalid timing: "));
                    }
                } catch (NumberFormatException unused) {
                    m.h("SubripDecoder", p10.length() != 0 ? "Skipping invalid index: ".concat(p10) : new String("Skipping invalid index: "));
                }
            }
        }
        return new b((e6.a[]) arrayList.toArray(new e6.a[0]), nVar.d());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final e6.a B(Spanned spanned, @Nullable String str) {
        char c4;
        char c10;
        a.b o10 = new a.b().o(spanned);
        if (str == null) {
            return o10.a();
        }
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        if (c4 == 0 || c4 == 1 || c4 == 2) {
            o10.l(0);
        } else if (c4 != 3 && c4 != 4 && c4 != 5) {
            o10.l(1);
        } else {
            o10.l(2);
        }
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    c10 = 6;
                    break;
                }
                c10 = 65535;
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    c10 = 7;
                    break;
                }
                c10 = 65535;
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    c10 = '\b';
                    break;
                }
                c10 = 65535;
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    c10 = 5;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        if (c10 == 0 || c10 == 1 || c10 == 2) {
            o10.i(2);
        } else if (c10 != 3 && c10 != 4 && c10 != 5) {
            o10.i(1);
        } else {
            o10.i(0);
        }
        return o10.k(C(o10.d())).h(C(o10.c()), 0).a();
    }

    public final String E(String str, ArrayList<String> arrayList) {
        String trim = str.trim();
        StringBuilder sb2 = new StringBuilder(trim);
        Matcher matcher = f50340r.matcher(trim);
        int i10 = 0;
        while (matcher.find()) {
            String group = matcher.group();
            arrayList.add(group);
            int start = matcher.start() - i10;
            int length = group.length();
            sb2.replace(start, start + length, "");
            i10 += length;
        }
        return sb2.toString();
    }
}
