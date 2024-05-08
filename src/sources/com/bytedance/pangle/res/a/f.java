package com.bytedance.pangle.res.a;

import java.io.DataInput;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class f implements DataInput {

    /* renamed from: a, reason: collision with root package name */
    public final i f10932a;

    public f(i iVar) {
        this.f10932a = iVar;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return this.f10932a.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return this.f10932a.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return this.f10932a.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return this.f10932a.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return this.f10932a.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i10, int i11) {
        this.f10932a.readFully(bArr, i10, i11);
    }

    @Override // java.io.DataInput
    public int readInt() {
        return this.f10932a.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() {
        return this.f10932a.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() {
        return this.f10932a.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() {
        return this.f10932a.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return this.f10932a.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return this.f10932a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return this.f10932a.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i10) {
        return this.f10932a.skipBytes(i10);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) {
        this.f10932a.readFully(bArr);
    }
}
