package org.example.visitor;

public class GroceryItem extends Item {
  Long weight;

  public <T> T accept(ItemVisitor<T> itemVisitor) {
    return itemVisitor.visit(this);
  }
}
