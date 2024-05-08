package com.cupidapp.live.filter.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterTopTabModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FilterTopTabUiBaseModel {

    @Nullable
    private String content;
    private boolean isOpened;

    @NotNull
    private final String key;
    private final boolean limitTimeReward;

    @NotNull
    private final String name;
    private final int productType;

    @NotNull
    private TabLayoutStyle style;

    public FilterTopTabUiBaseModel(@Nullable String str, @NotNull String name, @NotNull String key, int i10, @NotNull TabLayoutStyle style, boolean z10, boolean z11) {
        s.i(name, "name");
        s.i(key, "key");
        s.i(style, "style");
        this.content = str;
        this.name = name;
        this.key = key;
        this.productType = i10;
        this.style = style;
        this.isOpened = z10;
        this.limitTimeReward = z11;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public final boolean getLimitTimeReward() {
        return this.limitTimeReward;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getProductType() {
        return this.productType;
    }

    @NotNull
    public final TabLayoutStyle getStyle() {
        return this.style;
    }

    public final boolean isOpened() {
        return this.isOpened;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setOpened(boolean z10) {
        this.isOpened = z10;
    }

    public final void setStyle(@NotNull TabLayoutStyle tabLayoutStyle) {
        s.i(tabLayoutStyle, "<set-?>");
        this.style = tabLayoutStyle;
    }
}
