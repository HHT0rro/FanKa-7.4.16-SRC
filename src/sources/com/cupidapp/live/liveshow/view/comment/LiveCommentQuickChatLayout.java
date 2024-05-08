package com.cupidapp.live.liveshow.view.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.decoration.ExtraSpacingDecoration;
import com.cupidapp.live.track.group.GroupLiveLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: LiveCommentQuickChatLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveCommentQuickChatLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function1<? super LiveCommentQuickChatModel, p> f15394b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f15395c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15396d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCommentQuickChatLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15396d = new LinkedHashMap();
        this.f15395c = kotlin.c.b(new Function0<LiveCommentQuickChatAdapter>() { // from class: com.cupidapp.live.liveshow.view.comment.LiveCommentQuickChatLayout$quickChatAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveCommentQuickChatAdapter invoke() {
                LiveCommentQuickChatAdapter liveCommentQuickChatAdapter = new LiveCommentQuickChatAdapter();
                final LiveCommentQuickChatLayout liveCommentQuickChatLayout = LiveCommentQuickChatLayout.this;
                liveCommentQuickChatAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.comment.LiveCommentQuickChatLayout$quickChatAdapter$2$1$1
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
                        if (obj instanceof LiveCommentQuickChatModel) {
                            Function1<LiveCommentQuickChatModel, p> selectCallback = LiveCommentQuickChatLayout.this.getSelectCallback();
                            if (selectCallback != null) {
                                selectCallback.invoke(obj);
                            }
                            GroupLiveLog.f18698a.H(((LiveCommentQuickChatModel) obj).getMessage());
                        }
                    }
                });
                return liveCommentQuickChatAdapter;
            }
        });
        c();
    }

    private final LiveCommentQuickChatAdapter getQuickChatAdapter() {
        return (LiveCommentQuickChatAdapter) this.f15395c.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15396d;
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

    public final void b(@NotNull List<LiveCommentQuickChatModel> messages) {
        s.i(messages, "messages");
        if (s.d(getQuickChatAdapter().j(), messages)) {
            return;
        }
        getQuickChatAdapter().j().clear();
        getQuickChatAdapter().e(messages);
        getQuickChatAdapter().notifyDataSetChanged();
    }

    public final void c() {
        z.a(this, R$layout.layout_live_comment_quick_chat, true);
        RecyclerView initView$lambda$0 = (RecyclerView) a(R$id.live_quick_chat_recyclerview);
        initView$lambda$0.setAdapter(getQuickChatAdapter());
        initView$lambda$0.setLayoutManager(new LinearLayoutManager(initView$lambda$0.getContext(), 0, false));
        s.h(initView$lambda$0, "initView$lambda$0");
        initView$lambda$0.addItemDecoration(new ExtraSpacingDecoration(h.c(initView$lambda$0, 4.0f), 0, h.c(initView$lambda$0, 4.0f), 0, h.c(initView$lambda$0, 12.0f)));
    }

    @Nullable
    public final Function1<LiveCommentQuickChatModel, p> getSelectCallback() {
        return this.f15394b;
    }

    public final void setSelectCallback(@Nullable Function1<? super LiveCommentQuickChatModel, p> function1) {
        this.f15394b = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCommentQuickChatLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15396d = new LinkedHashMap();
        this.f15395c = kotlin.c.b(new Function0<LiveCommentQuickChatAdapter>() { // from class: com.cupidapp.live.liveshow.view.comment.LiveCommentQuickChatLayout$quickChatAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveCommentQuickChatAdapter invoke() {
                LiveCommentQuickChatAdapter liveCommentQuickChatAdapter = new LiveCommentQuickChatAdapter();
                final LiveCommentQuickChatLayout liveCommentQuickChatLayout = LiveCommentQuickChatLayout.this;
                liveCommentQuickChatAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.comment.LiveCommentQuickChatLayout$quickChatAdapter$2$1$1
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
                        if (obj instanceof LiveCommentQuickChatModel) {
                            Function1<LiveCommentQuickChatModel, p> selectCallback = LiveCommentQuickChatLayout.this.getSelectCallback();
                            if (selectCallback != null) {
                                selectCallback.invoke(obj);
                            }
                            GroupLiveLog.f18698a.H(((LiveCommentQuickChatModel) obj).getMessage());
                        }
                    }
                });
                return liveCommentQuickChatAdapter;
            }
        });
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCommentQuickChatLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15396d = new LinkedHashMap();
        this.f15395c = kotlin.c.b(new Function0<LiveCommentQuickChatAdapter>() { // from class: com.cupidapp.live.liveshow.view.comment.LiveCommentQuickChatLayout$quickChatAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveCommentQuickChatAdapter invoke() {
                LiveCommentQuickChatAdapter liveCommentQuickChatAdapter = new LiveCommentQuickChatAdapter();
                final LiveCommentQuickChatLayout liveCommentQuickChatLayout = LiveCommentQuickChatLayout.this;
                liveCommentQuickChatAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.comment.LiveCommentQuickChatLayout$quickChatAdapter$2$1$1
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
                        if (obj instanceof LiveCommentQuickChatModel) {
                            Function1<LiveCommentQuickChatModel, p> selectCallback = LiveCommentQuickChatLayout.this.getSelectCallback();
                            if (selectCallback != null) {
                                selectCallback.invoke(obj);
                            }
                            GroupLiveLog.f18698a.H(((LiveCommentQuickChatModel) obj).getMessage());
                        }
                    }
                });
                return liveCommentQuickChatAdapter;
            }
        });
        c();
    }
}
