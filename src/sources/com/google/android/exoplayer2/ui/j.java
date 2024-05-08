package com.google.android.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.j;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: SpannedToHtmlConverter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f22681a = Pattern.compile("(&#13;)?&#10;");

    /* compiled from: SpannedToHtmlConverter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f22682a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<String, String> f22683b;

        public b(String str, Map<String, String> map) {
            this.f22682a = str;
            this.f22683b = map;
        }
    }

    /* compiled from: SpannedToHtmlConverter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c {

        /* renamed from: e, reason: collision with root package name */
        public static final Comparator<c> f22684e = new Comparator() { // from class: com.google.android.exoplayer2.ui.k
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e2;
                e2 = j.c.e((j.c) obj, (j.c) obj2);
                return e2;
            }
        };

        /* renamed from: f, reason: collision with root package name */
        public static final Comparator<c> f22685f = new Comparator() { // from class: com.google.android.exoplayer2.ui.l
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int f10;
                f10 = j.c.f((j.c) obj, (j.c) obj2);
                return f10;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final int f22686a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22687b;

        /* renamed from: c, reason: collision with root package name */
        public final String f22688c;

        /* renamed from: d, reason: collision with root package name */
        public final String f22689d;

        public static /* synthetic */ int e(c cVar, c cVar2) {
            int compare = Integer.compare(cVar2.f22687b, cVar.f22687b);
            if (compare != 0) {
                return compare;
            }
            int compareTo = cVar.f22688c.compareTo(cVar2.f22688c);
            return compareTo != 0 ? compareTo : cVar.f22689d.compareTo(cVar2.f22689d);
        }

        public static /* synthetic */ int f(c cVar, c cVar2) {
            int compare = Integer.compare(cVar2.f22686a, cVar.f22686a);
            if (compare != 0) {
                return compare;
            }
            int compareTo = cVar2.f22688c.compareTo(cVar.f22688c);
            return compareTo != 0 ? compareTo : cVar2.f22689d.compareTo(cVar.f22689d);
        }

        public c(int i10, int i11, String str, String str2) {
            this.f22686a = i10;
            this.f22687b = i11;
            this.f22688c = str;
            this.f22689d = str2;
        }
    }

    /* compiled from: SpannedToHtmlConverter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final List<c> f22690a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final List<c> f22691b = new ArrayList();
    }

    public static b a(@Nullable CharSequence charSequence, float f10) {
        if (charSequence == null) {
            return new b("", ImmutableMap.of());
        }
        if (!(charSequence instanceof Spanned)) {
            return new b(b(charSequence), ImmutableMap.of());
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet hashSet = new HashSet();
        int i10 = 0;
        for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
        }
        HashMap hashMap = new HashMap();
        Iterator<E> iterator2 = hashSet.iterator2();
        while (iterator2.hasNext()) {
            int intValue = ((Integer) iterator2.next()).intValue();
            StringBuilder sb2 = new StringBuilder(14);
            sb2.append("bg_");
            sb2.append(intValue);
            hashMap.put(g.a(sb2.toString()), com.google.android.exoplayer2.util.j0.D("background-color:%s;", g.b(intValue)));
        }
        SparseArray<d> c4 = c(spanned, f10);
        StringBuilder sb3 = new StringBuilder(spanned.length());
        int i11 = 0;
        while (i10 < c4.size()) {
            int keyAt = c4.keyAt(i10);
            sb3.append(b(spanned.subSequence(i11, keyAt)));
            d dVar = c4.get(keyAt);
            Collections.sort(dVar.f22691b, c.f22685f);
            Iterator iterator22 = dVar.f22691b.iterator2();
            while (iterator22.hasNext()) {
                sb3.append(((c) iterator22.next()).f22689d);
            }
            Collections.sort(dVar.f22690a, c.f22684e);
            Iterator iterator23 = dVar.f22690a.iterator2();
            while (iterator23.hasNext()) {
                sb3.append(((c) iterator23.next()).f22688c);
            }
            i10++;
            i11 = keyAt;
        }
        sb3.append(b(spanned.subSequence(i11, spanned.length())));
        return new b(sb3.toString(), hashMap);
    }

    public static String b(CharSequence charSequence) {
        return f22681a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    public static SparseArray<d> c(Spanned spanned, float f10) {
        SparseArray<d> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String e2 = e(obj, f10);
            String d10 = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (e2 != null) {
                com.google.android.exoplayer2.util.a.e(d10);
                c cVar = new c(spanStart, spanEnd, e2, d10);
                f(sparseArray, spanStart).f22690a.add(cVar);
                f(sparseArray, spanEnd).f22691b.add(cVar);
            }
        }
        return sparseArray;
    }

    @Nullable
    public static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof h6.a) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof h6.e)) {
            return "</span>";
        }
        if (obj instanceof TypefaceSpan) {
            if (((TypefaceSpan) obj).getFamily() != null) {
                return "</span>";
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style == 3) {
                return "</i></b>";
            }
        } else {
            if (obj instanceof h6.c) {
                String b4 = b(((h6.c) obj).f49524a);
                StringBuilder sb2 = new StringBuilder(String.valueOf(b4).length() + 16);
                sb2.append("<rt>");
                sb2.append(b4);
                sb2.append("</rt></ruby>");
                return sb2.toString();
            }
            if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
        }
        return null;
    }

    @Nullable
    public static String e(Object obj, float f10) {
        float size;
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return com.google.android.exoplayer2.util.j0.D("<span style='color:%s;'>", g.b(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return com.google.android.exoplayer2.util.j0.D("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof h6.a) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
            if (absoluteSizeSpan.getDip()) {
                size = absoluteSizeSpan.getSize();
            } else {
                size = absoluteSizeSpan.getSize() / f10;
            }
            return com.google.android.exoplayer2.util.j0.D("<span style='font-size:%.2fpx;'>", Float.valueOf(size));
        }
        if (obj instanceof RelativeSizeSpan) {
            return com.google.android.exoplayer2.util.j0.D("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        }
        if (obj instanceof TypefaceSpan) {
            String family = ((TypefaceSpan) obj).getFamily();
            if (family != null) {
                return com.google.android.exoplayer2.util.j0.D("<span style='font-family:\"%s\";'>", family);
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "<b>";
            }
            if (style == 2) {
                return "<i>";
            }
            if (style != 3) {
                return null;
            }
            return "<b><i>";
        }
        if (obj instanceof h6.c) {
            int i10 = ((h6.c) obj).f49525b;
            if (i10 == -1) {
                return "<ruby style='ruby-position:unset;'>";
            }
            if (i10 == 1) {
                return "<ruby style='ruby-position:over;'>";
            }
            if (i10 != 2) {
                return null;
            }
            return "<ruby style='ruby-position:under;'>";
        }
        if (obj instanceof UnderlineSpan) {
            return "<u>";
        }
        if (!(obj instanceof h6.e)) {
            return null;
        }
        h6.e eVar = (h6.e) obj;
        return com.google.android.exoplayer2.util.j0.D("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(eVar.f49526a, eVar.f49527b), g(eVar.f49528c));
    }

    public static d f(SparseArray<d> sparseArray, int i10) {
        d dVar = sparseArray.get(i10);
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        sparseArray.put(i10, dVar2);
        return dVar2;
    }

    public static String g(int i10) {
        return i10 != 2 ? "over right" : "under left";
    }

    public static String h(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        if (i11 == 1) {
            sb2.append("filled ");
        } else if (i11 == 2) {
            sb2.append("open ");
        }
        if (i10 == 0) {
            sb2.append("none");
        } else if (i10 == 1) {
            sb2.append("circle");
        } else if (i10 == 2) {
            sb2.append("dot");
        } else if (i10 != 3) {
            sb2.append("unset");
        } else {
            sb2.append("sesame");
        }
        return sb2.toString();
    }
}
