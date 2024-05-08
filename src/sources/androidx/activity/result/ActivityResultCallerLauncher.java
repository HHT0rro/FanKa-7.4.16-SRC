package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultCallerLauncher$resultContract$2;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Lazy;
import kotlin.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActivityResultCaller.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<p> {

    @NotNull
    private final ActivityResultContract<I, O> callerContract;
    private final I callerInput;

    @NotNull
    private final ActivityResultLauncher<I> launcher;

    @NotNull
    private final Lazy resultContract$delegate;

    public ActivityResultCallerLauncher(@NotNull ActivityResultLauncher<I> launcher, @NotNull ActivityResultContract<I, O> callerContract, I i10) {
        s.i(launcher, "launcher");
        s.i(callerContract, "callerContract");
        this.launcher = launcher;
        this.callerContract = callerContract;
        this.callerInput = i10;
        this.resultContract$delegate = c.b(new Function0<ActivityResultCallerLauncher$resultContract$2.AnonymousClass1>(this) { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2
            public final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnonymousClass1 invoke() {
                final ActivityResultCallerLauncher<I, O> activityResultCallerLauncher = this.this$0;
                return new ActivityResultContract<p, O>() { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2.1
                    @Override // androidx.activity.result.contract.ActivityResultContract
                    public O parseResult(int i11, @Nullable Intent intent) {
                        return (O) activityResultCallerLauncher.getCallerContract().parseResult(i11, intent);
                    }

                    @Override // androidx.activity.result.contract.ActivityResultContract
                    @NotNull
                    public Intent createIntent(@NotNull Context context, @NotNull p input) {
                        s.i(context, "context");
                        s.i(input, "input");
                        return activityResultCallerLauncher.getCallerContract().createIntent(context, activityResultCallerLauncher.getCallerInput());
                    }
                };
            }
        });
    }

    @NotNull
    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    public final I getCallerInput() {
        return this.callerInput;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    @NotNull
    public ActivityResultContract<p, ?> getContract() {
        return getResultContract();
    }

    @NotNull
    public final ActivityResultLauncher<I> getLauncher() {
        return this.launcher;
    }

    @NotNull
    public final ActivityResultContract<p, O> getResultContract() {
        return (ActivityResultContract) this.resultContract$delegate.getValue();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(@NotNull p input, @Nullable ActivityOptionsCompat activityOptionsCompat) {
        s.i(input, "input");
        this.launcher.launch(this.callerInput, activityOptionsCompat);
    }
}
