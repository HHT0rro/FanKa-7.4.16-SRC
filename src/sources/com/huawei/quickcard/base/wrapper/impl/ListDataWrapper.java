package com.huawei.quickcard.base.wrapper.impl;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.utils.Utils;
import com.huawei.quickcard.base.wrapper.DataWrapper;
import com.huawei.quickcard.base.wrapper.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ListDataWrapper implements DataWrapper<List> {
    private static void a(List list, int i10) {
        for (int size = list.size(); size < i10; size++) {
            list.add(0);
        }
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isArray(@NonNull List list) {
        return true;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isObject(@NonNull List list) {
        return false;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object slice(List list, int i10) {
        return a.c(this, list, i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ String toString(List list) {
        return a.f(this, list);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void add(@NonNull List list, @NonNull Object obj) {
        list.add(obj);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    @NonNull
    public String[] keys(@NonNull List list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = String.valueOf(i10);
        }
        return strArr;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public int size(@NonNull List list) {
        return list.size();
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object slice(@NonNull List list, int i10, int i11) {
        int size = list.size();
        if (i10 < 0) {
            i10 += size;
        }
        int max = Math.max(i10, 0);
        if (max >= size) {
            return new ArrayList();
        }
        if (i11 < 0) {
            i11 += size;
        }
        if (i11 <= max) {
            return new ArrayList();
        }
        return new ArrayList(list.subList(max, Math.min(i11, size)));
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object splice(String str, int i10, @NonNull List list, int i11, int i12, Object... objArr) {
        int size = list.size();
        if (i11 < 0) {
            i11 += size;
        }
        int max = Math.max(Math.min(i11, size), 0);
        int max2 = Math.max(Math.min(size - max, i12), 0);
        ArrayList arrayList = new ArrayList();
        if (max < size) {
            arrayList.addAll(list.subList(max, max + max2));
        }
        int length = objArr.length - max2;
        int i13 = size + length;
        for (int i14 = i13 - 1; i14 >= max; i14--) {
            a(list, i14 + 1);
            if (i14 < objArr.length + max) {
                Object obj = list.get(i14);
                int i15 = i14 - max;
                list.set(i14, objArr[i15]);
                if (str != null) {
                    Utils.notifyDataSet(i10, str + "[" + i14 + "]", obj, objArr[i15]);
                }
            } else if (length != 0) {
                Object obj2 = list.get(i14);
                list.set(i14, list.get(i14 - length));
                if (str != null) {
                    Utils.notifyDataSet(i10, str + "[" + i14 + "]", obj2, list.get(i14));
                }
            }
        }
        for (int i16 = size - 1; i16 >= i13; i16--) {
            Object remove = list.remove(i16);
            if (str != null) {
                Utils.notifyDataSet(i10, str + "[" + i16 + "]", remove, null);
            }
        }
        return arrayList;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public String stringify(@NonNull List list) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        for (int i10 = 0; i10 < size(list); i10++) {
            a.g(sb2, list.get(i10));
            if (i10 < size(list) - 1) {
                sb2.append(',');
            }
        }
        sb2.append(']');
        return sb2.toString();
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object get(@NonNull List list, String str) {
        if (Utils.isIntNum(str)) {
            return get(list, Integer.parseInt(str));
        }
        return null;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void set(@NonNull List list, String str, Object obj) {
        if (Utils.isIntNum(str)) {
            set(list, Integer.parseInt(str), obj);
        }
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object get(@NonNull List list, int i10) {
        if (i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return list.get(i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void set(@NonNull List list, int i10, Object obj) {
        if (i10 < 0) {
            return;
        }
        if (i10 >= list.size()) {
            for (int size = list.size(); size <= i10; size++) {
                list.add(null);
            }
        }
        list.set(i10, obj);
    }
}
