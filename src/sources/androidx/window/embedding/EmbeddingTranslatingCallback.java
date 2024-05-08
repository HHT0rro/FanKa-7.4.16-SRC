package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import java.util.List;
import java.util.function.Consumer;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: EmbeddingTranslatingCallback.kt */
@ExperimentalWindowApi
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class EmbeddingTranslatingCallback implements Consumer<List<? extends androidx.window.extensions.embedding.SplitInfo>> {

    @NotNull
    private final EmbeddingAdapter adapter;

    @NotNull
    private final EmbeddingInterfaceCompat.EmbeddingCallbackInterface callback;

    public EmbeddingTranslatingCallback(@NotNull EmbeddingInterfaceCompat.EmbeddingCallbackInterface callback, @NotNull EmbeddingAdapter adapter) {
        s.i(callback, "callback");
        s.i(adapter, "adapter");
        this.callback = callback;
        this.adapter = adapter;
    }

    @Override // java.util.function.Consumer
    public void accept(@NotNull List<? extends androidx.window.extensions.embedding.SplitInfo> splitInfoList) {
        s.i(splitInfoList, "splitInfoList");
        this.callback.onSplitInfoChanged(this.adapter.translate(splitInfoList));
    }
}
