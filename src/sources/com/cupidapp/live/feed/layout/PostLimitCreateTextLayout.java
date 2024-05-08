package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.dialog.BgColor;
import com.cupidapp.live.base.view.dialog.FKPointerDialog;
import com.cupidapp.live.base.view.dialog.PointerPos;
import com.cupidapp.live.feed.activity.PostLimitBgColorType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: PostLimitCreateTextLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitCreateTextLayout extends FrameLayout {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f14532h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f14533i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f14534j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f14535k;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public PostLimitTextFontType f14536b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public PostLimitTextBgType f14537c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public r f14538d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public PostLimitDragTextLayout f14539e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public FKPointerDialog f14540f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14541g;

    /* compiled from: PostLimitCreateTextLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return PostLimitCreateTextLayout.f14535k;
        }

        public final int b() {
            return PostLimitCreateTextLayout.f14533i;
        }

        public final int c() {
            return PostLimitCreateTextLayout.f14534j;
        }
    }

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        
            r2 = r2;
         */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void afterTextChanged(@org.jetbrains.annotations.Nullable android.text.Editable r2) {
            /*
                r1 = this;
                if (r2 == 0) goto L3
                goto L5
            L3:
                java.lang.String r2 = ""
            L5:
                java.lang.String r2 = r2.toString()
                com.cupidapp.live.feed.layout.PostLimitCreateTextLayout r0 = com.cupidapp.live.feed.layout.PostLimitCreateTextLayout.this
                com.cupidapp.live.feed.layout.PostLimitCreateTextLayout.k(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.PostLimitCreateTextLayout.b.afterTextChanged(android.text.Editable):void");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
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
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence == null || charSequence.length() <= 140) {
                return;
            }
            PostLimitCreateTextLayout postLimitCreateTextLayout = PostLimitCreateTextLayout.this;
            int i13 = R$id.post_limit_edit_text;
            ((EditText) postLimitCreateTextLayout.b(i13)).setText(charSequence.subSequence(0, 140).toString());
            ((EditText) PostLimitCreateTextLayout.this.b(i13)).setSelection(Math.min(i10 + i12, 140));
            com.cupidapp.live.base.view.h.f12779a.l(PostLimitCreateTextLayout.this.getContext(), R$string.word_limit_exceeded);
        }
    }

    static {
        a aVar = new a(null);
        f14532h = aVar;
        f14533i = z0.h.c(aVar, 6.0f);
        f14534j = z0.h.c(aVar, 4.0f);
        f14535k = z0.h.c(aVar, 10.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitCreateTextLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14541g = new LinkedHashMap();
        this.f14536b = PostLimitTextFontType.DEFAULT;
        this.f14537c = PostLimitTextBgType.NO_BG_WHITE_TEXT;
        q();
    }

    public static final void s(PostLimitCreateTextLayout this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        p1.g.f52734a.u3(Boolean.FALSE);
        FKPointerDialog.a aVar = FKPointerDialog.f12718p;
        Context context = this$0.getContext();
        kotlin.jvm.internal.s.h(context, "context");
        FKPointerDialog a10 = aVar.a(context);
        String string = this$0.getContext().getString(R$string.try_change_text_background);
        kotlin.jvm.internal.s.h(string, "context.getString(R.stri…y_change_text_background)");
        FKPointerDialog j10 = a10.n(string).q(PointerPos.TOP_CENTER, BgColor.DEFAULT).m(true).j(Float.valueOf(0.0f));
        this$0.f14540f = j10;
        if (j10 != null) {
            FKPointerDialog.B(j10, (ImageView) this$0.b(R$id.limit_edit_text_bg_btn), 0, z0.h.c(this$0, 13.0f), 0, null, 26, null);
        }
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f14541g;
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
        ImageView limit_edit_text_font_btn = (ImageView) b(R$id.limit_edit_text_font_btn);
        kotlin.jvm.internal.s.h(limit_edit_text_font_btn, "limit_edit_text_font_btn");
        y.d(limit_edit_text_font_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitCreateTextLayout$bindClickEvent$1

            /* compiled from: PostLimitCreateTextLayout.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f14543a;

                static {
                    int[] iArr = new int[PostLimitTextFontType.values().length];
                    try {
                        iArr[PostLimitTextFontType.DEFAULT.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PostLimitTextFontType.YOU_SHE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PostLimitTextFontType.SONG_TI.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[PostLimitTextFontType.SAN_JI.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f14543a = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                PostLimitTextFontType postLimitTextFontType;
                PostLimitTextFontType postLimitTextFontType2;
                postLimitTextFontType = PostLimitCreateTextLayout.this.f14536b;
                int i10 = a.f14543a[postLimitTextFontType.ordinal()];
                if (i10 == 1) {
                    postLimitTextFontType2 = PostLimitTextFontType.YOU_SHE;
                } else if (i10 == 2) {
                    postLimitTextFontType2 = PostLimitTextFontType.SONG_TI;
                } else if (i10 == 3) {
                    postLimitTextFontType2 = PostLimitTextFontType.SAN_JI;
                } else {
                    if (i10 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    postLimitTextFontType2 = PostLimitTextFontType.DEFAULT;
                }
                PostLimitCreateTextLayout.this.n(postLimitTextFontType2);
            }
        });
        ImageView limit_edit_text_bg_btn = (ImageView) b(R$id.limit_edit_text_bg_btn);
        kotlin.jvm.internal.s.h(limit_edit_text_bg_btn, "limit_edit_text_bg_btn");
        y.d(limit_edit_text_bg_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitCreateTextLayout$bindClickEvent$2

            /* compiled from: PostLimitCreateTextLayout.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f14544a;

                static {
                    int[] iArr = new int[PostLimitTextBgType.values().length];
                    try {
                        iArr[PostLimitTextBgType.NO_BG_WHITE_TEXT.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PostLimitTextBgType.WHITE_BG_BLACK_TEXT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PostLimitTextBgType.BLACK_BG_WHITE_TEXT.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[PostLimitTextBgType.NO_BG_BLACK_TEXT.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f14544a = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                PostLimitTextBgType postLimitTextBgType;
                PostLimitTextBgType postLimitTextBgType2;
                PostLimitCreateTextLayout.this.o();
                postLimitTextBgType = PostLimitCreateTextLayout.this.f14537c;
                int i10 = a.f14544a[postLimitTextBgType.ordinal()];
                if (i10 == 1) {
                    postLimitTextBgType2 = PostLimitTextBgType.WHITE_BG_BLACK_TEXT;
                } else if (i10 == 2) {
                    postLimitTextBgType2 = PostLimitTextBgType.BLACK_BG_WHITE_TEXT;
                } else if (i10 == 3) {
                    postLimitTextBgType2 = PostLimitTextBgType.NO_BG_BLACK_TEXT;
                } else {
                    if (i10 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    postLimitTextBgType2 = PostLimitTextBgType.NO_BG_WHITE_TEXT;
                }
                PostLimitCreateTextLayout.this.m(postLimitTextBgType2);
            }
        });
        TextView limit_edit_create_complete_btn = (TextView) b(R$id.limit_edit_create_complete_btn);
        kotlin.jvm.internal.s.h(limit_edit_create_complete_btn, "limit_edit_create_complete_btn");
        y.d(limit_edit_create_complete_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitCreateTextLayout$bindClickEvent$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                PostLimitCreateTextLayout.this.p();
            }
        });
        ConstraintLayout limit_edit_parent_layout = (ConstraintLayout) b(R$id.limit_edit_parent_layout);
        kotlin.jvm.internal.s.h(limit_edit_parent_layout, "limit_edit_parent_layout");
        y.d(limit_edit_parent_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitCreateTextLayout$bindClickEvent$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                PostLimitCreateTextLayout.this.p();
            }
        });
    }

    public final void m(PostLimitTextBgType postLimitTextBgType) {
        this.f14537c = postLimitTextBgType;
        int i10 = R$id.post_limit_edit_text;
        ((EditText) b(i10)).setBackgroundColor(ContextCompat.getColor(getContext(), postLimitTextBgType.getBgColorResId()));
        ((EditText) b(i10)).setTextColor(ContextCompat.getColor(getContext(), postLimitTextBgType.getTextColorResId()));
    }

    public final void n(PostLimitTextFontType postLimitTextFontType) {
        this.f14536b = postLimitTextFontType;
        if (postLimitTextFontType != PostLimitTextFontType.DEFAULT && postLimitTextFontType.getFontResId() > 0) {
            ((EditText) b(R$id.post_limit_edit_text)).setTypeface(ResourcesCompat.getFont(getContext(), postLimitTextFontType.getFontResId()));
        } else {
            ((EditText) b(R$id.post_limit_edit_text)).setTypeface(Typeface.DEFAULT);
        }
    }

    public final void o() {
        FKPointerDialog fKPointerDialog = this.f14540f;
        if (fKPointerDialog != null) {
            fKPointerDialog.g(false);
        }
        this.f14540f = null;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NotNull View changedView, int i10) {
        kotlin.jvm.internal.s.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, i10);
        if (i10 != 0) {
            o();
        }
    }

    public final void p() {
        if (getVisibility() == 8) {
            return;
        }
        setVisibility(8);
        Context context = getContext();
        kotlin.jvm.internal.s.h(context, "context");
        int i10 = R$id.post_limit_edit_text;
        z0.h.p(context, (EditText) b(i10));
        PostLimitDragTextLayout postLimitDragTextLayout = this.f14539e;
        if (postLimitDragTextLayout != null) {
            postLimitDragTextLayout.setVisibility(0);
        }
        CreateTextUiModel createTextUiModel = new CreateTextUiModel(this.f14539e, ((EditText) b(i10)).getText().toString(), this.f14536b, this.f14537c, 0.0f, 0, 48, null);
        r rVar = this.f14538d;
        if (rVar != null) {
            rVar.a(createTextUiModel);
        }
        ((EditText) b(i10)).getText().clear();
        this.f14539e = null;
    }

    public final void q() {
        z.a(this, R$layout.layout_post_limit_create_text, true);
        int i10 = R$id.post_limit_edit_text;
        EditText post_limit_edit_text = (EditText) b(i10);
        kotlin.jvm.internal.s.h(post_limit_edit_text, "post_limit_edit_text");
        int i11 = f14535k;
        y.m(post_limit_edit_text, Integer.valueOf(i11), null, Integer.valueOf(i11), null, 10, null);
        EditText editText = (EditText) b(i10);
        int i12 = f14533i;
        int i13 = f14534j;
        editText.setPadding(i12, i13, i12, i13);
        EditText post_limit_edit_text2 = (EditText) b(i10);
        kotlin.jvm.internal.s.h(post_limit_edit_text2, "post_limit_edit_text");
        post_limit_edit_text2.addTextChangedListener(new c());
        EditText post_limit_edit_text3 = (EditText) b(i10);
        kotlin.jvm.internal.s.h(post_limit_edit_text3, "post_limit_edit_text");
        post_limit_edit_text3.addTextChangedListener(new b());
        l();
    }

    public final void r(String str) {
        if (kotlin.jvm.internal.s.d(p1.g.f52734a.i1(), Boolean.FALSE)) {
            return;
        }
        if (str.length() == 0) {
            return;
        }
        ((ImageView) b(R$id.limit_edit_text_bg_btn)).post(new Runnable() { // from class: com.cupidapp.live.feed.layout.q
            @Override // java.lang.Runnable
            public final void run() {
                PostLimitCreateTextLayout.s(PostLimitCreateTextLayout.this);
            }
        });
    }

    public final void setListener(@NotNull r listener) {
        kotlin.jvm.internal.s.i(listener, "listener");
        this.f14538d = listener;
    }

    public final void t(@Nullable CreateTextUiModel createTextUiModel, @NotNull PostLimitBgColorType type) {
        kotlin.jvm.internal.s.i(type, "type");
        this.f14539e = createTextUiModel != null ? createTextUiModel.getTextLayout() : null;
        setVisibility(0);
        Context context = getContext();
        kotlin.jvm.internal.s.h(context, "context");
        int i10 = R$id.post_limit_edit_text;
        EditText post_limit_edit_text = (EditText) b(i10);
        kotlin.jvm.internal.s.h(post_limit_edit_text, "post_limit_edit_text");
        z0.h.v(context, post_limit_edit_text);
        ConstraintLayout limit_edit_parent_layout = (ConstraintLayout) b(R$id.limit_edit_parent_layout);
        kotlin.jvm.internal.s.h(limit_edit_parent_layout, "limit_edit_parent_layout");
        y.o(limit_edit_parent_layout, null, Integer.valueOf(z0.h.k(this) - p1.g.f52734a.a0()), 1, null);
        if (createTextUiModel == null) {
            ((EditText) b(i10)).getText().clear();
            n(PostLimitTextFontType.DEFAULT);
            m(PostLimitBgColorType.Companion.a(type));
            return;
        }
        PostLimitDragTextLayout postLimitDragTextLayout = this.f14539e;
        if (postLimitDragTextLayout != null) {
            postLimitDragTextLayout.setVisibility(4);
        }
        ((EditText) b(i10)).setText(createTextUiModel.getText());
        ((EditText) b(i10)).setSelection(createTextUiModel.getText().length());
        n(createTextUiModel.getFontType());
        m(createTextUiModel.getBgType());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitCreateTextLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14541g = new LinkedHashMap();
        this.f14536b = PostLimitTextFontType.DEFAULT;
        this.f14537c = PostLimitTextBgType.NO_BG_WHITE_TEXT;
        q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitCreateTextLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14541g = new LinkedHashMap();
        this.f14536b = PostLimitTextFontType.DEFAULT;
        this.f14537c = PostLimitTextBgType.NO_BG_WHITE_TEXT;
        q();
    }
}
