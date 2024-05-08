package com.alimm.tanx.ui.image.glide.manager;

import com.alimm.tanx.ui.image.glide.RequestManager;
import java.util.Collections;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class EmptyRequestManagerTreeNode implements RequestManagerTreeNode {
    @Override // com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode
    public Set<RequestManager> getDescendants() {
        return Collections.emptySet();
    }
}
