package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class w0 implements h1 {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f51559b;

    public w0(boolean z10) {
        this.f51559b = z10;
    }

    @Override // kotlinx.coroutines.h1
    @Nullable
    public y1 c() {
        return null;
    }

    @Override // kotlinx.coroutines.h1
    public boolean isActive() {
        return this.f51559b;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Empty{");
        sb2.append(isActive() ? "Active" : "New");
        sb2.append('}');
        return sb2.toString();
    }
}
