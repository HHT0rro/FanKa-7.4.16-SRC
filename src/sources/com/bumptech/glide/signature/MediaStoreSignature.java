package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediaStoreSignature implements Key {
    private final long dateModified;

    @NonNull
    private final String mimeType;
    private final int orientation;

    public MediaStoreSignature(@Nullable String str, long j10, int i10) {
        this.mimeType = str == null ? "" : str;
        this.dateModified = j10;
        this.orientation = i10;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaStoreSignature mediaStoreSignature = (MediaStoreSignature) obj;
        return this.dateModified == mediaStoreSignature.dateModified && this.orientation == mediaStoreSignature.orientation && this.mimeType.equals(mediaStoreSignature.mimeType);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int hashCode = this.mimeType.hashCode() * 31;
        long j10 = this.dateModified;
        return ((hashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.orientation;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.dateModified).putInt(this.orientation).array());
        messageDigest.update(this.mimeType.getBytes(Key.CHARSET));
    }
}
