package androidx.databinding;

import androidx.annotation.Nullable;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ObservableField<T> extends BaseObservableField implements Serializable {
    public static final long serialVersionUID = 1;
    private T mValue;

    public ObservableField(T t2) {
        this.mValue = t2;
    }

    @Nullable
    public T get() {
        return this.mValue;
    }

    public void set(T t2) {
        if (t2 != this.mValue) {
            this.mValue = t2;
            notifyChange();
        }
    }

    public ObservableField() {
    }

    public ObservableField(Observable... observableArr) {
        super(observableArr);
    }
}
