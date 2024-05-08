package com.cupidapp.live.maskparty.view;

import android.app.AlertDialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.BubbleGuideModel;
import com.cupidapp.live.base.view.FKPopupWindowBubbleGuideView;
import com.cupidapp.live.chat.view.QuickExpressionLayout;
import com.cupidapp.live.maskparty.model.MessageActionType;
import com.google.android.material.badge.BadgeDrawable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: MaskPartyChatBottomLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatBottomLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public c f16380b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public FKPopupWindowBubbleGuideView f16381c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16382d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public MessageActionType f16383e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16384f;

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            c cVar;
            if (editable == null || editable.length() == 0) {
                ((ImageView) MaskPartyChatBottomLayout.this.c(R$id.mask_party_chat_send_message_img)).setVisibility(8);
                ((ImageView) MaskPartyChatBottomLayout.this.c(R$id.mask_party_chat_open_album_img)).setVisibility(0);
                return;
            }
            ((ImageView) MaskPartyChatBottomLayout.this.c(R$id.mask_party_chat_send_message_img)).setVisibility(0);
            ((ImageView) MaskPartyChatBottomLayout.this.c(R$id.mask_party_chat_open_album_img)).setVisibility(8);
            if (MaskPartyChatBottomLayout.this.f16382d || (cVar = MaskPartyChatBottomLayout.this.f16380b) == null) {
                return;
            }
            cVar.b();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatBottomLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16384f = new LinkedHashMap();
        this.f16383e = MessageActionType.Ordinary;
        n();
    }

    public static final boolean i(MaskPartyChatBottomLayout this$0, TextView textView, int i10, KeyEvent keyEvent) {
        s.i(this$0, "this$0");
        if (i10 != 4) {
            return true;
        }
        this$0.p();
        return true;
    }

    public static final void s(MaskPartyChatBottomLayout this$0, int i10) {
        s.i(this$0, "this$0");
        int[] iArr = new int[2];
        ((ImageView) this$0.c(R$id.mask_party_chat_send_message_img)).getLocationInWindow(iArr);
        this$0.k(i10, iArr[1]);
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f16384f;
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
        ImageView mask_party_chat_send_message_img = (ImageView) c(R$id.mask_party_chat_send_message_img);
        s.h(mask_party_chat_send_message_img, "mask_party_chat_send_message_img");
        y.d(mask_party_chat_send_message_img, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyChatBottomLayout$bindClickEvent$1
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
                MaskPartyChatBottomLayout.this.p();
            }
        });
        ImageView mask_party_chat_open_album_img = (ImageView) c(R$id.mask_party_chat_open_album_img);
        s.h(mask_party_chat_open_album_img, "mask_party_chat_open_album_img");
        y.d(mask_party_chat_open_album_img, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyChatBottomLayout$bindClickEvent$2
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
                c cVar = MaskPartyChatBottomLayout.this.f16380b;
                if (cVar != null) {
                    cVar.a();
                }
            }
        });
    }

    public final void h() {
        int i10 = R$id.mask_party_chat_edit_text;
        EditText mask_party_chat_edit_text = (EditText) c(i10);
        s.h(mask_party_chat_edit_text, "mask_party_chat_edit_text");
        mask_party_chat_edit_text.addTextChangedListener(new a());
        EditText editText = (EditText) c(i10);
        editText.setInputType(262144);
        editText.setSingleLine(false);
        editText.setMaxLines(4);
        ((EditText) c(i10)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.cupidapp.live.maskparty.view.d
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                boolean i12;
                i12 = MaskPartyChatBottomLayout.i(MaskPartyChatBottomLayout.this, textView, i11, keyEvent);
                return i12;
            }
        });
    }

    public final void j(@NotNull String message, @NotNull MessageActionType messageType, int i10) {
        s.i(message, "message");
        s.i(messageType, "messageType");
        this.f16382d = true;
        this.f16383e = messageType;
        int i11 = R$id.mask_party_chat_edit_text;
        ((EditText) c(i11)).setText(message);
        ((EditText) c(i11)).setEnabled(false);
        r(i10);
    }

    public final void k(int i10, int i11) {
        Context context = getContext();
        s.h(context, "context");
        FKPopupWindowBubbleGuideView fKPopupWindowBubbleGuideView = new FKPopupWindowBubbleGuideView(context);
        fKPopupWindowBubbleGuideView.c(new BubbleGuideModel(null, 0, Integer.valueOf(i10), 0, 11, null));
        this.f16381c = fKPopupWindowBubbleGuideView;
        fKPopupWindowBubbleGuideView.measure(View.MeasureSpec.makeMeasureSpec(z0.h.l(this), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(z0.h.k(this), Integer.MIN_VALUE));
        FKPopupWindowBubbleGuideView fKPopupWindowBubbleGuideView2 = this.f16381c;
        int measuredHeight = (i11 - (fKPopupWindowBubbleGuideView2 != null ? fKPopupWindowBubbleGuideView2.getMeasuredHeight() : 0)) + z0.h.c(this, 10.0f);
        FKPopupWindowBubbleGuideView fKPopupWindowBubbleGuideView3 = this.f16381c;
        if (fKPopupWindowBubbleGuideView3 != null) {
            fKPopupWindowBubbleGuideView3.e(this, BadgeDrawable.TOP_END, 0, measuredHeight, (r17 & 16) != 0 ? null : null, (r17 & 32) != 0 ? false : false, (r17 & 64) != 0 ? false : false);
        }
    }

    public final void l() {
        ((QuickExpressionLayout) c(R$id.mask_party_chat_expression_layout)).setItemClickListener(new Function1<String, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyChatBottomLayout$configQuickExpressUi$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str) {
                invoke2(str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                s.i(it, "it");
                if (MaskPartyChatBottomLayout.this.f16382d) {
                    return;
                }
                MaskPartyChatBottomLayout maskPartyChatBottomLayout = MaskPartyChatBottomLayout.this;
                int i10 = R$id.mask_party_chat_edit_text;
                ((EditText) maskPartyChatBottomLayout.c(i10)).getText().insert(((EditText) MaskPartyChatBottomLayout.this.c(i10)).getSelectionStart(), it);
            }
        });
    }

    public final void m() {
        FKPopupWindowBubbleGuideView fKPopupWindowBubbleGuideView = this.f16381c;
        if (fKPopupWindowBubbleGuideView != null) {
            fKPopupWindowBubbleGuideView.g();
        }
        this.f16381c = null;
    }

    public final void n() {
        z.a(this, R$layout.layout_mask_party_chat_bottom, true);
        h();
        l();
        g();
    }

    public final void o(@NotNull String message) {
        s.i(message, "message");
        this.f16383e = MessageActionType.Ordinary;
        int i10 = R$id.mask_party_chat_edit_text;
        ((EditText) c(i10)).getText().insert(((EditText) c(i10)).getSelectionStart(), message);
        Context context = getContext();
        s.h(context, "context");
        EditText mask_party_chat_edit_text = (EditText) c(i10);
        s.h(mask_party_chat_edit_text, "mask_party_chat_edit_text");
        z0.h.v(context, mask_party_chat_edit_text);
    }

    public final void p() {
        int i10 = R$id.mask_party_chat_edit_text;
        String obj = StringsKt__StringsKt.P0(((EditText) c(i10)).getText().toString()).toString();
        c cVar = this.f16380b;
        if (cVar != null) {
            cVar.c(obj, this.f16383e, this.f16382d);
        }
        ((EditText) c(i10)).getText().clear();
        ((EditText) c(i10)).setEnabled(true);
        this.f16383e = MessageActionType.Ordinary;
        if (this.f16382d) {
            m();
            this.f16382d = false;
        }
    }

    public final void q() {
        final AlertDialog g3;
        int i10 = R$id.mask_party_chat_open_album_img;
        if (((ImageView) c(i10)).getVisibility() != 0) {
            return;
        }
        p1.g gVar = p1.g.f52734a;
        if (s.d(gVar.i0(), Boolean.TRUE)) {
            gVar.L2(Boolean.FALSE);
            View contentView = LayoutInflater.from(getContext()).inflate(R$layout.layout_mask_party_send_image_guide, (ViewGroup) null, false);
            ((TextView) contentView.findViewById(R$id.mask_party_guide_text)).getPaint().setFakeBoldText(true);
            contentView.measure(View.MeasureSpec.makeMeasureSpec(z0.h.l(this), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(z0.h.k(this), Integer.MIN_VALUE));
            int[] iArr = new int[2];
            ((ImageView) c(i10)).getLocationInWindow(iArr);
            int measuredHeight = ((iArr[1] - contentView.getMeasuredHeight()) - z0.h.m(getContext())) + z0.h.c(this, 40.0f);
            z0.b bVar = z0.b.f54812a;
            Context context = getContext();
            s.h(context, "context");
            s.h(contentView, "contentView");
            g3 = bVar.g(context, contentView, 0, measuredHeight, -2, -2, (r32 & 64) != 0 ? 17 : 48, (r32 & 128) != 0 ? null : Float.valueOf(0.5f), (r32 & 256) != 0 ? null : null, (r32 & 512) != 0 ? null : null, (r32 & 1024) != 0 ? null : null, (r32 & 2048) != 0 ? null : null, (r32 & 4096) != 0 ? null : null, (r32 & 8192) != 0 ? null : null);
            y.d(contentView, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyChatBottomLayout$showSendImageGuide$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    g3.dismiss();
                }
            });
        }
    }

    public final void r(final int i10) {
        post(new Runnable() { // from class: com.cupidapp.live.maskparty.view.e
            @Override // java.lang.Runnable
            public final void run() {
                MaskPartyChatBottomLayout.s(MaskPartyChatBottomLayout.this, i10);
            }
        });
    }

    public final void setCallback(@NotNull c callback) {
        s.i(callback, "callback");
        this.f16380b = callback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatBottomLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16384f = new LinkedHashMap();
        this.f16383e = MessageActionType.Ordinary;
        n();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatBottomLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16384f = new LinkedHashMap();
        this.f16383e = MessageActionType.Ordinary;
        n();
    }
}
