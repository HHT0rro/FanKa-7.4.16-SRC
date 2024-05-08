package com.cupidapp.live.maskparty.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.view.m;
import com.cupidapp.live.track.group.GroupOthersLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.r;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: MaskPartyChatPromptLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatPromptLayout extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f16388f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f16389b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.utils.i f16390c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public f f16391d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16392e;

    /* compiled from: MaskPartyChatPromptLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @Nullable Integer num, @NotNull f listener) {
            s.i(listener, "listener");
            if (context == null) {
                return;
            }
            MaskPartyChatPromptLayout maskPartyChatPromptLayout = new MaskPartyChatPromptLayout(context);
            PromptType promptType = PromptType.HangUp;
            String string = context.getString(R$string.still_there);
            String string2 = context.getString(R$string.hang_up_prompt);
            s.h(string2, "context.getString(R.string.hang_up_prompt)");
            maskPartyChatPromptLayout.f(new ChatPromptModel(promptType, string, string2, R$mipmap.icon_still_there, null, null, num), listener);
            GroupOthersLog.a0(GroupOthersLog.f18702a, "MASK_PARTY_HANG_UP", SensorPosition.ChatRoom.getValue(), null, 4, null);
        }

        public final void b(@Nullable Context context, @NotNull String content) {
            s.i(content, "content");
            if (context == null) {
                return;
            }
            MaskPartyChatPromptLayout.g(new MaskPartyChatPromptLayout(context), new ChatPromptModel(PromptType.OpenAlbum, context.getString(R$string.open_album_prompt_title), content, R$mipmap.icon_awkward, kotlin.collections.s.m(context.getString(R$string.key_100), context.getString(R$string.key_continue_chat)), context.getString(R$string.continue_chat), null, 64, null), null, 2, null);
            GroupOthersLog.a0(GroupOthersLog.f18702a, "CAN_BIT_SEND_PHOTO", SensorPosition.ChatRoom.getValue(), null, 4, null);
        }

        public final void c(@Nullable Context context, @NotNull String content) {
            s.i(content, "content");
            if (context == null) {
                return;
            }
            MaskPartyChatPromptLayout.g(new MaskPartyChatPromptLayout(context), new ChatPromptModel(PromptType.OpenProfile, context.getString(R$string.open_profile_prompt_title), content, R$mipmap.icon_awkward, kotlin.collections.s.m(context.getString(R$string.key_100), context.getString(R$string.key_continue_chat)), context.getString(R$string.continue_chat), null, 64, null), null, 2, null);
            GroupOthersLog.a0(GroupOthersLog.f18702a, "CAN_NOT_SEE_PROFILE", SensorPosition.ChatRoom.getValue(), null, 4, null);
        }

        public final void d(@Nullable Context context) {
            if (context == null) {
                return;
            }
            MaskPartyChatPromptLayout maskPartyChatPromptLayout = new MaskPartyChatPromptLayout(context);
            PromptType promptType = PromptType.Shot;
            String string = context.getString(R$string.shot_prompt_content);
            s.h(string, "context.getString(R.string.shot_prompt_content)");
            MaskPartyChatPromptLayout.g(maskPartyChatPromptLayout, new ChatPromptModel(promptType, null, string, R$mipmap.icon_shot, r.e(context.getString(R$string.key_shot)), context.getString(R$string.i_know_it), null, 64, null), null, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatPromptLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16392e = new LinkedHashMap();
        e();
    }

    public static /* synthetic */ void g(MaskPartyChatPromptLayout maskPartyChatPromptLayout, ChatPromptModel chatPromptModel, f fVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            fVar = null;
        }
        maskPartyChatPromptLayout.f(chatPromptModel, fVar);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16392e;
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

    public final void e() {
        z.a(this, R$layout.layout_mask_party_chat_prompt, true);
        RoundedFrameLayout prompt_container_layout = (RoundedFrameLayout) a(R$id.prompt_container_layout);
        s.h(prompt_container_layout, "prompt_container_layout");
        m.a.d(prompt_container_layout, z0.h.c(this, 24.0f), 0.0f, z0.h.c(this, 24.0f), 0.0f, 10, null);
        TextView continue_chat_button = (TextView) a(R$id.continue_chat_button);
        s.h(continue_chat_button, "continue_chat_button");
        y.d(continue_chat_button, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyChatPromptLayout$initView$1
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
                AlertDialog alertDialog;
                com.cupidapp.live.base.utils.i iVar;
                f fVar;
                alertDialog = MaskPartyChatPromptLayout.this.f16389b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                iVar = MaskPartyChatPromptLayout.this.f16390c;
                if (iVar != null) {
                    iVar.g();
                }
                fVar = MaskPartyChatPromptLayout.this.f16391d;
                if (fVar != null) {
                    fVar.a();
                }
            }
        });
    }

    public final void f(@NotNull ChatPromptModel model, @Nullable final f fVar) {
        CharSequence h10;
        Window window;
        s.i(model, "model");
        this.f16391d = fVar;
        ((ImageView) a(R$id.top_icon_image)).setImageResource(model.getTopIcon());
        if (model.getTitle() != null) {
            int i10 = R$id.prompt_title_text;
            ((TextView) a(i10)).setVisibility(0);
            ((TextView) a(i10)).setText(model.getTitle());
        } else {
            ((TextView) a(R$id.prompt_title_text)).setVisibility(8);
        }
        TextView textView = (TextView) a(R$id.prompt_content_text);
        List<String> keys = model.getKeys();
        if (keys == null || keys.isEmpty()) {
            h10 = model.getContent();
        } else {
            q1.d dVar = q1.d.f53006a;
            String content = model.getContent();
            List<String> keys2 = model.getKeys();
            ArrayList arrayList = new ArrayList(t.t(keys2, 10));
            Iterator<String> iterator2 = keys2.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next());
            }
            h10 = dVar.h(content, arrayList, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? false : true);
        }
        textView.setText(h10);
        ((TextView) a(R$id.continue_chat_button)).setText(model.getButton());
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f16389b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog = this.f16389b;
        if (alertDialog != null) {
            z0.d.d(alertDialog, new Function0<p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyChatPromptLayout$showPromptDialog$2
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
                    f fVar2 = f.this;
                    if (fVar2 != null) {
                        fVar2.b();
                    }
                }
            });
        }
        AlertDialog alertDialog2 = this.f16389b;
        if (alertDialog2 != null) {
            alertDialog2.show();
        }
        AlertDialog alertDialog3 = this.f16389b;
        if (alertDialog3 != null && (window = alertDialog3.getWindow()) != null) {
            window.setDimAmount(0.5f);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
        if (model.getType() != PromptType.HangUp || model.getCountDown() == null) {
            return;
        }
        com.cupidapp.live.base.utils.i iVar = new com.cupidapp.live.base.utils.i();
        this.f16390c = iVar;
        iVar.c(model.getCountDown(), 1, new Function0<p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyChatPromptLayout$showPromptDialog$4
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
                AlertDialog alertDialog4;
                alertDialog4 = MaskPartyChatPromptLayout.this.f16389b;
                if (alertDialog4 != null) {
                    alertDialog4.dismiss();
                }
                f fVar2 = fVar;
                if (fVar2 != null) {
                    fVar2.b();
                }
            }
        }, new Function1<Integer, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyChatPromptLayout$showPromptDialog$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i11) {
                ((TextView) MaskPartyChatPromptLayout.this.a(R$id.continue_chat_button)).setText(MaskPartyChatPromptLayout.this.getContext().getString(R$string.still_here, Integer.valueOf(i11)));
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.cupidapp.live.base.utils.i iVar = this.f16390c;
        if (iVar != null) {
            iVar.g();
        }
        this.f16390c = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatPromptLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16392e = new LinkedHashMap();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatPromptLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16392e = new LinkedHashMap();
        e();
    }
}
