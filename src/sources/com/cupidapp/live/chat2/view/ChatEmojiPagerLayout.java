package com.cupidapp.live.chat2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$array;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.chat.model.CustomEmojiCode;
import com.cupidapp.live.chat2.adapter.ChatCustomEmojiItemUiModel;
import com.cupidapp.live.chat2.adapter.ChatEmojiPagerAdapter;
import com.cupidapp.live.chat2.adapter.ChatEmojiTitleAdapter;
import com.cupidapp.live.chat2.adapter.ChatEmojiTitleUiModel;
import com.cupidapp.live.chat2.holder.ChatCustomEmojiPagerUiModel;
import com.cupidapp.live.chat2.holder.ChatSystemEmojiPagerUiModel;
import com.cupidapp.live.chat2.model.ChatSendEmojiMessageEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ChatEmojiPagerLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatEmojiPagerLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final ChatEmojiTitleAdapter f13445d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public i f13446e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13447f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatEmojiPagerLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13447f = new LinkedHashMap();
        this.f13445d = new ChatEmojiTitleAdapter();
        i();
    }

    private final List<Object> getContentData() {
        String[] stringArray = getResources().getStringArray(R$array.emoji_face);
        s.h(stringArray, "resources.getStringArray(R.array.emoji_face)");
        List M = m.M(stringArray);
        Map g3 = i0.g(kotlin.f.a(CustomEmojiCode.Greet, "打招呼"), kotlin.f.a(CustomEmojiCode.WaterPistol, "滋水枪"), kotlin.f.a(CustomEmojiCode.PatPat, "贴贴"), kotlin.f.a(CustomEmojiCode.Poke, "戳一下"), kotlin.f.a(CustomEmojiCode.TouchHead, "摸摸头"), kotlin.f.a(CustomEmojiCode.PinchFace, "捏捏脸"), kotlin.f.a(CustomEmojiCode.ThanHeart, "比个心"));
        ArrayList arrayList = new ArrayList(g3.size());
        for (Map.Entry entry : g3.entrySet()) {
            arrayList.add(new ChatCustomEmojiItemUiModel((String) entry.getValue(), ((CustomEmojiCode) entry.getKey()).getImageResId(), ((CustomEmojiCode) entry.getKey()).getEmojiCNCode()));
        }
        return kotlin.collections.s.m(new ChatSystemEmojiPagerUiModel(M), new ChatCustomEmojiPagerUiModel(arrayList));
    }

    private final List<ChatEmojiTitleUiModel> getTitleData() {
        return kotlin.collections.s.m(new ChatEmojiTitleUiModel(R$mipmap.icon_chat_system_emoji, true), new ChatEmojiTitleUiModel(R$mipmap.icon_chat_custom_emoji, false));
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f13447f;
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

    public final void g() {
        ChatEmojiPagerAdapter chatEmojiPagerAdapter = new ChatEmojiPagerAdapter();
        int i10 = R$id.chat_emoji_content_view_pager;
        ((ViewPager2) e(i10)).setAdapter(chatEmojiPagerAdapter);
        ((ViewPager2) e(i10)).registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.chat2.view.ChatEmojiPagerLayout$configContentViewPager$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(final int i11) {
                ChatEmojiTitleAdapter chatEmojiTitleAdapter;
                chatEmojiTitleAdapter = ChatEmojiPagerLayout.this.f13445d;
                final ChatEmojiPagerLayout chatEmojiPagerLayout = ChatEmojiPagerLayout.this;
                chatEmojiTitleAdapter.w(i11, new Function0<p>() { // from class: com.cupidapp.live.chat2.view.ChatEmojiPagerLayout$configContentViewPager$1$onPageSelected$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ p invoke() {
                        invoke2();
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ((RecyclerView) ChatEmojiPagerLayout.this.e(R$id.chat_emoji_title_recycler_view)).smoothScrollToPosition(i11);
                    }
                });
            }
        });
        chatEmojiPagerAdapter.j().clear();
        List<? extends Object> contentData = getContentData();
        chatEmojiPagerAdapter.e(contentData);
        chatEmojiPagerAdapter.notifyItemRangeInserted(0, contentData.size());
    }

    public final void h() {
        this.f13445d.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.chat2.view.ChatEmojiPagerLayout$configTitleRecyclerView$1
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
                ChatEmojiTitleAdapter chatEmojiTitleAdapter;
                ChatEmojiTitleAdapter chatEmojiTitleAdapter2;
                if (obj instanceof ChatEmojiTitleUiModel) {
                    chatEmojiTitleAdapter = ChatEmojiPagerLayout.this.f13445d;
                    final int indexOf = chatEmojiTitleAdapter.j().indexOf(obj);
                    chatEmojiTitleAdapter2 = ChatEmojiPagerLayout.this.f13445d;
                    final ChatEmojiPagerLayout chatEmojiPagerLayout = ChatEmojiPagerLayout.this;
                    chatEmojiTitleAdapter2.w(indexOf, new Function0<p>() { // from class: com.cupidapp.live.chat2.view.ChatEmojiPagerLayout$configTitleRecyclerView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ p invoke() {
                            invoke2();
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ((ViewPager2) ChatEmojiPagerLayout.this.e(R$id.chat_emoji_content_view_pager)).setCurrentItem(indexOf, false);
                        }
                    });
                }
            }
        });
        RecyclerView configTitleRecyclerView$lambda$0 = (RecyclerView) e(R$id.chat_emoji_title_recycler_view);
        RecyclerView.ItemAnimator itemAnimator = configTitleRecyclerView$lambda$0.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        configTitleRecyclerView$lambda$0.setAdapter(this.f13445d);
        configTitleRecyclerView$lambda$0.setLayoutManager(new LinearLayoutManager(configTitleRecyclerView$lambda$0.getContext(), 0, false));
        s.h(configTitleRecyclerView$lambda$0, "configTitleRecyclerView$lambda$0");
        int c4 = z0.h.c(configTitleRecyclerView$lambda$0, 8.0f);
        configTitleRecyclerView$lambda$0.addItemDecoration(new FKAddExtraSpacingDecoration(c4, 0, c4, 0, c4, 0, 42, null));
        this.f13445d.u(getTitleData());
    }

    public final void i() {
        z.a(this, R$layout.layout_chat_emoji_pager, true);
        h();
        g();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChatSendEmojiMessageEvent event) {
        s.i(event, "event");
        i iVar = this.f13446e;
        if (iVar != null) {
            iVar.a(event.getType(), event.getTextMessage());
        }
    }

    public final void setChatEmojiPagerListener(@NotNull i listener) {
        s.i(listener, "listener");
        this.f13446e = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatEmojiPagerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13447f = new LinkedHashMap();
        this.f13445d = new ChatEmojiTitleAdapter();
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatEmojiPagerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13447f = new LinkedHashMap();
        this.f13445d = new ChatEmojiTitleAdapter();
        i();
    }
}
