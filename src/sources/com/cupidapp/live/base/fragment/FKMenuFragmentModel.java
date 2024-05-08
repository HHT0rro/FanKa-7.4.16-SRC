package com.cupidapp.live.base.fragment;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKMenuFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKMenuFragmentModel implements Serializable {
    private final boolean isShowBackButton;

    @Nullable
    private final ArrayList<FKMenuFragmentItemModel> list;

    @Nullable
    private final String title;

    public FKMenuFragmentModel() {
        this(null, null, false, 7, null);
    }

    public FKMenuFragmentModel(@Nullable String str, @Nullable ArrayList<FKMenuFragmentItemModel> arrayList, boolean z10) {
        this.title = str;
        this.list = arrayList;
        this.isShowBackButton = z10;
    }

    @Nullable
    public final ArrayList<FKMenuFragmentItemModel> getList() {
        return this.list;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final boolean isShowBackButton() {
        return this.isShowBackButton;
    }

    public /* synthetic */ FKMenuFragmentModel(String str, ArrayList arrayList, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : arrayList, (i10 & 4) != 0 ? true : z10);
    }
}
