package kotlin.io.path;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PathRecursiveFunctions.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f50981a = new b();

    @Override // kotlin.io.path.a
    @NotNull
    public CopyActionResult a(@NotNull Path path, @NotNull Path target, boolean z10) {
        s.i(path, "<this>");
        s.i(target, "target");
        LinkOption[] a10 = f.f50989a.a(z10);
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(a10, a10.length);
        if (!Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length)) || !Files.isDirectory(target, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
            CopyOption[] copyOptionArr = (CopyOption[]) Arrays.copyOf(a10, a10.length);
            s.h(Files.copy(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), "copy(this, target, *options)");
        }
        return CopyActionResult.CONTINUE;
    }
}
