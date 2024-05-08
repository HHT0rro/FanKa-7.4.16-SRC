package com.alimm.tanx.ui.image.glide.signature;

import com.alimm.tanx.ui.image.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class MediaStoreSignature implements Key {
    public final long dateModified;
    public final String mimeType;
    public final int orientation;

    public MediaStoreSignature(String str, long j10, int i10) {
        this.mimeType = str;
        this.dateModified = j10;
        this.orientation = i10;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaStoreSignature.class != obj.getClass()) {
            return false;
        }
        MediaStoreSignature mediaStoreSignature = (MediaStoreSignature) obj;
        if (this.dateModified != mediaStoreSignature.dateModified || this.orientation != mediaStoreSignature.orientation) {
            return false;
        }
        String str = this.mimeType;
        String str2 = mediaStoreSignature.mimeType;
        return str == null ? str2 == null : str.equals(str2);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public int hashCode() {
        String str = this.mimeType;
        int hashCode = str != null ? str.hashCode() : 0;
        long j10 = this.dateModified;
        return (((hashCode * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.orientation;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.dateModified).putInt(this.orientation).array());
        messageDigest.update(this.mimeType.getBytes("UTF-8"));
    }
}
