package com.alibaba.security.realidentity.oss.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum StorageClass {
    Standard("Standard"),
    IA("IA"),
    Archive("Archive"),
    Unknown("Unknown");

    private String storageClassString;

    StorageClass(String str) {
        this.storageClassString = str;
    }

    public static StorageClass parse(String str) {
        for (StorageClass storageClass : values()) {
            if (storageClass.toString().equals(str)) {
                return storageClass;
            }
        }
        throw new IllegalArgumentException("Unable to parse ".concat(String.valueOf(str)));
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.storageClassString;
    }
}
