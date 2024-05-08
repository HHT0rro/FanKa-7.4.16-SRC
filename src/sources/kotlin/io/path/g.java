package kotlin.io.path;

import java.nio.file.Path;
import java.util.Iterator;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PathTreeWalk.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Path f50994a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final Object f50995b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final g f50996c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Iterator<g> f50997d;

    public g(@NotNull Path path, @Nullable Object obj, @Nullable g gVar) {
        s.i(path, "path");
        this.f50994a = path;
        this.f50995b = obj;
        this.f50996c = gVar;
    }

    @Nullable
    public final Iterator<g> a() {
        return this.f50997d;
    }

    @Nullable
    public final Object b() {
        return this.f50995b;
    }

    @Nullable
    public final g c() {
        return this.f50996c;
    }

    @NotNull
    public final Path d() {
        return this.f50994a;
    }

    public final void e(@Nullable Iterator<g> it) {
        this.f50997d = it;
    }
}
