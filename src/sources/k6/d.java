package k6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.Attributes;
import com.kuaishou.weapon.p0.t;
import e6.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: TtmlNode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f50688a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f50689b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f50690c;

    /* renamed from: d, reason: collision with root package name */
    public final long f50691d;

    /* renamed from: e, reason: collision with root package name */
    public final long f50692e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final g f50693f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final String[] f50694g;

    /* renamed from: h, reason: collision with root package name */
    public final String f50695h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final String f50696i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public final d f50697j;

    /* renamed from: k, reason: collision with root package name */
    public final HashMap<String, Integer> f50698k;

    /* renamed from: l, reason: collision with root package name */
    public final HashMap<String, Integer> f50699l;

    /* renamed from: m, reason: collision with root package name */
    public List<d> f50700m;

    public d(@Nullable String str, @Nullable String str2, long j10, long j11, @Nullable g gVar, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable d dVar) {
        this.f50688a = str;
        this.f50689b = str2;
        this.f50696i = str4;
        this.f50693f = gVar;
        this.f50694g = strArr;
        this.f50690c = str2 != null;
        this.f50691d = j10;
        this.f50692e = j11;
        this.f50695h = (String) com.google.android.exoplayer2.util.a.e(str3);
        this.f50697j = dVar;
        this.f50698k = new HashMap<>();
        this.f50699l = new HashMap<>();
    }

    public static d c(@Nullable String str, long j10, long j11, @Nullable g gVar, @Nullable String[] strArr, String str2, @Nullable String str3, @Nullable d dVar) {
        return new d(str, null, j10, j11, gVar, strArr, str2, str3, dVar);
    }

    public static d d(String str) {
        return new d(null, f.b(str), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static void e(SpannableStringBuilder spannableStringBuilder) {
        for (a aVar : (a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), a.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar), spannableStringBuilder.getSpanEnd(aVar), "");
        }
        for (int i10 = 0; i10 < spannableStringBuilder.length(); i10++) {
            if (spannableStringBuilder.charAt(i10) == ' ') {
                int i11 = i10 + 1;
                int i12 = i11;
                while (i12 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i12) == ' ') {
                    i12++;
                }
                int i13 = i12 - i11;
                if (i13 > 0) {
                    spannableStringBuilder.delete(i10, i13 + i10);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i14 = 0; i14 < spannableStringBuilder.length() - 1; i14++) {
            if (spannableStringBuilder.charAt(i14) == '\n') {
                int i15 = i14 + 1;
                if (spannableStringBuilder.charAt(i15) == ' ') {
                    spannableStringBuilder.delete(i15, i14 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i16 = 0; i16 < spannableStringBuilder.length() - 1; i16++) {
            if (spannableStringBuilder.charAt(i16) == ' ') {
                int i17 = i16 + 1;
                if (spannableStringBuilder.charAt(i17) == '\n') {
                    spannableStringBuilder.delete(i16, i17);
                }
            }
        }
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
            return;
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
    }

    public static SpannableStringBuilder k(String str, Map<String, a.b> map) {
        if (!map.containsKey(str)) {
            a.b bVar = new a.b();
            bVar.o(new SpannableStringBuilder());
            map.put(str, bVar);
        }
        return (SpannableStringBuilder) com.google.android.exoplayer2.util.a.e(map.get(str).e());
    }

    public void a(d dVar) {
        if (this.f50700m == null) {
            this.f50700m = new ArrayList();
        }
        this.f50700m.add(dVar);
    }

    public final void b(Map<String, g> map, a.b bVar, int i10, int i11, int i12) {
        g f10 = f.f(this.f50693f, this.f50694g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) bVar.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            bVar.o(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (f10 != null) {
            f.a(spannableStringBuilder2, i10, i11, f10, this.f50697j, map, i12);
            if (t.f36217b.equals(this.f50688a)) {
                if (f10.k() != Float.MAX_VALUE) {
                    bVar.m((f10.k() * (-90.0f)) / 100.0f);
                }
                if (f10.m() != null) {
                    bVar.p(f10.m());
                }
                if (f10.h() != null) {
                    bVar.j(f10.h());
                }
            }
        }
    }

    public d f(int i10) {
        List<d> list = this.f50700m;
        if (list != null) {
            return list.get(i10);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List<d> list = this.f50700m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<e6.a> h(long j10, Map<String, g> map, Map<String, e> map2, Map<String, String> map3) {
        ArrayList arrayList = new ArrayList();
        n(j10, this.f50695h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j10, false, this.f50695h, treeMap);
        o(j10, map, map2, this.f50695h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                e eVar = (e) com.google.android.exoplayer2.util.a.e(map2.get(pair.first));
                arrayList2.add(new a.b().f(decodeByteArray).k(eVar.f50702b).l(0).h(eVar.f50703c, 0).i(eVar.f50705e).n(eVar.f50706f).g(eVar.f50707g).r(eVar.f50710j).a());
            }
        }
        for (Map.Entry<String, a.b> entry : treeMap.entrySet()) {
            e eVar2 = (e) com.google.android.exoplayer2.util.a.e(map2.get(entry.getKey()));
            a.b value = entry.getValue();
            e((SpannableStringBuilder) com.google.android.exoplayer2.util.a.e(value.e()));
            value.h(eVar2.f50703c, eVar2.f50704d);
            value.i(eVar2.f50705e);
            value.k(eVar2.f50702b);
            value.n(eVar2.f50706f);
            value.q(eVar2.f50709i, eVar2.f50708h);
            value.r(eVar2.f50710j);
            arrayList2.add(value.a());
        }
        return arrayList2;
    }

    public final void i(TreeSet<Long> treeSet, boolean z10) {
        boolean equals = t.f36217b.equals(this.f50688a);
        boolean equals2 = Attributes.Component.DIV.equals(this.f50688a);
        if (z10 || equals || (equals2 && this.f50696i != null)) {
            long j10 = this.f50691d;
            if (j10 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j10));
            }
            long j11 = this.f50692e;
            if (j11 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j11));
            }
        }
        if (this.f50700m == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f50700m.size(); i10++) {
            this.f50700m.get(i10).i(treeSet, z10 || equals);
        }
    }

    public long[] j() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i10 = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> iterator2 = treeSet.iterator2();
        while (iterator2.hasNext()) {
            jArr[i10] = iterator2.next().longValue();
            i10++;
        }
        return jArr;
    }

    @Nullable
    public String[] l() {
        return this.f50694g;
    }

    public boolean m(long j10) {
        long j11 = this.f50691d;
        return (j11 == -9223372036854775807L && this.f50692e == -9223372036854775807L) || (j11 <= j10 && this.f50692e == -9223372036854775807L) || ((j11 == -9223372036854775807L && j10 < this.f50692e) || (j11 <= j10 && j10 < this.f50692e));
    }

    public final void n(long j10, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.f50695h)) {
            str = this.f50695h;
        }
        if (m(j10) && Attributes.Component.DIV.equals(this.f50688a) && this.f50696i != null) {
            list.add(new Pair<>(str, this.f50696i));
            return;
        }
        for (int i10 = 0; i10 < g(); i10++) {
            f(i10).n(j10, str, list);
        }
    }

    public final void o(long j10, Map<String, g> map, Map<String, e> map2, String str, Map<String, a.b> map3) {
        int i10;
        if (m(j10)) {
            String str2 = "".equals(this.f50695h) ? str : this.f50695h;
            Iterator<Map.Entry<String, Integer>> iterator2 = this.f50699l.entrySet().iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                Map.Entry<String, Integer> next = iterator2.next();
                String key = next.getKey();
                int intValue = this.f50698k.containsKey(key) ? this.f50698k.get(key).intValue() : 0;
                int intValue2 = next.getValue().intValue();
                if (intValue != intValue2) {
                    b(map, (a.b) com.google.android.exoplayer2.util.a.e(map3.get(key)), intValue, intValue2, ((e) com.google.android.exoplayer2.util.a.e(map2.get(str2))).f50710j);
                }
            }
            for (i10 = 0; i10 < g(); i10++) {
                f(i10).o(j10, map, map2, str2, map3);
            }
        }
    }

    public final void p(long j10, boolean z10, String str, Map<String, a.b> map) {
        this.f50698k.clear();
        this.f50699l.clear();
        if ("metadata".equals(this.f50688a)) {
            return;
        }
        if (!"".equals(this.f50695h)) {
            str = this.f50695h;
        }
        if (this.f50690c && z10) {
            k(str, map).append((CharSequence) com.google.android.exoplayer2.util.a.e(this.f50689b));
            return;
        }
        if ("br".equals(this.f50688a) && z10) {
            k(str, map).append('\n');
            return;
        }
        if (m(j10)) {
            for (Map.Entry<String, a.b> entry : map.entrySet()) {
                this.f50698k.put(entry.getKey(), Integer.valueOf(((CharSequence) com.google.android.exoplayer2.util.a.e(entry.getValue().e())).length()));
            }
            boolean equals = t.f36217b.equals(this.f50688a);
            for (int i10 = 0; i10 < g(); i10++) {
                f(i10).p(j10, z10 || equals, str, map);
            }
            if (equals) {
                f.c(k(str, map));
            }
            for (Map.Entry<String, a.b> entry2 : map.entrySet()) {
                this.f50699l.put(entry2.getKey(), Integer.valueOf(((CharSequence) com.google.android.exoplayer2.util.a.e(entry2.getValue().e())).length()));
            }
        }
    }
}
