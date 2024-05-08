package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SavedStateRegistry.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SavedStateRegistry {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private boolean attached;

    @NotNull
    private final SafeIterableMap<String, SavedStateProvider> components = new SafeIterableMap<>();
    private boolean isAllowingSavingState = true;
    private boolean isRestored;

    @Nullable
    private Recreator.SavedStateProvider recreatorProvider;

    @Nullable
    private Bundle restoredState;

    /* compiled from: SavedStateRegistry.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface AutoRecreated {
        void onRecreated(@NotNull SavedStateRegistryOwner savedStateRegistryOwner);
    }

    /* compiled from: SavedStateRegistry.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SavedStateRegistry.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface SavedStateProvider {
        @NotNull
        Bundle saveState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performAttach$lambda$4(SavedStateRegistry this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        s.i(this$0, "this$0");
        s.i(lifecycleOwner, "<anonymous parameter 0>");
        s.i(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            this$0.isAllowingSavingState = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            this$0.isAllowingSavingState = false;
        }
    }

    @MainThread
    @Nullable
    public final Bundle consumeRestoredStateForKey(@NotNull String key) {
        s.i(key, "key");
        if (this.isRestored) {
            Bundle bundle = this.restoredState;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
            Bundle bundle3 = this.restoredState;
            if (bundle3 != null) {
                bundle3.remove(key);
            }
            Bundle bundle4 = this.restoredState;
            boolean z10 = false;
            if (bundle4 != null && !bundle4.isEmpty()) {
                z10 = true;
            }
            if (!z10) {
                this.restoredState = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    @Nullable
    public final SavedStateProvider getSavedStateProvider(@NotNull String key) {
        s.i(key, "key");
        Iterator<Map.Entry<String, SavedStateProvider>> iterator2 = this.components.iterator2();
        while (iterator2.hasNext()) {
            Map.Entry<String, SavedStateProvider> components = iterator2.next();
            s.h(components, "components");
            String key2 = components.getKey();
            SavedStateProvider value = components.getValue();
            if (s.d(key2, key)) {
                return value;
            }
        }
        return null;
    }

    public final boolean isAllowingSavingState$savedstate_release() {
        return this.isAllowingSavingState;
    }

    @MainThread
    public final boolean isRestored() {
        return this.isRestored;
    }

    @MainThread
    public final void performAttach$savedstate_release(@NotNull Lifecycle lifecycle) {
        s.i(lifecycle, "lifecycle");
        if (!this.attached) {
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.savedstate.a
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    SavedStateRegistry.performAttach$lambda$4(SavedStateRegistry.this, lifecycleOwner, event);
                }
            });
            this.attached = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    }

    @MainThread
    public final void performRestore$savedstate_release(@Nullable Bundle bundle) {
        if (this.attached) {
            if (!this.isRestored) {
                this.restoredState = bundle != null ? bundle.getBundle(SAVED_COMPONENTS_KEY) : null;
                this.isRestored = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
    }

    @MainThread
    public final void performSave(@NotNull Bundle outBundle) {
        s.i(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.restoredState;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        SafeIterableMap<String, SavedStateProvider>.IteratorWithAdditions iteratorWithAdditions = this.components.iteratorWithAdditions();
        s.h(iteratorWithAdditions, "this.components.iteratorWithAdditions()");
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry next = iteratorWithAdditions.next();
            bundle.putBundle((String) next.getKey(), ((SavedStateProvider) next.getValue()).saveState());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle(SAVED_COMPONENTS_KEY, bundle);
    }

    @MainThread
    public final void registerSavedStateProvider(@NotNull String key, @NotNull SavedStateProvider provider) {
        s.i(key, "key");
        s.i(provider, "provider");
        if (!(this.components.putIfAbsent(key, provider) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    @MainThread
    public final void runOnNextRecreation(@NotNull Class<? extends AutoRecreated> clazz) {
        s.i(clazz, "clazz");
        if (this.isAllowingSavingState) {
            Recreator.SavedStateProvider savedStateProvider = this.recreatorProvider;
            if (savedStateProvider == null) {
                savedStateProvider = new Recreator.SavedStateProvider(this);
            }
            this.recreatorProvider = savedStateProvider;
            try {
                clazz.getDeclaredConstructor(new Class[0]);
                Recreator.SavedStateProvider savedStateProvider2 = this.recreatorProvider;
                if (savedStateProvider2 != null) {
                    String name = clazz.getName();
                    s.h(name, "clazz.name");
                    savedStateProvider2.add(name);
                    return;
                }
                return;
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
    }

    public final void setAllowingSavingState$savedstate_release(boolean z10) {
        this.isAllowingSavingState = z10;
    }

    @MainThread
    public final void unregisterSavedStateProvider(@NotNull String key) {
        s.i(key, "key");
        this.components.remove(key);
    }
}
