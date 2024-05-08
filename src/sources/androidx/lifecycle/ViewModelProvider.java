package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ViewModelProvider.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ViewModelProvider {

    @NotNull
    private final CreationExtras defaultCreationExtras;

    @NotNull
    private final Factory factory;

    @NotNull
    private final ViewModelStore store;

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Factory {

        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;

        /* compiled from: ViewModelProvider.kt */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public static final class Companion {
            public static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            @NotNull
            public final Factory from(@NotNull ViewModelInitializer<?>... initializers) {
                s.i(initializers, "initializers");
                return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(initializers, initializers.length));
            }
        }

        @NotNull
        <T extends ViewModel> T create(@NotNull Class<T> cls);

        @NotNull
        <T extends ViewModel> T create(@NotNull Class<T> cls, @NotNull CreationExtras creationExtras);
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class NewInstanceFactory implements Factory {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        public static final CreationExtras.Key<String> VIEW_MODEL_KEY = Companion.ViewModelKeyImpl.INSTANCE;

        @Nullable
        private static NewInstanceFactory sInstance;

        /* compiled from: ViewModelProvider.kt */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public static final class Companion {

            /* compiled from: ViewModelProvider.kt */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
            public static final class ViewModelKeyImpl implements CreationExtras.Key<String> {

                @NotNull
                public static final ViewModelKeyImpl INSTANCE = new ViewModelKeyImpl();

                private ViewModelKeyImpl() {
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ void getInstance$annotations() {
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            @NotNull
            public final NewInstanceFactory getInstance() {
                if (NewInstanceFactory.sInstance == null) {
                    NewInstanceFactory.sInstance = new NewInstanceFactory();
                }
                NewInstanceFactory newInstanceFactory = NewInstanceFactory.sInstance;
                s.f(newInstanceFactory);
                return newInstanceFactory;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public static final NewInstanceFactory getInstance() {
            return Companion.getInstance();
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            s.i(modelClass, "modelClass");
            try {
                T newInstance = modelClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                s.h(newInstance, "{\n                modelC…wInstance()\n            }");
                return newInstance;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + ((Object) modelClass), e2);
            } catch (InstantiationException e10) {
                throw new RuntimeException("Cannot create an instance of " + ((Object) modelClass), e10);
            } catch (NoSuchMethodException e11) {
                throw new RuntimeException("Cannot create an instance of " + ((Object) modelClass), e11);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return k.b(this, cls, creationExtras);
        }
    }

    /* compiled from: ViewModelProvider.kt */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class OnRequeryFactory {
        public void onRequery(@NotNull ViewModel viewModel) {
            s.i(viewModel, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(@NotNull ViewModelStore store, @NotNull Factory factory) {
        this(store, factory, null, 4, null);
        s.i(store, "store");
        s.i(factory, "factory");
    }

    public ViewModelProvider(@NotNull ViewModelStore store, @NotNull Factory factory, @NotNull CreationExtras defaultCreationExtras) {
        s.i(store, "store");
        s.i(factory, "factory");
        s.i(defaultCreationExtras, "defaultCreationExtras");
        this.store = store;
        this.factory = factory;
        this.defaultCreationExtras = defaultCreationExtras;
    }

    @MainThread
    @NotNull
    public <T extends ViewModel> T get(@NotNull Class<T> modelClass) {
        s.i(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class AndroidViewModelFactory extends NewInstanceFactory {

        @NotNull
        public static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";

        @Nullable
        private static AndroidViewModelFactory sInstance;

        @Nullable
        private final Application application;

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        public static final CreationExtras.Key<Application> APPLICATION_KEY = Companion.ApplicationKeyImpl.INSTANCE;

        /* compiled from: ViewModelProvider.kt */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public static final class Companion {

            /* compiled from: ViewModelProvider.kt */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
            public static final class ApplicationKeyImpl implements CreationExtras.Key<Application> {

                @NotNull
                public static final ApplicationKeyImpl INSTANCE = new ApplicationKeyImpl();

                private ApplicationKeyImpl() {
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Factory defaultFactory$lifecycle_viewmodel_release(@NotNull ViewModelStoreOwner owner) {
                s.i(owner, "owner");
                return owner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) owner).getDefaultViewModelProviderFactory() : NewInstanceFactory.Companion.getInstance();
            }

            @NotNull
            public final AndroidViewModelFactory getInstance(@NotNull Application application) {
                s.i(application, "application");
                if (AndroidViewModelFactory.sInstance == null) {
                    AndroidViewModelFactory.sInstance = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory androidViewModelFactory = AndroidViewModelFactory.sInstance;
                s.f(androidViewModelFactory);
                return androidViewModelFactory;
            }
        }

        private AndroidViewModelFactory(Application application, int i10) {
            this.application = application;
        }

        @NotNull
        public static final AndroidViewModelFactory getInstance(@NotNull Application application) {
            return Companion.getInstance(application);
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass, @NotNull CreationExtras extras) {
            s.i(modelClass, "modelClass");
            s.i(extras, "extras");
            if (this.application != null) {
                return (T) create(modelClass);
            }
            Application application = (Application) extras.get(APPLICATION_KEY);
            if (application != null) {
                return (T) create(modelClass, application);
            }
            if (!AndroidViewModel.class.isAssignableFrom(modelClass)) {
                return (T) super.create(modelClass);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        public AndroidViewModelFactory() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AndroidViewModelFactory(@NotNull Application application) {
            this(application, 0);
            s.i(application, "application");
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            s.i(modelClass, "modelClass");
            Application application = this.application;
            if (application != null) {
                return (T) create(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        private final <T extends ViewModel> T create(Class<T> cls, Application application) {
            if (AndroidViewModel.class.isAssignableFrom(cls)) {
                try {
                    T newInstance = cls.getConstructor(Application.class).newInstance(application);
                    s.h(newInstance, "{\n                try {\n…          }\n            }");
                    return newInstance;
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException("Cannot create an instance of " + ((Object) cls), e2);
                } catch (InstantiationException e10) {
                    throw new RuntimeException("Cannot create an instance of " + ((Object) cls), e10);
                } catch (NoSuchMethodException e11) {
                    throw new RuntimeException("Cannot create an instance of " + ((Object) cls), e11);
                } catch (InvocationTargetException e12) {
                    throw new RuntimeException("Cannot create an instance of " + ((Object) cls), e12);
                }
            }
            return (T) super.create(cls);
        }
    }

    @MainThread
    @NotNull
    public <T extends ViewModel> T get(@NotNull String key, @NotNull Class<T> modelClass) {
        T t2;
        s.i(key, "key");
        s.i(modelClass, "modelClass");
        T t10 = (T) this.store.get(key);
        if (modelClass.isInstance(t10)) {
            Object obj = this.factory;
            OnRequeryFactory onRequeryFactory = obj instanceof OnRequeryFactory ? (OnRequeryFactory) obj : null;
            if (onRequeryFactory != null) {
                s.f(t10);
                onRequeryFactory.onRequery(t10);
            }
            s.g(t10, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return t10;
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.defaultCreationExtras);
        mutableCreationExtras.set(NewInstanceFactory.VIEW_MODEL_KEY, key);
        try {
            t2 = (T) this.factory.create(modelClass, mutableCreationExtras);
        } catch (AbstractMethodError unused) {
            t2 = (T) this.factory.create(modelClass);
        }
        this.store.put(key, t2);
        return t2;
    }

    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewModelStore, factory, (i10 & 4) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(@NotNull ViewModelStoreOwner owner) {
        this(owner.getViewModelStore(), AndroidViewModelFactory.Companion.defaultFactory$lifecycle_viewmodel_release(owner), ViewModelProviderGetKt.defaultCreationExtras(owner));
        s.i(owner, "owner");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(@NotNull ViewModelStoreOwner owner, @NotNull Factory factory) {
        this(owner.getViewModelStore(), factory, ViewModelProviderGetKt.defaultCreationExtras(owner));
        s.i(owner, "owner");
        s.i(factory, "factory");
    }
}
