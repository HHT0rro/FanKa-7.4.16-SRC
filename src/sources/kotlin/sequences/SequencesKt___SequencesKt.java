package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: _Sequences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SequencesKt___SequencesKt extends l {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a<T> implements Iterable<T>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f51063b;

        public a(g gVar) {
            this.f51063b = gVar;
        }

        @Override // java.lang.Iterable
        @NotNull
        /* renamed from: iterator */
        public Iterator<T> iterator2() {
            return this.f51063b.iterator();
        }
    }

    @NotNull
    public static final <T> Iterable<T> g(@NotNull g<? extends T> gVar) {
        s.i(gVar, "<this>");
        return new a(gVar);
    }

    public static final <T> int h(@NotNull g<? extends T> gVar) {
        s.i(gVar, "<this>");
        Iterator<? extends T> it = gVar.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            it.next();
            i10++;
            if (i10 < 0) {
                kotlin.collections.s.r();
            }
        }
        return i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> g<T> i(@NotNull g<? extends T> gVar, int i10) {
        s.i(gVar, "<this>");
        if (i10 >= 0) {
            return i10 == 0 ? gVar : gVar instanceof c ? ((c) gVar).a(i10) : new b(gVar, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @NotNull
    public static final <T> g<T> j(@NotNull g<? extends T> gVar, @NotNull Function1<? super T, Boolean> predicate) {
        s.i(gVar, "<this>");
        s.i(predicate, "predicate");
        return new e(gVar, true, predicate);
    }

    @NotNull
    public static final <T> g<T> k(@NotNull g<? extends T> gVar, @NotNull Function1<? super T, Boolean> predicate) {
        s.i(gVar, "<this>");
        s.i(predicate, "predicate");
        return new e(gVar, false, predicate);
    }

    @NotNull
    public static final <T> g<T> l(@NotNull g<? extends T> gVar) {
        s.i(gVar, "<this>");
        g<T> k10 = k(gVar, new Function1<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$filterNotNull$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@Nullable T t2) {
                return Boolean.valueOf(t2 == null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return invoke((SequencesKt___SequencesKt$filterNotNull$1<T>) obj);
            }
        });
        s.g(k10, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return k10;
    }

    @Nullable
    public static final <T> T m(@NotNull g<? extends T> gVar) {
        s.i(gVar, "<this>");
        Iterator<? extends T> it = gVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @NotNull
    public static final <T, A extends Appendable> A n(@NotNull g<? extends T> gVar, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i10, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        s.i(gVar, "<this>");
        s.i(buffer, "buffer");
        s.i(separator, "separator");
        s.i(prefix, "prefix");
        s.i(postfix, "postfix");
        s.i(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t2 : gVar) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            kotlin.text.i.a(buffer, t2, function1);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @NotNull
    public static final <T> String o(@NotNull g<? extends T> gVar, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i10, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        s.i(gVar, "<this>");
        s.i(separator, "separator");
        s.i(prefix, "prefix");
        s.i(postfix, "postfix");
        s.i(truncated, "truncated");
        String sb2 = ((StringBuilder) n(gVar, new StringBuilder(), separator, prefix, postfix, i10, truncated, function1)).toString();
        s.h(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static /* synthetic */ String p(g gVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            function1 = null;
        }
        return o(gVar, charSequence, charSequence5, charSequence6, i12, charSequence7, function1);
    }

    public static final <T> T q(@NotNull g<? extends T> gVar) {
        s.i(gVar, "<this>");
        Iterator<? extends T> it = gVar.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @NotNull
    public static final <T, R> g<R> r(@NotNull g<? extends T> gVar, @NotNull Function1<? super T, ? extends R> transform) {
        s.i(gVar, "<this>");
        s.i(transform, "transform");
        return new m(gVar, transform);
    }

    @NotNull
    public static final <T, R> g<R> s(@NotNull g<? extends T> gVar, @NotNull Function1<? super T, ? extends R> transform) {
        s.i(gVar, "<this>");
        s.i(transform, "transform");
        return l(new m(gVar, transform));
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C t(@NotNull g<? extends T> gVar, @NotNull C destination) {
        s.i(gVar, "<this>");
        s.i(destination, "destination");
        Iterator<? extends T> it = gVar.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    @NotNull
    public static final <T> List<T> u(@NotNull g<? extends T> gVar) {
        s.i(gVar, "<this>");
        return kotlin.collections.s.p(v(gVar));
    }

    @NotNull
    public static final <T> List<T> v(@NotNull g<? extends T> gVar) {
        s.i(gVar, "<this>");
        return (List) t(gVar, new ArrayList());
    }
}
