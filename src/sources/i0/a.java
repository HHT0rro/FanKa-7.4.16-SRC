package i0;

import java.util.List;

/* compiled from: ArrayWheelAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a<T> implements r0.a {

    /* renamed from: a, reason: collision with root package name */
    public List<T> f49673a;

    public a(List<T> list) {
        this.f49673a = list;
    }

    @Override // r0.a
    public int a() {
        return this.f49673a.size();
    }

    @Override // r0.a
    public Object getItem(int i10) {
        return (i10 < 0 || i10 >= this.f49673a.size()) ? "" : this.f49673a.get(i10);
    }
}
