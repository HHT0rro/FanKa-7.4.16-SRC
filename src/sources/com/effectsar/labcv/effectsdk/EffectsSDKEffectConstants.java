package com.effectsar.labcv.effectsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class EffectsSDKEffectConstants {
    public static final int BEF_DETECT_SMALL_MODEL = 2097152;
    public static final int BEF_SKELETON_MAX_NUM = 2;
    public static final String TAG = "bef_effect_ai";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum BachSkeletonParamType {
        BEF_AI_BACH_SKELETON_BODY_MAX_COUNT(0),
        BEF_AI_BACH_SKELETON_FORCE_DETECT(1),
        BEF_AI_BACH_SKELETON_IMAGE_MODE(2);

        private int value;

        BachSkeletonParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum C1ModelType {
        BEF_AI_C1_MODEL_SMALL(1),
        BEF_AI_C1_MODEL_LARGE(2);

        private int value;

        C1ModelType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum C1ParamType {
        BEF_AI_C1_USE_VIDEO_MODE(1),
        BEF_AI_C1_USE_MultiLabels(2);

        private int value;

        C1ParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum C2ModelType {
        BEF_AI_kC2Model1(1);

        private int value;

        C2ModelType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum C2ParamType {
        BEF_AI_C2_USE_VIDEO_MODE(0),
        BEF_AI_C2_USE_MultiLabels(1);

        private int value;

        C2ParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum CarModelType {
        DetectModel(1),
        BrandNodel(2),
        OCRModel(3),
        TrackModel(4);

        private int value;

        CarModelType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum CarParamType {
        BEF_Car_Detect(1),
        BEF_Brand_Rec(2);

        private int value;

        CarParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ChromaKeyingParamType {
        BEF_AI_CHROMA_KEYING_METHOD(0),
        BEF_AI_CHROMA_KEYING_CAL_COLOR(1),
        BEF_AI_CHROMA_KEYING_BG_R(2),
        BEF_AI_CHROMA_KEYING_BG_G(3),
        BEF_AI_CHROMA_KEYING_BG_B(4),
        BEF_AI_CHROMA_KEYING_BALP(5),
        BEF_AI_CHROMA_KEYING_KALP(6),
        BEF_AI_CHROMA_KEYING_SMOOTH(7),
        BEF_AI_CHROMA_KEYING_SHARPEN(8),
        BEF_AI_CHROMA_KEYING_GET_MASK(9);

        private int value;

        ChromaKeyingParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class DetectMode {
        public static final int BEF_DETECT_MODE_IMAGE = 262144;
        public static final int BEF_DETECT_MODE_IMAGE_SLOW = 524288;
        public static final int BEF_DETECT_MODE_VIDEO = 131072;
        public static final int BEF_DETECT_MODE_VIDEO_SLOW = 65536;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum DynamicActionModelType {
        BEF_AI_DYNAMIC_ACTION_MODEL_SK(1),
        BEF_AI_DYNAMIC_ACTION_MODEL_DETECT(2),
        BEF_AI_DYNAMIC_ACTION_MODEL_DYNAMIC_ACTION(4);

        private int value;

        DynamicActionModelType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum DynamicActionParamType {
        BEF_AI_DYNAMIC_ACTION_REFRESH_FRAME_INTERVAL(1),
        BEF_AI_DYNAMIC_ACTION_MAX_PERSON_NUM(2);

        private int value;

        DynamicActionParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum DynamicGestureParamType {
        BEF_AI_DYNGEST_REFRESH_FRAME_INTERVAL(0),
        BEF_AI_DYNAMIC_GESTURE_NUM_REQ_FRAMES(1),
        BEF_AI_DYNAMIC_GESTURE_FRAMES_INTERVAL(2),
        BEF_AI_DYNAMIC_GESTURE_MODEL_GESTURE_CLS(3);

        private int value;

        DynamicGestureParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class EffectsSDKResultCode {
        public static final int BEF_RESULT_FAIL = -1;
        public static final int BEF_RESULT_FAIL_DATA_ERROR = -3;
        public static final int BEF_RESULT_FILE_NOT_FIND = -2;
        public static final int BEF_RESULT_INVALID_HANDLE = -4;
        public static final int BEF_RESULT_INVALID_IMAGE_FORMAT = -7;
        public static final int BEF_RESULT_INVALID_LICENSE = -114;
        public static final int BEF_RESULT_MODEL_LOAD_FAILURE = -8;
        public static final int BEF_RESULT_SUC = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class FaceAction {
        public static final int BEF_BROW_RAISE = 32;
        public static final int BEF_DETECT_FULL = 127;
        public static final int BEF_EYE_BLINK = 2;
        public static final int BEF_FACE_DETECT = 1;
        public static final int BEF_HEAD_NOD = 16;
        public static final int BEF_HEAD_SHAKE = 8;
        public static final int BEF_MOUTH_AH = 4;
        public static final int BEF_MOUTH_POUT = 64;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class FaceAttribute {
        public static final int BEF_FACE_ATTRIBUTE_AGE = 1;
        public static final int BEF_FACE_ATTRIBUTE_ATTRACTIVE = 8;
        public static final int BEF_FACE_ATTRIBUTE_CONFUSE = 1024;
        public static final int BEF_FACE_ATTRIBUTE_EXPRESSION = 4;
        public static final int BEF_FACE_ATTRIBUTE_GENDER = 2;
        public static final int BEF_FACE_ATTRIBUTE_HAPPINESS = 16;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class FaceDetectType {
        public static final int BEF_FACE_PARAM_BASE_SMOOTH_LEVEL = 4;
        public static final int BEF_FACE_PARAM_EXTRA_SMOOTH_LEVEL = 5;
        public static final int BEF_FACE_PARAM_FACE_DETECT_INTERVAL = 1;
        public static final int BEF_FACE_PARAM_MASK_SMOOTH_TYPE = 6;
        public static final int BEF_FACE_PARAM_MAX_FACE_NUM = 2;
        public static final int BEF_FACE_PARAM_MIN_DETECT_LEVEL = 3;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class FaceExpression {
        public static final int BEF_FACE_ATTRIBUTE_ANGRY = 0;
        public static final int BEF_FACE_ATTRIBUTE_DISGUST = 1;
        public static final int BEF_FACE_ATTRIBUTE_FEAR = 2;
        public static final int BEF_FACE_ATTRIBUTE_HAPPY = 3;
        public static final int BEF_FACE_ATTRIBUTE_NEUTRAL = 6;
        public static final int BEF_FACE_ATTRIBUTE_NUM_EXPRESSION = 7;
        public static final int BEF_FACE_ATTRIBUTE_SAD = 4;
        public static final int BEF_FACE_ATTRIBUTE_SURPRISE = 5;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class FaceExtraModel {
        public static final int BEF_MOBILE_FACE_240_DETECT = 256;
        public static final int BEF_MOBILE_FACE_240_DETECT_FASTMODE = 3145728;
        public static final int BEF_MOBILE_FACE_280_DETECT = 2304;

        public FaceExtraModel() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum FaceFittingCameraType {
        BEF_AI_FACEFITTING_Camera_Orthographic(0),
        BEF_AI_FACEFITTING_Camera_Perspective(1);

        private int value;

        FaceFittingCameraType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum FaceFittingParam {
        BEF_AI_FACEFITTING_Solver_Lambda(1),
        BEF_AI_FACEFITTING_Solver_MaxIter(2),
        BEF_AI_FACEFITTING_Solver_Eps(3),
        BEF_AI_FACEFITTING_Solver_Ratio(4),
        BEF_AI_FACEFITTING_Solver_Smooth(5),
        BEF_AI_FACEFITTING_Solver_Camera_Type(6),
        BEF_AI_FACEFITTING_Config_Cal_TB(7),
        BEF_AI_FACEFITTING_Eyelash_Flag(8),
        BEF_AI_FACEFITTING_Use_Semantic_Lmk(9),
        BEF_AI_FACEFITTING_Mouth_BS_Limit(10);

        private int value;

        FaceFittingParam(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum FaceMaskType {
        FACE_MASK_FACE(3),
        FACE_MASK_TEETH(2),
        FACE_MASK_MOUTH(1);

        private int value;

        FaceMaskType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class FaceRacial {
        public static final int BEF_FACE_ATTRIBUTE_BLACK = 3;
        public static final int BEF_FACE_ATTRIBUTE_INDIAN = 2;
        public static final int BEF_FACE_ATTRIBUTE_NUM_RACIAL = 4;
        public static final int BEF_FACE_ATTRIBUTE_WHITE = 0;
        public static final int BEF_FACE_ATTRIBUTE_YELLOW = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class FaceSegmentConfig {
        public static final int BEFF_MOBILE_FACE_REST_MASK = 1280;
        public static final int BEF_MOBILE_FACE_MOUTH_MASK = 768;
        public static final int BEF_MOBILE_FACE_TEETH_MASK = 768;

        public FaceSegmentConfig() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class FaceSegmentType {
        public static final int BEF_FACE_FACE_MASK = 3;
        public static final int BEF_FACE_MOUTH_MASK = 1;
        public static final int BEF_FACE_TEETH_MASK = 2;

        public FaceSegmentType() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum GazeEstimationModelType {
        BEF_GAZE_ESTIMATION_MODEL1(1);

        private int value;

        GazeEstimationModelType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum GazeEstimationParamType {
        BEF_GAZE_ESTIMATION_EDGE_MODE(1),
        BEF_GAZE_ESTIMATION_CAMERA_FOV(2),
        BEF_GAZE_ESTIMATION_DIVERGENCE(3);

        private int value;

        GazeEstimationParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum GeneralObjectModelType {
        BEF_AI_GENERAL_OBJECT_PURE_DETECT(1),
        BEF_AI_GENERAL_OBJECT_DETECT_CLS(2),
        BEF_AI_GENERAL_OBJECT_CLS_NAME(3),
        BEF_AI_GENERAL_OBJECT_DETECT_TRACK(4);

        private int value;

        GeneralObjectModelType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum GeneralObjectParamType {
        BEF_AI_GENERAL_OBJECT_DETECT_SHORT_SIDE_LEN(1);

        private int value;

        GeneralObjectParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum GestureEventCode {
        TAP(0),
        PAN(1),
        ROTATE(2),
        SCALE(3),
        LONG_PRESS(4),
        DOUBLE_CLICK(5);

        private final int code;

        GestureEventCode(int i10) {
            this.code = i10;
        }

        public int getCode() {
            return this.code;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum HandModelType {
        BEF_HAND_MODEL_DETECT(1),
        BEF_HAND_MODEL_BOX_REG(2),
        BEF_HAND_MODEL_GESTURE_CLS(4),
        BEF_HAND_MODEL_KEY_POINT(8);

        private int value;

        HandModelType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum HandParamType {
        BEF_HAND_MAX_HAND_NUM(2),
        BEF_HAND_DETECT_MIN_SIDE(3),
        BEF_HAND_CLS_SMOOTH_FACTOR(4),
        BEF_HAND_USE_ACTION_SMOOTH(5),
        BEF_HAND_ALGO_LOW_POWER_MODE(6),
        BEF_HAND_ALGO_AUTO_MODE(7),
        BEF_HAND_ALGO_TIME_ELAPSED_THRESHOLD(8),
        BEF_HAND_ALGO_MAX_TEST_FRAME(9),
        BEF_HAND_IS_USE_DOUBLE_GESTURE(10),
        BEF_HNAD_ENLARGE_FACTOR_REG(11),
        BEF_HAND_NARUTO_GESTUER(12);

        private int value;

        HandParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum HeadSegmentParamType {
        BEF_AI_HS_ENABLE_TRACKING(1),
        BEF_AI_HS_MAX_FACE(2);

        private int value;

        HeadSegmentParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum HumanDistanceModelType {
        BEF_HUMAN_DISTANCE_MODEL1(1);

        private int value;

        HumanDistanceModelType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum HumanDistanceParamType {
        BEF_HumanDistanceEdgeMode(0),
        BEF_HumanDistanceCameraFov(1);

        private int value;

        HumanDistanceParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ImageQualityAsfSceneMode {
        ASF_SCENE_MODE_LIVE_GAME(0),
        ASF_SCENE_MODE_LIVE_PEOPLE(1),
        ASF_SCENE_MODE_LIVE_EDIT(2),
        ASF_SCENE_MODE_LIVE_RECORED_MAIN(3),
        ASF_SCENE_MODE_LIVE_RECORED_FRONT(4);

        private final int mode;

        ImageQualityAsfSceneMode(int i10) {
            this.mode = i10;
        }

        public int getMode() {
            return this.mode;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ImageQualityOnekeyEnhanceSceneMode {
        SCENE_MODE_MOBILE_EDITOR(0),
        SCENE_MODE_MOBILE_RECORDE(1),
        SCENE_MODE_MOBILE_LIVE(2),
        SCENE_MODE_MOBILE_RTC(3),
        SCENE_MODE_PC_EDITOR(4),
        SCENE_MODE_PC_LIVE(5),
        SCENE_MODE_PC_RTC(6),
        SCENE_MODE_TRANSCODING(7);

        private final int mode;

        ImageQualityOnekeyEnhanceSceneMode(int i10) {
            this.mode = i10;
        }

        public int getMode() {
            return this.mode;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ImageQualityPostProcessType {
        IMAGE_QUALITY_POST_PROCESS_TYPE_NONE,
        IMAGE_QUALITY_POST_PROCESS_TYPE_VFI
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ImageQualityType {
        IMAGE_QUALITY_TYPE_NONE,
        IMAGE_QUALITY_TYPE_VIDEO_SR,
        IMAGE_QUALITY_TYPE_NIGHT_SCENE,
        IMAGE_QUALITY_TYPE_ADAPTIVE_SHARPEN,
        IMAGE_QUALITY_TYPE_ONEKEY_ENHANCE,
        IMAGE_QUALITY_TYPE_VIDAS,
        IMAGE_QUALITY_TYPE_TAINT_DETECT,
        IMAGE_QUALITY_TYPE_CINE_MOVE_ALG_SNAKE_V8,
        IMAGE_QUALITY_TYPE_CINE_MOVE_ALG_HEART_BEAT_V9,
        IMAGE_QUALITY_TYPE_CINE_MOVE_ALG_BREATH_V10,
        IMAGE_QUALITY_TYPE_CINE_MOVE_ALG_ROT360_V11
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ImageQualityVfiDataType {
        IMAGE_QUALITY_VFI_DATA_TYPE_BUFFER_RGBA8888(0),
        IMAGE_QUALITY_VFI_DATA_TYPE_TEXTURE_RGBA8(1);

        private int value;

        ImageQualityVfiDataType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ImageQualityVfiType {
        IMAGE_QUALITY_VFI_TYPE_UM(0),
        IMAGE_QUALITY_VFI_TYPE_COVER(1);

        private int value;

        ImageQualityVfiType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ImageQualityVidaType {
        VIDA_TYPE_FACE(0),
        VIDA_TYPE_AES(1),
        VIDA_TYPE_Similar(2),
        VIDA_TYPE_Coherence(3),
        VIDA_TYPE_Clarity(4);

        private final int type;

        ImageQualityVidaType(int i10) {
            this.type = i10;
        }

        public int getType() {
            return this.type;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ImageQulityBackendType {
        IMAGE_QUALITY_BACKEND_CPU(0),
        IMAGE_QUALITY_BACKEND_GPU(1);

        private final int type;

        ImageQulityBackendType(int i10) {
            this.type = i10;
        }

        public int getType() {
            return this.type;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ImageQulityPowerLevel {
        POWER_LEVEL_DEFAULT(0),
        POWER_LEVEL_LOW(1),
        POWER_LEVEL_NORMAL(2),
        POWER_LEVEL_HIGH(3),
        POWER_LEVEL_AUTO(4);

        private final int level;

        ImageQulityPowerLevel(int i10) {
            this.level = i10;
        }

        public int getLevel() {
            return this.level;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum IntensityType {
        Filter(12),
        BeautyWhite(1),
        BeautySmooth(2),
        FaceReshape(3),
        BeautySharp(9),
        MakeUpLip(17),
        MakeUpBlusher(18);


        /* renamed from: id, reason: collision with root package name */
        private int f19186id;

        IntensityType(int i10) {
            this.f19186id = i10;
        }

        public int getId() {
            return this.f19186id;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum LensVideoAlgType {
        SR_R_TYPE(0),
        SR_A_TYPE(1),
        SR_G_TYPE(2),
        SR_N_TYPE(3),
        SR_R15_TYPE(4),
        SR_U_UNKNOW(5);

        private int value;

        LensVideoAlgType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum LicenseCakeParamType {
        ALGORITHM_PARAMS_KEY_LICENSEFACE_DEDETECTION_DETECT_INTERVAL(0),
        ALGORITHM_PARAMS_KEY_LICENSEFACE_DEDETECTION_SIDE_MODEL_LEN(1),
        ALGORITHM_PARAMS_KEY_LICENSEFACE_DEDETECTION_DETECT_USE_REGRESSOR(2),
        ALGORITHM_PARAMS_KEY_LICENSEFACE_DEDETECTION_DETECT_USE_TRACKER(3);

        private int value;

        LicenseCakeParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum LightClsType {
        None(-1),
        Indoor_Yellow(0),
        Indoor_White(1),
        Indoor_weak(2),
        Sunny(3),
        Cloudy(4),
        Night(5),
        Backlight(6);

        private int value;

        LightClsType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ObjectTrackingInitBoxStatus {
        BEF_AI_OBJECT_TRACKING_InitBBoxInvalidHandle(-1),
        BEF_AI_OBJECT_TRACKING_InitBBoxSuccess(0),
        BEF_AI_OBJECT_TRACKING_InitBBoxNoTexture(1),
        BEF_AI_OBJECT_TRACKING_InitBBoxImageFeatureExtractFail(2);

        private int value;

        ObjectTrackingInitBoxStatus(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ObjectTrackingSpeed {
        BEF_AI_OBJECT_TRACKING_SpeedOrig(0),
        BEF_AI_OBJECT_TRACKING_SpeedUp1(1),
        BEF_AI_OBJECT_TRACKING_SpeedUp2(2);

        private int value;

        ObjectTrackingSpeed(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int i10) {
            this.value = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ObjectTrackingStatus {
        BEF_AI_OBJECT_TRACKING_StatusUnavailable(0),
        BEF_AI_OBJECT_TRACKING_StatusTracked(1),
        BEF_AI_OBJECT_TRACKING_StatusLosing(2),
        BEF_AI_OBJECT_TRACKING_StatusLost(3);

        private int value;

        ObjectTrackingStatus(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int i10) {
            this.value = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class PetFaceAction {
        public static final int BEF_LEFT_EYE_PET_FACE = 1;
        public static final int BEF_MOUTH_PET_FACE = 4;
        public static final int BEF_RIGHT_EYE_PET_FACE = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class PetFaceDetectConfig {
        public static final int BEF_PET_FACE_DETECT_CAT = 1;
        public static final int BEF_PET_FACE_DETECT_DOG = 2;
        public static final int BEF_PET_FACE_DETECT_QUICK = 4;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class PetFaceDetectType {
        public static final int BEF_PET_FACE_CAT = 1;
        public static final int BEF_PET_FACE_DOG = 2;
        public static final int BEF_PET_FACE_HUMAN = 3;
        public static final int BEF_PET_FACE_OTHER = 99;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum PhotoQualityType {
        PHOTO_QUALITY_TYPE_NONE,
        PHOTO_QUALITY_TYPE_NIGNT_SCENE
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum PixlFormat {
        RGBA8888(0),
        BGRA8888(1),
        BGR888(2),
        RGB888(3),
        BEF_AI_PIX_FMT_YUV420P(5),
        BEF_AI_PIX_FMT_NV12(6),
        BEF_AI_PIX_FMT_NV21(7);

        private int value;

        PixlFormat(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum PorraitMattingParamType {
        BEF_MP_EdgeMode(0),
        BEF_MP_FrashEvery(1),
        BEF_MP_OutputMinSideLen(2),
        BEF_MP_VIDEO_MODE(5);

        private int value;

        PorraitMattingParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum PortraitMatting {
        BEF_PORTAITMATTING_LARGE_MODEL(0),
        BEF_PORTAITMATTING_SMALL_MODEL(1);

        private int value;

        PortraitMatting(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum RenderAPI {
        GLES20(0),
        GLES30(1);

        private int value;

        RenderAPI(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum Rotation {
        CLOCKWISE_ROTATE_0(0),
        CLOCKWISE_ROTATE_90(1),
        CLOCKWISE_ROTATE_180(2),
        CLOCKWISE_ROTATE_270(3);


        /* renamed from: id, reason: collision with root package name */
        public int f19187id;

        Rotation(int i10) {
            this.f19187id = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum Skeleton3DParamType {
        BEF_SELETON3D_WHOLEBODY(0),
        BEF_SELETON3D_WITHHANDS(1),
        BEF_SELETON3D_MAXTARGETNUM(2),
        BEF_SELETON3D_TARGETSPEFRAME(3),
        BEF_SELETON3D_WRISTSCORETHRES(4),
        BEF_SELETON3D_HSWRISTSCORETHRES(5),
        BEF_SELETON3D_CHECKROOTINVERSE(6),
        BEF_SELETON3D_TASKPERTICK(7),
        BEF_SELETON3D_SMOOTHWINSIZE(8),
        BEF_SELETON3D_SMOOTHORIGINSIGMAXY(9),
        BEF_SELETON3D_SMOOTHORIGINSIGMAZ(10),
        BEF_SELETON3D_WITHWRISTOFFSET(11),
        BEF_SELETON3D_HANDPROBTHRES(12),
        BEF_SELETON3D_CHECKWRISTROT(13),
        BEF_SELETON3D_SMOOTHSIGMABETAS(14),
        BEF_SELETON3D_FITTINGENABLE(15),
        BEF_SELETON3D_FITTINGROOTENABLE(16);

        private int value;

        Skeleton3DParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum SkinSegmentationParamType {
        BEF_AI_SKIN_SEG_MODEL_KEY(0),
        BEF_AI_SKIN_SEG_IS_NEED_FACE(1);

        private int value;

        SkinSegmentationParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum SlamAccuracyLevel {
        BEF_AI_SLAM_High_Accuracy(0),
        BEF_AI_SLAM_Medium_Accuracy(1),
        BEF_AI_SLAM_Low_Accuracy(2);

        private int value;

        SlamAccuracyLevel(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum SlamDeviceOrientation {
        BEF_AI_SLAM_Portrait(0),
        BEF_AI_SLAM_LandscapeLeft(1),
        BEF_AI_SLAM_UpsideDown(2),
        BEF_AI_SLAM_LandscapeRight(3);

        private int value;

        SlamDeviceOrientation(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum SlamImageColor {
        BEF_AI_SLAM_RGB(0),
        BEF_AI_SLAM_BGR(1),
        BEF_AI_SLAM_GRAY(2);

        private int value;

        SlamImageColor(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum SlamImuDataType {
        BEF_AI_SLAM_IMU_ACCELEROMETER(0),
        BEF_AI_SLAM_IMU_GYROSCOPE(1),
        BEF_AI_SLAM_IMU_GRAVITY(2);

        private int value;

        SlamImuDataType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum SlamResolution {
        BEF_AI_SLAM_480P(0),
        BEF_AI_SLAM_720P(1),
        BEF_AI_SLAM_360P(2),
        BEF_AI_SLAM_180P(3);

        private int value;

        SlamResolution(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum SlamTrackingState {
        BEF_AI_SLAM_Tracking_ERROR(0),
        BEF_AI_SLAM_Tracking_INIT(1),
        BEF_AI_SLAM_Tracking_TRACKING(2),
        BEF_AI_SLAM_Tracking_LOST(3);

        private int value;

        SlamTrackingState(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum SlamVersion {
        BEF_AI_SLAM_Debug(0),
        BEF_AI_SLAM_HorizontalPlaneTracking(2),
        BEF_AI_SLAM_RegionTracking(3);

        private int value;

        SlamVersion(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum StudentIdOcrModelType {
        BEF_STUDENT_ID_OCR_MODEL(1);

        private int value;

        StudentIdOcrModelType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum TextureFormat {
        Texure2D(3553),
        Texture_Oes(36197);

        private int value;

        TextureFormat(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum TouchEventCode {
        BEGAN(0),
        MOVED(1),
        STATIONARY(2),
        ENDED(3),
        CANCELLED(4);

        private final int code;

        TouchEventCode(int i10) {
            this.code = i10;
        }

        public int getCode() {
            return this.code;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum VideoClsModelType {
        BEF_AI_kVideoClsModel1(1);

        private int value;

        VideoClsModelType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum VideoClsParamType {
        BEF_AI_kVideoClsEdgeMode(1);

        private int value;

        VideoClsParamType(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum YUV420Type {
        YUV_420_TYPE_NV21(0),
        YUV_420_TYPE_NV12(1);

        private int value;

        YUV420Type(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }
}
