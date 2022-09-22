package org.mymicroservice.msorder.obj.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mymicroservice.msorder.models.Meal;
import org.mymicroservice.msorder.models.Order;
import org.mymicroservice.msorder.rest.models.MealRest;
import org.mymicroservice.msorder.rest.models.OrderRest;

@Mapper
public interface OrderMapping {

    OrderMapping ORDER_MAPPING = Mappers.getMapper(OrderMapping.class);

    Order toOrder(OrderRest orderRest);

    OrderRest toOrderRest(Order order);

    Meal toMeal(MealRest mealRest);

    MealRest toMealRest(Meal meal);

}
