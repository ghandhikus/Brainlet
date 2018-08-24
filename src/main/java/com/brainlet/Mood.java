package com.brainlet;

public interface Mood {
    float getDopamine();
    float getNorepinephrine();
    float getOxytocin();
    float getSerotonine();

    /**
     * Adds mood modifier to this mood system.
     *
     * @param modifier
     * @return <tt>true</tt> (as specified by {@link java.util.Collection#add})
     */
    boolean addMoodModifier(MoodModifier modifier);

    /**
     * Removes mood modifier from this mood system.
     *
     * @param modifier
     * @return <tt>true</tt> if this list contained the specified element
     */
    boolean removeMoodModifier(MoodModifier modifier);
}
