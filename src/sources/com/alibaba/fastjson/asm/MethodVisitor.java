package com.alibaba.fastjson.asm;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface MethodVisitor {
    void visitEnd();

    void visitFieldInsn(int i10, String str, String str2, String str3);

    void visitIincInsn(int i10, int i11);

    void visitInsn(int i10);

    void visitIntInsn(int i10, int i11);

    void visitJumpInsn(int i10, Label label);

    void visitLabel(Label label);

    void visitLdcInsn(Object obj);

    void visitMaxs(int i10, int i11);

    void visitMethodInsn(int i10, String str, String str2, String str3);

    void visitTypeInsn(int i10, String str);

    void visitVarInsn(int i10, int i11);
}
