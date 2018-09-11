package com.brainlet;

import java.util.HashMap;
import java.util.Map;

public class BrainletMemory {
    protected String tag;
    protected transient String previousTag = null;
    protected Map<String, Object> data;
    protected boolean dirty = false;

    public BrainletMemory() {

    }


    public BrainletMemory(String tag) {
        this.tag = tag;
        this.data = new HashMap<>();
    }


    public BrainletMemory(String tag, Map<String, Object> data) {
        this.tag = tag;
        this.data = data;
    }



    public String getTag() { return tag; }
    public void setTag(String tag) { this.previousTag = tag; this.tag = tag; this.dirty = true; }

    public Map<String, Object> getData() { return data; }
    public void setData(Map<String, Object> data) { this.data = data; this.dirty = true; }

    public boolean isDirty() { return dirty; }
    public void setDirty(boolean dirty) { this.dirty = dirty; }

    public String getPreviousTag() { return previousTag; }
    public void setPreviousTag(String previousTag) { this.previousTag = previousTag; }

    /**
     * Sets dirty flag to false, nulls previousTag, and returns previous state of dirty.
     * @return returns isDirty
     */
    public boolean clean() { boolean dirt = dirty; previousTag = null; dirty = false; return dirt; }
}
