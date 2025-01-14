package org.apache.commons.lang3.tuple;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MutablePair<L, R> extends Pair<L, R> {
    private static final long serialVersionUID = 4954918890077093841L;
    public L left;
    public R right;

    public MutablePair() {
    }

    public static <L, R> MutablePair<L, R> of(L l10, R r10) {
        return new MutablePair<>(l10, r10);
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public L getLeft() {
        return this.left;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public R getRight() {
        return this.right;
    }

    public void setLeft(L l10) {
        this.left = l10;
    }

    public void setRight(R r10) {
        this.right = r10;
    }

    @Override // java.util.Map.Entry
    public R setValue(R r10) {
        R right = getRight();
        setRight(r10);
        return right;
    }

    public MutablePair(L l10, R r10) {
        this.left = l10;
        this.right = r10;
    }
}
