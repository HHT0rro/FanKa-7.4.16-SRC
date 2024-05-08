package kotlin.io.path;

import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.jvm.internal.s;
import kotlin.text.p;
import kotlin.text.r;
import org.jetbrains.annotations.NotNull;

/* compiled from: PathUtils.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f50998a = new h();

    /* renamed from: b, reason: collision with root package name */
    public static final Path f50999b = Paths.get("", new String[0]);

    /* renamed from: c, reason: collision with root package name */
    public static final Path f51000c = Paths.get("..", new String[0]);

    @NotNull
    public final Path a(@NotNull Path path, @NotNull Path base) {
        s.i(path, "path");
        s.i(base, "base");
        Path normalize = base.normalize();
        Path r10 = path.normalize();
        Path relativize = normalize.relativize(r10);
        int min = Math.min(normalize.getNameCount(), r10.getNameCount());
        for (int i10 = 0; i10 < min; i10++) {
            Path name = normalize.getName(i10);
            Path path2 = f51000c;
            if (!s.d(name, path2)) {
                break;
            }
            if (!s.d(r10.getName(i10), path2)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (s.d(r10, normalize) || !s.d(normalize, f50999b)) {
            String obj = relativize.toString();
            String separator = relativize.getFileSystem().getSeparator();
            s.h(separator, "rn.fileSystem.separator");
            r10 = p.q(obj, separator, false, 2, null) ? relativize.getFileSystem().getPath(r.U0(obj, relativize.getFileSystem().getSeparator().length()), new String[0]) : relativize;
        }
        s.h(r10, "r");
        return r10;
    }
}
