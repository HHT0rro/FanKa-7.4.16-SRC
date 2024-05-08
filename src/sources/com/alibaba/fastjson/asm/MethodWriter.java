package com.alibaba.fastjson.asm;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class MethodWriter implements MethodVisitor {
    private int access;
    private ByteVector code = new ByteVector();
    public final ClassWriter cw;
    private final int desc;
    public int exceptionCount;
    public int[] exceptions;
    private int maxLocals;
    private int maxStack;
    private final int name;
    public MethodWriter next;

    public MethodWriter(ClassWriter classWriter, int i10, String str, String str2, String str3, String[] strArr) {
        if (classWriter.firstMethod == null) {
            classWriter.firstMethod = this;
        } else {
            classWriter.lastMethod.next = this;
        }
        classWriter.lastMethod = this;
        this.cw = classWriter;
        this.access = i10;
        this.name = classWriter.newUTF8(str);
        this.desc = classWriter.newUTF8(str2);
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.exceptionCount = length;
        this.exceptions = new int[length];
        for (int i11 = 0; i11 < this.exceptionCount; i11++) {
            this.exceptions[i11] = classWriter.newClassItem(strArr[i11]).index;
        }
    }

    public final int getSize() {
        int i10;
        if (this.code.length > 0) {
            this.cw.newUTF8("Code");
            i10 = this.code.length + 18 + 0 + 8;
        } else {
            i10 = 8;
        }
        if (this.exceptionCount <= 0) {
            return i10;
        }
        this.cw.newUTF8("Exceptions");
        return i10 + (this.exceptionCount * 2) + 8;
    }

    public final void put(ByteVector byteVector) {
        byteVector.putShort(this.access & (-393217)).putShort(this.name).putShort(this.desc);
        int i10 = this.code.length > 0 ? 1 : 0;
        if (this.exceptionCount > 0) {
            i10++;
        }
        byteVector.putShort(i10);
        int i11 = this.code.length;
        if (i11 > 0) {
            byteVector.putShort(this.cw.newUTF8("Code")).putInt(i11 + 12 + 0);
            byteVector.putShort(this.maxStack).putShort(this.maxLocals);
            ByteVector putInt = byteVector.putInt(this.code.length);
            ByteVector byteVector2 = this.code;
            putInt.putByteArray(byteVector2.data, 0, byteVector2.length);
            byteVector.putShort(0);
            byteVector.putShort(0);
        }
        if (this.exceptionCount > 0) {
            byteVector.putShort(this.cw.newUTF8("Exceptions")).putInt((this.exceptionCount * 2) + 2);
            byteVector.putShort(this.exceptionCount);
            for (int i12 = 0; i12 < this.exceptionCount; i12++) {
                byteVector.putShort(this.exceptions[i12]);
            }
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitEnd() {
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitFieldInsn(int i10, String str, String str2, String str3) {
        this.code.put12(i10, this.cw.newFieldItem(str, str2, str3).index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIincInsn(int i10, int i11) {
        this.code.putByte(132).put11(i10, i11);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitInsn(int i10) {
        this.code.putByte(i10);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIntInsn(int i10, int i11) {
        this.code.put11(i10, i11);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitJumpInsn(int i10, Label label) {
        if ((label.status & 2) != 0 && label.position - this.code.length < -32768) {
            throw new UnsupportedOperationException();
        }
        this.code.putByte(i10);
        label.put(this, this.code, r3.length - 1);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLabel(Label label) {
        ByteVector byteVector = this.code;
        label.resolve(this, byteVector.length, byteVector.data);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLdcInsn(Object obj) {
        Item newConstItem = this.cw.newConstItem(obj);
        int i10 = newConstItem.index;
        int i11 = newConstItem.type;
        if (i11 == 5 || i11 == 6) {
            this.code.put12(20, i10);
        } else if (i10 >= 256) {
            this.code.put12(19, i10);
        } else {
            this.code.put11(18, i10);
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMaxs(int i10, int i11) {
        this.maxStack = i10;
        this.maxLocals = i11;
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMethodInsn(int i10, String str, String str2, String str3) {
        boolean z10 = i10 == 185;
        Item newMethodItem = this.cw.newMethodItem(str, str2, str3, z10);
        int i11 = newMethodItem.intVal;
        if (z10) {
            if (i11 == 0) {
                i11 = Type.getArgumentsAndReturnSizes(str3);
                newMethodItem.intVal = i11;
            }
            this.code.put12(185, newMethodItem.index).put11(i11 >> 2, 0);
            return;
        }
        this.code.put12(i10, newMethodItem.index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitTypeInsn(int i10, String str) {
        this.code.put12(i10, this.cw.newClassItem(str).index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitVarInsn(int i10, int i11) {
        if (i11 < 4 && i10 != 169) {
            this.code.putByte((i10 < 54 ? ((i10 - 21) << 2) + 26 : ((i10 - 54) << 2) + 59) + i11);
        } else if (i11 >= 256) {
            this.code.putByte(196).put12(i10, i11);
        } else {
            this.code.put11(i10, i11);
        }
    }
}
