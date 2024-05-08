package androidx.databinding.adapters;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ListenerUtil {
    private static final SparseArray<WeakHashMap<View, WeakReference<?>>> sListeners = new SparseArray<>();

    public static <T> T getListener(View view, int i10) {
        return (T) view.getTag(i10);
    }

    public static <T> T trackListener(View view, T t2, int i10) {
        T t10 = (T) view.getTag(i10);
        view.setTag(i10, t2);
        return t10;
    }
}
