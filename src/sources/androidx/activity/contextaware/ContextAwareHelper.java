package androidx.activity.contextaware;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContextAwareHelper.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ContextAwareHelper {

    @Nullable
    private volatile Context context;

    @NotNull
    private final Set<OnContextAvailableListener> listeners = new CopyOnWriteArraySet();

    public final void addOnContextAvailableListener(@NotNull OnContextAvailableListener listener) {
        s.i(listener, "listener");
        Context context = this.context;
        if (context != null) {
            listener.onContextAvailable(context);
        }
        this.listeners.add(listener);
    }

    public final void clearAvailableContext() {
        this.context = null;
    }

    public final void dispatchOnContextAvailable(@NotNull Context context) {
        s.i(context, "context");
        this.context = context;
        Iterator<OnContextAvailableListener> iterator2 = this.listeners.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onContextAvailable(context);
        }
    }

    @Nullable
    public final Context peekAvailableContext() {
        return this.context;
    }

    public final void removeOnContextAvailableListener(@NotNull OnContextAvailableListener listener) {
        s.i(listener, "listener");
        this.listeners.remove(listener);
    }
}
