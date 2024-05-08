package com.effectsar.labcv.effectsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefGazeEstimationInfo {
    public int faceCount;
    public BefGazeEstimation[] infos;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class BefGazeEstimation {
        public long faceId;
        public float[] head_r;
        public float[] head_t;
        public float[] leye_gaze;
        public float[] leye_gaze_2d;
        public float[] leye_pos;
        public float[] leye_pos2d;
        public float[] mid_gaze;
        public float[] reye_gaze;
        public float[] reye_gaze2d;
        public float[] reye_pos;
        public float[] reye_pos2d;
        public boolean valid;

        public long getFaceId() {
            return this.faceId;
        }

        public float[] getHead_r() {
            return this.head_r;
        }

        public float[] getHead_t() {
            return this.head_t;
        }

        public float[] getLeye_gaze() {
            return this.leye_gaze;
        }

        public float[] getLeye_gaze_2d() {
            return this.leye_gaze_2d;
        }

        public float[] getLeye_pos() {
            return this.leye_pos;
        }

        public float[] getLeye_pos2d() {
            return this.leye_pos2d;
        }

        public float[] getMid_gaze() {
            return this.mid_gaze;
        }

        public float[] getReye_gaze() {
            return this.reye_gaze;
        }

        public float[] getReye_gaze2d() {
            return this.reye_gaze2d;
        }

        public float[] getReye_pos() {
            return this.reye_pos;
        }

        public float[] getReye_pos2d() {
            return this.reye_pos2d;
        }

        public boolean isValid() {
            return this.valid;
        }
    }

    public int getFaceCount() {
        return this.faceCount;
    }

    public BefGazeEstimation[] getInfos() {
        return this.infos;
    }
}
