package i1;

import com.cupidapp.live.base.scrolltext.Direction;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

/* compiled from: CharOrderStrategy.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface b {
    @NotNull
    Pair<List<Character>, Direction> a(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i10, @NotNull List<? extends Collection<Character>> list);

    void b();

    @NotNull
    c c(@NotNull e eVar, int i10, @NotNull List<? extends List<Character>> list, int i11);

    void d(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull List<? extends Collection<Character>> list);
}
