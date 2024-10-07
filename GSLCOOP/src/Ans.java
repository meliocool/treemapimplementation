import java.util.Scanner;
import java.util.TreeMap;

public class Ans {

	public static void main(String[] args) {
		// Tree Map declaration, with key as String and Value as Integer
		// Just like the product table
		TreeMap<String, Integer> product = new TreeMap<>();
		// The rest is quite similar to past projects like the calculator
		while(true) {
			System.out.println("Welcome! Pick one of these options: ");
			menu();
			System.out.print("Choose from 1 to 5: ");
			Scanner choice = new Scanner(System.in);
			int pick = choice.nextInt();
			if(pick == 6) {
				System.out.println("Bye");
				break;
			}
			switch(pick) {
			case 1:
				boolean contAdd = true;
				while(contAdd) {
					System.out.print("Enter a SKU: ");
					Scanner k = new Scanner(System.in);
					String key = k.next();
					System.out.print("Enter the value to be assigned to that SKU: ");
					Scanner v = new Scanner(System.in);
					int value = v.nextInt();
					product.put(key, value); //adds a new node with the inputted value and key
					int res;
					while(true) {
						System.out.print("Do you want to keep adding? [1/0]: ");
						Scanner res_in = new Scanner(System.in);
						res = res_in.nextInt();
						if(res == 0) {
							contAdd = false; //user wants to stop adding
							break;
						} else if (res == 1) {
							break;
						} else {
							System.out.println("Only 1 or 0 please!");
						}
					}
				}
				break;
			case 2:
				if(product.isEmpty()) {
					System.out.println("The Table is Empty!"); //table is already empty
				} else {
					System.out.println(product);
				}
				break;
			case 3:
				System.out.print("Enter a SKU to be searched: ");
				Scanner s = new Scanner(System.in);
				String query = s.next();
				if(product.containsKey(query)) {
					int result = product.get(query); //find the key and value if it is in the Tree
					System.out.println("The quantity for SKU " + query + " is " + result);
				} else {
					System.out.println("Oops! SKU " + query + " does not exists!");
				}
				break;
			case 4:
				System.out.print("Enter a SKU to be removed: ");
				Scanner s_remove = new Scanner(System.in);
				String sR = s_remove.next();
				if(product.containsKey(sR)) {
					product.remove(sR); //deletes the key and value if its in the tree
					System.out.println("The SKU " + sR + " has been successfully removed");
				} else {
					System.out.println("Oops! SKU " + sR + " does not exists!");
				}
				break;
			case 5:
				product.clear(); //drop or clear the entire table
				System.out.println("You might be fired now");
				break;
			}
		}
	}
	public static void menu() {
		System.out.println("1. Add new product");
		System.out.println("2. Print all product");
		System.out.println("3. Look for product based on SKU");
		System.out.println("4. Remove a product");
		System.out.println("5. Drop the entire table (you're cooked if you choose this)");
		System.out.println("6. I'm out!");
	}

}
