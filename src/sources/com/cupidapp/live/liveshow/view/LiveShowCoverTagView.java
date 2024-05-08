package com.cupidapp.live.liveshow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.liveshow.model.LiveCoverTagModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: LiveShowCoverTagView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowCoverTagView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15310b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowCoverTagView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15310b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15310b;
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

    public final void b(@Nullable LiveCoverTagModel liveCoverTagModel, int i10) {
        if (liveCoverTagModel == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ImageModel image = liveCoverTagModel.getImage();
        Integer valueOf = image != null ? Integer.valueOf(image.getScaleWidthByHeight(i10)) : null;
        int i11 = R$id.live_cover_tag_imageview;
        ImageLoaderView live_cover_tag_imageview = (ImageLoaderView) a(i11);
        s.h(live_cover_tag_imageview, "live_cover_tag_imageview");
        y.n(live_cover_tag_imageview, valueOf, Integer.valueOf(i10));
        ImageLoaderView live_cover_tag_imageview2 = (ImageLoaderView) a(i11);
        s.h(live_cover_tag_imageview2, "live_cover_tag_imageview");
        ImageLoaderView.g(live_cover_tag_imageview2, liveCoverTagModel.getImage(), null, null, 6, null);
        String text = liveCoverTagModel.getText();
        if (text == null || text.length() == 0) {
            TextView live_cover_tag_textview = (TextView) a(R$id.live_cover_tag_textview);
            s.h(live_cover_tag_textview, "live_cover_tag_textview");
            live_cover_tag_textview.setVisibility(8);
        } else {
            int i12 = R$id.live_cover_tag_textview;
            TextView live_cover_tag_textview2 = (TextView) a(i12);
            s.h(live_cover_tag_textview2, "live_cover_tag_textview");
            live_cover_tag_textview2.setVisibility(0);
            ((TextView) a(i12)).setText(liveCoverTagModel.getText());
        }
    }

    public final void c() {
        z.a(this, R$layout.liveshow_cover_tag_view, true);
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowCoverTagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15310b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowCoverTagView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15310b = new LinkedHashMap();
        c();
    }
}
