package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.gson.GsonUtil;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.chat.view.QuickExpressionLayout;
import com.cupidapp.live.feed.model.CommentResult;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.PostCommentModel;
import com.cupidapp.live.mentionuser.model.ReplaceAtModel;
import com.cupidapp.live.profile.model.User;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FeedDetailEditTextLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailEditTextLayout extends BaseLayout {

    /* renamed from: d */
    @Nullable
    public FeedModel f14450d;

    /* renamed from: e */
    @Nullable
    public Function0<kotlin.p> f14451e;

    /* renamed from: f */
    @Nullable
    public Function2<? super Integer, ? super PostCommentModel, kotlin.p> f14452f;

    /* renamed from: g */
    @Nullable
    public Function1<? super Boolean, kotlin.p> f14453g;

    /* renamed from: h */
    @Nullable
    public FeedSensorContext f14454h;

    /* renamed from: i */
    @Nullable
    public Map<String, ? extends Object> f14455i;

    /* renamed from: j */
    @Nullable
    public com.cupidapp.live.feed.helper.f f14456j;

    /* renamed from: k */
    @NotNull
    public Map<Integer, View> f14457k;

    /* compiled from: FeedDetailEditTextLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            ((ImageView) FeedDetailEditTextLayout.this.f(R$id.sendCommentImageView)).setVisibility(((EditTextSelectable) FeedDetailEditTextLayout.this.f(R$id.commentInputEditText)).length() > 0 ? 0 : 8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedDetailEditTextLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14457k = new LinkedHashMap();
        t();
    }

    public final void setEnabledSendImageView(boolean z10) {
        int i10 = R$id.sendCommentImageView;
        ((ImageView) f(i10)).setAlpha(z10 ? 1.0f : 0.5f);
        ((ImageView) f(i10)).setEnabled(z10);
    }

    public static /* synthetic */ void setFeedModelAndCallback$default(FeedDetailEditTextLayout feedDetailEditTextLayout, FeedModel feedModel, FeedSensorContext feedSensorContext, Map map, Function0 function0, Function2 function2, Function1 function1, int i10, Object obj) {
        feedDetailEditTextLayout.setFeedModelAndCallback(feedModel, feedSensorContext, (i10 & 4) != 0 ? null : map, (i10 & 8) != 0 ? null : function0, (i10 & 16) != 0 ? null : function2, (i10 & 32) != 0 ? null : function1);
    }

    public static final boolean u(FeedDetailEditTextLayout this$0, TextView textView, int i10, KeyEvent keyEvent) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (i10 != 4) {
            return true;
        }
        this$0.x();
        return true;
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f14457k;
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

    public final void o(@Nullable String str, @Nullable String str2, boolean z10) {
        com.cupidapp.live.feed.helper.f fVar = this.f14456j;
        if (fVar != null) {
            com.cupidapp.live.feed.helper.f.c(fVar, str, str2, z10, 0, 8, null);
        }
    }

    public final void p() {
        ImageView sendAtImg = (ImageView) f(R$id.sendAtImg);
        kotlin.jvm.internal.s.h(sendAtImg, "sendAtImg");
        y.d(sendAtImg, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedDetailEditTextLayout$bindClickEvent$1
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
                Function1 function1;
                function1 = FeedDetailEditTextLayout.this.f14453g;
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                }
            }
        });
        ImageView sendCommentImageView = (ImageView) f(R$id.sendCommentImageView);
        kotlin.jvm.internal.s.h(sendCommentImageView, "sendCommentImageView");
        y.d(sendCommentImageView, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedDetailEditTextLayout$bindClickEvent$2
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
                FeedDetailEditTextLayout.this.setEnabledSendImageView(false);
                FeedDetailEditTextLayout.this.x();
            }
        });
        ((EditTextSelectable) f(R$id.commentInputEditText)).addTextChangedListener(new a());
        ((QuickExpressionLayout) f(R$id.quickExpressionLayout)).setItemClickListener(new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedDetailEditTextLayout$bindClickEvent$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                invoke2(str);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                kotlin.jvm.internal.s.i(it, "it");
                FeedDetailEditTextLayout feedDetailEditTextLayout = FeedDetailEditTextLayout.this;
                int i10 = R$id.commentInputEditText;
                Editable text = ((EditTextSelectable) feedDetailEditTextLayout.f(i10)).getText();
                if (text != null) {
                    text.insert(((EditTextSelectable) FeedDetailEditTextLayout.this.f(i10)).getSelectionStart(), it);
                }
            }
        });
    }

    public final void q(@Nullable FeedDetailClickCommentItemTagModel feedDetailClickCommentItemTagModel) {
        if (feedDetailClickCommentItemTagModel != null && !feedDetailClickCommentItemTagModel.getCommentModel().getUser().getMe()) {
            int i10 = R$id.commentInputEditText;
            ((EditTextSelectable) f(i10)).setTag(feedDetailClickCommentItemTagModel);
            if (feedDetailClickCommentItemTagModel.getCommentModel().getWhisper()) {
                Drawable drawable = ContextCompat.getDrawable(getContext(), R$mipmap.message_lock);
                if (drawable != null) {
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                }
                EditTextSelectable clickCommentItem$lambda$2 = (EditTextSelectable) f(i10);
                kotlin.jvm.internal.s.h(clickCommentItem$lambda$2, "clickCommentItem$lambda$2");
                clickCommentItem$lambda$2.setCompoundDrawablePadding(z0.h.c(clickCommentItem$lambda$2, 8.0f));
                clickCommentItem$lambda$2.setCompoundDrawables(drawable, null, null, null);
            } else {
                EditTextSelectable editTextSelectable = (EditTextSelectable) f(i10);
                editTextSelectable.setCompoundDrawables(null, null, null, null);
                editTextSelectable.refreshDrawableState();
            }
            EditTextSelectable editTextSelectable2 = (EditTextSelectable) f(i10);
            editTextSelectable2.setText("");
            editTextSelectable2.setHint(editTextSelectable2.getContext().getString(R$string.comment_in_reply_hint, feedDetailClickCommentItemTagModel.getCommentModel().getUser().getName()));
            s();
            return;
        }
        w();
        r();
    }

    public final void r() {
        Context context = getContext();
        kotlin.jvm.internal.s.h(context, "context");
        z0.h.p(context, (EditTextSelectable) f(R$id.commentInputEditText));
        Function0<kotlin.p> function0 = this.f14451e;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void s() {
        int i10 = R$id.commentInputEditText;
        ((EditTextSelectable) f(i10)).setCursorVisible(true);
        ((EditTextSelectable) f(i10)).setFocusable(true);
        ((EditTextSelectable) f(i10)).setFocusableInTouchMode(true);
        ((EditTextSelectable) f(i10)).requestFocus();
        Context context = getContext();
        kotlin.jvm.internal.s.h(context, "context");
        EditTextSelectable commentInputEditText = (EditTextSelectable) f(i10);
        kotlin.jvm.internal.s.h(commentInputEditText, "commentInputEditText");
        z0.h.v(context, commentInputEditText);
    }

    public final void setFeedModelAndCallback(@Nullable FeedModel feedModel, @Nullable FeedSensorContext feedSensorContext, @Nullable Map<String, ? extends Object> map, @Nullable Function0<kotlin.p> function0, @Nullable Function2<? super Integer, ? super PostCommentModel, kotlin.p> function2, @Nullable Function1<? super Boolean, kotlin.p> function1) {
        this.f14450d = feedModel;
        this.f14454h = feedSensorContext;
        this.f14455i = map;
        this.f14451e = function0;
        this.f14452f = function2;
        this.f14453g = function1;
        EditTextSelectable commentInputEditText = (EditTextSelectable) f(R$id.commentInputEditText);
        kotlin.jvm.internal.s.h(commentInputEditText, "commentInputEditText");
        this.f14456j = new com.cupidapp.live.feed.helper.f(commentInputEditText, function1);
    }

    public final void t() {
        z.a(this, R$layout.layout_feed_detail_edit_text, true);
        EditTextSelectable editTextSelectable = (EditTextSelectable) f(R$id.commentInputEditText);
        editTextSelectable.setHintTextColor(com.cupidapp.live.base.utils.h.a(-15066598, 0.3f));
        editTextSelectable.setInputType(262144);
        editTextSelectable.setSingleLine(false);
        editTextSelectable.setMaxLines(2);
        editTextSelectable.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.cupidapp.live.feed.layout.c
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                boolean u10;
                u10 = FeedDetailEditTextLayout.u(FeedDetailEditTextLayout.this, textView, i10, keyEvent);
                return u10;
            }
        });
        w();
        setEnabledSendImageView(true);
        p();
    }

    public final void v(FeedModel feedModel, PostCommentModel postCommentModel, FeedSensorContext feedSensorContext, String str) {
        User user;
        if (feedModel == null || feedSensorContext == null) {
            return;
        }
        SensorsLogFeed.f12208a.c(feedModel.getUser().userId(), feedModel.getPostId(), feedSensorContext.getScene(), feedSensorContext.getPosition(), str, feedModel.getUser().getAloha(), postCommentModel != null ? postCommentModel.getId() : null, (postCommentModel == null || (user = postCommentModel.getUser()) == null) ? null : user.userId(), feedModel.getStrategyId(), p1.g.f52734a.x());
    }

    public final void w() {
        EditTextSelectable editTextSelectable = (EditTextSelectable) f(R$id.commentInputEditText);
        editTextSelectable.setText("");
        editTextSelectable.setHint(editTextSelectable.getContext().getString(R$string.click_input_comment));
        editTextSelectable.setTag(null);
        editTextSelectable.setCompoundDrawables(null, null, null, null);
        editTextSelectable.refreshDrawableState();
    }

    public final void x() {
        FeedModel feedModel = this.f14450d;
        String postId = feedModel != null ? feedModel.getPostId() : null;
        int i10 = R$id.commentInputEditText;
        final String e2 = z0.t.e(String.valueOf(((EditTextSelectable) f(i10)).getText()));
        if (!(StringsKt__StringsKt.P0(e2).toString().length() == 0)) {
            if (!(postId == null || postId.length() == 0)) {
                com.cupidapp.live.feed.helper.f fVar = this.f14456j;
                List<ReplaceAtModel> f10 = fVar != null ? fVar.f() : null;
                Object tag = ((EditTextSelectable) f(i10)).getTag();
                final FeedDetailClickCommentItemTagModel feedDetailClickCommentItemTagModel = tag instanceof FeedDetailClickCommentItemTagModel ? (FeedDetailClickCommentItemTagModel) tag : null;
                Observable<Result<CommentResult>> u10 = NetworkClient.f11868a.l().u(postId, (feedDetailClickCommentItemTagModel == null || feedDetailClickCommentItemTagModel.getCommentModel().getUser().getMe()) ? null : feedDetailClickCommentItemTagModel.getCommentModel().getId(), e2, GsonUtil.f12000a.b().toJson(f10));
                Object context = getContext();
                Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.layout.FeedDetailEditTextLayout$sendComment$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull Throwable it) {
                        kotlin.jvm.internal.s.i(it, "it");
                        FeedDetailEditTextLayout.this.setEnabledSendImageView(true);
                        return Boolean.FALSE;
                    }
                };
                com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
                Disposable disposed = u10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<CommentResult, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedDetailEditTextLayout$sendComment$$inlined$handleByContext$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(CommentResult commentResult) {
                        m2575invoke(commentResult);
                        return kotlin.p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:5:0x0016, code lost:
                    
                        r1 = r4.this$0.f14452f;
                     */
                    /* renamed from: invoke, reason: collision with other method in class */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void m2575invoke(com.cupidapp.live.feed.model.CommentResult r5) {
                        /*
                            r4 = this;
                            com.cupidapp.live.feed.model.CommentResult r5 = (com.cupidapp.live.feed.model.CommentResult) r5
                            com.cupidapp.live.feed.layout.FeedDetailEditTextLayout r0 = com.cupidapp.live.feed.layout.FeedDetailEditTextLayout.this
                            r1 = 1
                            com.cupidapp.live.feed.layout.FeedDetailEditTextLayout.m(r0, r1)
                            java.util.List r5 = r5.getList()
                            r0 = 0
                            if (r5 == 0) goto L34
                            boolean r2 = r5.isEmpty()
                            r1 = r1 ^ r2
                            if (r1 == 0) goto L34
                            com.cupidapp.live.feed.layout.FeedDetailEditTextLayout r1 = com.cupidapp.live.feed.layout.FeedDetailEditTextLayout.this
                            kotlin.jvm.functions.Function2 r1 = com.cupidapp.live.feed.layout.FeedDetailEditTextLayout.i(r1)
                            if (r1 == 0) goto L34
                            com.cupidapp.live.feed.layout.FeedDetailClickCommentItemTagModel r2 = r2
                            if (r2 == 0) goto L2b
                            int r2 = r2.getClickItemIndex()
                            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                            goto L2c
                        L2b:
                            r2 = r0
                        L2c:
                            r3 = 0
                            java.lang.Object r5 = r5.get(r3)
                            r1.mo1743invoke(r2, r5)
                        L34:
                            com.cupidapp.live.feed.layout.FeedDetailEditTextLayout r5 = com.cupidapp.live.feed.layout.FeedDetailEditTextLayout.this
                            r5.r()
                            com.cupidapp.live.feed.layout.FeedDetailEditTextLayout r5 = com.cupidapp.live.feed.layout.FeedDetailEditTextLayout.this
                            r5.w()
                            com.cupidapp.live.base.view.h r5 = com.cupidapp.live.base.view.h.f12779a
                            com.cupidapp.live.feed.layout.FeedDetailEditTextLayout r1 = com.cupidapp.live.feed.layout.FeedDetailEditTextLayout.this
                            android.content.Context r1 = r1.getContext()
                            r2 = 2131886502(0x7f1201a6, float:1.9407585E38)
                            r5.c(r1, r2)
                            com.cupidapp.live.feed.layout.FeedDetailEditTextLayout r5 = com.cupidapp.live.feed.layout.FeedDetailEditTextLayout.this
                            com.cupidapp.live.feed.model.FeedModel r1 = com.cupidapp.live.feed.layout.FeedDetailEditTextLayout.h(r5)
                            com.cupidapp.live.feed.layout.FeedDetailClickCommentItemTagModel r2 = r2
                            if (r2 == 0) goto L5a
                            com.cupidapp.live.feed.model.PostCommentModel r0 = r2.getCommentModel()
                        L5a:
                            com.cupidapp.live.feed.layout.FeedDetailEditTextLayout r2 = com.cupidapp.live.feed.layout.FeedDetailEditTextLayout.this
                            com.cupidapp.live.base.sensorslog.FeedSensorContext r2 = com.cupidapp.live.feed.layout.FeedDetailEditTextLayout.j(r2)
                            java.lang.String r3 = r3
                            com.cupidapp.live.feed.layout.FeedDetailEditTextLayout.k(r5, r1, r0, r2, r3)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.FeedDetailEditTextLayout$sendComment$$inlined$handleByContext$1.m2575invoke(java.lang.Object):void");
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
                if (disposed != null) {
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                    if (gVar != null) {
                        gVar.H(disposed);
                    }
                }
                kotlin.jvm.internal.s.h(disposed, "disposed");
                return;
            }
        }
        setEnabledSendImageView(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedDetailEditTextLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14457k = new LinkedHashMap();
        t();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedDetailEditTextLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14457k = new LinkedHashMap();
        t();
    }
}
