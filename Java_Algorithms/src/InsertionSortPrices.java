//class related to the Item class

public class InsertionSortPrices {
	
	public static void main(String[] args) {
				
		Item items[] = {
				new Item("Book", 150),
				new Item("Backpack", 175),
				new Item("Laptop", 2530),
				new Item("Pencil Case", 35),
				new Item("Notebook", 25),
				new Item("Tablet", 1300),
				null,//test
				null
		};
		
		insertionSort(items);//Insertion sort
		
		for(Item item : items) {
			
			if(item != null) {
			
				System.out.println(item.getName() + " -------- " + item.getPrice());
			
			}
			
		}
		
	}
	
	private static void insertionSort(Item[] items) {
		
		for(int currentPrice = 1; currentPrice < items.length && items[currentPrice] != null; currentPrice++) {
		
			int comparedItem = currentPrice;
		
			while(comparedItem > 0 && items[comparedItem].getPrice() < items[comparedItem - 1].getPrice()) {
		
				Item currentItem = items[comparedItem];
				Item lowerPricedItem = items[comparedItem - 1];
				items[comparedItem] = lowerPricedItem;
				items[comparedItem - 1] = currentItem;
			
				comparedItem--;
			
			}
		
		}
		
	}

}
