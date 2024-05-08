package com.kwad.sdk.core.imageloader.cache.disc.naming;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HashCodeFileNameGenerator implements FileNameGenerator {
    @Override // com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator
    public String generate(String str) {
        return String.valueOf(str.hashCode());
    }
}
