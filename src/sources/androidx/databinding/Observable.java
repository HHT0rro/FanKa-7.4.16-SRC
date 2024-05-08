package androidx.databinding;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface Observable {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static abstract class OnPropertyChangedCallback {
        public abstract void onPropertyChanged(Observable observable, int i10);
    }

    void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback);

    void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback);
}
