package com.alibaba.fastjson.asm;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class FieldWriter {
    private final int access;
    private final int desc;
    private final int name;
    public FieldWriter next;

    public FieldWriter(ClassWriter classWriter, int i10, String str, String str2) {
        if (classWriter.firstField == null) {
            classWriter.firstField = this;
        } else {
            classWriter.lastField.next = this;
        }
        classWriter.lastField = this;
        this.access = i10;
        this.name = classWriter.newUTF8(str);
        this.desc = classWriter.newUTF8(str2);
    }

    public int getSize() {
        return 8;
    }

    public void put(ByteVector byteVector) {
        byteVector.putShort(this.access & (-393217)).putShort(this.name).putShort(this.desc);
        byteVector.putShort(0);
    }

    public void visitEnd() {
    }
}
