package org.apache.commons.lang3.tuple;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ImmutablePair<L, R> extends Pair<L, R> {
    private static final ImmutablePair NULL = of((Object) null, (Object) null);
    private static final long serialVersionUID = 4954918890077093841L;
    public final L left;
    public final R right;

    public ImmutablePair(L l10, R r10) {
        this.left = l10;
        this.right = r10;
    }

    public static <L, R> ImmutablePair<L, R> nullPair() {
        return NULL;
    }

    public static <L, R> ImmutablePair<L, R> of(L l10, R r10) {
        return new ImmutablePair<>(l10, r10);
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public L getLeft() {
        return this.left;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public R getRight() {
        return this.right;
    }

    @Override // java.util.Map.Entry
    public R setValue(R r10) {
        throw new UnsupportedOperationException();
    }
}
