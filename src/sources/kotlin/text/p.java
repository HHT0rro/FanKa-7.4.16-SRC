package kotlin.text;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import kotlin.collections.e0;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StringsJVM.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class p extends o {
    public static /* synthetic */ String A(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return y(str, str2, str3, z10);
    }

    @NotNull
    public static final String B(@NotNull String str, @NotNull String oldValue, @NotNull String newValue, boolean z10) {
        s.i(str, "<this>");
        s.i(oldValue, "oldValue");
        s.i(newValue, "newValue");
        int X = StringsKt__StringsKt.X(str, oldValue, 0, z10, 2, null);
        return X < 0 ? str : StringsKt__StringsKt.t0(str, X, oldValue.length() + X, newValue).toString();
    }

    public static final boolean C(@NotNull String str, @NotNull String prefix, int i10, boolean z10) {
        s.i(str, "<this>");
        s.i(prefix, "prefix");
        if (!z10) {
            return str.startsWith(prefix, i10);
        }
        return u(str, i10, prefix, 0, prefix.length(), z10);
    }

    public static final boolean D(@NotNull String str, @NotNull String prefix, boolean z10) {
        s.i(str, "<this>");
        s.i(prefix, "prefix");
        if (!z10) {
            return str.startsWith(prefix);
        }
        return u(str, 0, prefix, 0, prefix.length(), z10);
    }

    public static /* synthetic */ boolean E(String str, String str2, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return C(str, str2, i10, z10);
    }

    public static /* synthetic */ boolean F(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return D(str, str2, z10);
    }

    @NotNull
    public static final String n(@NotNull String str) {
        s.i(str, "<this>");
        Locale locale = Locale.getDefault();
        s.h(locale, "getDefault()");
        return o(str, locale);
    }

    @NotNull
    public static final String o(@NotNull String str, @NotNull Locale locale) {
        s.i(str, "<this>");
        s.i(locale, "locale");
        if (!(str.length() > 0)) {
            return str;
        }
        char charAt = str.charAt(0);
        if (!Character.isLowerCase(charAt)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        char titleCase = Character.toTitleCase(charAt);
        if (titleCase != Character.toUpperCase(charAt)) {
            sb2.append(titleCase);
        } else {
            String substring = str.substring(0, 1);
            s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            s.g(substring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = substring.toUpperCase(locale);
            s.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
            sb2.append(upperCase);
        }
        String substring2 = str.substring(1);
        s.h(substring2, "this as java.lang.String).substring(startIndex)");
        sb2.append(substring2);
        String sb3 = sb2.toString();
        s.h(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public static final boolean p(@NotNull String str, @NotNull String suffix, boolean z10) {
        s.i(str, "<this>");
        s.i(suffix, "suffix");
        if (!z10) {
            return str.endsWith(suffix);
        }
        return u(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean q(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return p(str, str2, z10);
    }

    public static final boolean r(@Nullable String str, @Nullable String str2, boolean z10) {
        if (str == null) {
            return str2 == null;
        }
        if (!z10) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    @NotNull
    public static final Comparator<String> s(@NotNull y yVar) {
        s.i(yVar, "<this>");
        Comparator<String> CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        s.h(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    public static final boolean t(@NotNull CharSequence charSequence) {
        boolean z10;
        s.i(charSequence, "<this>");
        if (charSequence.length() != 0) {
            Iterable Q = StringsKt__StringsKt.Q(charSequence);
            if (!(Q instanceof Collection) || !((Collection) Q).isEmpty()) {
                Iterator iterator2 = Q.iterator2();
                while (iterator2.hasNext()) {
                    if (!a.c(charSequence.charAt(((e0) iterator2).nextInt()))) {
                        z10 = false;
                        break;
                    }
                }
            }
            z10 = true;
            if (!z10) {
                return false;
            }
        }
        return true;
    }

    public static final boolean u(@NotNull String str, int i10, @NotNull String other, int i11, int i12, boolean z10) {
        s.i(str, "<this>");
        s.i(other, "other");
        if (!z10) {
            return str.regionMatches(i10, other, i11, i12);
        }
        return str.regionMatches(z10, i10, other, i11, i12);
    }

    @NotNull
    public static final String w(@NotNull CharSequence charSequence, int i10) {
        s.i(charSequence, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i10 + '.').toString());
        }
        if (i10 == 0) {
            return "";
        }
        if (i10 != 1) {
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb2 = new StringBuilder(charSequence.length() * i10);
                e0 iterator2 = new IntRange(1, i10).iterator2();
                while (iterator2.hasNext()) {
                    iterator2.nextInt();
                    sb2.append(charSequence);
                }
                String sb3 = sb2.toString();
                s.h(sb3, "{\n                    va…tring()\n                }");
                return sb3;
            }
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                cArr[i11] = charAt;
            }
            return new String(cArr);
        }
        return charSequence.toString();
    }

    @NotNull
    public static final String x(@NotNull String str, char c4, char c10, boolean z10) {
        s.i(str, "<this>");
        if (!z10) {
            String replace = str.replace(c4, c10);
            s.h(replace, "this as java.lang.String…replace(oldChar, newChar)");
            return replace;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (b.d(charAt, c4, z10)) {
                charAt = c10;
            }
            sb2.append(charAt);
        }
        String sb3 = sb2.toString();
        s.h(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public static final String y(@NotNull String str, @NotNull String oldValue, @NotNull String newValue, boolean z10) {
        s.i(str, "<this>");
        s.i(oldValue, "oldValue");
        s.i(newValue, "newValue");
        int i10 = 0;
        int T = StringsKt__StringsKt.T(str, oldValue, 0, z10);
        if (T < 0) {
            return str;
        }
        int length = oldValue.length();
        int b4 = ce.n.b(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 >= 0) {
            StringBuilder sb2 = new StringBuilder(length2);
            do {
                sb2.append((CharSequence) str, i10, T);
                sb2.append(newValue);
                i10 = T + length;
                if (T >= str.length()) {
                    break;
                }
                T = StringsKt__StringsKt.T(str, oldValue, T + b4, z10);
            } while (T > 0);
            sb2.append((CharSequence) str, i10, str.length());
            String sb3 = sb2.toString();
            s.h(sb3, "stringBuilder.append(this, i, length).toString()");
            return sb3;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String z(String str, char c4, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return x(str, c4, c10, z10);
    }
}
