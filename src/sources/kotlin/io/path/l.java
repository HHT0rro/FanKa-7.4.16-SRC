package kotlin.io.path;

import java.nio.file.Path;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PathUtils.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class l extends k {
    @NotNull
    public static final Path o(@NotNull Path path, @NotNull Path base) {
        s.i(path, "<this>");
        s.i(base, "base");
        try {
            return h.f50998a.a(path, base);
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException(e2.getMessage() + "\nthis path: " + ((Object) path) + "\nbase path: " + ((Object) base), e2);
        }
    }
}
