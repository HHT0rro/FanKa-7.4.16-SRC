package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.notify.activity.NotifyActivity;
import com.cupidapp.live.notify.fragment.NotifyPageType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotifyJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e0 implements com.cupidapp.live.base.router.h {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f12164b = new a(null);

    /* compiled from: NotifyJumper.kt */
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
        if (context == null) {
            return;
        }
        String path = uri.getPath();
        NotifyPageType notifyPageType = null;
        String A = path != null ? kotlin.text.p.A(path, "/", "", false, 4, null) : null;
        if (A != null) {
            switch (A.hashCode()) {
                case -1268958287:
                    if (A.equals("follow")) {
                        notifyPageType = NotifyPageType.Follow;
                        break;
                    }
                    break;
                case -1023304982:
                    if (A.equals("aiPhoto")) {
                        notifyPageType = NotifyPageType.AiIdentify;
                        break;
                    }
                    break;
                case -980226692:
                    if (A.equals("praise")) {
                        notifyPageType = NotifyPageType.Praise;
                        break;
                    }
                    break;
                case 1505429933:
                    if (A.equals("dailyHeart")) {
                        notifyPageType = NotifyPageType.DailyHeart;
                        break;
                    }
                    break;
                case 2124767295:
                    if (A.equals("dynamic")) {
                        notifyPageType = NotifyPageType.Dynamic;
                        break;
                    }
                    break;
            }
        }
        NotifyPageType notifyPageType2 = notifyPageType;
        if (notifyPageType2 != null) {
            NotifyActivity.a.b(NotifyActivity.f17492s, context, notifyPageType2, false, 4, null);
        }
    }
}
