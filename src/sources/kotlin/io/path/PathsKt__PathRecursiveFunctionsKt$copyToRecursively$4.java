package kotlin.io.path;

import java.nio.file.Path;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PathRecursiveFunctions.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$4 extends Lambda implements Function3<a, Path, Path, CopyActionResult> {
    public final /* synthetic */ boolean $followLinks;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathsKt__PathRecursiveFunctionsKt$copyToRecursively$4(boolean z10) {
        super(3);
        this.$followLinks = z10;
    }

    @Override // kotlin.jvm.functions.Function3
    @NotNull
    public final CopyActionResult invoke(@NotNull a aVar, @NotNull Path src, @NotNull Path dst) {
        s.i(aVar, "$this$null");
        s.i(src, "src");
        s.i(dst, "dst");
        return aVar.a(src, dst, this.$followLinks);
    }
}
