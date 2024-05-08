package l6;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import e6.a;
import e6.c;
import e6.e;
import java.util.List;

/* compiled from: Tx3gDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends c {

    /* renamed from: o, reason: collision with root package name */
    public final ParsableByteArray f51669o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f51670p;

    /* renamed from: q, reason: collision with root package name */
    public final int f51671q;

    /* renamed from: r, reason: collision with root package name */
    public final int f51672r;

    /* renamed from: s, reason: collision with root package name */
    public final String f51673s;

    /* renamed from: t, reason: collision with root package name */
    public final float f51674t;

    /* renamed from: u, reason: collision with root package name */
    public final int f51675u;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        this.f51669o = new ParsableByteArray();
        if (list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.f51671q = bArr[24];
            this.f51672r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.f51673s = "Serif".equals(j0.F(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
            int i10 = bArr[25] * 20;
            this.f51675u = i10;
            boolean z10 = (bArr[0] & 32) != 0;
            this.f51670p = z10;
            if (z10) {
                this.f51674t = j0.q(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i10, 0.0f, 0.95f);
                return;
            } else {
                this.f51674t = 0.85f;
                return;
            }
        }
        this.f51671q = 0;
        this.f51672r = -1;
        this.f51673s = "sans-serif";
        this.f51670p = false;
        this.f51674t = 0.85f;
        this.f51675u = -1;
    }

    public static void C(boolean z10) throws SubtitleDecoderException {
        if (!z10) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    public static void D(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, int i14) {
        if (i10 != i11) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i10 >>> 8) | ((i10 & 255) << 24)), i12, i13, i14 | 33);
        }
    }

    public static void E(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, int i14) {
        if (i10 != i11) {
            int i15 = i14 | 33;
            boolean z10 = (i10 & 1) != 0;
            boolean z11 = (i10 & 2) != 0;
            if (z10) {
                if (z11) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i12, i13, i15);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i12, i13, i15);
                }
            } else if (z11) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i12, i13, i15);
            }
            boolean z12 = (i10 & 4) != 0;
            if (z12) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i12, i13, i15);
            }
            if (z12 || z10 || z11) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i12, i13, i15);
        }
    }

    public static void F(SpannableStringBuilder spannableStringBuilder, String str, int i10, int i11) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i10, i11, 16711713);
        }
    }

    public static String G(ParsableByteArray parsableByteArray) throws SubtitleDecoderException {
        char g3;
        C(parsableByteArray.a() >= 2);
        int J = parsableByteArray.J();
        if (J == 0) {
            return "";
        }
        if (parsableByteArray.a() >= 2 && ((g3 = parsableByteArray.g()) == 65279 || g3 == 65534)) {
            return parsableByteArray.B(J, com.google.common.base.c.f25964f);
        }
        return parsableByteArray.B(J, com.google.common.base.c.f25961c);
    }

    @Override // e6.c
    public e A(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException {
        this.f51669o.N(bArr, i10);
        String G = G(this.f51669o);
        if (G.isEmpty()) {
            return b.f51676c;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(G);
        E(spannableStringBuilder, this.f51671q, 0, 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
        D(spannableStringBuilder, this.f51672r, -1, 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
        F(spannableStringBuilder, this.f51673s, 0, spannableStringBuilder.length());
        float f10 = this.f51674t;
        while (this.f51669o.a() >= 8) {
            int e2 = this.f51669o.e();
            int n10 = this.f51669o.n();
            int n11 = this.f51669o.n();
            if (n11 == 1937013100) {
                C(this.f51669o.a() >= 2);
                int J = this.f51669o.J();
                for (int i11 = 0; i11 < J; i11++) {
                    B(this.f51669o, spannableStringBuilder);
                }
            } else if (n11 == 1952608120 && this.f51670p) {
                C(this.f51669o.a() >= 2);
                f10 = j0.q(this.f51669o.J() / this.f51675u, 0.0f, 0.95f);
            }
            this.f51669o.P(e2 + n10);
        }
        return new b(new a.b().o(spannableStringBuilder).h(f10, 0).i(0).a());
    }

    public final void B(ParsableByteArray parsableByteArray, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        int i10;
        C(parsableByteArray.a() >= 12);
        int J = parsableByteArray.J();
        int J2 = parsableByteArray.J();
        parsableByteArray.Q(2);
        int D = parsableByteArray.D();
        parsableByteArray.Q(1);
        int n10 = parsableByteArray.n();
        if (J2 > spannableStringBuilder.length()) {
            int length = spannableStringBuilder.length();
            StringBuilder sb2 = new StringBuilder(68);
            sb2.append("Truncating styl end (");
            sb2.append(J2);
            sb2.append(") to cueText.length() (");
            sb2.append(length);
            sb2.append(").");
            m.h("Tx3gDecoder", sb2.toString());
            i10 = spannableStringBuilder.length();
        } else {
            i10 = J2;
        }
        if (J >= i10) {
            StringBuilder sb3 = new StringBuilder(60);
            sb3.append("Ignoring styl with start (");
            sb3.append(J);
            sb3.append(") >= end (");
            sb3.append(i10);
            sb3.append(").");
            m.h("Tx3gDecoder", sb3.toString());
            return;
        }
        int i11 = i10;
        E(spannableStringBuilder, D, this.f51671q, J, i11, 0);
        D(spannableStringBuilder, n10, this.f51672r, J, i11, 0);
    }
}
