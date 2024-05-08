package androidx.lifecycle.viewmodel;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CreationExtras.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class CreationExtras {

    @NotNull
    private final Map<Key<?>, Object> map = new LinkedHashMap();

    /* compiled from: CreationExtras.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Empty extends CreationExtras {

        @NotNull
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @Override // androidx.lifecycle.viewmodel.CreationExtras
        @Nullable
        public <T> T get(@NotNull Key<T> key) {
            s.i(key, "key");
            return null;
        }
    }

    /* compiled from: CreationExtras.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Key<T> {
    }

    @Nullable
    public abstract <T> T get(@NotNull Key<T> key);

    @NotNull
    public final Map<Key<?>, Object> getMap$lifecycle_viewmodel_release() {
        return this.map;
    }
}
