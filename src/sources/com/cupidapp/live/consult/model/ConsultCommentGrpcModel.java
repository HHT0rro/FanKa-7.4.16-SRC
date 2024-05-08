package com.cupidapp.live.consult.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultCommentGrpcModel extends BaseConsultLiveGrpcModel {

    @Nullable
    private final ConsultCommentModel comment;

    public ConsultCommentGrpcModel(@Nullable String str, @Nullable ConsultCommentModel consultCommentModel) {
        super(str);
        this.comment = consultCommentModel;
    }

    @Nullable
    public final ConsultCommentModel getComment() {
        return this.comment;
    }
}
