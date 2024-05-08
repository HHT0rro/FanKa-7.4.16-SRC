package com.cupidapp.live.base.view;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import com.cupidapp.live.base.utils.ImageSizeModel;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: EndWithIconTextView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class EndWithIconTextView$configData$1 extends Lambda implements Function1<List<? extends com.cupidapp.live.base.view.a>, kotlin.p> {
    public final /* synthetic */ SpannableStringBuilder $builder;
    public final /* synthetic */ List<ImageSizeModel> $imageList;
    public final /* synthetic */ EndWithIconTextView this$0;

    /* compiled from: EndWithIconTextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends ClickableSpan {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<ImageSizeModel> f12454b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f12455c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends ImageSizeModel> list, int i10) {
            this.f12454b = list;
            this.f12455c = i10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            kotlin.jvm.internal.s.i(widget, "widget");
            Function0<kotlin.p> clickCallback = this.f12454b.get(this.f12455c).getClickCallback();
            if (clickCallback != null) {
                clickCallback.invoke();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EndWithIconTextView$configData$1(EndWithIconTextView endWithIconTextView, SpannableStringBuilder spannableStringBuilder, List<? extends ImageSizeModel> list) {
        super(1);
        this.this$0 = endWithIconTextView;
        this.$builder = spannableStringBuilder;
        this.$imageList = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(List<? extends com.cupidapp.live.base.view.a> list) {
        invoke2((List<com.cupidapp.live.base.view.a>) list);
        return kotlin.p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<com.cupidapp.live.base.view.a> list) {
        kotlin.jvm.internal.s.h(list, "list");
        SpannableStringBuilder spannableStringBuilder = this.$builder;
        List<ImageSizeModel> list2 = this.$imageList;
        int i10 = 0;
        for (com.cupidapp.live.base.view.a aVar : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            com.cupidapp.live.base.view.a aVar2 = aVar;
            if (aVar2 != null) {
                spannableStringBuilder.append((CharSequence) " ");
                spannableStringBuilder.setSpan(aVar2, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                spannableStringBuilder.setSpan(new a(list2, i10), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            }
            i10 = i11;
        }
        this.this$0.setText(this.$builder);
        this.this$0.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
