package i1;

import com.cupidapp.live.base.scrolltext.Direction;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.collections.s;
import kotlin.collections.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NormalAnimationStrategy.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class d extends h {
    @Override // i1.h
    @NotNull
    public Pair<List<Character>, Direction> e(char c4, char c10, int i10, @Nullable Iterable<Character> iterable) {
        if (c4 == c10) {
            return kotlin.f.a(r.e(Character.valueOf(c10)), Direction.SCROLL_UP);
        }
        if (iterable == null) {
            return kotlin.f.a(s.m(Character.valueOf(c4), Character.valueOf(c10)), Direction.SCROLL_UP);
        }
        int X = CollectionsKt___CollectionsKt.X(iterable, Character.valueOf(c4));
        int X2 = CollectionsKt___CollectionsKt.X(iterable, Character.valueOf(c10));
        if (X < X2) {
            return kotlin.f.a(h(iterable, X, X2), Direction.SCROLL_UP);
        }
        return kotlin.f.a(y.F(h(iterable, X2, X)), Direction.SCROLL_DOWN);
    }

    public final <T> List<T> h(Iterable<? extends T> iterable, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        for (T t2 : iterable) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                s.s();
            }
            if (i10 <= i12 && i12 <= i11) {
                arrayList.add(t2);
            }
            i12 = i13;
        }
        return arrayList;
    }
}
