package androidx.window.embedding;

import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: EmbeddingCompat.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class EmptyEmbeddingComponent implements ActivityEmbeddingComponent {
    public void setEmbeddingRules(@NotNull Set<androidx.window.extensions.embedding.EmbeddingRule> splitRules) {
        s.i(splitRules, "splitRules");
    }

    public void setSplitInfoCallback(@NotNull Consumer<List<androidx.window.extensions.embedding.SplitInfo>> consumer) {
        s.i(consumer, "consumer");
    }
}
