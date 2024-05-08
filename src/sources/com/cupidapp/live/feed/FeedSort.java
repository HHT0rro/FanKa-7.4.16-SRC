package com.cupidapp.live.feed;

import androidx.annotation.StringRes;
import com.cupidapp.live.R$string;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedType.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum FeedSort {
    Time("Time", R$string.up_to_date),
    Intimacy("Intimacy", R$string.concern),
    CloseFriend("CloseFriend", R$string.close_friend),
    Focus("UserFocus", R$string.focus);


    @NotNull
    private final String value;
    private final int valueRes;

    FeedSort(String str, @StringRes int i10) {
        this.value = str;
        this.valueRes = i10;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public final int getValueRes() {
        return this.valueRes;
    }
}
