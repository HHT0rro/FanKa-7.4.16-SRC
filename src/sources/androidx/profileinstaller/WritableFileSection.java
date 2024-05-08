package androidx.profileinstaller;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class WritableFileSection {
    public final byte[] mContents;
    public final int mExpectedInflateSize;
    public final boolean mNeedsCompression;
    public final FileSectionType mType;

    public WritableFileSection(@NonNull FileSectionType fileSectionType, int i10, @NonNull byte[] bArr, boolean z10) {
        this.mType = fileSectionType;
        this.mExpectedInflateSize = i10;
        this.mContents = bArr;
        this.mNeedsCompression = z10;
    }
}
