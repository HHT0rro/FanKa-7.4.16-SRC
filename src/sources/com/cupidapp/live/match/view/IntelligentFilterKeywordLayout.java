package com.cupidapp.live.match.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.match.event.ShowPurchaseDialogEvent;
import com.cupidapp.live.match.event.ShowRainbowVipPurchaseGuideEvent;
import com.cupidapp.live.match.model.IntelligentFilterKeywordResult;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.match.view.IntelligentFilterKeywordLayout;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IntelligentFilterKeywordLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class IntelligentFilterKeywordLayout extends BaseLayout {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f16931g = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public u f16932d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16933e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16934f;

    /* compiled from: IntelligentFilterKeywordLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* compiled from: IntelligentFilterKeywordLayout.kt */
        @kotlin.d
        /* renamed from: com.cupidapp.live.match.view.IntelligentFilterKeywordLayout$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class C0165a implements u {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AlertDialog f16935a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1<String, kotlin.p> f16936b;

            /* JADX WARN: Multi-variable type inference failed */
            public C0165a(AlertDialog alertDialog, Function1<? super String, kotlin.p> function1) {
                this.f16935a = alertDialog;
                this.f16936b = function1;
            }

            @Override // com.cupidapp.live.match.view.u
            public void a() {
                this.f16935a.dismiss();
            }

            @Override // com.cupidapp.live.match.view.u
            public void b(@NotNull String keyword) {
                kotlin.jvm.internal.s.i(keyword, "keyword");
                this.f16936b.invoke(keyword);
                this.f16935a.dismiss();
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void c(IntelligentFilterKeywordLayout layout, DialogInterface dialogInterface) {
            kotlin.jvm.internal.s.i(layout, "$layout");
            layout.o();
            j1.c.b(j1.c.f50228a, SensorPosition.INTELLIGENT_FILTER, null, null, 6, null);
        }

        public final void b(@NotNull Context context, @Nullable String str, boolean z10, @NotNull Function1<? super String, kotlin.p> selectCallback) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(selectCallback, "selectCallback");
            final IntelligentFilterKeywordLayout intelligentFilterKeywordLayout = new IntelligentFilterKeywordLayout(context);
            AlertDialog create = z0.b.f54812a.e(context).setView(intelligentFilterKeywordLayout).create();
            intelligentFilterKeywordLayout.l(str, z10);
            intelligentFilterKeywordLayout.setListener(new C0165a(create, selectCallback));
            create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.match.view.t
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    IntelligentFilterKeywordLayout.a.c(IntelligentFilterKeywordLayout.this, dialogInterface);
                }
            });
            create.show();
            Window window = create.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setWindowAnimations(R$style.dialog_translate_anim);
                window.setLayout(-1, -2);
            }
        }
    }

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            if (editable == null || editable.length() == 0) {
                ((ImageView) IntelligentFilterKeywordLayout.this.g(R$id.filter_clear_img)).setVisibility(8);
            } else {
                ((ImageView) IntelligentFilterKeywordLayout.this.g(R$id.filter_clear_img)).setVisibility(0);
            }
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
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
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
            if (charSequence == null || charSequence.length() <= 50) {
                return;
            }
            IntelligentFilterKeywordLayout intelligentFilterKeywordLayout = IntelligentFilterKeywordLayout.this;
            int i13 = R$id.filter_edit_text;
            ((EditText) intelligentFilterKeywordLayout.g(i13)).setText(charSequence.subSequence(0, 50).toString());
            ((EditText) IntelligentFilterKeywordLayout.this.g(i13)).setSelection(Math.min(i10 + i12, 50));
            String string = IntelligentFilterKeywordLayout.this.getContext().getString(R$string.enter_up_any_characters, 50);
            kotlin.jvm.internal.s.h(string, "context.getString(R.stri…ers, TEXT_MAX_WORD_COUNT)");
            com.cupidapp.live.base.view.h.f12779a.m(IntelligentFilterKeywordLayout.this.getContext(), string);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntelligentFilterKeywordLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16934f = new LinkedHashMap();
        this.f16933e = true;
        m();
    }

    public static final boolean j(IntelligentFilterKeywordLayout this$0, TextView textView, int i10, KeyEvent keyEvent) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (i10 != 3) {
            return true;
        }
        if (!com.cupidapp.live.profile.logic.c.f17839a.b() && this$0.f16933e) {
            EventBus c4 = EventBus.c();
            VipPurchaseEntranceType vipPurchaseEntranceType = VipPurchaseEntranceType.IntelligentFilter;
            c4.l(new ShowRainbowVipPurchaseGuideEvent(vipPurchaseEntranceType));
            EventBus.c().l(new ShowPurchaseDialogEvent(vipPurchaseEntranceType, null, PurchaseProductType.SSVIP));
            return true;
        }
        String obj = ((EditText) this$0.g(R$id.filter_edit_text)).getText().toString();
        GroupOthersLog.f18702a.c0(SensorPosition.INTELLIGENT_FILTER, obj);
        u uVar = this$0.f16932d;
        if (uVar == null) {
            return true;
        }
        uVar.b(obj);
        return true;
    }

    public static final void p(IntelligentFilterKeywordLayout this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        Context context = this$0.getContext();
        kotlin.jvm.internal.s.h(context, "context");
        EditText filter_edit_text = (EditText) this$0.g(R$id.filter_edit_text);
        kotlin.jvm.internal.s.h(filter_edit_text, "filter_edit_text");
        z0.h.v(context, filter_edit_text);
    }

    @Nullable
    public View g(int i10) {
        Map<Integer, View> map = this.f16934f;
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

    public final void i() {
        int i10 = R$id.filter_edit_text;
        ((EditText) g(i10)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.cupidapp.live.match.view.r
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                boolean j10;
                j10 = IntelligentFilterKeywordLayout.j(IntelligentFilterKeywordLayout.this, textView, i11, keyEvent);
                return j10;
            }
        });
        EditText filter_edit_text = (EditText) g(i10);
        kotlin.jvm.internal.s.h(filter_edit_text, "filter_edit_text");
        filter_edit_text.addTextChangedListener(new b());
        EditText filter_edit_text2 = (EditText) g(i10);
        kotlin.jvm.internal.s.h(filter_edit_text2, "filter_edit_text");
        filter_edit_text2.addTextChangedListener(new c());
        ImageView filter_clear_img = (ImageView) g(R$id.filter_clear_img);
        kotlin.jvm.internal.s.h(filter_clear_img, "filter_clear_img");
        z0.y.d(filter_clear_img, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.IntelligentFilterKeywordLayout$bindClickEvent$4
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
                ((EditText) IntelligentFilterKeywordLayout.this.g(R$id.filter_edit_text)).setText((CharSequence) null);
            }
        });
        TextView filter_cancel_btn = (TextView) g(R$id.filter_cancel_btn);
        kotlin.jvm.internal.s.h(filter_cancel_btn, "filter_cancel_btn");
        z0.y.d(filter_cancel_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.IntelligentFilterKeywordLayout$bindClickEvent$5
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
                u uVar;
                uVar = IntelligentFilterKeywordLayout.this.f16932d;
                if (uVar != null) {
                    uVar.a();
                }
            }
        });
    }

    public final void k() {
        Disposable disposed = NetworkClient.f11868a.A().w().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<IntelligentFilterKeywordResult, kotlin.p>() { // from class: com.cupidapp.live.match.view.IntelligentFilterKeywordLayout$callHotKeywordApi$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(IntelligentFilterKeywordResult intelligentFilterKeywordResult) {
                m2719invoke(intelligentFilterKeywordResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2719invoke(IntelligentFilterKeywordResult intelligentFilterKeywordResult) {
                Map<String, List<String>> matchKeywords = intelligentFilterKeywordResult.getMatchKeywords();
                if (matchKeywords != null) {
                    IntelligentFilterRcmdWordLayout intelligentFilterRcmdWordLayout = (IntelligentFilterRcmdWordLayout) IntelligentFilterKeywordLayout.this.g(R$id.filter_words_layout);
                    final IntelligentFilterKeywordLayout intelligentFilterKeywordLayout = IntelligentFilterKeywordLayout.this;
                    intelligentFilterRcmdWordLayout.f(matchKeywords, new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.match.view.IntelligentFilterKeywordLayout$callHotKeywordApi$1$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                            invoke2(str);
                            return kotlin.p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull String keyword) {
                            kotlin.jvm.internal.s.i(keyword, "keyword");
                            IntelligentFilterKeywordLayout intelligentFilterKeywordLayout2 = IntelligentFilterKeywordLayout.this;
                            int i10 = R$id.filter_edit_text;
                            ((EditText) intelligentFilterKeywordLayout2.g(i10)).setText(keyword);
                            ((EditText) IntelligentFilterKeywordLayout.this.g(i10)).setSelection(keyword.length());
                            GroupOthersLog.f18702a.b0(keyword);
                        }
                    });
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
    
        if ((r4.length() > 0) == true) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l(@org.jetbrains.annotations.Nullable java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            r3.f16933e = r5
            int r5 = com.cupidapp.live.R$id.filter_edit_text
            android.view.View r0 = r3.g(r5)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r0.setText(r4)
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L1d
            int r2 = r4.length()
            if (r2 <= 0) goto L19
            r2 = 1
            goto L1a
        L19:
            r2 = 0
        L1a:
            if (r2 != r0) goto L1d
            goto L1e
        L1d:
            r0 = 0
        L1e:
            if (r0 == 0) goto L2d
            android.view.View r5 = r3.g(r5)
            android.widget.EditText r5 = (android.widget.EditText) r5
            int r4 = r4.length()
            r5.setSelection(r4)
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.IntelligentFilterKeywordLayout.l(java.lang.String, boolean):void");
    }

    public final void m() {
        z0.z.a(this, R$layout.layout_intelligent_filter_keyword, true);
        k();
        i();
    }

    public final void o() {
        postDelayed(new Runnable() { // from class: com.cupidapp.live.match.view.s
            @Override // java.lang.Runnable
            public final void run() {
                IntelligentFilterKeywordLayout.p(IntelligentFilterKeywordLayout.this);
            }
        }, 60L);
    }

    public final void setListener(@NotNull u listener) {
        kotlin.jvm.internal.s.i(listener, "listener");
        this.f16932d = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntelligentFilterKeywordLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16934f = new LinkedHashMap();
        this.f16933e = true;
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntelligentFilterKeywordLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16934f = new LinkedHashMap();
        this.f16933e = true;
        m();
    }
}
