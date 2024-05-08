package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.router.h;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.huawei.openalliance.ad.constant.as;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: UserUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class UserUrlJumper implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable final Context context, @NotNull Uri uri, @Nullable String str) {
        List z02;
        kotlin.jvm.internal.s.i(uri, "uri");
        String queryParameter = uri.getQueryParameter(as.f32242q);
        if (queryParameter == null || queryParameter.length() == 0) {
            String path = uri.getPath();
            String A = path != null ? kotlin.text.p.A(path, "/", "", false, 4, null) : null;
            queryParameter = (A == null || (z02 = StringsKt__StringsKt.z0(A, new String[]{"&shareby="}, false, 0, 6, null)) == null) ? null : (String) CollectionsKt___CollectionsKt.V(z02);
        }
        String str2 = queryParameter;
        final SensorPosition b4 = b(uri.getQueryParameter("source"));
        final SensorScene c4 = c(uri.getQueryParameter("scene"));
        if (str2 == null || str2.length() == 0) {
            return;
        }
        Observable z10 = a.C0836a.z(NetworkClient.f11868a.N(), str2, null, null, false, null, 30, null);
        Object applicationContext = AppApplication.f11612d.h().getApplicationContext();
        com.cupidapp.live.base.network.g gVar = applicationContext instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) applicationContext : null;
        Disposable disposed = z10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileResult, kotlin.p>() { // from class: com.cupidapp.live.base.router.jumper.UserUrlJumper$jump$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ProfileResult profileResult) {
                m2471invoke(profileResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2471invoke(ProfileResult profileResult) {
                ProfileResult profileResult2 = profileResult;
                UserProfileActivity.G.a(context, profileResult2.getUser(), new ProfileSensorContext(ViewProfilePrefer.URLSchemeToProfile.getValue(), null, profileResult2.getUser().getMe(), SensorPosition.this, SensorPosition.Unknown, c4), (r21 & 8) != 0 ? false : false, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @NotNull
    public SensorPosition b(@Nullable String str) {
        return h.a.a(this, str);
    }

    @Nullable
    public SensorScene c(@Nullable String str) {
        return h.a.b(this, str);
    }
}
