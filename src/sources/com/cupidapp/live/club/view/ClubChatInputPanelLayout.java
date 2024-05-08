package com.cupidapp.live.club.view;

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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.chat2.view.ChatEmojiPagerLayout;
import com.cupidapp.live.chat2.view.ChatEmojiType;
import com.cupidapp.live.club.dialog.ClubAtUserDialog;
import com.cupidapp.live.club.model.ClubCancelMsgData;
import com.cupidapp.live.club.model.ClubChatEditLeftBtn;
import com.cupidapp.live.club.model.ClubChatEditRightBtn;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import com.cupidapp.live.club.model.ClubChatPanelType;
import com.cupidapp.live.feed.layout.EditTextSelectable;
import com.cupidapp.live.mentionuser.model.ReplaceAtModel;
import com.cupidapp.live.profile.model.User;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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

/* compiled from: ClubChatInputPanelLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatInputPanelLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public ClubChatEditLeftBtn f13615b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public ClubChatEditRightBtn f13616c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public h f13617d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public ClubChatPanelType f13618e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13619f;

    /* renamed from: g, reason: collision with root package name */
    public ClubChatTopMsgLayout f13620g;

    /* renamed from: h, reason: collision with root package name */
    public RecyclerView f13621h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public ChatEmojiPagerLayout f13622i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public FKSVGAImageView f13623j;

    /* renamed from: k, reason: collision with root package name */
    public int f13624k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.feed.helper.f f13625l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public ClubChatMsgModel f13626m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13627n;

    /* compiled from: ClubChatInputPanelLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13628a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f13629b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f13630c;

        static {
            int[] iArr = new int[ClubChatEditLeftBtn.values().length];
            try {
                iArr[ClubChatEditLeftBtn.EMOJI_BTN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClubChatEditLeftBtn.LEFT_KEYBOARD_BTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f13628a = iArr;
            int[] iArr2 = new int[ClubChatEditRightBtn.values().length];
            try {
                iArr2[ClubChatEditRightBtn.RED_PACKET.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ClubChatEditRightBtn.SEND_BTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f13629b = iArr2;
            int[] iArr3 = new int[ClubChatPanelType.values().length];
            try {
                iArr3[ClubChatPanelType.SOFT_KEYBOARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[ClubChatPanelType.CHAT_EMOJI.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[ClubChatPanelType.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            f13630c = iArr3;
        }
    }

    /* compiled from: ClubChatInputPanelLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements com.cupidapp.live.chat2.view.i {

        /* compiled from: ClubChatInputPanelLayout.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f13632a;

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
                f13632a = iArr;
            }
        }

        public b() {
        }

        @Override // com.cupidapp.live.chat2.view.i
        public void a(@NotNull ChatEmojiType type, @NotNull String textMessage) {
            s.i(type, "type");
            s.i(textMessage, "textMessage");
            int i10 = a.f13632a[type.ordinal()];
            if (i10 == 1) {
                ClubChatInputPanelLayout.o(ClubChatInputPanelLayout.this, textMessage, false, 2, null);
            } else {
                if (i10 != 2) {
                    return;
                }
                ClubChatInputPanelLayout.this.s(textMessage);
            }
        }
    }

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            if (editable == null || editable.length() == 0) {
                ClubChatInputPanelLayout.this.v(ClubChatEditRightBtn.RED_PACKET);
                ((ImageView) ClubChatInputPanelLayout.this.f(R$id.club_chat_open_album_btn)).setVisibility(0);
            } else {
                ClubChatInputPanelLayout.this.v(ClubChatEditRightBtn.SEND_BTN);
                ((ImageView) ClubChatInputPanelLayout.this.f(R$id.club_chat_open_album_btn)).setVisibility(8);
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
    public static final class d implements Animator.AnimatorListener {
        public d() {
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
            h hVar = ClubChatInputPanelLayout.this.f13617d;
            if (hVar != null) {
                hVar.b();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatInputPanelLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13627n = new LinkedHashMap();
        this.f13615b = ClubChatEditLeftBtn.EMOJI_BTN;
        this.f13616c = ClubChatEditRightBtn.RED_PACKET;
        this.f13618e = ClubChatPanelType.NONE;
        I();
    }

    public static final void C(ClubChatInputPanelLayout this$0) {
        s.i(this$0, "this$0");
        this$0.O(ClubChatPanelType.SOFT_KEYBOARD);
        h hVar = this$0.f13617d;
        if (hVar != null) {
            hVar.e();
        }
    }

    public static /* synthetic */ void E(ClubChatInputPanelLayout clubChatInputPanelLayout, ClubChatPanelType clubChatPanelType, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        clubChatInputPanelLayout.D(clubChatPanelType, i10, i11);
    }

    public static /* synthetic */ void G(ClubChatInputPanelLayout clubChatInputPanelLayout, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        clubChatInputPanelLayout.F(z10);
    }

    public static final void R(ClubChatInputPanelLayout this$0) {
        s.i(this$0, "this$0");
        float y10 = this$0.getY();
        RecyclerView recyclerView = this$0.f13621h;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            s.A("mRecyclerView");
            recyclerView = null;
        }
        float y11 = recyclerView.getY();
        RecyclerView recyclerView3 = this$0.f13621h;
        if (recyclerView3 == null) {
            s.A("mRecyclerView");
            recyclerView3 = null;
        }
        float height = y10 - (y11 + recyclerView3.getHeight());
        if (height < 0.0f) {
            RecyclerView recyclerView4 = this$0.f13621h;
            if (recyclerView4 == null) {
                s.A("mRecyclerView");
            } else {
                recyclerView2 = recyclerView4;
            }
            recyclerView2.setTranslationY(recyclerView2.getTranslationY() + height);
        }
    }

    public static /* synthetic */ void o(ClubChatInputPanelLayout clubChatInputPanelLayout, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        clubChatInputPanelLayout.n(str, z10);
    }

    public static /* synthetic */ void t(ClubChatInputPanelLayout clubChatInputPanelLayout, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        clubChatInputPanelLayout.s(str);
    }

    public static final boolean x(ClubChatInputPanelLayout this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        view.performClick();
        if (motionEvent.getAction() != 1 || this$0.f13619f) {
            return false;
        }
        this$0.O(ClubChatPanelType.SOFT_KEYBOARD);
        return false;
    }

    public static final boolean y(ClubChatInputPanelLayout this$0, TextView textView, int i10, KeyEvent keyEvent) {
        s.i(this$0, "this$0");
        if (i10 == 4) {
            t(this$0, null, 1, null);
        }
        return true;
    }

    public static final void z(ClubChatInputPanelLayout this$0, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18;
        s.i(this$0, "this$0");
        if ((i14 == 0 && i15 == 0 && i16 == 0 && i17 == 0) || (i18 = i17 - i13) == 0) {
            return;
        }
        RecyclerView recyclerView = null;
        if (i18 < 0) {
            RecyclerView recyclerView2 = this$0.f13621h;
            if (recyclerView2 == null) {
                s.A("mRecyclerView");
                recyclerView2 = null;
            }
            float y10 = recyclerView2.getY();
            RecyclerView recyclerView3 = this$0.f13621h;
            if (recyclerView3 == null) {
                s.A("mRecyclerView");
                recyclerView3 = null;
            }
            if (y10 + recyclerView3.getHeight() > this$0.getY()) {
                this$0.f13624k += i18;
                RecyclerView recyclerView4 = this$0.f13621h;
                if (recyclerView4 == null) {
                    s.A("mRecyclerView");
                } else {
                    recyclerView = recyclerView4;
                }
                recyclerView.setTranslationY(recyclerView.getTranslationY() + i18);
            }
            h hVar = this$0.f13617d;
            if (hVar != null) {
                hVar.b();
                return;
            }
            return;
        }
        if (this$0.f13624k < 0) {
            ClubChatTopMsgLayout clubChatTopMsgLayout = this$0.f13620g;
            if (clubChatTopMsgLayout == null) {
                s.A("mTopMsgLayout");
                clubChatTopMsgLayout = null;
            }
            float y11 = clubChatTopMsgLayout.getY();
            ClubChatTopMsgLayout clubChatTopMsgLayout2 = this$0.f13620g;
            if (clubChatTopMsgLayout2 == null) {
                s.A("mTopMsgLayout");
                clubChatTopMsgLayout2 = null;
            }
            float height = y11 + clubChatTopMsgLayout2.getHeight();
            RecyclerView recyclerView5 = this$0.f13621h;
            if (recyclerView5 == null) {
                s.A("mRecyclerView");
                recyclerView5 = null;
            }
            float min = Math.min(height - recyclerView5.getY(), i18);
            this$0.f13624k += (int) min;
            RecyclerView recyclerView6 = this$0.f13621h;
            if (recyclerView6 == null) {
                s.A("mRecyclerView");
            } else {
                recyclerView = recyclerView6;
            }
            recyclerView.setTranslationY(recyclerView.getTranslationY() + min);
        }
        h hVar2 = this$0.f13617d;
        if (hVar2 != null) {
            hVar2.b();
        }
    }

    public final void A() {
        ChatEmojiPagerLayout chatEmojiPagerLayout = this.f13622i;
        if (chatEmojiPagerLayout != null) {
            y.o(chatEmojiPagerLayout, null, Integer.valueOf(p1.g.f52734a.a0()), 1, null);
        }
    }

    public final void B(@Nullable ClubChatMsgModel clubChatMsgModel) {
        this.f13626m = clubChatMsgModel;
        if (clubChatMsgModel == null) {
            ((TextView) f(R$id.club_chat_edit_quote_text)).setText((CharSequence) null);
            ((ConstraintLayout) f(R$id.club_chat_edit_quote_layout)).setVisibility(8);
            return;
        }
        int i10 = R$id.club_chat_edit_quote_layout;
        ((ConstraintLayout) f(i10)).setVisibility(0);
        ((TextView) f(R$id.club_chat_edit_quote_text)).setText(clubChatMsgModel.getEditInputQuoteText());
        User sender = clubChatMsgModel.getSender();
        if (sender != null) {
            String userId = sender.userId();
            User X = p1.g.f52734a.X();
            if (!s.d(userId, X != null ? X.userId() : null)) {
                m(sender, false);
            }
        }
        ((ConstraintLayout) f(i10)).postDelayed(new Runnable() { // from class: com.cupidapp.live.club.view.e
            @Override // java.lang.Runnable
            public final void run() {
                ClubChatInputPanelLayout.C(ClubChatInputPanelLayout.this);
            }
        }, 100L);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void D(com.cupidapp.live.club.model.ClubChatPanelType r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.club.view.ClubChatInputPanelLayout.D(com.cupidapp.live.club.model.ClubChatPanelType, int, int):void");
    }

    public final void F(boolean z10) {
        EditTextSelectable editTextSelectable = (EditTextSelectable) f(R$id.club_chat_edit_text);
        if (z10) {
            ViewParent parent = editTextSelectable.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.setFocusable(true);
                viewGroup.setFocusableInTouchMode(true);
                requestFocus();
            }
        } else {
            editTextSelectable.setFocusable(true);
            editTextSelectable.setFocusableInTouchMode(true);
            editTextSelectable.requestFocus();
        }
        Context context = getContext();
        s.h(context, "context");
        z0.h.p(context, editTextSelectable);
    }

    public final void H(@NotNull ClubChatTopMsgLayout topMsgLayout, @NotNull RecyclerView recyclerView, @NotNull ChatEmojiPagerLayout emojiLayout, @NotNull FKSVGAImageView svgaImg, @NotNull final String clubId) {
        s.i(topMsgLayout, "topMsgLayout");
        s.i(recyclerView, "recyclerView");
        s.i(emojiLayout, "emojiLayout");
        s.i(svgaImg, "svgaImg");
        s.i(clubId, "clubId");
        this.f13620g = topMsgLayout;
        this.f13621h = recyclerView;
        this.f13622i = emojiLayout;
        this.f13623j = svgaImg;
        EditTextSelectable club_chat_edit_text = (EditTextSelectable) f(R$id.club_chat_edit_text);
        s.h(club_chat_edit_text, "club_chat_edit_text");
        this.f13625l = new com.cupidapp.live.feed.helper.f(club_chat_edit_text, new Function1<Boolean, p>() { // from class: com.cupidapp.live.club.view.ClubChatInputPanelLayout$initBottomOperateData$1

            /* compiled from: ClubChatInputPanelLayout.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
            public static final class a implements com.cupidapp.live.club.dialog.f {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ClubChatInputPanelLayout f13637a;

                public a(ClubChatInputPanelLayout clubChatInputPanelLayout) {
                    this.f13637a = clubChatInputPanelLayout;
                }

                public static final void e(ClubChatInputPanelLayout this$0) {
                    s.i(this$0, "this$0");
                    this$0.O(ClubChatPanelType.SOFT_KEYBOARD);
                }

                public static final void f(ClubChatInputPanelLayout this$0) {
                    s.i(this$0, "this$0");
                    this$0.O(ClubChatPanelType.SOFT_KEYBOARD);
                }

                @Override // com.cupidapp.live.club.dialog.f
                public void a() {
                    final ClubChatInputPanelLayout clubChatInputPanelLayout = this.f13637a;
                    clubChatInputPanelLayout.postDelayed(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: INVOKE 
                          (r0v0 'clubChatInputPanelLayout' com.cupidapp.live.club.view.ClubChatInputPanelLayout)
                          (wrap:java.lang.Runnable:0x0004: CONSTRUCTOR (r0v0 'clubChatInputPanelLayout' com.cupidapp.live.club.view.ClubChatInputPanelLayout A[DONT_INLINE]) A[MD:(com.cupidapp.live.club.view.ClubChatInputPanelLayout):void (m), WRAPPED] call: com.cupidapp.live.club.view.g.<init>(com.cupidapp.live.club.view.ClubChatInputPanelLayout):void type: CONSTRUCTOR)
                          (200 long)
                         VIRTUAL call: android.widget.FrameLayout.postDelayed(java.lang.Runnable, long):boolean A[MD:(java.lang.Runnable, long):boolean (m)] in method: com.cupidapp.live.club.view.ClubChatInputPanelLayout$initBottomOperateData$1.a.a():void, file: C:\Users\35037\Desktop\fankahook\2\class2.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.cupidapp.live.club.view.g, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        com.cupidapp.live.club.view.ClubChatInputPanelLayout r0 = r4.f13637a
                        com.cupidapp.live.club.view.g r1 = new com.cupidapp.live.club.view.g
                        r1.<init>(r0)
                        r2 = 200(0xc8, double:9.9E-322)
                        r0.postDelayed(r1, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.club.view.ClubChatInputPanelLayout$initBottomOperateData$1.a.a():void");
                }

                @Override // com.cupidapp.live.club.dialog.f
                public void b(@NotNull List<User> userList) {
                    com.cupidapp.live.feed.helper.f fVar;
                    s.i(userList, "userList");
                    ClubChatInputPanelLayout clubChatInputPanelLayout = this.f13637a;
                    int i10 = 0;
                    for (User user : userList) {
                        int i11 = i10 + 1;
                        if (i10 < 0) {
                            kotlin.collections.s.s();
                        }
                        User user2 = user;
                        fVar = clubChatInputPanelLayout.f13625l;
                        if (fVar != null) {
                            fVar.b(user2.userId(), user2.getNickname(), i10 == 0, -15066598);
                        }
                        i10 = i11;
                    }
                    final ClubChatInputPanelLayout clubChatInputPanelLayout2 = this.f13637a;
                    clubChatInputPanelLayout2.postDelayed(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0044: INVOKE 
                          (r9v2 'clubChatInputPanelLayout2' com.cupidapp.live.club.view.ClubChatInputPanelLayout)
                          (wrap:java.lang.Runnable:0x003f: CONSTRUCTOR (r9v2 'clubChatInputPanelLayout2' com.cupidapp.live.club.view.ClubChatInputPanelLayout A[DONT_INLINE]) A[MD:(com.cupidapp.live.club.view.ClubChatInputPanelLayout):void (m), WRAPPED] call: com.cupidapp.live.club.view.f.<init>(com.cupidapp.live.club.view.ClubChatInputPanelLayout):void type: CONSTRUCTOR)
                          (200 long)
                         VIRTUAL call: android.widget.FrameLayout.postDelayed(java.lang.Runnable, long):boolean A[MD:(java.lang.Runnable, long):boolean (m)] in method: com.cupidapp.live.club.view.ClubChatInputPanelLayout$initBottomOperateData$1.a.b(java.util.List<com.cupidapp.live.profile.model.User>):void, file: C:\Users\35037\Desktop\fankahook\2\class2.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.cupidapp.live.club.view.f, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        java.lang.String r0 = "userList"
                        kotlin.jvm.internal.s.i(r9, r0)
                        com.cupidapp.live.club.view.ClubChatInputPanelLayout r0 = r8.f13637a
                        java.util.Iterator r9 = r9.iterator2()
                        r1 = 0
                        r2 = 0
                    Ld:
                        boolean r3 = r9.hasNext()
                        if (r3 == 0) goto L3b
                        java.lang.Object r3 = r9.next()
                        int r4 = r2 + 1
                        if (r2 >= 0) goto L1e
                        kotlin.collections.s.s()
                    L1e:
                        com.cupidapp.live.profile.model.User r3 = (com.cupidapp.live.profile.model.User) r3
                        com.cupidapp.live.feed.helper.f r5 = com.cupidapp.live.club.view.ClubChatInputPanelLayout.i(r0)
                        if (r5 == 0) goto L39
                        java.lang.String r6 = r3.userId()
                        java.lang.String r3 = r3.getNickname()
                        if (r2 != 0) goto L32
                        r2 = 1
                        goto L33
                    L32:
                        r2 = 0
                    L33:
                        r7 = -15066598(0xffffffffff1a1a1a, float:-2.0483664E38)
                        r5.b(r6, r3, r2, r7)
                    L39:
                        r2 = r4
                        goto Ld
                    L3b:
                        com.cupidapp.live.club.view.ClubChatInputPanelLayout r9 = r8.f13637a
                        com.cupidapp.live.club.view.f r0 = new com.cupidapp.live.club.view.f
                        r0.<init>(r9)
                        r1 = 200(0xc8, double:9.9E-322)
                        r9.postDelayed(r0, r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.club.view.ClubChatInputPanelLayout$initBottomOperateData$1.a.b(java.util.List):void");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                com.cupidapp.live.feed.helper.f fVar;
                List<ReplaceAtModel> f10;
                ClubChatInputPanelLayout.this.q();
                ClubAtUserDialog a10 = ClubAtUserDialog.f13520j.a(ClubChatInputPanelLayout.this.getContext());
                fVar = ClubChatInputPanelLayout.this.f13625l;
                a10.E((fVar == null || (f10 = fVar.f()) == null) ? 0 : f10.size()).F(new a(ClubChatInputPanelLayout.this)).G(clubId);
            }
        });
        w();
        p();
    }

    public final void I() {
        z.a(this, R$layout.layout_club_chat_input_panel, true);
    }

    public final boolean J(ClubChatPanelType clubChatPanelType) {
        return clubChatPanelType == ClubChatPanelType.SOFT_KEYBOARD || clubChatPanelType == ClubChatPanelType.CHAT_EMOJI;
    }

    public final void K(int i10, int i11) {
        D(ClubChatPanelType.SOFT_KEYBOARD, i10, i11);
        A();
    }

    public final void L() {
        this.f13619f = false;
        if (this.f13618e == ClubChatPanelType.SOFT_KEYBOARD) {
            O(ClubChatPanelType.NONE);
        }
    }

    public final void M() {
        this.f13619f = true;
    }

    public final void N() {
        O(ClubChatPanelType.NONE);
    }

    public final void O(@NotNull ClubChatPanelType type) {
        s.i(type, "type");
        int i10 = a.f13630c[type.ordinal()];
        boolean z10 = true;
        if (i10 == 1) {
            u(ClubChatEditLeftBtn.EMOJI_BTN);
            int i11 = R$id.club_chat_edit_text;
            Editable text = ((EditTextSelectable) f(i11)).getText();
            if (text != null && text.length() != 0) {
                z10 = false;
            }
            if (z10) {
                v(ClubChatEditRightBtn.RED_PACKET);
            } else {
                v(ClubChatEditRightBtn.SEND_BTN);
            }
            Context context = getContext();
            s.h(context, "context");
            EditTextSelectable club_chat_edit_text = (EditTextSelectable) f(i11);
            s.h(club_chat_edit_text, "club_chat_edit_text");
            z0.h.v(context, club_chat_edit_text);
            ChatEmojiPagerLayout chatEmojiPagerLayout = this.f13622i;
            if (chatEmojiPagerLayout != null) {
                chatEmojiPagerLayout.setVisibility(4);
            }
        } else if (i10 == 2) {
            u(ClubChatEditLeftBtn.LEFT_KEYBOARD_BTN);
            F(false);
            ChatEmojiPagerLayout chatEmojiPagerLayout2 = this.f13622i;
            if (chatEmojiPagerLayout2 != null) {
                chatEmojiPagerLayout2.setVisibility(0);
            }
        } else if (i10 == 3) {
            u(ClubChatEditLeftBtn.EMOJI_BTN);
            Editable text2 = ((EditTextSelectable) f(R$id.club_chat_edit_text)).getText();
            if (text2 == null || text2.length() == 0) {
                v(ClubChatEditRightBtn.RED_PACKET);
            } else {
                v(ClubChatEditRightBtn.SEND_BTN);
            }
            G(this, false, 1, null);
            ChatEmojiPagerLayout chatEmojiPagerLayout3 = this.f13622i;
            if (chatEmojiPagerLayout3 != null) {
                chatEmojiPagerLayout3.setVisibility(8);
            }
        }
        E(this, type, 0, 0, 6, null);
    }

    public final boolean P() {
        return this.f13618e != ClubChatPanelType.NONE;
    }

    public final void Q() {
        RecyclerView recyclerView = this.f13621h;
        if (recyclerView == null) {
            s.A("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.post(new Runnable() { // from class: com.cupidapp.live.club.view.d
            @Override // java.lang.Runnable
            public final void run() {
                ClubChatInputPanelLayout.R(ClubChatInputPanelLayout.this);
            }
        });
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f13627n;
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

    public final void m(@NotNull User user, boolean z10) {
        List<ReplaceAtModel> f10;
        s.i(user, "user");
        com.cupidapp.live.feed.helper.f fVar = this.f13625l;
        if (9 > ((fVar == null || (f10 = fVar.f()) == null) ? 0 : f10.size())) {
            com.cupidapp.live.feed.helper.f fVar2 = this.f13625l;
            if (fVar2 != null) {
                String userId = user.userId();
                String nickname = user.getNickname();
                if (nickname == null) {
                    nickname = user.getName();
                }
                fVar2.b(userId, nickname, z10, -15066598);
                return;
            }
            return;
        }
        com.cupidapp.live.base.view.h.f12779a.k(R$string.club_at_user_max_nine);
    }

    public final void n(@Nullable String str, boolean z10) {
        if (str == null || str.length() == 0) {
            return;
        }
        int i10 = R$id.club_chat_edit_text;
        Editable text = ((EditTextSelectable) f(i10)).getText();
        if (text != null) {
            text.insert(((EditTextSelectable) f(i10)).getSelectionStart(), str);
        }
        if (z10) {
            O(ClubChatPanelType.SOFT_KEYBOARD);
        }
    }

    public final void p() {
        ImageView club_chat_edit_left_btn = (ImageView) f(R$id.club_chat_edit_left_btn);
        s.h(club_chat_edit_left_btn, "club_chat_edit_left_btn");
        y.d(club_chat_edit_left_btn, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.ClubChatInputPanelLayout$bindClickEvent$1

            /* compiled from: ClubChatInputPanelLayout.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f13633a;

                static {
                    int[] iArr = new int[ClubChatEditLeftBtn.values().length];
                    try {
                        iArr[ClubChatEditLeftBtn.EMOJI_BTN.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ClubChatEditLeftBtn.LEFT_KEYBOARD_BTN.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f13633a = iArr;
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
                ClubChatEditLeftBtn clubChatEditLeftBtn;
                clubChatEditLeftBtn = ClubChatInputPanelLayout.this.f13615b;
                int i10 = a.f13633a[clubChatEditLeftBtn.ordinal()];
                if (i10 == 1) {
                    ClubChatInputPanelLayout.this.O(ClubChatPanelType.CHAT_EMOJI);
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    ClubChatInputPanelLayout.this.O(ClubChatPanelType.SOFT_KEYBOARD);
                }
            }
        });
        ImageView club_chat_edit_right_btn = (ImageView) f(R$id.club_chat_edit_right_btn);
        s.h(club_chat_edit_right_btn, "club_chat_edit_right_btn");
        y.d(club_chat_edit_right_btn, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.ClubChatInputPanelLayout$bindClickEvent$2

            /* compiled from: ClubChatInputPanelLayout.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f13634a;

                static {
                    int[] iArr = new int[ClubChatEditRightBtn.values().length];
                    try {
                        iArr[ClubChatEditRightBtn.RED_PACKET.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ClubChatEditRightBtn.SEND_BTN.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f13634a = iArr;
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
                ClubChatEditRightBtn clubChatEditRightBtn;
                clubChatEditRightBtn = ClubChatInputPanelLayout.this.f13616c;
                int i10 = a.f13634a[clubChatEditRightBtn.ordinal()];
                if (i10 != 1) {
                    if (i10 != 2) {
                        return;
                    }
                    ClubChatInputPanelLayout.t(ClubChatInputPanelLayout.this, null, 1, null);
                } else {
                    h hVar = ClubChatInputPanelLayout.this.f13617d;
                    if (hVar != null) {
                        hVar.c();
                    }
                }
            }
        });
        ImageView club_chat_open_album_btn = (ImageView) f(R$id.club_chat_open_album_btn);
        s.h(club_chat_open_album_btn, "club_chat_open_album_btn");
        y.d(club_chat_open_album_btn, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.ClubChatInputPanelLayout$bindClickEvent$3
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
                h hVar = ClubChatInputPanelLayout.this.f13617d;
                if (hVar != null) {
                    hVar.a();
                }
            }
        });
        ChatEmojiPagerLayout chatEmojiPagerLayout = this.f13622i;
        if (chatEmojiPagerLayout != null) {
            chatEmojiPagerLayout.setChatEmojiPagerListener(new b());
        }
        ImageView club_chat_edit_quote_close_btn = (ImageView) f(R$id.club_chat_edit_quote_close_btn);
        s.h(club_chat_edit_quote_close_btn, "club_chat_edit_quote_close_btn");
        y.d(club_chat_edit_quote_close_btn, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.ClubChatInputPanelLayout$bindClickEvent$5
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
                ClubChatInputPanelLayout.this.B(null);
            }
        });
    }

    public final boolean q() {
        ClubChatPanelType clubChatPanelType = this.f13618e;
        ClubChatPanelType clubChatPanelType2 = ClubChatPanelType.NONE;
        if (clubChatPanelType == clubChatPanelType2) {
            return false;
        }
        O(clubChatPanelType2);
        return true;
    }

    public final void r(@NotNull ClubCancelMsgData data) {
        s.i(data, "data");
        String messageId = data.getMessageId();
        ClubChatMsgModel clubChatMsgModel = this.f13626m;
        if (s.d(messageId, clubChatMsgModel != null ? clubChatMsgModel.getMessageId() : null)) {
            B(null);
            if (data.isMeCancel()) {
                return;
            }
            FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.quote_msg_has_been_cancel, 0, 2, null), R$string.i_know_it, null, null, 6, null), null, 1, null);
        }
    }

    public final void s(String str) {
        ClubChatMsgModel clubChatMsgModel;
        boolean z10;
        List<ReplaceAtModel> f10;
        if (str == null || str.length() == 0) {
            str = StringsKt__StringsKt.P0(String.valueOf(((EditTextSelectable) f(R$id.club_chat_edit_text)).getText())).toString();
            clubChatMsgModel = this.f13626m;
            z10 = true;
        } else {
            clubChatMsgModel = null;
            z10 = false;
        }
        if (str.length() == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        com.cupidapp.live.feed.helper.f fVar = this.f13625l;
        if (fVar != null && (f10 = fVar.f()) != null) {
            Iterator<ReplaceAtModel> iterator2 = f10.iterator2();
            while (iterator2.hasNext()) {
                sb2.append(iterator2.next().getId());
                sb2.append(',');
            }
        }
        h hVar = this.f13617d;
        if (hVar != null) {
            hVar.d(str, StringsKt__StringsKt.Q0(sb2, ',').toString(), clubChatMsgModel);
        }
        if (z10) {
            Editable text = ((EditTextSelectable) f(R$id.club_chat_edit_text)).getText();
            if (text != null) {
                text.clear();
            }
            B(null);
        }
    }

    public final void setListener(@NotNull h listener) {
        s.i(listener, "listener");
        this.f13617d = listener;
    }

    public final void u(ClubChatEditLeftBtn clubChatEditLeftBtn) {
        int i10;
        this.f13615b = clubChatEditLeftBtn;
        int i11 = a.f13628a[clubChatEditLeftBtn.ordinal()];
        if (i11 == 1) {
            i10 = R$mipmap.icon_chat_detail_emoji;
        } else {
            if (i11 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i10 = R$mipmap.icon_chat_detail_soft_keyboard;
        }
        ((ImageView) f(R$id.club_chat_edit_left_btn)).setImageResource(i10);
    }

    public final void v(ClubChatEditRightBtn clubChatEditRightBtn) {
        int i10;
        this.f13616c = clubChatEditRightBtn;
        int i11 = a.f13629b[clubChatEditRightBtn.ordinal()];
        if (i11 == 1) {
            i10 = R$mipmap.ic_club_chat_red_packet;
        } else {
            if (i11 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i10 = R$mipmap.icon_chat_detail_send_message;
        }
        ((ImageView) f(R$id.club_chat_edit_right_btn)).setImageResource(i10);
    }

    public final void w() {
        A();
        int i10 = R$id.club_chat_edit_text;
        ((EditTextSelectable) f(i10)).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.club.view.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean x10;
                x10 = ClubChatInputPanelLayout.x(ClubChatInputPanelLayout.this, view, motionEvent);
                return x10;
            }
        });
        EditTextSelectable club_chat_edit_text = (EditTextSelectable) f(i10);
        s.h(club_chat_edit_text, "club_chat_edit_text");
        club_chat_edit_text.addTextChangedListener(new c());
        EditTextSelectable editTextSelectable = (EditTextSelectable) f(i10);
        editTextSelectable.setInputType(262144);
        editTextSelectable.setSingleLine(false);
        editTextSelectable.setMaxLines(4);
        editTextSelectable.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.cupidapp.live.club.view.c
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                boolean y10;
                y10 = ClubChatInputPanelLayout.y(ClubChatInputPanelLayout.this, textView, i11, keyEvent);
                return y10;
            }
        });
        ((EditTextSelectable) f(i10)).addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.cupidapp.live.club.view.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                ClubChatInputPanelLayout.z(ClubChatInputPanelLayout.this, view, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatInputPanelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13627n = new LinkedHashMap();
        this.f13615b = ClubChatEditLeftBtn.EMOJI_BTN;
        this.f13616c = ClubChatEditRightBtn.RED_PACKET;
        this.f13618e = ClubChatPanelType.NONE;
        I();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatInputPanelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13627n = new LinkedHashMap();
        this.f13615b = ClubChatEditLeftBtn.EMOJI_BTN;
        this.f13616c = ClubChatEditRightBtn.RED_PACKET;
        this.f13618e = ClubChatPanelType.NONE;
        I();
    }
}
