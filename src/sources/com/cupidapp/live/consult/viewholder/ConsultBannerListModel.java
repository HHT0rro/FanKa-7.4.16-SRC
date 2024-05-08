package com.cupidapp.live.consult.viewholder;

import com.cupidapp.live.consult.model.ConsultBannerModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultBannerViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultBannerListModel {

    @Nullable
    private final List<ConsultBannerModel> banners;

    public ConsultBannerListModel(@Nullable List<ConsultBannerModel> list) {
        this.banners = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsultBannerListModel copy$default(ConsultBannerListModel consultBannerListModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = consultBannerListModel.banners;
        }
        return consultBannerListModel.copy(list);
    }

    @Nullable
    public final List<ConsultBannerModel> component1() {
        return this.banners;
    }

    @NotNull
    public final ConsultBannerListModel copy(@Nullable List<ConsultBannerModel> list) {
        return new ConsultBannerListModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConsultBannerListModel) && s.d(this.banners, ((ConsultBannerListModel) obj).banners);
    }

    @Nullable
    public final List<ConsultBannerModel> getBanners() {
        return this.banners;
    }

    public int hashCode() {
        List<ConsultBannerModel> list = this.banners;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConsultBannerListModel(banners=" + ((Object) this.banners) + ")";
    }
}
