package m6;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;
import com.huawei.openalliance.ad.constant.u;
import com.kuaishou.weapon.p0.t;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import e6.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m6.f;

/* compiled from: WebvttCueParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f51903a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f51904b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c, reason: collision with root package name */
    public static final Map<String, Integer> f51905c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map<String, Integer> f51906d;

    /* compiled from: WebvttCueParser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b {

        /* renamed from: c, reason: collision with root package name */
        public static final Comparator<b> f51907c = new Comparator() { // from class: m6.g
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e2;
                e2 = f.b.e((f.b) obj, (f.b) obj2);
                return e2;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final c f51908a;

        /* renamed from: b, reason: collision with root package name */
        public final int f51909b;

        public static /* synthetic */ int e(b bVar, b bVar2) {
            return Integer.compare(bVar.f51908a.f51911b, bVar2.f51908a.f51911b);
        }

        public b(c cVar, int i10) {
            this.f51908a = cVar;
            this.f51909b = i10;
        }
    }

    /* compiled from: WebvttCueParser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f51910a;

        /* renamed from: b, reason: collision with root package name */
        public final int f51911b;

        /* renamed from: c, reason: collision with root package name */
        public final String f51912c;

        /* renamed from: d, reason: collision with root package name */
        public final Set<String> f51913d;

        public c(String str, int i10, String str2, Set<String> set) {
            this.f51911b = i10;
            this.f51910a = str;
            this.f51912c = str2;
            this.f51913d = set;
        }

        public static c a(String str, int i10) {
            String str2;
            String trim = str.trim();
            com.google.android.exoplayer2.util.a.a(!trim.isEmpty());
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] M0 = j0.M0(trim, "\\.");
            String str3 = M0[0];
            HashSet hashSet = new HashSet();
            for (int i11 = 1; i11 < M0.length; i11++) {
                hashSet.add(M0[i11]);
            }
            return new c(str3, i10, str2, hashSet);
        }

        public static c b() {
            return new c("", 0, "", Collections.emptySet());
        }
    }

    /* compiled from: WebvttCueParser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements Comparable<d> {

        /* renamed from: b, reason: collision with root package name */
        public final int f51914b;

        /* renamed from: c, reason: collision with root package name */
        public final m6.d f51915c;

        public d(int i10, m6.d dVar) {
            this.f51914b = i10;
            this.f51915c = dVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return Integer.compare(this.f51914b, dVar.f51914b);
        }
    }

    /* compiled from: WebvttCueParser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e {

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f51918c;

        /* renamed from: a, reason: collision with root package name */
        public long f51916a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f51917b = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f51919d = 2;

        /* renamed from: e, reason: collision with root package name */
        public float f51920e = -3.4028235E38f;

        /* renamed from: f, reason: collision with root package name */
        public int f51921f = 1;

        /* renamed from: g, reason: collision with root package name */
        public int f51922g = 0;

        /* renamed from: h, reason: collision with root package name */
        public float f51923h = -3.4028235E38f;

        /* renamed from: i, reason: collision with root package name */
        public int f51924i = Integer.MIN_VALUE;

        /* renamed from: j, reason: collision with root package name */
        public float f51925j = 1.0f;

        /* renamed from: k, reason: collision with root package name */
        public int f51926k = Integer.MIN_VALUE;

        public static float b(float f10, int i10) {
            if (f10 == -3.4028235E38f || i10 != 0 || (f10 >= 0.0f && f10 <= 1.0f)) {
                return f10 != -3.4028235E38f ? f10 : i10 == 0 ? 1.0f : -3.4028235E38f;
            }
            return 1.0f;
        }

        @Nullable
        public static Layout.Alignment c(int i10) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 != 5) {
                                StringBuilder sb2 = new StringBuilder(34);
                                sb2.append("Unknown textAlignment: ");
                                sb2.append(i10);
                                m.h("WebvttCueParser", sb2.toString());
                                return null;
                            }
                        }
                    }
                    return Layout.Alignment.ALIGN_OPPOSITE;
                }
                return Layout.Alignment.ALIGN_CENTER;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        public static float d(int i10, float f10) {
            if (i10 == 0) {
                return 1.0f - f10;
            }
            if (i10 == 1) {
                return f10 <= 0.5f ? f10 * 2.0f : (1.0f - f10) * 2.0f;
            }
            if (i10 == 2) {
                return f10;
            }
            throw new IllegalStateException(String.valueOf(i10));
        }

        public static float e(int i10) {
            if (i10 != 4) {
                return i10 != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        public static int f(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 3) {
                return 2;
            }
            if (i10 != 4) {
                return i10 != 5 ? 1 : 2;
            }
            return 0;
        }

        public m6.e a() {
            return new m6.e(g().a(), this.f51916a, this.f51917b);
        }

        public a.b g() {
            float f10 = this.f51923h;
            if (f10 == -3.4028235E38f) {
                f10 = e(this.f51919d);
            }
            int i10 = this.f51924i;
            if (i10 == Integer.MIN_VALUE) {
                i10 = f(this.f51919d);
            }
            a.b r10 = new a.b().p(c(this.f51919d)).h(b(this.f51920e, this.f51921f), this.f51921f).i(this.f51922g).k(f10).l(i10).n(Math.min(this.f51925j, d(i10, f10))).r(this.f51926k);
            CharSequence charSequence = this.f51918c;
            if (charSequence != null) {
                r10.o(charSequence);
            }
            return r10;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(WbCloudFaceContant.WHITE, Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put(WbCloudFaceContant.BLACK, Integer.valueOf(Color.rgb(0, 0, 0)));
        f51905c = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f51906d = Collections.unmodifiableMap(hashMap2);
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, Set<String> set, int i10, int i11) {
        for (String str : set) {
            Map<String, Integer> map = f51905c;
            if (map.containsKey(str)) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(map.get(str).intValue()), i10, i11, 33);
            } else {
                Map<String, Integer> map2 = f51906d;
                if (map2.containsKey(str)) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(map2.get(str).intValue()), i10, i11, 33);
                }
            }
        }
    }

    public static void b(String str, SpannableStringBuilder spannableStringBuilder) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals("gt")) {
                    c4 = 0;
                    break;
                }
                break;
            case 3464:
                if (str.equals("lt")) {
                    c4 = 1;
                    break;
                }
                break;
            case 96708:
                if (str.equals("amp")) {
                    c4 = 2;
                    break;
                }
                break;
            case 3374865:
                if (str.equals("nbsp")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                spannableStringBuilder.append('>');
                return;
            case 1:
                spannableStringBuilder.append('<');
                return;
            case 2:
                spannableStringBuilder.append(SymbolValues.CHAR_AND_SYMBOL);
                return;
            case 3:
                spannableStringBuilder.append(' ');
                return;
            default:
                StringBuilder sb2 = new StringBuilder(str.length() + 33);
                sb2.append("ignoring unsupported entity: '&");
                sb2.append(str);
                sb2.append(";'");
                m.h("WebvttCueParser", sb2.toString());
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(SpannableStringBuilder spannableStringBuilder, @Nullable String str, c cVar, List<b> list, List<m6.d> list2) {
        int i10 = i(list2, str, cVar);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, b.f51907c);
        int i11 = cVar.f51911b;
        int i12 = 0;
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            if ("rt".equals(((b) arrayList.get(i13)).f51908a.f51910a)) {
                b bVar = (b) arrayList.get(i13);
                int g3 = g(i(list2, str, bVar.f51908a), i10, 1);
                int i14 = bVar.f51908a.f51911b - i12;
                int i15 = bVar.f51909b - i12;
                CharSequence subSequence = spannableStringBuilder.subSequence(i14, i15);
                spannableStringBuilder.delete(i14, i15);
                spannableStringBuilder.setSpan(new h6.c(subSequence.toString(), g3), i11, i14, 33);
                i12 += subSequence.length();
                i11 = i14;
            }
        }
    }

    public static void d(@Nullable String str, c cVar, List<b> list, SpannableStringBuilder spannableStringBuilder, List<m6.d> list2) {
        int i10 = cVar.f51911b;
        int length = spannableStringBuilder.length();
        String str2 = cVar.f51910a;
        str2.hashCode();
        char c4 = 65535;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    c4 = 0;
                    break;
                }
                break;
            case 98:
                if (str2.equals("b")) {
                    c4 = 1;
                    break;
                }
                break;
            case 99:
                if (str2.equals("c")) {
                    c4 = 2;
                    break;
                }
                break;
            case 105:
                if (str2.equals(t.f36220e)) {
                    c4 = 3;
                    break;
                }
                break;
            case 117:
                if (str2.equals(t.f36224i)) {
                    c4 = 4;
                    break;
                }
                break;
            case 118:
                if (str2.equals(t.f36218c)) {
                    c4 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    c4 = 6;
                    break;
                }
                break;
            case 3511770:
                if (str2.equals("ruby")) {
                    c4 = 7;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 5:
            case 6:
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(1), i10, length, 33);
                break;
            case 2:
                a(spannableStringBuilder, cVar.f51913d, i10, length);
                break;
            case 3:
                spannableStringBuilder.setSpan(new StyleSpan(2), i10, length, 33);
                break;
            case 4:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i10, length, 33);
                break;
            case 7:
                c(spannableStringBuilder, str, cVar, list, list2);
                break;
            default:
                return;
        }
        List<d> h10 = h(list2, str, cVar);
        for (int i11 = 0; i11 < h10.size(); i11++) {
            e(spannableStringBuilder, h10.get(i11).f51915c, i10, length);
        }
    }

    public static void e(SpannableStringBuilder spannableStringBuilder, m6.d dVar, int i10, int i11) {
        if (dVar == null) {
            return;
        }
        if (dVar.i() != -1) {
            h6.d.a(spannableStringBuilder, new StyleSpan(dVar.i()), i10, i11, 33);
        }
        if (dVar.l()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i10, i11, 33);
        }
        if (dVar.m()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i10, i11, 33);
        }
        if (dVar.k()) {
            h6.d.a(spannableStringBuilder, new ForegroundColorSpan(dVar.c()), i10, i11, 33);
        }
        if (dVar.j()) {
            h6.d.a(spannableStringBuilder, new BackgroundColorSpan(dVar.a()), i10, i11, 33);
        }
        if (dVar.d() != null) {
            h6.d.a(spannableStringBuilder, new TypefaceSpan(dVar.d()), i10, i11, 33);
        }
        int f10 = dVar.f();
        if (f10 == 1) {
            h6.d.a(spannableStringBuilder, new AbsoluteSizeSpan((int) dVar.e(), true), i10, i11, 33);
        } else if (f10 == 2) {
            h6.d.a(spannableStringBuilder, new RelativeSizeSpan(dVar.e()), i10, i11, 33);
        } else if (f10 == 3) {
            h6.d.a(spannableStringBuilder, new RelativeSizeSpan(dVar.e() / 100.0f), i10, i11, 33);
        }
        if (dVar.b()) {
            spannableStringBuilder.setSpan(new h6.a(), i10, i11, 33);
        }
    }

    public static int f(String str, int i10) {
        int indexOf = str.indexOf(62, i10);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    public static int g(int i10, int i11, int i12) {
        if (i10 != -1) {
            return i10;
        }
        if (i11 != -1) {
            return i11;
        }
        if (i12 != -1) {
            return i12;
        }
        throw new IllegalArgumentException();
    }

    public static List<d> h(List<m6.d> list, @Nullable String str, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            m6.d dVar = list.get(i10);
            int h10 = dVar.h(str, cVar.f51910a, cVar.f51913d, cVar.f51912c);
            if (h10 > 0) {
                arrayList.add(new d(h10, dVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static int i(List<m6.d> list, @Nullable String str, c cVar) {
        List<d> h10 = h(list, str, cVar);
        for (int i10 = 0; i10 < h10.size(); i10++) {
            m6.d dVar = h10.get(i10).f51915c;
            if (dVar.g() != -1) {
                return dVar.g();
            }
        }
        return -1;
    }

    public static String j(String str) {
        String trim = str.trim();
        com.google.android.exoplayer2.util.a.a(!trim.isEmpty());
        return j0.N0(trim, "[ \\.]")[0];
    }

    public static boolean k(String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case 98:
                if (str.equals("b")) {
                    c4 = 0;
                    break;
                }
                break;
            case 99:
                if (str.equals("c")) {
                    c4 = 1;
                    break;
                }
                break;
            case 105:
                if (str.equals(t.f36220e)) {
                    c4 = 2;
                    break;
                }
                break;
            case 117:
                if (str.equals(t.f36224i)) {
                    c4 = 3;
                    break;
                }
                break;
            case 118:
                if (str.equals(t.f36218c)) {
                    c4 = 4;
                    break;
                }
                break;
            case 3650:
                if (str.equals("rt")) {
                    c4 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str.equals("lang")) {
                    c4 = 6;
                    break;
                }
                break;
            case 3511770:
                if (str.equals("ruby")) {
                    c4 = 7;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    public static e6.a l(CharSequence charSequence) {
        e eVar = new e();
        eVar.f51918c = charSequence;
        return eVar.g().a();
    }

    @Nullable
    public static m6.e m(ParsableByteArray parsableByteArray, List<m6.d> list) {
        String p10 = parsableByteArray.p();
        if (p10 == null) {
            return null;
        }
        Pattern pattern = f51903a;
        Matcher matcher = pattern.matcher(p10);
        if (matcher.matches()) {
            return n(null, matcher, parsableByteArray, list);
        }
        String p11 = parsableByteArray.p();
        if (p11 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(p11);
        if (matcher2.matches()) {
            return n(p10.trim(), matcher2, parsableByteArray, list);
        }
        return null;
    }

    @Nullable
    public static m6.e n(@Nullable String str, Matcher matcher, ParsableByteArray parsableByteArray, List<m6.d> list) {
        e eVar = new e();
        try {
            eVar.f51916a = i.d((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            eVar.f51917b = i.d((String) com.google.android.exoplayer2.util.a.e(matcher.group(2)));
            p((String) com.google.android.exoplayer2.util.a.e(matcher.group(3)), eVar);
            StringBuilder sb2 = new StringBuilder();
            String p10 = parsableByteArray.p();
            while (!TextUtils.isEmpty(p10)) {
                if (sb2.length() > 0) {
                    sb2.append("\n");
                }
                sb2.append(p10.trim());
                p10 = parsableByteArray.p();
            }
            eVar.f51918c = q(str, sb2.toString(), list);
            return eVar.a();
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(matcher.group());
            m.h("WebvttCueParser", valueOf.length() != 0 ? "Skipping cue with bad header: ".concat(valueOf) : new String("Skipping cue with bad header: "));
            return null;
        }
    }

    public static a.b o(String str) {
        e eVar = new e();
        p(str, eVar);
        return eVar.g();
    }

    public static void p(String str, e eVar) {
        Matcher matcher = f51904b.matcher(str);
        while (matcher.find()) {
            String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
            String str3 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    s(str3, eVar);
                } else if ("align".equals(str2)) {
                    eVar.f51919d = v(str3);
                } else if ("position".equals(str2)) {
                    u(str3, eVar);
                } else if ("size".equals(str2)) {
                    eVar.f51925j = i.c(str3);
                } else if ("vertical".equals(str2)) {
                    eVar.f51926k = w(str3);
                } else {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 21 + String.valueOf(str3).length());
                    sb2.append("Unknown cue setting ");
                    sb2.append(str2);
                    sb2.append(u.bD);
                    sb2.append(str3);
                    m.h("WebvttCueParser", sb2.toString());
                }
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(matcher.group());
                m.h("WebvttCueParser", valueOf.length() != 0 ? "Skipping bad cue setting: ".concat(valueOf) : new String("Skipping bad cue setting: "));
            }
        }
    }

    public static SpannedString q(@Nullable String str, String str2, List<m6.d> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 < str2.length()) {
            char charAt = str2.charAt(i10);
            if (charAt == '&') {
                i10++;
                int indexOf = str2.indexOf(59, i10);
                int indexOf2 = str2.indexOf(32, i10);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    b(str2.substring(i10, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i10 = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i10++;
            } else {
                int i11 = i10 + 1;
                if (i11 < str2.length()) {
                    boolean z10 = str2.charAt(i11) == '/';
                    i11 = f(str2, i11);
                    int i12 = i11 - 2;
                    boolean z11 = str2.charAt(i12) == '/';
                    int i13 = i10 + (z10 ? 2 : 1);
                    if (!z11) {
                        i12 = i11 - 1;
                    }
                    String substring = str2.substring(i13, i12);
                    if (!substring.trim().isEmpty()) {
                        String j10 = j(substring);
                        if (k(j10)) {
                            if (!z10) {
                                if (!z11) {
                                    arrayDeque.push(c.a(substring, spannableStringBuilder.length()));
                                }
                            }
                            while (!arrayDeque.isEmpty()) {
                                c cVar = (c) arrayDeque.pop();
                                d(str, cVar, arrayList, spannableStringBuilder, list);
                                if (!arrayDeque.isEmpty()) {
                                    arrayList.add(new b(cVar, spannableStringBuilder.length()));
                                } else {
                                    arrayList.clear();
                                }
                                if (cVar.f51910a.equals(j10)) {
                                    break;
                                }
                            }
                        }
                    }
                }
                i10 = i11;
            }
        }
        while (!arrayDeque.isEmpty()) {
            d(str, (c) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        d(str, c.b(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    public static int r(String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(CSSAlignValue.AlignKey.CENTER)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c4 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c4 = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 0;
            default:
                m.h("WebvttCueParser", str.length() != 0 ? "Invalid anchor value: ".concat(str) : new String("Invalid anchor value: "));
                return Integer.MIN_VALUE;
        }
    }

    public static void s(String str, e eVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            eVar.f51922g = r(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            eVar.f51920e = i.c(str);
            eVar.f51921f = 0;
        } else {
            eVar.f51920e = Integer.parseInt(str);
            eVar.f51921f = 1;
        }
    }

    public static int t(String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1842484672:
                if (str.equals("line-left")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals(CSSAlignValue.AlignKey.CENTER)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1276788989:
                if (str.equals("line-right")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c4 = 3;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c4 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 5:
                return 0;
            case 1:
            case 3:
                return 1;
            case 2:
            case 4:
                return 2;
            default:
                m.h("WebvttCueParser", str.length() != 0 ? "Invalid anchor value: ".concat(str) : new String("Invalid anchor value: "));
                return Integer.MIN_VALUE;
        }
    }

    public static void u(String str, e eVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            eVar.f51924i = t(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        eVar.f51923h = i.c(str);
    }

    public static int v(String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(CSSAlignValue.AlignKey.CENTER)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c4 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c4 = 2;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c4 = 3;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    c4 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 1;
            default:
                m.h("WebvttCueParser", str.length() != 0 ? "Invalid alignment value: ".concat(str) : new String("Invalid alignment value: "));
                return 2;
        }
    }

    public static int w(String str) {
        str.hashCode();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        m.h("WebvttCueParser", str.length() != 0 ? "Invalid 'vertical' value: ".concat(str) : new String("Invalid 'vertical' value: "));
        return Integer.MIN_VALUE;
    }
}
