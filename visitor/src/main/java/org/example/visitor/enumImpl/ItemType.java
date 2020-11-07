package org.example.visitor.enumImpl;

public enum ItemType {
    FOOD{
        @Override
        public <T> T accept(ItemTypeVisitor2<T> itemTypeVisitor) {
            return itemTypeVisitor.visitFood();
        }
    },
    GROCERY{
        public <T> T accept(ItemTypeVisitor2<T> itemTypeVisitor) {
            return itemTypeVisitor.visitGrocery();
        }
    },
    CLOTH{
        public <T> T accept(ItemTypeVisitor2<T> itemTypeVisitor) {
            return itemTypeVisitor.visitCloth();
        }
    };

    public abstract <T> T accept(ItemTypeVisitor2<T> itemTypeVisitor);

    public interface ItemTypeVisitor2<T> {
         T visitFood();

         T visitGrocery();

         T visitCloth();

    }
}
