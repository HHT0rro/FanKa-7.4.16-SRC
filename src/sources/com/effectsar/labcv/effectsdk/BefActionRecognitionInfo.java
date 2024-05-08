package com.effectsar.labcv.effectsdk;

import com.effectsar.labcv.effectsdk.BefPublicDefine;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefActionRecognitionInfo {
    public static final int BEF_AI_ACTION_RECOGNITION_MAX_POINT_NUM = 18;
    public static final int FEEDBACK_PART_LEFT_ARM = 1;
    public static final int FEEDBACK_PART_LEFT_LEG = 3;
    public static final int FEEDBACK_PART_NONE = 0;
    public static final int FEEDBACK_PART_RIGHT_ARM = 2;
    public static final int FEEDBACK_PART_RIGHT_LEG = 4;
    public BefPublicDefine.BefKeyPoint[] feedbackKeyPoints;
    public int feedbackPart;
    public boolean isFeedbackValid;
    public BefPublicDefine.BefKeyPoint[] keyPoints;
    public boolean recognizeSucceed;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ActionRecognitionPoseType {
        STAND(1),
        LYING(2),
        SITTING(3),
        SIDELEFT(4),
        SIDERIGHT(5);


        /* renamed from: id, reason: collision with root package name */
        public int f19156id;

        ActionRecognitionPoseType(int i10) {
            this.f19156id = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class PoseDetectResult {
        public boolean isDetected;
    }
}
