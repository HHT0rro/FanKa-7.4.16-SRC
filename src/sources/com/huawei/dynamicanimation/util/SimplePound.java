package com.huawei.dynamicanimation.util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class SimplePound<T> implements Pound<T> {
    public final Object[] mPoundArray;
    public int mPoundRealSize;

    public SimplePound(int i10) {
        if (i10 > 0) {
            this.mPoundArray = new Object[i10];
            return;
        }
        throw new IllegalArgumentException("The max pound capacity must > 0");
    }

    private boolean isInstanceInPounds(T t2) {
        for (int i10 = 0; i10 < this.mPoundRealSize; i10++) {
            if (this.mPoundArray[i10] == t2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.huawei.dynamicanimation.util.Pound
    public T getInstance() {
        int i10 = this.mPoundRealSize;
        if (i10 > 0) {
            int i11 = i10 - 1;
            Object[] objArr = this.mPoundArray;
            if (objArr != null && i11 < objArr.length) {
                T t2 = (T) objArr[i11];
                objArr[i11] = null;
                this.mPoundRealSize = i11;
                return t2;
            }
        }
        return null;
    }

    @Override // com.huawei.dynamicanimation.util.Pound
    public boolean restoreInstance(T t2) {
        if (!isInstanceInPounds(t2)) {
            int i10 = this.mPoundRealSize;
            Object[] objArr = this.mPoundArray;
            if (i10 >= objArr.length) {
                return false;
            }
            objArr[i10] = t2;
            this.mPoundRealSize = i10 + 1;
            return true;
        }
        throw new IllegalStateException("The instance is already in the pounds!");
    }
}
