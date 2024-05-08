package org.apache.commons.collections4.sequence;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class EditCommand<T> {
    private final T object;

    public EditCommand(T t2) {
        this.object = t2;
    }

    public abstract void accept(CommandVisitor<T> commandVisitor);

    public T getObject() {
        return this.object;
    }
}
