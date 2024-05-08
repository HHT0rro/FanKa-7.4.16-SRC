package xb;

import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.List;

/* compiled from: Permission.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f54608a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f54609b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f54610c;

    /* compiled from: Permission.java */
    /* renamed from: xb.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class C0840a implements BiConsumer<StringBuilder, String> {
        public C0840a() {
        }

        @Override // io.reactivex.functions.BiConsumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(StringBuilder sb2, String str) throws Exception {
            if (sb2.length() == 0) {
                sb2.append(str);
            } else {
                sb2.append(", ");
                sb2.append(str);
            }
        }
    }

    /* compiled from: Permission.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class b implements Function<a, String> {
        public b() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(a aVar) throws Exception {
            return aVar.f54608a;
        }
    }

    /* compiled from: Permission.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class c implements Predicate<a> {
        public c() {
        }

        @Override // io.reactivex.functions.Predicate
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(a aVar) throws Exception {
            return aVar.f54609b;
        }
    }

    /* compiled from: Permission.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class d implements Predicate<a> {
        public d() {
        }

        @Override // io.reactivex.functions.Predicate
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(a aVar) throws Exception {
            return aVar.f54610c;
        }
    }

    public a(String str, boolean z10, boolean z11) {
        this.f54608a = str;
        this.f54609b = z10;
        this.f54610c = z11;
    }

    public final Boolean a(List<a> list) {
        return Observable.fromIterable(list).all(new c()).blockingGet();
    }

    public final String b(List<a> list) {
        return ((StringBuilder) Observable.fromIterable(list).map(new b()).collectInto(new StringBuilder(), new C0840a()).blockingGet()).toString();
    }

    public final Boolean c(List<a> list) {
        return Observable.fromIterable(list).any(new d()).blockingGet();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f54609b == aVar.f54609b && this.f54610c == aVar.f54610c) {
            return this.f54608a.equals(aVar.f54608a);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f54608a.hashCode() * 31) + (this.f54609b ? 1 : 0)) * 31) + (this.f54610c ? 1 : 0);
    }

    public String toString() {
        return "Permission{name='" + this.f54608a + "', granted=" + this.f54609b + ", shouldShowRequestPermissionRationale=" + this.f54610c + '}';
    }

    public a(List<a> list) {
        this.f54608a = b(list);
        this.f54609b = a(list).booleanValue();
        this.f54610c = c(list).booleanValue();
    }
}
