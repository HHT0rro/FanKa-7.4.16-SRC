package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* compiled from: EmbeddingInterfaceCompat.kt */
@ExperimentalWindowApi
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface EmbeddingInterfaceCompat {

    /* compiled from: EmbeddingInterfaceCompat.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface EmbeddingCallbackInterface {
        void onSplitInfoChanged(@NotNull List<SplitInfo> list);
    }

    void setEmbeddingCallback(@NotNull EmbeddingCallbackInterface embeddingCallbackInterface);

    void setSplitRules(@NotNull Set<? extends EmbeddingRule> set);
}
