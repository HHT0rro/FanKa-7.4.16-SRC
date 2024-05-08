package kotlin.io;

import java.io.File;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilePathComponents.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final File f50952a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<File> f50953b;

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull File root, @NotNull List<? extends File> segments) {
        s.i(root, "root");
        s.i(segments, "segments");
        this.f50952a = root;
        this.f50953b = segments;
    }

    @NotNull
    public final File a() {
        return this.f50952a;
    }

    @NotNull
    public final List<File> b() {
        return this.f50953b;
    }

    public final int c() {
        return this.f50953b.size();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return s.d(this.f50952a, eVar.f50952a) && s.d(this.f50953b, eVar.f50953b);
    }

    public int hashCode() {
        return (this.f50952a.hashCode() * 31) + this.f50953b.hashCode();
    }

    @NotNull
    public String toString() {
        return "FilePathComponents(root=" + ((Object) this.f50952a) + ", segments=" + ((Object) this.f50953b) + ')';
    }
}
