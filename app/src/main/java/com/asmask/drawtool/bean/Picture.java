package com.asmask.drawtool.bean;

import static com.asmask.drawtool.DrawMainActivity.getContext;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * @Author srg
 * @Date On 07 03
 * @Description : 图片元素
 */
public class Picture {
    /**
     * 资源id
     */
    private int contentId;
    /**
     * 图片bitmap
     */
    private Bitmap content;
    /**
     * 图片名称
     */
    private String name;

    public Picture(int contentId, String name) {
        this.contentId = contentId;
        this.name = name;
    }

    public Picture(int contentId) {
        this.contentId = contentId;
    }

    public Bitmap createContent() {
        content = BitmapFactory.decodeResource(getContext().getResources(),
                contentId);
        return content;
    }


    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public Bitmap getContent() {
        return content;
    }

    public void setContent(Bitmap content) {
        this.content = content;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

