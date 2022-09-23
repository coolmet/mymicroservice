package org.mymicroservice.msorder;

import java.util.function.Predicate;

public class ChooseRetryWithResult implements Predicate<String>
{
    @Override
    public boolean test(String e) {
        if (e.contains("mydeneme1") || e.contains("mydeneme2")){
            return true;
        }
        return false;
    }
}
