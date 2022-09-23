package org.mymicroservice.msorder;

import java.util.function.Predicate;

public class ChooseRetryWithException implements Predicate<Throwable>
{
    @Override
    public boolean test(Throwable e) {
        if (e instanceof IllegalArgumentException){
            return false;
        } else if (e instanceof IllegalAccessException){
            return true;
        }
        return false;
    }
}
