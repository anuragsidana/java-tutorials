package org.example.visitor;

public class Application {

  public static void main(String[] args) {

    FoodItem foodItem = new FoodItem();
    GroceryItem groceryItem = new GroceryItem();
    ClothItem clothItem = new ClothItem();

    testVisitor(foodItem);
    testVisitor(groceryItem);
    testVisitor(clothItem);
  }

  // This method doesn't know whether this item param is of Cloth, food or Grocery type
  private static void testVisitor(Item item) {
    item.accept(
        new ItemVisitor<Object>() {

          public Object visit(ClothItem clothItem) {
            System.out.println("Cloth visitor executed ");
            return null;
          }

          public Object visit(FoodItem foodItem) {
            System.out.println("Food visitor executed ");
            return null;
          }

          public Object visit(GroceryItem groceryItem) {
            System.out.println("Grocery visitor executed ");
            return null;
          }
        });
  }
}
