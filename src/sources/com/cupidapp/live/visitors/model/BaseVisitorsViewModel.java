package com.cupidapp.live.visitors.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: VisitorsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BaseVisitorsViewModel {
    private final boolean visitorEnable;

    @NotNull
    private final VisitorModel visitorModel;

    public BaseVisitorsViewModel(@NotNull VisitorModel visitorModel, boolean z10) {
        s.i(visitorModel, "visitorModel");
        this.visitorModel = visitorModel;
        this.visitorEnable = z10;
    }

    public final boolean getVisitorEnable() {
        return this.visitorEnable;
    }

    @NotNull
    public final VisitorModel getVisitorModel() {
        return this.visitorModel;
    }
}
