package org.mymicroservice.msorder;

import java.util.function.Predicate;

public class ChooseRetryWithResult implements Predicate<String>
{
    @Override
    public boolean test(String e) {
        if (e.contains("osman1") || e.contains("osman2")){
            return true;
        }
        return false;
    }
}
