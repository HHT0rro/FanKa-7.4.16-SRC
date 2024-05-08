package z0;

import android.graphics.Paint;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.cupidapp.live.R$string;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StringExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class t {
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.text.SpannableString a(@org.jetbrains.annotations.NotNull java.lang.String r12, @androidx.annotation.ColorInt int r13) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.s.i(r12, r0)
            int r0 = r12.length()
            r1 = 0
            r2 = 0
        Lb:
            r3 = 35
            r4 = 1
            r5 = -1
            if (r2 >= r0) goto L20
            char r6 = r12.charAt(r2)
            if (r6 != r3) goto L19
            r6 = 1
            goto L1a
        L19:
            r6 = 0
        L1a:
            if (r6 == 0) goto L1d
            goto L21
        L1d:
            int r2 = r2 + 1
            goto Lb
        L20:
            r2 = -1
        L21:
            if (r2 < 0) goto L62
            int r0 = r12.length()
            int r0 = r0 + r5
            if (r0 < 0) goto L3e
        L2a:
            int r6 = r0 + (-1)
            char r7 = r12.charAt(r0)
            if (r7 != r3) goto L34
            r7 = 1
            goto L35
        L34:
            r7 = 0
        L35:
            if (r7 == 0) goto L39
            r5 = r0
            goto L3e
        L39:
            if (r6 >= 0) goto L3c
            goto L3e
        L3c:
            r0 = r6
            goto L2a
        L3e:
            if (r5 <= r2) goto L62
            int r0 = r12.length()
            if (r5 >= r0) goto L62
            android.text.SpannableString r0 = new android.text.SpannableString
            r9 = 0
            r10 = 4
            r11 = 0
            java.lang.String r7 = "#"
            java.lang.String r8 = " "
            r6 = r12
            java.lang.String r1 = kotlin.text.p.A(r6, r7, r8, r9, r10, r11)
            r0.<init>(r1)
            android.text.style.ForegroundColorSpan r1 = new android.text.style.ForegroundColorSpan
            r1.<init>(r13)
            r13 = 33
            r0.setSpan(r1, r2, r5, r13)
            goto L63
        L62:
            r0 = 0
        L63:
            if (r0 != 0) goto L6a
            android.text.SpannableString r0 = new android.text.SpannableString
            r0.<init>(r12)
        L6a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.t.a(java.lang.String, int):android.text.SpannableString");
    }

    public static final boolean b(@NotNull String str) {
        kotlin.jvm.internal.s.i(str, "<this>");
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (g(str.codePointAt(i10))) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static final String c(@NotNull String str) {
        kotlin.jvm.internal.s.i(str, "<this>");
        Matcher matcher = Pattern.compile("(\r?\n(\\s*\r?\n)+)").matcher(str);
        return matcher.find() ? matcher.replaceAll("\n") : str;
    }

    @NotNull
    public static final SpannableStringBuilder d(@NotNull SpannableStringBuilder spannableStringBuilder) {
        kotlin.jvm.internal.s.i(spannableStringBuilder, "<this>");
        Matcher matcher = Pattern.compile("(\r?\n(\\s*\r?\n)+)").matcher(spannableStringBuilder);
        if (!matcher.find()) {
            return spannableStringBuilder;
        }
        SpannableStringBuilder replace = spannableStringBuilder.replace(matcher.start(), matcher.end(), "\n\n");
        kotlin.jvm.internal.s.h(replace, "{\n        val start = ma…cher.end(), \"\\n\\n\")\n    }");
        return replace;
    }

    @NotNull
    public static final String e(@NotNull String str) {
        kotlin.jvm.internal.s.i(str, "<this>");
        Matcher matcher = Pattern.compile("(\r?\n(\\s*\r?\n)+)").matcher(str);
        if (!matcher.find()) {
            return str;
        }
        String replaceAll = matcher.replaceAll("\n\n");
        kotlin.jvm.internal.s.h(replaceAll, "{\n        matcher.replaceAll(\"\\n\\n\")\n    }");
        return replaceAll;
    }

    public static final float f(@NotNull String str, @NotNull Paint paint) {
        kotlin.jvm.internal.s.i(str, "<this>");
        kotlin.jvm.internal.s.i(paint, "paint");
        return paint.measureText(str);
    }

    public static final boolean g(int i10) {
        return (i10 == 0 || i10 == 9 || i10 == 10 || i10 == 13 || (i10 >= 32 && i10 <= 55295) || ((i10 >= 57344 && i10 <= 65533) || (i10 >= 65536 && i10 <= 1114111))) ? false : true;
    }

    public static final void h(@NotNull String password, @NotNull Function2<? super Boolean, ? super Integer, kotlin.p> callback) {
        boolean z10;
        kotlin.jvm.internal.s.i(password, "password");
        kotlin.jvm.internal.s.i(callback, "callback");
        int length = password.length();
        if (8 <= length && length < 21) {
            char[] charArray = password.toCharArray();
            kotlin.jvm.internal.s.h(charArray, "this as java.lang.String).toCharArray()");
            int length2 = charArray.length;
            int i10 = 0;
            boolean z11 = false;
            boolean z12 = false;
            boolean z13 = false;
            while (true) {
                if (i10 >= length2) {
                    z10 = false;
                    break;
                }
                char c4 = charArray[i10];
                if ('0' <= c4 && c4 < ':') {
                    z11 = true;
                } else {
                    if (!('A' <= c4 && c4 < '[')) {
                        if (!('a' <= c4 && c4 < '{')) {
                            if (!('!' <= c4 && c4 < '0')) {
                                if (!(':' <= c4 && c4 < 'A')) {
                                    if (!('[' <= c4 && c4 < 'a')) {
                                        if (!('{' <= c4 && c4 < 127)) {
                                            z10 = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            z13 = true;
                        }
                    }
                    z12 = true;
                }
                i10++;
            }
            boolean z14 = (z11 && z12) || (z11 && z13) || (z12 && z13);
            if (z10) {
                callback.mo1743invoke(Boolean.FALSE, Integer.valueOf(R$string.password_only_contain_letters_numbers_symbols));
                return;
            } else if (z14) {
                callback.mo1743invoke(Boolean.TRUE, null);
                return;
            } else {
                callback.mo1743invoke(Boolean.FALSE, Integer.valueOf(R$string.password_contain_at_least_two_type));
                return;
            }
        }
        callback.mo1743invoke(Boolean.FALSE, Integer.valueOf(R$string.password_length_condition));
    }

    @NotNull
    public static final String i(@NotNull String str, @NotNull Map<String, String> map) {
        kotlin.jvm.internal.s.i(str, "<this>");
        kotlin.jvm.internal.s.i(map, "map");
        String str2 = str;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str2 = kotlin.text.p.A(str2, entry.getKey(), entry.getValue(), false, 4, null);
        }
        return str2;
    }

    @Nullable
    public static final SpannableString j(@NotNull String str, int i10, @NotNull String[] spanStr, boolean z10) {
        kotlin.jvm.internal.s.i(str, "<this>");
        kotlin.jvm.internal.s.i(spanStr, "spanStr");
        return l(str, new ForegroundColorSpan(i10), (String[]) Arrays.copyOf(spanStr, spanStr.length), z10);
    }

    public static /* synthetic */ SpannableString k(String str, int i10, String[] strArr, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = true;
        }
        return j(str, i10, strArr, z10);
    }

    @Nullable
    public static final SpannableString l(@NotNull String str, @NotNull CharacterStyle what, @NotNull String[] spanStr, boolean z10) {
        kotlin.jvm.internal.s.i(str, "<this>");
        kotlin.jvm.internal.s.i(what, "what");
        kotlin.jvm.internal.s.i(spanStr, "spanStr");
        SpannableString spannableString = new SpannableString(str);
        m(spannableString, what, (String[]) Arrays.copyOf(spanStr, spanStr.length), z10);
        return spannableString;
    }

    public static final void m(@NotNull SpannableString spannableString, @NotNull CharacterStyle what, @NotNull String[] spanStr, boolean z10) {
        kotlin.jvm.internal.s.i(spannableString, "<this>");
        kotlin.jvm.internal.s.i(what, "what");
        kotlin.jvm.internal.s.i(spanStr, "spanStr");
        for (String str : spanStr) {
            if (str != null) {
                int T = StringsKt__StringsKt.T(spannableString, str, 0, z10);
                int length = str.length() + T;
                if (T == -1) {
                    length = 0;
                    T = 0;
                }
                spannableString.setSpan(CharacterStyle.wrap(what), T, length, 17);
            }
        }
    }

    public static /* synthetic */ SpannableString n(String str, CharacterStyle characterStyle, String[] strArr, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        return l(str, characterStyle, strArr, z10);
    }

    @NotNull
    public static final String o(@Nullable String str, int i10, @NotNull CharSequence replacement) {
        kotlin.jvm.internal.s.i(replacement, "replacement");
        return str == null || str.length() == 0 ? "" : str.length() >= i10 ? StringsKt__StringsKt.t0(str, i10, str.length(), replacement).toString() : str;
    }

    public static /* synthetic */ String p(String str, int i10, CharSequence charSequence, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            charSequence = "...";
        }
        return o(str, i10, charSequence);
    }

    public static final int q(@NotNull String str) {
        kotlin.jvm.internal.s.i(str, "<this>");
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static final long r(@NotNull String str) {
        kotlin.jvm.internal.s.i(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }
}
