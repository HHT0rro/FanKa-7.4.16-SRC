package com.bytedance.sdk.openadsdk;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface FilterWord {
    void addOption(FilterWord filterWord);

    String getId();

    boolean getIsSelected();

    String getName();

    List<FilterWord> getOptions();

    boolean hasSecondOptions();

    boolean isValid();

    void setIsSelected(boolean z10);
}
