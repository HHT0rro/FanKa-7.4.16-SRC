package com.tencent.liteav.videobase.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f extends j {
    public f() {
        super(com.tencent.liteav.videobase.a.b.NO_FILTER_VERTEX_SHADER, "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform float width;\nuniform float height;\nhighp vec3 offset = vec3(0.0625, 0.5, 0.5);\nhighp mat3 scale = mat3( 0.256816,  0.504154, 0.0979137,\n                        -0.148246,  -0.29102,  0.439266,\n                         0.439271, -0.367833, -0.071438);\n\nvoid main() {\n    vec2 yScale = vec2(4.0, 4.0);\n    vec2 uvScale = vec2(8.0, 8.0);\n\n    highp vec2 nowTxtPos = textureCoordinate;\n    vec2 size = vec2(width, height);\n    float imageRatio = width / height;\n\n    if (nowTxtPos.y < 0.3) { //y平面占整个texture的0.3\n        // y1 postion\n        vec2 now_pos = nowTxtPos * size - vec2(0.375, 0.375);\n        vec2 basePos = now_pos * yScale;\n\n        float addY = float(int((basePos.x / width)));\n        basePos.x -= addY * width;\n        basePos.y += addY;\n\n        float y1 = 0.0;\n        float y2 = 0.0;\n        float y3 = 0.0;\n        float y4 = 0.0;\n        vec2 samplingPos = basePos / size;\n        vec4 texel = texture2D(inputImageTexture, samplingPos);\n\n        y1 = dot(texel.rgb, scale[0]);\n        y1 += offset[0];\n\n        basePos.x += 1.0;\n        addY = float(int((basePos.x / width)));\n        basePos.x -= addY * width;\n        basePos.y += addY;\n        samplingPos = basePos/ size;\n        texel = texture2D(inputImageTexture, samplingPos);\n\n        y2 = dot(texel.rgb, scale[0]);\n        y2 += offset[0];\n\n        basePos.x += 1.0;\n        addY = float(int((basePos.x / width)));\n        basePos.x -= addY * width;\n        basePos.y += addY;\n        samplingPos = basePos/ size;\n        texel = texture2D(inputImageTexture, samplingPos);\n\n        y3 = dot(texel.rgb, scale[0]);\n        y3 += offset[0];\n\n        basePos.x += 1.0;\n        addY = float(int((basePos.x / width)));\n        basePos.x -= addY * width;\n        basePos.y += addY;\n        samplingPos = basePos/ size;\n        texel = texture2D(inputImageTexture, samplingPos);\n\n        y4 = dot(texel.rgb, scale[0]);\n        y4 += offset[0];\n\n        gl_FragColor = vec4(y1, y2, y3, y4);\n    } else if (nowTxtPos.y >= 0.5 && nowTxtPos.y < 0.625) { //u平面占整个texture的0.5 ~ 0.625范围\n        nowTxtPos.y -= 0.5;\n        highp vec2 basePos = nowTxtPos * uvScale * size + vec2(1.0, -0.5);\n        highp float addY = float(int(basePos.x / width));\n        basePos.x -= addY * width;\n\n        basePos.y += addY;\n        basePos.y *= 2.0;\n        basePos -= clamp(uvScale * 0.5, vec2(0.0), uvScale);\n        basePos.y -= 2.0;\n\n        highp vec4 sample = texture2D(inputImageTexture, basePos/ size).rgba;\n        highp float u1 = dot(sample.rgb, scale[1]);\n        u1 += offset.y;\n\n        basePos.x+=2.0;\n        addY = float(int((basePos.x / width)));\n        basePos.x -= addY * width;\n        basePos.y += addY * 2.0;\n        sample = texture2D(inputImageTexture, basePos/ size).rgba;\n        float u2 = dot(sample.rgb, scale[1]);\n        u2 += offset.y;\n\n        basePos.x+=2.0;\n        addY = float(int((basePos.x / width)));\n        basePos.x -= addY * width;\n        basePos.y += addY * 2.0;\n        sample = texture2D(inputImageTexture, basePos / size).rgba;\n        float u3 = dot(sample.rgb, scale[1]);\n        u3 += offset.y;\n\n        basePos.x+=2.0;\n        addY = float(int((basePos.x / width)));\n        basePos.x -= addY * width;\n        basePos.y += addY * 2.0;\n        sample = texture2D(inputImageTexture, basePos / size).rgba;\n        float u4 = dot(sample.rgb, scale[1]);\n        u4 += offset.y;\n\n        gl_FragColor = vec4(u1, u2, u3, u4);\n    } else if (nowTxtPos.y >= 0.75 && nowTxtPos.y < 0.875) { // v平面占texture的0.75 ~ 0.875范围\n        nowTxtPos -= vec2(0,0.75);\n        highp vec2 basePos = nowTxtPos * uvScale * size + vec2(0.5, -0.5);\n        highp float addY = float(int(basePos.x / width));\n        basePos.x -= addY * width;\n\n        basePos.y += addY;\n        basePos.y *= 2.0;\n        basePos -= clamp(uvScale * 0.5, vec2(0.0), uvScale);\n        basePos.y -= 2.0;\n\n        highp vec4 sample = texture2D(inputImageTexture, basePos / size).rgba;\n        highp float v1 = dot(sample.rgb, scale[2]);\n        v1 += offset.z;\n\n        basePos.x += 2.0;\n        addY = float(int((basePos.x / width)));\n        basePos.x -= addY * width;\n        basePos.y += addY * 2.0;\n        sample = texture2D(inputImageTexture, basePos / size).rgba;\n        float v2 = dot(sample.rgb, scale[2]);\n        v2 += offset.z;\n\n        basePos.x += 2.0;\n        addY = float(int((basePos.x / width)));\n        basePos.x -= addY * width;\n        basePos.y += addY * 2.0;\n        sample = texture2D(inputImageTexture, basePos / size).rgba;\n        float v3 = dot(sample.rgb, scale[2]);\n        v3 += offset.z;\n\n        basePos.x += 2.0;\n        addY = float(int((basePos.x / width)));\n        basePos.x -= addY * width;\n        basePos.y += addY * 2.0;\n        sample = texture2D(inputImageTexture, basePos / size).rgba;\n        float v4 = dot(sample.rgb, scale[2]);\n        v4 += offset.z;\n\n        gl_FragColor = vec4(v1, v2, v3, v4);\n        // gl_FragColor = vec4(0.5, 0.5, 0.5, 0.5);\\\\\\\\\\\\\\\\n +\n    } else {\n    }\n}");
    }
}
