package com.cupidapp.live.liveshow.view.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.grpc.NotifyMessageModel;
import com.cupidapp.live.base.network.gson.BaseLiveShowTagModel;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.adapter.FKLiveCommentAdapter;
import com.cupidapp.live.liveshow.adapter.FKLiveCommentMessageViewModel;
import com.cupidapp.live.liveshow.adapter.FKLiveGiftMessageViewModel;
import com.cupidapp.live.liveshow.adapter.FKLiveMessageViewModel;
import com.cupidapp.live.liveshow.adapter.FKLiveSystemMessageViewModel;
import com.cupidapp.live.liveshow.adapter.LiveCommentMessageGuideModel;
import com.cupidapp.live.liveshow.model.CommentModel;
import com.cupidapp.live.liveshow.model.LiveCommentGuideType;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupLiveLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKLiveCommentLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveCommentLayout extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f15357f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f15358b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public f f15359c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Map<String, String> f15360d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15361e;

    /* compiled from: FKLiveCommentLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return (int) (h.k(this) * 0.275f);
        }
    }

    /* compiled from: FKLiveCommentLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15362a;

        static {
            int[] iArr = new int[LiveCommentGuideType.values().length];
            try {
                iArr[LiveCommentGuideType.AlohaType.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LiveCommentGuideType.ChatType.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LiveCommentGuideType.SendGiftType.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f15362a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveCommentLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15361e = new LinkedHashMap();
        this.f15358b = kotlin.c.b(new Function0<FKLiveCommentAdapter>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveCommentLayout$commentListAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLiveCommentAdapter invoke() {
                FKLiveCommentAdapter fKLiveCommentAdapter = new FKLiveCommentAdapter();
                final FKLiveCommentLayout fKLiveCommentLayout = FKLiveCommentLayout.this;
                fKLiveCommentAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveCommentLayout$commentListAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        f fVar;
                        if (obj instanceof FKLiveSystemMessageViewModel) {
                            User user = ((FKLiveSystemMessageViewModel) obj).getUser();
                            if (user != null) {
                                EventBus.c().l(new ShowLiveMiniProfileViewModel(user.userId(), null, null, false, false, false, 54, null));
                                return;
                            }
                            return;
                        }
                        if (obj instanceof LiveCommentMessageGuideModel) {
                            LiveCommentMessageGuideModel liveCommentMessageGuideModel = (LiveCommentMessageGuideModel) obj;
                            if (liveCommentMessageGuideModel.getCanClick()) {
                                String url = liveCommentMessageGuideModel.getUrl();
                                if (!(url == null || url.length() == 0)) {
                                    EventBus.c().l(new FKLiveOpenWebFragmentEvent(liveCommentMessageGuideModel.getUrl(), false, 2, null));
                                } else {
                                    fVar = FKLiveCommentLayout.this.f15359c;
                                    if (fVar != null) {
                                        fVar.a(liveCommentMessageGuideModel.getMessageType());
                                    }
                                }
                                GroupLiveLog.f18698a.F(liveCommentMessageGuideModel.getMessageType());
                            }
                        }
                    }
                });
                return fKLiveCommentAdapter;
            }
        });
        this.f15360d = new LinkedHashMap();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FKLiveCommentAdapter getCommentListAdapter() {
        return (FKLiveCommentAdapter) this.f15358b.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15361e;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void d(@NotNull LiveCommentGuideType type) {
        Object obj;
        s.i(type, "type");
        Iterator<Object> iterator2 = getCommentListAdapter().j().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                obj = null;
                break;
            } else {
                obj = iterator2.next();
                if ((obj instanceof LiveCommentMessageGuideModel) && ((LiveCommentMessageGuideModel) obj).getMessageType() == type) {
                    break;
                }
            }
        }
        if (obj != null) {
            return;
        }
        int i10 = b.f15362a[type.ordinal()];
        if (i10 == 1) {
            e(new LiveCommentMessageGuideModel(Integer.valueOf(R$mipmap.icon_live_aloha_guide), getContext().getString(R$string.aloha_actor_prompt), kotlin.collections.s.m(-49019, -35520), LiveCommentGuideType.AlohaType, null, null, false, 112, null));
        } else if (i10 == 2) {
            e(new LiveCommentMessageGuideModel(Integer.valueOf(R$mipmap.icon_live_comment_guide), getContext().getString(R$string.chat_with_actor_prompt), kotlin.collections.s.m(-11122177, -14188033), LiveCommentGuideType.ChatType, null, null, false, 112, null));
        } else if (i10 == 3) {
            e(new LiveCommentMessageGuideModel(Integer.valueOf(R$mipmap.icon_live_gift_guide), getContext().getString(R$string.send_gift_prompt), kotlin.collections.s.m(-6275073, -9877761), LiveCommentGuideType.SendGiftType, null, null, false, 112, null));
        }
        GroupLiveLog.f18698a.G(type);
    }

    public final void e(@NotNull FKLiveMessageViewModel message) {
        s.i(message, "message");
        getCommentListAdapter().d(message);
        getCommentListAdapter().notifyItemInserted(getCommentListAdapter().n() - 1);
        int i10 = R$id.layoutLiveCommentRecycler;
        if (((RecyclerView) a(i10)).canScrollVertically(1)) {
            ((TextView) a(R$id.layoutLiveCommentTips)).setVisibility(0);
        } else {
            ((RecyclerView) a(i10)).scrollToPosition(kotlin.collections.s.l(getCommentListAdapter().j()));
        }
    }

    public final void f(@NotNull NotifyMessageModel notify, boolean z10) {
        ArrayList arrayList;
        List z02;
        s.i(notify, "notify");
        String bgColor = notify.getBgColor();
        if (bgColor == null || (z02 = StringsKt__StringsKt.z0(bgColor, new String[]{","}, false, 0, 6, null)) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(t.t(z02, 10));
            Iterator<E> iterator2 = z02.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(Integer.valueOf(com.cupidapp.live.base.utils.h.b((String) iterator2.next())));
            }
        }
        ArrayList arrayList2 = arrayList;
        LiveCommentGuideType liveCommentGuideType = LiveCommentGuideType.CommentGuide;
        String point = notify.getPoint();
        if (point == null) {
            point = "";
        }
        liveCommentGuideType.setType(point);
        e(new LiveCommentMessageGuideModel(null, notify.getMessage(), arrayList2, liveCommentGuideType, notify.getLeftIcon(), notify.getPath(), !z10));
        GroupLiveLog.f18698a.G(liveCommentGuideType);
    }

    public final void g(@Nullable User user, @Nullable String str, @Nullable List<? extends BaseLiveShowTagModel> list) {
        if (user != null) {
            if (str == null || str.length() == 0) {
                return;
            }
            String userId = user.userId();
            if (this.f15360d.containsKey(userId)) {
                l(this.f15360d.get(userId));
                this.f15360d.remove(userId);
                e(new FKLiveSystemMessageViewModel(str, user, list));
                this.f15360d.put(userId, str);
                return;
            }
            if (this.f15360d.size() < 3) {
                e(new FKLiveSystemMessageViewModel(str, user, list));
                this.f15360d.put(userId, str);
                return;
            }
            String str2 = (String) CollectionsKt___CollectionsKt.S(this.f15360d.h());
            l(this.f15360d.get(str2));
            this.f15360d.remove(str2);
            e(new FKLiveSystemMessageViewModel(str, user, list));
            this.f15360d.put(userId, str);
        }
    }

    public final void h(@Nullable String str) {
        getCommentListAdapter().v(str);
    }

    public final void i() {
        z.a(this, R$layout.layout_live_comment, true);
        FrameLayout layoutLiveComment = (FrameLayout) a(R$id.layoutLiveComment);
        s.h(layoutLiveComment, "layoutLiveComment");
        y.o(layoutLiveComment, null, Integer.valueOf(f15357f.a()), 1, null);
        int i10 = R$id.layoutLiveCommentRecycler;
        RecyclerView recyclerView = (RecyclerView) a(i10);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(getCommentListAdapter());
        FKLiveCommentAdapter commentListAdapter = getCommentListAdapter();
        ExposureScene exposureScene = ExposureScene.Live;
        s.h(recyclerView, "this");
        commentListAdapter.t(new RecyclerExposureHelper(exposureScene, recyclerView, 0.0f, 0L, null, new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveCommentLayout$initView$1$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends h1.a> list) {
                invoke2((List<h1.a>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<h1.a> list) {
                s.i(list, "list");
                Iterator<h1.a> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof FKLiveCommentMessageViewModel) {
                        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                        String value = SensorScene.Live.getValue();
                        User user = ((FKLiveCommentMessageViewModel) a10).getCommentModel().getUser();
                        groupSocialLog.w(value, user != null ? user.userId() : null, (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : false, (r29 & 2048) != 0 ? false : false);
                    } else if (a10 instanceof FKLiveGiftMessageViewModel) {
                        GroupSocialLog groupSocialLog2 = GroupSocialLog.f18708a;
                        String value2 = SensorScene.Live.getValue();
                        User sender = ((FKLiveGiftMessageViewModel) a10).getSender();
                        groupSocialLog2.w(value2, sender != null ? sender.userId() : null, (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : false, (r29 & 2048) != 0 ? false : false);
                    }
                }
            }
        }, 28, null));
        TextView layoutLiveCommentTips = (TextView) a(R$id.layoutLiveCommentTips);
        s.h(layoutLiveCommentTips, "layoutLiveCommentTips");
        y.d(layoutLiveCommentTips, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveCommentLayout$initView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKLiveCommentAdapter commentListAdapter2;
                RecyclerView recyclerView2 = (RecyclerView) FKLiveCommentLayout.this.a(R$id.layoutLiveCommentRecycler);
                commentListAdapter2 = FKLiveCommentLayout.this.getCommentListAdapter();
                recyclerView2.scrollToPosition(kotlin.collections.s.l(commentListAdapter2.j()));
                ((TextView) FKLiveCommentLayout.this.a(R$id.layoutLiveCommentTips)).setVisibility(8);
            }
        });
        ((RecyclerView) a(i10)).addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveCommentLayout$initView$3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView2, int i11) {
                s.i(recyclerView2, "recyclerView");
                super.onScrollStateChanged(recyclerView2, i11);
                if (i11 != 0 || ((RecyclerView) FKLiveCommentLayout.this.a(R$id.layoutLiveCommentRecycler)).canScrollVertically(1)) {
                    return;
                }
                ((TextView) FKLiveCommentLayout.this.a(R$id.layoutLiveCommentTips)).setVisibility(8);
            }
        });
    }

    public final void j(boolean z10) {
        getCommentListAdapter().w(z10);
    }

    public final void k(@NotNull LiveShowResult liveShowResult) {
        s.i(liveShowResult, "liveShowResult");
        List<CommentModel> recentComments = liveShowResult.getRecentComments();
        if (recentComments != null) {
            ArrayList arrayList = new ArrayList();
            for (CommentModel commentModel : recentComments) {
                if (!commentModel.getBarrage()) {
                    arrayList.add(commentModel);
                }
            }
            ArrayList<FKLiveCommentMessageViewModel> arrayList2 = new ArrayList(t.t(arrayList, 10));
            Iterator<E> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                arrayList2.add(new FKLiveCommentMessageViewModel((CommentModel) iterator2.next(), false, 2, null));
            }
            List<Object> j10 = getCommentListAdapter().j();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : j10) {
                if (obj instanceof FKLiveCommentMessageViewModel) {
                    arrayList3.add(obj);
                }
            }
            ArrayList arrayList4 = new ArrayList(t.t(arrayList3, 10));
            Iterator<E> iterator22 = arrayList3.iterator2();
            while (iterator22.hasNext()) {
                arrayList4.add(((FKLiveCommentMessageViewModel) iterator22.next()).getCommentModel().getItemId());
            }
            for (FKLiveCommentMessageViewModel fKLiveCommentMessageViewModel : arrayList2) {
                if (!arrayList4.contains(fKLiveCommentMessageViewModel.getCommentModel().getItemId())) {
                    getCommentListAdapter().d(fKLiveCommentMessageViewModel);
                }
            }
            getCommentListAdapter().notifyDataSetChanged();
            ((RecyclerView) a(R$id.layoutLiveCommentRecycler)).scrollToPosition(kotlin.collections.s.l(getCommentListAdapter().j()));
        }
    }

    public final void l(String str) {
        if (str == null) {
            return;
        }
        Iterator<Object> iterator2 = getCommentListAdapter().j().iterator2();
        int i10 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                i10 = -1;
                break;
            }
            Object next = iterator2.next();
            if ((next instanceof FKLiveSystemMessageViewModel) && s.d(((FKLiveSystemMessageViewModel) next).getSystemMessage(), str)) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0) {
            getCommentListAdapter().j().remove(i10);
            getCommentListAdapter().notifyItemRemoved(i10);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void setListener(@NotNull f listener) {
        s.i(listener, "listener");
        this.f15359c = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveCommentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15361e = new LinkedHashMap();
        this.f15358b = kotlin.c.b(new Function0<FKLiveCommentAdapter>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveCommentLayout$commentListAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLiveCommentAdapter invoke() {
                FKLiveCommentAdapter fKLiveCommentAdapter = new FKLiveCommentAdapter();
                final FKLiveCommentLayout fKLiveCommentLayout = FKLiveCommentLayout.this;
                fKLiveCommentAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveCommentLayout$commentListAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        f fVar;
                        if (obj instanceof FKLiveSystemMessageViewModel) {
                            User user = ((FKLiveSystemMessageViewModel) obj).getUser();
                            if (user != null) {
                                EventBus.c().l(new ShowLiveMiniProfileViewModel(user.userId(), null, null, false, false, false, 54, null));
                                return;
                            }
                            return;
                        }
                        if (obj instanceof LiveCommentMessageGuideModel) {
                            LiveCommentMessageGuideModel liveCommentMessageGuideModel = (LiveCommentMessageGuideModel) obj;
                            if (liveCommentMessageGuideModel.getCanClick()) {
                                String url = liveCommentMessageGuideModel.getUrl();
                                if (!(url == null || url.length() == 0)) {
                                    EventBus.c().l(new FKLiveOpenWebFragmentEvent(liveCommentMessageGuideModel.getUrl(), false, 2, null));
                                } else {
                                    fVar = FKLiveCommentLayout.this.f15359c;
                                    if (fVar != null) {
                                        fVar.a(liveCommentMessageGuideModel.getMessageType());
                                    }
                                }
                                GroupLiveLog.f18698a.F(liveCommentMessageGuideModel.getMessageType());
                            }
                        }
                    }
                });
                return fKLiveCommentAdapter;
            }
        });
        this.f15360d = new LinkedHashMap();
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveCommentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15361e = new LinkedHashMap();
        this.f15358b = kotlin.c.b(new Function0<FKLiveCommentAdapter>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveCommentLayout$commentListAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLiveCommentAdapter invoke() {
                FKLiveCommentAdapter fKLiveCommentAdapter = new FKLiveCommentAdapter();
                final FKLiveCommentLayout fKLiveCommentLayout = FKLiveCommentLayout.this;
                fKLiveCommentAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveCommentLayout$commentListAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        f fVar;
                        if (obj instanceof FKLiveSystemMessageViewModel) {
                            User user = ((FKLiveSystemMessageViewModel) obj).getUser();
                            if (user != null) {
                                EventBus.c().l(new ShowLiveMiniProfileViewModel(user.userId(), null, null, false, false, false, 54, null));
                                return;
                            }
                            return;
                        }
                        if (obj instanceof LiveCommentMessageGuideModel) {
                            LiveCommentMessageGuideModel liveCommentMessageGuideModel = (LiveCommentMessageGuideModel) obj;
                            if (liveCommentMessageGuideModel.getCanClick()) {
                                String url = liveCommentMessageGuideModel.getUrl();
                                if (!(url == null || url.length() == 0)) {
                                    EventBus.c().l(new FKLiveOpenWebFragmentEvent(liveCommentMessageGuideModel.getUrl(), false, 2, null));
                                } else {
                                    fVar = FKLiveCommentLayout.this.f15359c;
                                    if (fVar != null) {
                                        fVar.a(liveCommentMessageGuideModel.getMessageType());
                                    }
                                }
                                GroupLiveLog.f18698a.F(liveCommentMessageGuideModel.getMessageType());
                            }
                        }
                    }
                });
                return fKLiveCommentAdapter;
            }
        });
        this.f15360d = new LinkedHashMap();
        i();
    }
}
