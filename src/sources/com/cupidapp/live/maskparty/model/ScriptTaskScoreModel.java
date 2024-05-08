package com.cupidapp.live.maskparty.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyScriptModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ScriptTaskScoreModel extends MaskPartyChatConnectorMessageModel {
    private final boolean myself;

    /* renamed from: public, reason: not valid java name */
    private boolean f202public;
    private final int score;

    @NotNull
    private final List<MaskPartyScriptTaskItemModel> task;

    public /* synthetic */ ScriptTaskScoreModel(String str, boolean z10, int i10, List list, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z10, i10, list, (i11 & 16) != 0 ? false : z11);
    }

    public final boolean getMyself() {
        return this.myself;
    }

    public final boolean getPublic() {
        return this.f202public;
    }

    public final int getScore() {
        return this.score;
    }

    @NotNull
    public final List<MaskPartyScriptTaskItemModel> getTask() {
        return this.task;
    }

    public final void setPublic(boolean z10) {
        this.f202public = z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptTaskScoreModel(@Nullable String str, boolean z10, int i10, @NotNull List<MaskPartyScriptTaskItemModel> task, boolean z11) {
        super(str);
        s.i(task, "task");
        this.myself = z10;
        this.score = i10;
        this.task = task;
        this.f202public = z11;
    }
}
