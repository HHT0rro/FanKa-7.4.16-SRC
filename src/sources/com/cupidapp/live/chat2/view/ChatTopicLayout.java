package com.cupidapp.live.chat2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.chat2.model.ChatTopicModel;
import com.cupidapp.live.profile.model.ZodiacElfInfoModel;
import com.cupidapp.live.track.group.EventTrackMessageTopicClickType;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ChatTopicLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatTopicLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<ChatTopicModel> f13453d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final List<ZodiacElfInfoModel> f13454e;

    /* renamed from: f, reason: collision with root package name */
    public int f13455f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public String f13456g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public j f13457h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13458i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatTopicLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13458i = new LinkedHashMap();
        this.f13453d = new ArrayList();
        this.f13454e = new ArrayList();
        this.f13455f = -1;
        s();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f13458i;
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

    public final void l() {
        TextView chat_topic_last_btn = (TextView) e(R$id.chat_topic_last_btn);
        s.h(chat_topic_last_btn, "chat_topic_last_btn");
        y.d(chat_topic_last_btn, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatTopicLayout$bindClickEvent$1
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
                String str;
                if (((TextView) ChatTopicLayout.this.e(R$id.chat_topic_last_btn)).getAlpha() == 1.0f) {
                    z3.b bVar = z3.b.f54828a;
                    str = ChatTopicLayout.this.f13456g;
                    bVar.g(str, EventTrackMessageTopicClickType.PREVIOUS);
                    ChatTopicLayout.this.p(false);
                }
            }
        });
        View chat_topic_send_btn = e(R$id.chat_topic_send_btn);
        s.h(chat_topic_send_btn, "chat_topic_send_btn");
        y.d(chat_topic_send_btn, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatTopicLayout$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
            
                if ((r4.length() > 0) == true) goto L11;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable android.view.View r4) {
                /*
                    r3 = this;
                    com.cupidapp.live.chat2.view.ChatTopicLayout r4 = com.cupidapp.live.chat2.view.ChatTopicLayout.this
                    java.lang.String r4 = com.cupidapp.live.chat2.view.ChatTopicLayout.h(r4)
                    r0 = 1
                    r1 = 0
                    if (r4 == 0) goto L16
                    int r2 = r4.length()
                    if (r2 <= 0) goto L12
                    r2 = 1
                    goto L13
                L12:
                    r2 = 0
                L13:
                    if (r2 != r0) goto L16
                    goto L17
                L16:
                    r0 = 0
                L17:
                    if (r0 == 0) goto L31
                    z3.b r0 = z3.b.f54828a
                    com.cupidapp.live.chat2.view.ChatTopicLayout r1 = com.cupidapp.live.chat2.view.ChatTopicLayout.this
                    java.lang.String r1 = com.cupidapp.live.chat2.view.ChatTopicLayout.h(r1)
                    com.cupidapp.live.track.group.EventTrackMessageTopicClickType r2 = com.cupidapp.live.track.group.EventTrackMessageTopicClickType.SEND
                    r0.g(r1, r2)
                    com.cupidapp.live.chat2.view.ChatTopicLayout r0 = com.cupidapp.live.chat2.view.ChatTopicLayout.this
                    com.cupidapp.live.chat2.view.j r0 = com.cupidapp.live.chat2.view.ChatTopicLayout.i(r0)
                    if (r0 == 0) goto L31
                    r0.a(r4)
                L31:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.chat2.view.ChatTopicLayout$bindClickEvent$2.invoke2(android.view.View):void");
            }
        });
        TextView chat_topic_next_btn = (TextView) e(R$id.chat_topic_next_btn);
        s.h(chat_topic_next_btn, "chat_topic_next_btn");
        y.d(chat_topic_next_btn, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatTopicLayout$bindClickEvent$3
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
                String str;
                if (((TextView) ChatTopicLayout.this.e(R$id.chat_topic_next_btn)).getAlpha() == 1.0f) {
                    z3.b bVar = z3.b.f54828a;
                    str = ChatTopicLayout.this.f13456g;
                    bVar.g(str, EventTrackMessageTopicClickType.NEXT);
                    ChatTopicLayout.this.p(true);
                }
            }
        });
    }

    public final void m() {
        if (!this.f13453d.isEmpty()) {
            z3.b.f54828a.h(this.f13456g);
            return;
        }
        Disposable disposed = NetworkClient.f11868a.h().s().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<ChatTopicModel>, p>() { // from class: com.cupidapp.live.chat2.view.ChatTopicLayout$configChatTopicData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<ChatTopicModel> listResult) {
                m2494invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2494invoke(ListResult<ChatTopicModel> listResult) {
                List list;
                List list2;
                List list3;
                String str;
                List<ChatTopicModel> list4 = listResult.getList();
                if (list4 != null) {
                    list = ChatTopicLayout.this.f13453d;
                    list.clear();
                    list2 = ChatTopicLayout.this.f13453d;
                    list2.addAll(list4);
                    list3 = ChatTopicLayout.this.f13454e;
                    if (list3.isEmpty()) {
                        ChatTopicLayout.this.f13455f = -1;
                        ChatTopicLayout.this.p(true);
                    }
                    z3.b bVar = z3.b.f54828a;
                    str = ChatTopicLayout.this.f13456g;
                    bVar.h(str);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void o(ChatTopicModel chatTopicModel, boolean z10, boolean z11) {
        ((ConstraintLayout) e(R$id.zodiac_elf_question_layout)).setVisibility(8);
        ((ConstraintLayout) e(R$id.chat_topic_question_layout)).setVisibility(0);
        ((ConstraintLayout) e(R$id.chat_topic_root_layout)).setBackgroundResource(R$drawable.shape_chat_topic_gradient_bg);
        int i10 = R$id.chat_topic_last_btn;
        ((TextView) e(i10)).setBackgroundResource(R$drawable.shape_red_stroke_bg);
        ((TextView) e(i10)).setTextColor(-49088);
        ((TextView) e(i10)).setAlpha(z10 ? 0.4f : 1.0f);
        e(R$id.chat_topic_send_btn).setBackgroundResource(R$drawable.shape_red_bg_twenty_two_corners);
        int i11 = R$id.chat_topic_next_btn;
        ((TextView) e(i11)).setBackgroundResource(R$drawable.shape_red_stroke_bg);
        ((TextView) e(i11)).setTextColor(-49088);
        ((TextView) e(i11)).setAlpha(z11 ? 0.4f : 1.0f);
        ((TextView) e(R$id.chat_topic_content_text)).setText(chatTopicModel.getContent());
        this.f13456g = chatTopicModel.getContent();
    }

    public final void p(boolean z10) {
        if (z10) {
            this.f13455f++;
        } else {
            this.f13455f--;
        }
        int size = this.f13454e.size();
        int size2 = this.f13453d.size() + size;
        int i10 = this.f13455f;
        if (i10 >= 0 && i10 < size) {
            q(i10);
            return;
        }
        if (size <= i10 && i10 < size2) {
            o(this.f13453d.get(this.f13455f - size), this.f13454e.isEmpty() && this.f13455f == size, this.f13455f == size2 - 1);
        } else if (z10) {
            this.f13455f = i10 - 1;
        } else {
            this.f13455f = i10 + 1;
        }
    }

    public final void q(int i10) {
        ZodiacElfInfoModel zodiacElfInfoModel = this.f13454e.get(i10);
        boolean z10 = i10 == 0;
        int i11 = R$id.zodiac_elf_question_layout;
        ((ConstraintLayout) e(i11)).setVisibility(0);
        ((ConstraintLayout) e(R$id.chat_topic_question_layout)).setVisibility(8);
        if (i10 == 0) {
            ((ConstraintLayout) e(R$id.chat_topic_root_layout)).setBackgroundResource(R$drawable.chat_zodiac_elf_first_big_bg);
            ((ConstraintLayout) e(i11)).setBackgroundResource(R$drawable.rect_cor_15_sd_4046be);
            ((TextView) e(R$id.chat_topic_last_btn)).setBackgroundResource(R$drawable.rect_cor_22_sk_2fb5fa_w_2);
            e(R$id.chat_topic_send_btn).setBackgroundResource(R$drawable.chat_zodiac_elf_first_send_btn_bg);
            ((TextView) e(R$id.chat_topic_next_btn)).setBackgroundResource(R$drawable.rect_cor_22_sk_2fb5fa_w_2);
        } else if (i10 == 1) {
            ((ConstraintLayout) e(R$id.chat_topic_root_layout)).setBackgroundResource(R$drawable.chat_zodiac_elf_second_big_bg);
            ((ConstraintLayout) e(i11)).setBackgroundResource(R$drawable.rect_cor_15_sd_882977);
            ((TextView) e(R$id.chat_topic_last_btn)).setBackgroundResource(R$drawable.rect_cor_22_sk_f2d79a_w_2);
            e(R$id.chat_topic_send_btn).setBackgroundResource(R$drawable.chat_zodiac_elf_second_send_btn_bg);
            ((TextView) e(R$id.chat_topic_next_btn)).setBackgroundResource(R$drawable.rect_cor_22_sk_f2d79a_w_2);
        } else if (i10 == 2) {
            ((ConstraintLayout) e(R$id.chat_topic_root_layout)).setBackgroundResource(R$drawable.chat_zodiac_elf_third_big_bg);
            ((ConstraintLayout) e(i11)).setBackgroundResource(R$drawable.rect_cor_15_sd_682997);
            ((TextView) e(R$id.chat_topic_last_btn)).setBackgroundResource(R$drawable.rect_cor_22_sk_bf7dff_w_2);
            e(R$id.chat_topic_send_btn).setBackgroundResource(R$drawable.chat_zodiac_elf_third_send_btn_bg);
            ((TextView) e(R$id.chat_topic_next_btn)).setBackgroundResource(R$drawable.rect_cor_22_sk_bf7dff_w_2);
        }
        int i12 = R$id.chat_topic_last_btn;
        ((TextView) e(i12)).setTextColor(-1);
        ((TextView) e(i12)).setAlpha(z10 ? 0.4f : 1.0f);
        int i13 = R$id.chat_topic_next_btn;
        ((TextView) e(i13)).setTextColor(-1);
        ((TextView) e(i13)).setAlpha(1.0f);
        ((TextView) e(R$id.zodiac_elf_question_title_text)).setText(zodiacElfInfoModel.getTitle());
        ((TextView) e(R$id.zodiac_elf_question_content_text)).setText(zodiacElfInfoModel.getSubTitle());
        this.f13456g = zodiacElfInfoModel.getSubTitle();
    }

    public final void r(@NotNull List<ZodiacElfInfoModel> list) {
        s.i(list, "list");
        if (!this.f13454e.isEmpty()) {
            return;
        }
        this.f13454e.addAll(list);
        this.f13455f = -1;
        p(true);
    }

    public final void s() {
        z.a(this, R$layout.layout_chat_topic, true);
        l();
    }

    public final void setListener(@NotNull j listener) {
        s.i(listener, "listener");
        this.f13457h = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatTopicLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13458i = new LinkedHashMap();
        this.f13453d = new ArrayList();
        this.f13454e = new ArrayList();
        this.f13455f = -1;
        s();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatTopicLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13458i = new LinkedHashMap();
        this.f13453d = new ArrayList();
        this.f13454e = new ArrayList();
        this.f13455f = -1;
        s();
    }
}
