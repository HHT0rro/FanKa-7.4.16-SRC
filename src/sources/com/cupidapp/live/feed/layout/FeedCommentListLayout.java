package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.PostCommentModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FeedCommentListLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedCommentListLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14449b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedCommentListLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14449b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f14449b;
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

    public final void b(@Nullable FeedModel feedModel, @Nullable FeedSensorContext feedSensorContext) {
        if (feedModel == null) {
            return;
        }
        int i10 = R$id.commentListLayout;
        ((LinearLayout) a(i10)).removeAllViews();
        List<PostCommentModel> recentComments = feedModel.getRecentComments();
        if (recentComments != null && recentComments.isEmpty()) {
            ((LinearLayout) a(i10)).setVisibility(8);
            return;
        }
        ((LinearLayout) a(i10)).setVisibility(0);
        ArrayList arrayList = new ArrayList();
        List<PostCommentModel> recentComments2 = feedModel.getRecentComments();
        if (recentComments2 != null) {
            for (PostCommentModel postCommentModel : recentComments2) {
                arrayList.add(postCommentModel);
                List<PostCommentModel> nextLevelComments = postCommentModel.getNextLevelComments();
                if (!(nextLevelComments == null || nextLevelComments.isEmpty())) {
                    arrayList.addAll(postCommentModel.getNextLevelComments());
                }
            }
        }
        int i11 = 0;
        for (Object obj : arrayList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.s.s();
            }
            PostCommentModel postCommentModel2 = (PostCommentModel) obj;
            if (postCommentModel2.getUser() != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (i11 != arrayList.size() - 1) {
                    layoutParams.setMargins(0, 0, 0, z0.h.c(this, 4.0f));
                }
                Context context = getContext();
                kotlin.jvm.internal.s.h(context, "context");
                FeedCommentItemLayout feedCommentItemLayout = new FeedCommentItemLayout(context);
                feedCommentItemLayout.setLayoutParams(layoutParams);
                feedCommentItemLayout.c(postCommentModel2, feedSensorContext, feedModel);
                ((LinearLayout) a(R$id.commentListLayout)).addView(feedCommentItemLayout);
            }
            i11 = i12;
        }
    }

    public final void c() {
        z.a(this, R$layout.layout_feed_comment_list, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedCommentListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14449b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedCommentListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14449b = new LinkedHashMap();
        c();
    }
}
