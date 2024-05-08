package org.apache.commons.collections4.sequence;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface CommandVisitor<T> {
    void visitDeleteCommand(T t2);

    void visitInsertCommand(T t2);

    void visitKeepCommand(T t2);
}
