package com.zego.zegoavkit2.screencapture.ve_gl;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class GlRectDrawer {
    private static final String OES_FRAGMENT_SHADER_STRING = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oes_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(oes_tex, interp_tc);\n}\n";
    private static final String RGB_FRAGMENT_SHADER_STRING = "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D rgb_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(rgb_tex, interp_tc);\n}\n";
    private static final String VERTEX_SHADER_STRING = "varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n";
    private static final String YUV_FRAGMENT_SHADER_STRING = "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n\nvoid main() {\n  float y = texture2D(y_tex, interp_tc).r * 1.16438;\n  float u = texture2D(u_tex, interp_tc).r;\n  float v = texture2D(v_tex, interp_tc).r;\n  gl_FragColor = vec4(y + 1.59603 * v - 0.874202,                       y - 0.391762 * u - 0.812968 * v + 0.531668,                       y + 2.01723 * u - 1.08563, 1);\n}\n";
    private static FloatBuffer mVertices = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    private static final FloatBuffer mTexcoords = GlUtil.createFloatBuffer(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
    private int mFrameWidth = 0;
    private int mFrameHeight = 0;
    private final Map<String, Shader> shaders = new IdentityHashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Shader {
        public final GlShader glShader;
        public final int posLocation;
        public final int tcLocation;
        public int tex0Location;
        public int tex1Location;
        public int tex2Location;
        public final int texMatrixLocation;

        public Shader(String str) {
            GlShader glShader = new GlShader(GlRectDrawer.VERTEX_SHADER_STRING, str);
            this.glShader = glShader;
            this.texMatrixLocation = glShader.getUniformLocation("texMatrix");
            int attribLocation = glShader.getAttribLocation("in_pos");
            this.posLocation = attribLocation;
            int attribLocation2 = glShader.getAttribLocation("in_tc");
            this.tcLocation = attribLocation2;
            GLES20.glEnableVertexAttribArray(attribLocation);
            GLES20.glEnableVertexAttribArray(attribLocation2);
            this.tex2Location = -1;
            this.tex1Location = -1;
            this.tex0Location = -1;
        }
    }

    private void configCanvas(int i10, int i11, int i12, int i13) {
        float f10;
        float f11 = i10 / i11;
        float f12 = i12 / i13;
        float f13 = 1.0f;
        if (f11 > f12) {
            f10 = f12 / f11;
        } else {
            f13 = f11 / f12;
            f10 = 1.0f;
        }
        float f14 = -f13;
        mVertices.put(0, f14);
        float f15 = -f10;
        mVertices.put(1, f15);
        mVertices.put(2, f13);
        mVertices.put(3, f15);
        mVertices.put(4, f14);
        mVertices.put(5, f10);
        mVertices.put(6, f13);
        mVertices.put(7, f10);
    }

    private void drawRectangle(int i10, int i11, int i12, int i13) {
        GLES20.glViewport(i10, i11, i12, i13);
        GLES20.glDrawArrays(5, 0, 4);
    }

    private void prepareShader(String str, float[] fArr) {
        Shader shader;
        if (this.shaders.containsKey(str)) {
            shader = this.shaders.get(str);
        } else {
            Shader shader2 = new Shader(str);
            this.shaders.put(str, shader2);
            shader2.glShader.useProgram();
            if (str == YUV_FRAGMENT_SHADER_STRING) {
                shader2.tex0Location = shader2.glShader.getUniformLocation("y_tex");
                shader2.tex1Location = shader2.glShader.getUniformLocation("u_tex");
                shader2.tex2Location = shader2.glShader.getUniformLocation("v_tex");
            } else if (str == RGB_FRAGMENT_SHADER_STRING) {
                shader2.tex0Location = shader2.glShader.getUniformLocation("rgb_tex");
            } else if (str == OES_FRAGMENT_SHADER_STRING) {
                shader2.tex0Location = shader2.glShader.getUniformLocation("oes_tex");
            } else {
                throw new IllegalStateException("Unknown fragment shader: " + str);
            }
            GlUtil.checkNoGLES2Error("Initialize fragment shader uniform values.");
            shader = shader2;
        }
        shader.glShader.useProgram();
        int i10 = shader.tex0Location;
        if (i10 != -1) {
            GLES20.glUniform1i(i10, 0);
        }
        int i11 = shader.tex1Location;
        if (i11 != -1) {
            GLES20.glUniform1i(i11, 1);
        }
        int i12 = shader.tex2Location;
        if (i12 != -1) {
            GLES20.glUniform1i(i12, 2);
        }
        GLES20.glEnableVertexAttribArray(shader.posLocation);
        GLES20.glEnableVertexAttribArray(shader.tcLocation);
        GLES20.glVertexAttribPointer(shader.posLocation, 2, 5126, false, 0, (Buffer) mVertices);
        GLES20.glVertexAttribPointer(shader.tcLocation, 2, 5126, false, 0, (Buffer) mTexcoords);
        GLES20.glUniformMatrix4fv(shader.texMatrixLocation, 1, false, fArr, 0);
    }

    public void drawOes(int i10, float[] fArr, int i11, int i12, int i13, int i14, int i15, int i16) {
        prepareShader(OES_FRAGMENT_SHADER_STRING, fArr);
        GLES20.glActiveTexture(33984);
        if (this.mFrameWidth != i11 || this.mFrameHeight != i12) {
            configCanvas(i11, i12, i15, i16);
            this.mFrameWidth = i11;
            this.mFrameHeight = i12;
        }
        GLES20.glBindTexture(36197, i10);
        drawRectangle(i13, i14, i15, i16);
        GLES20.glBindTexture(36197, 0);
    }

    public void drawRgb(int i10, float[] fArr, int i11, int i12, int i13, int i14, int i15, int i16) {
        prepareShader(RGB_FRAGMENT_SHADER_STRING, fArr);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i10);
        drawRectangle(i13, i14, i15, i16);
        GLES20.glBindTexture(3553, 0);
    }

    public void drawYuv(int[] iArr, float[] fArr, int i10, int i11, int i12, int i13, int i14, int i15) {
        prepareShader(YUV_FRAGMENT_SHADER_STRING, fArr);
        for (int i16 = 0; i16 < 3; i16++) {
            GLES20.glActiveTexture(33984 + i16);
            GLES20.glBindTexture(3553, iArr[i16]);
        }
        drawRectangle(i12, i13, i14, i15);
        for (int i17 = 0; i17 < 3; i17++) {
            GLES20.glActiveTexture(i17 + 33984);
            GLES20.glBindTexture(3553, 0);
        }
    }

    public void release() {
        Iterator<Shader> iterator2 = this.shaders.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().glShader.release();
        }
        this.shaders.clear();
    }
}
