package p7;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n<TResult> implements q<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f52922a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f52923b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public d<? super TResult> f52924c;

    public n(@NonNull Executor executor, @NonNull d<? super TResult> dVar) {
        this.f52922a = executor;
        this.f52924c = dVar;
    }

    @Override // p7.q
    public final void a(@NonNull f<TResult> fVar) {
        if (fVar.i()) {
            synchronized (this.f52923b) {
                if (this.f52924c == null) {
                    return;
                }
                this.f52922a.execute(new o(this, fVar));
            }
        }
    }
}
