package le;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.Result;
import retrofit2.c;
import retrofit2.p;

/* compiled from: RxJava2CallAdapterFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class f extends c.a {

    /* renamed from: a, reason: collision with root package name */
    public final Scheduler f51718a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f51719b;

    public f(Scheduler scheduler, boolean z10) {
        this.f51718a = scheduler;
        this.f51719b = z10;
    }

    public static f d() {
        return new f(null, false);
    }

    public static f e(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler == null");
        return new f(scheduler, false);
    }

    @Override // retrofit2.c.a
    public retrofit2.c<?, ?> a(Type type, Annotation[] annotationArr, p pVar) {
        Type type2;
        boolean z10;
        boolean z11;
        Class<?> c4 = c.a.c(type);
        if (c4 == Completable.class) {
            return new e(Void.class, this.f51718a, this.f51719b, false, true, false, false, false, true);
        }
        boolean z12 = c4 == Flowable.class;
        boolean z13 = c4 == Single.class;
        boolean z14 = c4 == Maybe.class;
        if (c4 != Observable.class && !z12 && !z13 && !z14) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z12 ? !z13 ? z14 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type b4 = c.a.b(0, (ParameterizedType) type);
        Class<?> c10 = c.a.c(b4);
        if (c10 == Response.class) {
            if (b4 instanceof ParameterizedType) {
                type2 = c.a.b(0, (ParameterizedType) b4);
                z10 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (c10 == Result.class) {
            if (b4 instanceof ParameterizedType) {
                type2 = c.a.b(0, (ParameterizedType) b4);
                z10 = true;
            } else {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
        } else {
            type2 = b4;
            z10 = false;
            z11 = true;
            return new e(type2, this.f51718a, this.f51719b, z10, z11, z12, z13, z14, false);
        }
        z11 = false;
        return new e(type2, this.f51718a, this.f51719b, z10, z11, z12, z13, z14, false);
    }
}
