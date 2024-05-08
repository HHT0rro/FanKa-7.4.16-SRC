package td;

import java.lang.reflect.Method;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DebugMetadata.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f53809a = new g();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f53810b = new a(null, null, null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static a f53811c;

    /* compiled from: DebugMetadata.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public final Method f53812a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final Method f53813b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final Method f53814c;

        public a(@Nullable Method method, @Nullable Method method2, @Nullable Method method3) {
            this.f53812a = method;
            this.f53813b = method2;
            this.f53814c = method3;
        }
    }

    public final a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f53811c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f53810b;
            f53811c = aVar2;
            return aVar2;
        }
    }

    @Nullable
    public final String b(@NotNull BaseContinuationImpl continuation) {
        s.i(continuation, "continuation");
        a aVar = f53811c;
        if (aVar == null) {
            aVar = a(continuation);
        }
        if (aVar == f53810b) {
            return null;
        }
        Method method = aVar.f53812a;
        Object invoke = method != null ? method.invoke(continuation.getClass(), new Object[0]) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = aVar.f53813b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = aVar.f53814c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}
