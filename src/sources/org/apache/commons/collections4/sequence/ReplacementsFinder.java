package org.apache.commons.collections4.sequence;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ReplacementsFinder<T> implements CommandVisitor<T> {
    private final ReplacementsHandler<T> handler;
    private final List<T> pendingInsertions = new ArrayList();
    private final List<T> pendingDeletions = new ArrayList();
    private int skipped = 0;

    public ReplacementsFinder(ReplacementsHandler<T> replacementsHandler) {
        this.handler = replacementsHandler;
    }

    @Override // org.apache.commons.collections4.sequence.CommandVisitor
    public void visitDeleteCommand(T t2) {
        this.pendingDeletions.add(t2);
    }

    @Override // org.apache.commons.collections4.sequence.CommandVisitor
    public void visitInsertCommand(T t2) {
        this.pendingInsertions.add(t2);
    }

    @Override // org.apache.commons.collections4.sequence.CommandVisitor
    public void visitKeepCommand(T t2) {
        if (this.pendingDeletions.isEmpty() && this.pendingInsertions.isEmpty()) {
            this.skipped++;
            return;
        }
        this.handler.handleReplacement(this.skipped, this.pendingDeletions, this.pendingInsertions);
        this.pendingDeletions.clear();
        this.pendingInsertions.clear();
        this.skipped = 1;
    }
}
