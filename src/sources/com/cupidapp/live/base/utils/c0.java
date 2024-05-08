package com.cupidapp.live.base.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LayoutManagerUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c0 {
    @Nullable
    public static final Pair<Integer, Integer> a(@NotNull LinearLayoutManager linearLayoutManager) {
        kotlin.jvm.internal.s.i(linearLayoutManager, "<this>");
        int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        if (findFirstCompletelyVisibleItemPosition == -1 || findLastCompletelyVisibleItemPosition == -1) {
            return null;
        }
        return new Pair<>(Integer.valueOf(findFirstCompletelyVisibleItemPosition), Integer.valueOf(findLastCompletelyVisibleItemPosition));
    }

    @Nullable
    public static final Pair<Integer, Integer> b(@NotNull LinearLayoutManager linearLayoutManager) {
        kotlin.jvm.internal.s.i(linearLayoutManager, "<this>");
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition == -1 || findLastVisibleItemPosition == -1) {
            return null;
        }
        return new Pair<>(Integer.valueOf(findFirstVisibleItemPosition), Integer.valueOf(findLastVisibleItemPosition));
    }
}
