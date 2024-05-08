package androidx.transition;

import android.util.SparseArray;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TransitionValuesMaps {
    public final ArrayMap<View, TransitionValues> mViewValues = new ArrayMap<>();
    public final SparseArray<View> mIdValues = new SparseArray<>();
    public final LongSparseArray<View> mItemIdValues = new LongSparseArray<>();
    public final ArrayMap<String, View> mNameValues = new ArrayMap<>();
}
