package com.cupidapp.live.maskparty.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.maskparty.model.MaskPartyQuestionItemModel;
import com.cupidapp.live.maskparty.model.MaskPartyQuestionModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: MaskPartyQuestionLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyQuestionLayout extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f16431f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public m f16432b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final List<List<MaskPartyQuestionItemModel>> f16433c;

    /* renamed from: d, reason: collision with root package name */
    public int f16434d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16435e;

    /* compiled from: MaskPartyQuestionLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MaskPartyQuestionLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            s.i(animation, "animation");
            MaskPartyQuestionLayout.this.setVisibility(0);
            ((RelativeLayout) MaskPartyQuestionLayout.this.b(R$id.question_type_container)).setVisibility(0);
            ((RelativeLayout) MaskPartyQuestionLayout.this.b(R$id.question_list_container)).setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyQuestionLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16435e = new LinkedHashMap();
        this.f16433c = new ArrayList();
        m();
    }

    public static final void j(MaskPartyQuestionLayout this$0) {
        s.i(this$0, "this$0");
        this$0.n();
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f16435e;
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

    public final void h() {
        int i10 = 0;
        if (this.f16434d == this.f16433c.size() - 1) {
            this.f16434d = 0;
        } else {
            this.f16434d++;
        }
        for (MaskPartyQuestionItemModel maskPartyQuestionItemModel : this.f16433c.get(this.f16434d)) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            ((TextView) ((LinearLayout) b(R$id.question_list_layout)).getChildAt(i10).findViewById(R$id.question_text)).setText(maskPartyQuestionItemModel.getContent());
            i10 = i11;
        }
    }

    public final void i(@NotNull List<MaskPartyQuestionModel> modelList) {
        s.i(modelList, "modelList");
        ((LinearLayout) b(R$id.question_type_layout)).removeAllViews();
        for (final MaskPartyQuestionModel maskPartyQuestionModel : modelList) {
            int i10 = R$id.question_type_layout;
            LinearLayout question_type_layout = (LinearLayout) b(i10);
            s.h(question_type_layout, "question_type_layout");
            final View b4 = z.b(question_type_layout, R$layout.mask_party_question_type_view, false, 2, null);
            ImageLoaderView typeImageView = (ImageLoaderView) b4.findViewById(R$id.question_type_image);
            QuestionType a10 = QuestionType.Companion.a(maskPartyQuestionModel.getType());
            if (a10 != null) {
                s.h(typeImageView, "typeImageView");
                ImageLoaderView.f(typeImageView, new com.cupidapp.live.base.imageloader.b(false, null, null, null, Integer.valueOf(a10.getTypeImage()), null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524271, null), null, 2, null);
            }
            y.d(b4, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyQuestionLayout$configQuestionLayout$1$2
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
                    View view2;
                    m mVar;
                    LinearLayout question_type_layout2 = (LinearLayout) MaskPartyQuestionLayout.this.b(R$id.question_type_layout);
                    s.h(question_type_layout2, "question_type_layout");
                    Iterator<View> it = ViewGroupKt.getChildren(question_type_layout2).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            view2 = null;
                            break;
                        } else {
                            view2 = it.next();
                            if (view2.isSelected()) {
                                break;
                            }
                        }
                    }
                    if (view2 != null) {
                        return;
                    }
                    b4.setSelected(true);
                    ((RelativeLayout) MaskPartyQuestionLayout.this.b(R$id.question_type_container)).setVisibility(8);
                    ((RelativeLayout) MaskPartyQuestionLayout.this.b(R$id.question_list_container)).setVisibility(0);
                    MaskPartyQuestionLayout.this.k(maskPartyQuestionModel);
                    mVar = MaskPartyQuestionLayout.this.f16432b;
                    if (mVar != null) {
                        mVar.a(maskPartyQuestionModel.getType());
                    }
                }
            });
            int l10 = (z0.h.l(this) - z0.h.c(this, 48.0f)) / 3;
            ((LinearLayout) b(i10)).addView(b4, new LinearLayout.LayoutParams(l10, (l10 * 5) / 3));
            y.m(b4, Integer.valueOf(z0.h.c(this, 4.0f)), null, Integer.valueOf(z0.h.c(this, 4.0f)), null, 10, null);
        }
        ((LinearLayout) b(R$id.question_type_layout)).post(new Runnable() { // from class: com.cupidapp.live.maskparty.view.l
            @Override // java.lang.Runnable
            public final void run() {
                MaskPartyQuestionLayout.j(MaskPartyQuestionLayout.this);
            }
        });
    }

    public final void k(MaskPartyQuestionModel maskPartyQuestionModel) {
        this.f16434d = 0;
        this.f16433c.clear();
        ((LinearLayout) b(R$id.question_list_layout)).removeAllViews();
        QuestionType a10 = QuestionType.Companion.a(maskPartyQuestionModel.getType());
        if (a10 != null) {
            ((ImageView) b(R$id.question_image)).setImageResource(a10.getTypeTitle());
        }
        int size = maskPartyQuestionModel.getQuestions().size() / 3;
        for (int i10 = 0; i10 < size; i10++) {
            int i11 = i10 * 3;
            this.f16433c.add(maskPartyQuestionModel.getQuestions().subList(i11, i11 + 3));
        }
        Iterator<MaskPartyQuestionItemModel> iterator2 = this.f16433c.get(this.f16434d).iterator2();
        while (iterator2.hasNext()) {
            ((LinearLayout) b(R$id.question_list_layout)).addView(l(iterator2.next().getContent()), new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public final View l(String str) {
        LinearLayout question_list_layout = (LinearLayout) b(R$id.question_list_layout);
        s.h(question_list_layout, "question_list_layout");
        final View b4 = z.b(question_list_layout, R$layout.mask_party_question_view, false, 2, null);
        TextView textView = (TextView) b4.findViewById(R$id.question_text);
        textView.getPaint().setFakeBoldText(true);
        textView.setText(str);
        y.d(b4, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyQuestionLayout$getQuestionItemView$1
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
                View view2;
                List list;
                int i10;
                m mVar;
                LinearLayout question_list_layout2 = (LinearLayout) MaskPartyQuestionLayout.this.b(R$id.question_list_layout);
                s.h(question_list_layout2, "question_list_layout");
                Iterator<View> it = ViewGroupKt.getChildren(question_list_layout2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        view2 = null;
                        break;
                    } else {
                        view2 = it.next();
                        if (view2.isSelected()) {
                            break;
                        }
                    }
                }
                if (view2 != null) {
                    return;
                }
                b4.setSelected(true);
                MaskPartyQuestionLayout.this.setVisibility(8);
                int indexOfChild = ((LinearLayout) MaskPartyQuestionLayout.this.b(R$id.question_list_layout)).indexOfChild(b4);
                list = MaskPartyQuestionLayout.this.f16433c;
                i10 = MaskPartyQuestionLayout.this.f16434d;
                MaskPartyQuestionItemModel maskPartyQuestionItemModel = (MaskPartyQuestionItemModel) ((List) list.get(i10)).get(indexOfChild);
                mVar = MaskPartyQuestionLayout.this.f16432b;
                if (mVar != null) {
                    mVar.b(maskPartyQuestionItemModel);
                }
            }
        });
        return b4;
    }

    public final void m() {
        z.a(this, R$layout.layout_mask_party_question, true);
        setVisibility(8);
        TextView initView$lambda$0 = (TextView) b(R$id.change_next_button);
        initView$lambda$0.getPaint().setFakeBoldText(true);
        s.h(initView$lambda$0, "initView$lambda$0");
        y.d(initView$lambda$0, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyQuestionLayout$initView$1$1
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
                MaskPartyQuestionLayout.this.h();
            }
        });
    }

    public final void n() {
        if (getVisibility() != 0) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<MaskPartyQuestionLayout, Float>) View.ALPHA, 0.0f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    public final void setSelectListener(@NotNull m listener) {
        s.i(listener, "listener");
        this.f16432b = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyQuestionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16435e = new LinkedHashMap();
        this.f16433c = new ArrayList();
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyQuestionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16435e = new LinkedHashMap();
        this.f16433c = new ArrayList();
        m();
    }
}
