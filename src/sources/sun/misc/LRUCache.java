package sun.misc;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class LRUCache<N, V> {

    /* renamed from: oa, reason: collision with root package name */
    private V[] f53710oa = null;
    private final int size;

    protected abstract V create(N n10);

    protected abstract boolean hasName(V v2, N n10);

    public LRUCache(int size) {
        this.size = size;
    }

    public static void moveToFront(Object[] oa2, int i10) {
        Object ob2 = oa2[i10];
        for (int j10 = i10; j10 > 0; j10--) {
            oa2[j10] = oa2[j10 - 1];
        }
        oa2[0] = ob2;
    }

    public V forName(N n10) {
        if (this.f53710oa == null) {
            this.f53710oa = (V[]) new Object[this.size];
        } else {
            int i10 = 0;
            while (true) {
                V[] vArr = this.f53710oa;
                if (i10 >= vArr.length) {
                    break;
                }
                V v2 = vArr[i10];
                if (v2 == null || !hasName(v2, n10)) {
                    i10++;
                } else {
                    if (i10 > 0) {
                        moveToFront(this.f53710oa, i10);
                    }
                    return v2;
                }
            }
        }
        V create = create(n10);
        V[] vArr2 = this.f53710oa;
        vArr2[vArr2.length - 1] = create;
        moveToFront(vArr2, vArr2.length - 1);
        return create;
    }
}
