package androidx.constraintlayout.motion.widget;

/* compiled from: DesignTool.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
interface ProxyInterface {
    int designAccess(int i10, String str, Object obj, float[] fArr, int i11, float[] fArr2, int i12);

    float getKeyFramePosition(Object obj, int i10, float f10, float f11);

    Object getKeyframeAtLocation(Object obj, float f10, float f11);

    Boolean getPositionKeyframe(Object obj, Object obj2, float f10, float f11, String[] strArr, float[] fArr);

    long getTransitionTimeMs();

    void setAttributes(int i10, String str, Object obj, Object obj2);

    void setKeyFrame(Object obj, int i10, String str, Object obj2);

    boolean setKeyFramePosition(Object obj, int i10, int i11, float f10, float f11);

    void setToolPosition(float f10);
}
