package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.feed.activity.MapActivity;
import com.cupidapp.live.feed.model.FeedModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FeedUserInfoLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedUserInfoLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f14503b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public FeedSensorContext f14504c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public FeedModel f14505d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14506e;

    /* compiled from: FeedUserInfoLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14507a;

        static {
            int[] iArr = new int[SensorPosition.values().length];
            try {
                iArr[SensorPosition.Feed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SensorPosition.PostStream.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f14507a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedUserInfoLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14506e = new LinkedHashMap();
        this.f14503b = true;
        c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c2, code lost:
    
        if (r3 == false) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setFeedModel(com.cupidapp.live.feed.model.FeedModel r12) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.layout.FeedUserInfoLayout.setFeedModel(com.cupidapp.live.feed.model.FeedModel):void");
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f14506e;
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

    public final void b(final FeedModel feedModel) {
        if (feedModel.getVenue() != null) {
            int i10 = R$id.feedUserLocationTxt;
            ((TextView) a(i10)).setVisibility(0);
            ((TextView) a(i10)).setText(feedModel.getVenue());
            TextView feedUserLocationTxt = (TextView) a(i10);
            kotlin.jvm.internal.s.h(feedUserLocationTxt, "feedUserLocationTxt");
            y.d(feedUserLocationTxt, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedUserInfoLayout$configUserLocation$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    MapActivity.f14086t.a(FeedUserInfoLayout.this.getContext(), feedModel.getVenue(), feedModel.getLatitude(), feedModel.getLongitude(), feedModel.getVenueAbroad());
                }
            });
            return;
        }
        ((TextView) a(R$id.feedUserLocationTxt)).setVisibility(8);
    }

    public final void c() {
        z.a(this, R$layout.layout_feed_user_info, true);
        ((TextView) a(R$id.feedUserNameTextView)).getPaint().setFakeBoldText(true);
        TextView feedAlohaButton = (TextView) a(R$id.feedAlohaButton);
        kotlin.jvm.internal.s.h(feedAlohaButton, "feedAlohaButton");
        z0.u.a(feedAlohaButton);
    }

    public final boolean getDisplayAlohaBtn() {
        return this.f14503b;
    }

    @Nullable
    public final FeedSensorContext getSensorContext() {
        return this.f14504c;
    }

    public final void setDisplayAlohaBtn(boolean z10) {
        this.f14503b = z10;
    }

    public final void setFeedUserInfo(@Nullable FeedModel feedModel) {
        setFeedModel(feedModel);
    }

    public final void setSensorContext(@Nullable FeedSensorContext feedSensorContext) {
        this.f14504c = feedSensorContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedUserInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14506e = new LinkedHashMap();
        this.f14503b = true;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedUserInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14506e = new LinkedHashMap();
        this.f14503b = true;
        c();
    }
}
