package com.cupidapp.live.chat2.view;

import android.animation.Animator;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.dialog.BgColor;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.dialog.FKPointerDialog;
import com.cupidapp.live.base.view.dialog.PointerPos;
import com.cupidapp.live.chat2.model.ChatEditLeftBtn;
import com.cupidapp.live.chat2.model.ChatEditRightBtn;
import com.cupidapp.live.chat2.model.ChatPanelType;
import com.cupidapp.live.chat2.model.ChatTextType;
import com.cupidapp.live.profile.model.User;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ChatDetailInputPanelLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatDetailInputPanelLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public User f13414b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public ChatEditLeftBtn f13415c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public ChatEditRightBtn f13416d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public f f13417e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public ChatPanelType f13418f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13419g;

    /* renamed from: h, reason: collision with root package name */
    public ChatDetailTitleLayout f13420h;

    /* renamed from: i, reason: collision with root package name */
    public RecyclerView f13421i;

    /* renamed from: j, reason: collision with root package name */
    public ChatDetailTipsLayout f13422j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public ChatEmojiPagerLayout f13423k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public FrameLayout f13424l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public ChatTopicLayout f13425m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public FKSVGAImageView f13426n;

    /* renamed from: o, reason: collision with root package name */
    public int f13427o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public FKPointerDialog f13428p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13429q;

    /* compiled from: ChatDetailInputPanelLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13430a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f13431b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f13432c;

        static {
            int[] iArr = new int[ChatEditLeftBtn.values().length];
            try {
                iArr[ChatEditLeftBtn.EMOJI_BTN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChatEditLeftBtn.LEFT_KEYBOARD_BTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f13430a = iArr;
            int[] iArr2 = new int[ChatEditRightBtn.values().length];
            try {
                iArr2[ChatEditRightBtn.TOPIC_BTN.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ChatEditRightBtn.RIGHT_KEYBOARD_BTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ChatEditRightBtn.SEND_BTN.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f13431b = iArr2;
            int[] iArr3 = new int[ChatPanelType.values().length];
            try {
                iArr3[ChatPanelType.SOFT_KEYBOARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[ChatPanelType.CHAT_TOPIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[ChatPanelType.CHAT_EMOJI.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ChatPanelType.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            f13432c = iArr3;
        }
    }

    /* compiled from: ChatDetailInputPanelLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements i {

        /* compiled from: ChatDetailInputPanelLayout.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f13434a;

            static {
                int[] iArr = new int[ChatEmojiType.values().length];
                try {
                    iArr[ChatEmojiType.SYSTEM.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ChatEmojiType.CUSTOM.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f13434a = iArr;
            }
        }

        public b() {
        }

        @Override // com.cupidapp.live.chat2.view.i
        public void a(@NotNull ChatEmojiType type, @NotNull String textMessage) {
            s.i(type, "type");
            s.i(textMessage, "textMessage");
            int i10 = a.f13434a[type.ordinal()];
            if (i10 == 1) {
                ChatDetailInputPanelLayout.n(ChatDetailInputPanelLayout.this, textMessage, false, 2, null);
            } else {
                if (i10 != 2) {
                    return;
                }
                ChatDetailInputPanelLayout.q(ChatDetailInputPanelLayout.this, false, textMessage, null, 4, null);
            }
        }
    }

    /* compiled from: ChatDetailInputPanelLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements j {
        public c() {
        }

        @Override // com.cupidapp.live.chat2.view.j
        public void a(@NotNull String textMessage) {
            s.i(textMessage, "textMessage");
            ChatDetailInputPanelLayout.this.p(false, textMessage, ChatTextType.CHAT_TOPIC);
        }
    }

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            if (editable == null || editable.length() == 0) {
                ChatDetailInputPanelLayout.this.s(ChatEditRightBtn.TOPIC_BTN);
                ((ImageView) ChatDetailInputPanelLayout.this.f(R$id.detail_open_album_btn)).setVisibility(0);
            } else {
                ChatDetailInputPanelLayout.this.s(ChatEditRightBtn.SEND_BTN);
                ((ImageView) ChatDetailInputPanelLayout.this.f(R$id.detail_open_album_btn)).setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* compiled from: Animator.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
            f fVar = ChatDetailInputPanelLayout.this.f13417e;
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatDetailInputPanelLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13429q = new LinkedHashMap();
        this.f13415c = ChatEditLeftBtn.EMOJI_BTN;
        this.f13416d = ChatEditRightBtn.TOPIC_BTN;
        this.f13418f = ChatPanelType.NONE;
        F();
    }

    public static /* synthetic */ void A(ChatDetailInputPanelLayout chatDetailInputPanelLayout, ChatPanelType chatPanelType, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        chatDetailInputPanelLayout.z(chatPanelType, i10, i11);
    }

    public static /* synthetic */ void D(ChatDetailInputPanelLayout chatDetailInputPanelLayout, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        chatDetailInputPanelLayout.C(z10);
    }

    public static final void P(ChatDetailInputPanelLayout this$0) {
        s.i(this$0, "this$0");
        p1.g.f52734a.k3(Boolean.FALSE);
        FKPointerDialog.a aVar = FKPointerDialog.f12718p;
        Context context = this$0.getContext();
        s.h(context, "context");
        FKPointerDialog a10 = aVar.a(context);
        String string = this$0.getContext().getString(R$string.find_something_interesting_to_talk_about);
        s.h(string, "context.getString(R.stri…nteresting_to_talk_about)");
        FKPointerDialog j10 = a10.n(string).q(PointerPos.BOTTOM_CENTER, BgColor.DEFAULT).m(true).j(Float.valueOf(0.0f));
        this$0.f13428p = j10;
        if (j10 != null) {
            FKPointerDialog.E(j10, (ImageView) this$0.f(R$id.detail_edit_right_btn), 0, z0.h.c(this$0, 6.0f), 0, null, 26, null);
        }
    }

    public static final void R(ChatDetailInputPanelLayout this$0) {
        s.i(this$0, "this$0");
        ChatDetailTipsLayout chatDetailTipsLayout = this$0.f13422j;
        RecyclerView recyclerView = null;
        if (chatDetailTipsLayout == null) {
            s.A("mTipsLayout");
            chatDetailTipsLayout = null;
        }
        float y10 = chatDetailTipsLayout.getY();
        RecyclerView recyclerView2 = this$0.f13421i;
        if (recyclerView2 == null) {
            s.A("mRecyclerView");
            recyclerView2 = null;
        }
        float y11 = recyclerView2.getY();
        RecyclerView recyclerView3 = this$0.f13421i;
        if (recyclerView3 == null) {
            s.A("mRecyclerView");
            recyclerView3 = null;
        }
        float height = y10 - (y11 + recyclerView3.getHeight());
        if (height < 0.0f) {
            RecyclerView recyclerView4 = this$0.f13421i;
            if (recyclerView4 == null) {
                s.A("mRecyclerView");
            } else {
                recyclerView = recyclerView4;
            }
            recyclerView.setTranslationY(recyclerView.getTranslationY() + height);
        }
    }

    public static /* synthetic */ void n(ChatDetailInputPanelLayout chatDetailInputPanelLayout, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        chatDetailInputPanelLayout.m(str, z10);
    }

    public static /* synthetic */ void q(ChatDetailInputPanelLayout chatDetailInputPanelLayout, boolean z10, String str, ChatTextType chatTextType, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            chatTextType = null;
        }
        chatDetailInputPanelLayout.p(z10, str, chatTextType);
    }

    public static final boolean u(ChatDetailInputPanelLayout this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        view.performClick();
        if (motionEvent.getAction() != 1 || this$0.f13419g) {
            return false;
        }
        this$0.M(ChatPanelType.SOFT_KEYBOARD);
        return false;
    }

    public static final boolean v(ChatDetailInputPanelLayout this$0, TextView textView, int i10, KeyEvent keyEvent) {
        s.i(this$0, "this$0");
        if (i10 != 4) {
            return true;
        }
        q(this$0, false, null, null, 6, null);
        return true;
    }

    public static final void w(ChatDetailInputPanelLayout this$0, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18;
        s.i(this$0, "this$0");
        if ((i14 == 0 && i15 == 0 && i16 == 0 && i17 == 0) || (i18 = i17 - i13) == 0) {
            return;
        }
        RecyclerView recyclerView = null;
        if (i18 < 0) {
            RecyclerView recyclerView2 = this$0.f13421i;
            if (recyclerView2 == null) {
                s.A("mRecyclerView");
                recyclerView2 = null;
            }
            float y10 = recyclerView2.getY();
            RecyclerView recyclerView3 = this$0.f13421i;
            if (recyclerView3 == null) {
                s.A("mRecyclerView");
                recyclerView3 = null;
            }
            float height = y10 + recyclerView3.getHeight();
            ChatDetailTipsLayout chatDetailTipsLayout = this$0.f13422j;
            if (chatDetailTipsLayout == null) {
                s.A("mTipsLayout");
                chatDetailTipsLayout = null;
            }
            if (height > chatDetailTipsLayout.getY()) {
                this$0.f13427o += i18;
                RecyclerView recyclerView4 = this$0.f13421i;
                if (recyclerView4 == null) {
                    s.A("mRecyclerView");
                } else {
                    recyclerView = recyclerView4;
                }
                recyclerView.setTranslationY(recyclerView.getTranslationY() + i18);
            }
            f fVar = this$0.f13417e;
            if (fVar != null) {
                fVar.b();
                return;
            }
            return;
        }
        if (this$0.f13427o < 0) {
            ChatDetailTitleLayout chatDetailTitleLayout = this$0.f13420h;
            if (chatDetailTitleLayout == null) {
                s.A("mTitleLayout");
                chatDetailTitleLayout = null;
            }
            float y11 = chatDetailTitleLayout.getY();
            ChatDetailTitleLayout chatDetailTitleLayout2 = this$0.f13420h;
            if (chatDetailTitleLayout2 == null) {
                s.A("mTitleLayout");
                chatDetailTitleLayout2 = null;
            }
            float height2 = y11 + chatDetailTitleLayout2.getHeight();
            RecyclerView recyclerView5 = this$0.f13421i;
            if (recyclerView5 == null) {
                s.A("mRecyclerView");
                recyclerView5 = null;
            }
            float min = Math.min(height2 - recyclerView5.getY(), i18);
            this$0.f13427o += (int) min;
            RecyclerView recyclerView6 = this$0.f13421i;
            if (recyclerView6 == null) {
                s.A("mRecyclerView");
            } else {
                recyclerView = recyclerView6;
            }
            recyclerView.setTranslationY(recyclerView.getTranslationY() + min);
        }
        f fVar2 = this$0.f13417e;
        if (fVar2 != null) {
            fVar2.b();
        }
    }

    public final void B() {
        FKPointerDialog fKPointerDialog = this.f13428p;
        if (fKPointerDialog != null) {
            fKPointerDialog.g(false);
        }
        this.f13428p = null;
    }

    public final void C(boolean z10) {
        EditText editText = (EditText) f(R$id.detail_edit_text);
        if (z10) {
            ViewParent parent = editText.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.setFocusable(true);
                viewGroup.setFocusableInTouchMode(true);
                requestFocus();
            }
        } else {
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
        }
        Context context = getContext();
        s.h(context, "context");
        z0.h.p(context, editText);
    }

    public final void E(@NotNull User otherUser, @NotNull ChatDetailTitleLayout titleLayout, @NotNull RecyclerView recyclerView, @NotNull ChatDetailTipsLayout tipsLayout, @NotNull ChatEmojiPagerLayout emojiLayout, @NotNull FrameLayout topicParentLayout, @NotNull ChatTopicLayout topicLayout, @NotNull FKSVGAImageView svgaImg) {
        s.i(otherUser, "otherUser");
        s.i(titleLayout, "titleLayout");
        s.i(recyclerView, "recyclerView");
        s.i(tipsLayout, "tipsLayout");
        s.i(emojiLayout, "emojiLayout");
        s.i(topicParentLayout, "topicParentLayout");
        s.i(topicLayout, "topicLayout");
        s.i(svgaImg, "svgaImg");
        this.f13414b = otherUser;
        this.f13420h = titleLayout;
        this.f13421i = recyclerView;
        this.f13422j = tipsLayout;
        this.f13423k = emojiLayout;
        this.f13424l = topicParentLayout;
        this.f13425m = topicLayout;
        this.f13426n = svgaImg;
        boolean a10 = ChatDetailTitleLayout.f13442d.a(otherUser.userId());
        x(a10);
        if (a10) {
            return;
        }
        t();
        o();
        O();
    }

    public final void F() {
        z.a(this, R$layout.layout_chat_detail_input_panel, true);
    }

    public final boolean G(ChatPanelType chatPanelType) {
        return chatPanelType == ChatPanelType.SOFT_KEYBOARD || chatPanelType == ChatPanelType.CHAT_TOPIC || chatPanelType == ChatPanelType.CHAT_EMOJI;
    }

    public final boolean H() {
        ChatPanelType chatPanelType = this.f13418f;
        ChatPanelType chatPanelType2 = ChatPanelType.NONE;
        if (chatPanelType == chatPanelType2) {
            return false;
        }
        M(chatPanelType2);
        return true;
    }

    public final void I(int i10, int i11) {
        z(ChatPanelType.SOFT_KEYBOARD, i10, i11);
        y();
    }

    public final void J() {
        this.f13419g = false;
        if (this.f13418f == ChatPanelType.SOFT_KEYBOARD) {
            M(ChatPanelType.NONE);
        }
    }

    public final void K() {
        this.f13419g = true;
    }

    public final void L() {
        M(ChatPanelType.NONE);
    }

    public final void M(@NotNull ChatPanelType type) {
        s.i(type, "type");
        if (type != ChatPanelType.NONE) {
            B();
        }
        int i10 = a.f13432c[type.ordinal()];
        boolean z10 = true;
        if (i10 == 1) {
            r(ChatEditLeftBtn.EMOJI_BTN);
            int i11 = R$id.detail_edit_text;
            Editable text = ((EditText) f(i11)).getText();
            if (text != null && text.length() != 0) {
                z10 = false;
            }
            if (z10) {
                s(ChatEditRightBtn.TOPIC_BTN);
            } else {
                s(ChatEditRightBtn.SEND_BTN);
            }
            Context context = getContext();
            s.h(context, "context");
            EditText detail_edit_text = (EditText) f(i11);
            s.h(detail_edit_text, "detail_edit_text");
            z0.h.v(context, detail_edit_text);
            FrameLayout frameLayout = this.f13424l;
            if (frameLayout != null) {
                frameLayout.setVisibility(4);
            }
            ChatEmojiPagerLayout chatEmojiPagerLayout = this.f13423k;
            if (chatEmojiPagerLayout != null) {
                chatEmojiPagerLayout.setVisibility(4);
            }
        } else if (i10 == 2) {
            s(ChatEditRightBtn.RIGHT_KEYBOARD_BTN);
            if (this.f13415c == ChatEditLeftBtn.LEFT_KEYBOARD_BTN) {
                r(ChatEditLeftBtn.EMOJI_BTN);
            }
            D(this, false, 1, null);
            FrameLayout frameLayout2 = this.f13424l;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            ChatEmojiPagerLayout chatEmojiPagerLayout2 = this.f13423k;
            if (chatEmojiPagerLayout2 != null) {
                chatEmojiPagerLayout2.setVisibility(8);
            }
            ChatTopicLayout chatTopicLayout = this.f13425m;
            if (chatTopicLayout != null) {
                chatTopicLayout.m();
            }
        } else if (i10 == 3) {
            r(ChatEditLeftBtn.LEFT_KEYBOARD_BTN);
            if (this.f13416d == ChatEditRightBtn.RIGHT_KEYBOARD_BTN) {
                s(ChatEditRightBtn.TOPIC_BTN);
            }
            C(false);
            FrameLayout frameLayout3 = this.f13424l;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(8);
            }
            ChatEmojiPagerLayout chatEmojiPagerLayout3 = this.f13423k;
            if (chatEmojiPagerLayout3 != null) {
                chatEmojiPagerLayout3.setVisibility(0);
            }
        } else if (i10 == 4) {
            r(ChatEditLeftBtn.EMOJI_BTN);
            Editable text2 = ((EditText) f(R$id.detail_edit_text)).getText();
            if (text2 == null || text2.length() == 0) {
                s(ChatEditRightBtn.TOPIC_BTN);
            } else {
                s(ChatEditRightBtn.SEND_BTN);
            }
            D(this, false, 1, null);
            FrameLayout frameLayout4 = this.f13424l;
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(8);
            }
            ChatEmojiPagerLayout chatEmojiPagerLayout4 = this.f13423k;
            if (chatEmojiPagerLayout4 != null) {
                chatEmojiPagerLayout4.setVisibility(8);
            }
        }
        A(this, type, 0, 0, 6, null);
    }

    public final void N(@NotNull User otherUser) {
        s.i(otherUser, "otherUser");
        this.f13414b = otherUser;
    }

    public final void O() {
        if (s.d(p1.g.f52734a.T0(), Boolean.FALSE)) {
            return;
        }
        ((ImageView) f(R$id.detail_edit_right_btn)).post(new Runnable() { // from class: com.cupidapp.live.chat2.view.d
            @Override // java.lang.Runnable
            public final void run() {
                ChatDetailInputPanelLayout.P(ChatDetailInputPanelLayout.this);
            }
        });
    }

    public final void Q() {
        RecyclerView recyclerView = this.f13421i;
        if (recyclerView == null) {
            s.A("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.post(new Runnable() { // from class: com.cupidapp.live.chat2.view.e
            @Override // java.lang.Runnable
            public final void run() {
                ChatDetailInputPanelLayout.R(ChatDetailInputPanelLayout.this);
            }
        });
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f13429q;
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

    public final void m(@Nullable String str, boolean z10) {
        if (str == null || str.length() == 0) {
            return;
        }
        int i10 = R$id.detail_edit_text;
        ((EditText) f(i10)).getText().insert(((EditText) f(i10)).getSelectionStart(), str);
        if (z10) {
            M(ChatPanelType.SOFT_KEYBOARD);
        }
    }

    public final void o() {
        ImageView detail_edit_left_btn = (ImageView) f(R$id.detail_edit_left_btn);
        s.h(detail_edit_left_btn, "detail_edit_left_btn");
        y.d(detail_edit_left_btn, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatDetailInputPanelLayout$bindClickEvent$1

            /* compiled from: ChatDetailInputPanelLayout.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f13435a;

                static {
                    int[] iArr = new int[ChatEditLeftBtn.values().length];
                    try {
                        iArr[ChatEditLeftBtn.EMOJI_BTN.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ChatEditLeftBtn.LEFT_KEYBOARD_BTN.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f13435a = iArr;
                }
            }

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
                ChatEditLeftBtn chatEditLeftBtn;
                chatEditLeftBtn = ChatDetailInputPanelLayout.this.f13415c;
                int i10 = a.f13435a[chatEditLeftBtn.ordinal()];
                if (i10 == 1) {
                    SensorsLogKeyButtonClick.MessageDetail.EMOJI.click();
                    ChatDetailInputPanelLayout.this.M(ChatPanelType.CHAT_EMOJI);
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    ChatDetailInputPanelLayout.this.M(ChatPanelType.SOFT_KEYBOARD);
                }
            }
        });
        ImageView detail_edit_right_btn = (ImageView) f(R$id.detail_edit_right_btn);
        s.h(detail_edit_right_btn, "detail_edit_right_btn");
        y.d(detail_edit_right_btn, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatDetailInputPanelLayout$bindClickEvent$2

            /* compiled from: ChatDetailInputPanelLayout.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f13436a;

                static {
                    int[] iArr = new int[ChatEditRightBtn.values().length];
                    try {
                        iArr[ChatEditRightBtn.TOPIC_BTN.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ChatEditRightBtn.RIGHT_KEYBOARD_BTN.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ChatEditRightBtn.SEND_BTN.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f13436a = iArr;
                }
            }

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
                ChatEditRightBtn chatEditRightBtn;
                chatEditRightBtn = ChatDetailInputPanelLayout.this.f13416d;
                int i10 = a.f13436a[chatEditRightBtn.ordinal()];
                if (i10 == 1) {
                    SensorsLogKeyButtonClick.MessageDetail.TOPIC.click();
                    ChatDetailInputPanelLayout.this.M(ChatPanelType.CHAT_TOPIC);
                } else if (i10 == 2) {
                    ChatDetailInputPanelLayout.this.M(ChatPanelType.SOFT_KEYBOARD);
                } else {
                    if (i10 != 3) {
                        return;
                    }
                    ChatDetailInputPanelLayout.q(ChatDetailInputPanelLayout.this, false, null, null, 6, null);
                }
            }
        });
        ImageView detail_open_album_btn = (ImageView) f(R$id.detail_open_album_btn);
        s.h(detail_open_album_btn, "detail_open_album_btn");
        y.d(detail_open_album_btn, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatDetailInputPanelLayout$bindClickEvent$3
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
                ChatDetailInputPanelLayout.this.B();
                ChatDetailInputPanelLayout.q(ChatDetailInputPanelLayout.this, true, null, null, 6, null);
            }
        });
        ChatEmojiPagerLayout chatEmojiPagerLayout = this.f13423k;
        if (chatEmojiPagerLayout != null) {
            chatEmojiPagerLayout.setChatEmojiPagerListener(new b());
        }
        ChatTopicLayout chatTopicLayout = this.f13425m;
        if (chatTopicLayout != null) {
            chatTopicLayout.setListener(new c());
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NotNull View changedView, int i10) {
        s.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, i10);
        if (i10 != 0) {
            B();
        }
    }

    public final void p(boolean z10, String str, ChatTextType chatTextType) {
        User user = this.f13414b;
        boolean z11 = true;
        if (user != null && user.getBlock()) {
            FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.you_blacklisted_the_other_person, 0, 2, null), 0, null, null, 7, null), null, 1, null);
            return;
        }
        if (str == null || str.length() == 0) {
            str = StringsKt__StringsKt.P0(((EditText) f(R$id.detail_edit_text)).getText().toString()).toString();
        } else {
            z11 = false;
        }
        f fVar = this.f13417e;
        if (fVar != null) {
            fVar.c(z10, str, chatTextType);
        }
        if (z11) {
            ((EditText) f(R$id.detail_edit_text)).getText().clear();
        }
    }

    public final void r(ChatEditLeftBtn chatEditLeftBtn) {
        int i10;
        this.f13415c = chatEditLeftBtn;
        int i11 = a.f13430a[chatEditLeftBtn.ordinal()];
        if (i11 == 1) {
            i10 = R$mipmap.icon_chat_detail_emoji;
        } else {
            if (i11 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i10 = R$mipmap.icon_chat_detail_soft_keyboard;
        }
        ((ImageView) f(R$id.detail_edit_left_btn)).setImageResource(i10);
    }

    public final void s(ChatEditRightBtn chatEditRightBtn) {
        int i10;
        this.f13416d = chatEditRightBtn;
        int i11 = a.f13431b[chatEditRightBtn.ordinal()];
        if (i11 == 1) {
            i10 = R$mipmap.icon_chat_detail_chat_topic;
        } else if (i11 == 2) {
            i10 = R$mipmap.icon_chat_detail_soft_keyboard;
        } else {
            if (i11 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i10 = R$mipmap.icon_chat_detail_send_message;
        }
        ((ImageView) f(R$id.detail_edit_right_btn)).setImageResource(i10);
    }

    public final void setListener(@NotNull f listener) {
        s.i(listener, "listener");
        this.f13417e = listener;
    }

    public final void t() {
        y();
        int i10 = R$id.detail_edit_text;
        ((EditText) f(i10)).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.chat2.view.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean u10;
                u10 = ChatDetailInputPanelLayout.u(ChatDetailInputPanelLayout.this, view, motionEvent);
                return u10;
            }
        });
        EditText detail_edit_text = (EditText) f(i10);
        s.h(detail_edit_text, "detail_edit_text");
        detail_edit_text.addTextChangedListener(new d());
        EditText editText = (EditText) f(i10);
        editText.setInputType(262144);
        editText.setSingleLine(false);
        editText.setMaxLines(4);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.cupidapp.live.chat2.view.c
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                boolean v2;
                v2 = ChatDetailInputPanelLayout.v(ChatDetailInputPanelLayout.this, textView, i11, keyEvent);
                return v2;
            }
        });
        ((EditText) f(i10)).addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.cupidapp.live.chat2.view.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                ChatDetailInputPanelLayout.w(ChatDetailInputPanelLayout.this, view, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        });
    }

    public final void x(boolean z10) {
        if (z10) {
            ((ConstraintLayout) f(R$id.detail_chat_edit_parent_layout)).setVisibility(8);
            int i10 = R$id.detail_chat_feed_back_btn;
            ((TextView) f(i10)).setVisibility(0);
            TextView detail_chat_feed_back_btn = (TextView) f(i10);
            s.h(detail_chat_feed_back_btn, "detail_chat_feed_back_btn");
            y.d(detail_chat_feed_back_btn, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatDetailInputPanelLayout$configFeedBackBtnUi$1
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
                    ConstantsUrlModel urlModel;
                    j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                    Context context = ChatDetailInputPanelLayout.this.getContext();
                    ConstantsResult q10 = p1.g.f52734a.q();
                    j.a.b(aVar, context, (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getUrlUserFeedBack(), null, 4, null);
                }
            });
        } else {
            ((ConstraintLayout) f(R$id.detail_chat_edit_parent_layout)).setVisibility(0);
            ((TextView) f(R$id.detail_chat_feed_back_btn)).setVisibility(8);
        }
        FrameLayout frameLayout = this.f13424l;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        ChatEmojiPagerLayout chatEmojiPagerLayout = this.f13423k;
        if (chatEmojiPagerLayout == null) {
            return;
        }
        chatEmojiPagerLayout.setVisibility(8);
    }

    public final void y() {
        FrameLayout frameLayout = this.f13424l;
        if (frameLayout != null) {
            y.o(frameLayout, null, Integer.valueOf(p1.g.f52734a.a0()), 1, null);
        }
        ChatEmojiPagerLayout chatEmojiPagerLayout = this.f13423k;
        if (chatEmojiPagerLayout != null) {
            y.o(chatEmojiPagerLayout, null, Integer.valueOf(p1.g.f52734a.a0()), 1, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x017a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void z(com.cupidapp.live.chat2.model.ChatPanelType r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.chat2.view.ChatDetailInputPanelLayout.z(com.cupidapp.live.chat2.model.ChatPanelType, int, int):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatDetailInputPanelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13429q = new LinkedHashMap();
        this.f13415c = ChatEditLeftBtn.EMOJI_BTN;
        this.f13416d = ChatEditRightBtn.TOPIC_BTN;
        this.f13418f = ChatPanelType.NONE;
        F();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatDetailInputPanelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13429q = new LinkedHashMap();
        this.f13415c = ChatEditLeftBtn.EMOJI_BTN;
        this.f13416d = ChatEditRightBtn.TOPIC_BTN;
        this.f13418f = ChatPanelType.NONE;
        F();
    }
}
