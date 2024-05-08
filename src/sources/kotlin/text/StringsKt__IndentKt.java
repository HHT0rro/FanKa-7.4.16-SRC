package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Indent.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class StringsKt__IndentKt extends i {
    public static final Function1<String, String> b(final String str) {
        return str.length() == 0 ? new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull String line) {
                s.i(line, "line");
                return line;
            }
        } : new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull String line) {
                s.i(line, "line");
                return String.this + line;
            }
        };
    }

    public static final int c(String str) {
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            if (!a.c(str.charAt(i10))) {
                break;
            }
            i10++;
        }
        return i10 == -1 ? str.length() : i10;
    }

    @NotNull
    public static final String d(@NotNull String str, @NotNull String newIndent) {
        String invoke;
        s.i(str, "<this>");
        s.i(newIndent, "newIndent");
        List<String> g02 = StringsKt__StringsKt.g0(str);
        ArrayList arrayList = new ArrayList();
        for (String str2 : g02) {
            if (!p.t(str2)) {
                arrayList.add(str2);
            }
        }
        ArrayList arrayList2 = new ArrayList(t.t(arrayList, 10));
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            arrayList2.add(Integer.valueOf(c((String) iterator2.next())));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.i0(arrayList2);
        int i10 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * g02.size());
        Function1<String, String> b4 = b(newIndent);
        int l10 = kotlin.collections.s.l(g02);
        ArrayList arrayList3 = new ArrayList();
        for (String str3 : g02) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            String str4 = str3;
            if ((i10 == 0 || i10 == l10) && p.t(str4)) {
                str4 = null;
            } else {
                String T0 = r.T0(str4, intValue);
                if (T0 != null && (invoke = b4.invoke(T0)) != null) {
                    str4 = invoke;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i10 = i11;
        }
        String sb2 = ((StringBuilder) CollectionsKt___CollectionsKt.a0(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        s.h(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb2;
    }

    @NotNull
    public static final String e(@NotNull String str, @NotNull String newIndent, @NotNull String marginPrefix) {
        int i10;
        String invoke;
        s.i(str, "<this>");
        s.i(newIndent, "newIndent");
        s.i(marginPrefix, "marginPrefix");
        if (!p.t(marginPrefix)) {
            List<String> g02 = StringsKt__StringsKt.g0(str);
            int length = str.length() + (newIndent.length() * g02.size());
            Function1<String, String> b4 = b(newIndent);
            int l10 = kotlin.collections.s.l(g02);
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            for (String str2 : g02) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.s.s();
                }
                String str3 = str2;
                String str4 = null;
                if ((i11 == 0 || i11 == l10) && p.t(str3)) {
                    str3 = null;
                } else {
                    int length2 = str3.length();
                    int i13 = 0;
                    while (true) {
                        if (i13 >= length2) {
                            i10 = -1;
                            break;
                        }
                        if (!a.c(str3.charAt(i13))) {
                            i10 = i13;
                            break;
                        }
                        i13++;
                    }
                    if (i10 != -1) {
                        int i14 = i10;
                        if (p.E(str3, marginPrefix, i10, false, 4, null)) {
                            int length3 = i14 + marginPrefix.length();
                            s.g(str3, "null cannot be cast to non-null type java.lang.String");
                            str4 = str3.substring(length3);
                            s.h(str4, "this as java.lang.String).substring(startIndex)");
                        }
                    }
                    if (str4 != null && (invoke = b4.invoke(str4)) != null) {
                        str3 = invoke;
                    }
                }
                if (str3 != null) {
                    arrayList.add(str3);
                }
                i11 = i12;
            }
            String sb2 = ((StringBuilder) CollectionsKt___CollectionsKt.a0(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
            s.h(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb2;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    @NotNull
    public static final String f(@NotNull String str) {
        s.i(str, "<this>");
        return d(str, "");
    }

    @NotNull
    public static final String g(@NotNull String str, @NotNull String marginPrefix) {
        s.i(str, "<this>");
        s.i(marginPrefix, "marginPrefix");
        return e(str, "", marginPrefix);
    }

    public static /* synthetic */ String h(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "|";
        }
        return g(str, str2);
    }
}
