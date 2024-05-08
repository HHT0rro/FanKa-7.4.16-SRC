package com.cupidapp.live.setting.activity;

import android.view.View;
import com.cupidapp.live.setting.model.LimitRangeType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitSettingActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LimitRangeModel {

    @Nullable
    private final String content;

    @Nullable
    private View itemView;

    @NotNull
    private final String title;

    @NotNull
    private final LimitRangeType type;

    public LimitRangeModel(@NotNull LimitRangeType type, @NotNull String title, @Nullable String str, @Nullable View view) {
        kotlin.jvm.internal.s.i(type, "type");
        kotlin.jvm.internal.s.i(title, "title");
        this.type = type;
        this.title = title;
        this.content = str;
        this.itemView = view;
    }

    public static /* synthetic */ LimitRangeModel copy$default(LimitRangeModel limitRangeModel, LimitRangeType limitRangeType, String str, String str2, View view, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            limitRangeType = limitRangeModel.type;
        }
        if ((i10 & 2) != 0) {
            str = limitRangeModel.title;
        }
        if ((i10 & 4) != 0) {
            str2 = limitRangeModel.content;
        }
        if ((i10 & 8) != 0) {
            view = limitRangeModel.itemView;
        }
        return limitRangeModel.copy(limitRangeType, str, str2, view);
    }

    @NotNull
    public final LimitRangeType component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.content;
    }

    @Nullable
    public final View component4() {
        return this.itemView;
    }

    @NotNull
    public final LimitRangeModel copy(@NotNull LimitRangeType type, @NotNull String title, @Nullable String str, @Nullable View view) {
        kotlin.jvm.internal.s.i(type, "type");
        kotlin.jvm.internal.s.i(title, "title");
        return new LimitRangeModel(type, title, str, view);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LimitRangeModel)) {
            return false;
        }
        LimitRangeModel limitRangeModel = (LimitRangeModel) obj;
        return this.type == limitRangeModel.type && kotlin.jvm.internal.s.d(this.title, limitRangeModel.title) && kotlin.jvm.internal.s.d(this.content, limitRangeModel.content) && kotlin.jvm.internal.s.d(this.itemView, limitRangeModel.itemView);
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final View getItemView() {
        return this.itemView;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final LimitRangeType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((this.type.hashCode() * 31) + this.title.hashCode()) * 31;
        String str = this.content;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        View view = this.itemView;
        return hashCode2 + (view != null ? view.hashCode() : 0);
    }

    public final void setItemView(@Nullable View view) {
        this.itemView = view;
    }

    @NotNull
    public String toString() {
        LimitRangeType limitRangeType = this.type;
        return "LimitRangeModel(type=" + ((Object) limitRangeType) + ", title=" + this.title + ", content=" + this.content + ", itemView=" + ((Object) this.itemView) + ")";
    }

    public /* synthetic */ LimitRangeModel(LimitRangeType limitRangeType, String str, String str2, View view, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(limitRangeType, str, str2, (i10 & 8) != 0 ? null : view);
    }
}
