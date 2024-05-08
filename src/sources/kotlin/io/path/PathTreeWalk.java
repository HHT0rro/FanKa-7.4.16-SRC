package kotlin.io.path;

import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Iterator;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;

/* compiled from: PathTreeWalk.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class PathTreeWalk implements kotlin.sequences.g<Path> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Path f50979a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final PathWalkOption[] f50980b;

    public final Iterator<Path> f() {
        return kotlin.sequences.j.a(new PathTreeWalk$bfsIterator$1(this, null));
    }

    public final Iterator<Path> g() {
        return kotlin.sequences.j.a(new PathTreeWalk$dfsIterator$1(this, null));
    }

    public final boolean h() {
        return m.t(this.f50980b, PathWalkOption.FOLLOW_LINKS);
    }

    public final boolean i() {
        return m.t(this.f50980b, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    @Override // kotlin.sequences.g
    @NotNull
    public Iterator<Path> iterator() {
        return k() ? f() : g();
    }

    public final LinkOption[] j() {
        return f.f50989a.a(h());
    }

    public final boolean k() {
        return m.t(this.f50980b, PathWalkOption.BREADTH_FIRST);
    }
}
