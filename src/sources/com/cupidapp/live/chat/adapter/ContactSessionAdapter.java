package com.cupidapp.live.chat.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterWithSpaceViewHolder;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterWithSpaceModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.chat.model.ChatSessionTitleUIModel;
import com.cupidapp.live.chat.model.InboxSessionModel;
import com.cupidapp.live.chat.model.InboxSessionType;
import com.cupidapp.live.chat.viewholder.ChatSessionTitleViewHolder;
import com.cupidapp.live.chat.viewholder.ContactSessionListViewHolder;
import com.cupidapp.live.chat.viewholder.NewUserGuideModel;
import com.cupidapp.live.chat.viewholder.NewUserGuideViewHolder;
import com.cupidapp.live.feed.model.PromotionNearByGuideModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupOthersLog;
import h1.a;
import j1.e;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContactSessionAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ContactSessionAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public ChatSessionTitleViewHolder f13134f;

    public ContactSessionAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(ChatSessionTitleUIModel.class);
        k10.add(InboxSessionModel.class);
        k10.add(NewUserGuideModel.class);
        k10.add(FKEmptyViewModel.class);
        k10.add(FKFooterWithSpaceModel.class);
    }

    public final void v(List<a> list) {
        Iterator<a> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            Object a10 = iterator2.next().a();
            if (a10 instanceof InboxSessionModel) {
                w((InboxSessionModel) a10);
            } else if (a10 instanceof ChatSessionTitleUIModel) {
                ChatSessionTitleUIModel chatSessionTitleUIModel = (ChatSessionTitleUIModel) a10;
                if (chatSessionTitleUIModel.getGuide() != null) {
                    GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                    SensorPosition sensorPosition = SensorPosition.Message;
                    PromotionNearByGuideModel guide = chatSessionTitleUIModel.getGuide();
                    GroupOthersLog.L(groupOthersLog, sensorPosition, guide != null ? guide.getTrackName() : null, null, 4, null);
                }
            }
        }
    }

    public final void w(InboxSessionModel inboxSessionModel) {
        if (s.d(inboxSessionModel.getType(), InboxSessionType.ChatStatusSession.getType())) {
            e.e(e.f50230a, "RECOMMENDED_CHAT", inboxSessionModel.getChatStatusDot(), false, null, null, 28, null);
            return;
        }
        if (s.d(inboxSessionModel.getType(), InboxSessionType.InboxSession.getType()) && inboxSessionModel.inLiveShow()) {
            e eVar = e.f50230a;
            boolean inLiveShow = inboxSessionModel.inLiveShow();
            User sender = inboxSessionModel.getSender();
            e.e(eVar, "COMMON_CHAT", null, inLiveShow, sender != null ? sender.userId() : null, null, 18, null);
            SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
            String liveShowId = inboxSessionModel.getLiveShowId();
            s.f(liveShowId);
            User sender2 = inboxSessionModel.getSender();
            sensorsLogLiveShow.o(liveShowId, sender2 != null ? sender2.userId() : null, SensorPosition.Message, SensorScene.Chat, (r33 & 16) != 0 ? null : null, (r33 & 32) != 0 ? null : null, (r33 & 64) != 0 ? null : null, (r33 & 128) != 0 ? null : null, (r33 & 256) != 0 ? null : null, (r33 & 512) != 0 ? null : null, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? null : null, (r33 & 4096) != 0 ? null : null, (r33 & 8192) != 0 ? null : null);
            return;
        }
        if (s.d(inboxSessionModel.getType(), InboxSessionType.MarketingSession.getType())) {
            String trackName = inboxSessionModel.getTrackName();
            if (!(trackName == null || trackName.length() == 0)) {
                e.e(e.f50230a, inboxSessionModel.getTrackName(), Boolean.valueOf(inboxSessionModel.getMarketingDot()), false, null, null, 28, null);
                return;
            }
        }
        if (s.d(inboxSessionModel.getType(), InboxSessionType.GroupSession.getType())) {
            e.e(e.f50230a, "GROUP_SESSION", null, false, null, inboxSessionModel.getItemId(), 14, null);
            return;
        }
        if (s.d(inboxSessionModel.getType(), InboxSessionType.NearBySession.getType())) {
            e eVar2 = e.f50230a;
            User sender3 = inboxSessionModel.getSender();
            e.e(eVar2, "NEARBY_CHAT", null, false, sender3 != null ? sender3.userId() : null, null, 22, null);
        } else if (s.d(inboxSessionModel.getType(), InboxSessionType.OperationSession.getType())) {
            e eVar3 = e.f50230a;
            User sender4 = inboxSessionModel.getSender();
            e.e(eVar3, "MATKET_COMMON", null, false, sender4 != null ? sender4.userId() : null, null, 22, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder fKBaseRecyclerViewHolder;
        s.i(parent, "parent");
        if (i10 == 0) {
            ChatSessionTitleViewHolder a10 = ChatSessionTitleViewHolder.f13247d.a(parent);
            this.f13134f = a10;
            s.f(a10);
            fKBaseRecyclerViewHolder = a10;
        } else if (i10 == 1) {
            fKBaseRecyclerViewHolder = ContactSessionListViewHolder.f13251d.a(parent);
        } else if (i10 == 2) {
            fKBaseRecyclerViewHolder = NewUserGuideViewHolder.f13257c.a(parent);
        } else if (i10 != 3) {
            fKBaseRecyclerViewHolder = FKFooterWithSpaceViewHolder.f12037c.a(parent);
        } else {
            fKBaseRecyclerViewHolder = FKEmptyListViewHolder.f12034c.a(parent);
        }
        fKBaseRecyclerViewHolder.k(l());
        return fKBaseRecyclerViewHolder;
    }

    public final void y() {
        ChatSessionTitleViewHolder chatSessionTitleViewHolder = this.f13134f;
        if (chatSessionTitleViewHolder != null) {
            chatSessionTitleViewHolder.z();
        }
    }

    public final void z(@NotNull RecyclerView recyclerView) {
        s.i(recyclerView, "recyclerView");
        t(new RecyclerExposureHelper(ExposureScene.ChatSessionList, recyclerView, 0.0f, 0L, null, new Function1<List<? extends a>, p>() { // from class: com.cupidapp.live.chat.adapter.ContactSessionAdapter$setExposureHelper$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends a> list) {
                invoke2((List<a>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<a> itemList) {
                s.i(itemList, "itemList");
                ContactSessionAdapter.this.v(itemList);
            }
        }, 28, null));
    }
}
