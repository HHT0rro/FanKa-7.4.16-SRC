package i;

import java.util.Arrays;
import java.util.List;

/* compiled from: BaseAnimatableValue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class n<V, O> implements m<V, O> {

    /* renamed from: a, reason: collision with root package name */
    public final List<o.a<V>> f49672a;

    public n(List<o.a<V>> list) {
        this.f49672a = list;
    }

    @Override // i.m
    public List<o.a<V>> b() {
        return this.f49672a;
    }

    @Override // i.m
    public boolean c() {
        return this.f49672a.isEmpty() || (this.f49672a.size() == 1 && this.f49672a.get(0).i());
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (!this.f49672a.isEmpty()) {
            sb2.append("values=");
            sb2.append(Arrays.toString(this.f49672a.toArray()));
        }
        return sb2.toString();
    }
}
