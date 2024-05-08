package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FileTreeWalk.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class i extends h {
    @NotNull
    public static final f d(@NotNull File file, @NotNull FileWalkDirection direction) {
        s.i(file, "<this>");
        s.i(direction, "direction");
        return new f(file, direction);
    }

    @NotNull
    public static final f e(@NotNull File file) {
        s.i(file, "<this>");
        return d(file, FileWalkDirection.BOTTOM_UP);
    }

    @NotNull
    public static final f f(@NotNull File file) {
        s.i(file, "<this>");
        return d(file, FileWalkDirection.TOP_DOWN);
    }
}
