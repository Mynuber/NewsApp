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
}
