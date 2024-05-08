package com.github.penfeizhou.animation.webp;

import android.content.Context;
import com.github.penfeizhou.animation.FrameAnimationDrawable;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.webp.decode.l;
import i4.a;
import i4.b;
import i4.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class WebPDrawable extends FrameAnimationDrawable<l> {
    public WebPDrawable(c cVar) {
        super(cVar);
    }

    public static WebPDrawable k(Context context, String str) {
        return new WebPDrawable(new a(context, str));
    }

    public static WebPDrawable l(String str) {
        return new WebPDrawable(new b(str));
    }

    @Override // com.github.penfeizhou.animation.FrameAnimationDrawable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public l c(c cVar, FrameSeqDecoder.j jVar) {
        return new l(cVar, jVar);
    }
}
