package com.brainlet;

/**
 * Covers all useful parts that entities might use for AI.
 *
 * Name is based on Brainlet meme.
 *
 * Core class of Brainlet library.
 */
public abstract class Brainlet {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Instructions ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // To use brainlet you need to override Brainlet class
    //
    // Brainlet core parts:
    //
    // - Long-term memory
    // - Short-term memory
    // - Sensorics
    // - Body control
    // - Identity
    // - Mood
    // - Decision-making blackbox
    //
    //
    // Additional information:
    // - For long-term memory you should use database that won't store data in memory
    //   to avoid hauling megabytes of data.
    //
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Variables ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    protected BrainletMemories longMemory = null;
    protected BrainletMemories shortMemory = null;
    protected Senses senses = null;
    protected BrainletBody body = null;
    protected Identity identity = null;
    protected Mood mood = null;
    protected BlackBox blackBox = null;
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    public Brainlet() {

    }
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters /////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // longMemory
    public void setLongMemory(BrainletMemories longMemory) { this.longMemory = longMemory; }
    public BrainletMemories getLongMemory() { return longMemory; }
    //
    // shortMemory
    public void setShortMemory(BrainletMemories shortMemory) { this.shortMemory = shortMemory; }
    public BrainletMemories getShortMemory() { return shortMemory; }
    //
    // senses
    public Senses getSenses() { return senses; }
    public void setSenses(Senses senses) { this.senses = senses; }
    //
    // body
    public BrainletBody getBody() { return body; }
    public void setBody(BrainletBody body) { this.body = body; }
    //
    // identity
    public Identity getIdentity() { return identity; }
    public void setIdentity(Identity identity) { this.identity = identity; }
    //
    // mood
    public Mood getMood() { return mood; }
    public void setMood(Mood mood) { this.mood = mood; }
    //
    // blackBox
    public void setBlackBox(BlackBox blackBox) { this.blackBox = blackBox; }
    public BlackBox getBlackBox() { return blackBox; }
}
