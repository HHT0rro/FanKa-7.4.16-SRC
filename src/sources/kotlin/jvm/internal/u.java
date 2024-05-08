package kotlin.jvm.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PackageReference.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class u implements l {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Class<?> f51033b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f51034c;

    public u(@NotNull Class<?> jClass, @NotNull String moduleName) {
        s.i(jClass, "jClass");
        s.i(moduleName, "moduleName");
        this.f51033b = jClass;
        this.f51034c = moduleName;
    }

    @Override // kotlin.jvm.internal.l
    @NotNull
    public Class<?> a() {
        return this.f51033b;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof u) && s.d(a(), ((u) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    @NotNull
    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
