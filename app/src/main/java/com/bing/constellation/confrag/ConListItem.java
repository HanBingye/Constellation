package com.bing.constellation.confrag;

public class ConListItem {
   private String text;
   private String context;
   private int color;

    public ConListItem(String text, String context, int color) {
        this.text = text;
        this.context = context;
        this.color = color;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
