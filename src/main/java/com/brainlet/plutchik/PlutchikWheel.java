package com.brainlet.plutchik;

import com.brainlet.Mood;
import com.brainlet.MoodModifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlutchikWheel implements Mood {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Variables ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    protected float dopamine = 0.5f;
    protected float norepinephrine = 0.5f;
    protected float oxytocin = 0.5f;
    protected float serotonine = 0.5f;

    protected ArrayList<MoodModifier> modifiers = new ArrayList<>();

    protected boolean dirty = true;


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Mood interface implementation ///////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public @Override float getDopamine() { return dopamine; }
    public @Override float getNorepinephrine() { return norepinephrine; }
    public @Override float getOxytocin() { return oxytocin; }
    public @Override float getSerotonine() { return serotonine; }
    public @Override boolean addMoodModifier(MoodModifier modifier) { dirty=true; return modifiers.add(modifier); }
    public @Override boolean removeMoodModifier(MoodModifier modifier) { dirty=true; return modifiers.remove(modifier); }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Misc ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public PlutchikWheel() {}

    public static final class MoodCalculation {
        public PlutchikMood currentMood = null;
        public float moodStrength; // < current maximal value of specific hormone
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Methods /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void update(float delta) {

        if(dirty) {
            dirty = false;

            dopamine = 0.5f;
            norepinephrine = 0.5f;
            oxytocin = 0.5f;
            serotonine = 0.5f;

            modifiers.forEach((e)->{
                dopamine += e.dopamine();
                norepinephrine += e.norepinephrine();
                oxytocin += e.oxytocin();
                serotonine += e.serotonine();
            });


        }
    }

    public PlutchikMood getMainMood() {
        final MoodCalculation calc = new MoodCalculation();

        final List<PlutchikMood> moods = Arrays.asList(PlutchikMood.values());

        moods.forEach((mood)-> calculateMood(calc, mood));

        return calc.currentMood;
    }

    public List<MoodCalculation> getAllMoods() {
        final List<PlutchikMood> moods = Arrays.asList(PlutchikMood.values());
        final List<MoodCalculation> result = new ArrayList<>(moods.size());

        for(int i = 0;i < moods.size(); i++)
            result.add(calculateMood(new MoodCalculation(), moods.get(i)));

        return result;
    }

    public MoodCalculation getMood(PlutchikMood mood) {
        return calculateMood(new MoodCalculation(), mood);
    }

    public MoodCalculation calculateMood(final MoodCalculation calc, final PlutchikMood mood) {
        float curHormone = 0;

        float ratio = mood.ratio;

        // curHormone calculation
        {
            if (mood.h == PlutchikConstants.CHAR_DOPAMINE) curHormone = dopamine; else
            if (mood.h == PlutchikConstants.CHAR_NOREPINEPHRINE) curHormone = norepinephrine; else
            if (mood.h == PlutchikConstants.CHAR_OXYTOCIN) curHormone = oxytocin; else
            if (mood.h == PlutchikConstants.CHAR_SEROTONINE) curHormone = serotonine;


            System.out.println("pre : "+curHormone);
            // flip negative hormone to determine max
            if (!mood.positive) {
                ratio = (1 - ratio);
            }

            float dst = Math.abs(curHormone - ratio);
            curHormone = 1-dst;
            System.out.println("post: "+curHormone);
        }


        // Results
        boolean setResults = false;
        setResults |= calc.currentMood == null;
        setResults |= curHormone > calc.moodStrength;

        if(setResults) {
            calc.currentMood = mood;
            calc.moodStrength = curHormone;
        }

        return calc;
    }
}
