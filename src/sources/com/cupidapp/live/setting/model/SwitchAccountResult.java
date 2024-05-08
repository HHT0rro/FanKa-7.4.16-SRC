package com.cupidapp.live.setting.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SwitchAccountModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SwitchAccountResult implements Serializable {

    @Nullable
    private final List<SwitchAccountUserModel> accountList;

    @Nullable
    private final Integer otherUnReadCount;

    public SwitchAccountResult(@Nullable List<SwitchAccountUserModel> list, @Nullable Integer num) {
        this.accountList = list;
        this.otherUnReadCount = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SwitchAccountResult copy$default(SwitchAccountResult switchAccountResult, List list, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = switchAccountResult.accountList;
        }
        if ((i10 & 2) != 0) {
            num = switchAccountResult.otherUnReadCount;
        }
        return switchAccountResult.copy(list, num);
    }

    @Nullable
    public final List<SwitchAccountUserModel> component1() {
        return this.accountList;
    }

    @Nullable
    public final Integer component2() {
        return this.otherUnReadCount;
    }

    @NotNull
    public final SwitchAccountResult copy(@Nullable List<SwitchAccountUserModel> list, @Nullable Integer num) {
        return new SwitchAccountResult(list, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwitchAccountResult)) {
            return false;
        }
        SwitchAccountResult switchAccountResult = (SwitchAccountResult) obj;
        return s.d(this.accountList, switchAccountResult.accountList) && s.d(this.otherUnReadCount, switchAccountResult.otherUnReadCount);
    }

    @Nullable
    public final List<SwitchAccountUserModel> getAccountList() {
        return this.accountList;
    }

    @Nullable
    public final Integer getOtherUnReadCount() {
        return this.otherUnReadCount;
    }

    public int hashCode() {
        List<SwitchAccountUserModel> list = this.accountList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.otherUnReadCount;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SwitchAccountResult(accountList=" + ((Object) this.accountList) + ", otherUnReadCount=" + ((Object) this.otherUnReadCount) + ")";
    }
}
