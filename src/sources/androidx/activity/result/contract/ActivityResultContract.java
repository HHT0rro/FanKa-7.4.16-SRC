package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActivityResultContract.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class ActivityResultContract<I, O> {

    /* compiled from: ActivityResultContract.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class SynchronousResult<T> {
        private final T value;

        public SynchronousResult(T t2) {
            this.value = t2;
        }

        public final T getValue() {
            return this.value;
        }
    }

    @NotNull
    public abstract Intent createIntent(@NotNull Context context, I i10);

    @Nullable
    public SynchronousResult<O> getSynchronousResult(@NotNull Context context, I i10) {
        s.i(context, "context");
        return null;
    }

    public abstract O parseResult(int i10, @Nullable Intent intent);
}
