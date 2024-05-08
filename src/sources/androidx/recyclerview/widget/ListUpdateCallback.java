package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ListUpdateCallback {
    void onChanged(int i10, int i11, @Nullable Object obj);

    void onInserted(int i10, int i11);

    void onMoved(int i10, int i11);

    void onRemoved(int i10, int i11);
}
