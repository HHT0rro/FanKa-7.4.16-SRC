package com.kwad.sdk.crash.online.monitor.block.a;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends c {
    private static String ayT = "CREATE TABLE IF NOT EXISTS ksad_block_actions (actionId varchar(60) primary key, aLog TEXT)";

    public a(@Nullable Context context, int i10) {
        super(context, "ksadBlock.db", i10, ayT);
    }
}
