package k6;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import java.util.ArrayDeque;
import java.util.Map;
import org.apache.commons.io.IOUtils;

/* compiled from: TtmlRenderUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f {
    public static void a(Spannable spannable, int i10, int i11, g gVar, @Nullable d dVar, Map<String, g> map, int i12) {
        d e2;
        g f10;
        int i13;
        if (gVar.l() != -1) {
            spannable.setSpan(new StyleSpan(gVar.l()), i10, i11, 33);
        }
        if (gVar.s()) {
            spannable.setSpan(new StrikethroughSpan(), i10, i11, 33);
        }
        if (gVar.t()) {
            spannable.setSpan(new UnderlineSpan(), i10, i11, 33);
        }
        if (gVar.q()) {
            h6.d.a(spannable, new ForegroundColorSpan(gVar.c()), i10, i11, 33);
        }
        if (gVar.p()) {
            h6.d.a(spannable, new BackgroundColorSpan(gVar.b()), i10, i11, 33);
        }
        if (gVar.d() != null) {
            h6.d.a(spannable, new TypefaceSpan(gVar.d()), i10, i11, 33);
        }
        if (gVar.o() != null) {
            b bVar = (b) com.google.android.exoplayer2.util.a.e(gVar.o());
            int i14 = bVar.f50668a;
            if (i14 == -1) {
                i14 = (i12 == 2 || i12 == 1) ? 3 : 1;
                i13 = 1;
            } else {
                i13 = bVar.f50669b;
            }
            int i15 = bVar.f50670c;
            if (i15 == -2) {
                i15 = 1;
            }
            h6.d.a(spannable, new h6.e(i14, i13, i15), i10, i11, 33);
        }
        int j10 = gVar.j();
        if (j10 == 2) {
            d d10 = d(dVar, map);
            if (d10 != null && (e2 = e(d10, map)) != null) {
                if (e2.g() == 1 && e2.f(0).f50689b != null) {
                    String str = (String) j0.j(e2.f(0).f50689b);
                    g f11 = f(e2.f50693f, e2.l(), map);
                    int i16 = f11 != null ? f11.i() : -1;
                    if (i16 == -1 && (f10 = f(d10.f50693f, d10.l(), map)) != null) {
                        i16 = f10.i();
                    }
                    spannable.setSpan(new h6.c(str, i16), i10, i11, 33);
                } else {
                    m.f("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                }
            }
        } else if (j10 == 3 || j10 == 4) {
            spannable.setSpan(new a(), i10, i11, 33);
        }
        if (gVar.n()) {
            h6.d.a(spannable, new h6.a(), i10, i11, 33);
        }
        int f12 = gVar.f();
        if (f12 == 1) {
            h6.d.a(spannable, new AbsoluteSizeSpan((int) gVar.e(), true), i10, i11, 33);
        } else if (f12 == 2) {
            h6.d.a(spannable, new RelativeSizeSpan(gVar.e()), i10, i11, 33);
        } else {
            if (f12 != 3) {
                return;
            }
            h6.d.a(spannable, new RelativeSizeSpan(gVar.e() / 100.0f), i10, i11, 33);
        }
    }

    public static String b(String str) {
        return str.replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    public static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    @Nullable
    public static d d(@Nullable d dVar, Map<String, g> map) {
        while (dVar != null) {
            g f10 = f(dVar.f50693f, dVar.l(), map);
            if (f10 != null && f10.j() == 1) {
                return dVar;
            }
            dVar = dVar.f50697j;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static d e(d dVar, Map<String, g> map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(dVar);
        while (!arrayDeque.isEmpty()) {
            d dVar2 = (d) arrayDeque.pop();
            g f10 = f(dVar2.f50693f, dVar2.l(), map);
            if (f10 != null && f10.j() == 3) {
                return dVar2;
            }
            for (int g3 = dVar2.g() - 1; g3 >= 0; g3--) {
                arrayDeque.push(dVar2.f(g3));
            }
        }
        return null;
    }

    @Nullable
    public static g f(@Nullable g gVar, @Nullable String[] strArr, Map<String, g> map) {
        int i10 = 0;
        if (gVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                g gVar2 = new g();
                int length = strArr.length;
                while (i10 < length) {
                    gVar2.a(map.get(strArr[i10]));
                    i10++;
                }
                return gVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return gVar.a(map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i10 < length2) {
                    gVar.a(map.get(strArr[i10]));
                    i10++;
                }
            }
        }
        return gVar;
    }
}
