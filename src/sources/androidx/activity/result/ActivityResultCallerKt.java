package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: ActivityResultCaller.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ActivityResultCallerKt {
    @NotNull
    public static final <I, O> ActivityResultLauncher<p> registerForActivityResult(@NotNull ActivityResultCaller activityResultCaller, @NotNull ActivityResultContract<I, O> contract, I i10, @NotNull ActivityResultRegistry registry, @NotNull final Function1<? super O, p> callback) {
        s.i(activityResultCaller, "<this>");
        s.i(contract, "contract");
        s.i(registry, "registry");
        s.i(callback, "callback");
        ActivityResultLauncher<I> registerForActivityResult = activityResultCaller.registerForActivityResult(contract, registry, new ActivityResultCallback() { // from class: androidx.activity.result.b
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ActivityResultCallerKt.registerForActivityResult$lambda$0(Function1.this, obj);
            }
        });
        s.h(registerForActivityResult, "registerForActivityResul…egistry) { callback(it) }");
        return new ActivityResultCallerLauncher(registerForActivityResult, contract, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerForActivityResult$lambda$0(Function1 callback, Object obj) {
        s.i(callback, "$callback");
        callback.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerForActivityResult$lambda$1(Function1 callback, Object obj) {
        s.i(callback, "$callback");
        callback.invoke(obj);
    }

    @NotNull
    public static final <I, O> ActivityResultLauncher<p> registerForActivityResult(@NotNull ActivityResultCaller activityResultCaller, @NotNull ActivityResultContract<I, O> contract, I i10, @NotNull final Function1<? super O, p> callback) {
        s.i(activityResultCaller, "<this>");
        s.i(contract, "contract");
        s.i(callback, "callback");
        ActivityResultLauncher<I> registerForActivityResult = activityResultCaller.registerForActivityResult(contract, new ActivityResultCallback() { // from class: androidx.activity.result.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ActivityResultCallerKt.registerForActivityResult$lambda$1(Function1.this, obj);
            }
        });
        s.h(registerForActivityResult, "registerForActivityResul…ontract) { callback(it) }");
        return new ActivityResultCallerLauncher(registerForActivityResult, contract, i10);
    }
}
