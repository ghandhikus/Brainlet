package com.brainlet;

import com.brainlet.plutchik.PlutchikWheel;
import org.junit.Test;

import java.util.List;

public class PlutchikWheelTests {

    @Test
    public void wheel() {
        PlutchikWheel mood = new PlutchikWheel();

        StringBuilder sb = new StringBuilder();

        int iterations = 10;
        boolean print = true;

        long startTime = System.currentTimeMillis();
        /*
        for(int i=0; i<iterations;i++) {
            mood.dopamine = (float) Math.random();
            mood.serotonine = (float) Math.random();
            mood.oxytocin = (float) Math.random();
            mood.norepinephrine = (float) Math.random();

            PlutchikMood mainMood = mood.getMainMood();
            final List<PlutchikWheel.MoodCalculation> allMoods = mood.getAllMoods();

            if(print) {
                allMoods.sort((a,b)->(a.moodStrength>b.moodStrength) ? -1 : 1);
                sb
                        .append("(serotonine:").append(mood.serotonine)
                        .append(", dopamine:").append(mood.dopamine)
                        .append(", norepinephrine:").append(mood.norepinephrine)
                        .append(", oxytocin:").append(mood.oxytocin)
                        .append(") Main mood: ").append(mainMood).append('\n');
                allMoods.forEach((m) -> sb.append(m.currentMood).append(" ").append(m.moodStrength).append('\n'));
                sb.append('\n');
            }
        }
        */
        sb.append("\n\n").append(iterations).append(" iterations took: ").append(System.currentTimeMillis()-startTime).append("ms");

        System.out.println(sb.toString());
    }
}
