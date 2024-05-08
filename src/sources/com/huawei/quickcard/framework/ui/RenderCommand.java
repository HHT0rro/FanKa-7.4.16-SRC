package com.huawei.quickcard.framework.ui;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface RenderCommand {
    String attrName();

    void doRender();

    boolean immediately();

    boolean isPseudoClass();

    boolean needRefresh();

    void setPseudoClass(boolean z10);
}
