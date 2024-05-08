package i2;

import i2.b;
import java.lang.ref.WeakReference;

/* compiled from: BasePresenter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a<T extends b> {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<T> f49710a;

    public T c() {
        WeakReference<T> weakReference = this.f49710a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean d() {
        return c() != null;
    }
}
