package android.view.translation;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class TranslationRequestValue implements Parcelable {
    public static final Parcelable.Creator<TranslationRequestValue> CREATOR = new Parcelable.Creator<TranslationRequestValue>() { // from class: android.view.translation.TranslationRequestValue.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TranslationRequestValue[] newArray(int size) {
            return new TranslationRequestValue[size];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TranslationRequestValue createFromParcel(Parcel in) {
            return new TranslationRequestValue(in);
        }
    };
    private final CharSequence mText;

    public static TranslationRequestValue forText(CharSequence text) {
        Objects.requireNonNull(text, "text should not be null");
        return new TranslationRequestValue(text);
    }

    public CharSequence getText() {
        return this.mText;
    }

    public TranslationRequestValue(CharSequence text) {
        this.mText = text;
    }

    public String toString() {
        return "TranslationRequestValue { text = " + ((Object) this.mText) + " }";
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        TranslationRequestValue that = (TranslationRequestValue) o10;
        return Objects.equals(this.mText, that.mText);
    }

    public int hashCode() {
        int _hash = (1 * 31) + Objects.hashCode(this.mText);
        return _hash;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        byte flg = this.mText != null ? (byte) (0 | 1) : (byte) 0;
        dest.writeByte(flg);
        CharSequence charSequence = this.mText;
        if (charSequence != null) {
            dest.writeCharSequence(charSequence);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    TranslationRequestValue(Parcel in) {
        byte flg = in.readByte();
        CharSequence text = (flg & 1) == 0 ? null : in.readCharSequence();
        this.mText = text;
    }

    @Deprecated
    private void __metadata() {
    }
}
