package i6;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.huawei.openalliance.ad.constant.u;
import e6.a;
import e6.e;
import i6.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: SsaDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends e6.c {

    /* renamed from: t, reason: collision with root package name */
    public static final Pattern f49805t = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: o, reason: collision with root package name */
    public final boolean f49806o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public final b f49807p;

    /* renamed from: q, reason: collision with root package name */
    public Map<String, c> f49808q;

    /* renamed from: r, reason: collision with root package name */
    public float f49809r;

    /* renamed from: s, reason: collision with root package name */
    public float f49810s;

    public a(@Nullable List<byte[]> list) {
        super("SsaDecoder");
        this.f49809r = -3.4028235E38f;
        this.f49810s = -3.4028235E38f;
        if (list != null && !list.isEmpty()) {
            this.f49806o = true;
            String E = j0.E(list.get(0));
            com.google.android.exoplayer2.util.a.a(E.startsWith("Format:"));
            this.f49807p = (b) com.google.android.exoplayer2.util.a.e(b.a(E));
            G(new ParsableByteArray(list.get(1)));
            return;
        }
        this.f49806o = false;
        this.f49807p = null;
    }

    public static int B(long j10, List<Long> list, List<List<e6.a>> list2) {
        int i10;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i10 = 0;
                break;
            }
            if (list.get(size).longValue() == j10) {
                return size;
            }
            if (list.get(size).longValue() < j10) {
                i10 = size + 1;
                break;
            }
            size--;
        }
        list.add(i10, Long.valueOf(j10));
        list2.add(i10, i10 == 0 ? new ArrayList() : new ArrayList(list2.get(i10 - 1)));
        return i10;
    }

    public static float C(int i10) {
        if (i10 == 0) {
            return 0.05f;
        }
        if (i10 != 1) {
            return i10 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    public static e6.a D(String str, @Nullable c cVar, c.b bVar, float f10, float f11) {
        SpannableString spannableString = new SpannableString(str);
        a.b o10 = new a.b().o(spannableString);
        if (cVar != null) {
            if (cVar.f49818c != null) {
                spannableString.setSpan(new ForegroundColorSpan(cVar.f49818c.intValue()), 0, spannableString.length(), 33);
            }
            float f12 = cVar.f49819d;
            if (f12 != -3.4028235E38f && f11 != -3.4028235E38f) {
                o10.q(f12 / f11, 1);
            }
            boolean z10 = cVar.f49820e;
            if (z10 && cVar.f49821f) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z10) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (cVar.f49821f) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (cVar.f49822g) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (cVar.f49823h) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i10 = bVar.f49837a;
        if (i10 == -1) {
            i10 = cVar != null ? cVar.f49817b : -1;
        }
        o10.p(M(i10)).l(L(i10)).i(K(i10));
        PointF pointF = bVar.f49838b;
        if (pointF != null && f11 != -3.4028235E38f && f10 != -3.4028235E38f) {
            o10.k(pointF.x / f10);
            o10.h(bVar.f49838b.y / f11, 0);
        } else {
            o10.k(C(o10.d()));
            o10.h(C(o10.c()), 0);
        }
        return o10.a();
    }

    public static Map<String, c> I(ParsableByteArray parsableByteArray) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c.a aVar = null;
        while (true) {
            String p10 = parsableByteArray.p();
            if (p10 == null || (parsableByteArray.a() != 0 && parsableByteArray.h() == 91)) {
                break;
            }
            if (p10.startsWith("Format:")) {
                aVar = c.a.a(p10);
            } else if (p10.startsWith("Style:")) {
                if (aVar == null) {
                    m.h("SsaDecoder", p10.length() != 0 ? "Skipping 'Style:' line before 'Format:' line: ".concat(p10) : new String("Skipping 'Style:' line before 'Format:' line: "));
                } else {
                    c b4 = c.b(p10, aVar);
                    if (b4 != null) {
                        linkedHashMap.put(b4.f49816a, b4);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static long J(String str) {
        Matcher matcher = f49805t.matcher(str.trim());
        if (matcher.matches()) {
            return (Long.parseLong((String) j0.j(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) j0.j(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) j0.j(matcher.group(3))) * 1000000) + (Long.parseLong((String) j0.j(matcher.group(4))) * 10000);
        }
        return -9223372036854775807L;
    }

    public static int K(int i10) {
        switch (i10) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                StringBuilder sb2 = new StringBuilder(30);
                sb2.append("Unknown alignment: ");
                sb2.append(i10);
                m.h("SsaDecoder", sb2.toString());
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
        }
    }

    public static int L(int i10) {
        switch (i10) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                StringBuilder sb2 = new StringBuilder(30);
                sb2.append("Unknown alignment: ");
                sb2.append(i10);
                m.h("SsaDecoder", sb2.toString());
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
        }
    }

    @Nullable
    public static Layout.Alignment M(int i10) {
        switch (i10) {
            case -1:
                return null;
            case 0:
            default:
                StringBuilder sb2 = new StringBuilder(30);
                sb2.append("Unknown alignment: ");
                sb2.append(i10);
                m.h("SsaDecoder", sb2.toString());
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    @Override // e6.c
    public e A(byte[] bArr, int i10, boolean z10) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i10);
        if (!this.f49806o) {
            G(parsableByteArray);
        }
        F(parsableByteArray, arrayList, arrayList2);
        return new d(arrayList, arrayList2);
    }

    public final void E(String str, b bVar, List<List<e6.a>> list, List<Long> list2) {
        int i10;
        com.google.android.exoplayer2.util.a.a(str.startsWith("Dialogue:"));
        String[] split = str.substring(9).split(",", bVar.f49815e);
        if (split.length != bVar.f49815e) {
            m.h("SsaDecoder", str.length() != 0 ? "Skipping dialogue line with fewer columns than format: ".concat(str) : new String("Skipping dialogue line with fewer columns than format: "));
            return;
        }
        long J = J(split[bVar.f49811a]);
        if (J == -9223372036854775807L) {
            m.h("SsaDecoder", str.length() != 0 ? "Skipping invalid timing: ".concat(str) : new String("Skipping invalid timing: "));
            return;
        }
        long J2 = J(split[bVar.f49812b]);
        if (J2 == -9223372036854775807L) {
            m.h("SsaDecoder", str.length() != 0 ? "Skipping invalid timing: ".concat(str) : new String("Skipping invalid timing: "));
            return;
        }
        Map<String, c> map = this.f49808q;
        c cVar = (map == null || (i10 = bVar.f49813c) == -1) ? null : map.get(split[i10].trim());
        String str2 = split[bVar.f49814d];
        e6.a D = D(c.b.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), cVar, c.b.b(str2), this.f49809r, this.f49810s);
        int B = B(J2, list2, list);
        for (int B2 = B(J, list2, list); B2 < B; B2++) {
            list.get(B2).add(D);
        }
    }

    public final void F(ParsableByteArray parsableByteArray, List<List<e6.a>> list, List<Long> list2) {
        b bVar = this.f49806o ? this.f49807p : null;
        while (true) {
            String p10 = parsableByteArray.p();
            if (p10 == null) {
                return;
            }
            if (p10.startsWith("Format:")) {
                bVar = b.a(p10);
            } else if (p10.startsWith("Dialogue:")) {
                if (bVar == null) {
                    m.h("SsaDecoder", p10.length() != 0 ? "Skipping dialogue line before complete format: ".concat(p10) : new String("Skipping dialogue line before complete format: "));
                } else {
                    E(p10, bVar, list, list2);
                }
            }
        }
    }

    public final void G(ParsableByteArray parsableByteArray) {
        while (true) {
            String p10 = parsableByteArray.p();
            if (p10 == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(p10)) {
                H(parsableByteArray);
            } else if ("[V4+ Styles]".equalsIgnoreCase(p10)) {
                this.f49808q = I(parsableByteArray);
            } else if ("[V4 Styles]".equalsIgnoreCase(p10)) {
                m.f("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(p10)) {
                return;
            }
        }
    }

    public final void H(ParsableByteArray parsableByteArray) {
        while (true) {
            String p10 = parsableByteArray.p();
            if (p10 == null) {
                return;
            }
            if (parsableByteArray.a() != 0 && parsableByteArray.h() == 91) {
                return;
            }
            String[] split = p10.split(u.bD);
            if (split.length == 2) {
                String e2 = com.google.common.base.a.e(split[0].trim());
                e2.hashCode();
                if (e2.equals("playresx")) {
                    this.f49809r = Float.parseFloat(split[1].trim());
                } else if (e2.equals("playresy")) {
                    try {
                        this.f49810s = Float.parseFloat(split[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }
}
