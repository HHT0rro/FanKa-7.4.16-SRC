package com.cupidapp.live.feed.fragment;

import android.view.View;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.feed.fragment.FeedContainerFragment;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* compiled from: FeedContainerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedContainerFragment$configFeedContainerTitleLayout$1$5 extends Lambda implements Function2<Integer, Boolean, kotlin.p> {
    public final /* synthetic */ FKTitleBarLayout $this_apply;
    public final /* synthetic */ FeedContainerFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedContainerFragment$configFeedContainerTitleLayout$1$5(FKTitleBarLayout fKTitleBarLayout, FeedContainerFragment feedContainerFragment) {
        super(2);
        this.$this_apply = fKTitleBarLayout;
        this.this$0 = feedContainerFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(View view, FeedContainerFragment this$0, FKTitleBarLayout fKTitleBarLayout) {
        kotlin.jvm.internal.s.i(view, "$view");
        kotlin.jvm.internal.s.i(this$0, "this$0");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        this$0.a2(view, iArr[1]);
        fKTitleBarLayout.m(FeedContainerFragment.FeedTabType.Follow.getPageIndex(), R$mipmap.ic_title_arrow_top);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Integer num, Boolean bool) {
        invoke(num.intValue(), bool.booleanValue());
        return kotlin.p.f51048a;
    }

    public final void invoke(int i10, boolean z10) {
        final View titleView;
        if (i10 != FeedContainerFragment.FeedTabType.Follow.getPageIndex() || z10 || !kotlin.jvm.internal.s.d(p1.g.f52734a.w(), Boolean.TRUE) || (titleView = this.$this_apply.getTitleView()) == null) {
            return;
        }
        final FeedContainerFragment feedContainerFragment = this.this$0;
        final FKTitleBarLayout fKTitleBarLayout = this.$this_apply;
        titleView.post(new Runnable() { // from class: com.cupidapp.live.feed.fragment.h
            @Override // java.lang.Runnable
            public final void run() {
                FeedContainerFragment$configFeedContainerTitleLayout$1$5.invoke$lambda$0(View.this, feedContainerFragment, fKTitleBarLayout);
            }
        });
    }
}
