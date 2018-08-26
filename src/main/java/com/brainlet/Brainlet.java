package com.brainlet;

import com.brainlet.plutchik.PlutchikWheel;

/**
 * Covers all useful parts that entities might use for AI.
 *
 * Name is based on Brainlet meme.
 *
 * Core class of Brainlet library.
 */
public abstract class Brainlet {

    //////////////////////////////
    // To use brainlet you need to override Brainlet class
    //
    // Brainlet core parts:
    //
    // - Long-term memory
    // - Short-term memory
    // - Sensorics
    // - Identity
    // - Mood
    // - Decision-making blackbox
    //
    //
    // Additional information:
    // - For long-term memory you should use database that won't use RAM to avoid hauling megabytes of data.
    //
    //


    protected BrainletMemories longMemory = null;
    protected BrainletMemories shortMemory = null;
    protected Senses senses = null;
    protected Identity identity = null;
    protected Mood mood = null;
    protected BlackBox blackBox = null;

    public Brainlet() {

    }

    public void setLongMemory(BrainletMemories longMemory) { this.longMemory = longMemory; }
    public BrainletMemories getLongMemory() { return longMemory; }

    public void setShortMemory(BrainletMemories shortMemory) { this.shortMemory = shortMemory; }
    public BrainletMemories getShortMemory() { return shortMemory; }

    public void setBlackBox(BlackBox blackBox) { this.blackBox = blackBox; }
    public BlackBox getBlackBox() { return blackBox; }

    public Senses getSenses() { return senses; }
    public void setSenses(Senses senses) { this.senses = senses; }

    public Identity getIdentity() { return identity; }
    public void setIdentity(Identity identity) { this.identity = identity; }
}
