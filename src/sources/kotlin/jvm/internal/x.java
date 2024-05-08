package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: SpreadBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<Object> f51037a;

    public x(int i10) {
        this.f51037a = new ArrayList<>(i10);
    }

    public void a(Object obj) {
        this.f51037a.add(obj);
    }

    public void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.f51037a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f51037a, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.f51037a.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator iterator2 = ((Iterable) obj).iterator2();
            while (iterator2.hasNext()) {
                this.f51037a.add(iterator2.next());
            }
            return;
        }
        if (obj instanceof Iterator) {
            Iterator it = (Iterator) obj;
            while (it.hasNext()) {
                this.f51037a.add(it.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + ((Object) obj.getClass()));
        }
    }

    public int c() {
        return this.f51037a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.f51037a.toArray(objArr);
    }
}
