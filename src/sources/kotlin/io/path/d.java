package kotlin.io.path;

import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PathRecursiveFunctions.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f50985a;

    /* renamed from: b, reason: collision with root package name */
    public int f50986b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final List<Exception> f50987c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Path f50988d;

    public d(int i10) {
        this.f50985a = i10;
        this.f50987c = new ArrayList();
    }

    public final void a(@NotNull Exception exception) {
        s.i(exception, "exception");
        this.f50986b++;
        if (this.f50987c.size() < this.f50985a) {
            if (this.f50988d != null) {
                Throwable initCause = new FileSystemException(String.valueOf(this.f50988d)).initCause(exception);
                s.g(initCause, "null cannot be cast to non-null type java.nio.file.FileSystemException");
                exception = (FileSystemException) initCause;
            }
            this.f50987c.add(exception);
        }
    }

    public final void b(@NotNull Path name) {
        s.i(name, "name");
        Path path = this.f50988d;
        this.f50988d = path != null ? path.resolve(name) : null;
    }

    public final void c(@NotNull Path name) {
        s.i(name, "name");
        Path path = this.f50988d;
        if (s.d(name, path != null ? path.getFileName() : null)) {
            Path path2 = this.f50988d;
            this.f50988d = path2 != null ? path2.getParent() : null;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @NotNull
    public final List<Exception> d() {
        return this.f50987c;
    }

    public final int e() {
        return this.f50986b;
    }

    public final void f(@Nullable Path path) {
        this.f50988d = path;
    }

    public /* synthetic */ d(int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 64 : i10);
    }
}
