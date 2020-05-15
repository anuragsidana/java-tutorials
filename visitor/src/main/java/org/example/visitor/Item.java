package org.example.visitor;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "type",
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = ClothItem.class, name = "CLOTH"),
  @JsonSubTypes.Type(value = FoodItem.class, name = "FOOD"),
  @JsonSubTypes.Type(value = GroceryItem.class, name = "GROCERY")
})
public abstract class Item {
  String name;
  String price;
  ItemType type;

  public abstract <T> T accept(ItemVisitor<T> itemVisitor);
}
