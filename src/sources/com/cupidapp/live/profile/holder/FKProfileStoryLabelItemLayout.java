package com.cupidapp.live.profile.holder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKProfileStoryLabelViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKProfileStoryLabelItemLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17804b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKProfileStoryLabelItemLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17804b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f17804b;
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

    public final void b(@NotNull FKStoryLabelItemModel label, boolean z10) {
        s.i(label, "label");
        ImageLoaderView profile_label_image = (ImageLoaderView) a(R$id.profile_label_image);
        s.h(profile_label_image, "profile_label_image");
        ImageLoaderView.g(profile_label_image, label.getIcon(), null, null, 6, null);
        ((TextView) a(R$id.profile_label_title)).setText(label.getQuestion());
        int i10 = R$id.profile_label_content;
        ((TextView) a(i10)).setText(label.getContent());
        ((TextView) a(i10)).setMaxLines(z10 ? 1 : 5);
    }

    public final void c() {
        z.a(this, R$layout.layout_profile_story_label_item, true);
        ((TextView) a(R$id.profile_label_content)).getPaint().setFakeBoldText(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKProfileStoryLabelItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17804b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKProfileStoryLabelItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17804b = new LinkedHashMap();
        c();
    }
}
