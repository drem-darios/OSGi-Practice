package com.drem.osgi.spell.impl.french;

import com.drem.osgi.spell.services.DictionaryService;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;

@Component // This is a POJO component
@Provides // This provides a service
@Instantiate // Instantiate this services when installed
public class FrenchDictionary implements DictionaryService {
    String[] dictionary = {"bienvenue", "au", "osgi", "tutoriel"};

    public boolean checkWord(String word) {
        word = word.toLowerCase();

        for (String w : dictionary) {
            if (w.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
