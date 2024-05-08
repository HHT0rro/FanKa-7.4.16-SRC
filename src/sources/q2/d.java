package q2;

import android.content.Context;
import android.view.OrientationEventListener;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;

/* compiled from: OrientationSensor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static OrientationEventListener f53026a;

    /* renamed from: b, reason: collision with root package name */
    public static int f53027b;

    /* compiled from: OrientationSensor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a extends OrientationEventListener {
        public a(Context context, int i10) {
            super(context, i10);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i10) {
            int i11;
            if (i10 == -1 || (i11 = (((i10 + 45) / 90) * 90) % 360) == d.f53027b) {
                return;
            }
            d.f53027b = i11;
        }
    }

    public static EffectsSDKEffectConstants.Rotation c() {
        int i10 = f53027b;
        if (i10 == 90) {
            return EffectsSDKEffectConstants.Rotation.CLOCKWISE_ROTATE_90;
        }
        if (i10 == 180) {
            return EffectsSDKEffectConstants.Rotation.CLOCKWISE_ROTATE_180;
        }
        if (i10 != 270) {
            return EffectsSDKEffectConstants.Rotation.CLOCKWISE_ROTATE_0;
        }
        return EffectsSDKEffectConstants.Rotation.CLOCKWISE_ROTATE_270;
    }

    public static void d(Context context) {
        if (f53026a != null) {
            return;
        }
        a aVar = new a(context, 3);
        f53026a = aVar;
        if (aVar.canDetectOrientation()) {
            f53026a.enable();
        } else {
            f53026a = null;
        }
    }

    public static void e() {
        OrientationEventListener orientationEventListener = f53026a;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        f53026a = null;
        f53027b = 0;
    }
}
