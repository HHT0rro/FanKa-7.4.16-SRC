package android.view.textclassifier;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class TextClassificationSessionId implements Parcelable {
    public static final Parcelable.Creator<TextClassificationSessionId> CREATOR = new Parcelable.Creator<TextClassificationSessionId>() { // from class: android.view.textclassifier.TextClassificationSessionId.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextClassificationSessionId createFromParcel(Parcel parcel) {
            return new TextClassificationSessionId(parcel.readString(), parcel.readStrongBinder());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextClassificationSessionId[] newArray(int size) {
            return new TextClassificationSessionId[size];
        }
    };
    private final IBinder mToken;
    private final String mValue;

    public TextClassificationSessionId() {
        this(UUID.randomUUID().toString(), new Binder());
    }

    public TextClassificationSessionId(String value, IBinder token) {
        this.mValue = (String) Objects.requireNonNull(value);
        this.mToken = (IBinder) Objects.requireNonNull(token);
    }

    public IBinder getToken() {
        return this.mToken;
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        TextClassificationSessionId that = (TextClassificationSessionId) o10;
        if (Objects.equals(this.mValue, that.mValue) && Objects.equals(this.mToken, that.mToken)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.mValue, this.mToken);
    }

    public String toString() {
        return String.format(Locale.US, "TextClassificationSessionId {%s}", this.mValue);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(this.mValue);
        parcel.writeStrongBinder(this.mToken);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getValue() {
        return this.mValue;
    }
}
