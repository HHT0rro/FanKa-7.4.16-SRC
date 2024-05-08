package com.cupidapp.live.notify.adapter;

import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.view.viewpager.FKBaseFragmentPagerAdapter;
import com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment;
import com.cupidapp.live.notify.fragment.AttentionNotifyFragment;
import com.cupidapp.live.notify.fragment.DailyHeartFragment;
import com.cupidapp.live.notify.fragment.PostCommentNotifyFragment;
import com.cupidapp.live.notify.fragment.PostLikeNotifyFragment;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: NotifyContainerViewPagerNewAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NotifyContainerViewPagerNewAdapter extends FKBaseFragmentPagerAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotifyContainerViewPagerNewAdapter(@NotNull FragmentManager manager, boolean z10) {
        super(manager);
        s.i(manager, "manager");
        List<FKBaseFragment> a10 = a();
        a10.add(AttentionNotifyFragment.f17506o.a(z10));
        a10.add(new AiPhotoIdentifyFragment());
        a10.add(new PostLikeNotifyFragment());
        a10.add(new PostCommentNotifyFragment());
        a10.add(new DailyHeartFragment());
    }
}
