package com.example.novi.ncmdb.domain.competitiemanager.utils;

public class DataUtils {
    private final String NONLETTER_REGEX = "\\W";
    private final String NONNUMBER_REGEX = "[^0-9]";
    private final String NUMMER_REGEX = "[0-9]";

    public String extractName(String input) {
        String output = extractData(input);
        output = output.replaceAll(NUMMER_REGEX, "");

        return addNameSpace(output);
    }

    public String addNameSpace(String input) {
        char[] outputArray = input.toCharArray();
        String output = "";

        for (int index = 0; index < outputArray.length ; index++) {
            char sut = outputArray[index];

            if (index != 0 && Character.isUpperCase(sut)){
                output = addSpace(input, index);
            }
        }

        return output;
    }

    public String extractCompetitieId(String input) {
        String output = extractData(input);

        return output.replaceAll(NONNUMBER_REGEX, "");
    }

    public String extractData(String voorspelling) {
        String letterRegex = "postdata";
        String output = voorspelling.replaceAll(letterRegex, "");

        return output.replaceAll(NONLETTER_REGEX, "");

    }

    public String addSpace(String input, int index) {
        char[] space = " ".toCharArray();

        StringBuilder sb = new StringBuilder(input);
        sb.insert(index, space[0]);

        return sb.toString();
    }

}
