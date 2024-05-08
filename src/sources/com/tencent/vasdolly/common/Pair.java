package com.tencent.vasdolly.common;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Pair<A, B> {
    private final A mFirst;
    private final B mSecond;

    private Pair(A a10, B b4) {
        this.mFirst = a10;
        this.mSecond = b4;
    }

    public static <A, B> Pair<A, B> create(A a10, B b4) {
        return new Pair<>(a10, b4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Pair.class != obj.getClass()) {
            return false;
        }
        Pair pair = (Pair) obj;
        A a10 = this.mFirst;
        if (a10 == null) {
            if (pair.mFirst != null) {
                return false;
            }
        } else if (!a10.equals(pair.mFirst)) {
            return false;
        }
        B b4 = this.mSecond;
        if (b4 == null) {
            if (pair.mSecond != null) {
                return false;
            }
        } else if (!b4.equals(pair.mSecond)) {
            return false;
        }
        return true;
    }

    public A getFirst() {
        return this.mFirst;
    }

    public B getSecond() {
        return this.mSecond;
    }

    public int hashCode() {
        A a10 = this.mFirst;
        int hashCode = ((a10 == null ? 0 : a10.hashCode()) + 31) * 31;
        B b4 = this.mSecond;
        return hashCode + (b4 != null ? b4.hashCode() : 0);
    }

    public String toString() {
        return "first = " + ((Object) this.mFirst) + " , second = " + ((Object) this.mSecond);
    }
}
