package org.example.visitor;

public class Application {

  public static void main(String[] args) {

    FoodItem foodItem = new FoodItem();

    foodItem.accept(
        new ItemVisitor<Object>() {

          public Object visit(ClothItem clothItem) {
            return null;
          }

          public Object visit(FoodItem foodItem) {
            System.out.println("Food visitor executed ");
            return null;
          }

          public Object visit(GroceryItem groceryItem) {
            return null;
          }
        });
  }
}
