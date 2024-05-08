package fe;

import kotlinx.coroutines.j0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Tasks.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class j extends g {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Runnable f49336d;

    public j(@NotNull Runnable runnable, long j10, @NotNull h hVar) {
        super(j10, hVar);
        this.f49336d = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f49336d.run();
        } finally {
            this.f49334c.a();
        }
    }

    @NotNull
    public String toString() {
        return "Task[" + j0.a(this.f49336d) + '@' + j0.b(this.f49336d) + ", " + this.f49333b + ", " + ((Object) this.f49334c) + ']';
    }
}
