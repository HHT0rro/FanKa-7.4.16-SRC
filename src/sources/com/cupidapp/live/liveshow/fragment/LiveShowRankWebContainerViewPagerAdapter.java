package com.cupidapp.live.liveshow.fragment;

import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.base.view.viewpager.FKBaseFragmentPagerAdapter;
import com.cupidapp.live.base.web.WebConfigViewModel;
import com.cupidapp.live.base.web.fragment.FKWebViewFragment;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveShowRankWebFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowRankWebContainerViewPagerAdapter extends FKBaseFragmentPagerAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowRankWebContainerViewPagerAdapter(@NotNull FragmentManager manager, @NotNull List<String> webUrls) {
        super(manager);
        s.i(manager, "manager");
        s.i(webUrls, "webUrls");
        Iterator<String> iterator2 = webUrls.iterator2();
        while (iterator2.hasNext()) {
            a().add(FKWebViewFragment.a.e(FKWebViewFragment.f13075p, iterator2.next(), null, new WebConfigViewModel(false, false, false, false, false, null, false, 126, null), 2, null));
        }
    }
}
