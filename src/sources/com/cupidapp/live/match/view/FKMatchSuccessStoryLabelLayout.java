package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKMatchSuccessStoryLabelLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKMatchSuccessStoryLabelLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16857b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKMatchSuccessStoryLabelLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16857b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16857b;
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

    public final void b(@NotNull FKStoryLabelItemModel storyLabel) {
        kotlin.jvm.internal.s.i(storyLabel, "storyLabel");
        ImageLoaderView story_label_icon = (ImageLoaderView) a(R$id.story_label_icon);
        kotlin.jvm.internal.s.h(story_label_icon, "story_label_icon");
        ImageLoaderView.g(story_label_icon, storyLabel.getIcon(), null, null, 6, null);
        ((TextView) a(R$id.story_label_title)).setText(getContext().getString(R$string.content_and_blank, storyLabel.getQuestion()));
        TextView textView = (TextView) a(R$id.story_label_description);
        String content = storyLabel.getContent();
        textView.setText(content != null ? z0.t.c(content) : null);
    }

    public final void c() {
        z0.z.a(this, R$layout.layout_match_success_story_label, true);
        ((TextView) a(R$id.story_label_title)).getPaint().setFakeBoldText(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKMatchSuccessStoryLabelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16857b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKMatchSuccessStoryLabelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16857b = new LinkedHashMap();
        c();
    }
}
