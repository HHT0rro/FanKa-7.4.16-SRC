package i1;

import com.cupidapp.live.base.scrolltext.Direction;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CharOrderStrategy.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class h implements b {
    @Override // i1.b
    @NotNull
    public Pair<List<Character>, Direction> a(@NotNull CharSequence sourceText, @NotNull CharSequence targetText, int i10, @NotNull List<? extends Collection<Character>> charPool) {
        s.i(sourceText, "sourceText");
        s.i(targetText, "targetText");
        s.i(charPool, "charPool");
        int max = Math.max(sourceText.length(), targetText.length());
        int length = max - sourceText.length();
        int length2 = max - targetText.length();
        return f(i10 >= length ? sourceText.charAt(i10 - length) : (char) 0, i10 >= length2 ? targetText.charAt(i10 - length2) : (char) 0, i10, charPool);
    }

    @Override // i1.b
    public void b() {
    }

    @Override // i1.b
    @NotNull
    public c c(@NotNull e previousProgress, int i10, @NotNull List<? extends List<Character>> columns, int i11) {
        s.i(previousProgress, "previousProgress");
        s.i(columns, "columns");
        double g3 = g(previousProgress, i10, columns.size(), columns.get(i10));
        double size = (r13.size() - 1) * previousProgress.a();
        int i12 = (int) size;
        double d10 = 1.0d / g3;
        double d11 = 1.0d - g3;
        double d12 = size - i12;
        return new c(i12, d12 >= d11 ? (d12 * d10) - (d11 * d10) : ShadowDrawableWrapper.COS_45, previousProgress.a());
    }

    @Override // i1.b
    public void d(@NotNull CharSequence sourceText, @NotNull CharSequence targetText, @NotNull List<? extends Collection<Character>> charPool) {
        s.i(sourceText, "sourceText");
        s.i(targetText, "targetText");
        s.i(charPool, "charPool");
    }

    @NotNull
    public abstract Pair<List<Character>, Direction> e(char c4, char c10, int i10, @Nullable Iterable<Character> iterable);

    @NotNull
    public Pair<List<Character>, Direction> f(char c4, char c10, int i10, @NotNull List<? extends Collection<Character>> charPool) {
        Collection<Character> collection;
        s.i(charPool, "charPool");
        Iterator<? extends Collection<Character>> iterator2 = charPool.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                collection = null;
                break;
            }
            collection = iterator2.next();
            Collection<Character> collection2 = collection;
            if (collection2.contains(Character.valueOf(c4)) && collection2.contains(Character.valueOf(c10))) {
                break;
            }
        }
        return e(c4, c10, i10, collection);
    }

    public double g(@NotNull e previousProgress, int i10, int i11, @NotNull List<Character> charList) {
        s.i(previousProgress, "previousProgress");
        s.i(charList, "charList");
        return 1.0d;
    }
}
