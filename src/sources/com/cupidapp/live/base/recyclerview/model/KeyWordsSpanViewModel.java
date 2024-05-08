package com.cupidapp.live.base.recyclerview.model;

import android.text.style.ClickableSpan;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKEmptyViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class KeyWordsSpanViewModel {

    @NotNull
    private final List<ClickableSpan> clickableSpan;
    private final int keywordColor;

    @NotNull
    private final List<String> keywords;

    public KeyWordsSpanViewModel(@NotNull List<String> keywords, @NotNull List<ClickableSpan> clickableSpan, int i10) {
        s.i(keywords, "keywords");
        s.i(clickableSpan, "clickableSpan");
        this.keywords = keywords;
        this.clickableSpan = clickableSpan;
        this.keywordColor = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KeyWordsSpanViewModel copy$default(KeyWordsSpanViewModel keyWordsSpanViewModel, List list, List list2, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = keyWordsSpanViewModel.keywords;
        }
        if ((i11 & 2) != 0) {
            list2 = keyWordsSpanViewModel.clickableSpan;
        }
        if ((i11 & 4) != 0) {
            i10 = keyWordsSpanViewModel.keywordColor;
        }
        return keyWordsSpanViewModel.copy(list, list2, i10);
    }

    @NotNull
    public final List<String> component1() {
        return this.keywords;
    }

    @NotNull
    public final List<ClickableSpan> component2() {
        return this.clickableSpan;
    }

    public final int component3() {
        return this.keywordColor;
    }

    @NotNull
    public final KeyWordsSpanViewModel copy(@NotNull List<String> keywords, @NotNull List<ClickableSpan> clickableSpan, int i10) {
        s.i(keywords, "keywords");
        s.i(clickableSpan, "clickableSpan");
        return new KeyWordsSpanViewModel(keywords, clickableSpan, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyWordsSpanViewModel)) {
            return false;
        }
        KeyWordsSpanViewModel keyWordsSpanViewModel = (KeyWordsSpanViewModel) obj;
        return s.d(this.keywords, keyWordsSpanViewModel.keywords) && s.d(this.clickableSpan, keyWordsSpanViewModel.clickableSpan) && this.keywordColor == keyWordsSpanViewModel.keywordColor;
    }

    @NotNull
    public final List<ClickableSpan> getClickableSpan() {
        return this.clickableSpan;
    }

    public final int getKeywordColor() {
        return this.keywordColor;
    }

    @NotNull
    public final List<String> getKeywords() {
        return this.keywords;
    }

    public int hashCode() {
        return (((this.keywords.hashCode() * 31) + this.clickableSpan.hashCode()) * 31) + this.keywordColor;
    }

    @NotNull
    public String toString() {
        List<String> list = this.keywords;
        List<ClickableSpan> list2 = this.clickableSpan;
        return "KeyWordsSpanViewModel(keywords=" + ((Object) list) + ", clickableSpan=" + ((Object) list2) + ", keywordColor=" + this.keywordColor + ")";
    }
}
