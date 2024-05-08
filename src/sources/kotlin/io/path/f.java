package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import kotlin.collections.l0;
import kotlin.collections.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: PathTreeWalk.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f50989a = new f();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final LinkOption[] f50990b = {LinkOption.NOFOLLOW_LINKS};

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final LinkOption[] f50991c = new LinkOption[0];

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Set<FileVisitOption> f50992d = m0.d();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final Set<FileVisitOption> f50993e = l0.c(FileVisitOption.FOLLOW_LINKS);

    @NotNull
    public final LinkOption[] a(boolean z10) {
        return z10 ? f50991c : f50990b;
    }

    @NotNull
    public final Set<FileVisitOption> b(boolean z10) {
        return z10 ? f50993e : f50992d;
    }
}
