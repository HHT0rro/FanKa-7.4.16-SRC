package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.consult.activity.ConsultAnchorActivity;
import com.cupidapp.live.consult.activity.ConsultStartLiveActivity;
import com.cupidapp.live.consult.model.ConsultLiveHangOverResult;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PreviewVoiceRoomJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PreviewVoiceRoomJumper implements com.cupidapp.live.base.router.h {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable final Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        Observable<Result<ConsultLiveHangOverResult>> m10 = NetworkClient.f11868a.v().m();
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = m10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ConsultLiveHangOverResult, kotlin.p>() { // from class: com.cupidapp.live.base.router.jumper.PreviewVoiceRoomJumper$jump$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ConsultLiveHangOverResult consultLiveHangOverResult) {
                m2470invoke(consultLiveHangOverResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2470invoke(ConsultLiveHangOverResult consultLiveHangOverResult) {
                ConsultLiveHangOverResult consultLiveHangOverResult2 = consultLiveHangOverResult;
                if (consultLiveHangOverResult2.getSuspend() && consultLiveHangOverResult2.getInfo() != null) {
                    ConsultAnchorActivity.f13716v.a(context, consultLiveHangOverResult2.getInfo(), true);
                } else {
                    ConsultStartLiveActivity.f13722v.a(context);
                }
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
}
