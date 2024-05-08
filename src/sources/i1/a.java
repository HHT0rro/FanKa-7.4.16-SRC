package i1;

import com.cupidapp.live.base.scrolltext.Direction;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.x;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: CharOrderManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public b f49677a = i.b();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<LinkedHashSet<Character>> f49678b = new ArrayList();

    public final void a(@NotNull Iterable<Character> orderList) {
        s.i(orderList, "orderList");
        List o10 = kotlin.collections.s.o((char) 0);
        x.x(o10, orderList);
        this.f49678b.add(new LinkedHashSet<>(o10));
    }

    public final void b() {
        this.f49677a.b();
    }

    public final void c(@NotNull CharSequence sourceText, @NotNull CharSequence targetText) {
        s.i(sourceText, "sourceText");
        s.i(targetText, "targetText");
        this.f49677a.d(sourceText, targetText, this.f49678b);
    }

    @NotNull
    public final Pair<List<Character>, Direction> d(@NotNull CharSequence sourceText, @NotNull CharSequence targetText, int i10) {
        s.i(sourceText, "sourceText");
        s.i(targetText, "targetText");
        return this.f49677a.a(sourceText, targetText, i10, this.f49678b);
    }

    @NotNull
    public final b e() {
        return this.f49677a;
    }

    @NotNull
    public final c f(@NotNull e previousProgress, int i10, @NotNull List<? extends List<Character>> columns, int i11) {
        s.i(previousProgress, "previousProgress");
        s.i(columns, "columns");
        return this.f49677a.c(previousProgress, i10, columns, i11);
    }

    public final void g(@NotNull Iterable<Character> orderList) {
        s.i(orderList, "orderList");
        this.f49678b.clear();
        List o10 = kotlin.collections.s.o((char) 0);
        x.x(o10, orderList);
        this.f49678b.add(new LinkedHashSet<>(o10));
    }

    public final void h(@NotNull b bVar) {
        s.i(bVar, "<set-?>");
        this.f49677a = bVar;
    }
}
