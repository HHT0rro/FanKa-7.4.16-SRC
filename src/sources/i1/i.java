package i1;

import com.cupidapp.live.base.scrolltext.Direction;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Strategy.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f49689a = new i();

    /* compiled from: Strategy.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends h {
        @Override // i1.h
        @NotNull
        public Pair<List<Character>, Direction> e(char c4, char c10, int i10, @Nullable Iterable<Character> iterable) {
            return kotlin.f.a(r.e(Character.valueOf(c10)), Direction.SCROLL_DOWN);
        }
    }

    @NotNull
    public static final b a() {
        return new a();
    }

    @NotNull
    public static final b b() {
        return new d();
    }
}
