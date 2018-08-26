package com.brainlet.mbti;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public enum MBTI {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Type List ///////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Intuition
  // Introverted
    INTP(),
    INTJ(),
    INFP(),
    INFJ(),

  // Extroverted
    ENTP(),
    ENTJ(),
    ENFP(),
    ENFJ(),

// Sensing
  // Introverted
    ISTP(),
    ISTJ(),
    ISFP(),
    ISFJ(),

  // Extroverted
    ESTP(),
    ESTJ(),
    ESFP(),
    ESFJ()

    ;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Variables ///////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Main Function Preferences
    public char identity;
    public char gathering;
    public char organising;
    public char tribe;

    // Efficiency is specified by [0,1,2,3], 0 being the strongest and 3 the weakest
    public int identityEfficiency;
    public int gatheringEfficiency;
    public int organisingEfficiency;
    public int tribeEfficiency;


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Minor variables
    public String[] DnDAlignment;
    public float giftedToNormalRatio;
    public float maleToFemaleRatio;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Public Methods //////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Data Initialization /////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    MBTI() {
        final String name = this.name();

        MBTIJson data = loadJson(name);

        errorCheck(name, data);
        dataFill(name, data);
    }

    void dataFill(String name, MBTIJson data) {

        // Parsing jungian function stack
        for(int i=0;i<8;i++)
            fillStack(name, data, i, data.func[i]);

        fillDndAlignment(name, data);
        fillRatios(name, data);

    }

    void fillStack(String name, MBTIJson data, int i, String func) {

        // Parsing function preferences and efficiency
        mainFunctionPreferences(i, func);
    }

    void fillRatios(String name, MBTIJson data) {
        giftedToNormalRatio = data.giftedToNormalRatio;
        maleToFemaleRatio = data.maleToFemaleRatio;
    }

    void fillDndAlignment(String name, MBTIJson data) {
        this.DnDAlignment = data.DnDAlignment;
    }

    void mainFunctionPreferences(int i, String func) {
        if(i>3) // < only 0-3 range
            return;

        // Identity
        if((func.equals("Ti") || func.equals("Fi")) && identity == 0) {
            identity = func.charAt(0);
            identityEfficiency = i;
        }

        // Gathering
        if((func.equals("Ne") || func.equals("Se")) && gathering == 0) {
            gathering = func.charAt(0);
            gatheringEfficiency = i;
        }

        // Organising
        if((func.equals("Ni") || func.equals("Si")) && organising == 0) {
            organising = func.charAt(0);
            organisingEfficiency = i;
        }

        // Tribe
        if((func.equals("Te") || func.equals("Fe")) && tribe == 0) {
            tribe = func.charAt(0);
            tribeEfficiency = i;
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Internal JSON Loading ///////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    static class MBTIJson {
        public String[] func;
        public float giftedToNormalRatio = -1;
        public float maleToFemaleRatio = -1;
        public String[] DnDAlignment;
    }

    void errorCheck(String name, MBTIJson data) {
        try {
            if(data.func == null || data.func.length == 0) throw new RuntimeException("func is null or empty");
            if(data.DnDAlignment == null || data.DnDAlignment.length == 0) throw new RuntimeException("DnDAlignment is null or empty");
            if(data.giftedToNormalRatio == -1) throw new RuntimeException("giftedToNormalRatio is unspecified or invalid");
            if(data.maleToFemaleRatio == -1) throw new RuntimeException("maleToFemaleRatio is unspecified or invalid");
        } catch (RuntimeException e) {
            throw new RuntimeException("There is an error with type: "+name, e);
        }
    }

    MBTIJson loadJson(String name) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("mbti/"+name+".json").getFile());

        Gson gson = new Gson();
        try {
            return gson.fromJson(new FileReader(file), MBTIJson.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
