package com.google.common.hash;

import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Hashing {

    /* renamed from: a, reason: collision with root package name */
    public static final int f26626a = (int) System.currentTimeMillis();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum ChecksumType implements g<Checksum> {
        CRC_32("Hashing.crc32()") { // from class: com.google.common.hash.Hashing.ChecksumType.1
            @Override // com.google.common.hash.Hashing.ChecksumType, com.google.common.base.t
            public Checksum get() {
                return new CRC32();
            }
        },
        ADLER_32("Hashing.adler32()") { // from class: com.google.common.hash.Hashing.ChecksumType.2
            @Override // com.google.common.hash.Hashing.ChecksumType, com.google.common.base.t
            public Checksum get() {
                return new Adler32();
            }
        };

        public final e hashFunction;

        @Override // com.google.common.base.t
        public abstract /* synthetic */ Object get();

        ChecksumType(String str) {
            this.hashFunction = new ChecksumHashFunction(this, 32, str);
        }
    }

    public static e a() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }
}
