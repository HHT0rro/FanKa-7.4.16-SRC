package com.cupidapp.live.chat.viewholder;

import com.cupidapp.live.chat.service.NewUserGuideItemModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewUserGuideViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NewUserGuideModel {

    @NotNull
    private final List<NewUserGuideItemModel> guideList;

    public NewUserGuideModel(@NotNull List<NewUserGuideItemModel> guideList) {
        s.i(guideList, "guideList");
        this.guideList = guideList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NewUserGuideModel copy$default(NewUserGuideModel newUserGuideModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = newUserGuideModel.guideList;
        }
        return newUserGuideModel.copy(list);
    }

    @NotNull
    public final List<NewUserGuideItemModel> component1() {
        return this.guideList;
    }

    @NotNull
    public final NewUserGuideModel copy(@NotNull List<NewUserGuideItemModel> guideList) {
        s.i(guideList, "guideList");
        return new NewUserGuideModel(guideList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NewUserGuideModel) && s.d(this.guideList, ((NewUserGuideModel) obj).guideList);
    }

    @NotNull
    public final List<NewUserGuideItemModel> getGuideList() {
        return this.guideList;
    }

    public int hashCode() {
        return this.guideList.hashCode();
    }

    @NotNull
    public String toString() {
        return "NewUserGuideModel(guideList=" + ((Object) this.guideList) + ")";
    }
}
