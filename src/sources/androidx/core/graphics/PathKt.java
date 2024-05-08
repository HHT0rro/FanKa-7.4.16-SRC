package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.RequiresApi;
import java.util.Collection;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Path.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class PathKt {
    @RequiresApi(19)
    @NotNull
    public static final Path and(@NotNull Path path, @NotNull Path p10) {
        s.i(path, "<this>");
        s.i(p10, "p");
        Path path2 = new Path();
        path2.op(path, p10, Path.Op.INTERSECT);
        return path2;
    }

    @RequiresApi(26)
    @NotNull
    public static final Iterable<PathSegment> flatten(@NotNull Path path, float f10) {
        s.i(path, "<this>");
        Collection<PathSegment> flatten = PathUtils.flatten(path, f10);
        s.h(flatten, "flatten(this, error)");
        return flatten;
    }

    public static /* synthetic */ Iterable flatten$default(Path path, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.5f;
        }
        return flatten(path, f10);
    }

    @RequiresApi(19)
    @NotNull
    public static final Path minus(@NotNull Path path, @NotNull Path p10) {
        s.i(path, "<this>");
        s.i(p10, "p");
        Path path2 = new Path(path);
        path2.op(p10, Path.Op.DIFFERENCE);
        return path2;
    }

    @RequiresApi(19)
    @NotNull
    public static final Path or(@NotNull Path path, @NotNull Path p10) {
        s.i(path, "<this>");
        s.i(p10, "p");
        Path path2 = new Path(path);
        path2.op(p10, Path.Op.UNION);
        return path2;
    }

    @RequiresApi(19)
    @NotNull
    public static final Path plus(@NotNull Path path, @NotNull Path p10) {
        s.i(path, "<this>");
        s.i(p10, "p");
        Path path2 = new Path(path);
        path2.op(p10, Path.Op.UNION);
        return path2;
    }

    @RequiresApi(19)
    @NotNull
    public static final Path xor(@NotNull Path path, @NotNull Path p10) {
        s.i(path, "<this>");
        s.i(p10, "p");
        Path path2 = new Path(path);
        path2.op(p10, Path.Op.XOR);
        return path2;
    }
}
