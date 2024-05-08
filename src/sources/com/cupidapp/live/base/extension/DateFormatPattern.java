package com.cupidapp.live.base.extension;

import com.alimm.tanx.core.web.cache.utils.TimeUtils;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: TimeExtension.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum DateFormatPattern {
    YYYYMD("yyyy年M月d日"),
    YYYYMMDD("yyyy年MM月dd日"),
    YyyyMMdd("yyyy-MM-dd"),
    YyyyMMddHHmmss(TimeUtils.STARD_FROMAT),
    MD("M月d日"),
    Hmm("H:mm"),
    HHmm("HH:mm");


    @NotNull
    private final String pattern;

    DateFormatPattern(String str) {
        this.pattern = str;
    }

    @NotNull
    public final String getPattern() {
        return this.pattern;
    }
}
