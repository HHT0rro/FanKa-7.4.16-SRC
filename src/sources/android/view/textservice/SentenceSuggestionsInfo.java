package android.view.textservice;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class SentenceSuggestionsInfo implements Parcelable {
    public static final Parcelable.Creator<SentenceSuggestionsInfo> CREATOR = new Parcelable.Creator<SentenceSuggestionsInfo>() { // from class: android.view.textservice.SentenceSuggestionsInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SentenceSuggestionsInfo createFromParcel(Parcel source) {
            return new SentenceSuggestionsInfo(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SentenceSuggestionsInfo[] newArray(int size) {
            return new SentenceSuggestionsInfo[size];
        }
    };
    private final int[] mLengths;
    private final int[] mOffsets;
    private final SuggestionsInfo[] mSuggestionsInfos;

    public SentenceSuggestionsInfo(SuggestionsInfo[] suggestionsInfos, int[] offsets, int[] lengths) {
        if (suggestionsInfos == null || offsets == null || lengths == null) {
            throw new NullPointerException();
        }
        if (suggestionsInfos.length != offsets.length || offsets.length != lengths.length) {
            throw new IllegalArgumentException();
        }
        int infoSize = suggestionsInfos.length;
        this.mSuggestionsInfos = (SuggestionsInfo[]) Arrays.copyOf(suggestionsInfos, infoSize);
        this.mOffsets = Arrays.copyOf(offsets, infoSize);
        this.mLengths = Arrays.copyOf(lengths, infoSize);
    }

    public SentenceSuggestionsInfo(Parcel source) {
        int infoSize = source.readInt();
        SuggestionsInfo[] suggestionsInfoArr = new SuggestionsInfo[infoSize];
        this.mSuggestionsInfos = suggestionsInfoArr;
        source.readTypedArray(suggestionsInfoArr, SuggestionsInfo.CREATOR);
        int[] iArr = new int[suggestionsInfoArr.length];
        this.mOffsets = iArr;
        source.readIntArray(iArr);
        int[] iArr2 = new int[suggestionsInfoArr.length];
        this.mLengths = iArr2;
        source.readIntArray(iArr2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        int infoSize = this.mSuggestionsInfos.length;
        dest.writeInt(infoSize);
        dest.writeTypedArray(this.mSuggestionsInfos, 0);
        dest.writeIntArray(this.mOffsets);
        dest.writeIntArray(this.mLengths);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getSuggestionsCount() {
        return this.mSuggestionsInfos.length;
    }

    public SuggestionsInfo getSuggestionsInfoAt(int i10) {
        if (i10 < 0) {
            return null;
        }
        SuggestionsInfo[] suggestionsInfoArr = this.mSuggestionsInfos;
        if (i10 < suggestionsInfoArr.length) {
            return suggestionsInfoArr[i10];
        }
        return null;
    }

    public int getOffsetAt(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int[] iArr = this.mOffsets;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    public int getLengthAt(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int[] iArr = this.mLengths;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }
}
