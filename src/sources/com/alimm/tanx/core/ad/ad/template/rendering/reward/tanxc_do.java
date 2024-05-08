package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import com.alimm.tanx.core.view.player.core.PlayerBufferingState;
import com.alimm.tanx.core.view.player.core.PlayerState;
import com.huawei.quickcard.video.VideoAttributes;

/* compiled from: PlayerStateConvert.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_do {
    public static String tanxc_do(PlayerState playerState) {
        return (playerState == PlayerState.IDLE || playerState == PlayerState.INITIALIZED || playerState == PlayerState.PREPARING) ? "preparing" : playerState == PlayerState.PREPARED ? "ready" : playerState == PlayerState.STARTED ? VideoAttributes.Event.PLAYING : (playerState == PlayerState.PAUSED || playerState == PlayerState.STOPPED) ? "pausing" : playerState == PlayerState.ERROR ? "error" : (playerState == PlayerState.COMPLETED || playerState == PlayerState.END) ? "end" : "unknown";
    }

    public static String tanxc_do(PlayerBufferingState playerBufferingState) {
        return playerBufferingState == PlayerBufferingState.BUFFERING_START ? "buffering" : VideoAttributes.Event.PLAYING;
    }
}
