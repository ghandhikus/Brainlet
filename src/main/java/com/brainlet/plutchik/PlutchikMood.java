package com.brainlet.plutchik;

public enum PlutchikMood {
    ECSTASY(PlutchikConstants.moodTier0, "serotonine+"),
    ADMIRATION(PlutchikConstants.moodTier0, "oxytocin+"),
    RAGE(PlutchikConstants.moodTier0, "norepinephrine+"),
    AMAZEMENT(PlutchikConstants.moodTier0, "dopamine+"),
    GRIEF(PlutchikConstants.moodTier0, "serotonine-"),
    LOATHING(PlutchikConstants.moodTier0, "oxytocin-"),
    TERROR(PlutchikConstants.moodTier0, "norepinephrine-"),
    VIGILANCE(PlutchikConstants.moodTier0, "dopamine-"),

    JOY(PlutchikConstants.moodTier1, "serotonine+"),
    TRUST(PlutchikConstants.moodTier1, "oxytocin+"),
    ANGER(PlutchikConstants.moodTier1, "norepinephrine+"),
    SURPRISE(PlutchikConstants.moodTier1, "dopamine+"),
    SADNESS(PlutchikConstants.moodTier1, "serotonine-"),
    DISGUST(PlutchikConstants.moodTier1, "oxytocin-"),
    FEAR(PlutchikConstants.moodTier1, "norepinephrine-"),
    ANTICIPATION(PlutchikConstants.moodTier1, "dopamine-"),

    SERENITY(PlutchikConstants.moodTier2, "serotonine+"),
    ACCEPTANCE(PlutchikConstants.moodTier2, "oxytocin+"),
    ANNOYANCE(PlutchikConstants.moodTier2, "norepinephrine+"),
    DISTRACTION(PlutchikConstants.moodTier2, "dopamine+"),
    PENSIVENESS(PlutchikConstants.moodTier2, "serotonine-"),
    BOREDOM(PlutchikConstants.moodTier2, "oxytocin-"),
    APPREHENSION(PlutchikConstants.moodTier2, "norepinephrine-"),
    INTEREST(PlutchikConstants.moodTier2, "dopamine-"),

    ;


    
    public final float ratio;
    public final char h;
    public final String type;
    public final String hormone;
    public final boolean positive;


    PlutchikMood(float ratio, String type) {
        this.hormone = type.substring(0, type.length()-1);
        this.h = type.charAt(0);
        this.positive = type.endsWith("+");
        this.ratio = ratio;
        this.type = type;

    }
}
