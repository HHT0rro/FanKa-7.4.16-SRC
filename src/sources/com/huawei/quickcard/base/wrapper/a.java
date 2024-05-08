package com.huawei.quickcard.base.wrapper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.interfaces.IQuickCardData;
import com.huawei.quickcard.base.utils.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class a<T> {
    public static Object a(DataWrapper dataWrapper, @NonNull Object obj, @NonNull int i10) {
        return dataWrapper.get((DataWrapper) obj, String.valueOf(i10));
    }

    public static void b(DataWrapper dataWrapper, @NonNull Object obj, @NonNull int i10, @Nullable Object obj2) {
        dataWrapper.set((DataWrapper) obj, String.valueOf(i10), obj2);
    }

    public static Object c(DataWrapper dataWrapper, @NonNull Object obj, int i10) {
        return dataWrapper.slice(obj, i10, dataWrapper.size(obj));
    }

    public static Object d(DataWrapper dataWrapper, @NonNull Object obj, int i10, int i11) {
        return null;
    }

    public static Object e(DataWrapper dataWrapper, String str, int i10, @NonNull Object obj, int i11, int i12, Object... objArr) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String f(DataWrapper dataWrapper, @NonNull Object obj) {
        if (!dataWrapper.isArray(obj)) {
            return "[object object]";
        }
        int size = dataWrapper.size(obj);
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj2 = dataWrapper.get((DataWrapper) obj, String.valueOf(i10));
            if (obj2 == null) {
                sb2.append("");
            } else {
                DataWrapper dataWrapper2 = WrapDataUtils.getDataWrapper(obj2);
                if (dataWrapper2 != 0) {
                    sb2.append(dataWrapper2.toString(obj2));
                } else {
                    sb2.append(obj2.toString());
                }
            }
            if (i10 < size - 1) {
                sb2.append(',');
            }
        }
        return sb2.toString();
    }

    public static void g(StringBuilder sb2, Object obj) {
        DataWrapper dataWrapper = WrapDataUtils.getDataWrapper(obj);
        if (dataWrapper != null) {
            sb2.append(dataWrapper.stringify(obj));
            return;
        }
        if (obj instanceof IQuickCardData) {
            sb2.append(((IQuickCardData) obj).toJSON());
            return;
        }
        if (obj != null && !(obj instanceof Number) && !(obj instanceof Boolean)) {
            sb2.append("\"");
            sb2.append(Utils.wrapStr(obj.toString()));
            sb2.append("\"");
            return;
        }
        sb2.append(obj);
    }
}
