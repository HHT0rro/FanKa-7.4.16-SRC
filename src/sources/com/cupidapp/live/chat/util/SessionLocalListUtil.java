package com.cupidapp.live.chat.util;

import android.content.Context;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.chat.event.UpdateSessionListEvent;
import com.cupidapp.live.chat.model.InboxSessionModel;
import com.cupidapp.live.chat.model.InboxSessionType;
import com.cupidapp.live.chat.model.RefreshSessionLiveStatusEvent;
import com.cupidapp.live.chat.model.RefreshSessionLiveStatusGrpcModel;
import com.cupidapp.live.chat.service.InboxSessionResult;
import com.cupidapp.live.chat.service.VisitorInfoModel;
import com.cupidapp.live.profile.model.User;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SessionLocalListUtil.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SessionLocalListUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SessionLocalListUtil f13179a = new SessionLocalListUtil();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final List<InboxSessionModel> f13180b = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(@Nullable Context context, @NotNull String groupId) {
        s.i(groupId, "groupId");
        Observable<Result<InboxSessionResult>> p10 = NetworkClient.f11868a.u().p(groupId);
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = p10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<InboxSessionResult, p>() { // from class: com.cupidapp.live.chat.util.SessionLocalListUtil$getNewClubSession$$inlined$handleByContext$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(InboxSessionResult inboxSessionResult) {
                m2483invoke(inboxSessionResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2483invoke(InboxSessionResult inboxSessionResult) {
                InboxSessionModel inboxSessionModel;
                InboxSessionResult inboxSessionResult2 = inboxSessionResult;
                p1.g.f52734a.X1(inboxSessionResult2.getMessageCount());
                List<InboxSessionModel> list = inboxSessionResult2.getList();
                if (list == null || (inboxSessionModel = (InboxSessionModel) CollectionsKt___CollectionsKt.V(list)) == null) {
                    return;
                }
                SessionLocalListUtil.f13179a.i(inboxSessionModel);
                EventBus.c().o(new UpdateSessionListEvent());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(@Nullable Context context, @NotNull String sessionId) {
        s.i(sessionId, "sessionId");
        Observable<Result<InboxSessionResult>> b4 = NetworkClient.f11868a.j().b(sessionId);
        SessionLocalListUtil$getNewSession$2 sessionLocalListUtil$getNewSession$2 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.chat.util.SessionLocalListUtil$getNewSession$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.TRUE;
            }
        };
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = b4.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<InboxSessionResult, p>() { // from class: com.cupidapp.live.chat.util.SessionLocalListUtil$getNewSession$$inlined$handleByContext$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(InboxSessionResult inboxSessionResult) {
                m2484invoke(inboxSessionResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2484invoke(InboxSessionResult inboxSessionResult) {
                InboxSessionModel inboxSessionModel;
                InboxSessionResult inboxSessionResult2 = inboxSessionResult;
                p1.g.f52734a.X1(inboxSessionResult2.getMessageCount());
                List<InboxSessionModel> list = inboxSessionResult2.getList();
                if ((list == null || list.isEmpty()) || (inboxSessionModel = (InboxSessionModel) CollectionsKt___CollectionsKt.V(inboxSessionResult2.getList())) == null) {
                    return;
                }
                SessionLocalListUtil.f13179a.i(inboxSessionModel);
                EventBus.c().o(new UpdateSessionListEvent());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(sessionLocalListUtil$getNewSession$2, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final List<InboxSessionModel> d() {
        return f13180b;
    }

    public final void e(InboxSessionModel inboxSessionModel) {
        User sender = inboxSessionModel.getSender();
        boolean z10 = sender != null && sender.getFocus();
        int i10 = 0;
        int i11 = 0;
        for (InboxSessionModel inboxSessionModel2 : f13180b) {
            int i12 = i10 + 1;
            if (i10 != 0 || !f(inboxSessionModel2)) {
                if (z10) {
                    break;
                }
                User sender2 = inboxSessionModel2.getSender();
                if (!(sender2 != null && sender2.getFocus())) {
                    break;
                }
            }
            i11++;
            i10 = i12;
        }
        List<InboxSessionModel> list = f13180b;
        if (i11 <= list.size()) {
            list.add(i11, inboxSessionModel);
        }
    }

    public final boolean f(InboxSessionModel inboxSessionModel) {
        if (s.d(inboxSessionModel.getType(), InboxSessionType.VisitorSession.getType())) {
            VisitorInfoModel visitorInfo = inboxSessionModel.getVisitorInfo();
            if (visitorInfo != null && visitorInfo.getVisitorEnable()) {
                return true;
            }
        }
        return false;
    }

    public final void g(@NotNull RefreshSessionLiveStatusGrpcModel model) {
        InboxSessionModel inboxSessionModel;
        s.i(model, "model");
        Iterator<InboxSessionModel> iterator2 = f13180b.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                inboxSessionModel = null;
                break;
            } else {
                inboxSessionModel = iterator2.next();
                if (s.d(inboxSessionModel.getItemId(), model.getSessionId())) {
                    break;
                }
            }
        }
        InboxSessionModel inboxSessionModel2 = inboxSessionModel;
        if (inboxSessionModel2 == null || model.getTime() <= inboxSessionModel2.getRefreshSessionLiveStatusTime()) {
            return;
        }
        inboxSessionModel2.setLiveShowId(model.getLiveShowId());
        inboxSessionModel2.setRefreshSessionLiveStatusTime(model.getTime());
        EventBus.c().o(new RefreshSessionLiveStatusEvent(model));
    }

    public final void h(InboxSessionModel inboxSessionModel) {
        Iterator<InboxSessionModel> iterator2 = f13180b.iterator2();
        while (iterator2.hasNext()) {
            if (s.d(iterator2.next().getItemId(), inboxSessionModel.getItemId())) {
                iterator2.remove();
                return;
            }
        }
    }

    public final void i(InboxSessionModel inboxSessionModel) {
        h(inboxSessionModel);
        e(inboxSessionModel);
    }

    public final void j(@NotNull List<InboxSessionModel> list) {
        s.i(list, "list");
        List<InboxSessionModel> list2 = f13180b;
        list2.clear();
        if (!list.isEmpty()) {
            list2.addAll(list);
        }
    }
}
