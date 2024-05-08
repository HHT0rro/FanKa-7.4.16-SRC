package com.cupidapp.live.vip.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipPurchaseTabModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class PurchaseTabModel {

    @NotNull
    private String content;

    @NotNull
    private List<Integer> contentSelector;

    @Nullable
    private List<Integer> indicatorColor;
    private boolean indicatorSelectShow;
    private float paddingEnd;
    private float paddingStart;
    private boolean select;
    private float textSize;

    @NotNull
    private String title;

    @NotNull
    private List<Integer> titleSelectColor;
    private int unSelectColor;

    public PurchaseTabModel(@NotNull String title, @NotNull String content, float f10, @NotNull List<Integer> titleSelectColor, @NotNull List<Integer> contentSelector, int i10, boolean z10, boolean z11, @Nullable List<Integer> list, float f11, float f12) {
        s.i(title, "title");
        s.i(content, "content");
        s.i(titleSelectColor, "titleSelectColor");
        s.i(contentSelector, "contentSelector");
        this.title = title;
        this.content = content;
        this.textSize = f10;
        this.titleSelectColor = titleSelectColor;
        this.contentSelector = contentSelector;
        this.unSelectColor = i10;
        this.select = z10;
        this.indicatorSelectShow = z11;
        this.indicatorColor = list;
        this.paddingStart = f11;
        this.paddingEnd = f12;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final List<Integer> getContentSelector() {
        return this.contentSelector;
    }

    @Nullable
    public final List<Integer> getIndicatorColor() {
        return this.indicatorColor;
    }

    public final boolean getIndicatorSelectShow() {
        return this.indicatorSelectShow;
    }

    public final float getPaddingEnd() {
        return this.paddingEnd;
    }

    public final float getPaddingStart() {
        return this.paddingStart;
    }

    public final boolean getSelect() {
        return this.select;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final List<Integer> getTitleSelectColor() {
        return this.titleSelectColor;
    }

    public final int getUnSelectColor() {
        return this.unSelectColor;
    }

    public final void setContent(@NotNull String str) {
        s.i(str, "<set-?>");
        this.content = str;
    }

    public final void setContentSelector(@NotNull List<Integer> list) {
        s.i(list, "<set-?>");
        this.contentSelector = list;
    }

    public final void setIndicatorColor(@Nullable List<Integer> list) {
        this.indicatorColor = list;
    }

    public final void setIndicatorSelectShow(boolean z10) {
        this.indicatorSelectShow = z10;
    }

    public final void setPaddingEnd(float f10) {
        this.paddingEnd = f10;
    }

    public final void setPaddingStart(float f10) {
        this.paddingStart = f10;
    }

    public final void setSelect(boolean z10) {
        this.select = z10;
    }

    public final void setTextSize(float f10) {
        this.textSize = f10;
    }

    public final void setTitle(@NotNull String str) {
        s.i(str, "<set-?>");
        this.title = str;
    }

    public final void setTitleSelectColor(@NotNull List<Integer> list) {
        s.i(list, "<set-?>");
        this.titleSelectColor = list;
    }

    public final void setUnSelectColor(int i10) {
        this.unSelectColor = i10;
    }

    public /* synthetic */ PurchaseTabModel(String str, String str2, float f10, List list, List list2, int i10, boolean z10, boolean z11, List list3, float f11, float f12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, f10, list, (i11 & 16) != 0 ? list : list2, (i11 & 32) != 0 ? 0 : i10, (i11 & 64) != 0 ? false : z10, (i11 & 128) != 0 ? false : z11, (i11 & 256) != 0 ? null : list3, (i11 & 512) != 0 ? 14.0f : f11, (i11 & 1024) != 0 ? 14.0f : f12);
    }
}
