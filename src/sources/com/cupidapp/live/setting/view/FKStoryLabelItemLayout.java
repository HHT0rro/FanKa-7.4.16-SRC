package com.cupidapp.live.setting.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.setting.activity.FKEditStoryLabelActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKStoryLabelItemLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelItemLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public FKStoryLabelItemModel f18204b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function0<p> f18205c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18206d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKStoryLabelItemLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18206d = new LinkedHashMap();
        e();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18206d;
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

    public final void d(@NotNull FKStoryLabelItemModel label, @Nullable Function0<p> function0) {
        s.i(label, "label");
        this.f18204b = label;
        this.f18205c = function0;
        ImageLoaderView story_label_image = (ImageLoaderView) a(R$id.story_label_image);
        s.h(story_label_image, "story_label_image");
        ImageLoaderView.g(story_label_image, label.getIcon(), null, null, 6, null);
        ((TextView) a(R$id.story_label_title)).setText(label.getQuestion());
        ((TextView) a(R$id.story_label_description)).setText(label.getContent());
    }

    public final void e() {
        z.a(this, R$layout.layout_story_label_item, true);
        ((TextView) a(R$id.story_label_title)).getPaint().setFakeBoldText(true);
        ConstraintLayout story_label_layout = (ConstraintLayout) a(R$id.story_label_layout);
        s.h(story_label_layout, "story_label_layout");
        y.i(story_label_layout, (r18 & 1) != 0 ? 0.0f : h.c(this, 12.0f), r.e(0), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : Integer.valueOf(h.c(this, 0.5f)), (r18 & 16) != 0 ? null : -15066598, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
        ImageView story_label_more = (ImageView) a(R$id.story_label_more);
        s.h(story_label_more, "story_label_more");
        y.d(story_label_more, new Function1<View, p>() { // from class: com.cupidapp.live.setting.view.FKStoryLabelItemLayout$initView$1
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
                Function0 function0;
                function0 = FKStoryLabelItemLayout.this.f18205c;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.setting.view.FKStoryLabelItemLayout$initView$2
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
                FKStoryLabelItemModel fKStoryLabelItemModel;
                FKStoryLabelItemModel fKStoryLabelItemModel2;
                fKStoryLabelItemModel = FKStoryLabelItemLayout.this.f18204b;
                s.f(fKStoryLabelItemModel);
                if (fKStoryLabelItemModel.getOnline()) {
                    FKEditStoryLabelActivity.a aVar = FKEditStoryLabelActivity.f17956r;
                    Context context = FKStoryLabelItemLayout.this.getContext();
                    s.h(context, "context");
                    fKStoryLabelItemModel2 = FKStoryLabelItemLayout.this.f18204b;
                    s.f(fKStoryLabelItemModel2);
                    aVar.a(context, fKStoryLabelItemModel2);
                    return;
                }
                com.cupidapp.live.base.view.h.f12779a.r(FKStoryLabelItemLayout.this.getContext(), R$string.story_label_offline_prompt);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKStoryLabelItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18206d = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKStoryLabelItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18206d = new LinkedHashMap();
    }
}
