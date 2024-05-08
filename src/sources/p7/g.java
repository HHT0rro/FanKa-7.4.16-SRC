package p7;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class g<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final t<TResult> f52911a = new t<>();

    public g() {
    }

    @NonNull
    public f<TResult> a() {
        return this.f52911a;
    }

    public void b(@NonNull Exception exc) {
        this.f52911a.j(exc);
    }

    public void c(@Nullable TResult tresult) {
        this.f52911a.k(tresult);
    }

    public boolean d(@NonNull Exception exc) {
        return this.f52911a.n(exc);
    }

    public boolean e(@Nullable TResult tresult) {
        return this.f52911a.o(tresult);
    }

    public g(@NonNull a aVar) {
        aVar.b(new r(this));
    }
}
