package com.android.internal.org.bouncycastle.crypto.digests;

import com.android.internal.org.bouncycastle.crypto.Digest;
import com.android.internal.org.bouncycastle.crypto.digests.OpenSSLDigest;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AndroidDigestFactoryOpenSSL implements AndroidDigestFactoryInterface {
    @Override // com.android.internal.org.bouncycastle.crypto.digests.AndroidDigestFactoryInterface
    public Digest getMD5() {
        return new OpenSSLDigest.MD5();
    }

    @Override // com.android.internal.org.bouncycastle.crypto.digests.AndroidDigestFactoryInterface
    public Digest getSHA1() {
        return new OpenSSLDigest.SHA1();
    }

    @Override // com.android.internal.org.bouncycastle.crypto.digests.AndroidDigestFactoryInterface
    public Digest getSHA224() {
        return new OpenSSLDigest.SHA224();
    }

    @Override // com.android.internal.org.bouncycastle.crypto.digests.AndroidDigestFactoryInterface
    public Digest getSHA256() {
        return new OpenSSLDigest.SHA256();
    }

    @Override // com.android.internal.org.bouncycastle.crypto.digests.AndroidDigestFactoryInterface
    public Digest getSHA384() {
        return new OpenSSLDigest.SHA384();
    }

    @Override // com.android.internal.org.bouncycastle.crypto.digests.AndroidDigestFactoryInterface
    public Digest getSHA512() {
        return new OpenSSLDigest.SHA512();
    }
}
