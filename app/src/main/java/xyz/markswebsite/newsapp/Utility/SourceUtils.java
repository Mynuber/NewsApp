package xyz.markswebsite.newsapp.Utility;

import java.util.HashSet;
import java.util.Set;

import xyz.markswebsite.newsapp.models.Source;
import xyz.markswebsite.newsapp.models.SourcesResponse;

/**
 * Created by Mark on 7/10/2017.
 */

public class SourceUtils {

    public static Set<String> getLanguagesAvailable(SourcesResponse sourceResponse) {
        Set<String> temp = new HashSet<>();
        for(Source s : sourceResponse.getSources()){
            temp.add(s.getLanguage());
        }
        return temp;
    }


    public static Set<String> getCategoriesAvailable(SourcesResponse sourceResponse) {
        Set<String> temp = new HashSet<>();
        for(Source s : sourceResponse.getSources()){
            temp.add(s.getCategory());
        }
        return temp;
    }

//    public static Set<String> getCategoriesAvailable(SourcesResponse sourceResponse, String language) {
//        Set<String> temp = new HashSet<>();
//        for(Source s : sourceResponse.getSources()){
//            if (s.getLanguage().equals(language)){
//                temp.add(s.getCategory());
//                break;
//            }
//        }
//        return  temp;
//    }

    public static Set<String> getCategoriesAvailable(SourcesResponse sourceResponse, Set<String> languagesSelected) {
        Set<String> temp = new HashSet<>();

        //if we have no language selected default to all
        if(languagesSelected.isEmpty()){
            return getCategoriesAvailable(sourceResponse);
        }

        //otherwise we will get any sources that match the languages we want
        for(Source s : sourceResponse.getSources()){
            for(String language: languagesSelected){
                if (s.getLanguage().equals(language)){
                    temp.add(s.getCategory());
                    break;
                }
            }
        }
        return temp;
    }
}
