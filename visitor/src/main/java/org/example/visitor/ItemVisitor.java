package org.example.visitor;

public interface ItemVisitor<T> {
  public T visit(ClothItem clothItem);

  public T visit(FoodItem foodItem);

  public T visit(GroceryItem groceryItem);
}
