package org.example.visitor;

public class FoodItem extends Item {
  boolean isDesert;

  public <T> T accept(ItemVisitor<T> itemVisitor) {
    return itemVisitor.visit(this);
  }
}
