package com.zego.zegoavkit2.screencapture.ve_gl;

import android.opengl.GLES20;
import com.huawei.openalliance.ad.constant.u;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class GlShader {
    private static final String TAG = "GlShader";
    private int program;

    public GlShader(String str, String str2) {
        int compileShader = compileShader(35633, str);
        int compileShader2 = compileShader(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        this.program = glCreateProgram;
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, compileShader);
            GLES20.glAttachShader(this.program, compileShader2);
            GLES20.glLinkProgram(this.program);
            int[] iArr = {0};
            GLES20.glGetProgramiv(this.program, 35714, iArr, 0);
            if (iArr[0] == 1) {
                GLES20.glDeleteShader(compileShader);
                GLES20.glDeleteShader(compileShader2);
                GlUtil.checkNoGLES2Error("Creating GlShader");
                return;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not link program: ");
                sb2.append(GLES20.glGetProgramInfoLog(this.program));
                throw new RuntimeException(GLES20.glGetProgramInfoLog(this.program));
            }
        }
        throw new RuntimeException("glCreateProgram() failed. GLES20 error: " + GLES20.glGetError());
    }

    private static int compileShader(int i10, String str) {
        int glCreateShader = GLES20.glCreateShader(i10);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = {0};
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 1) {
                GlUtil.checkNoGLES2Error("compileShader");
                return glCreateShader;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not compile shader ");
            sb2.append(i10);
            sb2.append(u.bD);
            sb2.append(GLES20.glGetShaderInfoLog(glCreateShader));
            throw new RuntimeException(GLES20.glGetShaderInfoLog(glCreateShader));
        }
        throw new RuntimeException("glCreateShader() failed. GLES20 error: " + GLES20.glGetError());
    }

    public int getAttribLocation(String str) {
        int i10 = this.program;
        if (i10 != -1) {
            int glGetAttribLocation = GLES20.glGetAttribLocation(i10, str);
            if (glGetAttribLocation >= 0) {
                return glGetAttribLocation;
            }
            throw new RuntimeException("Could not locate '" + str + "' in program");
        }
        throw new RuntimeException("The program has been released");
    }

    public int getUniformLocation(String str) {
        int i10 = this.program;
        if (i10 != -1) {
            int glGetUniformLocation = GLES20.glGetUniformLocation(i10, str);
            if (glGetUniformLocation >= 0) {
                return glGetUniformLocation;
            }
            throw new RuntimeException("Could not locate uniform '" + str + "' in program");
        }
        throw new RuntimeException("The program has been released");
    }

    public void release() {
        int i10 = this.program;
        if (i10 != -1) {
            GLES20.glDeleteProgram(i10);
            this.program = -1;
        }
    }

    public void setVertexAttribArray(String str, int i10, FloatBuffer floatBuffer) {
        if (this.program != -1) {
            int attribLocation = getAttribLocation(str);
            GLES20.glEnableVertexAttribArray(attribLocation);
            GLES20.glVertexAttribPointer(attribLocation, i10, 5126, false, 0, (Buffer) floatBuffer);
            GlUtil.checkNoGLES2Error("setVertexAttribArray");
            return;
        }
        throw new RuntimeException("The program has been released");
    }

    public void useProgram() {
        int i10 = this.program;
        if (i10 != -1) {
            GLES20.glUseProgram(i10);
            GlUtil.checkNoGLES2Error("glUseProgram");
            return;
        }
        throw new RuntimeException("The program has been released");
    }
}
