package com.cupidapp.live.feed.model;

import android.view.View;
import com.cupidapp.live.feed.FeedSensorType;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedExpressAdModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKExpressAdModel implements IBaseFeedModel {

    @Nullable
    private View view;

    public FKExpressAdModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public FKExpressAdModel(@Nullable View view) {
        this.view = view;
    }

    public static /* synthetic */ FKExpressAdModel copy$default(FKExpressAdModel fKExpressAdModel, View view, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            view = fKExpressAdModel.view;
        }
        return fKExpressAdModel.copy(view);
    }

    @Nullable
    public final View component1() {
        return this.view;
    }

    @NotNull
    public final FKExpressAdModel copy(@Nullable View view) {
        return new FKExpressAdModel(view);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FKExpressAdModel) && s.d(this.view, ((FKExpressAdModel) obj).view);
    }

    @Override // com.cupidapp.live.feed.model.IBaseFeedModel
    @NotNull
    public String getSensorFeedType() {
        return FeedSensorType.ProgramAd.getValue();
    }

    @Nullable
    public final View getView() {
        return this.view;
    }

    public int hashCode() {
        View view = this.view;
        if (view == null) {
            return 0;
        }
        return view.hashCode();
    }

    public final void setView(@Nullable View view) {
        this.view = view;
    }

    @NotNull
    public String toString() {
        return "FKExpressAdModel(view=" + ((Object) this.view) + ")";
    }

    public /* synthetic */ FKExpressAdModel(View view, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : view);
    }
}
