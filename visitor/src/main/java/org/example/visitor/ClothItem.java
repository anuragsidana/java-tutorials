package org.example.visitor;

public class ClothItem extends Item {
  Long size;

  public <T> T accept(ItemVisitor<T> itemVisitor) {
    return itemVisitor.visit(this);
  }
}
