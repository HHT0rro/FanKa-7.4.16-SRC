package com.huawei.quickcard.base.wrapper.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.utils.Utils;
import com.huawei.quickcard.base.wrapper.DataWrapper;
import com.huawei.quickcard.base.wrapper.a;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ArrDataWrapper implements DataWrapper<Object[]> {
    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void add(@NonNull Object[] objArr, @NonNull Object obj) {
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isArray(@NonNull Object[] objArr) {
        return true;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isObject(@NonNull Object[] objArr) {
        return false;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object slice(Object[] objArr, int i10) {
        return a.c(this, objArr, i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object splice(String str, int i10, Object[] objArr, int i11, int i12, Object... objArr2) {
        return a.e(this, str, i10, objArr, i11, i12, objArr2);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ String toString(Object[] objArr) {
        return a.f(this, objArr);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    @NonNull
    public String[] keys(@NonNull Object[] objArr) {
        int length = objArr.length;
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            strArr[i10] = String.valueOf(i10);
        }
        return strArr;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public int size(@NonNull Object[] objArr) {
        return objArr.length;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object slice(@NonNull Object[] objArr, int i10, int i11) {
        int length = objArr.length;
        if (i10 < 0) {
            i10 += length;
        }
        int max = Math.max(i10, 0);
        if (max >= length) {
            return new Object[0];
        }
        if (i11 < 0) {
            i11 += length;
        }
        return i11 <= max ? new Object[0] : Arrays.copyOfRange(objArr, max, Math.min(i11, length));
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public String stringify(@NonNull Object[] objArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        for (int i10 = 0; i10 < objArr.length; i10++) {
            a.g(sb2, objArr[i10]);
            if (i10 < objArr.length - 1) {
                sb2.append(',');
            }
        }
        sb2.append(']');
        return sb2.toString();
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object get(@NonNull Object[] objArr, @NonNull String str) {
        if (Utils.isIntNum(str)) {
            return get(objArr, Integer.parseInt(str));
        }
        return null;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void set(@NonNull Object[] objArr, @NonNull String str, @Nullable Object obj) {
        if (Utils.isIntNum(str)) {
            set(objArr, Integer.parseInt(str), obj);
        }
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object get(@NonNull Object[] objArr, @NonNull int i10) {
        if (i10 >= objArr.length || i10 < 0) {
            return null;
        }
        return objArr[i10];
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void set(@NonNull Object[] objArr, @NonNull int i10, @Nullable Object obj) {
        if (i10 < 0 || i10 >= objArr.length) {
            return;
        }
        objArr[i10] = obj;
    }
}
