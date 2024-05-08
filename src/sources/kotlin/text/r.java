package kotlin.text;

import java.util.Iterator;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: _Strings.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class r extends q {

    /* compiled from: Iterables.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements Iterable<Character>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CharSequence f51119b;

        public a(CharSequence charSequence) {
            this.f51119b = charSequence;
        }

        @Override // java.lang.Iterable
        @NotNull
        /* renamed from: iterator */
        public Iterator<Character> iterator2() {
            return StringsKt__StringsKt.Z(this.f51119b);
        }
    }

    @NotNull
    public static final Iterable<Character> S0(@NotNull CharSequence charSequence) {
        s.i(charSequence, "<this>");
        if (charSequence instanceof String) {
            if (charSequence.length() == 0) {
                return kotlin.collections.s.j();
            }
        }
        return new a(charSequence);
    }

    @NotNull
    public static final String T0(@NotNull String str, int i10) {
        s.i(str, "<this>");
        if (i10 >= 0) {
            String substring = str.substring(ce.n.d(i10, str.length()));
            s.h(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    @NotNull
    public static final String U0(@NotNull String str, int i10) {
        s.i(str, "<this>");
        if (i10 >= 0) {
            return W0(str, ce.n.b(str.length() - i10, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    @Nullable
    public static final Character V0(@NotNull CharSequence charSequence, int i10) {
        s.i(charSequence, "<this>");
        if (i10 < 0 || i10 > StringsKt__StringsKt.R(charSequence)) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i10));
    }

    @NotNull
    public static final String W0(@NotNull String str, int i10) {
        s.i(str, "<this>");
        if (i10 >= 0) {
            String substring = str.substring(0, ce.n.d(i10, str.length()));
            s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }
}
