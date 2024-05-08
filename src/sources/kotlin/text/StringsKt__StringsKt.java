package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.e0;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Strings.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class StringsKt__StringsKt extends p {

    /* compiled from: Strings.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a extends kotlin.collections.q {

        /* renamed from: b, reason: collision with root package name */
        public int f51094b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CharSequence f51095c;

        public a(CharSequence charSequence) {
            this.f51095c = charSequence;
        }

        @Override // kotlin.collections.q
        public char a() {
            CharSequence charSequence = this.f51095c;
            int i10 = this.f51094b;
            this.f51094b = i10 + 1;
            return charSequence.charAt(i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f51094b < this.f51095c.length();
        }
    }

    @NotNull
    public static final kotlin.sequences.g<String> A0(@NotNull final CharSequence charSequence, @NotNull String[] delimiters, boolean z10, int i10) {
        s.i(charSequence, "<this>");
        s.i(delimiters, "delimiters");
        return SequencesKt___SequencesKt.r(m0(charSequence, delimiters, 0, z10, i10, 2, null), new Function1<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull IntRange it) {
                s.i(it, "it");
                return StringsKt__StringsKt.E0(CharSequence.this, it);
            }
        });
    }

    public static /* synthetic */ kotlin.sequences.g B0(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return A0(charSequence, strArr, z10, i10);
    }

    public static final boolean C0(@NotNull CharSequence charSequence, @NotNull CharSequence prefix, boolean z10) {
        s.i(charSequence, "<this>");
        s.i(prefix, "prefix");
        if (!z10 && (charSequence instanceof String) && (prefix instanceof String)) {
            return p.F((String) charSequence, (String) prefix, false, 2, null);
        }
        return n0(charSequence, 0, prefix, 0, prefix.length(), z10);
    }

    public static /* synthetic */ boolean D0(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return C0(charSequence, charSequence2, z10);
    }

    @NotNull
    public static final String E0(@NotNull CharSequence charSequence, @NotNull IntRange range) {
        s.i(charSequence, "<this>");
        s.i(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    @NotNull
    public static final String F0(@NotNull String str, char c4, @NotNull String missingDelimiterValue) {
        s.i(str, "<this>");
        s.i(missingDelimiterValue, "missingDelimiterValue");
        int W = W(str, c4, 0, false, 6, null);
        if (W == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(W + 1, str.length());
        s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String G0(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        s.i(str, "<this>");
        s.i(delimiter, "delimiter");
        s.i(missingDelimiterValue, "missingDelimiterValue");
        int X = X(str, delimiter, 0, false, 6, null);
        if (X == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(X + delimiter.length(), str.length());
        s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean H(@NotNull CharSequence charSequence, char c4, boolean z10) {
        s.i(charSequence, "<this>");
        return W(charSequence, c4, 0, z10, 2, null) >= 0;
    }

    public static /* synthetic */ String H0(String str, char c4, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return F0(str, c4, str2);
    }

    public static final boolean I(@NotNull CharSequence charSequence, @NotNull CharSequence other, boolean z10) {
        s.i(charSequence, "<this>");
        s.i(other, "other");
        if (other instanceof String) {
            if (X(charSequence, (String) other, 0, z10, 2, null) >= 0) {
                return true;
            }
        } else if (V(charSequence, other, 0, charSequence.length(), z10, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ String I0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return G0(str, str2, str3);
    }

    public static /* synthetic */ boolean J(CharSequence charSequence, char c4, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return H(charSequence, c4, z10);
    }

    @NotNull
    public static final String J0(@NotNull String str, char c4, @NotNull String missingDelimiterValue) {
        s.i(str, "<this>");
        s.i(missingDelimiterValue, "missingDelimiterValue");
        int c02 = c0(str, c4, 0, false, 6, null);
        if (c02 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(c02 + 1, str.length());
        s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ boolean K(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return I(charSequence, charSequence2, z10);
    }

    public static /* synthetic */ String K0(String str, char c4, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return J0(str, c4, str2);
    }

    public static final boolean L(@NotNull CharSequence charSequence, char c4, boolean z10) {
        s.i(charSequence, "<this>");
        return charSequence.length() > 0 && b.d(charSequence.charAt(R(charSequence)), c4, z10);
    }

    @NotNull
    public static final String L0(@NotNull String str, char c4, @NotNull String missingDelimiterValue) {
        s.i(str, "<this>");
        s.i(missingDelimiterValue, "missingDelimiterValue");
        int W = W(str, c4, 0, false, 6, null);
        if (W == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, W);
        s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean M(@NotNull CharSequence charSequence, @NotNull CharSequence suffix, boolean z10) {
        s.i(charSequence, "<this>");
        s.i(suffix, "suffix");
        if (!z10 && (charSequence instanceof String) && (suffix instanceof String)) {
            return p.q((String) charSequence, (String) suffix, false, 2, null);
        }
        return n0(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z10);
    }

    @NotNull
    public static final String M0(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        s.i(str, "<this>");
        s.i(delimiter, "delimiter");
        s.i(missingDelimiterValue, "missingDelimiterValue");
        int X = X(str, delimiter, 0, false, 6, null);
        if (X == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, X);
        s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ boolean N(CharSequence charSequence, char c4, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return L(charSequence, c4, z10);
    }

    public static /* synthetic */ String N0(String str, char c4, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return L0(str, c4, str2);
    }

    public static /* synthetic */ boolean O(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return M(charSequence, charSequence2, z10);
    }

    public static /* synthetic */ String O0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return M0(str, str2, str3);
    }

    public static final Pair<Integer, String> P(CharSequence charSequence, Collection<String> collection, int i10, boolean z10, boolean z11) {
        String str;
        String str2;
        if (!z10 && collection.size() == 1) {
            String str3 = (String) CollectionsKt___CollectionsKt.o0(collection);
            int X = !z11 ? X(charSequence, str3, i10, false, 4, null) : d0(charSequence, str3, i10, false, 4, null);
            if (X < 0) {
                return null;
            }
            return kotlin.f.a(Integer.valueOf(X), str3);
        }
        ce.h intRange = !z11 ? new IntRange(ce.n.b(i10, 0), charSequence.length()) : ce.n.g(ce.n.d(i10, R(charSequence)), 0);
        if (charSequence instanceof String) {
            int b4 = intRange.b();
            int c4 = intRange.c();
            int f10 = intRange.f();
            if ((f10 > 0 && b4 <= c4) || (f10 < 0 && c4 <= b4)) {
                while (true) {
                    Iterator<String> iterator2 = collection.iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            str2 = null;
                            break;
                        }
                        str2 = iterator2.next();
                        String str4 = str2;
                        if (p.u(str4, 0, (String) charSequence, b4, str4.length(), z10)) {
                            break;
                        }
                    }
                    String str5 = str2;
                    if (str5 == null) {
                        if (b4 == c4) {
                            break;
                        }
                        b4 += f10;
                    } else {
                        return kotlin.f.a(Integer.valueOf(b4), str5);
                    }
                }
            }
        } else {
            int b10 = intRange.b();
            int c10 = intRange.c();
            int f11 = intRange.f();
            if ((f11 > 0 && b10 <= c10) || (f11 < 0 && c10 <= b10)) {
                while (true) {
                    Iterator<String> iterator22 = collection.iterator2();
                    while (true) {
                        if (!iterator22.hasNext()) {
                            str = null;
                            break;
                        }
                        str = iterator22.next();
                        String str6 = str;
                        if (n0(str6, 0, charSequence, b10, str6.length(), z10)) {
                            break;
                        }
                    }
                    String str7 = str;
                    if (str7 == null) {
                        if (b10 == c10) {
                            break;
                        }
                        b10 += f11;
                    } else {
                        return kotlin.f.a(Integer.valueOf(b10), str7);
                    }
                }
            }
        }
        return null;
    }

    @NotNull
    public static final CharSequence P0(@NotNull CharSequence charSequence) {
        s.i(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean c4 = kotlin.text.a.c(charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!c4) {
                    break;
                }
                length--;
            } else if (c4) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    @NotNull
    public static final IntRange Q(@NotNull CharSequence charSequence) {
        s.i(charSequence, "<this>");
        return new IntRange(0, charSequence.length() - 1);
    }

    @NotNull
    public static final CharSequence Q0(@NotNull CharSequence charSequence, @NotNull char... chars) {
        s.i(charSequence, "<this>");
        s.i(chars, "chars");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (!kotlin.collections.m.s(chars, charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return "";
    }

    public static final int R(@NotNull CharSequence charSequence) {
        s.i(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    @NotNull
    public static final String R0(@NotNull String str, @NotNull char... chars) {
        CharSequence charSequence;
        s.i(str, "<this>");
        s.i(chars, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (!kotlin.collections.m.s(chars, str.charAt(length))) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    public static final int S(@NotNull CharSequence charSequence, char c4, int i10, boolean z10) {
        s.i(charSequence, "<this>");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c4, i10);
        }
        return Y(charSequence, new char[]{c4}, i10, z10);
    }

    public static final int T(@NotNull CharSequence charSequence, @NotNull String string, int i10, boolean z10) {
        s.i(charSequence, "<this>");
        s.i(string, "string");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i10);
        }
        return V(charSequence, string, i10, charSequence.length(), z10, false, 16, null);
    }

    public static final int U(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        ce.h g3;
        if (!z11) {
            g3 = new IntRange(ce.n.b(i10, 0), ce.n.d(i11, charSequence.length()));
        } else {
            g3 = ce.n.g(ce.n.d(i10, R(charSequence)), ce.n.b(i11, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int b4 = g3.b();
            int c4 = g3.c();
            int f10 = g3.f();
            if ((f10 <= 0 || b4 > c4) && (f10 >= 0 || c4 > b4)) {
                return -1;
            }
            while (!p.u((String) charSequence2, 0, (String) charSequence, b4, charSequence2.length(), z10)) {
                if (b4 == c4) {
                    return -1;
                }
                b4 += f10;
            }
            return b4;
        }
        int b10 = g3.b();
        int c10 = g3.c();
        int f11 = g3.f();
        if ((f11 <= 0 || b10 > c10) && (f11 >= 0 || c10 > b10)) {
            return -1;
        }
        while (!n0(charSequence2, 0, charSequence, b10, charSequence2.length(), z10)) {
            if (b10 == c10) {
                return -1;
            }
            b10 += f11;
        }
        return b10;
    }

    public static /* synthetic */ int V(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        return U(charSequence, charSequence2, i10, i11, z10, (i12 & 16) != 0 ? false : z11);
    }

    public static /* synthetic */ int W(CharSequence charSequence, char c4, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return S(charSequence, c4, i10, z10);
    }

    public static /* synthetic */ int X(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return T(charSequence, str, i10, z10);
    }

    public static final int Y(@NotNull CharSequence charSequence, @NotNull char[] chars, int i10, boolean z10) {
        boolean z11;
        s.i(charSequence, "<this>");
        s.i(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kotlin.collections.m.I(chars), i10);
        }
        e0 iterator2 = new IntRange(ce.n.b(i10, 0), R(charSequence)).iterator2();
        while (iterator2.hasNext()) {
            int nextInt = iterator2.nextInt();
            char charAt = charSequence.charAt(nextInt);
            int length = chars.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    z11 = false;
                    break;
                }
                if (b.d(chars[i11], charAt, z10)) {
                    z11 = true;
                    break;
                }
                i11++;
            }
            if (z11) {
                return nextInt;
            }
        }
        return -1;
    }

    @NotNull
    public static final kotlin.collections.q Z(@NotNull CharSequence charSequence) {
        s.i(charSequence, "<this>");
        return new a(charSequence);
    }

    public static final int a0(@NotNull CharSequence charSequence, char c4, int i10, boolean z10) {
        s.i(charSequence, "<this>");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c4, i10);
        }
        return e0(charSequence, new char[]{c4}, i10, z10);
    }

    public static final int b0(@NotNull CharSequence charSequence, @NotNull String string, int i10, boolean z10) {
        s.i(charSequence, "<this>");
        s.i(string, "string");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(string, i10);
        }
        return U(charSequence, string, i10, 0, z10, true);
    }

    public static /* synthetic */ int c0(CharSequence charSequence, char c4, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = R(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return a0(charSequence, c4, i10, z10);
    }

    public static /* synthetic */ int d0(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = R(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return b0(charSequence, str, i10, z10);
    }

    public static final int e0(@NotNull CharSequence charSequence, @NotNull char[] chars, int i10, boolean z10) {
        s.i(charSequence, "<this>");
        s.i(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(kotlin.collections.m.I(chars), i10);
        }
        for (int d10 = ce.n.d(i10, R(charSequence)); -1 < d10; d10--) {
            char charAt = charSequence.charAt(d10);
            int length = chars.length;
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (b.d(chars[i11], charAt, z10)) {
                    z11 = true;
                    break;
                }
                i11++;
            }
            if (z11) {
                return d10;
            }
        }
        return -1;
    }

    @NotNull
    public static final kotlin.sequences.g<String> f0(@NotNull CharSequence charSequence) {
        s.i(charSequence, "<this>");
        return B0(charSequence, new String[]{IOUtils.LINE_SEPARATOR_WINDOWS, "\n", StringUtils.CR}, false, 0, 6, null);
    }

    @NotNull
    public static final List<String> g0(@NotNull CharSequence charSequence) {
        s.i(charSequence, "<this>");
        return SequencesKt___SequencesKt.u(f0(charSequence));
    }

    @NotNull
    public static final CharSequence h0(@NotNull CharSequence charSequence, int i10, char c4) {
        s.i(charSequence, "<this>");
        if (i10 >= 0) {
            if (i10 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb2 = new StringBuilder(i10);
            e0 iterator2 = new IntRange(1, i10 - charSequence.length()).iterator2();
            while (iterator2.hasNext()) {
                iterator2.nextInt();
                sb2.append(c4);
            }
            sb2.append(charSequence);
            return sb2;
        }
        throw new IllegalArgumentException("Desired length " + i10 + " is less than zero.");
    }

    @NotNull
    public static final String i0(@NotNull String str, int i10, char c4) {
        s.i(str, "<this>");
        return h0(str, i10, c4).toString();
    }

    public static final kotlin.sequences.g<IntRange> j0(CharSequence charSequence, final char[] cArr, int i10, final boolean z10, int i11) {
        u0(i11);
        return new d(charSequence, i10, i11, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> mo1743invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            @Nullable
            public final Pair<Integer, Integer> invoke(@NotNull CharSequence $receiver, int i12) {
                s.i($receiver, "$this$$receiver");
                int Y = StringsKt__StringsKt.Y($receiver, cArr, i12, z10);
                if (Y < 0) {
                    return null;
                }
                return kotlin.f.a(Integer.valueOf(Y), 1);
            }
        });
    }

    public static final kotlin.sequences.g<IntRange> k0(CharSequence charSequence, String[] strArr, int i10, final boolean z10, int i11) {
        u0(i11);
        final List d10 = kotlin.collections.l.d(strArr);
        return new d(charSequence, i10, i11, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> mo1743invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            @Nullable
            public final Pair<Integer, Integer> invoke(@NotNull CharSequence $receiver, int i12) {
                Pair P;
                s.i($receiver, "$this$$receiver");
                P = StringsKt__StringsKt.P($receiver, d10, i12, z10, false);
                if (P != null) {
                    return kotlin.f.a(P.getFirst(), Integer.valueOf(((String) P.getSecond()).length()));
                }
                return null;
            }
        });
    }

    public static /* synthetic */ kotlin.sequences.g l0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return j0(charSequence, cArr, i10, z10, i11);
    }

    public static /* synthetic */ kotlin.sequences.g m0(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return k0(charSequence, strArr, i10, z10, i11);
    }

    public static final boolean n0(@NotNull CharSequence charSequence, int i10, @NotNull CharSequence other, int i11, int i12, boolean z10) {
        s.i(charSequence, "<this>");
        s.i(other, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > other.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!b.d(charSequence.charAt(i10 + i13), other.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final String o0(@NotNull String str, @NotNull CharSequence prefix) {
        s.i(str, "<this>");
        s.i(prefix, "prefix");
        if (!D0(str, prefix, false, 2, null)) {
            return str;
        }
        String substring = str.substring(prefix.length());
        s.h(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @NotNull
    public static final CharSequence p0(@NotNull CharSequence charSequence, @NotNull CharSequence suffix) {
        s.i(charSequence, "<this>");
        s.i(suffix, "suffix");
        if (O(charSequence, suffix, false, 2, null)) {
            return charSequence.subSequence(0, charSequence.length() - suffix.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @NotNull
    public static final String q0(@NotNull String str, @NotNull CharSequence suffix) {
        s.i(str, "<this>");
        s.i(suffix, "suffix");
        if (!O(str, suffix, false, 2, null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - suffix.length());
        s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String r0(@NotNull String str, @NotNull CharSequence delimiter) {
        s.i(str, "<this>");
        s.i(delimiter, "delimiter");
        return s0(str, delimiter, delimiter);
    }

    @NotNull
    public static final String s0(@NotNull String str, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        s.i(str, "<this>");
        s.i(prefix, "prefix");
        s.i(suffix, "suffix");
        if (str.length() < prefix.length() + suffix.length() || !D0(str, prefix, false, 2, null) || !O(str, suffix, false, 2, null)) {
            return str;
        }
        String substring = str.substring(prefix.length(), str.length() - suffix.length());
        s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final CharSequence t0(@NotNull CharSequence charSequence, int i10, int i11, @NotNull CharSequence replacement) {
        s.i(charSequence, "<this>");
        s.i(replacement, "replacement");
        if (i11 >= i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(charSequence, 0, i10);
            s.h(sb2, "this.append(value, startIndex, endIndex)");
            sb2.append(replacement);
            sb2.append(charSequence, i11, charSequence.length());
            s.h(sb2, "this.append(value, startIndex, endIndex)");
            return sb2;
        }
        throw new IndexOutOfBoundsException("End index (" + i11 + ") is less than start index (" + i10 + ").");
    }

    public static final void u0(int i10) {
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i10).toString());
    }

    @NotNull
    public static final List<String> v0(@NotNull CharSequence charSequence, @NotNull char[] delimiters, boolean z10, int i10) {
        s.i(charSequence, "<this>");
        s.i(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return x0(charSequence, String.valueOf(delimiters[0]), z10, i10);
        }
        Iterable g3 = SequencesKt___SequencesKt.g(l0(charSequence, delimiters, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(t.t(g3, 10));
        Iterator iterator2 = g3.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(E0(charSequence, (IntRange) iterator2.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final List<String> w0(@NotNull CharSequence charSequence, @NotNull String[] delimiters, boolean z10, int i10) {
        s.i(charSequence, "<this>");
        s.i(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (!(str.length() == 0)) {
                return x0(charSequence, str, z10, i10);
            }
        }
        Iterable g3 = SequencesKt___SequencesKt.g(m0(charSequence, delimiters, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(t.t(g3, 10));
        Iterator iterator2 = g3.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(E0(charSequence, (IntRange) iterator2.next()));
        }
        return arrayList;
    }

    public static final List<String> x0(CharSequence charSequence, String str, boolean z10, int i10) {
        u0(i10);
        int i11 = 0;
        int T = T(charSequence, str, 0, z10);
        if (T != -1 && i10 != 1) {
            boolean z11 = i10 > 0;
            ArrayList arrayList = new ArrayList(z11 ? ce.n.d(i10, 10) : 10);
            do {
                arrayList.add(charSequence.subSequence(i11, T).toString());
                i11 = str.length() + T;
                if (z11 && arrayList.size() == i10 - 1) {
                    break;
                }
                T = T(charSequence, str, i11, z10);
            } while (T != -1);
            arrayList.add(charSequence.subSequence(i11, charSequence.length()).toString());
            return arrayList;
        }
        return kotlin.collections.r.e(charSequence.toString());
    }

    public static /* synthetic */ List y0(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return v0(charSequence, cArr, z10, i10);
    }

    public static /* synthetic */ List z0(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return w0(charSequence, strArr, z10, i10);
    }
}
