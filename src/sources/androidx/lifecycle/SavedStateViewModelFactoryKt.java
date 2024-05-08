package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.m;
import kotlin.collections.r;
import kotlin.collections.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SavedStateViewModelFactory.kt */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SavedStateViewModelFactoryKt {

    @NotNull
    private static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE = s.m(Application.class, SavedStateHandle.class);

    @NotNull
    private static final List<Class<?>> VIEWMODEL_SIGNATURE = r.e(SavedStateHandle.class);

    @Nullable
    public static final <T> Constructor<T> findMatchingConstructor(@NotNull Class<T> modelClass, @NotNull List<? extends Class<?>> signature) {
        kotlin.jvm.internal.s.i(modelClass, "modelClass");
        kotlin.jvm.internal.s.i(signature, "signature");
        Object[] constructors = modelClass.getConstructors();
        kotlin.jvm.internal.s.h(constructors, "modelClass.constructors");
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            kotlin.jvm.internal.s.h(parameterTypes, "constructor.parameterTypes");
            List M = m.M(parameterTypes);
            if (kotlin.jvm.internal.s.d(signature, M)) {
                kotlin.jvm.internal.s.g(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (signature.size() == M.size() && M.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + ((Object) signature));
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T newInstance(@NotNull Class<T> modelClass, @NotNull Constructor<T> constructor, @NotNull Object... params) {
        kotlin.jvm.internal.s.i(modelClass, "modelClass");
        kotlin.jvm.internal.s.i(constructor, "constructor");
        kotlin.jvm.internal.s.i(params, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Failed to access " + ((Object) modelClass), e2);
        } catch (InstantiationException e10) {
            throw new RuntimeException("A " + ((Object) modelClass) + " cannot be instantiated.", e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException("An exception happened in constructor of " + ((Object) modelClass), e11.getCause());
        }
    }
}
