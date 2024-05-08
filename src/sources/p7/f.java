package p7;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class f<TResult> {
    @NonNull
    public abstract f<TResult> a(@NonNull Executor executor, @NonNull c cVar);

    @NonNull
    public abstract f<TResult> b(@NonNull c cVar);

    @NonNull
    public abstract f<TResult> c(@NonNull Executor executor, @NonNull d<? super TResult> dVar);

    @NonNull
    public abstract f<TResult> d(@NonNull d<? super TResult> dVar);

    @Nullable
    public abstract Exception e();

    public abstract TResult f();

    public abstract boolean g();

    public abstract boolean h();

    public abstract boolean i();
}
