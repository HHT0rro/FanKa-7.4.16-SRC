package kotlin.jvm.internal;

import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CollectionToArray.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Object[] f51031a = new Object[0];

    @NotNull
    public static final Object[] a(@NotNull Collection<?> collection) {
        s.i(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator<?> iterator2 = collection.iterator2();
            if (iterator2.hasNext()) {
                Object[] objArr = new Object[size];
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    objArr[i10] = iterator2.next();
                    if (i11 >= objArr.length) {
                        if (!iterator2.hasNext()) {
                            return objArr;
                        }
                        int i12 = ((i11 * 3) + 1) >>> 1;
                        if (i12 <= i11) {
                            if (i11 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                            i12 = AccessibilityNodeInfo.LEASHED_ITEM_ID;
                        }
                        objArr = Arrays.copyOf(objArr, i12);
                        s.h(objArr, "copyOf(result, newSize)");
                    } else if (!iterator2.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr, i11);
                        s.h(copyOf, "copyOf(result, size)");
                        return copyOf;
                    }
                    i10 = i11;
                }
            }
        }
        return f51031a;
    }

    @NotNull
    public static final Object[] b(@NotNull Collection<?> collection, @Nullable Object[] objArr) {
        Object[] objArr2;
        s.i(collection, "collection");
        Objects.requireNonNull(objArr);
        int size = collection.size();
        int i10 = 0;
        if (size == 0) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        Iterator<?> iterator2 = collection.iterator2();
        if (!iterator2.hasNext()) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        if (size <= objArr.length) {
            objArr2 = objArr;
        } else {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            s.g(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr2 = (Object[]) newInstance;
        }
        while (true) {
            int i11 = i10 + 1;
            objArr2[i10] = iterator2.next();
            if (i11 >= objArr2.length) {
                if (!iterator2.hasNext()) {
                    return objArr2;
                }
                int i12 = ((i11 * 3) + 1) >>> 1;
                if (i12 <= i11) {
                    if (i11 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                    i12 = AccessibilityNodeInfo.LEASHED_ITEM_ID;
                }
                objArr2 = Arrays.copyOf(objArr2, i12);
                s.h(objArr2, "copyOf(result, newSize)");
            } else if (!iterator2.hasNext()) {
                if (objArr2 == objArr) {
                    objArr[i11] = null;
                    return objArr;
                }
                Object[] copyOf = Arrays.copyOf(objArr2, i11);
                s.h(copyOf, "copyOf(result, size)");
                return copyOf;
            }
            i10 = i11;
        }
    }
}
