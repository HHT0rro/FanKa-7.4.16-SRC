package com.irisdt.db;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Entity {
    private byte[] blob;

    /* renamed from: id, reason: collision with root package name */
    private long f35692id;

    public Entity() {
    }

    public byte[] getBlob() {
        return this.blob;
    }

    public long getId() {
        return this.f35692id;
    }

    public void setBlob(byte[] bArr) {
        this.blob = bArr;
    }

    public void setId(long j10) {
        this.f35692id = j10;
    }

    public Entity(byte[] bArr) {
        this.blob = bArr;
    }
}
