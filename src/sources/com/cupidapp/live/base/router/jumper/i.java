package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.profile.activity.RelationUserListActivity;
import com.huawei.quickcard.base.Attributes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContactUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null) {
            return;
        }
        String path = uri.getPath();
        if (kotlin.jvm.internal.s.d(path != null ? kotlin.text.p.A(path, "/", "", false, 4, null) : null, Attributes.Style.ACTIVE)) {
            MainActivity.F.d(context, RelationUserListActivity.f17672s.a(context));
        }
    }
}
