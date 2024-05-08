package androidx.databinding;

import androidx.databinding.Observable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
abstract class BaseObservableField extends BaseObservable {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class DependencyCallback extends Observable.OnPropertyChangedCallback {
        public DependencyCallback() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i10) {
            BaseObservableField.this.notifyChange();
        }
    }

    public BaseObservableField() {
    }

    public BaseObservableField(Observable... observableArr) {
        if (observableArr == null || observableArr.length == 0) {
            return;
        }
        DependencyCallback dependencyCallback = new DependencyCallback();
        for (Observable observable : observableArr) {
            observable.addOnPropertyChangedCallback(dependencyCallback);
        }
    }
}
