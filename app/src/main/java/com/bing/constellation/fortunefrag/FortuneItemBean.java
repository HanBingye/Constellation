package com.bing.constellation.fortunefrag;

public class FortuneItemBean {
    private String text;
    private String content;
    private int colorId;

    public FortuneItemBean(String text, String content, int colorId) {
        this.text = text;
        this.content = content;
        this.colorId = colorId;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }
}
