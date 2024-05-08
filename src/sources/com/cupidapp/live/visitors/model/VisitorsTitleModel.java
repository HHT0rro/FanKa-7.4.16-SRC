package com.cupidapp.live.visitors.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorsTitleModel {

    @NotNull
    private final String title;

    public VisitorsTitleModel(@NotNull String title) {
        s.i(title, "title");
        this.title = title;
    }

    public static /* synthetic */ VisitorsTitleModel copy$default(VisitorsTitleModel visitorsTitleModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = visitorsTitleModel.title;
        }
        return visitorsTitleModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final VisitorsTitleModel copy(@NotNull String title) {
        s.i(title, "title");
        return new VisitorsTitleModel(title);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VisitorsTitleModel) && s.d(this.title, ((VisitorsTitleModel) obj).title);
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.title.hashCode();
    }

    @NotNull
    public String toString() {
        return "VisitorsTitleModel(title=" + this.title + ")";
    }
}
