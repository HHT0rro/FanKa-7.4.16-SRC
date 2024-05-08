package xb;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tbruyelle.rxpermissions2.RxPermissionsFragment;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RxPermissions.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static final String f54615b = "b";

    /* renamed from: c, reason: collision with root package name */
    public static final Object f54616c = new Object();

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public d<RxPermissionsFragment> f54617a;

    /* compiled from: RxPermissions.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements d<RxPermissionsFragment> {

        /* renamed from: a, reason: collision with root package name */
        public RxPermissionsFragment f54618a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f54619b;

        public a(FragmentManager fragmentManager) {
            this.f54619b = fragmentManager;
        }

        @Override // xb.b.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public synchronized RxPermissionsFragment get() {
            if (this.f54618a == null) {
                this.f54618a = b.this.g(this.f54619b);
            }
            return this.f54618a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: RxPermissions.java */
    /* renamed from: xb.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class C0841b<T> implements ObservableTransformer<T, xb.a> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f54621a;

        /* compiled from: RxPermissions.java */
        /* renamed from: xb.b$b$a */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public class a implements Function<List<xb.a>, ObservableSource<xb.a>> {
            public a() {
            }

            @Override // io.reactivex.functions.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ObservableSource<xb.a> apply(List<xb.a> list) {
                if (list.isEmpty()) {
                    return Observable.empty();
                }
                return Observable.just(new xb.a(list));
            }
        }

        public C0841b(String[] strArr) {
            this.f54621a = strArr;
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource<xb.a> apply(Observable<T> observable) {
            return b.this.m(observable, this.f54621a).buffer(this.f54621a.length).flatMap(new a());
        }
    }

    /* compiled from: RxPermissions.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class c implements Function<Object, Observable<xb.a>> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String[] f54624b;

        public c(String[] strArr) {
            this.f54624b = strArr;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Observable<xb.a> apply(Object obj) {
            return b.this.o(this.f54624b);
        }
    }

    /* compiled from: RxPermissions.java */
    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface d<V> {
        V get();
    }

    public b(@NonNull FragmentActivity fragmentActivity) {
        this.f54617a = f(fragmentActivity.getSupportFragmentManager());
    }

    public <T> ObservableTransformer<T, xb.a> d(String... strArr) {
        return new C0841b(strArr);
    }

    public final RxPermissionsFragment e(@NonNull FragmentManager fragmentManager) {
        return (RxPermissionsFragment) fragmentManager.findFragmentByTag(f54615b);
    }

    @NonNull
    public final d<RxPermissionsFragment> f(@NonNull FragmentManager fragmentManager) {
        return new a(fragmentManager);
    }

    public final RxPermissionsFragment g(@NonNull FragmentManager fragmentManager) {
        RxPermissionsFragment e2 = e(fragmentManager);
        if (!(e2 == null)) {
            return e2;
        }
        RxPermissionsFragment rxPermissionsFragment = new RxPermissionsFragment();
        fragmentManager.beginTransaction().add(rxPermissionsFragment, f54615b).commitNow();
        return rxPermissionsFragment;
    }

    public boolean h(String str) {
        return !i() || this.f54617a.get().P0(str);
    }

    public boolean i() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public boolean j(String str) {
        return i() && this.f54617a.get().Q0(str);
    }

    public final Observable<?> k(Observable<?> observable, Observable<?> observable2) {
        if (observable == null) {
            return Observable.just(f54616c);
        }
        return Observable.merge(observable, observable2);
    }

    public final Observable<?> l(String... strArr) {
        for (String str : strArr) {
            if (!this.f54617a.get().N0(str)) {
                return Observable.empty();
            }
        }
        return Observable.just(f54616c);
    }

    public final Observable<xb.a> m(Observable<?> observable, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            return k(observable, l(strArr)).flatMap(new c(strArr));
        }
        throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
    }

    public Observable<xb.a> n(String... strArr) {
        return Observable.just(f54616c).compose(d(strArr));
    }

    public final Observable<xb.a> o(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArr) {
            this.f54617a.get().R0("Requesting permission " + str);
            if (h(str)) {
                arrayList.add(Observable.just(new xb.a(str, true, false)));
            } else if (j(str)) {
                arrayList.add(Observable.just(new xb.a(str, false, false)));
            } else {
                PublishSubject<xb.a> O0 = this.f54617a.get().O0(str);
                if (O0 == null) {
                    arrayList2.add(str);
                    O0 = PublishSubject.create();
                    this.f54617a.get().U0(str, O0);
                }
                arrayList.add(O0);
            }
        }
        if (!arrayList2.isEmpty()) {
            p((String[]) arrayList2.toArray(new String[arrayList2.size()]));
        }
        return Observable.concat(Observable.fromIterable(arrayList));
    }

    public void p(String[] strArr) {
        this.f54617a.get().R0("requestPermissionsFromFragment " + TextUtils.join(", ", strArr));
        this.f54617a.get().T0(strArr);
    }

    public b(@NonNull Fragment fragment) {
        this.f54617a = f(fragment.getChildFragmentManager());
    }
}
