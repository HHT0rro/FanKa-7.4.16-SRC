package kotlin.io.path;

import java.nio.file.Path;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PathRecursiveFunctions.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$1 extends Lambda implements Function3 {
    public static final PathsKt__PathRecursiveFunctionsKt$copyToRecursively$1 INSTANCE = new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$1();

    public PathsKt__PathRecursiveFunctionsKt$copyToRecursively$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    @NotNull
    public final Void invoke(@NotNull Path path, @NotNull Path path2, @NotNull Exception exception) {
        s.i(path, "<anonymous parameter 0>");
        s.i(path2, "<anonymous parameter 1>");
        s.i(exception, "exception");
        throw exception;
    }
}
