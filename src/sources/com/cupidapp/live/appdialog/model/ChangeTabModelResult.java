package com.cupidapp.live.appdialog.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChangeTabModelResult {

    @NotNull
    private final String tab;

    @Nullable
    private final List<AppDialogModel> windows;

    /* JADX WARN: Multi-variable type inference failed */
    public ChangeTabModelResult(@Nullable List<? extends AppDialogModel> list, @NotNull String tab) {
        s.i(tab, "tab");
        this.windows = list;
        this.tab = tab;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChangeTabModelResult copy$default(ChangeTabModelResult changeTabModelResult, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = changeTabModelResult.windows;
        }
        if ((i10 & 2) != 0) {
            str = changeTabModelResult.tab;
        }
        return changeTabModelResult.copy(list, str);
    }

    @Nullable
    public final List<AppDialogModel> component1() {
        return this.windows;
    }

    @NotNull
    public final String component2() {
        return this.tab;
    }

    @NotNull
    public final ChangeTabModelResult copy(@Nullable List<? extends AppDialogModel> list, @NotNull String tab) {
        s.i(tab, "tab");
        return new ChangeTabModelResult(list, tab);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangeTabModelResult)) {
            return false;
        }
        ChangeTabModelResult changeTabModelResult = (ChangeTabModelResult) obj;
        return s.d(this.windows, changeTabModelResult.windows) && s.d(this.tab, changeTabModelResult.tab);
    }

    @NotNull
    public final String getTab() {
        return this.tab;
    }

    @Nullable
    public final List<AppDialogModel> getWindows() {
        return this.windows;
    }

    public int hashCode() {
        List<AppDialogModel> list = this.windows;
        return ((list == null ? 0 : list.hashCode()) * 31) + this.tab.hashCode();
    }

    @NotNull
    public String toString() {
        List<AppDialogModel> list = this.windows;
        return "ChangeTabModelResult(windows=" + ((Object) list) + ", tab=" + this.tab + ")";
    }
}
