package com.android.internal.inputmethod;

import android.annotation.NonNull;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.autofill.AutofillId;
import com.android.internal.util.AnnotationValidations;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class InlineSuggestionsRequestInfo implements Parcelable {
    public static final Parcelable.Creator<InlineSuggestionsRequestInfo> CREATOR = new Parcelable.Creator<InlineSuggestionsRequestInfo>() { // from class: com.android.internal.inputmethod.InlineSuggestionsRequestInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InlineSuggestionsRequestInfo[] newArray(int size) {
            return new InlineSuggestionsRequestInfo[size];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InlineSuggestionsRequestInfo createFromParcel(Parcel in) {
            return new InlineSuggestionsRequestInfo(in);
        }
    };
    private final AutofillId mAutofillId;
    private final ComponentName mComponentName;
    private final Bundle mUiExtras;

    public InlineSuggestionsRequestInfo(ComponentName componentName, AutofillId autofillId, Bundle uiExtras) {
        this.mComponentName = componentName;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, componentName);
        this.mAutofillId = autofillId;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, autofillId);
        this.mUiExtras = uiExtras;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, uiExtras);
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    public AutofillId getAutofillId() {
        return this.mAutofillId;
    }

    public Bundle getUiExtras() {
        return this.mUiExtras;
    }

    public String toString() {
        return "InlineSuggestionsRequestInfo { componentName = " + ((Object) this.mComponentName) + ", autofillId = " + ((Object) this.mAutofillId) + ", uiExtras = " + ((Object) this.mUiExtras) + " }";
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        InlineSuggestionsRequestInfo that = (InlineSuggestionsRequestInfo) o10;
        if (Objects.equals(this.mComponentName, that.mComponentName) && Objects.equals(this.mAutofillId, that.mAutofillId) && Objects.equals(this.mUiExtras, that.mUiExtras)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int _hash = (1 * 31) + Objects.hashCode(this.mComponentName);
        return (((_hash * 31) + Objects.hashCode(this.mAutofillId)) * 31) + Objects.hashCode(this.mUiExtras);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedObject(this.mComponentName, flags);
        dest.writeTypedObject(this.mAutofillId, flags);
        dest.writeBundle(this.mUiExtras);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    InlineSuggestionsRequestInfo(Parcel in) {
        ComponentName componentName = (ComponentName) in.readTypedObject(ComponentName.CREATOR);
        AutofillId autofillId = (AutofillId) in.readTypedObject(AutofillId.CREATOR);
        Bundle uiExtras = in.readBundle();
        this.mComponentName = componentName;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, componentName);
        this.mAutofillId = autofillId;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, autofillId);
        this.mUiExtras = uiExtras;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, uiExtras);
    }

    @Deprecated
    private void __metadata() {
    }
}
