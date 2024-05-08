package com.cupidapp.live.visitors.viewholder;

import com.cupidapp.live.visitors.model.VisitorMarketingInfoModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorMarksViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorMarketingUIModel {

    @Nullable
    private final List<VisitorMarketingInfoModel> list;

    public VisitorMarketingUIModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public VisitorMarketingUIModel(@Nullable List<VisitorMarketingInfoModel> list) {
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VisitorMarketingUIModel copy$default(VisitorMarketingUIModel visitorMarketingUIModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = visitorMarketingUIModel.list;
        }
        return visitorMarketingUIModel.copy(list);
    }

    @Nullable
    public final List<VisitorMarketingInfoModel> component1() {
        return this.list;
    }

    @NotNull
    public final VisitorMarketingUIModel copy(@Nullable List<VisitorMarketingInfoModel> list) {
        return new VisitorMarketingUIModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VisitorMarketingUIModel) && s.d(this.list, ((VisitorMarketingUIModel) obj).list);
    }

    @Nullable
    public final List<VisitorMarketingInfoModel> getList() {
        return this.list;
    }

    public int hashCode() {
        List<VisitorMarketingInfoModel> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "VisitorMarketingUIModel(list=" + ((Object) this.list) + ")";
    }

    public /* synthetic */ VisitorMarketingUIModel(List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : list);
    }
}
