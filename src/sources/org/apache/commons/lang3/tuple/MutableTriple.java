package org.apache.commons.lang3.tuple;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MutableTriple<L, M, R> extends Triple<L, M, R> {
    private static final long serialVersionUID = 1;
    public L left;
    public M middle;
    public R right;

    public MutableTriple() {
    }

    public static <L, M, R> MutableTriple<L, M, R> of(L l10, M m10, R r10) {
        return new MutableTriple<>(l10, m10, r10);
    }

    @Override // org.apache.commons.lang3.tuple.Triple
    public L getLeft() {
        return this.left;
    }

    @Override // org.apache.commons.lang3.tuple.Triple
    public M getMiddle() {
        return this.middle;
    }

    @Override // org.apache.commons.lang3.tuple.Triple
    public R getRight() {
        return this.right;
    }

    public void setLeft(L l10) {
        this.left = l10;
    }

    public void setMiddle(M m10) {
        this.middle = m10;
    }

    public void setRight(R r10) {
        this.right = r10;
    }

    public MutableTriple(L l10, M m10, R r10) {
        this.left = l10;
        this.middle = m10;
        this.right = r10;
    }
}
