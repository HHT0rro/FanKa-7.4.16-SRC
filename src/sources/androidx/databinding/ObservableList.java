package androidx.databinding;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ObservableList<T> extends List<T> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static abstract class OnListChangedCallback<T extends ObservableList> {
        public abstract void onChanged(T t2);

        public abstract void onItemRangeChanged(T t2, int i10, int i11);

        public abstract void onItemRangeInserted(T t2, int i10, int i11);

        public abstract void onItemRangeMoved(T t2, int i10, int i11, int i12);

        public abstract void onItemRangeRemoved(T t2, int i10, int i11);
    }

    void addOnListChangedCallback(OnListChangedCallback<? extends ObservableList<T>> onListChangedCallback);

    void removeOnListChangedCallback(OnListChangedCallback<? extends ObservableList<T>> onListChangedCallback);
}
