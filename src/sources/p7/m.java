package p7;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m<TResult> implements q<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f52919a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f52920b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public c f52921c;

    public m(@NonNull Executor executor, @NonNull c cVar) {
        this.f52919a = executor;
        this.f52921c = cVar;
    }

    @Override // p7.q
    public final void a(@NonNull f<TResult> fVar) {
        if (fVar.i() || fVar.g()) {
            return;
        }
        synchronized (this.f52920b) {
            if (this.f52921c == null) {
                return;
            }
            this.f52919a.execute(new l(this, fVar));
        }
    }
}
