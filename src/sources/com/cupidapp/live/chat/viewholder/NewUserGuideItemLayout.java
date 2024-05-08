package com.cupidapp.live.chat.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.chat.service.NewUserGuideItemModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: NewUserGuideViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NewUserGuideItemLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13256b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUserGuideItemLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13256b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13256b;
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

    public final void b(@NotNull NewUserGuideItemModel guide, boolean z10) {
        s.i(guide, "guide");
        ImageLoaderView guide_item_imageview = (ImageLoaderView) a(R$id.guide_item_imageview);
        s.h(guide_item_imageview, "guide_item_imageview");
        ImageLoaderView.g(guide_item_imageview, guide.getIcon(), null, null, 6, null);
        ((TextView) a(R$id.guide_item_title_textview)).setText(guide.getTitle());
        ((TextView) a(R$id.guide_item_content_textview)).setText(guide.getDesc());
        ((TextView) a(R$id.guide_item_action_textview)).setText(guide.getJumpDesc());
        View bottom_line_view = a(R$id.bottom_line_view);
        s.h(bottom_line_view, "bottom_line_view");
        bottom_line_view.setVisibility(z10 ? 0 : 8);
    }

    public final void c() {
        z.a(this, R$layout.layout_new_user_guide_item, true);
        ((TextView) a(R$id.guide_item_title_textview)).getPaint().setFakeBoldText(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUserGuideItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13256b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUserGuideItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13256b = new LinkedHashMap();
        c();
    }
}
