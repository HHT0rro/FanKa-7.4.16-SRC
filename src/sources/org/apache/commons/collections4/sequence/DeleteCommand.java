package org.apache.commons.collections4.sequence;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class DeleteCommand<T> extends EditCommand<T> {
    public DeleteCommand(T t2) {
        super(t2);
    }

    @Override // org.apache.commons.collections4.sequence.EditCommand
    public void accept(CommandVisitor<T> commandVisitor) {
        commandVisitor.visitDeleteCommand(getObject());
    }
}
