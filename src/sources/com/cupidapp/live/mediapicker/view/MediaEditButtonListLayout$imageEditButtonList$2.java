package com.cupidapp.live.mediapicker.view;

import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.mediapicker.model.MediaEditButtonViewModel;
import java.util.List;
import kotlin.collections.s;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: MediaEditButtonListLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaEditButtonListLayout$imageEditButtonList$2 extends Lambda implements Function0<List<MediaEditButtonViewModel>> {
    public static final MediaEditButtonListLayout$imageEditButtonList$2 INSTANCE = new MediaEditButtonListLayout$imageEditButtonList$2();

    public MediaEditButtonListLayout$imageEditButtonList$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<MediaEditButtonViewModel> invoke() {
        return s.o(new MediaEditButtonViewModel(R$string.edit_frame, R$mipmap.icon_frame, MediaEditButtonViewModel.EditButtonEnum.Frame));
    }
}
