package com.alimm.tanx.ui.image.glide.load.engine;

import com.alimm.tanx.ui.image.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class OriginalKey implements Key {

    /* renamed from: id, reason: collision with root package name */
    public final String f4193id;
    public final Key signature;

    public OriginalKey(String str, Key key) {
        this.f4193id = str;
        this.signature = key;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || OriginalKey.class != obj.getClass()) {
            return false;
        }
        OriginalKey originalKey = (OriginalKey) obj;
        return this.f4193id.equals(originalKey.f4193id) && this.signature.equals(originalKey.signature);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public int hashCode() {
        return this.signature.hashCode() + (this.f4193id.hashCode() * 31);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f4193id.getBytes("UTF-8"));
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
