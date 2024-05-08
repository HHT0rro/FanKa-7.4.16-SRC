package com.baidu.mobads.sdk.internal.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class b {
    public int a(Object[] objArr, int i10, int i11) {
        return (objArr == null || objArr.length <= i10 || !(objArr[i10] instanceof Integer)) ? i11 : ((Integer) objArr[i10]).intValue();
    }

    public Object a(Object[] objArr, int i10, Object obj) {
        Object obj2;
        return (objArr == null || objArr.length <= i10 || (obj2 = objArr[i10]) == null) ? obj : obj2;
    }
}
