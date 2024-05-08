package androidx.lifecycle;

import kotlin.jvm.internal.s;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ViewModel.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ViewModelKt {

    @NotNull
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    @NotNull
    public static final h0 getViewModelScope(@NotNull ViewModel viewModel) {
        s.i(viewModel, "<this>");
        h0 h0Var = (h0) viewModel.getTag(JOB_KEY);
        if (h0Var != null) {
            return h0Var;
        }
        Object tagIfAbsent = viewModel.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(h2.b(null, 1, null).plus(r0.c().x())));
        s.h(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (h0) tagIfAbsent;
    }
}
