package com.cupidapp.live.base.router.jumper;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.base.web.activity.FKTransparentWebActivity;
import com.cupidapp.live.setting.activity.EditUserInfoActivity;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EditProfileJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class m implements com.cupidapp.live.base.router.h {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f12165b = new a(null);

    /* compiled from: EditProfileJumper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        String queryParameter = uri.getQueryParameter("scene");
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("scrollToBottom", false);
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if ((activity instanceof FKTransparentWebActivity) && kotlin.jvm.internal.s.d(queryParameter, "NewUserActivity")) {
            ((FKTransparentWebActivity) activity).finish();
        }
        EditUserInfoActivity.f17947y.a(context, queryParameter, booleanQueryParameter);
    }
}
