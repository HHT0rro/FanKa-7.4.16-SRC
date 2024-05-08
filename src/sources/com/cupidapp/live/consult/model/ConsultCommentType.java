package com.cupidapp.live.consult.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ConsultCommentType {
    COMMENT(FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT),
    NOTICE("notice");


    @NotNull
    private final String value;

    ConsultCommentType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
