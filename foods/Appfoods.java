package foods;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import foods.dao.foodDao;
import foods.types.Food;

public class Appfoods {
	
	private Scanner scanner = new Scanner(System.in);
	private foodDao FoodDao = new foodDao();

	public static void main(String[] args) {
		new Appfoods().run();
		
	}
	
	private void run() {
		while (true) {
			printInstruction();
			
			System.out.print("Enter the option: ");
			String option = scanner.nextLine();
			
			if(option.isEmpty()) {
				break;
			}
			
			try {
			switch(option) {
			case "1":
				createFood();
				break;
				
			case "2":
				alterFood();
				break;
			
			case "3":
				listFoods();
				break;
				
			case "4":
				deleteFood();
				break;
				
			default:
				System.out.println("Invalid, try again");
			}
			}
			catch(SQLException e) {
				System.out.println("Warning Error: " + e.getMessage());
				break;
			}
			
			
		}
	}
	private void deleteFood() throws SQLException {
		listFoods();
		System.out.println("Enter the Food Id that you want to delete: ");
		int id = (int) Long.parseLong(scanner.nextLine());
		
		System.out.print("So sad!");
		FoodDao.deleteFood(id);
	}

	private void alterFood() throws SQLException{
		listFoods();
		System.out.println("Enter the Food Id that you want to modify: ");
		int id = (int) Long.parseLong(scanner.nextLine());
		
		System.out.print("Enter the new Food name");
		String name = scanner.nextLine();
		
		FoodDao.alterFood(id, name);
		listFoods();
	}
	
	
	private void listFoods() throws SQLException {
		List<Food> foods = FoodDao.getFoods();
		
		foods.stream().forEach(System.out::println);
		
	}

	private void createFood() throws SQLException {
		System.out.println("Enter Food name: ");
		String name = scanner.nextLine();
		FoodDao.createFood(name);
	}

	
	private void printInstruction() {
		System.out.println("Here is the option");
		System.out.println("1: create a Food");
		System.out.println("2: Modify Food");
		System.out.println("3: Food list");
		System.out.println("4: Delete Food");
	}
}

	





