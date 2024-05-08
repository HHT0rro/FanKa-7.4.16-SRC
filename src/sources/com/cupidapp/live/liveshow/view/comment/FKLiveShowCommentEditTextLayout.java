package com.cupidapp.live.liveshow.view.comment;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.EditInputBottomSheetDialog;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.base.web.WebStyleEnum;
import com.cupidapp.live.base.web.WebStyleViewModel;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.CommentResult;
import com.cupidapp.live.liveshow.model.LiveCommentGuideItemModel;
import com.cupidapp.live.liveshow.model.LiveCommentGuideModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.model.PropsType;
import com.irisdt.client.live.LiveProtos;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.z;

/* compiled from: FKLiveShowCommentEditTextLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveShowCommentEditTextLayout extends BaseLayout {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f15373h = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public EditInputBottomSheetDialog f15374d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public e f15375e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15376f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15377g;

    /* compiled from: FKLiveShowCommentEditTextLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
            int inputMaxLength = FKLiveShowCommentEditTextLayout.this.getInputMaxLength();
            if (charSequence == null || charSequence.length() <= inputMaxLength) {
                return;
            }
            FKLiveShowCommentEditTextLayout fKLiveShowCommentEditTextLayout = FKLiveShowCommentEditTextLayout.this;
            int i13 = R$id.commentEditText;
            ((EditText) fKLiveShowCommentEditTextLayout.h(i13)).setText(charSequence.subSequence(0, inputMaxLength).toString());
            ((EditText) FKLiveShowCommentEditTextLayout.this.h(i13)).setSelection(Math.min(i10 + i12, inputMaxLength));
            String string = FKLiveShowCommentEditTextLayout.this.getContext().getString(R$string.live_comment_max_word_tips, Integer.valueOf(inputMaxLength));
            s.h(string, "context.getString(\n     …xLength\n                )");
            h.f12779a.m(FKLiveShowCommentEditTextLayout.this.getContext(), string);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveShowCommentEditTextLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15377g = new LinkedHashMap();
        w();
    }

    public static final void B(FKLiveShowCommentEditTextLayout this$0, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        Context context = this$0.getContext();
        s.h(context, "context");
        EditText commentEditText = (EditText) this$0.h(R$id.commentEditText);
        s.h(commentEditText, "commentEditText");
        z0.h.v(context, commentEditText);
        e eVar = this$0.f15375e;
        if (eVar != null) {
            eVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getInputMaxLength() {
        Integer maxMessageTextLength;
        Integer maxHornTextLength;
        if (this.f15376f) {
            LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
            if (fkLiveShowResult == null || (maxHornTextLength = fkLiveShowResult.getMaxHornTextLength()) == null) {
                return 20;
            }
            return maxHornTextLength.intValue();
        }
        LiveShowResult fkLiveShowResult2 = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        if (fkLiveShowResult2 == null || (maxMessageTextLength = fkLiveShowResult2.getMaxMessageTextLength()) == null) {
            return 40;
        }
        return maxMessageTextLength.intValue();
    }

    public static final void o(FKLiveShowCommentEditTextLayout this$0, CompoundButton compoundButton, boolean z10) {
        s.i(this$0, "this$0");
        if (compoundButton.isPressed()) {
            this$0.r(z10, false);
        }
    }

    public static final boolean v(FKLiveShowCommentEditTextLayout this$0, TextView textView, int i10, KeyEvent keyEvent) {
        s.i(this$0, "this$0");
        if (i10 != 4) {
            return true;
        }
        if (this$0.f15376f) {
            this$0.y();
            return true;
        }
        this$0.x();
        return true;
    }

    public final void A() {
        if (this.f15374d == null) {
            Context context = getContext();
            s.h(context, "context");
            EditInputBottomSheetDialog editInputBottomSheetDialog = new EditInputBottomSheetDialog(context, false, 2, null);
            this.f15374d = editInputBottomSheetDialog;
            editInputBottomSheetDialog.setContentView(this);
        }
        EditInputBottomSheetDialog editInputBottomSheetDialog2 = this.f15374d;
        if (editInputBottomSheetDialog2 != null) {
            editInputBottomSheetDialog2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.liveshow.view.comment.b
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    FKLiveShowCommentEditTextLayout.B(FKLiveShowCommentEditTextLayout.this, dialogInterface);
                }
            });
        }
        EditInputBottomSheetDialog editInputBottomSheetDialog3 = this.f15374d;
        if (editInputBottomSheetDialog3 != null) {
            z0.d.g(editInputBottomSheetDialog3, 0.0f);
        }
        EditInputBottomSheetDialog editInputBottomSheetDialog4 = this.f15374d;
        if (editInputBottomSheetDialog4 != null) {
            editInputBottomSheetDialog4.show();
        }
    }

    public final void C(boolean z10, @Nullable Integer num) {
        D(z10);
        s(num);
        q(num);
        A();
    }

    public final void D(boolean z10) {
        LiveCommentGuideModel guide;
        LiveCommentGuideItemModel commentGuide;
        List<String> commonWords;
        if (z10) {
            LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
            if (fkLiveShowResult == null || (guide = fkLiveShowResult.getGuide()) == null || (commentGuide = guide.getCommentGuide()) == null || (commonWords = commentGuide.getCommonWords()) == null) {
                return;
            }
            LiveCommentQuickChatLayout liveCommentQuickChatLayout = (LiveCommentQuickChatLayout) h(R$id.live_comment_quick_chat_layout);
            ArrayList arrayList = new ArrayList(t.t(commonWords, 10));
            Iterator<String> iterator2 = commonWords.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(new LiveCommentQuickChatModel(iterator2.next()));
            }
            liveCommentQuickChatLayout.b(arrayList);
            LiveCommentQuickChatLayout live_comment_quick_chat_layout = (LiveCommentQuickChatLayout) h(R$id.live_comment_quick_chat_layout);
            s.h(live_comment_quick_chat_layout, "live_comment_quick_chat_layout");
            live_comment_quick_chat_layout.setVisibility(0);
            return;
        }
        LiveCommentQuickChatLayout live_comment_quick_chat_layout2 = (LiveCommentQuickChatLayout) h(R$id.live_comment_quick_chat_layout);
        s.h(live_comment_quick_chat_layout2, "live_comment_quick_chat_layout");
        live_comment_quick_chat_layout2.setVisibility(8);
    }

    public final boolean E() {
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        int barrageCardCount = fkLiveShowResult != null ? fkLiveShowResult.getBarrageCardCount() : 0;
        if (!((CheckBox) h(R$id.openBarrageSwitch)).isChecked() || g.f52734a.j() > 0 || barrageCardCount > 0) {
            return false;
        }
        t();
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.liveshow_need_purchase, 0, 2, null), R$string.liveshow_confirm_purchase, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout$showRechargePrompt$1
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
                ConstantsUrlModel urlModel;
                ConstantsResult q10 = g.f52734a.q();
                j.f12156c.a(FKLiveShowCommentEditTextLayout.this.getContext(), (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getUrlPurchasePay(), new WebStyleViewModel(WebStyleEnum.BottomToTopStyle, false, null, 6, null));
            }
        }, 2, null), 0, null, 3, null), null, 1, null);
        return true;
    }

    @Nullable
    public View h(int i10) {
        Map<Integer, View> map = this.f15377g;
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

    public final void m() {
        ((CheckBox) h(R$id.openBarrageSwitch)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cupidapp.live.liveshow.view.comment.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                FKLiveShowCommentEditTextLayout.o(FKLiveShowCommentEditTextLayout.this, compoundButton, z10);
            }
        });
        ((LiveCommentQuickChatLayout) h(R$id.live_comment_quick_chat_layout)).setSelectCallback(new Function1<LiveCommentQuickChatModel, p>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveCommentQuickChatModel liveCommentQuickChatModel) {
                invoke2(liveCommentQuickChatModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull LiveCommentQuickChatModel it) {
                s.i(it, "it");
                FKLiveShowCommentEditTextLayout fKLiveShowCommentEditTextLayout = FKLiveShowCommentEditTextLayout.this;
                int i10 = R$id.commentEditText;
                ((EditText) fKLiveShowCommentEditTextLayout.h(i10)).setText(it.getMessage());
                ((EditText) FKLiveShowCommentEditTextLayout.this.h(i10)).setSelection(it.getMessage().length());
            }
        });
    }

    public final boolean p() {
        EditInputBottomSheetDialog editInputBottomSheetDialog = this.f15374d;
        return editInputBottomSheetDialog != null && editInputBottomSheetDialog.isShowing();
    }

    public final void q(Integer num) {
        boolean z10 = true;
        boolean z11 = num != null && num.intValue() == PropsType.HornCard.getValue();
        this.f15376f = z11;
        if (z11) {
            ((CheckBox) h(R$id.openBarrageSwitch)).setVisibility(8);
            ((ImageView) h(R$id.horn_imageview)).setVisibility(0);
            r(false, true);
            return;
        }
        ((ImageView) h(R$id.horn_imageview)).setVisibility(8);
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        if (fkLiveShowResult != null ? s.d(fkLiveShowResult.getBarrageEnabled(), Boolean.TRUE) : false) {
            int i10 = R$id.openBarrageSwitch;
            ((CheckBox) h(i10)).setVisibility(0);
            CheckBox checkBox = (CheckBox) h(i10);
            if (!((CheckBox) h(i10)).isChecked()) {
                int value = PropsType.BarrageCard.getValue();
                if (num == null || num.intValue() != value) {
                    z10 = false;
                }
            }
            checkBox.setChecked(z10);
            r(((CheckBox) h(i10)).isChecked(), false);
            return;
        }
        ((CheckBox) h(R$id.openBarrageSwitch)).setVisibility(8);
        r(false, false);
    }

    public final void r(boolean z10, boolean z11) {
        String string;
        EditText editText = (EditText) h(R$id.commentEditText);
        if (z10) {
            FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
            LiveShowResult fkLiveShowResult = fKLiveConstantsData.getFkLiveShowResult();
            int barrageCardCount = fkLiveShowResult != null ? fkLiveShowResult.getBarrageCardCount() : 0;
            if (barrageCardCount > 0) {
                string = getContext().getString(R$string.barrage_card_hint, Integer.valueOf(barrageCardCount));
            } else {
                LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
                string = liveShowModel != null ? liveShowModel.getBarrageHintText() : null;
            }
        } else if (z11) {
            string = getContext().getString(R$string.horn_card_hint);
        } else {
            string = getContext().getString(R$string.talk_to_him);
        }
        editText.setHint(string);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (r3.intValue() != r0) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s(java.lang.Integer r3) {
        /*
            r2 = this;
            boolean r0 = r2.f15376f
            if (r0 == 0) goto L13
            com.cupidapp.live.liveshow.model.PropsType r0 = com.cupidapp.live.liveshow.model.PropsType.HornCard
            int r0 = r0.getValue()
            if (r3 != 0) goto Ld
            goto L26
        Ld:
            int r1 = r3.intValue()
            if (r1 != r0) goto L26
        L13:
            boolean r0 = r2.f15376f
            if (r0 != 0) goto L35
            com.cupidapp.live.liveshow.model.PropsType r0 = com.cupidapp.live.liveshow.model.PropsType.HornCard
            int r0 = r0.getValue()
            if (r3 != 0) goto L20
            goto L35
        L20:
            int r3 = r3.intValue()
            if (r3 != r0) goto L35
        L26:
            int r3 = com.cupidapp.live.R$id.commentEditText
            android.view.View r3 = r2.h(r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            android.text.Editable r3 = r3.getText()
            r3.clear()
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout.s(java.lang.Integer):void");
    }

    public final void setCommentListener(@NotNull e listener) {
        s.i(listener, "listener");
        this.f15375e = listener;
    }

    public final void t() {
        EditInputBottomSheetDialog editInputBottomSheetDialog = this.f15374d;
        if (editInputBottomSheetDialog != null) {
            editInputBottomSheetDialog.dismiss();
        }
    }

    public final void u() {
        int i10 = R$id.commentEditText;
        EditText editText = (EditText) h(i10);
        editText.setInputType(262144);
        editText.setSingleLine(true);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.cupidapp.live.liveshow.view.comment.d
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                boolean v2;
                v2 = FKLiveShowCommentEditTextLayout.v(FKLiveShowCommentEditTextLayout.this, textView, i11, keyEvent);
                return v2;
            }
        });
        EditText commentEditText = (EditText) h(i10);
        s.h(commentEditText, "commentEditText");
        commentEditText.addTextChangedListener(new b());
    }

    public final void w() {
        z.a(this, R$layout.layout_live_show_comment_edittext, true);
        u();
        m();
    }

    public final void x() {
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        String itemId = liveShowModel != null ? liveShowModel.getItemId() : null;
        final String obj = StringsKt__StringsKt.P0(((EditText) h(R$id.commentEditText)).getText().toString()).toString();
        if (itemId != null) {
            if ((obj.length() == 0) || E()) {
                return;
            }
            LiveShowResult fkLiveShowResult = fKLiveConstantsData.getFkLiveShowResult();
            final int barrageCardCount = fkLiveShowResult != null ? fkLiveShowResult.getBarrageCardCount() : 0;
            Disposable disposed = NetworkClient.f11868a.r().I(itemId, obj, ((CheckBox) h(R$id.openBarrageSwitch)).isChecked()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<CommentResult, p>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout$sendComment$$inlined$handle$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(CommentResult commentResult) {
                    m2640invoke(commentResult);
                    return p.f51048a;
                }

                /* JADX WARN: Code restructure failed: missing block: B:37:0x0095, code lost:
                
                    if (r0 != r3.intValue()) goto L47;
                 */
                /* JADX WARN: Removed duplicated region for block: B:34:0x008a  */
                /* JADX WARN: Removed duplicated region for block: B:40:0x00a1  */
                /* JADX WARN: Removed duplicated region for block: B:43:0x00d6  */
                /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
                /* renamed from: invoke, reason: collision with other method in class */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void m2640invoke(com.cupidapp.live.liveshow.model.CommentResult r7) {
                    /*
                        r6 = this;
                        com.cupidapp.live.liveshow.model.CommentResult r7 = (com.cupidapp.live.liveshow.model.CommentResult) r7
                        com.cupidapp.live.liveshow.constants.FKLiveConstantsData r0 = com.cupidapp.live.liveshow.constants.FKLiveConstantsData.INSTANCE
                        com.cupidapp.live.liveshow.model.LiveShowResult r1 = r0.getFkLiveShowResult()
                        if (r1 != 0) goto Lb
                        goto L12
                    Lb:
                        int r2 = r7.getBarrageCardCount()
                        r1.setBarrageCardCount(r2)
                    L12:
                        int r1 = r0.getTotalCommentCount()
                        r2 = 1
                        int r1 = r1 + r2
                        r0.setTotalCommentCount(r1)
                        com.cupidapp.live.liveshow.view.comment.LiveCommentGuideHelper r1 = com.cupidapp.live.liveshow.view.comment.LiveCommentGuideHelper.f15387a
                        int r3 = r1.d()
                        int r3 = r3 + r2
                        r1.h(r3)
                        p1.g r3 = p1.g.f52734a
                        long r4 = r7.getBalance()
                        r3.W1(r4)
                        java.lang.String r3 = r7.getBarrageHintText()
                        if (r3 == 0) goto L3e
                        com.cupidapp.live.liveshow.model.LiveShowModel r4 = r0.getLiveShowModel()
                        if (r4 != 0) goto L3b
                        goto L3e
                    L3b:
                        r4.setBarrageHintText(r3)
                    L3e:
                        com.cupidapp.live.liveshow.model.LiveShowResult r3 = r0.getFkLiveShowResult()
                        if (r3 == 0) goto L55
                        com.cupidapp.live.liveshow.model.LiveCommentGuideModel r3 = r3.getGuide()
                        if (r3 == 0) goto L55
                        com.cupidapp.live.liveshow.model.LiveCommentGuideItemModel r3 = r3.getAlohaCommentGuide()
                        if (r3 == 0) goto L55
                        java.lang.Integer r3 = r3.getCommentCount()
                        goto L56
                    L55:
                        r3 = 0
                    L56:
                        com.cupidapp.live.liveshow.model.LiveShowModel r4 = r0.getLiveShowModel()
                        r5 = 0
                        if (r4 == 0) goto L6b
                        com.cupidapp.live.profile.model.User r4 = r4.getUser()
                        if (r4 == 0) goto L6b
                        boolean r4 = r4.getAloha()
                        if (r4 != 0) goto L6b
                        r4 = 1
                        goto L6c
                    L6b:
                        r4 = 0
                    L6c:
                        if (r4 == 0) goto L87
                        com.cupidapp.live.liveshow.model.LiveShowModel r0 = r0.getLiveShowModel()
                        if (r0 == 0) goto L82
                        com.cupidapp.live.profile.model.User r0 = r0.getUser()
                        if (r0 == 0) goto L82
                        boolean r0 = r0.getMe()
                        if (r0 != 0) goto L82
                        r0 = 1
                        goto L83
                    L82:
                        r0 = 0
                    L83:
                        if (r0 == 0) goto L87
                        r0 = 1
                        goto L88
                    L87:
                        r0 = 0
                    L88:
                        if (r0 == 0) goto L98
                        int r0 = r1.d()
                        if (r3 != 0) goto L91
                        goto L98
                    L91:
                        int r1 = r3.intValue()
                        if (r0 != r1) goto L98
                        goto L99
                    L98:
                        r2 = 0
                    L99:
                        com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout r0 = com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout.this
                        com.cupidapp.live.liveshow.view.comment.e r0 = com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout.j(r0)
                        if (r0 == 0) goto Lac
                        boolean r1 = r7.getCommentInvalid()
                        com.cupidapp.live.liveshow.model.CommentModel r3 = r7.getComment()
                        r0.b(r1, r3, r2)
                    Lac:
                        com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout r0 = com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout.this
                        com.cupidapp.live.liveshow.model.CommentModel r7 = r7.getComment()
                        boolean r7 = r7.getBarrage()
                        int r1 = r2
                        java.lang.String r2 = r3
                        com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout.l(r0, r7, r1, r2)
                        com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout r7 = com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout.this
                        int r0 = com.cupidapp.live.R$id.commentEditText
                        android.view.View r7 = r7.h(r0)
                        android.widget.EditText r7 = (android.widget.EditText) r7
                        android.text.Editable r7 = r7.getText()
                        r7.clear()
                        com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout r7 = com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout.this
                        com.cupidapp.live.base.fragment.EditInputBottomSheetDialog r7 = com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout.i(r7)
                        if (r7 == 0) goto Ld9
                        r7.dismiss()
                    Ld9:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout$sendComment$$inlined$handle$default$1.m2640invoke(java.lang.Object):void");
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        }
    }

    public final void y() {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        String itemId = liveShowModel != null ? liveShowModel.getItemId() : null;
        String obj = StringsKt__StringsKt.P0(((EditText) h(R$id.commentEditText)).getText().toString()).toString();
        if (itemId != null) {
            if (obj.length() == 0) {
                return;
            }
            Disposable disposed = NetworkClient.f11868a.r().D0(itemId, obj).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout$sendHornContent$$inlined$handle$default$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj2) {
                    invoke2(obj2);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj2) {
                    EditInputBottomSheetDialog editInputBottomSheetDialog;
                    ((EditText) FKLiveShowCommentEditTextLayout.this.h(R$id.commentEditText)).getText().clear();
                    editInputBottomSheetDialog = FKLiveShowCommentEditTextLayout.this.f15374d;
                    if (editInputBottomSheetDialog != null) {
                        editInputBottomSheetDialog.dismiss();
                    }
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        }
    }

    public final void z(boolean z10, int i10, String str) {
        LiveProtos.Type type;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel != null) {
            if (!z10) {
                type = LiveProtos.Type.COMMON_COMMENT;
            } else if (i10 > 0) {
                type = LiveProtos.Type.NOBILITY_FREE_BULLET_COMMENT;
            } else {
                type = LiveProtos.Type.BULLET_COMMET;
            }
            SensorsLogLiveShow.f12212a.q(liveShowModel.getItemId(), liveShowModel.getUser().userId(), type, str, fKLiveConstantsData.getFkLiveType());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveShowCommentEditTextLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15377g = new LinkedHashMap();
        w();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveShowCommentEditTextLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15377g = new LinkedHashMap();
        w();
    }
}
